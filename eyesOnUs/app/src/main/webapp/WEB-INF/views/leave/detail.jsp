<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>휴가 상세 조회</title>

        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <script defer src="/js/teamRoom/list.js"></script>
        <script defer src="/js/teamRoom/teamRoom.js"></script>
        <script defer src="/js/workTime/workTime.js"></script>
        <script defer src="/js/teamRoom/clock.js"></script>
        <link rel="stylesheet" href="/css/teamRoom/clock.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <link rel="stylesheet" href="/css/leave/detail.css">
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
            <h3>휴가 상세 조회</h3>
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
                <div id="leaveType" class="formApponent second th">
                    <span>휴가 타입</span>
                </div>
                <div id="leaveTypeValue" class="appApp second">
                    <span id="leaveTypeSpan">휴가 타입</span>
                </div>
                <div class="second"></div>
                <div class="second"></div>
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
        </div>

        <div id="listContainer" class="list-container"></div>
    </body>
</html>

<script>
    const leaveNo = "${leaveVo.no}";

    window.addEventListener("load", onPageLoad);

    function onPageLoad(){
        $.ajax({
            url: "/api/leave/detail",
            method: "get",
            data: {
                no: leaveNo,
            },
            success: (data) => {
                console.log("휴가 상세 조회 통신 성공");

                const startDateSpan = document.querySelector("#startDateSpan");
                const endDateSpan = document.querySelector("#endDateSpan");
                const leaveTypeSpan = document.querySelector("#leaveTypeSpan");
                const reasonPre = document.querySelector("#reasonPre");
                const approverSpan = document.querySelector("#approverSpan");
                const writerSpan = document.querySelector("#writerSpan");
                const enrollDateSpan = document.querySelector("#enrollDateSpan");
                const approveDateSpan = document.querySelector("#approveDateSpan");
                const stateSpan = document.querySelector("#stateSpan");

                startDateSpan.innerHTML = "";
                endDateSpan.innerHTML = "";
                leaveTypeSpan.innerHTML = "";
                reasonPre.innerHTML = "";
                approverSpan.innerHTML = "";
                writerSpan.innerHTML = "";
                enrollDateSpan.innerHTML = "";
                approveDateSpan.innerHTML = "";
                stateSpan.innerHTML = "";

                const startDate = data.leaveDetailVo.startDate.substring(0, 10);
                const endDate = data.leaveDetailVo.endDate.substring(0, 10);
                const leaveType = data.leaveDetailVo.leaveName;
                const reason = data.leaveDetailVo.reason;
                const approver = data.leaveApproverDetailVo.divName + " " + data.leaveApproverDetailVo.approverName + " " + data.leaveApproverDetailVo.positionName;
                const writer = data.leaveDetailVo.divName + " " + data.leaveDetailVo.empName + " " + data.leaveDetailVo.positionName;
                const enrollDate = data.leaveDetailVo.enrollDate.substring(0, 10);
                const approveDate = data.leaveDetailVo.approveDate ? data.leaveDetailVo.approveDate.substring(0, 10) : "";

                let state = ""
                if(data.leaveDetailVo.state === "0"){
                    state = "승인 대기";
                } else if(data.leaveDetailVo.state === "1"){
                    state = "승인";
                } else if(data.leaveDetailVo.state === "2"){
                    state = "반려";
                }

                startDateSpan.innerHTML = startDate;
                endDateSpan.innerHTML = endDate;
                leaveTypeSpan.innerHTML = leaveType;
                reasonPre.innerHTML = reason;
                approverSpan.innerHTML = approver;
                writerSpan.innerHTML = writer;
                enrollDateSpan.innerHTML = enrollDate;
                approveDateSpan.innerHTML = approveDate;
                stateSpan.innerHTML = state;

                if(data.leaveDetailVo.state === "0" && data.leaveDetailVo.approverNo === data.vo.empNo){
                    // 버튼 태그 담을 div 가져오기
                    const calendarContainerDiv = document.querySelector("#calendarContainer");
                    
                    // 버튼 태그 만들기
                    const btnTag01 = document.createElement("button");
                    const btnTag02 = document.createElement("button");

                    // 버튼 태그 텍스트 담기
                    btnTag01.innerHTML = "승인";
                    btnTag02.innerHTML = "반려";

                    // 버튼 태그 함수 담기
                    btnTag01.onclick = approveProcess;
                    btnTag02.onclick = returnProcess;

                    // 버튼 태그 붙이기
                    calendarContainerDiv.appendChild(btnTag01);
                    calendarContainerDiv.appendChild(btnTag02);
                }
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }
</script>

<script>
    // 승인 처리
    function approveProcess(){
        $.ajax({
            url: "/api/leave/approve",
            method: "put",
            data: {
                no: leaveNo
            },
            success: (data) => {
                console.log("출장 승인 처리 통신 성공");

            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }

    // 반려 처리
    function returnProcess(){
        $.ajax({
            url: "/api/leave/approve",
            method: "get",
            data: {
                no: leaveNo
            },
            success: (data) => {
                console.log("출장 반려 처리 통신 성공");
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }
</script>

<script>
    // 승인 처리
    function approveProcess(){
        if(confirm("휴가 승인 처리를 진행하겠습니까?")){
            approveProcessGoOn();
        } else{
            approveProcessCancel();
        }
    }

    // 승인 처리 (진행)
    function approveProcessGoOn(){
        $.ajax({
            url: "/api/leave/approve",
            method: "put",
            data: {
                no: leaveNo,
                state: "1"
            },
            success: (data) => {
                console.log("휴가 승인 처리 통신 성공");

                if(data.leaveApproveResult === 1){
                    alert("휴가 승인 완료");
                    window.location.href = "/leave/listForApprover";
                    return ;
                }
                alert("휴가 승인 실패");
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }

    // 승인 처리 (취소)
    function approveProcessCancel(){
        alert("휴가 승인 처리를 중지합니다.");
    }

    // 반려 처리
    function returnProcess(){
        if(confirm("휴가 반려 처리를 진행하겠습니까?")){
            returnProcessGoOn();
        } else{
            returnProcessCancel();
        }
    }

    // 반려 처리 (진행)
    function returnProcessGoOn(){
        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: {
                no: leaveNo,
                state: "2"
            },
            success: (data) => {
                console.log("휴가 반려 처리 통신 성공");

                if(data.leaveApproveResult === 1){
                    alert("휴가 반려 완료");
                    window.location.href = "/leave/listForApprover";
                    return ;
                }
                alert("휴가 반려 실패");
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }

    // 반려 처리 (취소)
    function returnProcessCancel(){
        alert("휴가 반려 처리를 중지합니다.");
    }
</script>
