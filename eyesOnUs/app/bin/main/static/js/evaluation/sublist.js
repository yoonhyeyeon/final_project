$.ajax({
  url : "/evaluation/listData2",
  type : "get",
  success : (data)=>{
    console.log("data2 : "+ data);
    console.log("조회 성공");

    const list = document.querySelector("#personalTableBody2");
    let str = "";

    for( let i = 0; i < data.length; i++ ){
        str += "<tr>";
        str += "<td>" + data[i].no + "</td>";
        str += "<td>" + data[i].name + "</td>";
        str += "<td>" + data[i].position + "</td>";
        str += "</tr>"
    }
    list.innerHTML = str;

  },
  fail : ()=>{
    console.log("통신 실패");
  },
});