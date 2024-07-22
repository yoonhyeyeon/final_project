<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>출장 상세 조회</title>

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
   
            <div id="team-List-table">
                <!-- 팀원목록을 표시할 div 추가 -->
                <%@ include file="/WEB-INF/views/teamRoom/teamList.jsp" %>
            </div>
        </div>

        <div id="sidebar" class="sidebar">
            <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
        </div>
        <button id="sidebarBtn" class="open-btn">☰ Sidebar</button>

        <div id="calendarContainer" class="calendar-container">
            <h3>출장 상세 조회</h3>
            <div id="form">
                <div id="startDate" class="formApponent first th">
                    <span>시작일</span>
                </div>
                <div id="startDateValue" class="appApp first">
                    <span id="startDateSpan"></span>
                </div>
                <div id="endDate" class="formApponent first th">
                    <span>종료일</span>
                </div>
                <div id="endDateValue" class="appApp first">
                    <span id="endDateSpan"></span>
                </div>
                <div id="project" class="formApponent second th">
                    <span>프로젝트</span>
                </div>
                <div id="projectValue" class="appApp second">
                    <span id="projectSpan"></span>
                </div>
                <div id="destination" class="formApponent second th">
                    <span>출장지</span>
                </div>
                <div id="destinationValue" class="appApp second">
                    <span id="destinationSpan"></span>
                </div>
                <div id="reason" class="formApponent third th">
                    <span>사유</span>
                </div>
                <div id="reasonValue" class="appApp third">
                    <pre id="reasonPre"></pre>
                </div>
                <div id="approver" class="formApponent th">
                    <span>승인자</span>
                </div>
                <div id="approverValue" class="appApp">
                    <span id="approverSpan"></span>
                </div>
                <div id="writer" class="formApponent th">
                    <span>신청자</span>
                </div>
                <div id="writerValue" class="appApp">
                    <span id="writerSpan"></span>
                </div>
                <div id="enrollDate" class="formApponent th forth">
                    <span>신청일</span>
                </div>
                <div id="enrollDateValue" class="appApp forth">
                    <span id="enrollDateSpan"></span>
                </div>
                <div id="approveDate" class="formApponent th forth">
                    <span>승인일</span>
                </div>
                <div id="approveDateValue" class="appApp forth">
                    <span id="approveDateSpan"></span>
                </div>
                <div id="state" class="formApponent th fifth">
                    <span>승인 상태</span>
                </div>
                <div id="stateValue" class="appApp fifth">
                    <span id="stateSpan"></span>
                </div>
                <div class="fifth"></div>
                <div class="fifth"></div>
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
        <script src="/js/teamRoom/teamRoomSidebar.js"></script>
        <script src="/js/util/clock.js"></script>
    </body>
</html>

<script>
    const businessTripNo = "${businessTripVo.no}";
    
    window.addEventListener("DOMContentLoaded", onPageLoad);

    function onPageLoad(){
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

                removeTag(startDateSpan);
                removeTag(endDateSpan);
                removeTag(projectSpan);
                removeTag(destinationSpan);
                removeTag(reasonPre);
                removeTag(approverSpan);
                removeTag(writerSpan);
                removeTag(enrollDateSpan);
                removeTag(approveDateSpan);
                removeTag(stateSpan);

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

                startDateSpan.innerText = startDate;
                endDateSpan.innerText = endDate;
                projectSpan.innerText = project;
                destinationSpan.innerText = destination;
                reasonPre.innerText = reason;
                approverSpan.innerText = approver;
                writerSpan.innerText = writer;
                enrollDateSpan.innerText = enrollDate;
                approveDateSpan.innerText = approveDate;
                stateSpan.innerText = state;

                if(data.businessTripDetailVo.state === "0" && data.businessTripDetailVo.approverNo === data.vo.empNo){
                    // 버튼 태그 담을 div 가져오기
                    const calendarContainerDiv = document.querySelector("#calendarContainer");

                    // 버튼 태그 담을 div 태그 만들기
                    const btnDiv = document.createElement("div");
                    btnDiv.id = "approveBtnDiv";
                    
                    // 버튼 태그 만들기
                    const btnTag01 = document.createElement("button");
                    const btnTag02 = document.createElement("button");

                    // 버튼 태그 텍스트 담기
                    btnTag01.innerText = "승인";
                    btnTag02.innerText = "반려";

                    // 버튼 태그 함수 담기
                    btnTag01.onclick = approveProcess;
                    btnTag02.onclick = returnProcess;

                    // 버튼 태그 붙이기
                    btnDiv.appendChild(btnTag01);
                    btnDiv.appendChild(btnTag02);

                    // div 태그 붙이기
                    calendarContainerDiv.appendChild(btnDiv);
                }
            },
            error: (error) => {
                console.log("출장 상세 조회 통신 실패");
                console.log(error);
            }
        });
    }
</script>

<script>
    // 승인 처리
    function approveProcess(){
        if(confirm("출장 승인 처리를 진행하겠습니까?")){
            approveProcessGoOn();
        } else{
            approveProcessCancel();
        }
    }

    // 승인 처리 (진행)
    function approveProcessGoOn(){
        $.ajax({
            url: "/api/businessTrip/approve",
            method: "put",
            data: {
                no: businessTripNo,
                state: "1"
            },
            success: (data) => {
                console.log("출장 승인 처리 통신 성공");

                if(data.businessTripApproveResult === 1){
                    alert("출장 승인 완료");
                    window.location.href = "/businessTrip/listForApprover";
                    return ;
                }
                alert("출장 승인 실패");
            },
            error: (error) => {
                console.log("출장 승인 처리 통신 실패");
                console.log(error);
            }
        });
    }

    // 승인 처리 (취소)
    function approveProcessCancel(){
        alert("출장 승인 처리를 중지합니다.");
    }

    // 반려 처리
    function returnProcess(){
        if(confirm("출장 반려 처리를 진행하겠습니까?")){
            returnProcessGoOn();
        } else{
            returnProcessCancel();
        }
    }

    // 반려 처리 (진행)
    function returnProcessGoOn(){
        $.ajax({
            url: "/api/businessTrip/approve",
            method: "put",
            data: {
                no: businessTripNo,
                state: "2"
            },
            success: (data) => {
                console.log("출장 반려 처리 통신 성공");

                if(data.businessTripApproveResult === 1){
                    alert("출장 반려 완료");
                    window.location.href = "/businessTrip/listForApprover";
                    return ;
                }
                alert("출장 반려 실패");
            },
            error: (error) => {
                console.log("출장 반려 처리 통신 실패");
                console.log(error);
            }
        });
    }

    // 반려 처리 (취소)
    function returnProcessCancel(){
        alert("출장 반려 처리를 중지합니다.");
    }
</script>
