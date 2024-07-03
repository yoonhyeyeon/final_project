$(document).ready(function() {
    let no = new URL(window.location.href).searchParams.get('no');

    function formatDate(dateStr) {
        let date = new Date(dateStr);
        let year = date.getFullYear();
        let month = ('0' + (date.getMonth() + 1)).slice(-2);
        let day = ('0' + date.getDate()).slice(-2);
        return year + '-' + month + '-' + day;
    }

    function createFormHtml(divisionData) {
        return `
            <div id="editForm" action="/adminDeptMngr/edit" method="post">
                <div class="form-group">
                    <label for="deptName">부서</label>
                    <div class="value" id="deptName">${divisionData.deptName}</div>
                </div>
                <div class="form-group">
                    <label for="name">팀명</label>
                    <div class="value" id="name">${divisionData.name}</div>
                </div>
                <div class="form-group">
                    <label for="enrollDate">생성일</label>
                    <div class="value" id="enrollDate">${formatDate(divisionData.enrollDate)}</div>
                </div>
                <div class="form-group">
                    <label for="modifyDate">수정일</label>
                    <div class="value" id="modifyDate">${formatDate(divisionData.modifyDate)}</div>
                </div>
                <div class="form-group">
                    <label for="state">팀 상태</label>
                    <div class="value" id="state">${divisionData.state}</div>
                </div>
                <div>
                    <div class="emp-container list-container" id="empContainer"></div>
                    <div class="pagination" id="pagination"></div>
                </div>
                <div class="form-group">
                    <button class="edit-button" id="updateButton">부서정보수정</button>
                    <button class="getBack-button" id="listButton" onclick="location.href='/adminDeptMngr/list'">목록으로</button>
                </div>
            </div>
        `;
    }

    $.ajax({
        url: '/adminDeptMngr/detailDivData?no=' + no,
        method: 'GET',
        success: function(response) {
            let divisionData = response;
            $('#formContainer').html(createFormHtml(divisionData));
        },
        error: function(xhr, status, error) {
            console.error('Error fetching division detail:', error);
            alert('팀 정보를 가져오는 중 오류 발생했습니다.');
            console.log('상태:', status);
            console.log('응답 내용:', xhr.responseText);
        }
    });

    $(document).on('click', '#updateButton', function() {
        let no = new URL(window.location.href).searchParams.get('no');
        location.href = '/adminDeptMngr/edit?code=' + no;
    });

});
