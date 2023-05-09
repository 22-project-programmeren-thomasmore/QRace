const video = document.getElementById('qr-video');
const videoContainer = document.getElementById('video-container');
const openScannerBtn = document.getElementById('openScannerBtn');
const closeScannerBtn = document.getElementById('closeScannerBtn');
const scannerContainer = document.getElementById('scannerContainer');
const scanResult = document.getElementById('scanResult');

function setResult(label, result) {
  console.log(result.data);
  scanResult.textContent = result.data;
  label.style.color = 'teal';
  clearTimeout(label.highlightTimeout);
  label.highlightTimeout = setTimeout(() => label.style.color = 'inherit', 100);
}

// ####### Web Cam Scanning #######

const scanner = new QrScanner(video, result => setResult(scanResult, result), { returnDetailedScanResult: true });

openScannerBtn.addEventListener('click', () => {
  scanner.start();
  scannerContainer.style.display = 'block';
});

closeScannerBtn.addEventListener('click', () => {
  scanner.stop();
  scannerContainer.style.display = 'none';
});

// for debugging
window.scanner = scanner;
