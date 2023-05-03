class TimerModel {
    constructor() {
        this.startTime = null;
        this.timeElapsed = 0;
        this.intervalId = null;
    }

    start() {
        this.startTime = Date.now();
        this.intervalId = setInterval(() => {
            this.timeElapsed = Date.now() - this.startTime;
            this.updateDisplay();
        }, 1000);
    }

    stop() {
        clearInterval(this.intervalId);
        this.intervalId = null;
    }

    reset() {
        this.startTime = null;
        this.timeElapsed = 0;
        this.updateDisplay();
    }

    updateDisplay() {
        const timerElement = document.getElementById("timer");
        const seconds = Math.floor(this.timeElapsed / 1000) % 60;
        const minutes = Math.floor(this.timeElapsed / 60000);

        timerElement.textContent = `⏱ ${minutes.toString().padStart(2, "0")}:${seconds.toString().padStart(2, "0")}`;
    }
}

const timerModel = new TimerModel();
timerModel.start();