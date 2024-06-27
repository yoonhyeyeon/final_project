<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">

</head>
<body>
    <div class="form-container">
        <div class="form-item">
            <label>부서</label>
            <select name="deptCategory">
                <option value="10">경영지원부</option>
                <option value="20">인사부</option>
                <option value="30">연구개발</option>
                <option value="40">영업</option>
                <option value="50">홍보</option>
            </select>
        </div>
        <div class="form-item">
            <label>팀명</label>
            <input type="text" name="name">
        </div>
        <div class="form-item">
            <label>팀코드</label>
            <input type="text" name="code">
        </div>
        <div class="form-item">
            <label>설립일</label>
            <input type="date" name="enrollDate">
        </div>
        <div class="form-item">
            <label>팀 상태</label>
            <select name="stateCategory">
                <option value="활동중">활동중</option>
                <option value="준비중">준비중</option>
            </select>
        </div>
        <div class="form-item">
            <input class="enroll-button" type="submit" value="작성하기">
        </div>
    </div>
</body>
</html>
