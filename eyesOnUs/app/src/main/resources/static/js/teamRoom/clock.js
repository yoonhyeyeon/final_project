// 현재 시간을 표시하는 함수
function updateTime() {
    var now = new Date();
    var timeString = now.toLocaleTimeString();
    document.getElementById("time").innerText = timeString;
}

// 페이지 로드 시 시간 업데이트
updateTime();

// 매 초마다 시간 업데이트
setInterval(updateTime, 1000);