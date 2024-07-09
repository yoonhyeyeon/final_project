<!DOCTYPE html>
<html lang="ko">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/prjConfRecord/recordInsert.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
        <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="/js/adminUtil.js"></script>
      <script defer src="/js/sidebar.js"></script>
      <script defer src="/js/calender.js"></script>
      <script defer src="/js/prjConfRecord/recordInsert.js"></script>

    <title>KIM</title>
</head>

<body id="container">
    <div id="warp">
    <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
    <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>

        <c:if test="${sessionScope.loginMemberVo.rank eq '0' or sessionScope.loginMemberVo.rank eq '10' or sessionScope.loginMemberVo.rank eq '20'}">
            <section>
             <div id="out">
                    <div id="in">
                        <div id="div-title">
                            <h1>회의록</h1>
                        </div>
                        &nbsp;&nbsp;<p>회의 주제 :</p> <input type="text" name="title" id="title"><hr>
                        &nbsp;&nbsp;<p>프로젝트 번호</p> : <input type="text" name="prjNo" id="prjNo"><br><hr>
                        <textarea name="content" id="recordContent" placeholder="내용"></textarea><br>
                        <div id="div-submit">
                            <button id="submitButton" onclick="smtRecord();">등록</button>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>
        <c:if test ="${sessionScope.loginMemberVo.rank eq '30' or sessionScope.loginMemberVo.rank eq '40'}">
            <section>
                <div id="div-title">
                    <h1>권한이 없습니다</h1>
                </div>
            </section>
        </c:if>
        <c:if test ="${empty sessionScope.loginMemberVo.no}">
            <section>
                <div id="div-title">
                    <h1>로그인을 하고오세요</h1>
                </div>
            </section>
        </c:if>
        
        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
      </div>
      <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>
</html>

