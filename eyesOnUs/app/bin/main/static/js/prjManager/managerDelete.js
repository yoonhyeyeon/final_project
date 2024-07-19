

function del(no){
    $.ajax({
        url : "/project/manager/delete",
        type : "DELETE",
        data : {
            no : no
        },
        success : function(x){
            console.log(x);
            alert("해임 완료");
            location.href="/project/manager/list";
        },
        error : function(error){
            console.log("에러");
        }
    });
}