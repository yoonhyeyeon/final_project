<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
<link rel="stylesheet" type="text/css" href="/css/projectCss/recordInsert.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>

</head>
    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
          <div id ="out">
            <h1>회의록</h1>
            <hr>
            <div id="in">
                프로젝트 번호 : <input type="text" name="prjNo" id="prjNo">&nbsp;&nbsp;
                제목 : <input type="text" name="title" id="title"><br><br>
                <strong id="text-content">내용</strong><textarea name="content" id="content" >
                </textarea>
                <div id="div-submit">
                  <button type="button" onclick="f01();">등록</button>
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
    const   prjNoValue = document.querySelector("#prjNo").value;
    const   titleValue = document.querySelector("#title").value;
    const   contentValue = document.querySelector("#content").value;

    $.ajax({
        url : 'http://127.0.0.1:8080/project/record/insert',
        type : 'post',
        data : {
            prjNo : prjNoValue,
            title : titleValue,
            content : contentValue,
        },
        success : function(x){
            console.log(x);
        },
        error : function(x){
            console.log(x);
        },
    });
}

</script>