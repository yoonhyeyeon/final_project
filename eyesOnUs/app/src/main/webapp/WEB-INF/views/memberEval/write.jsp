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
    <link rel="stylesheet" type="text/css" href="/css/memberEval/memberWrite.css">
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

  <div class="out">
    <h2>팀원 평가</h2>
    <div id="date">
      <span id="dateItem">기한 : 2024-07-02&nbsp;&nbsp;</span><span>~&nbsp;&nbsp;2024-07-30</span>
    </div>

    <hr>
    <div id="form">
      <span>평가자&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <select id="evaluatorNo">
           <c:forEach var="vo" items="${voList}">
               <c:if test="${sessionScope.loginMemberVo.no == vo.no}">
                <option value="${vo.no}">${vo.no} : ${vo.name}</option>
               </c:if>
           </c:forEach>
      </select>
      <br>
      <br>
      <span>평가 대상&nbsp;</span>
      <select id="evaluateeNo" name="evaluateeNo">
          <option value="">------선택------</option>
          <c:forEach var="vo" items="${voList}">
              <option value="${vo.no}" ${vo.no == selectedEvaluateeNo ? 'selected' : ''}>${vo.name}</option>
          </c:forEach>
      </select>
      <p>잠재력</p>
      <div class="myform">
        <fieldset>
          <input type="radio" name="potential" value="100" id="rate1">
          <label for="rate1">★</label>
          <input type="radio" name="potential" value="90" id="rate2">
          <label for="rate2">★</label>
          <input type="radio" name="potential" value="80" id="rate3">
          <label for="rate3">★</label>
          <input type="radio" name="potential" value="70" id="rate4">
          <label for="rate4">★</label>
          <input type="radio" name="potential" value="60" id="rate5">
          <label for="rate5">★</label>
          <input type="radio" name="potential" value="50" id="rate6">
          <label for="rate6">★</label>
          <input type="radio" name="potential" value="40" id="rate7">
          <label for="rate7">★</label>
          <input type="radio" name="potential" value="30" id="rate8">
          <label for="rate8">★</label>
          <input type="radio" name="potential" value="20" id="rate9">
          <label for="rate9">★</label>
          <input type="radio" name="potential" value="10" id="rate10">
          <label for="rate10">★</label>
        </fieldset>
      </div>
      <p id="communication">소통력</p>
      <div class="myform2">
        <fieldset>
          <input type="radio" name="communication" value="100" id="rate11">
          <label for="rate11">★</label>
          <input type="radio" name="communication" value="90" id="rate12">
          <label for="rate12">★</label>
          <input type="radio" name="communication" value="80" id="rate13">
          <label for="rate13">★</label>
          <input type="radio" name="communication" value="70" id="rate14">
          <label for="rate14">★</label>
          <input type="radio" name="communication" value="60" id="rate15">
          <label for="rate15">★</label>
          <input type="radio" name="communication" value="50" id="rate16">
          <label for="rate16">★</label>
          <input type="radio" name="communication" value="40" id="rate17">
          <label for="rate17">★</label>
          <input type="radio" name="communication" value="30" id="rate18">
          <label for="rate18">★</label>
          <input type="radio" name="communication" value="20" id="rate19">
          <label for="rate19">★</label>
          <input type="radio" name="communication" value="10" id="rate20">
          <label for="rate20">★</label>
        </fieldset>
      </div>
      <p id="problemSolve">문제해결력</p>
      <div class="myform3">
        <fieldset>
          <input type="radio" name="problemSolve" value="100" id="rate21">
          <label for="rate21">★</label>
          <input type="radio" name="problemSolve" value="90" id="rate22">
          <label for="rate22">★</label>
          <input type="radio" name="problemSolve" value="80" id="rate23">
          <label for="rate23">★</label>
          <input type="radio" name="problemSolve" value="70" id="rate24">
          <label for="rate24">★</label>
          <input type="radio" name="problemSolve" value="60" id="rate25">
          <label for="rate25">★</label>
          <input type="radio" name="problemSolve" value="50" id="rate26">
          <label for="rate26">★</label>
          <input type="radio" name="problemSolve" value="40" id="rate27">
          <label for="rate27">★</label>
          <input type="radio" name="problemSolve" value="30" id="rate28">
          <label for="rate28">★</label>
          <input type="radio" name="problemSolve" value="20" id="rate29">
          <label for="rate29">★</label>
          <input type="radio" name="problemSolve" value="10" id="rate30">
          <label for="rate30">★</label>
        </fieldset>
      </div>
      <p id="responsibility">책임감</p>
      <div class="myform4">
        <fieldset>
          <input type="radio" name="responsibility" value="100" id="rate31">
          <label for="rate31">★</label>
          <input type="radio" name="responsibility" value="90" id="rate32">
          <label for="rate32">★</label>
          <input type="radio" name="responsibility" value="80" id="rate33">
          <label for="rate33">★</label>
          <input type="radio" name="responsibility" value="70" id="rate34">
          <label for="rate34">★</label>
          <input type="radio" name="responsibility" value="60" id="rate35">
          <label for="rate35">★</label>
          <input type="radio" name="responsibility" value="50" id="rate36">
          <label for="rate36">★</label>
          <input type="radio" name="responsibility" value="40" id="rate37">
          <label for="rate37">★</label>
          <input type="radio" name="responsibility" value="30" id="rate38">
          <label for="rate38">★</label>
          <input type="radio" name="responsibility" value="20" id="rate39">
          <label for="rate39">★</label>
          <input type="radio" name="responsibility" value="10" id="rate40">
          <label for="rate40">★</label>
        </fieldset>
      </div>
      <div id="say">
        <p>칭찬할 점</p>
        <textarea name="compliment" id="compliment"></textarea>
        <p>아쉬운 점</p>
        <textarea name="disappointment" id="disappointment"></textarea>
        <p>하고싶은 말</p>
        <textarea name="suggestion" id="suggestion"></textarea>
      </div>
      <br>
      <button onclick="write01();" id="sub">평가완료</button>
    </div>
    <br>
  </div>

</div>

<div id="listContainer" class="list-container">
  <!-- 여기에 **서브** 내용을 추가할 수 있습니다 -->
  <%@ include file="/WEB-INF/views/teamRoom/list.jsp" %>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/teamRoom/list.js"></script>
<script src="/js/teamRoom/teamRoom.js"></script>
<script defer src="../js/memberEval/memberWrite.js"></script>

</body>
</html>
