const translations = {
  en: {
    title: "Enter Name",
    nameLabel: "Name:",
    tooltip: "Enter your username here.",
  },
  fr: {
    title: "Entrez le nom",
    nameLabel: "Nom:",
    tooltip: "Entrez votre nom d'utilisateur ici.",
  },
  nl: {
    title: "Naam invoeren",
    nameLabel: "Naam:",
    tooltip: "Vul hier je gebruikersnaam in.",
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
  var pageTitle = document.querySelector("title");
  var nameLabel = document.querySelector('label[for="name"]');
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
    nameLabel.textContent = translations[lang].nameLabel;
    helpPopupText.textContent = translations[lang].tooltip;
  }
});
