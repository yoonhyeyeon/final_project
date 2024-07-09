<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>출장 상세 조회</title>

        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <script defer src="/js/teamRoom/list.js"></script>
        <script defer src="/js/teamRoom/teamRoom.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <link rel="stylesheet" href="/css/businessTrip/detail.css">
        <script defer src="/js/businessTrip/detail.js"></script>
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
            <h5>출장 상세 조회</h5>
            <table border="1" id="wait">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>사유</th>
                        <th>신청자</th>
                        <th>승인자</th>
                        <th>신청일</th>
                        <th>승인일</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>

        <div id="listContainer" class="list-container">
            <button>출장 신청</button>
            <button>출장 목록 조회</button>
            <button>승인할 출장 목록</button>
        </div>
    </body>
</html>
