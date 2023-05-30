const endRace = 'stop';

const MAX_ATTEMPTS = 2;
const FIRST_ATTEMPT_SCORE_CORRECT = 10;
const FIRST_ATTEMPT_SCORE_INCORRECT = -5;
const SECOND_ATTEMPT_SCORE_CORRECT = 5;
const SECOND_ATTEMPT_SCORE_INCORRECT = -10;

const trackProgressKey = 'track progress';

let questionNumber = 0;

// Initialize local storage
if (!localStorage.getItem(trackProgressKey)) {
  localStorage.setItem(trackProgressKey, JSON.stringify({ score: 0, groups: {} }));
}

document.addEventListener("exportData", (event) => {
  const groupParameter = event.detail;
  if (groupParameter === endRace) {

    window.location.href = "/scoreboard";
    return;
  } else {
    selectRandomQuestion(groupParameter);
  }
});

function selectRandomQuestion(groupParameter) {
  fetch('/api/questions')
    .then(response => response.ok ? response.json() : Promise.reject("Failed to fetch questions"))
    .then(questions => getFilteredQuestions(questions, groupParameter))
    .then(filteredQuestions => {
      const randomQuestion = getRandomQuestion(filteredQuestions);
      if (!randomQuestion) {
        console.error("No questions available for the selected group and language");
        alert(" je hebt alle vragen voor deze groep beantwoord. \n Zoek een andere qr code aub. \n \n You have answered all questions for this group. \n Please find another qr code. \n \n Tu as répondu à toutes les questions de ce groupe. \n Veuillez trouver un autre code QR.");
        openScannerBtn.style.display = 'block';
        return;
      }
      displayQuestion(randomQuestion);
      updateTrackProgress(randomQuestion);
    })
    .catch(console.error);
}

function getFilteredQuestions(questions, groupParameter) {
  const trackProgress = JSON.parse(localStorage.getItem(trackProgressKey));
  const language = getLanguageFromCookies();
  const filteredQuestions = questions.filter(question =>
    question.groupParameter === groupParameter &&
    question.language === language &&
    !question.archived &&
    (!trackProgress.groups[groupParameter] ||
      (!trackProgress.groups[groupParameter]?.answeredQuestions?.[question.id] &&
        trackProgress.groups[groupParameter]?.attempts < MAX_ATTEMPTS)));
  return filteredQuestions;
}

function getRandomQuestion(questions) {
  return questions[Math.floor(Math.random() * questions.length)];
}

function displayQuestion(question) {
  const questionContainer = document.getElementById('questionContainer');
  const questionTextElement = document.getElementById('questionText');
  const answerContainer = document.getElementById('answerContainer');

  questionTextElement.textContent = question.questionText;

  // Record time when a question is displayed
  let currentTime = getCurrentStopwatchTime();
  updateTrackProgress(question, currentTime);

  answerContainer.innerHTML = '';
  const answerKeys = ['answer1', 'answer2', 'answer3', 'answer4'];
  for (const key of answerKeys) {
    if (!question[key]) continue;

    const answerCard = document.createElement('div');
    answerCard.id = key;
    answerCard.className = 'answer-card';
    answerCard.textContent = question[key];
    answerCard.addEventListener('click', () => handleAnswerClick(key, question));
    answerContainer.appendChild(answerCard);
  }
  openScannerBtn.style.display = 'none';
  questionContainer.style.display = 'block';
}

function handleAnswerClick(selectedAnswer, question) {
  const selectedCard = document.getElementById(selectedAnswer);
  const answerCards = Array.from(document.getElementsByClassName('answer-card'));

  const trackProgress = JSON.parse(localStorage.getItem(trackProgressKey));
  const isCorrectAnswer = selectedCard.textContent === question.correctAnswer;
  if (isCorrectAnswer) {
    selectedCard.classList.add('correct');
    trackProgress.groups[question.groupParameter].attempts += 2;
    trackProgress.groups[question.groupParameter].answeredQuestions[question.id].correct = true;
    trackProgress.score += trackProgress.groups[question.groupParameter].attempts >= 2 ? SECOND_ATTEMPT_SCORE_CORRECT : FIRST_ATTEMPT_SCORE_CORRECT;
  } else {
    selectedCard.classList.add('incorrect');
    trackProgress.groups[question.groupParameter].attempts++;
    trackProgress.groups[question.groupParameter].answeredQuestions[question.id].correct = false;
    trackProgress.score += trackProgress.groups[question.groupParameter].attempts >= 2 ? SECOND_ATTEMPT_SCORE_INCORRECT : FIRST_ATTEMPT_SCORE_INCORRECT;
  }
  // Increment question number and display the result
  questionNumber++;
  displayQuestionResult(questionNumber, isCorrectAnswer, getCurrentStopwatchTime());

  localStorage.setItem(trackProgressKey, JSON.stringify(trackProgress));
  document.getElementById('score').textContent = " " + trackProgress.score;

  answerCards.forEach(card => card.style.display = 'none');
  document.getElementById('questionContainer').style.display = 'none';
  document.getElementById('openScannerBtn').style.display = 'block';

  giveNewChance(question);
}

function displayQuestionResult(questionNumber, isCorrect, timeString) {
  const resultItem = document.createElement("li");
  resultItem.textContent = `${questionNumber}. ${isCorrect ? 'Correct' : 'Incorrect'} - ${timeString}`;
  document.getElementById("timeList").appendChild(resultItem);
}

function updateTrackProgress(question, currentTime) {
  if (!question || question.id === undefined || !question.groupParameter) {
    console.error("Invalid object:", question);
    return;
  }
  const trackProgress = JSON.parse(localStorage.getItem(trackProgressKey));

  if (!trackProgress.groups[question.groupParameter]) {
    trackProgress.groups[question.groupParameter] = {
      attempts: 0,
      answeredQuestions: {}
    };
  }

  if (!trackProgress.groups[question.groupParameter].answeredQuestions[question.id]) {
    trackProgress.groups[question.groupParameter].answeredQuestions[question.id] = {
      recordTime: currentTime,
      correct: null
    };
  }
  localStorage.setItem(trackProgressKey, JSON.stringify(trackProgress));
}

function giveNewChance(question) {
  const trackProgress = JSON.parse(localStorage.getItem(trackProgressKey));
  console.log('attempts', trackProgress.groups[question.groupParameter]?.attempts)
  console.log('answer correct', trackProgress.groups[question.groupParameter]?.answeredQuestions[question.id]?.correct)

  if (trackProgress.groups[question.groupParameter]?.attempts < MAX_ATTEMPTS && trackProgress.groups[question.groupParameter].answeredQuestions[question.id].correct === false) {
    selectRandomQuestion(question.groupParameter);
  }
}

function getLanguageFromCookies() {
  let name = "language=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  console.error("No language cookie found! cookies: ", ca);
  return "";
}