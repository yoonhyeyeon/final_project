<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Personal List</title>
</head>
<body>

   <h1>Personal List</h1>
       <table border="1">
           <thead>
               <tr>
                   <th>No</th>
                   <th>No2</th>
                   <th>State B No</th>
                   <th>Type No</th>
                   <th>Start Date</th>
                   <th>Title</th>
                   <th>Content</th>
               </tr>
           </thead>
           <tbody>
               <tr th:each="personal : ${personalList}">
                   <td th:text="${personal.no}"></td>
                   <td th:text="${personal.no2}"></td>
                   <td th:text="${personal.stateBNo}"></td>
                   <td th:text="${personal.typeNo}"></td>
                   <td th:text="${personal.startDate}"></td>
                   <td th:text="${personal.title}"></td>
                   <td th:text="${personal.content}"></td>
               </tr>
           </tbody>
       </table>

</body>
</html>
