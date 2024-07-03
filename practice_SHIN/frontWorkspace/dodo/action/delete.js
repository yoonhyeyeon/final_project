

function del() {

  $.ajax({
    url:"http://127.0.0.1:8585/todo/detail",
    method:"delete",
    data: {
      num : detailNo
    },
    success:function(x){
      const detailArea = document.querySelector("#detailArea");

      let str = "";
      str += "<h2>상세조회</h2>";
      str += "<h3>번호 :"+x.no+"</h3>";
      str += "<h3>삭제완료</h3>";


    detailArea.innerHTML = str;
    },
  })
}