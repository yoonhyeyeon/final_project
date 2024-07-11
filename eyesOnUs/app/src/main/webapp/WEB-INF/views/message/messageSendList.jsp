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
            <script defer src="/js/messageJs/messageSendListJs.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <title>메시지 쓰기</title>
        </head>

        <body>
            <section>
                <h1>목록</h1>
                <div class="message-list list-container" id="empContainer"></div>
                <div class="pagination" id="pagination"></div>
            </section>
        </body>

</html>