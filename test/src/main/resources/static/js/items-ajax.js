$(document).ready(function() {
    $('#addItemForm').submit(function(event) {
        event.preventDefault();
        clearErrors();
        const formData = JSON.stringify(getFormData($(this)));
        addItem(formData);
    });

    $('#displayItemsBtn').click(function() {
        loadItems();
    });
});

function clearErrors() {
    $('#nameError').text('');
    $('#descriptionError').text('');
}

function getFormData($form) {
    let unindexed_array = $form.serializeArray();
    let indexed_array = {};

    $.map(unindexed_array, function(n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function addItem(formData) {
    $.ajax({
        url: '/api/items/create',
        method: 'POST',
        data: formData,
        contentType: 'application/json',
        success: function() {
            $('#addItemModal').modal('hide');
            alert('Item added successfully');
            loadItems();
        },
        error: function(jqXHR) {
            if (jqXHR.status === 400) {
                let errors = jqXHR.responseJSON;
                displayErrors(errors);
            } else {
                alert('Error adding item');
            }
        }
    });
}

function loadItems() {
    $.ajax({
        url: '/api/items',
        method: 'GET',
        success: function(data) {
            $('#itemList').empty();
            data.forEach(function(item) {
                $('#itemList').append('<p>' + item.name + ': ' + item.description + '</p>');
            });
        },
        error: function() {
            alert('Error loading items');
        }
    });
}

function displayErrors(errors) {
    if (errors.name) {
        $('#nameError').text(errors.name);
    }
    if (errors.description) {
        $('#descriptionError').text(errors.description);
    }
}
