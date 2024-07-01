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
	<h1>HOME ~ !</h1>

	<h3>유저 정보 ::: ${abc.nick}</h3>
	<c:if test="${not empty abc}">
	    <button onclick="location.href='/member/quit?num=${abc.no}'">탈퇴하기</button>
	</c:if>

</body>
</html>






