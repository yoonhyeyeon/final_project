function modify01(){
  const projectNoValue = document.querySelector("#projectNo").value;
  const goalValue = document.querySelector("#goal").value;
  const personalScheduleValue = document.querySelector("#personalSchedule").value;
  
  $.ajax({
    url : "http://127.0.0.1:8080/kpi/modify",
    type : "post",
    data : {
      no : no ,
      projectNo : projectNoValue ,
      goal : goalValue ,
      personalSchedule : personalScheduleValue,
    },
    success : (x)=>{
      console.log("통신 성공");
      console.log(x);
    },
    fail : (x)=>{
      console.log("통신 실패");
    },
  });
}
