$.ajax({
    url : "http://127.0.0.1:8383/util/detailData",
    type : "get",
    success : (data)=>{
        console.log("통신 성공");
        console.log(data);

        const list = document.querySelector("thead");
        let str = "";

       for(let i = 0; i < data.length ; i++){
            str += "<div id='listItem'>";
            str += "<span>" + data[i].name + "</span>";
            str += "<span>" + data[i].nick + "</span>";
            str += "</div>";


        }
        list.innerHTML = str;

    },
    fail : ()=>{
        console.log("통신 실패");
    },
});