<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> 로그인 </title>
</head>

<h1>로그인</h1>

  <form action="/member/login" method="POST">
    <input type="text" name="id">
    <br>
    <input type="text" name="pwd">
    <br>
    <input type="submit" name="submit">
  </form>

</body>
</html>