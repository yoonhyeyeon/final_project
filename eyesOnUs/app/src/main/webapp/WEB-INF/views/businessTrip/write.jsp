<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>출장 신청</title>

        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <script defer src="/js/teamRoom/list.js"></script>
        <script defer src="/js/teamRoom/teamRoom.js"></script>
        <script defer src="/js/workTime/workTime.js"></script>
        <script defer src="/js/teamRoom/clock.js"></script>
        <link rel="stylesheet" href="/css/teamRoom/clock.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <link rel="stylesheet" href="/css/businessTrip/write.css">
        <script defer src="/js/common/employeeList.js"></script>
        <script defer src="/js/businessTrip/write/write.js"></script>
        <script defer src="/js/businessTrip/write/projectList.js"></script>
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
        </div>

        <div id="sidebar" class="sidebar">
            <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
        </div>
        <button id="openBtn" class="open-btn">☰ Sidebar</button>

        <form action="/businessTrip/write" method="post">
            <div id="calendarContainer" class="calendar-container">
                <h3>출장 신청</h3>
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
                        <span>프로젝트</span>
                    </div>
                    <div id="projectValue" class="formApponent second">
                        <select name="proNo">
                            <option value="" selected>프로젝트를 선택하세요</option>
                        </select>
                    </div>
                    <div id="destination" class="formApponent second th">
                        <span>출장지</span>
                    </div>
                    <div id="destinationValue" class="formApponent second">
                        <input type="text" name="destination">
                    </div>
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

        <div id="listContainer" class="list-container"></div>
    </body>
</html>
