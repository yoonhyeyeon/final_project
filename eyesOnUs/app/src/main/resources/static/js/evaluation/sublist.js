$.ajax({
  url : "/evaluation/listData2",
  type : "get",
  success : (data)=>{
    console.log(data);
    console.log("조회 성공");

    const list = document.querySelector("");
    let str = "";

    for(let i = 0; i < data.length; i++){

    }
    list.innerHTML = str;

  },
  fail : ()=>{
    console.log("통신 실패");
  },
});