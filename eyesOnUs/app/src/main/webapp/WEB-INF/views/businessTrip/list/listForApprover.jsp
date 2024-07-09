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
        <title>출장 목록 조회</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/home/home.css">
        <link rel="stylesheet" href="/css/home/sidebar.css">
        <link rel="stylesheet" href="/css/util/footer.css">
        <link rel="stylesheet" href="/css/home/header.css">
        <script defer src="/js/testMain/sidebar.js"></script>
        <script defer src="/js/commute/write.js"></script>

        <link rel="stylesheet" href="/css/businessTrip/list/listForApprover.css">
        <script defer src="/js/businessTrip/list/listForApprover.js"></script>
        <script defer src="/js/common/addTag.js"></script>
    </head>
    <body>
        <header id="headerContainer">
            <%@ include file="/WEB-INF/views/util/header.jsp" %>
        </header>

        <nav id="navContainer">
            <%@ include file="/WEB-INF/views/home/nav.jsp" %>
        </nav>

        <section>
            <h1>출장 승인 대기 목록</h1>
            <table border="1" id="wait">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>사유</th>
                        <th>신청자</th>
                        <th>승인자</th>
                        <th>신청일</th>
                        <th>승인일</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <br>
            
            <h1>출장 승인 목록</h1>
            <table border="1" id="approval">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>사유</th>
                        <th>신청자</th>
                        <th>승인자</th>
                        <th>신청일</th>
                        <th>승인일</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <br>

            <h1>출장 반려 목록</h1>
            <table border="1" id="return">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>사유</th>
                        <th>신청자</th>
                        <th>승인자</th>
                        <th>신청일</th>
                        <th>승인일</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
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
