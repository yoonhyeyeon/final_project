$.ajax({
    url : "http://127.0.0.1:8383/project/record/listData",
    method : "get",
    data : {},
    success : function(x){
        const tbody = document.querySelector("#recordList");
        let str="";
        for(let i=0;i<x.length;i++){
            str += "<tr class='list-item' data-id='"+x[i].no + "'>";
            str += "<td>"+ x[i].prjNo + "</td>";
            str += "<td>"+ x[i].title + "</td>";
            str += "<td>" + x[i].enlDate + "</td>";
            str += "</tr>";
        }
        tbody.innerHTML = str;

        document.querySelectorAll(".list-item").forEach((tbody)=>{
            tbody.addEventListener("click", ()=>{
            const no = tbody.getAttribute("data-id");
            window.location.href="http://127.0.0.1:8383/project/record/detail?no="+no;
            });
        });
    },
    error : function(x){
        console.log("에러입니다.");
    },
});