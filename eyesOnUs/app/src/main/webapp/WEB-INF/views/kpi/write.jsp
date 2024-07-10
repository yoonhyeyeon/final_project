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
    <link rel="stylesheet" type="text/css" href="/css/kpi/kpiWrite.css">
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
         <div class="write-form">
                 <div id="title">
                     <h2>KPI 일정 등록</h2>
                 </div>
                 <hr>
             <div id="form">
                 프로젝트 번호 : <select name="projectNo" id="projectNo" style="width:100px">
                   <option value="">------선택------</option>
                   <c:forEach var="vo" items="${voList}">
                       <c:if test="${sessionScope.loginMemberVo.no == vo.empNo}">
                        <option value="${vo.no}">${vo.no} : ${vo.title}</option>
                       </c:if>
                   </c:forEach>
                 </select>
                 <br />
                 목표
                 <br>
                 <textarea name="goal" id="goal"></textarea>
                 <br />
                 <hr>
                 개인 일정
                 <br>
                 <textarea name="personalSchedule" id="personalSchedule"></textarea>
                 <br />
                 집중도 : <input type="text" name="focus" id="focus">
                 <br />
                 <br />
                 <div class="submit-bar">
                     <button onclick="write01(${sessionScope.loginMemberVo.no});" id="submit">등록하기</button>
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
<script defer src="../js/kpi/kpiWrite.js"></script>

</body>
</html>
