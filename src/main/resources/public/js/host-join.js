const translations = {
  en: {
    title: "Race your rivals",
    hostLabel: "host",
    joinLabel: "host",
    tooltip: "Enter your username here.",
  },
  fr: {
    title: "Race your rivals",
    hostLabel: "host",
    joinLabel: "host",
    tooltip: "Enter your username here.",
  },
  nl: {
    title: "Race your rivals",
    hostLabel: "host",
    joinLabel: "host",
    tooltip: "Enter your username here.",
  },
};

// Wait for the DOM to load
document.addEventListener("DOMContentLoaded", function () {
  // Get references to the help button and popup
  var helpBtn = document.querySelector(".help-btn");
  var helpPopup = document.querySelector(".help-popup");
  // Add a click event handler to the help button
  helpBtn.addEventListener("click", function () {
    // Toggle the popup's display between block and none
    helpPopup.style.display =
      helpPopup.style.display === "block" ? "none" : "block";
  });
  // Get references to the language button and all the elements that need updating
  var languageBtn = document.querySelector(".language-btn");
  var pageTitle = document.querySelector("title");
  var hostLabel = document.querySelector('label[for="name"]');
  var joinLabel = document.querySelector('label[for="name"]');
  var helpPopupText = document.querySelector(".help-popup p");
  // Add a click event handler to the language button
  languageBtn.addEventListener("click", function () {
    // Get the current language
    var currentLang = languageBtn.getAttribute("data-lang");
    var newLang;
    // Determine the new language based on the current
    if (currentLang === "en") {
      newLang = "fr";
    } else if (currentLang === "fr") {
      newLang = "nl";
    } else {
      newLang = "en";
    }
    // Update the language button's data attribute
    languageBtn.setAttribute("data-lang", newLang);
    // Update the text on the page
    updateLanguage(newLang);
  });
  // Function to update the text on the page
  function updateLanguage(lang) {
    pageTitle.textContent = translations[lang].title;
    hostLabel.textContent = translations[lang].hostLabel;
    joinLabel.textContent = translations[lang].joinLabel;
    helpPopupText.textContent = translations[lang].tooltip;
  }
});

