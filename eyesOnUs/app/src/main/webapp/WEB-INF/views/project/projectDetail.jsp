<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TEAM ROOM</title>
<link rel="stylesheet" href="/css/projectCss/projectDetail.css">
<link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
<link rel="stylesheet" href="/css/teamRoom/list.css">
<link rel="stylesheet" href="/css/teamRoom/sidebar.css">
<script defer src="/js/projectJs/projectDelete.js"></script>
<script defer src="/js/projectJs/projectDetail.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
    <input type="text" name="svo" id="svo" value="${sessionScope.loginMemberVo.no}" hidden>
    <input type="text" name="vo" id="vo" value="${vo.empNo}" hidden>
    <div class="time">
        <div id="time">
            <!-- 현재 시간을 표시할 div 추가 -->
        </div>

        <div id="work-time-table">
            <!-- 근무 시간을 표시할 div 추가 -->
            <%@ include file="/WEB-INF/views/util/workTime.jsp" %>
        </div>
    </div>

<div id="sidebar" class="sidebar">
<%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
</div>
<button id="openBtn" class="open-btn">☰ Sidebar</button>

<div id="calendarContainer" class="calendar-container">
<div id="out">
    <div id="in">
        <div id="div-title">
            <h1>프로젝트</h1>
        </div>
        &nbsp;&nbsp;<p class="title"></p><hr>
        &nbsp;&nbsp;<p class="deptCode"></p>
        
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <p class="division"></p><hr>
        &nbsp;&nbsp;<p class="employee"></p>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <p class="sPm"></p>
        <br><hr>
        &nbsp;&nbsp;<p class="state" ></p><br>
        <hr>
        <h2>내용</h2>
        <textarea name="content" id="projectContent" readonly></textarea><br>
        <div id="divSubmit">
                <p id="sBtn"></p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <p id="dBtn"></p>
        </div>
    </div>
</div>
</div>

<div id="listContainer" class="list-container">
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script src="/js/teamRoom/clock.js"></script>
</body>

</html>




