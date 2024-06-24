<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 직원 목록</title>
</head>
<body>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <th>사원번호</th>
                    <th>부서명</th>
                    <th>직급</th>
                    <th>이름</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${voList}" var="vo">
                    <tr>
                        <td>${vo.no}</td>
                        <td><a href="/adminEmpMngr/detail?no=${vo.no}">${vo.deptName}</a></td>
                        <td>${vo.positionName}</td>
                        <td>${vo.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <c:if test="${currentPage > 1}">
                <a href="/adminEmpMngr/list?page=${currentPage - 1}">이전</a>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="x">
                <c:choose>
                    <c:when test="${currentPage == x}">
                        <strong>${x}</strong>
                    </c:when>
                    <c:otherwise>
                        <a href="/adminEmpMngr/list?page=${x}">${x}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <a href="/adminEmpMngr/list?page=${currentPage + 1}">다음</a>
            </c:if>
        </div>
        <div>
            <form action="" method="post">
                <select>
                    <option value="deptName">부서</option>
                    <option value="positionName">직급</option>
                    <option value="name">이름</option>
                </select>
                <input type="text" name="searchBox" id="searchBox">
                <button type="submit" class="tableButton">검색</button>
            </form>
            <c:if test="">
                <button onclick="">사원등록</button>
            </c:if>
        </div>
    </div>
</body>
</html>
