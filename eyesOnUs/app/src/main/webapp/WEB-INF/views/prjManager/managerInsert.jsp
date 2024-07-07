<!DOCTYPE html>
<html lang="ko">

    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
        <link rel="stylesheet" type="text/css" href="/css/prjManager/managerInsert.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script defer src="/js/adminUtil.js"></script>
      <script defer src="/js/sidebar.js"></script>
      <script defer src="/js/calender.js"></script>
      <script defer src="/js/prjManager/managerInsert.js"></script>

    <title>KIM</title>
</head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
         <div id="out">
                <div id="in">
                    <div id="div-title">
                        <h1>프로젝트 담당자</h1>
                    </div>
                    &nbsp;&nbsp;<p>프로젝트 번호 :</p> <input type="text" name="proNo" id="proNo" ><hr>
                    &nbsp;&nbsp;<p>담당자 코드</p>&nbsp;&nbsp;&nbsp;&nbsp; :
                    <input type="text" name="empNo" id="empNo"><br><hr>
                    <div id="div-submit">
                        <button id="submitButton" onclick="smtM();">등록</button>
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

