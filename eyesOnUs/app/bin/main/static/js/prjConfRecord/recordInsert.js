

function smtRecord(){
    $(document).ready( ()=> {
        const no = getParam("no");
    });
    if(no){
        const titleVal = document.querySelector("#title").value;
        const prjNoVal = document.querySelector("#prjNo").value;
        const contentNoVal = document.querySelector("#recordContent").value;
        $.ajax({
            url : "/project/record/insert",
            method : "POST",
            data : {
                title : titleVal,
                prjNo : prjNoVal,
                content : contentNoVal
            },
            success : function(x){
                console.log(x);
                alert("등록 완료!!")
                location.href="/project/record/list";
            },
            error : function(error){
                console.log("에러");
            }
        });
    }
}


