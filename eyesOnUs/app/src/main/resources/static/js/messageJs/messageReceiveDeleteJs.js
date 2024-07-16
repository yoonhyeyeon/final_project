$(document).ready(function() {
    $(document).on('click', '#delete-receive-message', function(event) {
        event.preventDefault();

        if (confirm('삭제하시겠습니까?')) {
            let no = $(this).data('no');
            console.log(no);
            $.ajax({
                url: '/message/updateReceiveMsgDelYn',
                type: 'PUT',
                contentType: 'text/plain',
                data: no.toString(),
                success: function(response) {
                    alert('삭제했습니다.');
                    location.reload();
                },
            });
        }
    });
});
