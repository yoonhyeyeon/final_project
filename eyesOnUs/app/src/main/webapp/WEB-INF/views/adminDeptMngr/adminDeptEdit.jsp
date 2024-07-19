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
            <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminDeptJs/adminDeptEdit.js"></script>
            <script defer src="../js/adminUtil.js"></script>
            <script defer src="../js/sidebar.js"></script>
            <script defer src="../js/calender.js"></script>
            <title>팀 수정</title>
        </head>

        <body id="container">
            <div id="warp">
                <%@ include file="/WEB-INF/views/adminHr/adminHeader.jsp" %>
                    <%@ include file="/WEB-INF/views/adminHr/adminNav.jsp" %>
                        <section>
                            <div class="form-container">
                                <form id="editForm" action="/adminDeptMngr/edit" method="post">
                                    <div class="form-group">
                                        <label for="deptName">부서</label>
                                        <div>
                                            ${vo.deptName}
                                            <input type="hidden" name="deptCode" value="${vo.deptCode}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">팀명</label>
                                        <div>
                                            ${vo.name}
                                            <input type="hidden" name="name" value="${vo.name}" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="code">팀코드</label>
                                        <div>
                                            ${vo.code}
                                            <input type="hidden" name="code" value="${vo.code}" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="enrollDate">생성일</label>
                                        <div>
                                            ${vo.enrollDate}
                                            <input type="hidden" name="enrollDate" value="${vo.enrollDate}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="modifyDate">수정일</label>
                                        <input type="date" name="modifyDate" value="${vo.modifyDate}">
                                    </div>
                                    <div class="form-group">
                                        <label for="state">팀 상태</label>
                                        <select name="state">
                                            <option value="활동중">활동중</option>
                                            <option value="준비중">준비중</option>
                                            <option value="중단">중단</option>
                                            <option value="폐지">폐지</option>
                                            <option value="완료">완료</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="edit-button" value="수정하기">
                                        <button class="getBack-button" id="listButton"
                                            onclick="location.href='/adminDeptMngr/list'">목록으로</button>
                                    </div>
                                </form>
                            </div>
                        </section>
                        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
            </div>
        </body>

</html>