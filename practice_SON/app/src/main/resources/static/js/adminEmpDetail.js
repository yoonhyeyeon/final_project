$(document).ready(function() {
    // URL에서 쿼리 파라미터 'no'의 값을 가져오기
    var empNo = new URL(window.location.href).searchParams.get('no');

    // AJAX를 이용하여 사원 상세 정보를 서버에서 가져오는 함수
    $.ajax({
        url: '/adminEmpMngr/detailData?no=' + empNo,
        method: 'GET',
        success: function(employeeDetail) { // employeeDetail 매개변수 추가
            // 필요한 정보들을 각각의 요소에 설정
            $('#name').text(employeeDetail.vo.name);
            $('#phone').text(employeeDetail.vo.phone);
            $('#address').text(employeeDetail.vo.address);
            $('#deptName').text(employeeDetail.vo.deptName);
            $('#divName').text(employeeDetail.vo.divName);
            $('#positionName').text(employeeDetail.vo.positionName);
            $('#salary').text(employeeDetail.vo.salary);
            $('#bonus').text(employeeDetail.vo.bonus);
            $('#id').text(employeeDetail.vo.id);
            $('#nick').text(employeeDetail.vo.nick);
            $('#enrollDate').text(employeeDetail.vo.enrollDate);
            $('#retireDate').text(employeeDetail.vo.retireDate);
            $('#retireYn').text(employeeDetail.vo.retireYn);
        },
        error: function(xhr, status, error) {
            // 에러 처리 로직
            console.error('Error fetching employee detail:', error);
            console.error('사원 정보를 가져오는 중 오류 발생:', error);
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });
});
