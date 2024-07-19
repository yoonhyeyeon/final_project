$(document).ready(function() {
    $('#messageForm').submit(function(event) {
        event.preventDefault(); // 폼 제출 방지

        let formData = {
            sender: $('input[name="senderNo"]').val(),
            receiver: $('input[name="receiverNo"]').val(),
            title: $('input[name="title"]').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/message/messageWriteData',
            data: formData,
            success: function(response) {
                window.location.href = '/message/messageSendList';
            },
            error: function(error) {
                console.log('Error:', error);
            }
        });
    });

});