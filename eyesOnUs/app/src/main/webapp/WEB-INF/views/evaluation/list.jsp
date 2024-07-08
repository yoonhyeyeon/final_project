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
      <link rel="stylesheet" type="text/css" href="/css/evaluation/list.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <script defer src="../js/evaluation/list.js"></script>
      <script defer src="../js/evaluation/leader.js"></script>
      <script defer src="../js/evaluation/member.js"></script>
      <script defer src="../js/evaluation/colleage.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <title>YOON</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
              <div id="out">
                <h2>평가목록</h2>
                <hr><br><br>
                <div id="list">
                  <span>평가자 : 윤혜연</span>
                   <br>
                  <div id="listBtn">
                    <button onclick="leader(${vo.no});">팀장 평가</button>
                    <button onclick="member(${vo.no});">팀원 평가</button>
                    <button onclick="colleage(${vo.no});">동료 평가</button>
                  </div>
                  <div id="listBox">
                    <div id="listItemBox">
                      <span>이름</span>
                      <span>부서</span>
                      <span>팀</span>
                      <span>직급</span>
                    </div>
                    <div id="Item">

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