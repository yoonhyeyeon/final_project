function write02(empNo){

    $.ajax({
        url : "http://127.0.0.1:8383/home/quit",
        type : "post",
        data : { empNo : empNo },
        success : (data)=>{
            console.log(data);
            console.log("통신 성공");
            alert("퇴근 하셨습니다.");
        },
        fail : ()=>{
            console.log("통신 실패");
        },
    });
}