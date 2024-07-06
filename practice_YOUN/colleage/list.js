$.ajax({
    url : "http://127.0.0.1:8383/colleageEval/listData",
    type : "get",
    success : (data)=>{
        console.log(data);
        console.log("목록 조회 성공");

        const list = document.querySelector("tbody");
        let str = "";

        for(let i = 0; i < data.length ; i++){
            str += "<tr>";
            str += "<td>" + data[i].no + "</td>";
            str += "<td>" + data[i].evaluateeNo + "</td>";
            str += "<td>" + data[i].potential + "</td>";
            str += "<td>" + data[i].communication + "</td>";
            str += "<td>" + data[i].problemSolve + "</td>";
            str += "<td>" + data[i].responsibility + "</td>";
            str += "<td>" + data[i].compliment + "</td>";
            str += "<td>" + data[i].disappointment + "</td>";
            str += "<td>" + data[i].suggestion + "</td>";
            str += "<td>" + data[i].writeDate + "</td>";
            str += "</tr>";

        }
        list.innerHTML = str;
        location.href="http://127.0.0.1:8383/colleageEval/list";
    },
    fail : ()=>{
        console.log("목록 조회 실패");
    },
});