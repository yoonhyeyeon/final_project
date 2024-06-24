<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VO Data Table</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>VO Data Table</h2>
    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>No2</th>
                <th>State B No</th>
                <th>Type No</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Modify Date</th>
                <th>Title</th>
                <th>Content</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${voList}">
                <tr>
                    <td>${item.no}</td>
                    <td>${item.no2}</td>
                    <td>${item.stateBNo}</td>
                    <td>${item.typeNo}</td>
                    <td>${item.startDate}</td>
                    <td>${item.endDate}</td>
                    <td>${item.modifyDate}</td>
                    <td>${item.title}</td>
                    <td>${item.content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>