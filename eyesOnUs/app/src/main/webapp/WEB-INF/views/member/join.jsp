<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>join</title>
  <link rel="stylesheet" href="/css/member/join.css">

</head>
<body>
  <div class="background"></div>


  <div class="floating-window">
    <div class="join">
      <h1>join with us</h1>
      <form action="/member/join" method="POST">
        <label for="username">ID</label>
        <input type="text" id="username" name="id" placeholder="사용자명" required>

        <label for="password">PWD</label>
        <input type="password" id="password" name="pwd" placeholder="비밀번호" required>

        <label for="nickname">NICK</label>
        <input type="text" id="nickname" name="nick" placeholder="닉네임" required>

        <label for="name">NAME</label>
        <input type="text" id="name" name="name" placeholder="성명" required>

        <label for="phone">PHONE</label>
        <input type="tel" id="phone" name="phone" placeholder="전화번호" required>

        <label for="address">ADDRESS</label>
        <input type="text" id="address" name="address" placeholder="주소" required>


        <label for="position">직책</label>
        <select id="position" name="positionCode">
          <option value="90">사원</option>
          <option value="80">주임</option>
          <option value="70">대리</option>
          <option value="60">과장</option>
          <option value="50">차장</option>
          <option value="40">팀장</option>
          <option value="30">부장</option>
          <option value="20">이사</option>
          <option value="10">사장</option>
          <option value="11">관리자</option>
        </select>

        <!-- 프로필 사진 업로드 -->
        <label for="profilePic">프로필 사진</label>
        <input type="file" id="profilePic" name="profilePic" accept="image/*" class="custom-file-input">

        <button type="submit">가입하기</button>
      </form>
  </div>


</body>
</html>