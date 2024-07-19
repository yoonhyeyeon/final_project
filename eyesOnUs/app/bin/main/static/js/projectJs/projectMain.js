$.ajax({
  url : "/project/deptListData",
  method : "GET",
  data : {},
  success : function(x){
    console.log("담긴 값");
    console.log(x);

    const deptTag = document.querySelector("#personalTableBody2");
    const h1Title = document.querySelector("#h1Title");
    let str = "";
    let str2 = "";
    str2 += x[0].deptName
    for(let i = 0; i<x.length; i++){
      str += "<tr>";
      str += "<td>" + x[i].name +"</td>";
      str += "<td>" + x[i].positionName +"</td>";
      str += "<td>" + x[i].no +"</td>";
      str += "<td>" + x[i].state +"</td>";
      str += "</tr>";
    }
    deptTag.innerHTML = str;
    h1Title.innerHTML = str2;
  }
});