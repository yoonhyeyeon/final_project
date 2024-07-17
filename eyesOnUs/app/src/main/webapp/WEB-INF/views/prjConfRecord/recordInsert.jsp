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
        <link rel="stylesheet" href="/css/projectCss/projectList.css">
        <link rel="stylesheet" type="text/css" href="/css/prjConfRecord/recordInsert.css">
          <script defer src="/js/projectJs/projectSearch.js"></script>
          <script defer src="/js/projectJs/projectList.js"></script>
          <script defer src="/js/prjConfRecord/recordInsert.js"></script>
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

<c:if test="${not empty sessionScope.loginMemberVo.no}">
    <c:if test="${sessionScope.loginMemberVo.rank eq '0' or sessionScope.loginMemberVo.rank eq '10' or sessionScope.loginMemberVo.rank eq '20'}">
    <div id="calendarContainer" class="calendar-container">
                 <div id="out">
                        <div id="in">
                            <div id="div-title">
                                <h1>회의록</h1>
                            </div>
                            &nbsp;&nbsp;<p>회의 주제 :</p> <input type="text" name="title" id="title"><hr>
                            &nbsp;&nbsp;<p>프로젝트 번호</p> : <input type="text" name="prjNo" id="prjNo"><br><hr>
                            <textarea name="content" id="recordContent" placeholder="내용"></textarea><br>
                            <div id="div-submit">
                                <button id="submitButton" onclick="smtRecord();">등록</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test ="${sessionScope.loginMemberVo.rank eq '30' or sessionScope.loginMemberVo.rank eq '40'}">
                <div id="calendarContainer" class="calendar-container">
                    <div id="div-title">
                        <h1>권한이 없습니다</h1>
                    </div>
                </div>
            </c:if>
      
    
    
    
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
    
    <h4>중지된 프로젝트 일정</h4>
        
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
<script src="/js/teamRoom/clock.js"></script>
</body>
</html>




