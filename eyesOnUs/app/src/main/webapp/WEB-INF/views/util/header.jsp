<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>



<header id="header">

<div class="btn">
  <div id="goto">
    <button onclick="write01(${vo.empNo});">📥출근</button>
  </div>

  <div id="leave">
    <button onclick="write02(${vo.empNo});">📤퇴근</button>
  </div>

</div>



<div id="profile">
    <pre>안녕하세요.</pre>

  <div id="btn2">
    <button>수정</button>
    <button>로그아웃</button>
  </div>
</div>

<div class="upload-container">
  <h5>프로필</h5>
</div>

</header>

