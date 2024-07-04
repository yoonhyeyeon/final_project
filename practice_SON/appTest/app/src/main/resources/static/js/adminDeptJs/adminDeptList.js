$(document).ready(function() {
    function populateTeamContainer(page) {
        $.ajax({
            url: '/adminDeptMngr/listData?page=' + page,
            type: 'GET',
            dataType: 'json',
            success: function(response) {
                $('#teamContainer').empty();
                var headerRow = '<div class="team-header">' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>팀 상태</div>' +
                    '<div>팀 생성일</div>' +
                    '<div>팀 변경일</div>' +
                    '<div>팀 수정</div>' +
                    '</div>';
                $('#teamContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="team-row">' +
                        '<div class="team-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="team-data list-body-low"><a href="/adminDeptMngr/detail?no=' + vo.code + '" class="team-link">' + vo.name + '</a></div>' +
                        '<div class="team-data list-body-low">' + vo.state + '</div>' +
                        '<div class="team-data list-body-low">' + vo.enrollDate + '</div>' +
                        '<div class="team-data list-body-low">' + vo.modifyDate + '</div>' +
                        '<div class="team-data list-body-low"><a href="/adminDeptMngr/edit?code=' + vo.code + '" class="team-link">수정</a></div>' +
                        '</div>';
                    $('#teamContainer').append(row);
                }

                $('#pagination').empty();
                var totalPages = response.totalPages;
                for (var i = 1; i <= totalPages; i++) {
                    var link = '<a href="#" data-page="' + i + '">' + i + '</a> ';
                    $('#pagination').append(link);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error fetching team data:', error);
            }
        });
    }

    // 초기 로딩 시 첫 페이지 데이터 로드
    populateTeamContainer(1);

    $(document).on('click', '#pagination a', function(e) {
        e.preventDefault();
        var page = $(this).data('page');
        populateTeamContainer(page);
    });
});
