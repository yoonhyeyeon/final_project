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
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <link rel="stylesheet" href="/css/prjManager/managerList.css">
          <script defer src="/js/prjManager/managerList.js"></script>
          <script defer src="/js/prjManager/managerDelete.js"></script>
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
    <button id="sidebarBtn" class="open-btn">☰ Sidebar</button>
    <c:if test="${sessionScope.loginMemberVo.rank eq 20 }">
        <div id="calendarContainer" class="calendar-container">
            <div id="out">
                <div id="in">
                    <table>
                        <thead>
                            <tr>
                                <td>프로젝트 번호</td>
                                <td>담당자</td>
                                <td>담당자 코드</td>
                                <td>담당자 해임</td>
                            </tr>
                        </thead>
                        <tbody>
    
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="divSearch">
                <select name="search" id="search">
                    <option value="1">프로젝트번호</option>
                </select>
                <input type="text" name="ProNo" id="ProNo">
                <button id="searchBtn" onclick="saerchPrjNo();">검색</button>
            </div>
        </div>
        <div id="listContainer" class="list-container">
    
        </div>
    </c:if>
  <c:if test="${empty sessionScope.loginMemberVo.no}">
      <h1>로그인하고 오세요</h1>
      <div id="listContainer" class="list-container"></div>
  </c:if>
  <c:if test="${sessionScope.loginMemberVo.rank ne 20}">
    <div id="notLogin">
        <h1>권한이 없습니다</h1><br><br>
        <a href="http://127.0.0.1:8383/project/projectMain">돌아가기</a>
    </div>
<div id="listContainer" class="list-container">
</div>
</c:if>
  
  
  
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/js/teamRoom/teamRoom.js"></script>
    <script src="/js/util/clock.js"></script>
  </body>
      <div id="sidebar" class="sidebar">
        <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
      </div>
  </html>
  
  


