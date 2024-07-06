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

    <form id="editForm" action="/api/personal/edit" method="post">
        <!-- 수정할 데이터의 no 값을 hidden으로 전달 -->
        <input type="hidden" id="noInput" name="no" value="">

        <!-- 수정할 필드들 -->
        <input type="text" id="no2Input" name="no2" placeholder="사원번호">
        <br>
        <input type="text" id="titleInput" name="title" placeholder="제목">
        <br>
        <textarea id="contentInput" name="content" placeholder="내용"></textarea>
        <br>
        <select id="typeNoInput" name="typeNo">
            <option value="1">플젝일정</option>
            <option value="2">팀일정</option>
            <option value="3">개인일정</option>
        </select>

        <select id="stateBNoInput" name="stateBNo">
            <option value="1">진행</option>
            <option value="2">중단</option>
            <option value="3">완료</option>
        </select>

        <br>
        <button type="submit">수정하기</button>
    </form>

    <!-- JavaScript를 통해 필요한 데이터를 입력 필드에 바인딩하는 부분 -->
    <script>
        $(document).ready(function() {
            // URL 파라미터에서 no 값을 가져옴
            const urlParams = new URLSearchParams(window.location.search);
            const no = urlParams.get('no');

            // 서버에서 해당 no에 해당하는 데이터를 가져옴 (예: AJAX 호출을 통해)
            // 예시로 필드에 임의의 값 설정
            const sampleData = {
                no2: "사원번호 값",
                title: "제목 값",
                content: "내용 값",
                typeNo: "1",  // 예시 값
                stateBNo: "1" // 예시 값
            };

            // 데이터를 입력 필드에 설정
            $("#noInput").val(no);
            $("#no2Input").val(sampleData.no2);
            $("#titleInput").val(sampleData.title);
            $("#contentInput").val(sampleData.content);
            $("#typeNoInput").val(sampleData.typeNo);
            $("#stateBNoInput").val(sampleData.stateBNo);
        });
    </script>
</body>
</html>
