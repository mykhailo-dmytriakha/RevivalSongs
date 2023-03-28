document.getElementById('edit-songbook-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const songbookId = document.getElementById('songbook-id').value;
    const songbookTitle = document.getElementById('songbook-title').value;

    const updatedSongbook = {
        id: songbookId,
        title: songbookTitle
    };

    fetch(`/api/songbooks/${songbookId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedSongbook)
    })
        .then(response => {
            if (response.ok) {
                alert('Songbook updated successfully!');
                window.location.href = '/songbooks';
            } else {
                alert('Error updating songbook. Please try again.');
            }
        })
        .catch(() => {
            alert('Error updating songbook. Please try again.');
        });
});
