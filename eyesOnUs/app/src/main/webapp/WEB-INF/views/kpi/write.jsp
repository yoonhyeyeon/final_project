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
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/kpi/kpiWrite.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <script defer src="../js/kpi/kpiWrite.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <title>SHIN</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>

             <div id="out">
                 <div class="write-form">
                         <div id="title">
                             <h2>KPI 일정 등록</h2>
                         </div>
                         <hr>
                     <div id="form">
                         프로젝트 번호 : <select name="projectNo" id="projectNo" style="width:100px">
                           <option value="">------선택------</option>
                           <% for (int i = 1; i <= 36; i++) { %>
                             <option id="prjNo" value="<%= i %>"><%= i %></option>
                           <% } %>
                         </select>
                         <!-- <input type="text" name="projectNo" id="projectNo"> -->
                         <br />
                         목표
                         <br>
                         <textarea name="goal" id="goal"></textarea>
                         <br />
                         <hr>
                         개인 일정
                         <br>
                         <textarea name="personalSchedule" id="personalSchedule"></textarea>
                         <br />
                         집중도 : <input type="text" name="focus" id="focus">
                         <br />
                         <br />
                         <div class="submit-bar">
                             <button onclick="write01();" id="submit">등록하기</button>
                         </div>
                     </div>
                 </div>
             </div>

        </section>
        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
      </div>
      <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>
</html>