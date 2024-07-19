<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <!DOCTYPE html>
    <html lang="en">
    <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>RECORD LIST</title>
          <link rel="stylesheet" href="/css/teamRoom/clock.css">
          <link rel="stylesheet" href="/css/teamRoom/list.css">
          <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
          <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
          <script defer src="../js/teamRoom/teamList.js"></script>
          <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
          <link rel="stylesheet" href="/css/prjConfRecord/recordList.css">
          <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
          <script defer src="/js/prjConfRecord/recordList.js"></script>
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


<c:if test="${not empty sessionScope.loginMemberVo.no}">
    <div id="calendarContainer" class="calendar-container">
        <div id="divSearch">
                <h1>회의록 목록</h1>
        </div>
      <table id="recordTable">
            <thead>
                <tr>
                    <td>제목</td>
                    <td>등록일</td>
                    <td>작성자</td>
                </tr>
            </thead>
            <tbody id="recordList">
        
            </tbody>
        </table>  
    </div>
    
    
    
    <div id="listContainer" class="list-container">

    <table>
        <thead>
            <tr>

            </tr>
        </thead>
        <tbody id="personalTableBody1">
            <!-- 첫 번째 테이블의 동적 데이터가 여기에 추가됩니다 -->
        </tbody>
    </table>

    <table>
        <thead>
            <tr>

            </tr>
        </thead>
        <tbody id="personalTableBody2">
            <!-- 두 번째 테이블의 동적 데이터가 여기에 추가됩니다 -->
        </tbody>
    </table>
    </div>
</c:if>
<c:if test="${empty sessionScope.loginMemberVo.no}">
    <h1>로그인하고 오세요</h1>
    <div id="listContainer" class="list-container"></div>
</c:if>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script src="/js/util/clock.js"></script>

</body>
</html>


