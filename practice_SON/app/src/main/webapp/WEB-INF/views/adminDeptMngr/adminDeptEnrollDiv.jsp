<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 등록</title>
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
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="date"],
        .form-group select {
            width: calc(100% - 12px);
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

        /* Styling for the form items */
        .form-item {
            margin-bottom: 20px;
        }

        .form-item label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-item input[type="text"],
        .form-item input[type="date"],
        .form-item select {
            width: calc(100% - 12px);
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15pt;
            font-family: 'Do Hyeon', sans-serif;
        }

        .form-item input[type="submit"] {
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

        .form-item input[type="submit"]:hover {
            background-color: #357594;
            box-shadow: 0 0 15px rgba(138, 228, 255, 0.6);
        }

        /* Styling for the form container */
        .form-container {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <div class="form-item">
            <label>부서</label>
            <select name="deptCategory">
                <option value="10">경영지원부</option>
                <option value="20">인사부</option>
                <option value="30">연구개발</option>
                <option value="40">영업</option>
                <option value="50">홍보</option>
            </select>
        </div>
        <div class="form-item">
            <label>팀명</label>
            <input type="text" name="name">
        </div>
        <div class="form-item">
            <label>팀코드</label>
            <input type="text" name="code">
        </div>
        <div class="form-item">
            <label>설립일</label>
            <input type="date" name="enrollDate">
        </div>
        <div class="form-item">
            <label>팀 상태</label>
            <select name="stateCategory">
                <option value="활동중">활동중</option>
                <option value="준비중">준비중</option>
            </select>
        </div>
        <div class="form-item">
            <input class="enroll-button" type="submit" value="작성하기">
        </div>
    </div>
</body>
</html>
