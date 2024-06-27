<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/adminList.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminDeptList.js"></script>
            <title>부서 목록</title>
        </head>

        <body>
            <div class="team-container list-container" id="teamContainer"></div>
            <div class="pagination" id="pagination"></div>
            <div id="search-form" class="search-form">
                <form id="searchForm">
                    <select id="empCategory">
                        <option value="deptName">부서</option>
                        <option value="name">팀</option>
                        <option value="state">상태</option>
                    </select>
                    <input type="text" id="searchBox" name="searchBox">
                    <button type="submit" class="tableButton">검색</button>
                </form>
                <button class="enroll-button" onclick="window.location.href='/adminDeptMngr/enrollDiv'">프로젝트등록</button>
            </div>
        </body>

</html>