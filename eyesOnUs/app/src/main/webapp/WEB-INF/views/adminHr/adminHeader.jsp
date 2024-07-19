<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <header id="headerContainer">
    <div class="btn">

    </div>
    <div id="profile">
      <c:if test="${sessionScope.adminHrLoginVo != null}">
        <pre>
              안녕하세요. ${sessionScope.adminHrLoginVo.nick} 님
            </pre>
      </c:if>
      <div id="btn2">
        <button onclick="location.href='${pageContext.request.contextPath}/adminHr/logout'">로그아웃</button>
      </div>
    </div>

    <div class="upload-container">
      <h5></h5>
      <!-- <input type="file" id="fileInput" accept="image/*"> -->
      <img id="profileImage" src="#" alt="Profile Image">
    </div>
  </header>