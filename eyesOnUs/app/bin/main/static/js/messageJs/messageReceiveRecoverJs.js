$(document).ready(function() {
    $(document).on('click', '#recover-deleted-receive-message', function(event) {
        event.preventDefault();

        if (confirm('복구하시겠습니까?')) {
            let no = $(this).data('no');
            console.log(no);
            $.ajax({
                url: '/message/updateReceiveMsgRecover',
                type: 'PUT',
                contentType: 'text/plain',
                data: no.toString(),
                success: function(response) {
                    alert('복구했습니다.');
                    location.reload();
                },
            });
        }
    });
});
