<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.submit-button').click(function(event) {
                event.preventDefault();

                var formData = {
                    id: $('input[name="id"]').val(),
                    nick: $('input[name="nick"]').val(),
                    pwd: $('input[name="pwd"]').val(),
                    name: $('input[name="name"]').val(),
                    phone: $('input[name="phone"]').val(),
                    address: $('input[name="address"]').val(),
                    deptCode: $('input[name="deptCode"]').val(),
                    divCode: $('input[name="divCode"]').val(),
                    positionCode: $('input[name="positionCode"]').val(),
                    enrollDate: $('input[name="enrollDate"]').val()
                };

                $.ajax({
                    type: 'POST',
                    url: 'enrollEmpData',
                    data: formData,
                    success: function(response) {
                        window.location.href = '/adminEmpMngr/list';
                    },
                    error: function(error) {
                        console.log('Error:', error);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <div class="form-container">
        <div class="form-group">
            <div class="label">아이디</div>
            <input type="text" class="value" name="id">
        </div>
        <div class="form-group">
            <div class="label">닉네임</div>
            <input type="text" class="value" name="nick">
        </div>
        <div class="form-group">
            <div class="label">비밀번호</div>
            <input type="password" class="value" name="pwd">
        </div>
        <div class="form-group">
            <div class="label">이름</div>
            <input type="text" class="value" name="name">
        </div>
        <div class="form-group">
            <div class="label">전화번호</div>
            <input type="text" class="value" name="phone">
        </div>
        <div class="form-group">
            <div class="label">주소</div>
            <input type="text" class="value" name="address">
        </div>
        <div class="form-group">
            <div class="label">입사일</div>
            <input type="date" class="value" name="enrollDate">
        </div>
        <div class="form-group">
            <div class="label">부서</div>
            <input type="text" class="value" value="인사부"readonly>
            <input type="hidden" class="value" value="20" name="deptCode">
        </div>
        <div class="form-group">
            <div class="label">팀</div>
            <input type="text" class="value" value="인사본부"readonly>
            <input type="hidden" class="value" value="20" name="divCode">
        </div>
        <div class="form-group">
            <div class="label">직급</div>
            <input type="text" class="value" value="사원"readonly>
            <input type="hidden" class="value" value="90" name="positionCode">
        </div>
            <input class="submit-button" type="submit" value="작성하기">
    </div>
</body>
</html>
