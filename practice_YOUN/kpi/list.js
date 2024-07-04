
  $.ajax({
    url : "http://127.0.0.1:8080/kpi/list",
    type : "GET",
    success : (data)=>{
      console.log("통신 성공");
      console.log(data);
  
      const x = document.querySelector("#list");
      console.log(x);
  
      let str = "";
  
      for( let i = 0; i < data.length; i++){
        str += "<tr>";
        str += "<th>" + data[i].no + "</th>";
        str += "<th>" + data[i].projectNo + "</th>";
        str += "<th>" + data[i].focus + "% </th>";
        str += "<th>" + data[i].startDate + "</th>";
        str += "<th>" + data[i].endDate + "</th>";
        str += "</tr>"
        x.innerHTML = str;
      }
  
    },
    fail : ()=>{
      console.log("통신 실패");
    },
  });

