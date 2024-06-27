$(document).ready(function() {
    // 함수: 사원 목록 데이터 로드 및 페이지네이션 생성
    function populateEmpContainer(page) {
        $.ajax({
            url: '/adminEmpMngr/listData?page=' + page,
            type: 'GET',
            dataType: 'json',
            success: function(response) {
                $('#empContainer').empty();
                var headerRow = '<div class="emp-header list-header-row">' +
                    '<div>사원번호</div>' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>직급</div>' +
                    '<div>이름</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="emp-row list-body-row">' +
                         `<div class="emp-data list-body-low"><a class="team-link" href="/adminEmpMngr/detail?no=${vo.no}">${vo.no}</a></div>` +
                        '<div class="emp-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.divName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.positionName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.name + '</div>' +
                        '</div>';
                    $('#empContainer').append(row);
                }

                // 페이지네이션 생성
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
        // 현재 페이지 표시
        $('#pagination').find(`[data-page="${currentPage}"]`).addClass('current-page');
    }

    // 초기 로딩 시 첫 번째 페이지 데이터 로드
    populateEmpContainer(1);

    // 페이지네이션 클릭 시 데이터 로드
    $(document).on('click', '#pagination .page-link', function(e) {
        e.preventDefault();
        var page = $(this).data('page');
        populateEmpContainer(page);
    });

    // 검색 폼 제출 시 데이터 로드
    $('#search-form').on('submit', function(event) {
        event.preventDefault();
        var empCategory = $('#empCategory').val();
        var searchBox = $('#searchBox').val();
        $.ajax({
            url: '/adminEmpMngr/searchData',
            type: 'POST',
            dataType: 'json',
            data: {
                empCategory: empCategory,
                searchBox: searchBox,
                page: 1, // 검색 후 첫 번째 페이지 로드
            },
            success: function(response) {
                $('#empContainer').empty();
                var headerRow = '<div class="emp-header list-header-row">' +
                    '<div>사원번호</div>' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>직급</div>' +
                    '<div>이름</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="emp-row list-body-row">' +
                         `<div class="emp-data list-body-low"><a class="team-link" href="/adminEmpMngr/detail?no=${vo.no}">${vo.no}</a></div>` +
                        '<div class="emp-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.divName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.positionName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.name + '</div>' +
                        '</div>';
                    $('#empContainer').append(row);
                }

                // 페이지네이션 생성
                createPagination(response.totalPages, 1); // 검색 후 첫 번째 페이지 기준으로 생성
            },
            error: function(xhr, status, error) {
                console.error('Error fetching search results:', error);
            }
        });
    });
});
