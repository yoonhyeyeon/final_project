function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}

function smtM(){
$(document).ready( ()=> {
    const no = getParam("no");

    if(no){
            const empNoVal = document.querySelector("#empNo").value; 
        
        $.ajax({
            url : "/project/manager/insert",
            method : "POST",
            data : {
                proNo : no,
                empNo : empNoVal
            },
            success : function(x){
                console.log("x");
                alert("담당자 등록 완료!");
                location.href="/project/manager/list";
            },
            error : function(error){
                console.log("에러");
            }
        });
        
    }
});
}