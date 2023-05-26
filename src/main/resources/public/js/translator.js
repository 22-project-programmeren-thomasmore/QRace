document.addEventListener('DOMContentLoaded', (event) => {
    const translations = window.translations;
    let currentLanguage = 'nl';

    // Check if a language has been saved in the cookies
    const savedLanguage = document.cookie.replace(/(?:(?:^|.*;\s*)language\s*\=\s*([^;]*).*$)|^.*$/, "$1");
    if (savedLanguage) {
        currentLanguage = savedLanguage;
    }

    // Get the current page's name
    let pageName = window.location.pathname.split('/').pop().replace('.html', '');

    // Als pageName niet overeenkomt met een van de keys in translations, stellen we het in op 'start'
    if (!translations.hasOwnProperty(pageName)) {
        pageName = 'start';
    }

    function updateText() {
        console.log('current Language: ', currentLanguage); // Log the current language

        // Update the text on the page
        for (const key in translations[pageName][currentLanguage]) {
            const element = document.getElementById(key);
            if (element) {
                element.innerText = translations[pageName][currentLanguage][key];
            }
        }
    }

    // Fill in the initial text
    updateText();

    document.getElementById('changeLanguage').addEventListener('click', function () {
        // Cycle through the languages
        if (currentLanguage === 'nl') {
            currentLanguage = 'fr';
        } else if (currentLanguage === 'fr') {
            currentLanguage = 'en';
        } else if (currentLanguage === 'en') {
            currentLanguage = 'nl';
        }

        // Save the selected language in a cookie
        document.cookie = "language=" + currentLanguage;

        updateText();
    });
});
