var startTime;
var stopwatchInterval;
var raceTimes = [];

function startStopwatch() {
    startTime = new Date().getTime();
    stopwatchInterval = setInterval(updateStopwatch, 1000);
}

function stopStopwatch() {
    clearInterval(stopwatchInterval);
}

function resetStopwatch() {
    clearInterval(stopwatchInterval);
    document.getElementById("stopwatch").innerHTML = "00:00:00";
    raceTimes = [];
    document.getElementById("timeList").innerHTML = "";
}

function updateStopwatch() {
    var currentTime = new Date().getTime();
    var elapsedTime = currentTime - startTime;

    var timeString = formatTime(elapsedTime);
    document.getElementById("stopwatch").innerHTML = timeString;
}

function recordTime() {
    var currentTime = new Date().getTime();
    var elapsedTime = currentTime - startTime;

    var timeString = formatTime(elapsedTime);
    raceTimes.push(timeString);

    // var timeItem = document.createElement("li");
    // timeItem.textContent = timeString;
    // document.getElementById("timeList").appendChild(timeItem);
}

function formatTime(time) {
    var minutes = Math.floor((time % 3600000) / 60000);
    var seconds = Math.floor((time % 60000) / 1000);
    return pad(minutes) + ":" + pad(seconds);
}

function pad(number) {
    return (number < 10 ? "0" : "") + number;
}

function getCurrentStopwatchTime() {
    var currentTime = new Date().getTime();
    var elapsedTime = currentTime - startTime;

    var timeString = formatTime(elapsedTime);
    raceTimes.push(timeString);

    // var timeItem = document.createElement("li");
    // timeItem.textContent = timeString;
    
    return timeString;
}

window.onload = function () {
    startStopwatch();
}
