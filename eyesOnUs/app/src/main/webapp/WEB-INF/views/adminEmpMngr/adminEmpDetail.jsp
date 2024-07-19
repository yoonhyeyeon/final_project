<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
        </style>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/footer.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/popUpBoard.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/sidebar.css">
            <link rel="stylesheet" type="text/css" href="/css/homeUtil/teamRoom.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminEnroll.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminEmpJs/adminEmpDetail.js"></script>
            <script defer src="../js/adminUtil.js"></script>
            <script defer src="../js/sidebar.js"></script>
            <script defer src="../js/calender.js"></script>
            <title>사원 상세 정보</title>
        </head>

        <body id="container">
            <div id="warp">
                <%@ include file="/WEB-INF/views/adminHr/adminHeader.jsp" %>
                    <%@ include file="/WEB-INF/views/adminHr/adminNav.jsp" %>
                        <section>
                            <div class="form-container">
                                <div class="form-group">
                                    <div class="label">이름</div>
                                    <div class="value" id="name">${vo.name}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">전화번호</div>
                                    <div class="value" id="phone">${vo.phone}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">주소</div>
                                    <div class="value" id="address">${vo.address}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">사원번호</div>
                                    <div class="value" id="no">${vo.no}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">부서</div>
                                    <div class="value" id="deptName">${vo.deptName}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">팀</div>
                                    <div class="value" id="divName">${vo.divName}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">직급</div>
                                    <div class="value" id="positionName">${vo.positionName}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">연봉</div>
                                    <div class="value" id="salary">${vo.salary}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">보너스</div>
                                    <div class="value" id="bonus">${vo.bonus}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">아이디</div>
                                    <div class="value" id="id">${vo.id}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">닉네임</div>
                                    <div class="value" id="nick">${vo.nick}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">입사일</div>
                                    <div class="value" id="enrollDate">${vo.enrollDate}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">퇴사일</div>
                                    <div class="value" id="retireDate">${vo.retireDate}</div>
                                </div>
                                <div class="form-group">
                                    <div class="label">퇴사 여부</div>
                                    <div class="value" id="retireYn">${vo.retireYn}</div>
                                </div>
                                <button class="edit-button" id="updateButton">사원 정보 수정</button>
                                <button class="getBack-button" id="listButton"
                                    onclick="location.href='/adminEmpMngr/list'">목록으로</button>
                            </div>
                        </section>
                        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
            </div>
        </body>

</html>