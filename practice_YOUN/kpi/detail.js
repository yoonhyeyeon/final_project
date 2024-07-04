function getKpiByNo(evt){
  const KpiNo = evt.target.parentNode.children[0].innerHTML;

  $.ajax({
    url : "http://127.0.0.1:8080/kpi/detail",
    type : "GET",
    data : { no : KpiNo } ,
    success : (data)=>{
      console.log("통신성공");
      console.log(data);
      
      // const x = document.querySelector("table > tbody");
  
      // let str = "";
      // str += "<td>" + data.no + "</td>"
      // str += "<td>" + data.projectNo + "</td>"
      // str += "<td>" + data.goal + "</td>"
      // str += "<td>" + data.personalSchedule + "</td>"
      // str += "<td>" + data.focus + "</td>"
      // x.innerHTML = str;

      const tdTag = document.createElement("td");
      const textNode01 = document.createTextNode(data.no);
      tdTag.appendChild(textNode01);

      const tdTag02 = document.createElement("td");
      const textNode02 = document.createTextNode(data.projectNo);
      tdTag02.appendChild(textNode02);

      const tdTag03 = document.createElement("td");
      const textNode03 = document.createTextNode(data.goal);
      tdTag03.appendChild(textNode03);

      const tdTag04 = document.createElement("td");
      const textNode04 = document.createTextNode(data.personalSchedule);
      tdTag04.appendChild(textNode04);

      const tdTag05 = document.createElement("td");
      const textNode05 = document.createTextNode(data.focus);
      tdTag05.appendChild(textNode05);

      const tbody = document.querySelector("#detail");
      tbody.innerHTML = "";
      tbody.appendChild(tdTag);
      tbody.appendChild(tdTag02);
      tbody.appendChild(tdTag03);
      tbody.appendChild(tdTag04);
      tbody.appendChild(tdTag05);

    },
    fail : ()=>{
      console.log("통신 실패");
    },
  });

}

