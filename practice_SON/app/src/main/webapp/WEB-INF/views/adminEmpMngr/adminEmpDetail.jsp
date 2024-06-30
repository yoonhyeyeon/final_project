<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">
    <title>Document</title>
</head>
<body>

    <div class="form-container">
        <div class="form-group">
            <div class="label">이름</div>
            <div class="value">${vo.name}</div>
        </div>
        <div class="form-group">
            <div class="label">전화번호</div>
            <div class="value">${vo.phone}</div>
        </div>
        <div class="form-group">
            <div class="label">주소</div>
            <div class="value">${vo.address}</div>
        </div>
        <div class="form-group">
            <div class="label">사원번호</div>
            <div class="value">${vo.no}</div>
        </div>
        <div class="form-group">
            <div class="label">부서</div>
            <div class="value">${vo.deptName}</div>
        </div>
        <div class="form-group">
            <div class="label">팀</div>
            <div class="value">${vo.divName}</div>
        </div>
        <div class="form-group">
            <div class="label">직급</div>
            <div class="value">${vo.positionName}</div>
        </div>
        <div class="form-group">
            <div class="label">연봉</div>
            <div class="value">${vo.salary}</div>
        </div>
        <div class="form-group">
            <div class="label">보너스</div>
            <div class="value">${vo.bonus}</div>
        </div>
        <div class="form-group">
            <div class="label">아이디</div>
            <div class="value">${vo.id}</div>
        </div>
        <div class="form-group">
            <div class="label">닉네임</div>
            <div class="value">${vo.nick}</div>
        </div>
        <div class="form-group">
            <div class="label">입사일</div>
            <div class="value">${vo.enrollDate}</div>
        </div>
        <div class="form-group">
            <div class="label">퇴사일</div>
            <div class="value">${vo.retireDate}</div>
        </div>
        <div class="form-group">
            <div class="label">퇴사 여부</div>
            <div class="value">${vo.retireYn}</div>
        </div>
    </div>

</body>
</html>