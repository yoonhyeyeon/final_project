$(document).ready(function() {
    let no = new URL(window.location.href).searchParams.get('no');

    $.ajax({
        url: '/adminDeptMngr/detailDivMemData?no=' + no,
        method: 'GET',
        success: function(response) {
            let empContainer = $('#empContainer');
            empContainer.empty();

            let headerRow = `
                <div class="dept-detail-header list-header-row">
                    <div>사원번호</div>
                    <div>직급</div>
                    <div>이름</div>
                </div>`;
            empContainer.append(headerRow);

            let empList = response.empList;
            for (let i = 0; i < empList.length; i++) {
                let vo = empList[i];
                let row = `
                    <div class="dept-detail-row list-body-row">
                        <div class="emp-data list-body-low">${vo.no}</div>
                        <div class="emp-data list-body-low">${vo.positionName}</div>
                        <div class="emp-data list-body-low">${vo.name}</a></div>
                    </div>`;
                empContainer.append(row);
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error('AJAX 요청 실패:', textStatus, errorThrown);
        }
    });
});
