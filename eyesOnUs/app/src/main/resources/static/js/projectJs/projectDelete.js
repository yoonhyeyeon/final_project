function del(detailNo){
    $.ajax({
        url : "http://127.0.0.1:8383/project/projectDelete",
        method : "DELETE",
        data : { no : detailNo },
        success : function(x){
            console.log(x);
            alert("삭제완료");
            window.location.href=("http://127.0.0.1:8383/project/projectList");
        },
        error : function(x){
            console.log("에러");
        },
    });
}