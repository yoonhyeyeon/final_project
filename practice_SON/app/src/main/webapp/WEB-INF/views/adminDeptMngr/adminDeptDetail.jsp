<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="/css/adminDeptEdit.css">
            <link rel="stylesheet" type="text/css" href="/css/adminEnroll.css">
            <link rel="stylesheet" type="text/css" href="/css/adminList.css">
            <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script defer src="/js/adminDeptEdit.js"></script>
            <script defer src="/js/adminDeptDetail.js"></script>
            <script defer src="/js/adminDeptDetailMem.js"></script>
            <title>팀 정보</title>
        </head>

        <body>
            <section>
                <div class="form-container">
                    <div id="editForm" action="/adminDeptMngr/edit" method="post">
                        <div class="form-group">
                            <label for="deptName">부서</label>
                            <div class="value" id="deptName">${vo.deptName}</div>
                        </div>
                        <div class="form-group">
                            <label for="name">팀명</label>
                            <div class="value" id="name">${vo.name}</div>
                        </div>
                        <div class="form-group">
                            <label for="enrollDate">생성일</label>
                            <div class="value" id="enrollDate">${vo.enrollDate}</div>
                        </div>
                        <div class="form-group">
                            <label for="modifyDate">수정일</label>
                            <div class="value" id="modifyDate">${vo.modifyDate}</div>
                        </div>
                        <div class="form-group">
                            <label for="state">팀 상태</label>
                            <div class="value" id="state">${vo.modifyDate}</div>
                        </div>
                        <div>
                            <div class="emp-container list-container" id="empContainer"></div>
                            <div class="pagination" id="pagination"></div>
                        </div>
                        <div class="form-group">
                            <button class="edit-button" id="updateButton">부서정보수정</button>
                            <button class="getBack-button" id="listButton" onclick="location.href='/adminDeptMngr/list'">목록으로</button>
                        </div>
                    </div>
                </div>
            </section>
        </body>

</html>