<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
<link rel="stylesheet" href="/css/projectCss/projectList.css">
      <script defer src="/js/projectJs/projectSearch.js"></script>
      <script defer src="/js/projectJs/projectList.js"></script>
</head>
    <body id="container">
      <div id="warp">
        <section>
                    <table>
                        <thead>
                            <tr>
                                <td>프로젝트 이름</td>
                                <td>PM</td>
                                <td>담당 부서</td>
                                <td>상태</td>
                                <td>시작일</td>
                                <td>수정일</td>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>

            <div id="divSearch">
                <select name="search" id="search">
                    <option value="1">제목</option>
                </select>
                <input type="text" name="title" id="title">
                <button id="searchBtn" onclick="saerchName();">검색</button>
            </div>
        </section>
      </div>
    </body>



</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>



