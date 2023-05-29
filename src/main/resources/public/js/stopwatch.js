var startTime;
var endTime;

function startStopwatch() {
    startTime = new Date();
}
function stopStopwatch() {
    endTime = new Date();
}
function saveTimeToServer(playerID) {
    var elapsedMilliseconds = endTime - startTime;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/race", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Time saved to Java server successfully.");
        }
    };
    var data = JSON.stringify({ playerID: playerID, time: elapsedMilliseconds });
    xhr.send(data);
}



