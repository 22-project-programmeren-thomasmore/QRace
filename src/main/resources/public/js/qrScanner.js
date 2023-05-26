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

// create a new scanner
const scanner = new QrScanner(
  video,
  (result) => setResult(scanResult, result),
  {
    returnDetailedScanResult: true,
    onDecodeContinuouslyStop: true,
    scanBoth: true,
    highlightScanRegion: true,
    highlightCodeOutline: true,
    showCanvas: true,
    scanRegion: true,
    preferredFacingMode: "environment",
    scanRegion: { top: "25%", left: "25%", width: "50%", height: "50%" },
  }
);

// add event listener for the open scanner button
openScannerBtn.addEventListener("click", () => {
  // start the scanner
  scanner.start();
  // display the scanner container
  scannerContainer.style.display = "block";
});

// add event listener for the close scanner button
closeScannerBtn.addEventListener("click", () => {
  // stop the scanner
  scanner.stop();
  // hide the scanner container
  scannerContainer.style.display = "none";
});

// for debugging
window.scanner = scanner;

function setResult(label, result) {
  // stop the scanner
  scanner.stop();
  // hide the scanner container
  scannerContainer.style.display = "none";

  // display the result in console
  console.log(result.data);
  exportResult(result.data);

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
