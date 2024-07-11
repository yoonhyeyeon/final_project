$(document).ready(function() {
    // URL에서 쿼리 파라미터 'no'의 값을 가져오기
    let no = new URL(window.location.href).searchParams.get('no');

    $.ajax({
        url: '/message/messageDetailData?no=' + no,
        method: 'GET',
        success: function(messageDetail) {
            console.log(messageDetail);
            $('#title').val(messageDetail.title);
            $('#content').val(messageDetail.content);
            let senderInfo = messageDetail.senderDeptName + ' ' +
                             messageDetail.senderDivName + ' ' +
                             messageDetail.senderPositionName + ' ' +
                             messageDetail.senderName;
            console.log(senderInfo);
            $('#senderInfo').val(senderInfo);
            $('#sendTime').val(messageDetail.sendTime);
        },
        error: function(xhr, status, error) {
            // 에러 처리 로직
            console.error('Error fetching message detail:', error);
            console.error('메시지를 가져오는 중 오류 발생:', error);
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });
});
