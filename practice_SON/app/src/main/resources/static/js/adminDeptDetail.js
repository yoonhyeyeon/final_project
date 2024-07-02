$(document).ready(function() {

    let no = new URL(window.location.href).searchParams.get('no');

    function formatDate(dateStr) {
        let date = new Date(dateStr);
        let year = date.getFullYear();
        let month = ('0' + (date.getMonth() + 1)).slice(-2);
        let day = ('0' + date.getDate()).slice(-2);
        return year + '-' + month + '-' + day;
    }

    $.ajax({
        url: '/adminDeptMngr/detailDivData?no=' + no,
        method: 'GET',
        success: function(response) {
            let divisionData = response;
            $('#deptName').text(divisionData.deptName);
            $('#name').text(divisionData.name);
            $('#enrollDate').text(formatDate(divisionData.enrollDate)); // 생성일 설정
            $('#modifyDate').text(formatDate(divisionData.modifyDate)); // 수정일 설정
            $('#state').text(divisionData.state);

            let empList = divisionData.employeeList;
            let empContainer = $('#empContainer');
        },
        error: function(xhr, status, error) {
            console.error('Error fetching division detail:', error);
            alert('팀 정보를 가져오는 중 오류 발생했습니다.');
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });


    $('#updateButton').click(function() {
        let no = new URL(window.location.href).searchParams.get('no');
        location.href = '/adminDeptMngr/edit?code=' + no;
    });

});
