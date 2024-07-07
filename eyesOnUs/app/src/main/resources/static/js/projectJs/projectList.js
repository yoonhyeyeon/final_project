$.ajax({
    url : "http://127.0.0.1:8383/project/listData",
    method : "get",
    data : {},
    success : function(x){
        const voList = x;
        const tbody = document.querySelector("tbody");
        let str="";
        for(let i=0;i<voList.length;i++){
            str += "<tr class='list-item' data-id='"+voList[i].no + "'>";
            str += "<td>"+ voList[i].title + "</td>";
            str += "<td>"+ voList[i].pm + "</td>";
            str += "<td>" + voList[i].dept + "</td>";
            str += "<td>" + voList[i].state + "</td>";
            str += "<td>" + voList[i].startDate + "</td>";
            str += "<td>" + voList[i].modifyDate + "</td>";
            str += "<td>" + voList[i].modifyDate + "</td>";
            str += "</tr>";
        }
        tbody.innerHTML = str;

        document.querySelectorAll(".list-item").forEach((tbody)=>{
            tbody.addEventListener("click", ()=>{
            const no = tbody.getAttribute("data-id");
            window.location.href="http://127.0.0.1:8383/project/detail?no="+no;
            });
        });
    },
    error : function(x){
        console.log("에러입니다.");
    },
});
