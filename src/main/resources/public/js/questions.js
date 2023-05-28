const MAX_ATTEMPTS = 5;
const FIRST_ATTEMPT_SCORE_CORRECT = 10;
const FIRST_ATTEMPT_SCORE_INCORRECT = -5;
const SECOND_ATTEMPT_SCORE_CORRECT = 5;
const SECOND_ATTEMPT_SCORE_INCORRECT = -10;

const trackProgressKey = 'track progress';

// Initialize local storage
if (!localStorage.getItem(trackProgressKey)) {
  localStorage.setItem(trackProgressKey, JSON.stringify({ score: 0, groups: {} }));
}

document.addEventListener("exportData", (event) => {
  const groupParameter = event.detail;
  selectRandomQuestion(groupParameter);
});

function selectRandomQuestion(groupParameter) {
  fetch('/api/questions')
    .then(response => response.ok ? response.json() : Promise.reject("Failed to fetch questions"))
    .then(questions => getFilteredQuestions(questions, groupParameter))
    .then(filteredQuestions => {
      const randomQuestion = getRandomQuestion(filteredQuestions);
      if (!randomQuestion) {
        console.error("No questions available for the selected group and language");
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

  console.log("Before filtering: ", questions);
  console.log("Group Parameter: ", groupParameter);
  console.log("Language: ", language);
  console.log("Track Progress: ", trackProgress);

  const filteredQuestions = questions.filter(question =>
    question.groupParameter === groupParameter &&
    question.language === language &&
    !question.archived &&
    (!(trackProgress.groups[groupParameter]?.answeredQuestions?.[question.id]) && trackProgress.groups[groupParameter]?.attempts < MAX_ATTEMPTS)
  );
  console.log("After filtering: ", filteredQuestions);

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
  openScannerBtn.style.visibility = 'hidden';
  questionContainer.style.display = 'block';
}

function handleAnswerClick(selectedAnswer, question) {
  const selectedCard = document.getElementById(selectedAnswer);
  const answerCards = Array.from(document.getElementsByClassName('answer-card'));

  const trackProgress = JSON.parse(localStorage.getItem(trackProgressKey));
  const currentScore = Number(localStorage.getItem(trackProgressKey.score));
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

  localStorage.setItem(trackProgressKey, JSON.stringify(trackProgress));

  answerCards.forEach(card => card.style.display = 'none');
  document.getElementById('questionContainer').style.display = 'none';
  document.getElementById('openScannerBtn').style.visibility = 'visible';
}

function updateTrackProgress(question) {
  console.log('question', question)
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
      correct: null,
    };
  }
  localStorage.setItem(trackProgressKey, JSON.stringify(trackProgress));

  // if (trackProgress.groups[question.groupParameter.group].attempts < MAX_ATTEMPTS) {
  //   selectRandomQuestion(question.groupParameter);
  // }
}

function getLanguageFromCookies() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)language\s*\=\s*([^;]*).*$)|^.*$/, "$1");
}