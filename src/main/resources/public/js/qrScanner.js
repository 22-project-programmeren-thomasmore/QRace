// get the video element from the DOM
const video = document.getElementById('qr-video');
// get the video container element from the DOM
const videoContainer = document.getElementById('video-container');
// get the button that opens the scanner
const openScannerBtn = document.getElementById('openScannerBtn');
// get the button that closes the scanner
const closeScannerBtn = document.getElementById('closeScannerBtn');
// get the scanner container element from the DOM
const scannerContainer = document.getElementById('scannerContainer');
// get the element that displays the scan result
const scanResult = document.getElementById('scanResult');

// function that sets the scan result
function setResult(label, result) {
  // set the scan result text
  scanResult.textContent = result.data;
  // set the text color
  label.style.color = 'teal';
  // clear the highlight timeout
  clearTimeout(label.highlightTimeout);
  // set the highlight timeout
  label.highlightTimeout = setTimeout(() => label.style.color = 'inherit', 100);
}

// create a new scanner
const scanner = new QrScanner(video, result => setResult(scanResult, result), { returnDetailedScanResult: true });

// add event listener for the open scanner button
openScannerBtn.addEventListener('click', () => {
  // start the scanner
  scanner.start();
  // display the scanner container
  scannerContainer.style.display = 'block';
});

// add event listener for the close scanner button
closeScannerBtn.addEventListener('click', () => {
  // stop the scanner
  scanner.stop();
  // hide the scanner container
  scannerContainer.style.display = 'none';
});

// for debugging
window.scanner = scanner;