function saerchName(){
    const titleVal = document.querySelector("input[name=title]").value;
    $.ajax({
        url : "/project/searchByName",
        method : "get",
        data :{
            title : titleVal
        },
        success : function(x){
            const tbody = document.querySelector("#prjList");
            let str="";
            for(let i=0;i<x.length;i++){
            str += "<tr class='list-item' data-id='"+x[i].no + "'>";
            str += "<td>"+ x[i].title + "</td>";
            str += "<td>"+ x[i].pm + "</td>";
            str += "<td>" + x[i].dept + "</td>";
            str += "<td>" + x[i].state + "</td>";
            str += "<td>" + x[i].startDate + "</td>";
            str += "<td>" + x[i].modifyDate + "</td>";
            str += "</tr>";
        }
        tbody.innerHTML = str;

        document.querySelectorAll(".list-item").forEach((tbody)=>{
            tbody.addEventListener("click", ()=>{
            const no = tbody.getAttribute("data-id");
            window.location.href="/project/detail?no="+no;
            });
        });
        },
        error : function(x){
            console.log("에러");
        },
    });
}