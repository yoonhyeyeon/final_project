<!DOCTYPE html>
<html lang="ko">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/projectCss/projectInsert.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>

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
                        <h1>프로젝트</h1>
                    </div>
                    &nbsp;&nbsp;<p>주제 :</p> <input type="text" name="title" id="title"><hr>
                    &nbsp;&nbsp;<p>PM-CODE</p> : <input type="text" name="empNo" id="emp"><br><hr>
                    &nbsp;&nbsp;상태 : <input type="text" name="state" id="state"><br>
                    <hr>
                    &nbsp;&nbsp;<p>부서코드 :</p> <input type="text" name="code" id="code"><br><br>
                    <textarea name="content" id="projectContent" placeholder="내용"></textarea><br>
                    <div id="div-submit">
                        <button id="submitButton" onclick="f01();">등록</button>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
    function f01(){
        const titleVal = document.querySelector("#title").value;
        const codeVal = document.querySelector("#code").value;
        const empVal = document.querySelector("#emp").value;
        const stateVal = document.querySelector("#state").value;
        const contentVal = document.querySelector("#projectContent").value;

        $.ajax({
            url : 'http://127.0.0.1:8080/project/projectInsert',
            type : 'post',
            data : {
                title : titleVal,
                code : codeVal,
                empNo : empVal,
                stateANo : stateVal,
                content : contentVal
            },
            success : function(x){
                alert("등록완료!");
                location.href='http://127.0.0.1:8080/project/projectMain';
            },
            error : function(x){
                console.log("에러")
            }
        });
    }
</script>