<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>참조된 목록 조회</title>

        <link rel="stylesheet" href="/css/teamRoom/clock.css">
        <link rel="stylesheet" href="/css/homeUtil/calendar.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <script defer src="../js/util/calendar.js"></script>
        <script defer src="../js/teamRoom/teamList.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script defer src="/js/common/removeTag.js"></script>
        <link rel="stylesheet" href="/css/sign/list/listForReference.css">
        <script defer src="/js/sign/list/listForReference.js"></script>
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
                <span id="approveChangeSpan01" class="approveChangeSpan" onclick="location.href='/sign/write'">기안</span>
                <span id="approveChangeSpan02" onclick="location.href='/sign/listForWriter'">기안 목록</span>
                <span id="approveChangeSpan03" onclick="location.href='/sign/listForApprover'">결재할 목록</span>
                <span id="approveChangeSpan04" class="approveChangeSpan clickedApproveChangeSpan" onclick="location.href='/sign/listForReference'">참조된 목록</span>
            </div>
            <h5>결재 현황</h5>
            <div id="upperDiv">
                <div class="listBtn">
                    <h5>결재 진행</h5>
                    <h4 id="waitMark">0 건</h4>
                </div>
                <div class="listBtn">
                    <h5>결재 완료</h5>
                    <h4 id="approvalMark">0 건</h4>
                </div>
                <div class="listBtn">
                    <h5>반려</h5>
                    <h4 id="returnMark">0 건</h4>
                </div>
            </div>

            <div id="lowerDiv">
                <h5>결재 진행 목록</h5>
                <table border="1" id="wait">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>기안자</th>
                            <th>신청일</th>
                            <th>마지막 승인일</th>
                            <th>상태</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <br>
                
                <h5>결재 완료 목록</h5>
                <table border="1" id="approval">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>기안자</th>
                            <th>신청일</th>
                            <th>마지막 승인일</th>
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
                            <th>제목</th>
                            <th>기안자</th>
                            <th>신청일</th>
                            <th>마지막 승인일</th>
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
