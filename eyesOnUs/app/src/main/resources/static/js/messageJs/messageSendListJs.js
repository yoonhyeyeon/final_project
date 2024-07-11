$(document).ready(function() {
    function populateEmpContainer(page) {
        $.ajax({
            url: '/message/messageSendListData?page=' + page,
            type: 'GET',
            dataType: 'json',
            success: function(response) {
                $('#empContainer').empty();
                var headerRow = '<div class="emp-header list-header-row">' +
                    '<div>시간</div>' +
                    '<div>제목</div>' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>직급</div>' +
                    '<div>수신인</div>' +
                    '<div>읽음</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="emp-row list-body-row">' +
                        '<div class="emp-data list-body-low">' + vo.sendTime + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.title + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.divName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.positionName + '</div>' +
                        `<div class="emp-data list-body-low"><a class="team-link" href="/message/detail?no=${vo.no}">${vo.name}</a></div>` +
                        `<div class="emp-data list-body-low"><a class="team-link" href="/adminEmpMngr/edit?no=${vo.no}">삭제</a></div>` +
                        '</div>';
                    $('#empContainer').append(row);
                }

                createPagination(response.totalPages, page);
            },
            error: function(xhr, status, error) {
                console.error('Error fetching emp data:', error);
            }
        });
    }

    // 페이지네이션 생성 함수
    function createPagination(totalPages, currentPage) {
        $('#pagination').empty();
        for (var i = 1; i <= totalPages; i++) {
            var link = `<a href="#" class="page-link" data-page="${i}">${i}</a> `;
            $('#pagination').append(link);
        }
        $('#pagination').find(`[data-page="${currentPage}"]`).addClass('current-page');
    }

    // 초기 로딩 시 첫 번째 페이지 데이터 로드
    populateEmpContainer(1);

    $(document).on('click', '#pagination .page-link', function(e) {
        e.preventDefault();
        var page = $(this).data('page');
        populateEmpContainer(page);
    });
});