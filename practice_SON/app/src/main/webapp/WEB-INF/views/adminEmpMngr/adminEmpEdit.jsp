<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminEnroll.css">
            <link rel="stylesheet" type="text/css" href="/css/adminMngrCss/adminPageBtn.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminEmpJs/adminEmpEdit.js"></script>
            <script defer src="/js/adminEmpJs/adminEmpDivSlt.js"></script>
            <script defer src="/js/adminEmpJs/adminEmpEditSubmit.js"></script>
            <title>Document</title>
        </head>

        <body>
            <section>
                <div class="form-container">
                    <div class="form-group">
                        <div class="label">사원번호</div>
                        <input type="text" class="value" name="no" id="no">
                    </div>
                    <div class="form-group">
                        <div class="label">아이디</div>
                        <input type="text" class="value" name="id" id="id">
                    </div>
                    <div class="form-group">
                        <div class="label">닉네임</div>
                        <input type="text" class="value" name="nick" id="nick">
                    </div>
                    <div class="form-group">
                        <div class="label">이름</div>
                        <input type="text" class="value" name="name" id="name">
                    </div>
                    <div class="form-group">
                        <div class="label">전화번호</div>
                        <input type="text" class="value" name="phone" id="phone">
                    </div>
                    <div class="form-group">
                        <div class="label">주소</div>
                        <input type="text" class="value" name="address" id="address">
                    </div>
                    <div class="form-group">
                        <div class="label">입사일</div>
                        <input type="date" class="value" name="enrollDate" id="enrollDate">
                    </div>
                    <div class="form-group">
                        <div class="label">부서</div>
                        <select name="deptCategory" id="deptCategory">
                            <option value="10">경영지원부</option>
                            <option value="20">인사부</option>
                            <option value="30">연구개발부</option>
                            <option value="40">영업부</option>
                            <option value="50">홍보부</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="label">팀</div>
                        <select name="divCategory" id="divCategory">
                            <!-- AJAX로 가져온 팀 정보가 여기에 추가될 예정 -->
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="label">직급</div>
                        <select name="positionCategory" id="positionCategory">
                            <option value="11">관리자</option>
                            <option value="20">이사</option>
                            <option value="30">부장</option>
                            <option value="40">팀장</option>
                            <option value="50">차장</option>
                            <option value="60">과장</option>
                            <option value="70">대리</option>
                            <option value="80">주임</option>
                            <option value="90">사원</option>
                        </select>
                    </div>
                    <button class="edit-button" id="updateButton">수정 완료</button>
                    <button class="getBack-button" id="listButton"
                        onclick="location.href='/adminEmpMngr/list'">목록으로</button>
                </div>
            </section>
        </body>

        </html>