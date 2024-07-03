<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body id="container">
  <div id="wrap">
    <%@ include file="/WEB-INF/views/testUtil/header.jsp" %>
    <section id="section">
      <div id="indexTitle">
        Love Diary
      </div>
      <div id="indexPic">
        <h1>그림</h1>
      </div>
      <div id="indexLogin">
        <button id="indexLoginBtn">
          로그인
        </button>
      </div>
      <div id="indexJoin">
        <button id="indexJoinBtn">
          회원가입
        </button>
      </div>
    </section>
    <footer>
      <h1>footer</h1>
    </footer>
  </div>
</body>
</html>