<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <header id="headerContainer">
    <div class="btn">
      <div id="goto">
        <button onclick="write01(${sessionScope.loginMemberVo.no});">📥출근</button>
      </div>

      <div id="leave">
        <button onclick="write02(${sessionScope.loginMemberVo.no});">📤퇴근</button>
      </div>

    </div>
    <div id="profile">
      <c:if test="${sessionScope.loginMemberVo != null}">
        <pre>
              안녕하세요. ${sessionScope.loginMemberVo.id} 님
              |${sessionScope.loginMemberVo.deptName}| ${sessionScope.loginMemberVo.name} ${sessionScope.loginMemberVo.positionName}
            </pre>
      </c:if>

      <div id="btn2">
        <button onclick="location.href='${pageContext.request.contextPath}/member/logout'">로그아웃</button>
      </div>
    </div>

    <div class="upload-container">
      <h5></h5>
      <!-- <input type="file" id="fileInput" accept="image/*"> -->
      <img id="profileImage" src="#" alt="Profile Image">
    </div>
  </header>