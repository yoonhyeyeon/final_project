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
                    <th>팀명</th>
                    <th>직급</th>
                    <th>이름</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${voList}" var="vo">
                    <tr>
                        <td><a href="/adminEmpMngr/detail?no=${vo.no}">${vo.no}</td>
                        <td>${vo.deptName}</a></td>
                        <td>${vo.divName}</a></td>
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
            <form action="/adminEmpMngr/search" method="post">
                <select name="empCategory">
                    <option value="deptName">부서</option>
                    <option value="divName">팀</option>
                    <option value="positionName">직급</option>
                    <option value="name">이름</option>
                </select>
                <input type="text" name="searchBox">
                <button type="submit" class="tableButton">검색</button>
            </form>
            <button onclick="/adminEmpMngr/enrollEmp">사원등록</button>
            <c:if test="">

            </c:if>
        </div>
    </div>
</body>
</html>

<%--
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            loadEmployeeData(1, 20); // Default page and size

            function loadEmployeeData(page, size) {
                $.ajax({
                    url: '/adminEmpMngr/listData',
                    type: 'GET',
                    data: { page: page, size: size },
                    dataType: 'json',
                    success: function(data) {
                        var tableContent = '';
                        $.each(data.voList, function(index, vo) {
                            tableContent += '<tr>';
                            tableContent += '<td><a href="/adminEmpMngr/detail?no=' + vo.no + '">' + vo.no + '</a></td>';
                            tableContent += '<td>' + vo.deptName + '</td>';
                            tableContent += '<td>' + vo.divName + '</td>';
                            tableContent += '<td>' + vo.positionName + '</td>';
                            tableContent += '<td>' + vo.name + '</td>';
                            tableContent += '</tr>';
                        });
                        $('#employeeTable tbody').html(tableContent);
                        setupPagination(data.currentPage, data.totalPages);
                    },
                    error: function(request, status, error) {
                        console.log("Error: " + error);
                    }
                });
            }

            function setupPagination(currentPage, totalPages) {
                var paginationContent = '';
                for (var i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
                        paginationContent += '<span>' + i + '</span> ';
                    } else {
                        paginationContent += '<a href="#" class="page-link" data-page="' + i + '">' + i + '</a> ';
                    }
                }
                $('#pagination').html(paginationContent);

                $('.page-link').click(function(e) {
                    e.preventDefault();
                    var page = $(this).data('page');
                    loadEmployeeData(page, 20);
                });
            }
        });
    </script>
    --%>