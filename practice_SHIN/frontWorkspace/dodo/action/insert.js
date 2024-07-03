
function insertTodo() {

  const str = document.querySelector("input[name=content]").value;
  document.querySelector("input[name=content]").value="";
  
  $.ajax({
    url:"http://127.0.0.1:8585/todo",
    method:"POST",
    data:{
      content:"공부하기"
    },
    success:function(x){
      console.log(x);
      loadTodo();
    },
  })
}


