$(document).ready(function() {
    // 검색 폼 제출 시 데이터 로드
    $('#search-form').on('submit', function(event) {
        event.preventDefault();
        var empCategory = $('#empCategory').val();
        var searchBox = $('#searchBox').val();
        $.ajax({
            url: '/adminDeptMngr/searchData',
            type: 'POST',
            dataType: 'json',
            data: {
                empCategory: empCategory,
                searchBox: searchBox,
                page: 1,
            },
            success: function(response) {
                $('#teamContainer').empty();
                var headerRow = '<div class="team-header list-header-row">' +
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
                    var row = '<div class="team-row list-body-row">' +
                        '<div class="team-data">' + vo.deptName + '</div>' +
                        '<div class="team-data list-body-low"><a href="/adminDeptMngr/detail?no=' + vo.code + '" class="team-link">' + vo.name + '</a></div>' +
                        '<div class="team-data">' + vo.state + '</div>' +
                        '<div class="team-data">' + vo.enrollDate + '</div>' +
                        '<div class="team-data">' + vo.modifyDate + '</div>' +
                        '<div class="team-data"><a href="/adminDeptMngr/edit?code=' + vo.code + '" class="team-link">수정</a></div>' +
                        '</div>';
                    $('#teamContainer').append(row);
                }

                // 페이지네이션 처리
                $('#pagination').empty();
                var totalPages = response.totalPages;
                for (var i = 1; i <= totalPages; i++) {
                    var link = '<a href="#" data-page="' + i + '">' + i + '</a> ';
                    $('#pagination').append(link);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error fetching search results:', error);
            }
        });
    });

    // 초기 로딩 시 첫 페이지 데이터 로드
    $('#searchForm').submit(); // 페이지 로드 시 자동으로 첫 번째 검색 실행
});