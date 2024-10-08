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
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/header.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/testPersonalPage.css">
      <link rel="stylesheet" type="text/css" href="/css/attendance/list.css">
      <script defer src="../js/commute/write.js"></script>
      <script defer src="../js/commute/quit.js"></script>
      <script defer src="../js/attendance/list.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>

      <title>개인페이지</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/homeUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/homeUtil/nav.jsp" %>
        <section>
          <div id="out">
            <div id="listBox">
              <div id="listHead">

              </div>
              <br>
              <div id="listMain">
                <span>조회</span>
                <select name="month" id="month" onchange="monthData();">
                  <option value="">--선택--</option>
                  <option value="01">1월</option>
                  <option value="02">2월</option>
                  <option value="03">3월</option>
                  <option value="04">4월</option>
                  <option value="05">5월</option>
                  <option value="06">6월</option>
                  <option value="07">7월</option>
                  <option value="08">8월</option>
                  <option value="09">9월</option>
                  <option value="10">10월</option>
                  <option value="11">11월</option>
                  <option value="12">12월</option>
                </select>
                <span>출근 시간</span>
                <span>퇴근 시간</span>
                <span>총 근무 시간</span>
                <span>상태</span>
              </div>
              <br>
              <div id="list">
                <div id="listBody">

                </div>
              </div>

            </div>
          </div>
        </section>
        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
      </div>
    </body>
</html>