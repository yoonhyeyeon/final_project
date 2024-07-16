$(document).ready(function() {
    sessionStorage.setItem('currentPage', window.location.href);
    function populateEmpContainer(page) {
        $.ajax({
            url: '/message/messageSendListData?page=' + page,
            type: 'GET',
            dataType: 'json',
            success: function(response) {
                $('#empContainer').empty();
                var headerRow = '<div class="msg-header list-header-row">' +
                    '<div>시간</div>' +
                    '<div>제목</div>' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>직급</div>' +
                    '<div>수신인</div>' +
                    '<div>읽음</div>' +
                    '<div>삭제</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var readStatus = (vo.readYn === 'Y') ? '읽음' : '읽기 전';
                    var row = '<div class="msg-list-row list-body-row">' +
                        '<div class="emp-data list-body-low">' + vo.sendTime + '</div>' +
                        `<div class="emp-data list-body-low"><a class="team-link" href="/message/messageDetail?no=${vo.no}">${vo.title}</a></div>` +
                        '<div class="emp-data list-body-low">' + vo.receiverDeptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverDivName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverPositionName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverName + '</div>' +
                        '<div class="emp-data list-body-low">' + readStatus + '</div>' +
                        '<div class="emp-data list-body-low">' + `<button class="team-link delete-message-btn" id="delete-receive-message" data-no="${vo.no}">삭제</button>` +'</div>' +
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

    function createPagination(totalPages, currentPage) {
        $('#pagination').empty();
        for (var i = 1; i <= totalPages; i++) {
            var link = `<a href="#" class="page-link" data-page="${i}">${i}</a> `;
            $('#pagination').append(link);
        }
        $('#pagination').find(`[data-page="${currentPage}"]`).addClass('current-page');
    }

    populateEmpContainer(1);

    $(document).on('click', '#pagination .page-link', function(e) {
        e.preventDefault();
        var page = $(this).data('page');
        populateEmpContainer(page);
    });
});

$(document).ready(function() {
    $('#search-form').on('submit', function(event) {
        event.preventDefault();
        var empCategory = $('#empCategory').val();
        var searchBox = $('#searchBox').val();
        $.ajax({
            url: '/message/messageSendListSearchData',
            type: 'POST',
            dataType: 'json',
            data: {
                empCategory: empCategory,
                searchBox: searchBox,
                page: 1, // 검색 후 첫 번째 페이지 로드
            },
            success: function(response) {
                $('#empContainer').empty();
                var headerRow = '<div class="msg-header list-header-row">' +
                    '<div>시간</div>' +
                    '<div>제목</div>' +
                    '<div>부서명</div>' +
                    '<div>팀명</div>' +
                    '<div>직급</div>' +
                    '<div>수신인</div>' +
                    '<div>읽음</div>' +
                    '<div>삭제</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var readStatus = (vo.readYn === 'Y') ? '읽음' : '읽기 전';
                    var row = '<div class="msg-list-row list-body-row">' +
                        '<div class="emp-data list-body-low">' + vo.sendTime + '</div>' +
                        `<div class="emp-data list-body-low"><a class="team-link" href="/message/messageDetail?no=${vo.no}">${vo.title}</a></div>` +
                        '<div class="emp-data list-body-low">' + vo.receiverDeptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverDivName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverPositionName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.receiverName + '</div>' +
                        '<div class="emp-data list-body-low">' + readStatus + '</div>' +
                        '<div class="emp-data list-body-low">' + `<button class="team-link delete-message-btn" id="delete-receive-message" data-no="${vo.no}">삭제</button>` +'</div>' +
                        '</div>';
                    $('#empContainer').append(row);
                }

                createPagination(response.totalPages, 1); // 검색 후 첫 번째 페이지 기준으로 생성
            },
            error: function(xhr, status, error) {
                console.error('Error fetching search results:', error);
            }
        });
    });

    function createPagination(totalPages, currentPage) {
        $('#pagination').empty();
        for (var i = 1; i <= totalPages; i++) {
            var link = `<a href="#" class="page-link" data-page="${i}">${i}</a> `;
            $('#pagination').append(link);
        }
        $('#pagination').find(`[data-page="${currentPage}"]`).addClass('current-page');
    }
});
