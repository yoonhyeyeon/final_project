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
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminList.css">
      <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script defer src="/js/adminEmpJs/adminEmpList.js"></script>

      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <title>관리자 직원 목록</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/adminHr/adminHeader.jsp" %>
          <%@ include file="/WEB-INF/views/adminHr/adminNav.jsp" %>
            <section>
              <div class="emp-container list-container" id="empContainer"></div>
              <div class="pagination" id="pagination"></div>
              <div class="search-form" id="search-form">
                <form id="searchForm">
                  <select id="empCategory">
                    <option value="deptName">부서</option>
                    <option value="divName">팀</option>
                    <option value="positionName">직급</option>
                    <option value="name">이름</option>
                    <option value="retireYn">재직</option>
                  </select>
                  <input type="text" id="searchBox" name="searchBox">
                  <button type="submit" class="tableButton">검색</button>
                </form>
                <button class="enroll-button" onclick="window.location.href='/adminEmpMngr/enrollEmp'">사원등록</button>
              </div>
            </section>
            <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
      </div>
    </body>

</html>