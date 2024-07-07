function write01(empNo){

    $.ajax({
        url : "http://127.0.0.1:8383/home",
        type : "post",
        data : { empNo : empNo },
        success : (data)=>{
            console.log(data);
            console.log("통신 성공");
        },
        fail : ()=>{
            console.log("통신 실패");
        },
    });
}