const loadScript = (src) => {
  return new Promise((resolve, reject) => {
    const script = document.createElement("script");
    script.src = src;
    script.onload = resolve;
    script.onerror = reject;
    document.head.appendChild(script);
  });
};

const initQrScanner = async (
  openScannerBtnId,
  closeScannerBtnId,
  scannerFragmentId,
  scanResultId
) => {
  await loadScript("https://unpkg.com/qr-scanner");

  const openScannerBtn = document.getElementById(openScannerBtnId);
  const closeScannerBtn = document.getElementById(closeScannerBtnId);
  const scannerFragment = document.getElementById(scannerFragmentId);
  const scanResult = document.getElementById(scanResultId);

  // Load scanner fragment
  fetch("src/main/resources/templates/fragments/qrScanner.html")
    .then((response) => response.text())
    .then((html) => {
      scannerFragment.innerHTML = html;

      const video = document.getElementById("qr-video");

      function setResult(label, result) {
        console.log(result.data);
        scanResult.textContent = result.data;
        label.style.color = "teal";
        clearTimeout(label.highlightTimeout);
        label.highlightTimeout = setTimeout(
          () => (label.style.color = "inherit"),
          100
        );
      }

      const scanner = new QrScanner(video, (result) =>
        setResult(scanResult, result)
      );

      openScannerBtn.addEventListener("click", () => {
        scanner.start();
        scannerFragment.style.display = "block";
      });

      closeScannerBtn.addEventListener("click", () => {
        scanner.stop();
        scannerFragment.style.display = "none";
      });

      // for debugging
      window.scanner = scanner;
    });
};

initQrScanner(
  "openScannerBtn",
  "closeScannerBtn",
  "scannerFragment",
  "scanResult"
);
