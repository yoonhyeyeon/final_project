
function getParam(param) {
  const url = new URLSearchParams(window.location.search); //window.location.search : ? 뒤에 있는 값 가져옴
  return url.get(param);
}

$(document).ready(() => {
  const no = getParam("no");
  const prjNo = getParam("projectNo");
  if (no) {

      $.ajax({
        url : "http://127.0.0.1:8383/kpi/detailData",
        type : "get",
        data : { no : no },
        success : (detailData)=>{
          console.log("통신 성공");
          console.log(detailData);

          const x = document.querySelector("#form");

          let str = "";
          str += "프로젝트 번호 : <select name='projectNo' id='projectNo' style='width:100px'>";
          str += "<option value=''>------선택------</option>";
          for( let i = 1; i <= 36; i++){
            str += "<option id='prjNo' value='"+i+"'>"+i+"</option>";
          }
          str += "</select>";
          str += "<br />";
          str += "목표";
          str += "<br>";
          str += "<textarea name='goal' id='goal'>"+detailData.goal+"</textarea>";
          str += "<br />";
          str += "<hr>";
          str += "개인 일정";
          str += "<br>";
          str += "<textarea name='personalSchedule' id='personalSchedule'>" + detailData.personalSchedule + "</textarea>";
          str += "<br />";
          str += "<p> 집중도 : "+detailData.focus+"</p>";
          str += "<br />";
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

    const goalValue = document.querySelector("#goal").value;
    const projectNoValue = document.querySelector("#projectNo").value;
    const personalScheduleValue = document.querySelector("#personalSchedule").value;
    $(document).ready(() => {
      const no = getParam("no");
      if (no) {
        $.ajax({
          url : "http://127.0.0.1:8383/kpi/modify",
          type : "post",
          data : {
            no : no ,
            projectNo : projectNoValue,
            goal : goalValue ,
            personalSchedule : personalScheduleValue ,
          } ,
          success : (data)=>{
            console.log(data);
            alert("수정 완료!");
            window.location.href = "http://127.0.0.1:8383/kpi/list";
          },
          error : (x)=>{
            console.log("오류");
          },
      });
    }
  })
}