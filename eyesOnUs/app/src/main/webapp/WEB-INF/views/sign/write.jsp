<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>기안</title>

        <link rel="stylesheet" href="/css/teamRoom/clock.css">
        <link rel="stylesheet" href="/css/homeUtil/calendar.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
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

        <link rel="stylesheet" href="/css/sign/write.css">
        <script defer src="/js/sign/write/write.js"></script>
        <script defer src="/js/sign/write/approverList.js"></script>
        <script defer src="/js/sign/write/addRefNo.js"></script>
        <script defer src="/js/sign/write/check.js"></script>
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

        <form onsubmit="return check();" action="/sign/write" method="post" enctype="multipart/form-data">
            <div id="calendarContainer" class="calendar-container">
                <h3>기안</h3>
                <div id="form">
                    <div id="titleDiv" class="formApponent th first">
                        <span>제목</span>
                    </div>
                    <div class="formApponent first">
                        <input type="text" name="title">
                    </div>
                    <div id="contentDiv" class="formApponent th second">
                        <span>내용</span>
                    </div>
                    <div class="formApponent second">
                        <input type="text" name="content">
                    </div>
                    <div id="fileDiv" class="formApponent th third">
                        <span>결재 파일</span>
                    </div>
                    <div class="formApponent third">
                        <input type="file" name="file">
                    </div>
                    <div id="firstApproverDiv" class="formApponent th forth">
                        <span>1차 결재자</span>
                    </div>
                    <div class="formApponent forth">
                        <select id="firstApproverSelect" name="approverNo[]">
                            <option value="" selected>1차 결재자를 선택하세요</option>
                        </select>
                    </div>
                    <div id="secondApproverDiv" class="formApponent th fifth">
                        <span>2차 결재자</span>
                    </div>
                    <div class="formApponent fifth">
                        <select id="secondApproverSelect" name="approverNo[]">
                            <option value="" selected>2차 결재자를 선택하세요</option>
                        </select>
                    </div>
                    <div id="thirdApproverDiv" class="formApponent th sixth">
                        <span>3차 결재자</span>
                    </div>
                    <div class="formApponent sixth">
                        <select id="thirdApproverSelect" name="approverNo[]">
                            <option value="" selected>3차 결재자를 선택하세요</option>
                        </select>
                    </div>
                    <div id="refDiv" class="formApponent th">
                        <span>참조자</span>
                    </div>
                    <div id="refSelectDiv" class="formApponent">
                        <select id="refSelect" name="refNo[]">
                            <option value="" selected>참조자를 선택하세요</option>
                        </select>
                        <button type="button" onclick="addRefNo();">참조자 추가</button>
                    </div>
                </div>
                <input type="submit" value="기안">
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
