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
        <title>휴가 등록</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/home/home.css">
        <link rel="stylesheet" href="/css/home/sidebar.css">
        <link rel="stylesheet" href="/css/util/footer.css">
        <link rel="stylesheet" href="/css/home/header.css">
        <script defer src="/js/testMain/sidebar.js"></script>
        <script defer src="/js/commute/write.js"></script>

        <link rel="stylesheet" href="/css/leave/write.css">
        <script defer src="/js/leave/write.js"></script>
    </head>
    <body>
        <header id="headerContainer">
            <%@ include file="/WEB-INF/views/util/header.jsp" %>
        </header>

        <nav id="navContainer">
            <%@ include file="/WEB-INF/views/home/nav.jsp" %>
        </nav>

        <section>
            <form action="/leave/write" method="post">
                <!-- 사원 가져와서 출력 -->
                <label for="approverNo">승인자 선택</label>
                <select name="approverNo">
                    <option value="13">팀장</option>
                    <option value="13">팀장</option>
                    <option value="13">팀장</option>
                </select>
                <br>

                <label for="typeNo">휴가 타입 선택</label>
                <select name="typeNo">
                    <option value="1">연차</option>
                    <option value="2">병가</option>
                    <option value="3">경조사</option>
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
