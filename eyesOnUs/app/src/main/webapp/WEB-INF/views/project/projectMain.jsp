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
        <link rel="stylesheet" href="/css/projectCss/projectMain.css">
          <script defer src="/js/projectJs/projectSearch.js"></script>
          <script defer src="/js/projectJs/projectList.js"></script>
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
    <button id="prjListGoBtn" onclick="location.href='http://127.0.0.1:8383/project/projectList'">프로젝트 리스트</button>
    <button id="prjLnsertGoBtn" onclick="location.href='http://127.0.0.1:8383/project/projectInsert'">프로젝트 등록하기</button>
    <br><br>
    <button id="recordListGoBtn" onclick="location.href='http://127.0.0.1:8383/project/record/insert'">회의록 리스트</button>
    <button id="recordInsertGoBtn" onclick="location.href='http://127.0.0.1:8383/project/record/list'">회의록 등록하기</button>
</div>



<div id="listContainer" class="list-container">
  <h4>진행 중인 프로젝트</h4>

<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>프로젝트 이름</th>
            <th>시작일</th>
        </tr>
    </thead>
    <tbody id="personalTableBody1">
        <!-- 첫 번째 테이블의 동적 데이터가 여기에 추가됩니다 -->
    </tbody>
</table>

<h4>진행 중인 프로젝트 일정</h4>

<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
        </tr>
    </thead>
    <tbody id="personalTableBody2">
        <!-- 두 번째 테이블의 동적 데이터가 여기에 추가됩니다 -->
    </tbody>
</table>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>

</body>
</html>
