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
      <link rel="stylesheet" type="text/css" href="/css/memberEval/memberList.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <script defer src="../js/memberEval/memberList.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <title>YOON</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>

            <div id="out">
                <h1>팀원 평가</h1>
                <div id="list">
                    <span id="date">평가 기간 : 2024-07-08 ~ 2024-07-30</span>
                    <br><hr><br>
                    <div id="evaluatorNo">
                        <p>평가자 : 윤혜연</p>
                    </div>
                        <div class="listBox">
                            <div id="listItemBox">
                                <span>번호</span>
                                <span>이름</span>
                                <span>잠재력</span>
                                <span>소통력</span>
                                <span>문제해결력</span>
                                <span>책임감</span>
                                <span>칭찬할 점</span>
                                <span>아쉬운 점</span>
                                <span>하고 싶은 말</span>
                                <span>평가일</span>
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