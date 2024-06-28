<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/adminDeptEdit.css">
    <title>팀 수정</title>
</head>
<body>
<div class="form-container">
    <form id="editForm" action="/adminDeptMngr/edit" method="post">
        <div class="form-group">
            <label for="deptName">부서</label>
            <div>
                ${vo.deptName}
                <input type="hidden" name="deptCode" value="${vo.deptCode}">
            </div>
        </div>
        <div class="form-group">
            <label for="name">팀명</label>
            <div>
                ${vo.name}
                <input type="hidden" name="name" value="${vo.name}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="code">팀코드</label>
            <div>
                ${vo.code}
                <input type="hidden" name="code" value="${vo.code}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="enrollDate">생성일</label>
            <div>
                ${vo.enrollDate}
                <input type="hidden" name="enrollDate" value="${vo.enrollDate}">
            </div>
        </div>
        <div class="form-group">
            <label for="modifyDate">수정일</label>
            <input type="date" name="modifyDate" value="${vo.modifyDate}">
        </div>
        <div class="form-group">
            <label for="state">팀 상태</label>
            <select name="state">
                <option value="활동중">활동중</option>
                <option value="준비중">준비중</option>
                <option value="중단">중단</option>
                <option value="폐지">폐지</option>
                <option value="완료">완료</option>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" value="수정하기">
        </div>
    </form>
</div>
</body>
</html>
