$(document).ready(function() {
    $('#editForm').submit(function(event) {
        event.preventDefault();

        var formData = new FormData(this);

        $.ajax({
            type: 'POST',
            url: $(this).attr('action'),
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                alert('팀 정보가 수정되었습니다.');
                window.location.href = './list';
            },
            error: function(error) {
                console.error('Error:', error);
                alert('팀 정보 수정에 실패하였습니다. 다시 시도해주세요.');
            }
        });
    });
});