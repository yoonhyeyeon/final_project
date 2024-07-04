<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
      <link rel="stylesheet" href="/css/projectCss/projectDetail.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <script defer src="/js/projectJs/projectDelete.js"></script>
      <script defer src="/js/projectJs/projectDetail.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
            <div id="out">
                <div id="in">
                    <div id="div-title">
                        <h1>프로젝트</h1>
                    </div>
                    &nbsp;&nbsp;<p class="title"></p><hr>
                    &nbsp;&nbsp;<p class="deptCode"></p><hr>
                    &nbsp;&nbsp;<p class="employee"></p><br><hr>
                    &nbsp;&nbsp;<p class="state" ></p><br>
                    <hr>
                    <h2>내용</h2>
                    <textarea name="content" id="projectContent" readonly></textarea><br>
                    <div id="divSubmit">

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







