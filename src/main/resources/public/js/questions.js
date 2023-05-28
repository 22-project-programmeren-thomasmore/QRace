const MAX_ATTEMPTS = 10;
const FIRST_ATTEMPT_SCORE_CORRECT = 10;
const FIRST_ATTEMPT_SCORE_INCORRECT = -5;
const SECOND_ATTEMPT_SCORE_CORRECT = 5;
const SECOND_ATTEMPT_SCORE_INCORRECT = -10;

const answeredQuestionsKey = 'answered Questions';
const scoreKey = 'points';

// Initialize local storage
if (!localStorage.getItem(answeredQuestionsKey)) {
  localStorage.setItem(answeredQuestionsKey, JSON.stringify({}));
}

if (!localStorage.getItem(scoreKey)) {
  localStorage.setItem(scoreKey, 0);
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
      updateAnsweredQuestions();

      if (answeredQuestionsKey[questionId].attempts < MAX_ATTEMPTS) {
        selectRandomQuestion(groupParameter);
      }
    })
    .catch(console.error);
}

function getFilteredQuestions(questions, groupParameter) {
  const answeredQuestions = JSON.parse(localStorage.getItem(answeredQuestionsKey));
  const language = getLanguageFromCookies();

  return questions.filter(question =>
    question.groupParameter === groupParameter &&
    question.language === language &&
    !question.archived &&
    (!answeredQuestions[question.id] || answeredQuestions[question.id].attempts < MAX_ATTEMPTS)
  );
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
    answerCard.addEventListener('click', () => handleAnswerClick(key, question.id, question.correctAnswer));
    answerContainer.appendChild(answerCard);
  }
  openScannerBtn.style.visibility = 'hidden';
  questionContainer.style.display = 'block';
}

function handleAnswerClick(selectedAnswer, questionId, correctAnswer) {
  const selectedCard = document.getElementById(selectedAnswer);
  const answerCards = Array.from(document.getElementsByClassName('answer-card'));

  const answeredQuestions = JSON.parse(localStorage.getItem(answeredQuestionsKey));
  const currentScore = Number(localStorage.getItem(scoreKey));
  const isCorrectAnswer = selectedCard.textContent === correctAnswer;
  if (isCorrectAnswer) {
    selectedCard.classList.add('correct');
    answeredQuestions[questionId].attempts += 2; 
    answeredQuestions[questionId].correct = true; 
    localStorage.setItem(scoreKey, currentScore + (answeredQuestions[questionId].attempts >= 2 ? SECOND_ATTEMPT_SCORE_CORRECT : FIRST_ATTEMPT_SCORE_CORRECT));
  } else {
    selectedCard.classList.add('incorrect');
    answeredQuestions[questionId].attempts++; 
    answeredQuestions[questionId].correct = false; 
    localStorage.setItem(scoreKey, currentScore + (answeredQuestions[questionId].attempts >= 2 ? SECOND_ATTEMPT_SCORE_INCORRECT : FIRST_ATTEMPT_SCORE_INCORRECT));
    }
  localStorage.setItem(answeredQuestionsKey, JSON.stringify(answeredQuestions));

  answerCards.forEach(card => card.style.display = 'none');
  document.getElementById('questionContainer').style.display = 'none';
  document.getElementById('openScannerBtn').style.visibility = 'visible';
}

function updateAnsweredQuestions() {
}

function getLanguageFromCookies() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)language\s*\=\s*([^;]*).*$)|^.*$/, "$1");
}