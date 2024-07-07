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
        <title>출장 등록</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/home/home.css">
        <link rel="stylesheet" href="/css/home/sidebar.css">
        <link rel="stylesheet" href="/css/util/footer.css">
        <link rel="stylesheet" href="/css/home/header.css">
        <script defer src="/js/testMain/sidebar.js"></script>
        <script defer src="/js/commute/write.js"></script>

        <link rel="stylesheet" href="/css/businessTrip/write.css">
        <script defer src="/js/businessTrip/write.js"></script>
    </head>
    <body>
        <header id="headerContainer">
            <%@ include file="/WEB-INF/views/util/header.jsp" %>
        </header>

        <nav id="navContainer">
            <%@ include file="/WEB-INF/views/home/nav.jsp" %>
        </nav>

        <section>
            <form action="/businessTrip/write" method="post">
                <input type="text" name="empNo" value="43" hidden>
        
                <input type="text" name="approverNo" value="13" hidden>
        
                <!-- 해당 프로젝트 가져와서 출력 -->
                <label for="proNo">프로젝트 선택</label>
                <select name="proNo">
                    <option value="1">미치겠다</option>
                    <option value="2">So Many Things</option>
                    <option value="3">Too hard</option>
                </select>
                <br>
                <label for="startDate">시작일</label>
                <input type="date" name="startDate">
                <br>
                <label for="endDate">종료일</label>
                <input type="date" name="endDate">
                <br>
                <textarea name="reason" placeholder="사유"></textarea>
                <br>
                <input type="text" name="destination" placeholder="출장지">
                <br>
                <input type="submit" value="신청">
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
