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
     <link rel="stylesheet" href="/css/teamRoom/clock.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
    <link rel="stylesheet" type="text/css" href="/css/kpi/kpiList.css">
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
    <h2>KPI 목록</h2>
    <hr>
        <c:if test="${sessionScope.loginMemberVo.no == null}">
            <h2>로그인하고 와주세요</h2>
        </c:if>
        <c:if test="${sessionScope.loginMemberVo.no != null}">
            <div class="list-box">

            </div>
        </c:if>
  </div>

</div>

<div id="listContainer" class="list-container">
  <!-- 여기에 **서브** 내용을 추가할 수 있습니다 -->
  <%@ include file="/WEB-INF/views/teamRoom/list.jsp" %>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/list.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script defer src="../js/kpi/kpiList.js"></script>
<script defer src="../js/kpi/kpiDetail.js"></script>
<script src="/js/teamRoom/clock.js"></script>

</body>
</html>
