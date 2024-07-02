<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/adminList.css">
            <link rel="stylesheet" type="text/css" href="/css/adminPageBtn.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminEmpList.js"></script>
            <script defer src="/js/adminSearchEmpList.js"></script>
            <title>관리자 직원 목록</title>
        </head>

        <body>
            <section>
                <div class="emp-container list-container" id="empContainer"></div>
                <div class="pagination" id="pagination"></div>
                <div class="search-form" id="search-form">
                    <form id="searchForm">
                        <select id="empCategory">
                            <option value="deptName">부서</option>
                            <option value="divName">팀</option>
                            <option value="positionName">직급</option>
                            <option value="name">이름</option>
                        </select>
                        <input type="text" id="searchBox" name="searchBox">
                        <button type="submit" class="tableButton">검색</button>
                    </form>
                    <button class="enroll-button" onclick="window.location.href='/adminEmpMngr/enrollEmp'">사원등록</button>
                </div>
            </section>
        </body>
</html>