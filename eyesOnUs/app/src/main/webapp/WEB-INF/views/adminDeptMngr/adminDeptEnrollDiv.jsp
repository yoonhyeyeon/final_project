<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
        </style>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
            <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
            <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
            <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminList.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminEnroll.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminDeptJs/adminDeptEnrollDiv.js"></script>
            <script defer src="/js/adminDeptJs/adminDeptListEnroll.js"></script>
            <script defer src="../js/adminUtil.js"></script>
            <script defer src="../js/sidebar.js"></script>
            <script defer src="../js/calender.js"></script>
            <title>부서 등록</title>
        </head>

        <body id="container">
            <div id="warp">
                <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
                    <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
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
                                    <button class="getBack-button" id="listButton"
                                        onclick="location.href='/adminDeptMngr/list'">목록으로</button>
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
                            <div class="list-container" id="teamContainer"></div>
                            <div class="pagination" id="pagination"></div>
                        </section>
                        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
            </div>
            <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
                <button id="sidebarBtn"><span>메뉴</span></button>
        </body>

</html>