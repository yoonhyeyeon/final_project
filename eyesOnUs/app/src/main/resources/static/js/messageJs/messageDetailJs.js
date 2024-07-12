$(document).ready(function() {
    // URL에서 쿼리 파라미터 'no'의 값을 가져오기
    let no = new URL(window.location.href).searchParams.get('no');
    let url = new URL(window.location.href);

    // 로그인 세션에서 사원번호를 가져오는 함수 (AJAX 요청)
    function loginNo() {
        return $.ajax({
            url: '/message/loginNo',
            method: 'GET'
        });
    }

    // 메시지 상세 데이터 가져오기
    $.ajax({
        url: '/message/messageDetailData?no=' + no,
        method: 'GET',
        success: function(messageDetail) {
            $('#title').val(messageDetail.title);
            $('#content').val(messageDetail.content);
            let senderInfo = messageDetail.senderDeptName + ' ' +
                             messageDetail.senderDivName + ' ' +
                             messageDetail.senderPositionName + ' ' +
                             messageDetail.senderName;
            $('#senderInfo').val(senderInfo);
            $('#sendTime').val(messageDetail.sendTime);

            // 로그인된 사원번호를 가져와서 delYn과 receiver를 확인
            loginNo().done(function(currentLoginNo) {
                            console.log(messageDetail.receiver);
                            console.log(currentLoginNo);
                            console.log(messageDetail.delYn);
                if (messageDetail.readYn === "N" && messageDetail.receiver === currentLoginNo) {
                    // delYn을 'Y'로 업데이트하는 AJAX 요청
                    $.ajax({
                        url: '/message/updateDelYn',
                        method: 'POST',
                        contentType: 'application/json',
                        data: no,
                        success: function(response) {
                            console.log('readYn 업데이트 성공:', response);
                        },
                        error: function(xhr, status, error) {
                            console.error('Error updating readYn:', error);
                            console.error('readYn 업데이트 중 오류 발생:', error);
                            console.log('상태:', status);
                            console.log('응답 내용:', xhr.responseText);
                        }
                    });
                }
            }).fail(function(xhr, status, error) {
                console.error('Error fetching login no:', error);
                console.error('로그인 사원번호를 가져오는 중 오류 발생:', error);
                console.log('상태:', status);
                console.log('응답 내용:', xhr.responseText);
            });
        },
        error: function(xhr, status, error) {
            console.error('Error fetching message detail:', error);
            console.error('메시지를 가져오는 중 오류 발생:', error);
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('listButton').addEventListener('click', function() {
        let previousUrl = sessionStorage.getItem('currentPage');
        let currentPath = window.location.pathname;

        if (currentPath.includes('/message/messageReceiveList')) {
            window.location.href = 'http://127.0.0.1:8383/message/messageReceiveList';
        } else if (currentPath.includes('/message/messageSendList')) {
            window.location.href = 'http://127.0.0.1:8383/message/messageSendList';
        } else {
            // 이전 URL이 저장된 경우 해당 URL로 이동
            if (previousUrl) {
                window.location.href = previousUrl;
            } else {
                // 이전 URL이 저장되지 않은 경우 기본적으로 뒤로가기
                window.history.back();
            }
        }
    });
});
