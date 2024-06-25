<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 목록</title>
</head>
<body>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <th>부서명</th>
                    <th>팀명</th>
                    <th>팀 상태</th>
                    <th>팀 생성일</th>
                    <th>팀 변경일</th>
                    <th>팀 수정</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${voList}" var="vo">
                    <tr>
                        <td>${vo.deptName}</td>
                        <td>${vo.name}</td>
                        <td>${vo.state}</td>
                        <td>${vo.enrollDate}</td>
                        <td>${vo.modifyDate}</td>
                        <td><a href="/adminDeptMngr/edit?code=${vo.code}">수정</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <c:if test="${currentPage > 1}">
                <a href="/adminDeptMngr/list?page=${currentPage - 1}">이전</a>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="x">
                <c:choose>
                    <c:when test="${currentPage == x}">
                        <strong>${x}</strong>
                    </c:when>
                    <c:otherwise>
                        <a href="/adminDeptMngr/list?page=${x}">${x}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <a href="/adminEmpMngr/list?page=${currentPage + 1}">다음</a>
            </c:if>
        </div>
        <div>
            <form action="/adminDeptMngr/search" method="post">
                <select name="empCategory">
                    <option value="deptName">부서</option>
                    <option value="name">팀</option>
                    <option value="state">상태</option>
                </select>
                <input type="text" name="searchBox">
                <button type="submit" class="tableButton">검색</button>
            </form>
            <button onclick="window.location.href='/adminDeptMngr/enrollDiv'">프로젝트등록</button>
            <c:if test="">

            </c:if>
        </div>
    </div>
</body>
</html>
