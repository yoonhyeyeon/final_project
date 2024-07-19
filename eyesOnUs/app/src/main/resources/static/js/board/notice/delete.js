function del(no){
  $.ajax({
    url : "/notice/delete",
    type : "DELETE",
    data : {no : no},
    success : (data)=>{
      console.log(data);
      alert("삭제 성공!");
      window.location.href = "/notice/list";
    },
    fail : ()=>{
        console.log("통신 실패");
        alert("삭제 실패");
    },
  });
}
