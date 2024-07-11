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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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
            <h5>휴가 상세 조회</h5>
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
        </div>

        <div id="listContainer" class="list-container"></div>
    </body>
</html>

<script>
    window.addEventListener("load", onPageLoad);

    function onPageLoad(){
        const leaveNo = "${leaveVo.no}";

        $.ajax({
            url: "/api/leave/detail",
            method: "get",
            data: {
                no: leaveNo
            },
            success: (data) => {
                console.log("휴가 상세 조회 통신 성공");

                const waitTable = document.querySelector("#wait > tbody");
                waitTable.innerHTML = "";
                const trTag = document.createElement("tr");
                let waitTableCnt = 1;

                const tdTag01 = addTag("td", waitTableCnt);
                const tdTag02 = addTag("td", data.leaveDetailVo.leaveName);
                const tdTag03 = addTag("td", data.leaveDetailVo.reason);
                const tdTag04 = addTag("td", data.leaveDetailVo.divName + " " + data.leaveDetailVo.empName + " " + data.leaveDetailVo.positionName);
                const tdTag05 = addTag("td", data.leaveApproverDetailVo.divName + " " + data.leaveApproverDetailVo.approverName + " " + data.leaveApproverDetailVo.positionName);

                const enrollDate = data.leaveDetailVo.enrollDate.substring(0, 10);
                const approveDate = data.leaveDetailVo.approveDate ? data.leaveDetailVo.approveDate.substring(0, 10) : "";

                const tdTag06 = addTag("td", enrollDate);
                const tdTag07 = addTag("td", approveDate);

                let tdTag08 = "";
                if(data.leaveDetailVo.state === "0"){
                    tdTag08 = addTag("td", "승인 대기");
                } else if(data.leaveDetailVo.state === "1"){
                    tdTag08 = addTag("td", "승인 완료");
                } else if(data.leaveDetailVo.state === "2"){
                    tdTag08 = addTag("td", "반려");
                }

                trTag.appendChild(tdTag01);
                trTag.appendChild(tdTag02);
                trTag.appendChild(tdTag03);
                trTag.appendChild(tdTag04);
                trTag.appendChild(tdTag05);
                trTag.appendChild(tdTag06);
                trTag.appendChild(tdTag07);
                trTag.appendChild(tdTag08);

                waitTable.appendChild(trTag);
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }
</script>
