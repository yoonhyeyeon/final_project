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
            <h3>출장 상세 조회</h3>
            <div id="form">
                <div id="startDate" class="formApponent first th">
                    <span>시작일</span>
                </div>
                <div id="startDateValue" class="appApp first">
                    <span id="startDateSpan">시작일</span>
                </div>
                <div id="endDate" class="formApponent first th">
                    <span>종료일</span>
                </div>
                <div id="endDateValue" class="appApp first">
                    <span id="endDateSpan">종료일</span>
                </div>
                <div id="project" class="formApponent second th">
                    <span>프로젝트</span>
                </div>
                <div id="projectValue" class="appApp second">
                    <span id="projectSpan">프로젝트</span>
                </div>
                <div id="destination" class="formApponent second th">
                    <span>출장지</span>
                </div>
                <div id="destinationValue" class="appApp second">
                    <span id="destinationSpan">출장지</span>
                </div>
                <div id="reason" class="formApponent third th">
                    <span>사유</span>
                </div>
                <div id="reasonValue" class="appApp third">
                    <pre id="reasonPre">사유</pre>
                </div>
                <div id="approver" class="formApponent th">
                    <span>승인자</span>
                </div>
                <div id="approverValue" class="appApp">
                    <span id="approverSpan">승인자</span>
                </div>
                <div id="writer" class="formApponent th">
                    <span>신청자</span>
                </div>
                <div id="writerValue" class="appApp">
                    <span id="writerSpan">신청자</span>
                </div>
                <div id="enrollDate" class="formApponent th forth">
                    <span>신청일</span>
                </div>
                <div id="enrollDateValue" class="appApp forth">
                    <span id="enrollDateSpan">신청일</span>
                </div>
                <div id="approveDate" class="formApponent th forth">
                    <span>승인일</span>
                </div>
                <div id="approveDateValue" class="appApp forth">
                    <span id="approveDateSpan">승인일</span>
                </div>
                <div id="state" class="formApponent th fifth">
                    <span>승인 상태</span>
                </div>
                <div id="stateValue" class="appApp fifth">
                    <span id="stateSpan">승인 상태</span>
                </div>
                <div class="fifth"></div>
                <div class="fifth"></div>
            </div>
            <button onclick="">승인</button>
            <button onclick="">반려</button>
        </div>

        <div id="listContainer" class="list-container"></div>
    </body>
</html>

<script>
    window.addEventListener("load", onPageLoad);

    function onPageLoad(){
        const businessTripNo = "${businessTripVo.no}";

        $.ajax({
            url: "/api/businessTrip/detail",
            method: "get",
            data: {
                no: businessTripNo
            },
            success: (data) => {
                console.log("출장 상세 조회 통신 성공");

                const startDateSpan = document.querySelector("#startDateSpan");
                const endDateSpan = document.querySelector("#endDateSpan");
                const projectSpan = document.querySelector("#projectSpan");
                const destinationSpan = document.querySelector("#destinationSpan");
                const reasonPre = document.querySelector("#reasonPre");
                const approverSpan = document.querySelector("#approverSpan");
                const writerSpan = document.querySelector("#writerSpan");
                const enrollDateSpan = document.querySelector("#enrollDateSpan");
                const approveDateSpan = document.querySelector("#approveDateSpan");
                const stateSpan = document.querySelector("#stateSpan");

                startDateSpan.innerHTML = "";
                endDateSpan.innerHTML = "";
                projectSpan.innerHTML = "";
                destinationSpan.innerHTML = "";
                reasonPre.innerHTML = "";
                approverSpan.innerHTML = "";
                writerSpan.innerHTML = "";
                enrollDateSpan.innerHTML = "";
                approveDateSpan.innerHTML = "";
                stateSpan.innerHTML = "";

                const startDate = data.businessTripDetailVo.startDate.substring(0, 10);
                const endDate = data.businessTripDetailVo.endDate.substring(0, 10);
                const project = data.businessTripDetailVo.proName;
                const destination = data.businessTripDetailVo.destination;
                const reason = data.businessTripDetailVo.reason;
                const approver = data.businessTripApproverDetailVo.divName + " " + data.businessTripApproverDetailVo.approverName + " " + data.businessTripApproverDetailVo.positionName;
                const writer = data.businessTripDetailVo.divName + " " + data.businessTripDetailVo.empName + " " + data.businessTripDetailVo.positionName;
                const enrollDate = data.businessTripDetailVo.enrollDate.substring(0, 10);
                const approveDate = data.businessTripDetailVo.approveDate ? data.businessTripDetailVo.approveDate.substring(0, 10) : "";
                
                let state = ""
                if(data.businessTripDetailVo.state === "0"){
                    state = "승인 대기";
                } else if(data.businessTripDetailVo.state === "1"){
                    state = "승인";
                } else if(data.businessTripDetailVo.state === "2"){
                    state = "반려";
                }

                startDateSpan.innerHTML = startDate;
                endDateSpan.innerHTML = endDate;
                projectSpan.innerHTML = project;
                destinationSpan.innerHTML = destination;
                reasonPre.innerHTML = reason;
                approverSpan.innerHTML = approver;
                writerSpan.innerHTML = writer;
                enrollDateSpan.innerHTML = enrollDate;
                approveDateSpan.innerHTML = approveDate;
                stateSpan.innerHTML = state;
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }
</script>
