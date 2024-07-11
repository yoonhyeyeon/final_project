$.ajax({
  url : "http://127.0.0.1:8383/attendance/listData",
  type : "get",
  success : (data)=>{
    console.log("통신 성공");
    console.log(data);

    const list = document.querySelector("#list");
    console.log(list);

    let str = "";

    for(let i = 0; i < data.length; i++){
      str += "<div id='listBody'>";
      str += "<span>" + data[i].workDate + "</span>";
      str += "<span>" + data[i].workDay + "</span>";
      str += "<span>" + data[i].workTime + "</span>";
      str += "<span>" + data[i].quitTime + "</span>";
      str += "<span>" + data[i].totalHours + "시간 " + data[i].totalMinutes + "분" + "</span>";
      str += "<span>" + "출근" + "</span>";
    }

    list.innerHTML = str;

  },
  fail : ()=>{
    console.log("통신 실패");
  },
});

$.ajax({
  url : "http://127.0.0.1:8383/attendance/listData",
  type : "get",
  success : (data)=>{
    console.log("통신 성공");
    console.log(data);

    const list = document.querySelector("#list");
    console.log(list);

    let str = "";

    for(let i = 0; i < data.length; i++){
      str += "<div id='listBody'>";
      str += "<span>" + data[i].workDate + "</span>";
      str += "<span>(" + data[i].workDay + ")</span>";
      str += "<span>" + data[i].workTime + "</span>";
      str += "<span>" + data[i].quitTime + "</span>";
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


$.ajax({
  url : "http://127.0.0.1:8383/attendance/noData",
  type : "get",
  success : (data)=>{
    console.log("통신 성공");
    console.log(data);

    const list = document.querySelector("#list");
    console.log(list);

    let str = "";

    for(let i = 0; i < data.length; i++){
      str += "<div id='listBody'>";
      str += "<span>" + data[i].workDate + "</span>";
      str += "<span>(" + data[i].workDay + ")</span>";
      str += "<span>" + data[i].workTime + "</span>";
      str += "<span>" + data[i].quitTime + "</span>";
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