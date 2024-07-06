<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }

    h1 {
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    table th, table td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ddd;
    }

    table th {
        background-color: #f2f2f2;
        color: #333;
    }

    table tbody tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    table tbody tr:hover {
        background-color: #e0f7fa;
    }
</style>
</head>
<body>
    <h1>기타일정 목록 조회</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
            </tr>
        </thead>
        <tbody id="personalTableBody">
            <!-- Dynamic rows will be inserted here -->
        </tbody>
    </table>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: "http://127.0.0.1:8181/api/personal/list",
                method: "get",
                dataType: "json",
                success: function(data) {
                    const voList = data;
                    const tbody = $("#personalTableBody");

                    let rows = "";

                    for (let i = 0; i < voList.length; ++i) {
                        rows += "<tr>";
                        rows += "<td>" + voList[i].no + "</td>";
                        rows += "<td>" + voList[i].title + "</td>";
                        rows += "<td>" + voList[i].content + "</td>";
                        rows += "</tr>";
                    }

                    tbody.html(rows);
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching data:", error);
                }
            });
        });
    </script>
</body>
</html>





