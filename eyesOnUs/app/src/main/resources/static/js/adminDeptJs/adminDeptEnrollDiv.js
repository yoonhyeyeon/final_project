$(document).ready(function() {
    $('.enroll-button').click(function(event) {
        event.preventDefault();

        var formData = {
            deptCategory: $('select[name="deptCategory"]').val(),
            name: $('input[name="name"]').val(),
            code: $('input[name="code"]').val(),
            enrollDate: $('input[name="enrollDate"]').val(),
            stateCategory: $('select[name="stateCategory"]').val()
        };

        $.ajax({
            type: 'POST',
            url: '/adminDeptMngr/enrollDivData',
            data: formData,
            success: function(response) {
                window.location.href = './list';
            },
            error: function(error) {
                console.log('Error:', error);
            }
        });
    });
});