function del(no){
  $.ajax({
    url : "/project/record/delete",
    method : "DELETE",
    data : {no : no},
    success : function(x){
      console.log("삭제완료");
      alert("회의록 삭제 완료");
      location.href="/project/record/list";
    }
  });
}