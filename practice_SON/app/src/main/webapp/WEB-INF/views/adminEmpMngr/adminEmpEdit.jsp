<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="/js/adminEmpEnroll.js"></script>
    <title>Document</title>
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
            <select name="deptCategory">
                <option value="10">경영지원부</option>
                <option value="20">인사부</option>
                <option value="30">연구개발</option>
                <option value="40">영업</option>
                <option value="50">홍보</option>
            </select>
        </div>
        <div class="form-group">
            <div class="label">팀</div>
                <select name="divCategory" id="divCategory">
                </select>
        </div>
        <div class="form-group">
            <div class="label">직급</div>
            <select name="positionCategory">
                <option value="11">관리자</option>
                <option value="20">이사</option>
                <option value="30">부장</option>
                <option value="40">팀장</option>
                <option value="50">차장</option>
                <option value="60">과장</option>
                <option value="70">대리</option>
                <option value="80">주임</option>
                <option value="90">사원</option>
            </select>
        </div>
            <button class="edit-button" id="updateButton" onclick="location.href='/adminEmpMngr/edit?empNo=${vo.no}'">사원 정보 수정</button>
            <button class="getBack-button" id="listButton" onclick="location.href='/adminEmpMngr/list'">목록으로</button>
    </div>
    
</body>
<script>
$(document).ready(function() {
    // 부서 선택이 변경되었을 때 이벤트 처리
    $('#deptCategory').change(function() {
        var selectedDept = $(this).val(); // 선택된 부서 코드

        // AJAX를 이용하여 해당 부서에 속하는 팀 정보 가져오기
        $.ajax({
            url: '/adminEmpMngr/getTeams?deptCode=' + selectedDept,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                // 팀 선택(select) 요소 초기화
                var divCategorySelect = $('#divCategory');
                divCategorySelect.empty(); // 기존 옵션 제거

                // 받은 데이터를 이용해 팀 옵션 추가
                data.forEach(function(team) {
                    divCategorySelect.append('<option value="' + team.code + '">' + team.name + '</option>');
                });
            },
            error: function(xhr, status, error) {
                console.error('팀 정보를 가져오는 중 오류 발생:', error);
            }
        });
    });

    // 페이지 로드 시 초기 설정
    $('#deptCategory').trigger('change');
});
</script>
</html>