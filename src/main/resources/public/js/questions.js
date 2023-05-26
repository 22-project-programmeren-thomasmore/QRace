// Get a random question from the available non-archived questions in the specified group and language
function getRandomQuestion(group, questions) {
  // Get the language from the cookies
  const language = document.cookie.replace(/(?:(?:^|.*;\s*)language\s*\=\s*([^;]*).*$)|^.*$/, "$1");
  // console.log('language: ', language);
  // Filter the questions based on the group, archived status, and language
  const filteredQuestions = questions.filter(
    (question) =>
      question.groupParameter === group &&
      !question.archived &&
      question.language === language
  );

  // Select a random question from the filtered questions
  const randomIndex = Math.floor(Math.random() * filteredQuestions.length);
  return filteredQuestions[randomIndex];
}


// Function to handle question selection and UI update
function selectRandomQuestion(groupParameter) {
  // Fetch all questions from the server
  fetch('/api/questions')
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Failed to fetch questions");
      }
    })
    .then((questions) => {
      // Get a random question from the available non-archived questions in the specified group and language
      const randomQuestion = getRandomQuestion(groupParameter, questions);

      // Display the question on the page
      const questionTextElement = document.getElementById('questionText');
      questionTextElement.textContent = randomQuestion.questionText;

      // Display the answers on the page
      const answerContainer = document.getElementById('answerContainer');
      answerContainer.innerHTML = ''; // Clear previous answers

      // Loop through the answers and add them to the answer container
      const answerKeys = ['answer1', 'answer2', 'answer3', 'answer4'];
      for (const key of answerKeys) {
        const answer = randomQuestion[key];
        if (answer) {
          const answerCard = document.createElement('div');
          answerCard.id = key;
          answerCard.className = 'answer-card';
          answerCard.textContent = answer;
          answerCard.dataset.correctAnswer = randomQuestion.correctAnswer;
          answerCard.addEventListener('click', () => {
            handleAnswerClick(key);
          });
          answerContainer.appendChild(answerCard);
        }
      }

      // Show the question and answers container
      const questionContainer = document.getElementById('questionContainer');
      questionContainer.style.display = 'block';
    })
    .catch((error) => {
      console.error("Error:", error);
      // Handle error scenario
    });
}

// Handle the answer click event
function handleAnswerClick(selectedAnswer) {
  const selectedCard = document.getElementById(selectedAnswer);
  const answerCards = document.getElementsByClassName('answer-card');
  const correctAnswer = selectedCard.dataset.correctAnswer;

  // Add CSS classes to indicate selected answer and correctness
  selectedCard.classList.add('selected');
  if (selectedCard.textContent === correctAnswer) {
    selectedCard.classList.add('correct');
    console.log("Correct answer selected"); // Log to console
  } else {
    selectedCard.classList.add('incorrect');
    console.log("Incorrect answer selected"); // Log to console
  }

  // Hide all answer cards
  for (const card of answerCards) {
    card.style.display = 'none';
  }

  // Hide the question container
  const questionContainer = document.getElementById('questionContainer');
  questionContainer.style.display = 'none';

}


// Event listener for the custom "exportData" event
document.addEventListener("exportData", (event) => {
  const groupParameter = event.detail.groupParameter; // Adjust the property name accordingly
  // console.log('groupParameter: ', groupParameter);

  // Call the function to select a random question and update the UI
  selectRandomQuestion(groupParameter);
});
