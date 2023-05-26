
function populateTable(questions) {
  var tbody = document
    .getElementById("questions")
    .getElementsByTagName("tbody")[0];
  questions.forEach(function (question) {
    var row = createQuestionRow(question);
    tbody.appendChild(row);
  });
}

function clearTable() {
  var tbody = document
    .getElementById("questions")
    .getElementsByTagName("tbody")[0];
  while (tbody.firstChild) {
    tbody.removeChild(tbody.firstChild);
  }
}

function createQuestionRow(question) {
  // Create the row and cells for the question properties
  var row = document.createElement("tr");
  [
    "questionText",
    "correctAnswer",
    "answer1",
    "answer2",
    "answer3",
    "answer4",
    "groupParameter",
    "language",
  ].forEach(function (property) {
    var cell = document.createElement("td");
    cell.textContent = question[property];
    row.appendChild(cell);
  });

  // Create the cell for the "Archived" property
  var archivedCell = document.createElement("td");
  archivedCell.textContent = question.archived ? "Yes" : "No";
  row.appendChild(archivedCell);

  // Create the "Archive" button and add event listener
  var archiveButton = document.createElement("button");
  archiveButton.textContent = question.archived ? "Unarchive" : "Archive";
  archiveButton.addEventListener("click", function () {
    // Toggle the archived field of the question
    question.archived = !question.archived;

    // Send a PUT request to update the question
    fetch("/api/questions/" + question.id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(question),
    })
      .then(function (response) {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to update question");
        }
      })
      .then(function (updatedQuestion) {
        console.log("Updated question:", updatedQuestion);
        document.getElementById("feedback").textContent =
          question.archived
            ? "Question archived successfully!"
            : "Question unarchived successfully!";
        document.getElementById("feedback").style.color = "green";

        // Update the "Archived" cell and the "Archive" button
        archivedCell.textContent = question.archived ? "Yes" : "No";
        archiveButton.textContent = question.archived
          ? "Unarchive"
          : "Archive";
      })
      .catch(function (error) {
        console.error("Error:", error);
        document.getElementById("feedback").textContent =
          "Failed to update question. Please try again.";
        document.getElementById("feedback").style.color = "red";
      });
  });
  row.appendChild(archiveButton);

  // Create the "Edit" button and add event listener
  var editCell = document.createElement("td");
  var editButton = document.createElement("button");
  editButton.textContent = "Edit";
  editButton.addEventListener("click", function () {
    // Set questionId to the ID of the question
    questionId = question.id;

    // Populate the edit form with the data of the question
    document.getElementById("edit-question-text").value = question.questionText;
    document.getElementById("edit-correct-answer").value = question.correctAnswer;
    document.getElementById("edit-answer1").value = question.answer1;
    document.getElementById("edit-answer2").value = question.answer2;
    document.getElementById("edit-answer3").value = question.answer3;
    document.getElementById("edit-answer4").value = question.answer4;
    document.getElementById("edit-group-parameter").value =
      question.groupParameter;
    document.getElementById("edit-language").value = question.language;

    // Show the edit form
    document.getElementById("edit-form").style.display = "block";
  });
  editCell.appendChild(editButton);
  row.appendChild(editCell);

  return row;
}
document
  .getElementById("sort-select")
  .addEventListener("change", function () {
    var sortBy = this.value;
    // Clear the table
    clearTable();
    // Fetch the questions from the server with the selected sorting criteria
    fetch("/api/questions?sortBy=" + sortBy)
      .then(function (response) {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to fetch questions");
        }
      })
      .then(function (questions) {
        // Populate the table with the sorted questions
        populateTable(questions);
      })
      .catch(function (error) {
        console.error("Error:", error);
      });
  });
document
  .getElementById("question-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    var question = {
      questionText: document.getElementById("question-text").value,
      correctAnswer: document.getElementById(
        "answer" + document.getElementById("correct-answer").value
      ).value,
      answer1: document.getElementById("answer1").value,
      answer2: document.getElementById("answer2").value,
      answer3: document.getElementById("answer3").value,
      answer4: document.getElementById("answer4").value,
      groupParameter: document.getElementById("group-parameter").value,
      language: document.getElementById("language").value,
    };

    fetch("/api/questions", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(question),
    })
      .then(function (response) {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to create question");
        }
      })
      .then(function (createdQuestion) {
        console.log("Created question:", createdQuestion);
        document.getElementById("feedback").textContent =
          "Question created successfully!";
        document.getElementById("feedback").style.color = "green";
        clearTable();
        fetchQuestionsAndPopulateTable();
      })
      .catch(function (error) {
        console.error("Error:", error);
        document.getElementById("feedback").textContent =
          "Failed to create question. Please try again.";
        document.getElementById("feedback").style.color = "red";
      });
  });
// Event listener for edit form submission
document
  .getElementById("edit-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    var question = {
      questionText: document.getElementById("edit-question-text").value,
      correctAnswer: document.getElementById(
        "edit-answer" +
        document.getElementById("edit-correct-answer").value
      ).value,
      answer1: document.getElementById("edit-answer1").value,
      answer2: document.getElementById("edit-answer2").value,
      answer3: document.getElementById("edit-answer3").value,
      answer4: document.getElementById("edit-answer4").value,
      groupParameter: document.getElementById("edit-group-parameter")
        .value,
      language: document.getElementById("edit-language").value,
    };
    fetch("/api/questions/" + questionId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(question),
    })
      .then(function (response) {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to update question");
        }
      })
      .then(function (updatedQuestion) {
        console.log("Updated question:", updatedQuestion);
        document.getElementById("feedback").textContent =
          "Question updated successfully!";
        document.getElementById("feedback").style.color = "green";
        clearTable();
        fetchQuestionsAndPopulateTable();
        document.getElementById("edit-form").style.display = "none";
      })
      .catch(function (error) {
        console.error("Error:", error);
        document.getElementById("feedback").textContent =
          "Failed to update question. Please try again.";
        document.getElementById("feedback").style.color = "red";
      });
  });
function fetchQuestionsAndPopulateTable(sortBy = "") {
  fetch("/api/questions?sortBy=" + sortBy)
    .then(function (response) {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Failed to fetch questions");
      }
    })
    .then(function (questions) {
      clearTable();
      populateTable(questions);
    })
    .catch(function (error) {
      console.error("Error:", error);
    });
}
document
  .getElementById("sort-select")
  .addEventListener("change", function () {
    var sortBy = this.value;
    fetchQuestionsAndPopulateTable(sortBy);
  });
// Initial fetch and populate table
fetchQuestionsAndPopulateTable();