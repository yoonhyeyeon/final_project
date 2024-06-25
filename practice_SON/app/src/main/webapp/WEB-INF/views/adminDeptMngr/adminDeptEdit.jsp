<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>팀 수정</title>
</head>
<body>
<form id="editForm" action="/adminDeptMngr/edit" method="post">
    <table border="1">
        <tr>
            <td>부서</td>
            <td>
                <select name="deptCode">
                    <option value="10" ${vo.deptCode == 10 ? 'selected' : ''}>경영지원부</option>
                    <option value="20" ${vo.deptCode == 20 ? 'selected' : ''}>인사부</option>
                    <option value="30" ${vo.deptCode == 30 ? 'selected' : ''}>연구개발</option>
                    <option value="40" ${vo.deptCode == 40 ? 'selected' : ''}>영업</option>
                    <option value="50" ${vo.deptCode == 50 ? 'selected' : ''}>홍보</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>팀명</td>
            <td>
                <input type="text" name="name" value="${vo.name}" readonly>
            </td>
        </tr>
        <tr>
            <td>팀코드</td>
            <td>
                <input type="text" name="code" value="${vo.code}" readonly>
            </td>
        </tr>
        <tr>
            <td>수정일</td>
            <td>
                <input type="date" name="modifyDate" value="${vo.modifyDate}">
            </td>
        </tr>
        <tr>
            <td>팀 상태</td>
            <td>
                <select name="state">
                    <option value="활동중">활동중</option>
                    <option value="준비중">준비중</option>
                    <option value="중단">중단</option>
                    <option value="폐지">폐지</option>
                    <option value="완료">완료</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="수정하기">
</form>
</body>
</html>