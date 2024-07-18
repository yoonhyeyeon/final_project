<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
    </style>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
   <link rel="stylesheet" type="text/css" href="/css/board/notice/list.css">
   <script defer src="../js/board/notice/list.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
  
  <table border="1" id="rightBox">
    <tr id="listBox">
      <th>No.</th>
      <th>제목</th>
      <th>등록일</th>
      <th>등록자</th>
      <th>조회수</th>
    </tr>
    <tbody class="box">

    </tbody>
  </table>

  <style>

#rightBox{
  width: 100%;
  text-align: center;
  border-collapse: collapse;
  border-color: lightgrey;
}

#listBox{
  height: 40px;
  background-color: lightgrey;
}

.list{
  height: 40px;
  cursor: pointer;
}



#rightBox tr:nth-child(even){
  background-color: #f9f9f9;
}

#rightBox tr:nth-child(even):hover{
  background-color: #e0f7fa;
}

#notice{
    display: flex;
    justify-content: center;
    align-content: center;
}

  </style>


</body>
</html>