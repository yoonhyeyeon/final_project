function del(no){
  $.ajax({
    url : "http://127.0.0.1:8383/project/record/delete",
    method : "DELETE",
    data : {no : no},
    success : function(x){
      console.log("삭제완료");
      alert("회의록 삭제 완료");
      location.href="http://127.0.0.1:8383/project/record/list";
    }
  });
}