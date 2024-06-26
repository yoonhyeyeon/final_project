<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 목록</title>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');

  .do-hyeon-regular {
    font-family: "Do Hyeon", sans-serif;
    font-weight: 400;
    font-style: normal;
  }

  /* Global styles */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  @keyframes gradientAnimation {
    0% {
      background-position: 0% 50%;
    }

    50% {
      background-position: 100% 50%;
    }

    100% {
      background-position: 0% 50%;
    }
  }

  /* Team container styles */
  .team-container {
    display: flex;
    flex-direction: column;
    margin: 20px;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  }

  .team-header {
    display: grid;
    grid-template-columns: 2fr 2fr 1fr 2fr 2fr 1fr; /* Adjust column widths as needed */
    align-items: center;
    font-weight: bold;
    background-color: #f0f0f0;
    padding: 8px;
    border-bottom: 1px solid #000;
    font-family: 'Do Hyeon', sans-serif;
  }

  .team-row {
    display: grid;
    grid-template-columns: 2fr 2fr 1fr 2fr 2fr 1fr; /* Adjust column widths as needed */
    align-items: center;
    border-bottom: 1px solid #ccc;
    font-family: 'Do Hyeon', sans-serif;
  }

  .team-row:hover {
      box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3); /* Example shadow, adjust as needed */
  }

  .team-data {
    padding: 8px;
  }

  .team-link {
    text-decoration: none;
    color: blue;
    text-align: center;
    font-family: 'Do Hyeon', sans-serif;
  }

      /* Pagination styles */
      .pagination {
          margin-top: 20px;
          text-align: center;
          font-family: 'Do Hyeon', sans-serif;
      }

      .pagination a, .pagination strong {
          margin: 0 5px;
          text-decoration: none;
          color: #000;
      }

      .pagination strong {
          font-weight: bold;
      }

      /* Search form styles */
      .search-form {
          margin-top: 20px;
          display: flex;
          justify-content: center;
          align-items: center;
          font-family: 'Do Hyeon', sans-serif;
      }

      .search-form select, .search-form input[type="text"], .search-form button {
          margin: 0 5px;
          padding: 10px;
          border-radius: 5px;
          border: none;
          font-family: 'Do Hyeon', sans-serif;
          font-size: 13pt;
      }

      .search-form button {
          background-color: #ddd;
          color: #4a8fad;
          cursor: pointer;
          transition: background-color 0.3s, box-shadow 0.3s;
      }

      .search-form button:hover {
          background-color: #93e9ff;
          box-shadow: 0 0 15px rgba(138, 228, 255, 0.6);
      }

      /* "프로젝트등록" button styles */
      .enroll-button {
          margin-top: 20px;
          padding: 10px 20px;
          border-radius: 5px;
          border: none;
          background-color: #ddd;
          color: #4a8fad;
          font-family: 'Do Hyeon', sans-serif;
          cursor: pointer;
          transition: background-color 0.3s, box-shadow 0.3s;
      }

      .enroll-button:hover {
          background-color: #93e9ff;
          box-shadow: 0 0 15px rgba(138, 228, 255, 0.6);
      }
</style>


</head>
<body>
    <div>
        <div class="team-container">
            <div class="team-header">
                <div>부서명</div>
                <div>팀명</div>
                <div>팀 상태</div>
                <div>팀 생성일</div>
                <div>팀 변경일</div>
                <div>팀 수정</div>
            </div>
            <c:forEach items="${voList}" var="vo">
                <div class="team-row">
                    <div class="team-data">${vo.deptName}</div>
                    <div class="team-data">${vo.name}</div>
                    <div class="team-data">${vo.state}</div>
                    <div class="team-data">${vo.enrollDate}</div>
                    <div class="team-data">${vo.modifyDate}</div>
                    <div class="team-data"><a href="/adminDeptMngr/edit?code=${vo.code}" class="team-link">수정</a></div>
                </div>
            </c:forEach>
        </div>
        <div>
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <a href="/adminDeptMngr/list?page=${currentPage - 1}">이전</a>
                </c:if>
                <c:forEach begin="1" end="${totalPages}" var="x">
                    <c:choose>
                        <c:when test="${currentPage == x}">
                            <strong>${x}</strong>
                        </c:when>
                        <c:otherwise>
                            <a href="/adminDeptMngr/list?page=${x}">${x}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <a href="/adminEmpMngr/list?page=${currentPage + 1}">다음</a>
                </c:if>
            </div>

            <div class="search-form">
                <form action="/adminDeptMngr/search" method="post">
                    <select name="empCategory">
                        <option value="deptName">부서</option>
                        <option value="name">팀</option>
                        <option value="state">상태</option>
                    </select>
                    <input type="text" name="searchBox">
                    <button type="submit" class="tableButton">검색</button>
                </form>
                <button class="enroll-button" onclick="window.location.href='/adminDeptMngr/enrollDiv'">프로젝트등록</button>
            </div>
        </div>
    </div>
</body>
</html>
