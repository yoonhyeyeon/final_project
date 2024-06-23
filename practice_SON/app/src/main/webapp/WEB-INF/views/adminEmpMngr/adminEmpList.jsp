<!DOCTYPE html>
<html lang="ko">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 직원 목록</title>
    <script>
        ${voList}
    </script>
</head>
<body>

    <div>

        <table border="1">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>부서 코드</th>
                    <th>직위 코드</th>
                    <th>상태</th>
                    <th>급여 코드</th>
                    <th>직급</th>
                    <th>급여</th>
                    <th>보너스</th>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>닉네임</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>등록일</th>
                    <th>퇴사일</th>
                    <th>퇴사 여부</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${voList}" var="vo">
                    <tr>
                        <td>${vo.no}</td>
                        <td>${vo.deptCode}</td>
                        <td>${vo.positionCode}</td>
                        <td>${vo.state}</td>
                        <td>${vo.salaryCode}</td>
                        <td>${vo.rank}</td>
                        <td>${vo.salary}</td>
                        <td>${vo.bonus}</td>
                        <td>${vo.id}</td>
                        <td>${vo.pwd}</td>
                        <td>${vo.nick}</td>
                        <td>${vo.name}</td>
                        <td>${vo.phone}</td>
                        <td>${vo.address}</td>
                        <td>${vo.enrollDate}</td>
                        <td>${vo.retireDate}</td>
                        <td>${vo.retireYn}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
