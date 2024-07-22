<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>휴가 신청</title>

        <link rel="stylesheet" href="/css/teamRoom/clock.css">
        <link rel="stylesheet" href="/css/homeUtil/calendar.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <script defer src="../js/util/calendar.js"></script>
        <script defer src="../js/teamRoom/teamList.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            <c:if test="${not empty alertMsg}">
                alert("${alertMsg}");
            </c:if>
        </script>
        <c:remove var="alertMsg" scope="session"/>

        <link rel="stylesheet" href="/css/leave/write.css">
        <script defer src="/js/common/employeeList.js"></script>
        <script defer src="/js/leave/write/write.js"></script>
        <script defer src="/js/leave/write/leaveTypeList.js"></script>
        <script defer src="/js/leave/write/check.js"></script>
        <script defer src="/js/common/addTag.js"></script>
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
        <button id="sidebarBtn" class="open-btn">☰ Sidebar</button>

        <form onsubmit="return check();" action="/leave/write" method="post">
            <div id="calendarContainer" class="calendar-container">
                <h3>휴가 신청</h3>
                <div id="form">
                    <div id="startDate" class="formApponent first th">
                        <span>시작일</span>
                    </div>
                    <div id="startDateValue" class="formApponent first">
                        <input type="date" name="startDate">
                    </div>
                    <div id="endDate" class="formApponent first th">
                        <span>종료일</span>
                    </div>
                    <div id="endDateValue" class="formApponent first">
                        <input type="date" name="endDate">
                    </div>
                    <div id="project" class="formApponent second th">
                        <span>휴가 타입</span>
                    </div>
                    <div id="projectValue" class="formApponent second">
                        <select name="typeNo">
                            <option value="" selected>휴가 타입을 선택하세요</option>
                        </select>
                    </div>
                    <div id="destination" class="second"></div>
                    <div id="destinationValue" class="second"></div>
                    <div id="reason" class="formApponent third th">
                        <span>사유</span>
                    </div>
                    <div id="reasonValue" class="formApponent third">
                        <textarea name="reason"></textarea>
                    </div>
                    <div id="approver" class="formApponent th">
                        <span>승인자</span>
                    </div>
                    <div id="approverValue" class="formApponent">
                        <select name="approverNo">
                            <option value="" selected>승인자를 선택하세요</option>
                        </select>
                    </div>
                </div>
                <input type="submit" value="신청">
            </div>
        </form>

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
        <script src="/js/teamRoom/teamRoomSidebar.js"></script>
        <script src="/js/util/clock.js"></script>
    </body>
</html>
