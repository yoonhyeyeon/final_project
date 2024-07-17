function member(no){

  $.ajax({
    url : "/evaluation/memberEvalData",
    type : "get",
    data : { no : no },
    success : (data)=>{
      console.log(data);
      console.log("조회 성공");

      const list = document.querySelector("#Item");
      let str = "";

      for( let i = 0; i < data.length; i++){
        str += `<div id='listItem' onclick="location.href='/memberEval/write?evaluateeNo=${data[i].no}'">`;
        str += "<span>" + data[i].name + "</span>";
        str += "<span>" + data[i].dept + "</span>";
        str += "<span>" + data[i].division + "</span>";
        str += "<span>" + data[i].position + "</span>";
        str += "</div>";
      }

      list.innerHTML = str;

    },
    fail : ()=>{
      console.log("조회 실패");
    },
  });

}