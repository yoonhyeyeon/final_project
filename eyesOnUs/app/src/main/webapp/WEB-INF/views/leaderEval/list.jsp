<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>LEADER EVALUATION</title>
      <link rel="stylesheet" href="/css/evaluation/teamList.css">
      <link rel="stylesheet" href="/css/teamRoom/clock.css">
      <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
      <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
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

<button id="sidebarBtn" class="open-btn">☰ Sidebar</button>

<div id="calendarContainer" class="calendar-container">

    <div id="out">
        <h1>팀장 평가</h1>
        <div id="list">
            <span id="date">평가 기간 : 2024-07-06 ~ 2024-07-30</span>
            <br><hr><br>
                <c:forEach var="vo" items="${voList}">
                   <c:if test="${sessionScope.loginMemberVo.no == vo.no}">
                    <div id="evaluatorNo">
                        <p>평가자 : ${vo.name}</p>
                    </div>
                   </c:if>
                </c:forEach>
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
                <br>
                <button id="listBtn" onclick="location.href='http://127.0.0.1:8383/evaluation/list'">목록</button>
        </div>
    </div>

</div>

<div id="listContainer" class="list-container">

    <c:if test="${sessionScope.loginMemberVo.positionCode != 40 }">
        <button id="finishEval" onclick="location.href='/leaderEval/list'">완료된 팀장평가 목록</button>
    </c:if>
    <br />
    <c:if test="${sessionScope.loginMemberVo.positionCode == 40 }">
        <button id="finishEval" onclick="location.href='/memberEval/list'">완료된 팀원평가 목록</button>
    </c:if>
    <br />
        <button id="finishEval" onclick="location.href='/colleageEval/list'">완료된 동료평가 목록</button>

    <h4>남은 평가 목록</h4>

    <div id="boxList">
        <table>
            <thead>
                <tr>
                    <th>사원 번호</th>
                    <th>이름</th>
                    <th>직급</th>
                </tr>
            </thead>
            <tbody id="personalTableBody2">

            </tbody>
        </table>
    </div>

</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/util/clock.js"></script>
<script defer src="../js/evaluation/sublist.js"></script>
<script defer src="../js/leaderEval/leaderList.js"></script>

</body>
    <div id="sidebar" class="sidebar">
      <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
    </div>
</html>
