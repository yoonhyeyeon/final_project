document.addEventListener("DOMContentLoaded", function () {
    const table = document.getElementById("teamList-table");

    // 서버에서 팀원 목록 데이터를 가져오는 함수
    function fetchTeamList() {
        $.ajax({
            url: 'api/teamRoom/listData',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.length > 0) {
                    displayTable(data);
                } else {
                    table.innerHTML = "<tr><td colspan='2'>로그인이 필요합니다.</td></tr>";
                }
            },
            error: function (xhr, status, error) {
                console.error('Error:', error);
                table.innerHTML = "<tr><td colspan='2'>로그인 후 이용가능한 기능.</td></tr>";
            }
        });
    }

    // 팀원 목록 데이터를 테이블에 표시하는 함수
    function displayTable(data) {
        table.innerHTML = ""; // 테이블 초기화

        // 테이블 헤더 추가
        const header = table.createTHead();
        const headerRow = header.insertRow(0);
        const nameHeader = document.createElement("td");
        nameHeader.textContent = "이름";
        const phoneHeader = document.createElement("td"); // 헤더 이름 변경
        phoneHeader.textContent = "전화번호"; // 헤더 텍스트 변경
        headerRow.appendChild(nameHeader);
        headerRow.appendChild(phoneHeader);

        // 테이블 바디 추가
        const tbody = table.createTBody();
        data.forEach(item => {
            const row = tbody.insertRow();
            const nameCell = row.insertCell();
            const phoneCell = row.insertCell(); // 셀 이름 변경
            nameCell.textContent = item.name;
            phoneCell.textContent = item.phone; // 데이터 속성 변경
        });
    }

    // 페이지 로드 시 데이터 가져오기
    fetchTeamList();
});
