$.ajax({
    url : "/project/listData",
    method : "get",
    data : {},
    success : function(x){
        const voList = x;
        const tbody = document.querySelector("#prjList");
        let str="";
        for(let i=0;i<voList.length;i++){
            str += "<tr class='list-item' data-id='"+voList[i].no + "'>";
            str += "<td>"+ voList[i].title + "</td>";
            str += "<td>"+ voList[i].pm + "</td>";
            str += "<td>" + voList[i].dept + "</td>";
            str += "<td>" + voList[i].state + "</td>";
            str += "<td>" + voList[i].startDate + "</td>";
            str += "<td>" + (voList[i].modifyDate !== null ? voList[i].modifyDate : "-") + "</td>";
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
        console.log("에러입니다.");
    },
});

const deptCodeVal = document.querySelector("#ingProjectData").value;
$.ajax({
    url : "http://127.0.0.1:8383/project/listData2",
    method : "get",
    data :{
        code : deptCodeVal
    },
    success : function(x){
        const tbody = document.querySelector("#personalTableBody1");
        let str="";
        for(let i=0;i<x.length;i++){
        str += "<tr class='list-item' data-id='"+x[i].no + "'>";
        str += "<td>"+ x[i].no + "</td>";
        str += "<td>"+ x[i].title + "</td>";
        str += "<td>" + x[i].startDate + "</td>";
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
        console.log("에러");
    },
});


$.ajax({
    url : "http://127.0.0.1:8383/project/listData3",
    method : "get",
    data :{
        code : deptCodeVal
    },
    success : function(x){
        const tbody = document.querySelector("#personalTableBody2");
        let str="";
        for(let i=0;i<x.length;i++){
        str += "<tr class='list-item' data-id='"+x[i].no + "'>";
        str += "<td>"+ x[i].no + "</td>";
        str += "<td>"+ x[i].title + "</td>";
        str += "<td>" + x[i].startDate + "</td>";
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
        console.log("에러");
    },
});