$(document).ready(function() {
    // URL에서 쿼리 파라미터 'no'의 값을 가져오기
    let empNo = new URL(window.location.href).searchParams.get('no');

    $.ajax({
        url: '/adminEmpMngr/detailData?no=' + empNo,
        method: 'GET',
        success: function(employeeDetail) {
            $('#no').text(employeeDetail.no);
            $('#name').text(employeeDetail.name);
            $('#phone').text(employeeDetail.phone);
            $('#address').text(employeeDetail.address);
            $('#deptName').text(employeeDetail.deptName);
            $('#divName').text(employeeDetail.divName);
            $('#positionName').text(employeeDetail.positionName);
            $('#salary').text(employeeDetail.salary);
            $('#bonus').text(employeeDetail.bonus);
            $('#id').text(employeeDetail.id);
            $('#nick').text(employeeDetail.nick);
            $('#enrollDate').text(employeeDetail.enrollDate);
            $('#retireDate').text(employeeDetail.retireDate);

            // 삼항 연산자를 사용하여 'retireYn' 값에 따라 텍스트 변경
            let retireStatus = employeeDetail.retireYn === 'Y' ? '퇴사' : '재직';
            $('#retireYn').text(retireStatus);
        },
        error: function(xhr, status, error) {
            // 에러 처리 로직
            console.error('Error fetching employee detail:', error);
            console.error('사원 정보를 가져오는 중 오류 발생:', error);
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });

    // 버튼 클릭 시 사원 번호를 가져와서 URL에 추가
    $('#updateButton').click(function() {
        let empNo = $('#no').text();
        location.href = '/adminEmpMngr/edit?no=' + empNo;
    });
});
