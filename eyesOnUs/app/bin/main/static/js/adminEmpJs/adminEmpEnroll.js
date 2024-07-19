$(document).ready(function() {
    $('.submit-button').click(function(event) {
        event.preventDefault();

        let formData = {
            id: $('input[name="id"]').val(),
            nick: $('input[name="nick"]').val(),
            pwd: $('input[name="pwd"]').val(),
            name: $('input[name="name"]').val(),
            phone: $('input[name="phone"]').val(),
            address: $('input[name="address"]').val(),
            deptCode: $('input[name="deptCode"]').val(),
            divCode: $('input[name="divCode"]').val(),
            positionCode: $('input[name="positionCode"]').val(),
            enrollDate: $('input[name="enrollDate"]').val()
        };

        $.ajax({
            type: 'POST',
            url: 'enrollEmpData',
            data: formData,
            success: function(response) {
                window.location.href = '/adminEmpMngr/list';
            },
            error: function(error) {
                console.log('Error:', error);
            }
        });
    });
});