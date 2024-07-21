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
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/testPersonalPage.css">
      <link rel="stylesheet" type="text/css" href="/css/board/notice/write.css">
      <script defer src="../js/commute/write.js"></script>
      <script defer src="../js/commute/quit.js"></script>
      <script defer src="../js/board/notice/write.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>

      <title>홈페이지</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/homeUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/homeUtil/nav.jsp" %>
        <section>
          <div id="out">
            <h2>🔵 공지사항</h2>
            <hr>
            <br><br>
            <div class="body">
              <div id="left">
                <span>게시판</span>
                <p>- 공지사항</p>
                <p>- 자유게시판</p>
                <p>- 건의게시판</p>
              </div>
              <div id="right">
                  <h2>&nbsp;&nbsp;&nbsp;글쓰기</h2>
                  <br>
                  <div id="box">
                    <select>
                        <option>공지사항</option>
                    </select>
                  </div>
                <div id="form">
                    <p id="titleName">제목 : <input type="text" id="title"></p>
                    <p id="contentName">내용</p>
                    <textarea name="content" id="content"></textarea>
                    <br><br>
                    <div id="btn">
                        <button onclick="write01();" id="submit">등록하기</button>
                    </div>
                </div>
                <br>
              </div>
            </div>
          </div>
        </section>
        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
      </div>
    </body>
</html>