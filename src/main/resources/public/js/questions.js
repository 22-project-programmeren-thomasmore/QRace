const MAX_ATTEMPTS = 2;
const FIRST_ATTEMPT_SCORE_CORRECT = 10;
const FIRST_ATTEMPT_SCORE_INCORRECT = -5;
const SECOND_ATTEMPT_SCORE_CORRECT = 5;
const SECOND_ATTEMPT_SCORE_INCORRECT = -5;

const answeredQuestionsKey = 'answeredQuestions';
const scoreKey = 'score';

initializeLocalStorage();

document.addEventListener("exportData", (event) => {
  const groupParameter = event.detail;
  selectRandomQuestion(groupParameter);
});

function initializeLocalStorage() {
  if (!localStorage.getItem(answeredQuestionsKey)) {
    localStorage.setItem(answeredQuestionsKey, JSON.stringify({}));
  }
  if (!localStorage.getItem(scoreKey)) {
    localStorage.setItem(scoreKey, 0);
  }
}

function selectRandomQuestion(groupParameter) {
  fetch('/api/questions')
    .then(response => {
      if (!response.ok) {
        return Promise.reject(`Failed to fetch questions. Status: ${response.status}`);
      }
      return response.json();
    })
    .then(questions => getFilteredQuestions(questions, groupParameter))
    .then(filteredQuestions => {
      const randomQuestion = getRandomQuestion(filteredQuestions);
      if (!randomQuestion) {
        console.error("No questions available for the selected group and language");
        return;
      }
      displayQuestion(randomQuestion);
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
    (!answeredQuestions[question.id] || answeredQuestions[question.id].group !== groupParameter || answeredQuestions[question.id].attempts < MAX_ATTEMPTS)
  );
}

function getRandomQuestion(questions) {
  return questions[Math.floor(Math.random() * questions.length)];
}

let correctAnswerGlobal = ""; // global variable to keep track of correct answer

function displayQuestion(question) {
  const questionContainer = document.getElementById('questionContainer');
  const questionTextElement = document.getElementById('questionText');
  const answerContainer = document.getElementById('answerContainer');

  questionTextElement.textContent = question.questionText;

  correctAnswerGlobal = question.correctAnswer; // update global variable with correct answer

  answerContainer.innerHTML = '';
  const answerKeys = ['answer1', 'answer2', 'answer3', 'answer4'];
  for (const key of answerKeys) {
    if (question[key]) {
      const answerCard = document.createElement('div');
      answerCard.id = key;
      answerCard.className = 'answer-card';
      answerCard.textContent = question[key];
      answerCard.addEventListener('click', () => handleAnswerClick(answerCard.textContent, question.id, question.groupParameter));
      answerContainer.appendChild(answerCard);
    }
  }
  openScannerBtn.style.visibility = 'hidden';
  questionContainer.style.display = 'block';
}

function handleAnswerClick(selectedAnswer, questionId, groupParameter) {
  const selectedCard = document.getElementById(selectedAnswer);
  const answerCards = Array.from(document.getElementsByClassName('answer-card'));

  const answeredQuestions = JSON.parse(localStorage.getItem(answeredQuestionsKey));
  const currentScore = Number(localStorage.getItem(scoreKey));
  const isCorrectAnswer = selectedAnswer === correctAnswerGlobal; // use global variable for comparison

  if (!answeredQuestions[questionId]) {
    answeredQuestions[questionId] = {
      attempts: 0,
      group: groupParameter,
      correct: false
    };
  }

  if (isCorrectAnswer) {
    selectedCard.classList.add('correct');
    answeredQuestions[questionId].attempts = MAX_ATTEMPTS;
    answeredQuestions[questionId].correct = true;
    localStorage.setItem(scoreKey, currentScore + (answeredQuestions[questionId].attempts === 1 ? FIRST_ATTEMPT_SCORE_CORRECT : SECOND_ATTEMPT_SCORE_CORRECT));
  } else {
    selectedCard.classList.add('incorrect');
    answeredQuestions[questionId].attempts++;
    answeredQuestions[questionId].correct = false;
    localStorage.setItem(scoreKey, currentScore + (answeredQuestions[questionId].attempts === 1 ? FIRST_ATTEMPT_SCORE_INCORRECT : SECOND_ATTEMPT_SCORE_INCORRECT));
  }

  localStorage.setItem(answeredQuestionsKey, JSON.stringify(answeredQuestions));

  answerCards.forEach(card => card.style.display = 'none');
  document.getElementById('questionContainer').style.display = 'none';
  document.getElementById('openScannerBtn').style.visibility = 'visible';
}

function getLanguageFromCookies() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)language\s*\=\s*([^;]*).*$)|^.*$/, "$1");
}
