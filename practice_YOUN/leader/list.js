$.ajax({
    url : "http://127.0.0.1:8383/leaderEval/listData",
    type : "get",
    success : (data)=>{
        console.log("통신 성공");
        console.log(data);

        const list = document.querySelector("#Item");
        let str = "";

        for( let i = 0; i < data.length ; i++ ){
            
            str += "<div id='listItem'>";
            str += "<span>" + data[i].no + "</span>";
            str += "<span>" + data[i].evaluateeNo + "</span>";
            str += "<span>" + data[i].communication + "</span>";
            str += "<span>" + data[i].responsibility + "</span>";
            str += "<span>" + data[i].judgement + "</span>";
            str += "<span>" + data[i].professionalism + "</span>";
            str += "<span>" + data[i].compliment + "</span>";
            str += "<span>" + data[i].disappointment + "</span>";
            str += "<span>" + data[i].suggestion + "</span>";
            str += "<span>" + data[i].writeDate + "</span>";
            str += "</div>";  
        }

        list.innerHTML = str;

    },
    fail : ()=>{
        console.log("통신 실패");
    },    
});