// 사이드바 버튼
const btnTag = document.querySelector("#sidebarBtn");
// 사이드바
const sidebar = document.querySelector("#sidebar");

//클릭 이벤트
document.addEventListener("click", function(e) {
    // 클릭한 요소가 사이드바 내부가 아니고 버튼 내부도 아닐 때
    if (!sidebar.contains(e.target) && e.target !== btnTag) {
        // 사이드바를 닫는다.
        sidebar.classList.remove("active");
    // 그게 아니라면
    } else {
        // 버튼을 클릭한 경우 사이드바를 토글한다.
        sidebar.classList.toggle("active");
    }
});
