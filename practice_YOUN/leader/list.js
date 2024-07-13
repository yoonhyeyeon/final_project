$.ajax({
    url : "http://127.0.0.1:8383/workTime/detailData",
    type : "get",
    success : (data)=>{
        console.log("통신 성공");
        console.log(data);

        const list = document.querySelector("thead");
        let str = "";

        for( let i = 0; i < data.length ; i++ ){
            
            str += "<tr>";
            str += "<td>출근</td>";
            str += "<td>"+ data[i].workTime + "</td>";
            str += "</tr>";
            str += "<tr>";
            str += "<td>퇴근</td>";
            str += "<td>" + data[i].quitTime + "</td>";
            str += "</tr>";
            str += "<tr>";
            str += "<td>" + data[i].total + "</td>";
            str += "</tr>"
        }

        list.innerHTML = str;

    },
    fail : ()=>{
        console.log("통신 실패");
    },    
});