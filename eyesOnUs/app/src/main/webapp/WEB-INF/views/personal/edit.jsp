<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파이널</title>
</head>
<body>
    <h1>기타일정 수정하기</h1>

    <form id="editForm">
        <input type="text" name="no2" placeholder="사원번호">
        <br>
        <input type="text" name="title" placeholder="제목">
        <br>
        <textarea name="content" placeholder="내용"></textarea>
        <br>
        <select name="typeNo">
            <option value="1">플젝일정</option>
            <option value="2">팀일정</option>
            <option value="3">개인일정</option>
        </select>

        <select name="stateBNo">
            <option value="1">진행</option>
            <option value="2">중단</option>
            <option value="3">완료</option>
        </select>

        <br>
        <button type="button" onclick="submitForm()">수정하기</button>
    </form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    function submitForm() {
        const form = document.getElementById('editForm');
        const formData = {
            "no2": no2value,
            "title": form.title.value,
            "content": form.content.value,
            "typeNo": form.typeNo.value,
            "stateBNo": form.stateBNo.value
        };

        $.ajax({
            url: "/api/personal/edit",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function(response) {
                if (response === "edit success ~ !") {
                    alert("수정이 완료되었습니다.");
                    location.href = "/personal/list";
                } else {
                    alert("수정에 실패했습니다.");
                    // 실패 시 처리할 내용 추가
                }
            },
            error: function() {
                alert("서버 오류가 발생했습니다. 다시 시도해 주세요.");
                // 오류 처리
            }
        });
    }
</script>
</body>
</html>







