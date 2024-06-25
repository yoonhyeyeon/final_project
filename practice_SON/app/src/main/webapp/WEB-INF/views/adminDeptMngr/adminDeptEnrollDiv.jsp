<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <form action="/adminDeptMngr/enrollDiv" method="post">
        <table border="1">
            <tr>
                <td>부서</td>
                <td>
                    <select name="deptCategory">
                        <option value="10">경영지원부</option>
                        <option value="20">인사부</option>
                        <option value="30">연구개발</option>
                        <option value="40">영업</option>
                        <option value="50">홍보</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>팀명</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>팀코드</td>
                <td>
                    <input type="text" name="code">
                </td>
            </tr>
            <tr>
                <td>설립일</td>
                <td>
                    <input type="date" name="enrollDate">
                </td>
            </tr>
            <tr>
                <td>팀 상태</td>
                <td>
                    <select name="stateCategory">
                        <option value="활동중">활동중</option>
                        <option value="준비중">준비중</option>
                    </select>
                </td>
            </tr>

        </table>
        <input type="submit" name="작성하기">
    </form>

</body>
</html>