<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트일정 작성</title>
<style>
 h1 {
           text-align: center;
           color: #007bb5; /* 신뢰감을 주는 파란색 텍스트 */
       }

       form {
           background-color: #fff;
           padding: 20px;
           border-radius: 8px;
           box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
           width: 300px;
           height: 600px; /* 폼 높이 고정 */
           display: flex;
           flex-direction: column; /* 세로 방향 배치 */
           justify-content: space-between; /* 공간 균등 배분 */
           align-items: center; /* 중앙 정렬 */
       }

       input[type="text"],
       textarea,
       select {
           width: calc(100% - 20px);
           padding: 10px;
           margin-bottom: 10px;
           border: 1px solid #ccc;
           border-radius: 4px;
       }

       textarea {
           height: 200px; /* "내용" 영역의 높이 증가 */
       }

       input[type="submit"] {
           width: 100%;
           padding: 10px;
           background-color: #007BFF;
           border: none;
           border-radius: 4px;
           color: white;
           font-size: 16px;
           cursor: pointer;
       }

       input[type="submit"]:hover {
           background-color: #0056b3;
       }

       select {
           height: 40px;
       }
</style>

</head>
<body>
     <h4>프로젝트일정</h4>
	<form action="/api/projectWork/write" method="post">

        <input type="text" name="no2" placeholder="사번">
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
        <input type="submit" value="작성하기">
    </form>

  <script>



       function insertNotice() {
         // 폼 데이터 가져오기
         const no2Value = document.querySelector("input[name=no2]").value;
         const titleValue = document.querySelector("input[name=title]").value;
         const contentValue = document.querySelector("textarea[name=content]").value;
         const typeNoValue = document.querySelector("select[name=typeNo]").value;
         const stateBNoValue = document.querySelector("select[name=stateBNo]").value;




         // AJAX 요청
         $.ajax({
           url: "/api/projectWork/write",  // 수정 API 엔드포인트
           method: "post",
           data: {  // JSON 문자열로 변환하여 데이터 전송
             "no2": no2Value,
             "title": titleValue,
             "content": contentValue,
             "typeNo": typeNoValue,
             "stateBNo": stateBNoValue
           },
           success: function (response) {
             alert(response);  // 성공 메시지 알림
             location.href = "/personal/list";  // 목록 페이지로 이동
           },
           error: function () {
             location.href = "/error-page";  // 에러 페이지로 이동
           },
         });
       }
    </script>

</body>
</html>









