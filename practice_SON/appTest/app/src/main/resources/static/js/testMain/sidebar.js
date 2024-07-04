const btnTag = document.querySelector("#sidebarBtn");
const sidebar = document.querySelector(".sidebar");

btnTag.addEventListener("click", e => {
  e.stopPropagation(); // 이벤트 전파를 막음
  sidebar.classList.toggle("active");
});

//사이드바 영역 이외 클릭/터치 시 닫기
document.addEventListener("click", function(e) {
  // 사이드바 영역 외의 영역을 클릭했을 때
  if (!sidebar.contains(e.target) && e.target !== btnTag) {
    // 사이드바가 열려있는지 확인하고 열려 있다면 닫습니다.
    if (sidebar.classList.contains("active")) {
      sidebar.classList.remove("active");
    }
  }
});
