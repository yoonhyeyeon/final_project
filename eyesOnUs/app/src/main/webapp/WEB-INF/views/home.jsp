<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/home/home.css">
    <link rel="stylesheet" href="/css/home/sidebar.css">
    <link rel="stylesheet" href="/css/util/footer.css">
    <link rel="stylesheet" href="/css/home/header.css">
    <script defer src="/js/sidebar.js"></script>
    <script defer src="../js/commute/write.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <title>SHIN</title>
</head>

<body id="container">
  <div id="warp">
    <header id="headerContainer">
    <%@ include file="/WEB-INF/views/util/header.jsp" %>
    </header>
    <nav id="navContainer">
     <%@ include file="/WEB-INF/views/home/nav.jsp" %>
    </nav>
    <section id=""></section>
    <footer id="footerContainer">
     <%@ include file="/WEB-INF/views/util/footer.jsp" %>
    </footer>
  </div>
    <aside class="sidebar" id="sidebar">
    <%@ include file="/WEB-INF/views/home/sidebar.jsp" %>
    </aside>
    <button id="sidebarBtn"><span>메뉴</span></button>


</body>
</html>