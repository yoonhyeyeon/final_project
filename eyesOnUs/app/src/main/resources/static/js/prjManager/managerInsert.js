function smt(){
    const proNoVal = document.querySelector("#proNo").value; 
    const empNoVal = document.querySelector("#empNo").value; 
    $.ajax({
        url : "http://127.0.0.1:8383/project/manager/insert",
        method : "POST",
        data : {
            proNo : proNoVal,
            empNo : empNoVal
        },
        success : function(x){
            console.log("x");
            alert("담당자 등록 완료!");
            location.href="http://127.0.0.1:8383/project/projectList";
        },
        error : function(error){
            console.log("에러");
        }
    });
}