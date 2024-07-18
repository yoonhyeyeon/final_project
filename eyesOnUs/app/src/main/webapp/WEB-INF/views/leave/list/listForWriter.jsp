<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>신청한 휴가 목록 조회</title>

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

        <link rel="stylesheet" href="/css/leave/list/listForWriter.css">
        <script defer src="/js/leave/list/listForWriter.js"></script>
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
        <button id="openBtn" class="open-btn">☰ Sidebar</button>

        <div id="calendarContainer" class="calendar-container">
            <div id="approveChange">
                <span id="approveChangeSpan01" class="approveChangeSpan" onclick="location.href='/leave/write'">휴가 신청</span>
                <span id="approveChangeSpan02" class="clickedApproveChangeSpan" onclick="location.href='/leave/listForWriter'">신청한 휴가</span>
                <span id="approveChangeSpan03" class="approveChangeSpan" onclick="location.href='/leave/listForApprover'" >승인할 휴가</span>
            </div>
            <h5>휴가 승인 현황</h5>
            <div id="upperDiv">
                <div class="listBtn">
                    <h5>승인 대기</h5>
                    <h4 id="waitMark">0 건</h4>
                </div>
                <div class="listBtn">
                    <h5>승인 완료</h5>
                    <h4 id="approvalMark">0 건</h4>
                </div>
                <div class="listBtn">
                    <h5>반려</h5>
                    <h4 id="returnMark">0 건</h4>
                </div>
            </div>

            <div id="lowerDiv">
                <h5>휴가 승인 대기 목록</h5>
                <table border="1" id="wait">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>휴가 타입</th>
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
                <br>
                
                <h5>휴가 승인 목록</h5>
                <table border="1" id="approval">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>휴가 타입</th>
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
                <br>
    
                <h5>반려 목록</h5>
                <table border="1" id="return">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>휴가 타입</th>
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
