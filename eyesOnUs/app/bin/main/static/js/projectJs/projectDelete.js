function del(detailNo){
    $.ajax({
        url : "/project/projectDelete",
        method : "DELETE",
        data : { no : detailNo },
        success : function(x){
            console.log(x);
            alert("삭제완료");
            window.location.href=("/project/projectList");
        },
        error : function(x){
            console.log("에러");
        },
    });
}