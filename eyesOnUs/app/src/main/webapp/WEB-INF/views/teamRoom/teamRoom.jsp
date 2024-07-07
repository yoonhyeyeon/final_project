<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Slide Sidebar</title>
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
</head>
<body>
  <div id="sidebar" class="sidebar">
    <img src="profile.jpg" alt="Profile" class="profile-pic">
    <div class="button-container">
        <button class="sidebar-btn">프로젝트 일정</button>
        <button class="sidebar-btn">기타 일정</button>
        <button class="sidebar-btn">근태관리</button>
        <button class="sidebar-btn">결제</button>
        <button class="sidebar-btn">사용자 정보</button>
    </div>
</div>
<button id="openBtn" class="open-btn">☰ Sidebar</button>

<div id="calendarContainer" class="calendar-container">
  <!-- 여기에 캘린더 내용을 추가할 수 있습니다 -->
</div>

<div id="listContainer" class="list-container">
  <!-- 여기에 목록 내용을 추가할 수 있습니다 -->
  <h4>다가오는 일정</h4>
  <table>
      <thead>
          <tr>
              <th>번호</th>
              <th>제목</th>
              <th>내용</th>
          </tr>
      </thead>
      <tbody id="personalTableBody">
          <!-- 동적 데이터가 여기에 추가됩니다 -->
      </tbody>
  </table>

</div>

<script src="/js/teamRoom/teamRoom.js"></script>
</body>
</html>
