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
            <link rel="stylesheet" type="text/css" href="/css/messageCss/messageFolderStyleCss.css">
            <title>메시지 쓰기</title>
        </head>

        <body>
            <section>
                <div id="folderOutline">
                    <div id="folderHead">
                        <div id="folderHead1" class="folderTitleBar" onclick="location.href='/message/messageSendList'">
                            보낸 메시지</div>
                        <div id="folderHead2" class="folderTitleBar"
                            onclick="location.href='/message/messageReceiveList'">받은 메시지</div>
                        <div id="folderHead3" class="folderTitleBar"
                            onclick="location.href='/message/messageSendDeleteList'">삭제된 보낸 메시지</div>
                        <div id="folderHead4" class="folderTitleBar"
                            onclick="location.href='/message/messageReceiveDeleteList'">삭제된 받은 메시지</div>
                        <div id="folderHead5" class="folderTitleBar active" onclick="location.href='/message/messageWrite'">메시지 보내기</div>
                    </div>
                    <div id="folderBody">
                        <div id="sentMessages" class="tab-content active">
                        </div>
                        <div id="receivedMessages" class="tab-content">
                        </div>
                        <div id="deletedSentMessages" class="tab-content">
                        </div>
                        <div id="deletedReceivedMessages" class="tab-content">
                        </div>
                        <div id="messageWrite" class="tab-content active">
                            <div class="msg-container">
                                <form id="messageForm">
                                    <div class="row">
                                        <div class="title do-hyeon-regular">제목</div>
                                        <input type="text" name="title" class="title-body do-hyeon-regular">
                                    </div>
                                    <div class="row">
                                        <div class="content do-hyeon-regular">내용</div>
                                        <textarea name="content" id="content"
                                            class="content-body do-hyeon-regular"></textarea>
                                    </div>
                                    <div class="row">
                                        <div class="emp do-hyeon-regular">발신인</div>
                                        <input type="text" name="senderName" class="title-body do-hyeon-regular"
                                            value="${senderName}" readonly>
                                        <input type="hidden" name="senderNo" value="${senderNo}">
                                    </div>
                                    <div class="row">
                                        <div class="emp do-hyeon-regular">수신인</div>
                                        <input type="text" name="receiverName" class="title-body do-hyeon-regular"
                                            readonly>
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
                                    <button class="tableButton" onclick="window.location.href='/home'">홈으로</button>
                                </div>
                                <div class="emp-container list-container" id="empContainer"></div>
                            </div>
                        </div>
                    </div>
            </section>
        </body>

</html>