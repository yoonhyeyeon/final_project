<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>TEAM ROOM</title>
      <link rel="stylesheet" href="/css/teamRoom/clock.css">
      <link rel="stylesheet" href="/css/homeUtil/calendar.css">
      <link rel="stylesheet" href="/css/teamRoom/list.css">
      <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
      <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
      <script defer src="../js/util/calendar.js"></script>
      <script defer src="../js/teamRoom/teamList.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
        <div id="out">
              <c:if test="${sessionScope.loginMemberVo.no == null}">
                  <h2>로그인하고 와주세요</h2>
                  <h5 style="color: gray;">로그아웃 상태에서는 기타일정 기능만 사용 가능합니다.</h5>
              </c:if>
              <c:if test="${sessionScope.loginMemberVo.no != null}">
                <!-- 여기에 **본문** 내용을 추가할 수 있습니다 -->
                 <div id="calendar"></div>
              </c:if>
        </div>
      </div>

      <div id="listContainer" class="list-container">
              <div id="out">
                    <c:if test="${sessionScope.loginMemberVo.no == null}">
                    </c:if>
                    <c:if test="${sessionScope.loginMemberVo.no != null}">
                        <!-- 여기에 **서브** 내용을 추가할 수 있습니다 -->
                        <%@ include file="/WEB-INF/views/teamRoom/list.jsp" %>
                    </c:if>
              </div>
      </div>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="/js/teamRoom/list.js"></script>
      <script src="/js/teamRoom/teamRoom.js"></script>
      <script src="/js/util/clock.js"></script>

    </body>

    </html>