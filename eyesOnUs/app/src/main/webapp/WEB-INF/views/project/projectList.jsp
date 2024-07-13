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
        <link rel="stylesheet" href="/css/projectCss/projectList.css">
          <script defer src="/js/projectJs/projectSearch.js"></script>
          <script defer src="/js/projectJs/projectList.js"></script>
    </head>
<body>
<input type="text"id="ingProjectData" value="${sessionScope.loginMemberVo.deptCode}" hidden>
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


<c:if test="${not empty sessionScope.loginMemberVo.no}">
    <div id="calendarContainer" class="calendar-container">
      <div id="divSearch">
        <select name="search" id="search">
            <option value="1">제목</option>
        </select>
        <input type="text" name="title" id="title">
        <button id="searchBtn" onclick="saerchName();">검색</button>
    </div>
      <table>
            <thead>
                <tr>
                    <td>프로젝트 이름</td>
                    <td>PM</td>
                    <td>담당부서</td>
                    <td>상태</td>
                    <td>시작일</td>
                    <td>수정일</td>
                </tr>
            </thead>
            <tbody id="prjList">
        
            </tbody>
        </table>  
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
</c:if>
<c:if test="${empty sessionScope.loginMemberVo.no}">
    <h1>로그인하고 오세요</h1>
    <div id="listContainer" class="list-container"></div>
</c:if>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>

</body>
</html>


