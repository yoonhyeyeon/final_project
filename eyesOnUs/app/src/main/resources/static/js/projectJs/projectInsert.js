function smt(){
    const titleVal = document.querySelector("#title").value;
    const codeVal = document.querySelector("#code").value;
    const empVal = document.querySelector("#emp").value;
    const stateVal = document.querySelector("#state").value;
    const contentVal = document.querySelector("#projectContent").value;

    $.ajax({
        url : 'http://127.0.0.1:8383/project/projectInsert',
        type : 'post',
        data : {
            title : titleVal,
            code : codeVal,
            empNo : empVal,
            stateANo : stateVal,
            content : contentVal
        },
        success : function(x){
            alert("등록완료!");
            location.href='http://127.0.0.1:8383/project/projectMain';
        },
        error : function(x){
            console.log("에러")
        }
    });
}