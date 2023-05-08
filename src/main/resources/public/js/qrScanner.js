const preview = document.getElementById("preview");
const scanner = new QrScanner(preview, (result) => console.log(result), {
  frequency: 20,
  cameraId: "back",
});
scanner.start();
