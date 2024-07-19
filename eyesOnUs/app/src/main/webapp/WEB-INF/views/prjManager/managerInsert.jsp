<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TEAM ROOM</title>
    <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
    <script defer src="/js/prjManager/managerInsert.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/prjManager/managerInsert.css">
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
    <link rel="stylesheet" href="/css/teamRoom/list.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
</head>
<body>
<input type="text" name="insertPm" id="insertPm" value="${sessionScope.loginMemberVo.no}" hidden>
    <div class="time">

    </div>

<div id="sidebar" class="sidebar">
    <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
    </div>
    <button id="sidebarBtn" class="open-btn">☰ Sidebar</button>



<c:if test="${sessionScope.loginMemberVo.rank eq 20 }">
    
    <div id="calendarContainer" class="calendar-container">
        <div id="out">
            <div id="in">
                <div id="div-title">
                    <h1>프로젝트 담당자</h1>
                </div>
                &nbsp;&nbsp;<p>담당자</p>&nbsp;&nbsp;&nbsp;&nbsp; :
                <select name="empNo" id="empNo">
                    <c:forEach var="vo" items="${voList}">
                        <option value="${vo.no}">${vo.name}</option>
                    </c:forEach>
                </select>
                <br><hr>
                <div id="div-submit">
                    <button id="submitButton" onclick="smtM();">등록</button>
                </div>
            </div>
        </div>
    </div>
    
</c:if>

<c:if test="${sessionScope.loginMemberVo.rank ne 20}">
    <div id="notLogin">
        <h1>권한이 없습니다</h1><br><br>
        <a href="/project/projectMain">돌아가기</a>
    </div>
<div id="listContainer" class="list-container">
</div>
</c:if>

<c:if test="${empty sessionScope.loginMemberVo.no}">
    <h1>로그인 하고 오세요</h1>
    <div id="listContainer" class="list-container">
    </div>
</c:if>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/util/clock.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
</body>
</html>




