<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>결재 상세 조회</title>

        <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
        <link rel="stylesheet" href="/css/teamRoom/list.css">
        <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
        <script defer src="/js/teamRoom/list.js"></script>
        <script defer src="/js/teamRoom/teamRoom.js"></script>
        <script defer src="/js/workTime/workTime.js"></script>
        <script defer src="/js/teamRoom/clock.js"></script>
        <link rel="stylesheet" href="/css/teamRoom/clock.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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
                        <span>1차 결재자</span>
                    </div>
                    <div id="secondApprover" class="th top">
                        <span>2차 결재자</span>
                    </div>
                    <div id="thirdApprover" class="th top">
                        <span>3차 결재자</span>
                    </div>
                    <div id="firstApproverState" class="state">
                        <span>결재 상태</span>
                    </div>
                    <div id="secondApproverState" class="state">
                        <span>결재 상태</span>
                    </div>
                    <div id="thirdApproverState" class="state">
                        <span>결재 상태</span>
                    </div>
                </div>
                <div id="titleDiv" class="th second">
                    <span>제목</span>
                </div>
                <div id="titleValueDiv" class="appApp second">
                    <span>제목이다</span>
                </div>
                <div id="contentDiv" class="th third">
                    <span>내용</span>
                </div>
                <div id="contentValueDiv" class="appApp third">
                    <span>내용이다</span>
                </div>
                <div id="writerDiv" class="th forth">
                    <span>기안자</span>
                </div>
                <div id="writerValueDiv" class="appApp forth">
                    <span>기안자 누구누구</span>
                </div>
                <div id="refDiv" class="th forth">
                    <span>참조자</span>
                </div>
                <div id="refValueDiv" class="appApp forth">
                    <span>참조자1</span>
                    <span>참조자2</span>
                    <span>참조자3</span>
                </div>
                <div id="enrollDateDiv" class="th fifth">
                    <span>기안일</span>
                </div>
                <div id="enrollDateValueDiv" class="appApp fifth">
                    <span>며칠</span>
                </div>
                <div id="lastApproveDateDiv" class="th fifth">
                    <span>마지막 승인일</span>
                </div>
                <div id="lastApproveDateValueDiv" class="appApp fifth">
                    <span>며칠</span>
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
                    <textarea name="commenArea" id="commenArea"></textarea>
                </div>
                
                <script>
                    document.querySelector("input[type=file]").disabled = true;
                    document.querySelector("textarea[name=commenArea]").disabled = true;
                </script>
            </div>
            <div id="approveBtnDiv">
                <button id="openModalBtn" onclick="openModal();">결재파일 열기</button>
                <button onclick="approveProcess">승인</button>
                <button onclick="returnProcess">반려</button>
            </div>
        </div>

        <div id="modalDiv">
            <div id="modalContentDiv">
                <iframe name="file" src="/file/file.pdf" width="100%" height="100%"></iframe>
            </div>
        </div>

        <div id="listContainer" class="list-container"></div>
    </body>
</html>

<script>

</script>

<script>
    // 승인 처리
    function approveProcess(){
        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: {
                no: signNo
            },
            success: (data) => {
                console.log("승인 처리 통신 성공");

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
            url: "/api/sign/approve",
            method: "get",
            data: {
                no: signNo
            },
            success: (data) => {
                console.log("반려 처리 통신 성공");
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
        if(confirm("승인 처리를 진행하겠습니까?")){
            approveProcessGoOn();
        } else{
            approveProcessCancel();
        }
    }

    // 승인 처리 (진행)
    function approveProcessGoOn(){
        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: {
                no: signNo,
                result: "1",
                step: "2"
            },
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
                console.log("통신 실패");
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
        $.ajax({
            url: "/api/sign/approve",
            method: "put",
            data: {
                no: signNo,
                result: "2",
                step: "1"
            },
            success: (data) => {
                console.log("휴가 반려 처리 통신 성공");

                if(data.signApproveResult === 1){
                    alert("반려 완료");
                    window.location.href = "/sign/listForApprover";
                    return ;
                }
                alert("반려 실패");
            },
            error: (error) => {
                console.log("통신 실패");
                console.log(error);
            }
        });
    }

    // 반려 처리 (취소)
    function returnProcessCancel(){
        alert("반려 처리를 중지합니다.");
    }
</script>
