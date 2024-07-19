function write01(){
    const titleValue = document.querySelector("#title").value;
    const contentValue = document.querySelector("#content").value;

    $.ajax({
        url : "/notice/write",
        type : "post",
        data : {
            title : titleValue ,
            content : contentValue,
        },
        success : (data)=>{
            console.log("작성 성공");
            alert("등록 성공 !");
            location.href = "/notice/list";
        } ,
        fail : ()=>{
            console.log("작성 실패");
        } ,
    });
}

