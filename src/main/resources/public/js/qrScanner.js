// mobile camera qr code scanner js code for my html web page
import jsQR from "jsqr";
// select the scan button
const scanButton = document.querySelector("#scanButton");
// add click event listener
scanButton.addEventListener("click", () => {
  // access the device camera
  navigator.mediaDevices
    .getUserMedia({ video: { facingMode: "environment" } })
    .then((stream) => {
      // get the video element and set the stream as source
      const video = document.createElement("video");
      video.srcObject = stream;
      video.setAttribute("playsinline", true);
      video.play();

      // create canvas element and set dimensions to match video
      const canvas = document.createElement("canvas");
      const canvasContext = canvas.getContext("2d");
      const canvasWidth = video.videoWidth;
      const canvasHeight = video.videoHeight;
      canvas.width = canvasWidth;
      canvas.height = canvasHeight;

      // continuously scan the video feed for QR codes
      const scan = () => {
        canvasContext.drawImage(video, 0, 0, canvasWidth, canvasHeight);
        const imageData = canvasContext.getImageData(
          0,
          0,
          canvasWidth,
          canvasHeight
        );
        const code = jsQR(imageData.data, imageData.width, imageData.height);
        if (code) {
          console.log(code.data);
          // stop scanning when QR code is found
          stream.getTracks().forEach((track) => track.stop());
        } else {
          // continue scanning
          requestAnimationFrame(scan);
        }
      };

      // start scanning
      scan();
    })
    .catch((error) => {
      console.error(error);
    });
});
