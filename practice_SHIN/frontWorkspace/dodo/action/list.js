


  
  function loadTodo() {

    $.ajax({
      url:"http://127.0.0.1:8585/todo/list",
      method:"GET",
      success: function(x){
        console.log(x);0

        document.querySelector("#todoArea");

        let str = "";

        for (let i = 0; i <x.length; i++) {
          str += "<h3>"+x[i].no+"/"+x[i].content+"</h3>"
        }

        divTag.innerHTML = str;

      },
    })

  }




