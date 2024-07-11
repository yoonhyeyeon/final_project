
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>근무시간 테이블</title>
    <link rel="stylesheet" href="/css/teamRoom/teamList.css">
    <script defer src="../js/teamRoom/teamList.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>



    <table>
        <thead id="listItemBox">
            <tr>
                <th>이름</th>
                <th>직책</th>
            </tr>
        </thead>
        <tbody id="Item">
            <!-- 동적 데이터 추가 -->
        </tbody>
    </table>




</body>
</html>
