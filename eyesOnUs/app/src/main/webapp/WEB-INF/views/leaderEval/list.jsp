<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TEAM ROOM</title>
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
    <link rel="stylesheet" href="/css/teamRoom/list.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/leaderEval/leaderList.css">
</head>
<body>

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
        <h1>팀장 평가</h1>
        <div id="list">
            <span id="date">평가 기간 : 2024-07-06 ~ 2024-07-30</span>
            <br><hr><br>
            <div id="evaluatorNo">
                <p>평가자 : 윤혜연</p>
            </div>
                <div class="listBox">
                    <div id="listItemBox">
                        <span>번호</span>
                        <span>이름</span>
                        <span>소통력</span>
                        <span>첵임감</span>
                        <span>판단력</span>
                        <span>전문성</span>
                        <span>칭찬할 점</span>
                        <span>아쉬운 점</span>
                        <span>하고 싶은 말</span>
                        <span>평가일</span>
                    </div>
                    <div id="Item">

                    </div>
                </div>
        </div>
    </div>

</div>

<div id="listContainer" class="list-container">
  <!-- 여기에 **서브** 내용을 추가할 수 있습니다 -->
  <%@ include file="/WEB-INF/views/teamRoom/list.jsp" %>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/list.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script defer src="../js/leaderEval/leaderList.js"></script>

</body>
</html>
