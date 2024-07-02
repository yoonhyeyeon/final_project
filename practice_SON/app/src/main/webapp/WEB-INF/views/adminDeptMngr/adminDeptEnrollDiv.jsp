<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/adminDeptList.css">
    <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">
    <link rel="stylesheet" type="text/css" href="/css/adminPageBtn.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="/js/adminDeptEnrollDiv.js"></script>
    <script defer src="/js/adminDeptListEnroll.js"></script>
    <title>부서 등록</title>
</head>
<body>
    <section>
        <div class="form-container">
            <div class="form-group">
                <label>부서</label>
                <select name="deptCategory">
                    <option value="10">경영지원부</option>
                    <option value="20">인사부</option>
                    <option value="30">연구개발</option>
                    <option value="40">영업</option>
                    <option value="50">홍보</option>
                </select>
            </div>
            <div class="form-group">
                <label>팀명</label>
                <input type="text" name="name">
            </div>
            <div class="form-group">
                <label>팀코드</label>
                <input type="text" name="code">
            </div>
            <div class="form-group">
                <label>설립일</label>
                <input type="date" name="enrollDate">
            </div>
            <div class="form-group">
                <label>팀 상태</label>
                <select name="stateCategory">
                    <option value="활동중">활동중</option>
                    <option value="준비중">준비중</option>
                </select>
            </div>
            <div class="form-group">
                <input class="enroll-button" type="submit" value="작성하기">
                <button class="getBack-button" id="listButton" onclick="location.href='/adminDeptMngr/list'">목록으로</button>
            </div>
        </div>
        <div id="search-form" class="search-form">
            <form id="searchForm">
                <select id="empCategory">
                    <option value="deptName">부서</option>
                    <option value="name">팀</option>
                </select>
                <input type="text" id="searchBox" name="searchBox">
                <button type="submit" class="tableButton">검색</button>
            </form>
        </div>
        <div class="team-container list-container" id="teamContainer"></div>
        <div class="pagination" id="pagination"></div>
    </section>

</html>
