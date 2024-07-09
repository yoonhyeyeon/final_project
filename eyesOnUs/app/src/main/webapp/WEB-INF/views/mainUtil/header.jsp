<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header id="headerContainer">
    <div class="btn">
      <div id="goto">
        <button>📥출근</button>
      </div>

      <div id="leave">
        <button>📤퇴근</button>
      </div>

    </div>



    <div id="profile">
        <pre>
          안녕하세요. |로그인아이디| 님
          |인사관리부서| 사원
        </pre>

      <div id="btn2">
        <button>수정</button>
        <button onclick="location.href='${pageContext.request.contextPath}/member/logout'">로그아웃</button>
      </div>
    </div>

    <div class="upload-container">
      <h5>프로필</h5>
      <!-- <input type="file" id="fileInput" accept="image/*"> -->
      <img id="profileImage" src="#" alt="Profile Image">
    </div>
</header>