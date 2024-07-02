$(document).ready(function() {
    $('#addItemForm').submit(function(event) {
        event.preventDefault();
        clearErrors();
        disableSubmitButton(true);
        const formData = JSON.stringify(getFormData($(this)));
        addItem(formData);
    });
});

function getFormData($form) {
    let unindexed_array = $form.serializeArray();
    let indexed_array = {};

    $.map(unindexed_array, function (n) {
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
        success: function(response) {
            $('#addItemModal').modal('hide');
            appendItem(response);
        },
        error: function(jqXHR) {
            disableSubmitButton(false);
            if (jqXHR.status === 400) {
                displayErrors(jqXHR.responseJSON);
            } else {
                alert('Error adding item');
            }
        }
    });
}

function clearErrors() {
    $('#nameError').text('');
    $('#descriptionError').text('');
}

function displayErrors(errors) {
    if (errors.name) {
        $('#nameError').text(errors.name);
    }
    if (errors.description) {
        $('#descriptionError').text(errors.description);
    }
}

function appendItem(item) {
    let tbody = $('#itemsTableBody');
    tbody.append('<tr><td>' + item.name + '</td>'
        + '<td>' + item.description + '</td></tr>');
    disableSubmitButton(false);
}

function disableSubmitButton(disable) {
    $('#addItemForm button[type="submit"]').prop('disabled', disable);
}
