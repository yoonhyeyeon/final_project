$(document).ready(function() {
    // URL에서 쿼리 파라미터 'no'의 값을 가져오기
    let empNo = new URL(window.location.href).searchParams.get('no');

    // AJAX를 이용하여 사원 상세 정보를 서버에서 가져오는 함수
    $.ajax({
        url: '/adminEmpMngr/editData?no=' + empNo,
        method: 'GET',
        dataType: 'json',
        success: function(employeeDetail) {
            // 서버에서 받아온 데이터를 각 필드에 설정
            $('#no').val(employeeDetail.no);
            $('#id').val(employeeDetail.id);
            $('#nick').val(employeeDetail.nick);
            $('#name').val(employeeDetail.name);
            $('#phone').val(employeeDetail.phone);
            $('#address').val(employeeDetail.address);

            // 입사일 설정 (날짜 형식 맞추기)
            let enrollDate = new Date(employeeDetail.enrollDate);
            let formattedEnrollDate = enrollDate.getFullYear() + '-' + ('0' + (enrollDate.getMonth() + 1)).slice(-2) + '-' + ('0' + enrollDate.getDate()).slice(-2);
            $('#enrollDate').val(formattedEnrollDate);

            // 부서 설정
            $('#deptCategory').val(employeeDetail.deptCode);

            // 직급 설정
            $('#positionCategory').val(employeeDetail.positionCode);
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
