$(document).ready(function() {
    // 사원 정보 수정 버튼 클릭 시 처리
    $('#updateButton').click(function() {
        // 입력된 값들을 서버로 전송하여 사원 정보를 수정하는 로직
        var updatedData = {
            no: $('#no').val(),
            id: $('#id').val(),
            nick: $('#nick').val(),
            name: $('#name').val(),
            phone: $('#phone').val(),
            address: $('#address').val(),
            enrollDate: $('#enrollDate').val(),
            deptCode: $('#deptCategory').val(),
            divCode: $('#divCategory').val(),
            positionCode: $('#positionCategory').val()
            // 필요한 경우에 따라 추가적인 데이터도 포함할 수 있음
        };

        // 수정된 데이터를 서버로 전송하는 AJAX 요청
        $.ajax({
            url: '/adminEmpMngr/updateEmpData',
            method: 'POST', // POST 방식으로 전송
            contentType: 'application/json',
            data: JSON.stringify(updatedData),
            success: function(response) {
                alert('사원 정보가 성공적으로 수정되었습니다.');
            },
            error: function(xhr, status, error) {
                console.error('Error updating employee information:', error);
                alert('사원 정보 수정 중 오류가 발생했습니다.');
                console.log('상태:', status);
                console.log('응답 내용:', xhr.responseText);
            }
        });
    });
});
