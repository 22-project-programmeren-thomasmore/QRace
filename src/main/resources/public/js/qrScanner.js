// get the video element from the DOM
const video = document.getElementById("qr-video");
// get the video container element from the DOM
const videoContainer = document.getElementById("video-container");
// get the button that opens the scanner
const openScannerBtn = document.getElementById("openScannerBtn");
// get the button that closes the scanner
const closeScannerBtn = document.getElementById("closeScannerBtn");
// get the scanner container element from the DOM
const scannerContainer = document.getElementById("scannerContainer");
// get the element that displays the scan result
const scanResult = document.getElementById("scanResult");
// get the element that displays the question
const questionTextElement = document.getElementById("questionText");
// get the element that contains the answer options
const answerOptionsContainer = document.getElementById("answerOptions");

let currentQuestion;

// create a new scanner
const scanner = new QrScanner(
  video,
  (result) => setResult(scanResult, result),
  { returnDetailedScanResult: true }
);

// add event listener for the open scanner button
openScannerBtn.addEventListener("click", () => {
  // start the scanner
  scanner.start();
  // display the scanner container
  scannerContainer.style.display = "block";
});

// add event listener for the close scanner button
closeScannerBtn.addEventListener("click", () => {
  // stop the scanner
  scanner.stop();
  // hide the scanner container
  scannerContainer.style.display = "none";
});

// for debugging
window.scanner = scanner;

function setResult(label, result) {
  // set the scan result text
  scanResult.textContent = result.data;
  // set the text color
  label.style.color = "teal";
  // clear the highlight timeout
  clearTimeout(label.highlightTimeout);
  // set the highlight timeout
  label.highlightTimeout = setTimeout(
    () => (label.style.color = "inherit"),
    100
  );

  // Fetch the question from the backend
  fetch(`/api/questions/group/${result.data}`)
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Failed to fetch question");
      }
    })
    .then((question) => {
      // Display the question to the user
      currentQuestion = question;
      displayQuestion(question);
    })
    .catch((error) => {
      console.error("Error:", error);
      // Handle error scenario
    });
}

function displayQuestion(question) {
  // Update the DOM to display the question and answer options
  questionTextElement.textContent = question.questionText;

  // Clear the previous answer options
  answerOptionsContainer.innerHTML = "";

  // Iterate over the answer options and create HTML elements for each option
  question.answerOptions.forEach((answerOption, index) => {
    // Create a label element
    const label = document.createElement("label");

    // Create a radio button for the answer option
    const radio = document.createElement("input");
    radio.type = "radio";
    radio.name = "answerOptions";
    radio.value = answerOption;
    radio.id = `answer${index + 1}`;

    // Create a span element to display the answer option text
    const span = document.createElement("span");
    span.textContent = answerOption;

    // Append the radio button and span to the label
    label.appendChild(radio);
    label.appendChild(span);

    // Append the label to the answer options container
    answerOptionsContainer.appendChild(label);
  });

  // Add event listener for answer submission
  answerOptionsContainer.addEventListener("change", handleAnswerSubmission);
}

function handleAnswerSubmission(event) {
  // Get the selected answer option
  const selectedOption = event.target.value;

  // Compare the selected answer with the correct answer
  if (selectedOption === currentQuestion.correctAnswer) {
    // Increment the score for correct answer
    score += 10;
    event.target.parentElement.classList.add("correct");
  } else {
    // Decrement the score for wrong answer on the first try
    if (questionCount === 0) {
      score -= 5;
    }
    event.target.parentElement.classList.add("incorrect");
  }

  // Remove the event listener to prevent multiple submissions
  answerOptionsContainer.removeEventListener("change", handleAnswerSubmission);

  // Update the question count
  questionCount++;

  // Check if the maximum number of questions has been reached
  if (
    questionCount === maxQuestions ||
    selectedOption === currentQuestion.correctAnswer
  ) {
    // Display score and prompt for scanning a new QR code
    displayScore();
    promptForNewQRCode();
  } else {
    // Display the next question after a delay
    setTimeout(() => {
      displayNextQuestion();
    }, 2000);
  }
}

function promptForNewQRCode() {
  // Hide the answer options container
  answerOptionsContainer.style.display = "none";

  // Show the button to open the scanner
  openScannerBtn.style.display = "block";
}

function displayNextQuestion() {
  // Show the answer options container
  answerOptionsContainer.style.display = "block";

  // Hide the button to open the scanner
  openScannerBtn.style.display = "none";

  // Clear the current question
  currentQuestion = null;
}
