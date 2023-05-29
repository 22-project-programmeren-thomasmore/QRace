
document.addEventListener('DOMContentLoaded', (event) => {

    const defaultLanguage = 'nl';
    const availableLanguages = ['nl', 'fr', 'en'];
    let currentLanguage = getCookie("language") || defaultLanguage;

    if (!currentLanguage || !availableLanguages.includes(currentLanguage)) {
        currentLanguage = defaultLanguage;
        setCookie('language', currentLanguage);
    }
    else {
        setCookie('language', currentLanguage);
    }

    function getCookie(cname) {
        const name = cname + "=";
        const decodedCookie = decodeURIComponent(document.cookie);
        const ca = decodedCookie.split(';');
        for(let i = 0; i <ca.length; i++) {
            let c = ca[i].trim();
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    function setCookie(cname, cvalue) {
        document.cookie = cname + "=" + cvalue + ";";
    }

    const translations = window.translations;
    let pageName = window.location.pathname.split('/').pop().replace('.html', '') || 'start';

    if (!translations[pageName]) {
        pageName = 'start';
    }

    function updateText() {
        const pageTexts = translations[pageName][currentLanguage] || {};

        for (const [key, value] of Object.entries(pageTexts)) {
            const element = document.getElementById(key);
            if (element) {
                element.innerText = value;
            }
        }
    }

    updateText();

    document.getElementById('changeLanguage').addEventListener('click', function () {
        const currentLanguageIndex = availableLanguages.indexOf(currentLanguage);
        currentLanguage = availableLanguages[(currentLanguageIndex + 1) % availableLanguages.length];

        setCookie('language', currentLanguage);
        updateText();
    });
});
