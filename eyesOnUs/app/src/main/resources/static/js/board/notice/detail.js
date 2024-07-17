function getParam(param) {
  const url = new URLSearchParams(window.location.search); //window.location.search : ? 뒤에 있는 값 가져옴
  return url.get(param);
}

$(document).ready(() => {
  const no = getParam("no");
  if (no) {
      $.ajax({
        url : "/notice/detailData",
        method : "get",
        data : { no : no },
        success : (detailData)=>{
          console.log("상세조회 성공");
          console.log(detailData);

          const list = document.querySelector(".out-list");
          let str = "";

          str += "<div class='out'>";
          str += "<div class='detail-item'>";
          str += "<h3>공지사항</h3>";
          str += "<hr>";
          str += "<div class='detail-box'>";
          str += "<p id='no'> Number  : "+ detailData.no + "</p>";
          str += "<p id='title'> 제목 : " + detailData.title + "</p>";
          str += "<hr>";
          str += "<p id='hit'>조회수 : " + detailData.hit + "</p>";
          str += "<p>내용</p>";
          str += "<p id='content'>" + detailData.content + "</p>";
          str += "<p>등록 날짜</p>";
          str += "<p>"+ detailData.enrollDate + "</p>";
          str += "</div>";
          str += "</div>";
          str += "</div>";
          str += "<div class='btn-box'>";
          str += "<button id='btn01' data-id='" + detailData.no + "'>수정</button>";
          str += `<button id='btn02' onclick='del(${detailData.no});'>삭제</button>`;
          str += "</div>";

          list.innerHTML = str;

          document.querySelectorAll("#btn01").forEach((sub)=>{
            sub.addEventListener("click" , ()=>{
              const no = sub.getAttribute("data-id");
              location.href="/notice/modify?no="+no;
            });
          });
        },
        fail : ()=>{
          console.log("상세조회 실패");
        },
      });
 }
});


