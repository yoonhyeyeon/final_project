function getParam(param) {
  const url = new URLSearchParams(window.location.search); //window.location.search : ? 뒤에 있는 값 가져옴
  return url.get(param);
}

$(document).ready(() => {
  const no = getParam("no");
  if (no) {

      $.ajax({
        url : "http://127.0.0.1:8383/notice/detailData",
        type : "get",
        data : { no : no },
        success : (detailData)=>{
          console.log("통신 성공");
          console.log(detailData);

          const x = document.querySelector("#form");

          let str = "";
          str += "<p>Number : " + detailData.no + "</p>"
          str += "<p id='hit'>조회수 : " + detailData.hit + "</p>";
          str += "제목";
          str += "<textarea name='title' id='title'>"+detailData.title+"</textarea>";
          str += "<br />";
          str += "<hr>";
          str += "내용";
          str += "<br />";
          str += "<textarea name='content' id='content'>" + detailData.content + "</textarea>";
          str += "<br />";
          str += "<p> 등록날짜 : "+detailData.enrollDate+"</p>";
          str += "<br />";
          str += "<div class='submit-bar'>";
          str += "<button onclick='modify01();' id='submit'>수정하기</button>";
          str += "</div>";

          x.innerHTML = str;

        },
        fail : (x)=>{
          console.log("통신 실패");
        },
      });
  }
 });

function modify01(){

  const titleValue = document.querySelector("#title").value;
  const contentValue = document.querySelector("#content").value;
  const hitValue = document.querySelector("#hit").value;

  $(document).ready(() => {
    const no = getParam("no");
    if(no){
      $.ajax({
        url : "http://127.0.0.1:8383/notice/modify",
        type : "post",
        data : {
          no : no ,
          title : titleValue ,
          content : contentValue ,
          hit : hitValue,
        },
        success : (data)=>{
          console.log(data);
          alert("수정 완료");
          location.href = "http://127.0.0.1:8383/notice/list";
        },
        fail : ()=>{
          console.log("수정 실패");
        },
      });
    }
  })
}
