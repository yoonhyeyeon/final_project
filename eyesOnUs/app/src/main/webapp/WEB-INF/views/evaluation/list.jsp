<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>TEAM ROOM</title>
      <link rel="stylesheet" href="/css/teamRoom/clock.css">
      <link rel="stylesheet" href="/css/teamRoom/list.css">
      <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
      <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/evaluation/list.css">
      <script defer src="../js/teamRoom/teamList.js"></script>
      <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
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
<button id="sidebarBtn" class="open-btn">☰ Sidebar</button>

<div id="calendarContainer" class="calendar-container">

  <div id="out">
    <h2 id="head">평가목록</h2>
    <hr><br><br>
    <div id="list">
      <br><br><br>
      <span class="evaluatorNo"></span>
      <div id="listBtn">
        <c:if test="${sessionScope.loginMemberVo.positionCode != 40 }">
            <button onclick="leader(${vo.no});">팀장 평가</button>
        </c:if>
        <br><br>
        <c:if test="${sessionScope.loginMemberVo.positionCode == 40 }">
        <button onclick="member(${vo.no});">팀원 평가</button>
        </c:if>
        <br><br>
        <button onclick="colleage(${vo.no});">동료 평가</button>
        <br><br>
      </div>
      <div id="listBox">
        <div id="listItemBox">
          <span>이름</span>
          <span>부서</span>
          <span>팀</span>
          <span>직급</span>
        </div>
        <div id="Item">

        </div>
      </div>
    </div>
  </div>

</div>

<div id="listContainer" class="list-container">



</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/list.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script src="/js/util/clock.js"></script>
<script defer src="../js/evaluation/list.js"></script>
<script defer src="../js/evaluation/leader.js"></script>
<script defer src="../js/evaluation/member.js"></script>
<script defer src="../js/evaluation/colleage.js"></script>

</body>
<div id="sidebar" class="sidebar">
  <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
</div>
</html>
