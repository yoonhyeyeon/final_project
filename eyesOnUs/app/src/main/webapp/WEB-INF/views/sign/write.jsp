<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>결재 등록</h1>

    <form action="/sign/write" method="post" enctype="multipart/form-data">
        <input type="text" name="empNo" value="43" hidden>
        <input type="text" name="title" placeholder="제목">
        <br>
        <input type="text" name="content" placeholder="내용">
        <input type="text" name="refNo[]" value="4" hidden>
        <input type="text" name="refNo[]" value="7" hidden>
        <input type="text" name="approverNo[]" value="13" hidden>
        <input type="text" name="approverNo[]" value="9" hidden>
        <input type="text" name="approverNo[]" value="6" hidden>
        <br>
        <input type="file" name="file">
        <br>
        <input type="submit" value="제출">
    </form>
</body>
</html>
