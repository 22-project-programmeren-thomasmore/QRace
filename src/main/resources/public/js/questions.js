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
    console.log(questions);
    // Process the questions and update the UI
    displayQuestions(questions);
  })
  .catch((error) => {
    console.error("Error:", error);
    // Handle error scenario
  });



function displayQuestions(questions) {
  // Clear the previous questions
  questionContainer.innerHTML = "";

  // Loop through the questions and create HTML elements to display them
  questions.forEach((question) => {
    // Create a container for the question
    const questionElement = document.createElement("div");
    questionElement.classList.add("question");

    // Create elements for the question text, answer options, and correct answer
    const questionTextElement = document.createElement("p");
    questionTextElement.textContent = question.questionText;

    const answerOptionsElement = document.createElement("ul");
    question.answerOptions.forEach((answerOption) => {
      const li = document.createElement("li");
      li.textContent = answerOption;
      answerOptionsElement.appendChild(li);
    });

    const correctAnswerElement = document.createElement("p");
    correctAnswerElement.textContent = question.correctAnswer;

    // Append the elements to the question container
    questionElement.appendChild(questionTextElement);
    questionElement.appendChild(answerOptionsElement);
    questionElement.appendChild(correctAnswerElement);

    // Append the question container to the main container
    questionContainer.appendChild(questionElement);
  });
}
