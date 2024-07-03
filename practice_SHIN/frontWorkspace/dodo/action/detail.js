
function getTodoByNo() {

  const detailNo = document.querySelector("input[name = num]").value;
  document.querySelector("input[name=num]").value = "";

$.ajax({
  url:"http://127.0.0.1:8585/todo/detail",
  method:"GET",
  data:{
    num : detailNo
  },
  success: function(x){
    const detailArea = document.querySelector("#detailArea");

    let str = "";
    str += "<h2>상세조회</h2>";
    str += "<h3>번호 :"+x.no+"</h3>";
    str += "<h3>번호 :"+x.content+"</h3>";
    str += "<textarea name='changeContent'></textarea>";

    str += "<button onclick='edit("+x.no+");'>수정하기</button>";
    str += "<button onclick='del("+x.no+");'>삭제하기</button>";

    detailArea.innerHTML = str;

  },
});

}