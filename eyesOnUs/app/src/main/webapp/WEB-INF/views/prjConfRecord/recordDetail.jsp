<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
      <link rel="stylesheet" href="/css/prjConfRecord/recordDetail.css">
      <link rel="stylesheet" type="text/css" href="/css/mainUtil/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/mainUtil/teamRoom.css">
      <script defer src="../js/teamRoom/teamRoomSidebar.js"></script>
      <script defer src="/js/prjConfRecord/recordDetail.js"></script>
      <script defer src="/js/prjConfRecord/recordDelete.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
    <body id="container">
      <div id="warp">
        <section>
            <div id="out">
                <div id="in">
                    <div id="div-title">
                        <h1>회의록</h1>
                    </div>
                    &nbsp;&nbsp;<p class="prjNo"></p><hr>
                    &nbsp;&nbsp;<p class="name" ></p><br>
                    &nbsp;&nbsp;<p class="title"></p><hr>
                    &nbsp;&nbsp;<p class="enlDate" ></p><br>
                    <hr>
                    <h2>내용</h2>
                    <textarea name="content" id="recordContent" readonly></textarea><br>
                    <div id="divSubmit">
                        <p id="sBtn"></p>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <p id="dBtn"></p>
                    </div>
                </div>
            </div>
        </section>
      </div>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>



</html>






