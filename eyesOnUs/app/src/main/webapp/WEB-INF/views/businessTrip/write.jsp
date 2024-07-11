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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script defer src="/js/businessTrip/write.js"></script>
        <script defer src="/js/common/employeeList.js"></script>
        <script defer src="/js/common/projectList.js"></script>
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

        <div id="calendarContainer" class="calendar-container">
            <form action="/businessTrip/write" method="post">
                <!-- 사원 가져와서 출력 -->
                <label for="approverNo">승인자 선택</label>
                <select name="approverNo">
                    <option value="" selected>승인자를 선택하세요</option>
                </select>
                <br>

                <!-- 해당 프로젝트 가져와서 출력 -->
                <label for="proNo">프로젝트 선택</label>
                <select name="proNo">
                    <option value="" selected>프로젝트를 선택하세요</option>
                </select>
                <br>

                <label for="startDate">시작일</label>
                <input type="date" name="startDate">
                <br>

                <label for="endDate">종료일</label>
                <input type="date" name="endDate">
                <br>

                <textarea name="reason" placeholder="사유"></textarea>
                <br>

                <input type="text" name="destination" placeholder="출장지">
                <br>

                <input type="submit" value="신청">
            </form>
        </div>

        <div id="listContainer" class="list-container"></div>
    </body>
</html>
