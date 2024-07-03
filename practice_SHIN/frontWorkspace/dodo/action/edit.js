function edit() {

  // const todoNo = ;
  // const changeContent = ;

  $.ajax({
    url:"http://127.0.0.1:8585/todo/edit",
    method:"put",
    data: {
      no : todoNo,
      content: changeContent,
    },
    success:function(data){
      console.log(data);
      
    },
  })
}