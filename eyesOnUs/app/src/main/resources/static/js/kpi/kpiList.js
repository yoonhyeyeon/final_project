  $.ajax({
    url: "http://127.0.0.1:8080/kpi/listData",
    type: "GET",
    success: (data) => {
      console.log("통신 성공");
      console.log(data);

      const x = document.querySelector(".list-box");
      console.log(x);

      let str = "";

      for (let i = 0; i < data.length; i++) {
        str += "<div class='list-item' data-id='" + data[i].no + "'>";
        str += "<p id='no'> Number : " + data[i].no + "</p>";
        str += "<p id='projectNo'> 프로젝트 번호 : " + data[i].projectNo + "</p>";
        str += "<p id='projectName'> " + data[i].title + "</p>";
        str += "<span id='focus-name'> 집중도 : " + data[i].focus + " % </span>";
        str += "<progress value ='"+ data[i].focus +"' max='100' id='focus'></progress>";
        str += "<p id='data'> 시작일 : " + data[i].startDate + "</p>";
        str += "</div>";
      }
      x.innerHTML = str;

    document.querySelectorAll(".list-item").forEach((x)=>{
      x.addEventListener("click", ()=>{
        const no = x.getAttribute("data-id");
       window.location.href="http://127.0.0.1:8080/kpi/detail?no="+no;
      });
    });
    },
    fail: () => {
      console.log("통신 실패");
    },
  });

