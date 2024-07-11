<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/messageCss/messageWriteCss.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminList.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
            <script defer src="/js/messageJs/messageSearchJs.js"></script>
            <script defer src="/js/messageJs/messageSendJs.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <title>메시지 쓰기</title>
        </head>

        <body>
            <section id="msg-section">
                <div class="msg-container">
                    <form id="messageForm">
                        <div class="row">
                            <div class="title do-hyeon-regular">제목</div>
                            <input type="text" name="title" class="title-body do-hyeon-regular">
                        </div>
                        <div class="row">
                            <div class="content do-hyeon-regular">내용</div>
                            <textarea name="content" id="content" class="content-body do-hyeon-regular"></textarea>
                        </div>
                        <div class="row">
                            <div class="emp do-hyeon-regular">발신인</div>
                            <input type="text" name="senderName" class="title-body do-hyeon-regular"
                                value="${senderName}" readonly>
                            <input type="hidden" name="senderNo" value="${senderNo}">
                        </div>
                        <div class="row">
                            <div class="emp do-hyeon-regular">수신인</div>
                            <input type="text" name="receiverName" class="title-body do-hyeon-regular" readonly>
                            <input type="hidden" name="receiverNo" class="title-body do-hyeon-regular">
                        </div>
                        <input type="submit" value="보내기" class="button do-hyeon-regular">
                    </form>
                </div>
                <div id="empSearchDiv">
                    <div class="search-form" id="search-form">
                        <form id="searchForm">
                            <select id="empCategory">
                                <option value="deptName">부서</option>
                                <option value="divName">팀</option>
                                <option value="positionName">직급</option>
                                <option value="name">이름</option>
                            </select>
                            <input type="text" id="searchBox" name="searchBox">
                            <button type="submit" class="tableButton">검색</button>
                        </form>
                    </div>
                    <div class="emp-container list-container" id="empContainer"></div>
                </div>
            </section>
        </body>

</html>