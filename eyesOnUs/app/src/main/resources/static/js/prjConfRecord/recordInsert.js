function smtRecord(){
    const titleVal = document.querySelector("#title").value;
    const prjNoVal = document.querySelector("#prjNo").value;
    const contentNoVal = document.querySelector("#recordContent").value;
    $.ajax({
        url : "http://127.0.0.1:8383/project/record/insert",
        method : "POST",
        data : {
            title : titleVal,
            prjNo : prjNoVal,
            content : contentNoVal
        },
        success : function(x){
            console.log(x);
            alert("등록 완료!!")
            location.href="http://127.0.0.1:8383/project/record/list";
        },
        error : function(error){
            console.log("에러");
        }
    });
}