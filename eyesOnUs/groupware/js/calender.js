// 오늘 날짜 가져오기
let today = new Date();
let thisMonth = today.getMonth();
let thisMonthInput = today.getMonth() + 1; // 0부터 시작하기 때문에 1을 더해줌
thisMonthInput = thisMonthInput < 10 ? '0' + thisMonthInput : thisMonthInput; // 년월 형식에 맞게 0을 붙여줍니다.
let todayDate = today.getDate();
let thisYear = today.getFullYear();

// 현재 년월을 input에 설정
document.getElementById('currentMonth').value = `${thisYear}-${thisMonthInput}`;

// 달력 생성 함수 수정
function generateCalendar(year, month) {
    // 요일 배열
    const weekdays = ['일', '월', '화', '수', '목', '금', '토'];

    // calendar 요소가 이미 있다면 내용을 지움
    let calendar = document.getElementById('calendar');
    calendar.innerHTML = '';

    // 오늘 연원일 표시
    let todayDiv = document.getElementById('today');
    let todayYearMonth = today.getFullYear() + '.' + (today.getMonth() + 1).toString().padStart(2, '0');
    todayDiv.textContent = todayYearMonth;

    // 해당 월의 첫 번째 날의 요일 가져오기
    let firstDayOfMonth = new Date(year, month, 1);
    let startingDay = firstDayOfMonth.getDay();

    // 월의 마지막 날짜 가져오기
    let lastDayOfMonth = new Date(year, month + 1, 0);
    let lastDate = lastDayOfMonth.getDate();

    // 이전 달의 마지막 날짜 가져오기
    let lastDayOfLastMonth = new Date(year, month, 0);
    let lastDateOfLastMonth = lastDayOfLastMonth.getDate();

    // 달력에 날짜 추가
    let dayElement, date;
    for (let j = 0; j < 7; j++) {
        dayElement = document.createElement('div');
        dayElement.textContent = weekdays[j];
        dayElement.classList.add('day', 'header-day');
        calendar.appendChild(dayElement);
    }

    for (let i = 0; i < 42; i++) {
        dayElement = document.createElement('div');
        if (i < startingDay) {
            // 이전 달 날짜 표시
            date = lastDateOfLastMonth - startingDay + i + 1;
            let prevMonth = month === 0 ? 11 : month - 1; // 이전 달
            let prevMonthYear = month === 0 ? year - 1 : year;
            let dateId = prevMonthYear + '-' + ((prevMonth + 1 < 10) ? '0' + (prevMonth + 1) : (prevMonth + 1)) + '-' + (date < 10 ? '0' + date : date);
            dayElement.textContent = date;
            dayElement.classList.add('day', 'disabled');
            dayElement.id = dateId;
        } else if (i >= startingDay + lastDate) {
            // 다음 달 날짜 표시
            date = i - startingDay - lastDate + 1;
            let nextMonth = month === 11 ? 0 : month + 1; // 다음 달
            let nextMonthYear = month === 11 ? year + 1 : year;
            let dateId = nextMonthYear + '-' + ((nextMonth + 1 < 10) ? '0' + (nextMonth + 1) : (nextMonth + 1)) + '-' + (date < 10 ? '0' + date : date);
            dayElement.textContent = date;
            dayElement.classList.add('day', 'disabled');
            dayElement.id = dateId;
        } else {
            // 현재 월 날짜 표시
            date = i - startingDay + 1;
            dayElement.textContent = date;
            dayElement.classList.add('day');
            let currentDate = new Date(year, month, date); // 현재 날짜 객체 생성
            if (currentDate.toDateString() === today.toDateString()) { // 현재 날짜와 같은지 비교
                dayElement.classList.add('today');
            }
            // 현재 월의 날짜인 경우 아이디 설정
            let dateId = year + '-' + ((month + 1 < 10) ? '0' + (month + 1) : (month + 1)) + '-' + (date < 10 ? '0' + date : date);
            dayElement.id = dateId;
        }

        calendar.appendChild(dayElement);

        // 클릭 이벤트 리스너 추가
        dayElement.addEventListener('click', function () {
            // sidebar 요소의 클래스를 확인합니다.
            let sidebar = document.getElementById('sidebar');
            if (!sidebar.classList.contains('active')) {
                // 팝업 요소를 가져와서 보이도록 설정합니다.
                let popUp = document.getElementById('popUp');
                popUp.style.display = "block";

                // 클릭된 날짜를 가져옵니다.
                let clickedDate = this.id;

                // 날짜를 연, 월, 일로 분리합니다.
                let [year, month, day] = clickedDate.split('-');

                // 클릭된 날짜의 요일을 가져옵니다.
                let clickedDay = new Date(year, month - 1, day).getDay();
                let weekdays = ['일', '월', '화', '수', '목', '금', '토'];
                let dayOfWeek = weekdays[clickedDay];

                // 팝업의 날짜와 요일에 클릭된 날짜를 적용합니다.
                let popUpDate = document.getElementById('popUpDate');
                popUpDate.textContent = year + '년 ' + month + '월 ' + day + '일 ' + '(' + dayOfWeek + ')';
            }
        });
    }
}

// 팝업된 div 닫기 버튼
document.addEventListener("DOMContentLoaded", function () {
    // 모든 클래스가 "closeDivBtn"인 버튼에 대해 반복합니다.
    var closeBtns = document.querySelectorAll(".closeDivBtn");
    closeBtns.forEach(function (btn) {
        // 각 버튼에 클릭 이벤트 리스너를 추가합니다.
        btn.addEventListener("click", function () {
            // 클릭된 버튼의 부모 요소인 div를 숨깁니다.
            this.parentNode.style.display = "none";
        });
    });
});


// 달력 다시 생성 함수 정의
function regenerateCalendar(year, month) {
    // 달력 다시 생성
    generateCalendar(year, month);
    // 연 월 업데이트
    let todayDiv = document.getElementById('today');
    if (todayDiv) {
        todayDiv.textContent = year + '. ' + (month + 1);
    }
}

// 이전 월 버튼 이벤트 설정
document.getElementById('lastMonthBtn').addEventListener('click', function () {
    // 이전 월 계산
    thisMonth--;
    if (thisMonth < 0) {
        thisMonth = 11;
        thisYear--;
    }
    // 달력 다시 생성 및 연 월 업데이트
    regenerateCalendar(thisYear, thisMonth);
    // input type="month"의 연월 업데이트
    document.getElementById('currentMonth').value = `${thisYear}-${(thisMonth + 1).toString().padStart(2, '0')}`;
});

// 다음 월 버튼 이벤트 설정
document.getElementById('nextMonthBtn').addEventListener('click', function () {
    // 다음 월 계산
    thisMonth++;
    if (thisMonth > 11) {
        thisMonth = 0;
        thisYear++;
    }
    // 달력 다시 생성 및 연 월 업데이트
    regenerateCalendar(thisYear, thisMonth);
    // input type="month"의 연월 업데이트
    document.getElementById('currentMonth').value = `${thisYear}-${(thisMonth + 1).toString().padStart(2, '0')}`;
});

// 초기 달력 생성
generateCalendar(thisYear, thisMonth);

// 초기 달력 생성시 연 월 업데이트
let todayDiv = document.getElementById('today');
if (todayDiv) {
    todayDiv.textContent = thisYear + '. ' + (thisMonth + 1);
}

// 현재 년월을 input에 설정
document.getElementById('currentMonth').value = `${thisYear}-${thisMonthInput}`;

document.getElementById('currentMonth').addEventListener('change', function () {
    // 선택된 월 가져오기
    let selectedMonth = this.value;

    if (selectedMonth) {
        let [selectedYear, selectedMonthInput] = selectedMonth.split('-');
        selectedMonthInput = parseInt(selectedMonthInput) - 1; // JavaScript의 Date 객체에서 월은 0부터 시작하므로 1을 뺍니다.

        // 달력 다시 생성 및 연 월 업데이트
        regenerateCalendar(parseInt(selectedYear), selectedMonthInput);
    } else {
        // 월을 선택하지 않은 경우 현재 날짜 기준으로 달력 생성
        let today = new Date();
        let year = today.getFullYear();
        let month = today.getMonth();

        // 달력 다시 생성 및 연 월 업데이트
        regenerateCalendar(year, month);
    }
});


// 슬라이드 이벤트 처리
let container = document.getElementById('container');
let startX, moveX;

container.addEventListener('touchstart', function (event) {
    startX = event.touches[0].clientX;
    moveX = 0; // 초기화
});

container.addEventListener('touchmove', function (event) {
    let currentX = event.touches[0].clientX;
    moveX = currentX - startX;

    // 좌우 이동 제한 설정
    if (moveX > 50) {
        moveX = 50;
    } else if (moveX < -50) {
        moveX = -50;
    }
});

container.addEventListener('touchend', function () {
    if (moveX > 15) {
        thisMonth--;
        if (thisMonth < 0) {
            thisMonth = 11;
            thisYear--;
        }
    } else if (moveX < -15) {
        thisMonth++;
        if (thisMonth > 11) {
            thisMonth = 0;
            thisYear++;
        }
    }
    regenerateCalendar(thisYear, thisMonth);
    document.getElementById('currentMonth').value = `${thisYear}-${(thisMonth + 1).toString().padStart(2, '0')}`;
});

// 초기 달력 설정
regenerateCalendar(thisYear, thisMonth);
document.getElementById('currentMonth').value = `${thisYear}-${thisMonthInput}`;


// 버튼 클릭 이벤트 설정
document.getElementById('anniversaryBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('scheduleBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('todoBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('diaryBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('accountBoardBtn').addEventListener('click', toggleBoard);

// div 토글 함수 정의
function toggleBoard() {
    // 모든 보드 숨기기
    hideAllBoards();

    // 클릭된 버튼에 해당하는 보드 보이기
    let boardId = this.id.replace("Btn", "");
    let board = document.getElementById(boardId);
    if (board) {
        board.style.display = 'block';
    } else {
        console.error('Board not found:', boardId);
    }
}

// 모든 보드 숨기는 함수 정의
function hideAllBoards() {
    let boards = document.querySelectorAll('.board');
    boards.forEach(board => {
        board.style.display = 'none';
    });
}
