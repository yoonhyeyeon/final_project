function del(no){
  $.ajax({
    url : "http://127.0.0.1:8383/kpi/delete",
    type : "DELETE",
    data : {no : no},
    success : function(data){
      console.log(data);
      alert("삭제 성공!");
      window.location.href = "http://127.0.0.1:8383/kpi/list";
    },
    error : function(error){
        console.log("통신 실패");
        alert("삭제 실패");
    },
  });
}
