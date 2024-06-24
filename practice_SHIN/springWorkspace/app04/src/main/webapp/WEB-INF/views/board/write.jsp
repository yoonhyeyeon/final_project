<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> 작성 </title>
</head>

<h1>게시글 작성</h1>

<form action="/board/insert" method="POST" enctype="multipart/form-data">
제목: <input type="text" name="title">
<br/>
내용: <textarea type="text" name="content"></textarea>
<br/>
파일: <input type="file" name="attachmentList" multiple accept=".png">
<br/>
<input type="submit" value="작성하기">
</form>

</body>
</html>



</html>
