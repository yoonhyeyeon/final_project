<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파이널</title>

</head>
<body>
	<h1>공지사항 수정하기</h1>

    <form action="/notice/edit" method="post">
        <input type="text" name="title" placeholder="제목">
        <br>
        <textarea name="content" placeholder="내용"></textarea>
        <br>
        <input type="submit" value="수정하기">
    </form>
    <button onclick="location.href='/notice/delete'">삭제하기</button>

</body>
</html>






