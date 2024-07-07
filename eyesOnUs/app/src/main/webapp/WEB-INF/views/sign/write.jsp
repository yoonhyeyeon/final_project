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
        <title>결재 등록</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/home/home.css">
        <link rel="stylesheet" href="/css/home/sidebar.css">
        <link rel="stylesheet" href="/css/util/footer.css">
        <link rel="stylesheet" href="/css/home/header.css">
        <script defer src="/js/testMain/sidebar.js"></script>
        <script defer src="/js/commute/write.js"></script>

        <link rel="stylesheet" href="/css/sign/write.css">
        <script defer src="/js/sign/write.js"></script>
    </head>
    <body>
        <header id="headerContainer">
            <%@ include file="/WEB-INF/views/util/header.jsp" %>
        </header>

        <nav id="navContainer">
            <%@ include file="/WEB-INF/views/home/nav.jsp" %>
        </nav>

        <section>
            <form action="/sign/write" method="post" enctype="multipart/form-data">
                <input type="text" name="empNo" value="43" hidden>
                <input type="text" name="title" placeholder="제목">
                <br>
                <input type="text" name="content" placeholder="내용">
                <input type="text" name="refNo[]" value="4" hidden>
                <input type="text" name="refNo[]" value="7" hidden>
                <input type="text" name="approverNo[]" value="13" hidden>
                <input type="text" name="approverNo[]" value="9" hidden>
                <input type="text" name="approverNo[]" value="6" hidden>
                <br>
                <input type="file" name="file">
                <br>
                <input type="submit" value="제출">
            </form>
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
