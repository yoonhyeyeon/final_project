<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>팀 수정</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');

        /* Global styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Do Hyeon', sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }

        .form-group div {
            font-size: 15pt;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-family: 'Do Hyeon', sans-serif;
        }

        .form-group input[type="text"],
        .form-group input[type="date"],
        .form-group select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15pt;
            font-family: 'Do Hyeon', sans-serif;
        }

        .form-group input[type="submit"] {
            background-color: #4a8fad;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s, box-shadow 0.3s;
            font-family: 'Do Hyeon', sans-serif;
        }

        .form-group input[type="submit"]:hover {
            background-color: #357594;
            box-shadow: 0 0 15px rgba(138, 228, 255, 0.6);
        }

        /* Responsive adjustments */
        @media (max-width: 600px) {
            .form-group label {
                font-size: 14px;
            }

            .form-group input[type="text"],
            .form-group input[type="date"],
            .form-group select {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="form-container">
    <form id="editForm" action="/adminDeptMngr/edit" method="post">
        <div class="form-group">
            <label for="deptName">부서</label>
            <div>
                ${vo.deptName}
                <input type="hidden" name="deptCode" value="${vo.deptCode}">
            </div>
        </div>
        <div class="form-group">
            <label for="name">팀명</label>
            <div>
                ${vo.name}
                <input type="hidden" name="name" value="${vo.name}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="code">팀코드</label>
            <div>
                ${vo.code}
                <input type="hidden" name="code" value="${vo.code}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="enrollDate">생성일</label>
            <div>
                ${vo.enrollDate}
                <input type="hidden" name="enrollDate" value="${vo.enrollDate}">
            </div>
        </div>
        <div class="form-group">
            <label for="modifyDate">수정일</label>
            <input type="date" name="modifyDate" value="${vo.modifyDate}">
        </div>
        <div class="form-group">
            <label for="state">팀 상태</label>
            <select name="state">
                <option value="활동중">활동중</option>
                <option value="준비중">준비중</option>
                <option value="중단">중단</option>
                <option value="폐지">폐지</option>
                <option value="완료">완료</option>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" value="수정하기">
        </div>
    </form>
</div>
</body>
</html>
