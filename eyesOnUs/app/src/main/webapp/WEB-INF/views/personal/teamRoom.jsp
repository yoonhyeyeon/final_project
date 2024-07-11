<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>personalWork</title>
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
    <script defer src="../js/testMain/calender.js"></script>
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

         <div id="team-List-table">
             <!-- 팀원목록을 표시할 div 추가 -->
             <%@ include file="/WEB-INF/views/teamRoom/teamList.jsp" %>
         </div>
     </div>

  <div id="sidebar" class="sidebar">
   <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
</div>
<button id="openBtn" class="open-btn">☰ Sidebar</button>




<div id="calendarContainer" class="calendar-container">
  <!-- 여기에 **조회** 내용을 추가할 수 있습니다 -->
  <%@ include file="/WEB-INF/views/personal/list.jsp" %>
</div>

<div id="listContainer" class="list-container">
  <!-- 여기에 **작성** 내용을 추가할 수 있습니다 -->
<%@ include file="/WEB-INF/views/personal/write.jsp" %>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/list.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>

</body>
</html>
