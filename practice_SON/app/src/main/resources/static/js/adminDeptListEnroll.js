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
                    '<div>팀 코드</div>' +
                    '</div>';
                $('#teamContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="team-row">' +
                        '<div class="team-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="team-data list-body-low">' + vo.name + '</div>' +
                        '<div class="team-data">' + vo.code + '</div>';
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

$(document).ready(function() {
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
                    '<div>팀 코드</div>' +
                    '</div>';
                $('#teamContainer').append(headerRow);

                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="team-row list-body-row">' +
                        '<div class="team-data">' + vo.deptName + '</div>' +
                        '<div class="team-data">' + vo.name + '</div>' +
                        '<div class="team-data">' + vo.code + '</div>';
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
                console.error('Error fetching search results:', error);
            }
        });
    });

    $('#searchForm').submit();
});