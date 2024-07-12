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
            <script defer src="/js/messageJs/messageDetailJs.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <title>메시지 내용</title>
        </head>

        <body>
            <section id="msg-section">
                <div class="msg-container">
                    <form id="messageForm">
                        <div class="row">
                            <div class="title do-hyeon-regular">제목</div>
                            <input type="text" name="title" id="title" class="title-body do-hyeon-regular" readonly>
                        </div>
                        <div class="row">
                            <div class="content do-hyeon-regular">내용</div>
                            <textarea name="content" id="content" class="content-body do-hyeon-regular" readonly></textarea>
                        </div>
                        <div class="row">
                            <div class="emp do-hyeon-regular">발신인</div>
                            <input type="text" name="senderInfo" id="senderInfo" class="title-body do-hyeon-regular" value="${senderInfo}" readonly>
                        </div>
                        <div class="row">
                            <div class="emp do-hyeon-regular">보낸 시간</div>
                            <input type="text" name="sendTime" id="sendTime" class="title-body do-hyeon-regular" readonly>
                        </div>
                    </form>
                    <button class="getBack-button" id="listButton">목록으로</button>
                </div>
            </section>
        </body>

</html>