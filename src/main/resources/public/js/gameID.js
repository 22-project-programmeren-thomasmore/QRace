    fetch('/api/game/host', {
    method: 'POST',
})
    .then(response => {
    if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
}
    return response.json();
})
    .then(game => {
    if (game && game.raceId) {
    document.getElementById('raceId').textContent = game.raceId;
} else {
    console.error('Error: Response does not include raceId', game);
}
})
    .catch(e => {
    console.error('Error: ' + e.message);
});