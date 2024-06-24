<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <table border="1">
        <tr>
            <td>사원번호</td>
            <td>${vo.no}</td>
        </tr>
        <tr>
            <td>부서명</td>
            <td>${vo.deptName}</td>
        </tr>
        <tr>
            <td>직책명</td>
            <td>${vo.positionName}</td>
        </tr>
        <tr>
            <td>상태</td>
            <td>${vo.state}</td>
        </tr>
        <tr>
            <td>연봉 코드</td>
            <td>${vo.salaryCode}</td>
        </tr>
        <tr>
            <td>직급</td>
            <td>${vo.rank}</td>
        </tr>
        <tr>
            <td>연봉</td>
            <td>${vo.salary}</td>
        </tr>
        <tr>
            <td>보너스</td>
            <td>${vo.bonus}</td>
        </tr>
        <tr>
            <td>아이디</td>
            <td>${vo.id}</td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td>${vo.pwd}</td>
        </tr>
        <tr>
            <td>닉네임</td>
            <td>${vo.nick}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td>${vo.name}</td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td>${vo.phone}</td>
        </tr>
        <tr>
            <td>주소</td>
            <td>${vo.address}</td>
        </tr>
        <tr>
            <td>입사일</td>
            <td>${vo.enrollDate}</td>
        </tr>
        <tr>
            <td>퇴사일</td>
            <td>${vo.retireDate}</td>
        </tr>
        <tr>
            <td>퇴사 여부</td>
            <td>${vo.retireYn}</td>
        </tr>
    </table>
    
</body>
</html>