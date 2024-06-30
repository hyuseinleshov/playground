$(document).ready(function() {
    $('#fetch-books-btn').click(function() {
        $.ajax({
            url: '/api/books', // endpoint to fetch books (Spring controller)
            type: 'GET',
            success: function(books) {
                $('#book-details').empty(); // clear existing content
                books.forEach(function(book) {
                    $('#book-details').append('<p>Title: ' + book.title + ', Author: ' + book.author + ', ISBN: ' + book.isbn + '</p>');
                });
            },
            error: function() {
                alert('Error fetching books');
            }
        });
    });
});
