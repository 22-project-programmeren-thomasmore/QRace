const socket = new WebSocket('ws://localhost:8080/ws');

socket.onopen = function() {
    console.log('WebSocket connection established.');

    // Send a message to the server
    socket.send('Hello, server!');
};

socket.onmessage = function(event) {
    const message = event.data;
    console.log('Received message from server:', message);
};

socket.onclose = function() {
    console.log('WebSocket connection closed.');
};

document.addEventListener('DOMContentLoaded', function() {
    // Get the "Start Race" button element
    var startRaceBtn = document.getElementById('startRaceBtn');

    // Add click event listener to the "Start Race" button
    startRaceBtn.addEventListener('click', function() {
        // Redirect to the Java endpoint for starting the race
        window.location.href = '/host';
    });

    // Get the "Join Race" button element
    var joinRaceBtn = document.getElementById('joinRaceBtn');

    // Add click event listener to the "Join Race" button
    joinRaceBtn.addEventListener('click', function() {
        // Redirect to the Java endpoint for joining the race
        window.location.href = '/join';
    });
});
