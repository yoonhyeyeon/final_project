<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script defer src="/js/messageJs/messageFolderJs.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/messageCss/messageFolderStyleCss.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <title>메시지함</title>
</head>
<body>
  <div id="folderOutline">
    <div id="folderHead">
      <div id="folderHead1" class="folderTitleBar active" onclick="openTab(event, 'sentMessages')">보낸 메시지</div>
      <div id="folderHead2" class="folderTitleBar" onclick="openTab(event, 'receivedMessages')">받은 메시지</div>
      <div id="folderHead3" class="folderTitleBar" onclick="openTab(event, 'deletedSentMessages')">삭제된 보낸 메시지</div>
      <div id="folderHead4" class="folderTitleBar" onclick="openTab(event, 'deletedReceivedMessages')">삭제된 받은 메시지</div>
    </div>
    <div id="folderBody">
      <div id="sentMessages" class="tab-content active">
        <%@ include file="messageSendList.jsp" %>
      </div>
      <div id="receivedMessages" class="tab-content">
        <%@ include file="messageReceiveList.jsp" %>
      </div>
      <div id="deletedSentMessages" class="tab-content">
        <%@ include file="messageSendDeleteList.jsp" %>
      </div>
      <div id="deletedReceivedMessages" class="tab-content">
        <%@ include file="messageReceiveDeleteList.jsp" %>
      </div>
    </div>
  </div>
</body>
</html>
