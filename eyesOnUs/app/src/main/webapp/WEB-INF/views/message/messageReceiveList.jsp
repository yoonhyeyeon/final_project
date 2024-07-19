<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="/css/messageCss/messageWriteCss.css">
      <link rel="stylesheet" type="text/css" href="/css/messageCss/messageListCss.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
      <script defer src="/js/messageJs/messageReceiveListJs.js"></script>
      <script defer src="/js/messageJs/messageReceiveDeleteJs.js"></script>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <link rel="stylesheet" type="text/css" href="/css/messageCss/messageFolderStyleCss.css">
      <title>받은 메시지 함</title>
    </head>

    <body>
      <section>
        <div id="folderOutline">
          <div id="folderHead">
            <%@ include file="/WEB-INF/views/message/messageFolderHead.jsp" %>
          </div>
          <div id="folderBody">
            <div id="sentMessages" class="tab-content active">
            </div>
            <div id="receivedMessages" class="tab-content active">
              <div class="message-list list-container" id="empContainer"></div>
              <div class="pagination" id="pagination"></div>
              <div class="search-form" id="search-form">
                <form id="searchForm">
                  <select id="empCategory">
                    <option value="senderDeptName">부서</option>
                    <option value="senderDivName">팀</option>
                    <option value="senderPositionName">직급</option>
                    <option value="senderName">이름</option>
                  </select>
                  <input type="text" id="searchBox" name="searchBox">
                  <button type="submit" class="tableButton">검색</button>
                </form>
              </div>
            </div>
            <div id="deletedSentMessages" class="tab-content">
            </div>
            <div id="deletedReceivedMessages" class="tab-content">
            </div>
          </div>
        </div>
      </section>
    </body>

</html>