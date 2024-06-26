<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Write Personal</title>



</head>
<body>

<form id="personalForm">
    <label for="no2">No2:</label>
    <input type="text" id="no2" name="no2"><br><br>

    <label for="stateBNo">State B No:</label>
    <input type="text" id="stateBNo" name="stateBNo"><br><br>

    <label for="typeNo">Type No:</label>
    <input type="text" id="typeNo" name="typeNo"><br><br>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title"><br><br>

    <label for="content">Content:</label><br>
    <textarea id="content" name="content" rows="4" cols="50"></textarea><br><br>

    <button id="submitBtn" type="button">Submit</button>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
       <script>
          $(document).ready(function () {
              $('#submitBtn').click(function (event) {
                  event.preventDefault();

                  var formData = {
                      no2: $('#no2').val(),
                      stateBNo: $('#stateBNo').val(),
                      typeNo: $('#typeNo').val(),
                      title: $('#title').val(),
                      content: $('#content').val()
                  };

                  $.ajax({
                      type: 'POST',
                      url: '/personal/write',
                      contentType: 'application/json',
                      data: JSON.stringify(formData),
                      success: function () {
                          alert('Personal info successfully saved.');
                          window.location.href = '/personal/listAll'; // 성공 시 목록 페이지로 이동
                      },
                      error: function (error) {
                          console.log('Error:', error);
                          alert('Failed to write personal info. Please try again.');
                      }
                  });
              });
          });

       </script>
</body>
</html>
