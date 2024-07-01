$(document).ready(function() {
    // 페이지 로드 시, 사원 상세 정보를 가져와서 표시하는 함수 호출
    fetchEmployeeDetail();
});

function fetchEmployeeDetail() {
    // AJAX를 이용하여 사원 상세 정보를 서버에서 가져오는 함수
    $.ajax({
        url: '/adminEmpMngr/edit?empNo=${vo.no}', // 사원 상세 정보를 가져올 API 경로
        method: 'GET',
        dataType: 'json', // 응답 데이터 타입은 JSON으로 기대
        success: function(employeeDetail) {
            // 가져온 데이터를 각 항목에 대응하는 요소에 표시
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
            $('#retireYn').text(employeeDetail.retireYn);
        },
        error: function(xhr, status, error) {
            // 에러 처리 로직
            console.error('Error fetching employee detail:', error);
        }
    });
}