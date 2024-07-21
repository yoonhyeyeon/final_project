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
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/header.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminDeptEdit.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminEnroll.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminList.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
      <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script defer src="/js/adminDeptJs/adminDeptEdit.js"></script>
      <script defer src="/js/adminDeptJs/adminDeptDetail.js"></script>
      <script defer src="/js/adminDeptJs/adminDeptDetailMem.js"></script>
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <title>팀 정보</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/adminHr/adminHeader.jsp" %>
          <%@ include file="/WEB-INF/views/adminHr/adminNav.jsp" %>
            <section>
              <div class="form-container" id="formContainer"></div>
            </section>
            <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
      </div>
    </body>

</html>