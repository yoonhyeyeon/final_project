<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가 신청</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>휴가 신청</h1>

    <form action="/leave/write" method="post">

        <input type="text" name="empNo" value="43" hidden>

        <input type="text" name="approverNo" value="13" hidden>

        <label for="typeNo">휴가 타입 선택</label>
        <select name="typeNo">
            <option value="1">연차</option>
            <option value="2">병가</option>
            <option value="3">경조사</option>
        </select>
        <br>
        <label for="startDate">시작일</label>
        <input type="date" name="startDate">
        <br>
        <label for="endDate">종료일</label>
        <input type="date" name="endDate">
        <br>
        <textarea name="reason" placeholder="사유"></textarea>
        <br>
        <input type="submit" value="신청">
    </form>
</body>
</html>
