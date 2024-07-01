<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파이널</title>

</head>
<body>
	<h1>게시글 작성 ~ !</h1>

    <input type="text" id="title" placeholder="제목">
    <br />
    <textarea id="content" placeholder="내용"></textarea>
    <br />
    <input type="text" id="num" placeholder="작성자 번호">
    <br />
    <button type="button" onclick="f01();">작성하기</button>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>

    function f01(){
        const titleValue = document.querySelector("#title").value;
        const numValue = document.querySelector("#num").value;
        const contentValue = document.querySelector("#content").value;

        $.ajax({
            url : 'http://127.0.0.1:8080/api/board' ,
            type : 'post' ,
            data : {
                title: titleValue,
                content: contentValue,
                writerNo: numValue,
            } ,
            success : function(x){
                console.log(x);
            } ,
            error : function(x){
                console.log(x);
            } ,
        });

    }

</script>






