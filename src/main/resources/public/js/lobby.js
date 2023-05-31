// Start Race button event handler
document.getElementById("startRaceBtn").addEventListener("click", startRace);

// Join Race button event handler
document.getElementById("joinRaceBtn").addEventListener("click", joinRace);

// Function to handle starting a race
function startRace() {
    // Send an HTTP POST request to your backend to create a new race
    fetch("/race/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ /* Race data */ }),
    })
        .then(response => {
            if (response.ok) {
                // Race created successfully, redirect to race page or show a success message
            } else {
                // Handle error response from the server
            }
        })
        .catch(error => {
            // Handle any network or other errors
        });
}

// Function to handle joining a race
function joinRace() {
    // Prompt the user for a race ID or use any other mechanism to obtain the ID
    const raceId = prompt("Enter the Race ID:");

    if (raceId) {
        // Send an HTTP POST request to your backend to join the specified race
        fetch(`/race/join/${raceId}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ /* Player data */ }),
        })
            .then(response => {
                if (response.ok) {
                    // Race joined successfully, redirect to race page or show a success message
                } else {
                    // Handle error response from the server
                }
            })
            .catch(error => {
                // Handle any network or other errors
            });
    }
}
