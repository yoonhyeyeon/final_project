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
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/footer.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/popUpBoard.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/sidebar.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/teamRoom.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminEnroll.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminEmpJs/adminEmpEnroll.js"></script>
            <script defer src="../js/adminUtil.js"></script>
            <script defer src="../js/sidebar.js"></script>
            <script defer src="../js/calender.js"></script>
            <title>사원등록</title>
        </head>

        <body id="container">
            <div id="warp">
                <%@ include file="/WEB-INF/views/adminHr/adminHeader.jsp" %>
                    <%@ include file="/WEB-INF/views/adminHr/adminNav.jsp" %>
                        <section>
                            <div class="form-container">
                                <div class="form-group">
                                    <div class="label">아이디</div>
                                    <input type="text" class="value" name="id">
                                </div>
                                <div class="form-group">
                                    <div class="label">닉네임</div>
                                    <input type="text" class="value" name="nick">
                                </div>
                                <div class="form-group">
                                    <div class="label">비밀번호</div>
                                    <input type="password" class="value" name="pwd">
                                </div>
                                <div class="form-group">
                                    <div class="label">이름</div>
                                    <input type="text" class="value" name="name">
                                </div>
                                <div class="form-group">
                                    <div class="label">전화번호</div>
                                    <input type="text" class="value" name="phone">
                                </div>
                                <div class="form-group">
                                    <div class="label">주소</div>
                                    <input type="text" class="value" name="address">
                                </div>
                                <div class="form-group">
                                    <div class="label">입사일</div>
                                    <input type="date" class="value" name="enrollDate">
                                </div>
                                <div class="form-group">
                                    <div class="label">부서</div>
                                    <input type="text" class="value" value="인사부" readonly>
                                    <input type="hidden" class="value" value="20" name="deptCode">
                                </div>
                                <div class="form-group">
                                    <div class="label">팀</div>
                                    <input type="text" class="value" value="인사본부" readonly>
                                    <input type="hidden" class="value" value="20" name="divCode">
                                </div>
                                <div class="form-group">
                                    <div class="label">직급</div>
                                    <input type="text" class="value" value="사원" readonly>
                                    <input type="hidden" class="value" value="90" name="positionCode">
                                </div>
                                <input class="submit-button" type="submit" value="작성하기">
                                <button class="getBack-button" id="listButton"
                                    onclick="location.href='/adminEmpMngr/list'">목록으로</button>
                            </div>
                        </section>
                        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
            </div>
        </body>

</html>