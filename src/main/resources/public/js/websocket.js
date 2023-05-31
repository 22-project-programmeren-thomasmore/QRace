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