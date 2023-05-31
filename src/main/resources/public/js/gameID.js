    fetch('/api/game/host', {
    method: 'POST',
})
    .then(response => {
    if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
}
    return response.json();
})
    .then(race => {
    if (race && race.raceId) {
    document.getElementById('raceId').textContent = race.raceId;
} else {
    console.error('Error: Response does not include raceId', race);
}
})
    .catch(e => {
    console.error('Error: ' + e.message);
});
