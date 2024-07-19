$(document).ready(function() {
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
                    '<div>선택</div>' +
                    '</div>';
                $('#empContainer').append(headerRow);
                var voList = response.voList;
                for (var i = 0; i < voList.length; i++) {
                    var vo = voList[i];
                    var row = '<div class="emp-row list-body-row">' +
                        '<div class="emp-data list-body-low">' + vo.no + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.deptName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.divName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.positionName + '</div>' +
                        '<div class="emp-data list-body-low">' + vo.name + '</div>' +
                        '<div class="emp-data list-body-low">' + '<input type="checkbox" class="select" data-no="' + vo.no + '" data-name="' + vo.name + '">' + '</div>' +
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

    // 체크박스 선택시 사원번호, 이름 전송, 다른 체크박스 비활성화
    $(document).on('change', '.select', function() {
        if ($(this).is(':checked')) {
            $('.select').not(this).prop('disabled', true); // 다른 체크박스 비활성화
            $('input[name="receiverNo"]').val($(this).data('no')); // 사원번호 입력
            $('input[name="receiverName"]').val($(this).data('name')); // 사원이름 입력
        } else {
            $('.select').prop('disabled', false); // 체크 해제 시 모든 체크박스 활성화
            $('input[name="receiverNo"]').val(''); // receiverNo 필드 비우기
            $('input[name="receiverName"]').val(''); // receiverName 필드 비우기
        }
    });
});
