// get the video element from the DOM
const video = document.getElementById("qr-video");
// get the video container element from the DOM
const videoContainer = document.getElementById("video-container");
// get the button that opens the scanner
const openScannerBtn = document.getElementById("openScannerBtn");
// get the button that closes the scanner
const closeScannerBtn = document.getElementById("closeScannerBtn");
// get the scanner container element from the DOM
const scannerContainer = document.getElementById("scannerContainer");
// get the element that displays the scan result
const scanResult = document.getElementById("scanResult");
let resultSent = false; // Flag variable to track if a result has already been sent
let scannerRunning = false; // Flag variable to track if the scanner is running

// create a new scanner
const scanner = new QrScanner(
  video,
  (result) => setResult(scanResult, result),
  {
    maxScansPerSecond: 25,
    returnDetailedScanResult: false,
    onDecodeContinuouslyStop: true,
    scanBoth: true,
    highlightScanRegion: true,
    highlightCodeOutline: true,
    showCanvas: true,
    preferredFacingMode: "environment",
    scanRegion: { top: "25%", left: "25%", width: "50%", height: "50%" },
  }
);

// add event listener for the open scanner button
openScannerBtn.addEventListener("click", () => {
resultSent = false; // Reset the flag variable
  scanner.start();
    scannerRunning = true; // Set the scannerRunning flag to true
  closeScannerBtn.style.display = "inline";
  scannerContainer.style.display = "block";
  openScannerBtn.style.display = "none";
});

closeScannerBtn.addEventListener("click", () => {
  // stop the scanner after a 1-second delay
    scanner.stop();
    scannerRunning = false; // Set the scannerRunning flag to true
    // hide the scanner container
    scannerContainer.style.display = "none";
    // show the button to open the scanner
    openScannerBtn.style.display = "inline";
});

// for debugging
window.scanner = scanner;

function setResult(label, result) {

    // Stop the scanner
    scanner.stop();
    // Hide the scanner container
    scannerContainer.style.display = "none";

    // Get the scanned data
    const scannedData = result.data;

    // Create a RaceAction object with the scanned data
    const raceAction = {
        actionType: "SCAN",
        scannedData: scannedData,
    };

    // Convert the RaceAction object to JSON string
    const raceActionJson = JSON.stringify(raceAction);

    // Send the RaceAction object via WebSocket
    websocket.send(raceActionJson);

    // Display the scanned data in the UI
    scanResult.textContent = scannedData;

    // You can also perform other actions based on the scanned data
    // ...

    // Hide the answer options container (if applicable)
    answerOptionsContainer.style.display = "none";

  if (!resultSent) {
    resultSent = true; // Set the flag to true to indicate that a result has been sent
    // send the result after a 1-second delay if the scanner is still running
    setTimeout(() => {
      if (scannerRunning) {
        scanner.stop();
        // hide the scanner container
        scannerContainer.style.display = "none";
        // send the result
        exportResult(result.data);
      }
    }, 1000);
  }
}


function exportResult(data) {
  // Create a custom event to export the data to questions.js
  const exportDataEvent = new CustomEvent("exportData", { detail: data });

  // Dispatch the custom event
  document.dispatchEvent(exportDataEvent);
}

function promptForNewQRCode() {
  // Hide the answer options container
  answerOptionsContainer.style.display = "none";

  // Show the button to open the scanner
  openScannerBtn.style.display = "block";
}
