$.ajax({
    url : "http://127.0.0.1:8383/util/detailData",
    type : "get",
    success : (data)=>{
        console.log("통신 성공");
        console.log(data);

        const list = document.querySelector("thead");
        let str = "";

        str += "<tr>";
        str += "<td>출근</td>";
        str += "<td>"+ data.workTime + "</td>";
        str += "</tr>";
        str += "<tr>";
        str += "<td>퇴근</td>";
        str += "<td>" + data.quitTime + "</td>";
        str += "</tr>";
        str += "<tr>";
        str += "<td>총시간</td>";
        str += "<td>" + data.totalHours + "시간 " + data.totalMinutes + "분</td>";
        str += "</tr>"

        list.innerHTML = str;

    },
    fail : ()=>{
        console.log("통신 실패");
    },
});