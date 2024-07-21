<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TEAM ROOM</title>
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
    <link rel="stylesheet" href="/css/prjConfRecord/recordDetail.css">
    <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
    <script defer src="/js/prjConfRecord/recordDetail.js"></script>
    <script defer src="/js/prjConfRecord/recordDelete.js"></script>
</head>
<body>
<input type="hidden" name="vo" id="vo" value="${sessionScope.loginMemberVo.no}">
    <div class="time">
        <div id="time">
            <!-- 현재 시간을 표시할 div 추가 -->
        </div>
    </div>

  <button id="sidebarBtn" class="open-btn">☰ Sidebar</button>
 
    <div id="calendarContainer" class="calendar-container">
        <div id="out">
            <div id="in">
                <div id="div-title">
                    <h1>회의록</h1>
                </div>
                &nbsp;&nbsp;<p class="prjNo"></p><hr>
                &nbsp;&nbsp;<p class="name" ></p><br>
                &nbsp;&nbsp;<p class="title"></p><hr>
                &nbsp;&nbsp;<p class="enlDate" ></p><br>
                <hr>
                <h2>내용</h2>
                <textarea name="content" id="recordContent" readonly></textarea><br>
                <div id="divSubmit">
                    <p id="dBtn"></p>
                </div>
            </div>
        </div>
    </div>
    
    <div id="listContainer" class="list-container">
    </div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/util/clock.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
</body>
<div id="sidebar" class="sidebar">
    <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
  </div>
</html>






