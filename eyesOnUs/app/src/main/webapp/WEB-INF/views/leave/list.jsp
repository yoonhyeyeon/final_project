<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
    </style>
    <head>
        <meta charset="UTF-8">
        <title>휴가 목록 조회</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/home/home.css">
        <link rel="stylesheet" href="/css/home/sidebar.css">
        <link rel="stylesheet" href="/css/util/footer.css">
        <link rel="stylesheet" href="/css/home/header.css">
        <script defer src="/js/testMain/sidebar.js"></script>
        <script defer src="/js/commute/write.js"></script>

        <link rel="stylesheet" href="/css/leave/list.css">
        <script defer src="/js/leave/list.js"></script>
    </head>
    <body>
        <header id="headerContainer">
            <%@ include file="/WEB-INF/views/util/header.jsp" %>
        </header>

        <nav id="navContainer">
            <%@ include file="/WEB-INF/views/home/nav.jsp" %>
        </nav>

        <section>
            휴가 목록 조회
        </section>

        <footer id="footerContainer">
            <%@ include file="/WEB-INF/views/util/footer.jsp" %>
        </footer>

        <aside class="sidebar" id="sidebar">
            <%@ include file="/WEB-INF/views/home/sidebar.jsp" %>
        </aside>

        <button id="sidebarBtn"><span>메뉴</span></button>
    </body>
</html>
