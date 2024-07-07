function del(no){
    $.ajax({
        url : "http://127.0.0.1:8383/project/manager/delete",
        type : "DELETE",
        data : {
            no : no
        },
        success : function(x){
            console.log(x);
            alert("해임 완료");
            location.href="http://127.0.0.1:8383/project/manager/list";
        },
        error : function(error){
            console.log("에러");
        }
    });
}