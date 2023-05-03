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

document.addEventListener("DOMContentLoaded", function () {
  var helpBtn = document.querySelector(".help-btn");
  var helpPopup = document.querySelector(".help-popup");

  helpBtn.addEventListener("click", function () {
    helpPopup.style.display =
      helpPopup.style.display === "block" ? "none" : "block";
  });

  var languageBtn = document.querySelector(".language-btn");
  var pageTitle = document.querySelector("h1");
  var btnLabel = document.querySelector('button[for="next"]');
  var helpPopupText = document.querySelector(".help-popup p");

  languageBtn.addEventListener("click", function () {
    var currentLang = languageBtn.getAttribute("data-lang");
    var newLang;

    if (currentLang === "en") {
      newLang = "fr";
    } else if (currentLang === "fr") {
      newLang = "nl";
    } else {
      newLang = "en";
    }

    languageBtn.setAttribute("data-lang", newLang);
    updateLanguage(newLang);
  });

  function updateLanguage(lang) {
    pageTitle.textContent = translations[lang].title;
    helpPopupText.textContent = translations[lang].tooltip;
    btnLabel.textContent = translations[lang].nextLabel;
  }

  // Roep updateLanguage op met de standaardtaal "nl" om de tekst meteen in het Nederlands te laten verschijnen
  updateLanguage("nl");
});
