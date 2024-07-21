function monthData() {
    const month = document.querySelector("#month").value;

    $.ajax({
      url : "http://127.0.0.1:8383/attendance/listData",
      type : "get",
      data: { month: month },
      success : (data)=>{
        console.log("통신 성공");
        console.log(data);

        const list = document.querySelector("#list");
        console.log(list);

        let str = "";

        const title = document.querySelector("#listHead");
        console.log(title);

        let str2 = "";

        str2 += "<span>" + data[0].emp + "</span>";
        str2 += "<span>" + data[0].position + "</span>";
        str2 += "<span>(" + data[0].division + ")</span>";

        title.innerHTML = str2;

        for(let i = 0; i < data.length; i++){
          str += "<div id='listBody'>";
          str += "<span>" + data[i].workDate + "</span>";
          str += "<span>(" + data[i].workDay + ")</span>";
          str += "<span>" + data[i].workTime + "</span>";
          str += "<span>" + (data[i].quitTime !== null ? data[i].quitTime : "미등록") + "</span>";
          str += "<span>" + data[i].totalHours + "시간 " + data[i].totalMinutes + "분" + "</span>";
          str += "<span>" + data[i].attend + "</span>";
          str += "</div>";
        }

        list.innerHTML = str;

      },
      fail : ()=>{
        console.log("통신 실패");
      },
    });

}