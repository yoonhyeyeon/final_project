<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>결재 상세 조회</title>

        <link rel="stylesheet" href="/css/teamRoom/clock.css">
        <link rel="stylesheet" href="/css/homeUtil/calendar.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <script defer src="../js/util/calendar.js"></script>
        <script defer src="../js/teamRoom/teamList.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script defer src="/js/sign/detail/fileModal.js"></script>
        <link rel="stylesheet" href="/css/sign/detail/fileModal.css">
        <link rel="stylesheet" href="/css/sign/detail/detail.css">

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
            <h3>결재 상세 조회</h3>
            <div id="form">
                <div id="approverDiv" class="th first">
                    <span>결재</span>
                </div>
                <div id="approverLayout" class="first">
                    <div id="firstApprover" class="th top">
                    </div>
                    <div id="secondApprover" class="th top">
                    </div>
                    <div id="thirdApprover" class="th top">
                    </div>
                    <div id="firstApproverState" class="state">
                    </div>
                    <div id="secondApproverState" class="state">
                    </div>
                    <div id="thirdApproverState" class="state">
                    </div>
                </div>
                <div id="titleDiv" class="th second">
                    <span>제목</span>
                </div>
                <div id="titleValueDiv" class="appApp second">
                </div>
                <div id="contentDiv" class="th third">
                    <span>내용</span>
                </div>
                <div id="contentValueDiv" class="appApp third">
                </div>
                <div id="writerDiv" class="th forth">
                    <span>기안자</span>
                </div>
                <div id="writerValueDiv" class="appApp forth">
                </div>
                <div id="refDiv" class="th forth">
                    <span>참조자</span>
                </div>
                <div id="refValueDiv" class="appApp forth">
                </div>
                <div id="enrollDateDiv" class="th fifth">
                    <span>기안일</span>
                </div>
                <div id="enrollDateValueDiv" class="appApp fifth">
                </div>
                <div id="lastApproveDateDiv" class="th fifth">
                    <span>마지막 승인일</span>
                </div>
                <div id="lastApproveDateValueDiv" class="appApp fifth">
                </div>
                <div id="fileDiv" class="th">
                    <span>첨부파일</span>
                </div>
                <div id="fileValueDiv" class="appApp">
                    <input type="file" name="file">
                </div>
                <div id="commentDiv" class="th">
                    <span>첨언</span>
                </div>
                <div id="commentValueInput">
                    <textarea name="commentArea" id="commentArea"></textarea>
                </div>
            </div>
            <div id="approveBtnDiv">
                <button id="openModalBtn" onclick="openModal();">결재파일 열기</button>
            </div>
        </div>

        <div id="modalDiv">
            <div id="modalContentDiv">
                <iframe id="fileIframe" name="file" src="" width="100%" height="100%"></iframe>
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

<script>
    const signNo = "${signVo.no}";
    let result = "${signVo.result}";
    let step = "${signVo.step}";

    window.addEventListener("load", onPageLoad);

    function onPageLoad(){
        $.ajax({
            url: "/api/sign/detail",
            method: "get",
            data: {
                no: signNo,
            },
            success: (data) => {
                console.log("결재 상세 조회 통신 성공");

                document.querySelector("input[name=file]").disabled = true;
                document.querySelector("textarea[name=commentArea]").disabled = true;

                // div 태그 가져오기
                const titleValueDiv = document.querySelector("#titleValueDiv");
                const contentValueDiv = document.querySelector("#contentValueDiv");
                const writerValueDiv = document.querySelector("#writerValueDiv");
                const enrollDateValueDiv = document.querySelector("#enrollDateValueDiv");
                const lastApproveDateValueDiv = document.querySelector("#lastApproveDateValueDiv");

                // div 태그 비우기
                titleValueDiv.innerHTML = "";
                contentValueDiv.innerHTML = "";
                writerValueDiv.innerHTML = "";
                enrollDateValueDiv.innerHTML = "";
                lastApproveDateValueDiv.innerHTML = "";

                // div 태그에 들어갈 span 태그 생성
                const titleValueSpan = addTag("span", data.signDetailVo.title);
                const contentValueSpan = addTag("span", data.signDetailVo.content);
                const writerValueSpan = addTag("span", data.signDetailVo.divName + " " + data.signDetailVo.empName + " " + data.signDetailVo.positionName);
                const enrollDateValueSpan = addTag("span", data.signDetailVo.enrollDate.substring(0, 10));
                const lastApproveDateValueSpan = addTag("span", data.signDetailVo.modifyDate ? data.signDetailVo.modifyDate.substring(0, 10) : "");

                // div 태그에 span 태그 붙이기
                titleValueDiv.appendChild(titleValueSpan);
                contentValueDiv.appendChild(contentValueSpan);
                writerValueDiv.appendChild(writerValueSpan);
                enrollDateValueDiv.appendChild(enrollDateValueSpan);
                lastApproveDateValueDiv.appendChild(lastApproveDateValueSpan);

                getApproverAndReferenceDetailList(data);
            },
            error: (error) => {
                console.log("결재 상세 조회 통신 실패");
                console.log(error);
            }
        });
    }

    function getApproverAndReferenceDetailList(extData){
        $.ajax({
            url: "/api/sign/detailList",
            method: "get",
            data: {
                no: signNo,
            },
            success: (data) => {
                console.log("결재자, 참조자 상세 리스트 통신 성공");

                // 결재자 div 태그 가져오기
                const firstApproverDiv = document.querySelector("#firstApprover");
                const secondApproverDiv = document.querySelector("#secondApprover");
                const thirdApproverDiv = document.querySelector("#thirdApprover");

                // 결재 상태 div 태그 가져오기
                const firstApproverStateDiv = document.querySelector("#firstApproverState");
                const secondApproverStateDiv = document.querySelector("#secondApproverState");
                const thirdApproverStateDiv = document.querySelector("#thirdApproverState");

                // 결재자 div 태그 비우기
                firstApproverDiv.innerHTML = "";
                secondApproverDiv.innerHTML = "";
                thirdApproverDiv.innerHTML = "";

                // 결재 상태 div 태그 비우기
                firstApproverStateDiv.innerHTML = "";
                secondApproverStateDiv.innerHTML = "";
                thirdApproverStateDiv.innerHTML = "";

                // 결재자 div 태그에 들어갈 span 태그 생성
                const approverSpanTag01 = addTag("span", data.signApproverDetailVoList[0].divName + " " + data.signApproverDetailVoList[0].empName + " " + data.signApproverDetailVoList[0].positionName);
                const approverSpanTag02 = addTag("span", data.signApproverDetailVoList[1].divName + " " + data.signApproverDetailVoList[1].empName + " " + data.signApproverDetailVoList[1].positionName);
                const approverSpanTag03 = addTag("span", data.signApproverDetailVoList[2].divName + " " + data.signApproverDetailVoList[2].empName + " " + data.signApproverDetailVoList[2].positionName);

                // 결재 상태 div 태그에 들어갈 span 태그 생성
                let stateSpanTag01 = addTag("span", "");;
                let stateSpanTag02 = addTag("span", "");;
                let stateSpanTag03 = addTag("span", "");;
                if(data.signApproverDetailVoList[0].result === "0"){
                    if(data.signApproverDetailVoList[0].step === "2"){
                        stateSpanTag01 = addTag("span", "승인");
                    } else if(data.signApproverDetailVoList[0].step === "3"){
                        stateSpanTag01 = addTag("span", "승인");
                        stateSpanTag02 = addTag("span", "승인");
                    }
                } else if(data.signApproverDetailVoList[0].result === "1"){
                    stateSpanTag01 = addTag("span", "승인");
                    stateSpanTag02 = addTag("span", "승인");
                    stateSpanTag03 = addTag("span", "승인");
                } else if(data.signApproverDetailVoList[0].result === "2"){
                    if(data.signApproverDetailVoList[0].step === "1"){
                        stateSpanTag01 = addTag("span", "반려");
                    } else if(data.signApproverDetailVoList[0].step === "2"){
                        stateSpanTag01 = addTag("span", "승인");
                        stateSpanTag02 = addTag("span", "반려");
                    } else if(data.signApproverDetailVoList[0].step === "3"){
                        stateSpanTag01 = addTag("span", "승인");
                        stateSpanTag02 = addTag("span", "승인");
                        stateSpanTag03 = addTag("span", "반려");
                    }
                }

                // 결재자 div 태그에 span 태그 붙이기
                firstApproverDiv.appendChild(approverSpanTag01);
                secondApproverDiv.appendChild(approverSpanTag02);
                thirdApproverDiv.appendChild(approverSpanTag03);

                // 결재 상태 div 태그에 span 태그 붙이기
                firstApproverStateDiv.appendChild(stateSpanTag01);
                secondApproverStateDiv.appendChild(stateSpanTag02);
                thirdApproverStateDiv.appendChild(stateSpanTag03);

                // 참조자 div 태그 가져오기
                const refValueDiv = document.querySelector("#refValueDiv");

                // 참조자 div 태그 비우기
                refValueDiv.innerHTML = "";

                // span 생성하고, 참조자 div 태그에 붙이기
                let refSpanTag = addTag("span", "");
                for(let i = 0; i < data.signReferenceDetailVoList.length; ++i){
                    refSpanTag = addTag("span", data.signReferenceDetailVoList[i].divName + " " + data.signReferenceDetailVoList[i].empName + " " + data.signReferenceDetailVoList[i].positionName);
                    refValueDiv.appendChild(refSpanTag);
                }

                // iframe src 설정 (toolbar 안 보이기)
                const fileIframe = document.querySelector("#fileIframe");
                fileIframe.src = "/file/sign/" + data.signApproverDetailVoList[0].changeName + "#toolbar=0";

                // 현재 결재자에 해당하는지 판단
                let isApprover = false;
                let num = 0;
                for(let i = 0; i < data.signApproverDetailVoList.length; ++i){
                    if(data.signApproverDetailVoList[i].appNo === extData.vo.empNo){
                        isApprover = true;
                        num = i;
                    }
                }

                // 현재 결재자에 해당하면 승인, 반려 버튼 보여주기
                if(data.signApproverDetailVoList[num].result === "0"){
                    if(isApprover && data.signApproverDetailVoList[num].step === data.signApproverDetailVoList[num].signSeq){
                        // 첨언, 결재파일 첨부 가능하게 하기
                        document.querySelector("input[name=file]").disabled = false;
                        document.querySelector("textarea[name=commentArea]").disabled = false;
    
                        // 버튼 태그 담을 div 가져오기
                        const approveBtnDiv = document.querySelector("#approveBtnDiv");
    
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
                        approveBtnDiv.appendChild(btnTag01);
                        approveBtnDiv.appendChild(btnTag02);
    
                        // iframe toolbar 보이기
                        fileIframe.src = "/file/sign/" + data.signApproverDetailVoList[0].changeName;
                    }
                }
            },
            error: (error) => {
                console.log("결재자, 참조자 상세 리스트 통신 실패");
                console.log(error);
            }
        });
    }
</script>

<script>
    // 승인 처리
    function approveProcess(){
        if(confirm("승인 처리를 진행하겠습니까?")){
            approveProcessGoOn();
        } else{
            approveProcessCancel();
        }
    }

    // 승인 처리 (진행)
    function approveProcessGoOn(){
        const fileInput = document.querySelector("input[name=file]");
        const comment = document.querySelector("textarea[name=commentArea]").value;
        const file = fileInput.files[0];

        if(step === "1"){
            step = "2";
        } else if(step === "2"){
            step = "3";
        } else if(step === "3"){
            result = "1";
        }

        const formData = new FormData();
        formData.append("no", signNo);
        formData.append("result", result);
        formData.append("step", step);

        if(comment){
            formData.append("comment", comment);
        }

        if(file) {
            formData.append("file", file);
        }
        
        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: formData,
            processData: false,
            contentType: false,
            success: (data) => {
                console.log("승인 처리 통신 성공");

                if(data.signApproveResult === 1){
                    alert("승인 완료");
                    window.location.href = "/sign/listForApprover";
                    return ;
                }
                alert("승인 실패");
            },
            error: (error) => {
                console.log("승인 처리 통신 실패");
                console.log(error);
            }
        });
    }

    // 승인 처리 (취소)
    function approveProcessCancel(){
        alert("승인 처리를 중지합니다.");
    }

    // 반려 처리
    function returnProcess(){
        if(confirm("반려 처리를 진행하겠습니까?")){
            returnProcessGoOn();
        } else{
            returnProcessCancel();
        }
    }

    // 반려 처리 (진행)
    function returnProcessGoOn(){
        const comment = document.querySelector("textarea[name=commentArea]").value;

        result = "2";

        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: {
                no: signNo,
                result: result,
                step: step,
                comment: comment
            },
            success: (data) => {
                console.log("반려 처리 통신 성공");

                if(data.signApproveResult === 1){
                    alert("반려 완료");
                    window.location.href = "/sign/listForApprover";
                    return ;
                }
                alert("반려 실패");
            },
            error: (error) => {
                console.log("반려 처리 통신 실패");
                console.log(error);
            }
        });
    }

    // 반려 처리 (취소)
    function returnProcessCancel(){
        alert("반려 처리를 중지합니다.");
    }
</script>
