$(document).ready(function() {
    // 부서 선택이 변경되었을 때 팀 정보를 가져오는 함수
    $('#deptCategory').change(function() {
        var selectedDept = $(this).val();
        getDivCode(selectedDept);
    });

    // 초기화면 설정
    $('#deptCategory').trigger('change');

    // 팀 정보를 가져오는 함수 정의
    function getDivCode(deptCode, currentDivCode) {
        $.ajax({
            url: '/adminEmpMngr/getDivCode?deptCode=' + deptCode,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                var divCategorySelect = $('#divCategory');
                divCategorySelect.empty(); // 기존 옵션 제거

                // 받은 데이터를 이용해 팀 옵션 추가
                data.voList.forEach(function(division) {
                    var option = $('<option></option>')
                        .attr('value', division.code)
                        .text(division.name);

                    // 현재 선택된 팀 코드와 일치하는 경우 선택 상태로 설정
                    if (division.code === currentDivCode) {
                        option.prop('selected', true);
                    }

                    divCategorySelect.append(option);
                });
            },
            error: function(xhr, status, error) {
                console.error('팀 정보를 가져오는 중 오류 발생:', error);
            }
        });
    }
});
