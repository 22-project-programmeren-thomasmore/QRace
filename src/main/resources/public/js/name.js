// Object met vertalingen voor verschillende talen
const translations = {
  en: {
    title: "Enter Name",
    tooltip: "Enter your username here.",
    nextLabel: "next",
  },
  fr: {
    title: "Entrez le nom",
    tooltip: "Entrez votre nom d'utilisateur ici.",
    nextLabel: "prochaine",
  },
  nl: {
    title: "Naam invoeren",
    tooltip: "Vul hier je gebruikersnaam in.",
    nextLabel: "volgende",
  },
};

// Voeg een event listener toe die wordt uitgevoerd wanneer de pagina is geladen
document.addEventListener("DOMContentLoaded", function () {
  // Selecteer elementen uit de DOM
  var helpBtn = document.querySelector(".help-btn");
  var helpPopup = document.querySelector(".help-popup");

  // Voeg een click event listener toe aan de help-knop
  helpBtn.addEventListener("click", function () {
    // Schakel de weergave van de help-popup in/uit
    helpPopup.style.display =
      helpPopup.style.display === "block" ? "none" : "block";
  });

  // Selecteer elementen uit de DOM
  var languageBtn = document.querySelector(".language-btn");
  var pageTitle = document.querySelector("h1");
  var btnLabel = document.querySelector('button[for="next"]');
  var helpPopupText = document.querySelector(".help-popup p");

  // Voeg een click event listener toe aan de taalknop
  languageBtn.addEventListener("click", function () {
    // Haal de huidige taal op uit het data-lang attribuut
    var currentLang = languageBtn.getAttribute("data-lang");
    var newLang;

    // Bepaal de nieuwe taal op basis van de huidige taal
    if (currentLang === "en") {
      newLang = "fr";
    } else if (currentLang === "fr") {
      newLang = "nl";
    } else {
      newLang = "en";
    }

    // Wijzig het data-lang attribuut naar de nieuwe taal
    languageBtn.setAttribute("data-lang", newLang);
    // Update de tekst op basis van de nieuwe taal
    updateLanguage(newLang);
  });

  // Functie om de tekst op de pagina bij te werken op basis van de geselecteerde taal
  function updateLanguage(lang) {
    pageTitle.textContent = translations[lang].title;
    helpPopupText.textContent = translations[lang].tooltip;
    btnLabel.textContent = translations[lang].nextLabel;
  }

  // Roep updateLanguage op met de standaardtaal "nl" om de tekst meteen in het Nederlands te laten verschijnen
  updateLanguage("nl");
});
