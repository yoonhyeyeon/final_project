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
	<h1>기타일정 작성하기</h1>

	<form action="/api/personal/edit" method="post">
        <input type="text" name="no2" placeholder="사원번호">
        <br>
        <input type="text" name="title" placeholder="제목">
        <br>
        <textarea name="content" placeholder="내용"></textarea>
        <br>
        <select name="typeNo">
            <option value="1">플젝일정</option>
            <option value="2">팀일정</option>
            <option value="3">개인일정</option>
        </select>

        <select name="stateBNo">
            <option value="1">진행</option>
            <option value="2">중단</option>
            <option value="3">완료</option>
        </select>

        <br>
        <input type="submit" value="작성하기">
    </form>

</body>
</html>









