function colleage(no){

  $.ajax({
    url : "http://127.0.0.1:8383/evaluation/colleageData",
    type : "get",
    data : { no : no },
    success : (data)=>{
      console.log(data);
      console.log("조회 성공");

      const list = document.querySelector("#Item");
      let str = "";

      for( let i = 0; i < data.length; i++){
        str += `<div id='listItem' onclick="location.href='http://127.0.0.1:8383/colleageEval/write'">`;
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