<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출장 신청</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>출장 신청</h1>

    <form action="/businessTrip/write" method="post">

        <input type="text" name="empNo" value="43" hidden>

        <input type="text" name="approverNo" value="13" hidden>

        <!-- 해당 프로젝트 가져와서 출력 -->
        <label for="proNo">프로젝트 선택</label>
        <select name="proNo">
            <option value="1">미치겠다</option>
            <option value="2">So Many Things</option>
            <option value="3">Too hard</option>
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
        <input type="text" name="destination" placeholder="출장지">
        <br>
        <input type="submit" value="신청">
    </form>
</body>
</html>
