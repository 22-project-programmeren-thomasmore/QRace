// Get a random question from the available non-archived questions in the specified group and language
function getRandomQuestion(group, language, questions) {
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
        const randomQuestion = getRandomQuestion(groupParameter, 'nl', questions);
  
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
            const answerElement = document.createElement('p');
            answerElement.textContent = answer;
            answerContainer.appendChild(answerElement);
          }
        }
  
        // Show the question and answers container
        const questionContainer = document.getElementById('questionContainer');
        questionContainer.style.display = 'block';
  
        // Handle the submit answer button click event
        const submitAnswerBtn = document.getElementById('submitAnswerBtn');
        submitAnswerBtn.addEventListener('click', () => {
          const selectedAnswer = document.querySelector('input[name="answer"]:checked').value;
          // TODO: Handle the selected answer
        });
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle error scenario
      });
  }
  
  // Event listener for the custom "exportData" event
  document.addEventListener("exportData", (event) => {
    const groupParameter = event.detail.groupParameter; // Adjust the property name accordingly
    console.log('groupParameter: ', groupParameter);
  
    // Call the function to select a random question and update the UI
    selectRandomQuestion(groupParameter);
  });
  