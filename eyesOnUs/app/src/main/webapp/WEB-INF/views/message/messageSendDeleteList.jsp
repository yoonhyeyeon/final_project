<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="/css/messageCss/messageWriteCss.css">
      <link rel="stylesheet" type="text/css" href="/css/messageCss/messageListCss.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
      <script defer src="/js/messageJs/messageSendDeleteListJs.js"></script>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <title>삭제된 보낸 메시지 함</title>
    </head>

    <body>
      <section>
        <h1>삭제된 보낸 메시지 목록</h1>
        <div class="message-list list-container" id="empContainer"></div>
        <div class="pagination" id="pagination"></div>
        <div class="search-form" id="search-form">
          <form id="searchForm">
            <select id="empCategory">
              <option value="receiverDeptName">부서</option>
              <option value="receiverDivName">팀</option>
              <option value="receiverPositionName">직급</option>
              <option value="receiverName">이름</option>
            </select>
            <input type="text" id="searchBox" name="searchBox">
            <button type="submit" class="tableButton">검색</button>
          </form>
        </div>
      </section>
    </body>

</html>