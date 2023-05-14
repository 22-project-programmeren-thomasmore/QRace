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

document.addEventListener("DOMContentLoaded", function () {
    var helpBtn = document.querySelector(".help-btn");
    var helpPopup = document.querySelector(".help-popup");

    helpBtn.addEventListener("click", function () {
        helpPopup.style.display =
            helpPopup.style.display === "block" ? "none" : "block";
    });

    var languageBtn = document.querySelector(".language-btn");
    var pageTitle = document.querySelector("title");
    var hostLabel = document.querySelector('label[for="name"]');
    var joinLabel = document.querySelector('label[for="name"]');
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
        hostLabel.textContent = translations[lang].hostLabel;
        joinLabel.textContent = translations[lang].joinLabel;
        helpPopupText.textContent = translations[lang].tooltip;
    }
});

