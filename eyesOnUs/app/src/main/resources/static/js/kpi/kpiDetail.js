function getParam(param) {
  const url = new URLSearchParams(window.location.search); //window.location.search : ? 뒤에 있는 값 가져옴
  return url.get(param);
}

$(document).ready(() => {
  const no = getParam("no");
  if (no) {
    $.ajax({
      url: "http://127.0.0.1:8383/kpi/detailData",
      type: "get",
      data: { no: no },
      success: (detailData) => {
        console.log("상세 정보 통신 성공");
        console.log(detailData);

        const x = document.querySelector(".out-list");
        const sub = document.querySelector("#btn01");

        let str = "";
        str += "<div class='out'>";
        str += "<div class='detail-item'>";
        str += "<h3>KPI 상세 정보</h3>";
        str += "<hr>";
        str += "<div class='detail-box'>";
        str += "<p id='no'> Number  : "+ detailData.no + "</p>";
        str += "<p id='projectNo'> 프로젝트 : " + detailData.title + "</p>";
        str += "<hr>";
        str += "<p>목표</p>";
        str += "<p id='goal'>" + detailData.goal + "</p>";
        str += "<p>개인 일정</p>";
        str += "<p id='personalSchedule'>" + detailData.personalSchedule + "</p>";
        str += "<p>집중도 " + detailData.focus + " % </p>";
        str += "<progress value='" + detailData.focus + "' max='100' id='focus'></progress>";
        str += "<p>시작 날짜</p>";
        str += "<p>"+ detailData.startDate + "</p>";
        str += "</div>";
        str += "</div>";
        str += "</div>";
        str += "<div class='btn-box'>";
        str += "<button id='btn01' data-id='" + detailData.no + "'>수정</button>";
        str += `<button id='btn02' onclick='del(${detailData.no});'>삭제</button>`;
        str += "</div>";

        x.innerHTML = str;

        document.querySelectorAll("#btn01").forEach((sub)=>{
          sub.addEventListener("click", ()=>{
            const no = sub.getAttribute("data-id");
           window.location.href="http://127.0.0.1:8383/kpi/modify?no="+no;
          });
        });

      },

      fail: () => {
        console.log("상세 조회 실패");
      },
    });
  }
});
