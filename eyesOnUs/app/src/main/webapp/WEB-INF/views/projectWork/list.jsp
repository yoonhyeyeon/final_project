<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>프로젝트 일정 목록</title>
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

      .edit-button { /*gpt_수정*/
            background-color: #007BFF; /* Blue background */
            border: none; /* Remove borders */
            color: white; /* White text */
            padding: 10px 20px; /* Some padding */
            text-align: center; /* Center the text */
            text-decoration: none; /* Remove underline */
            display: inline-block; /* Get the element to line up correctly */
            font-size: 16px; /* Increase font size */
            margin: 4px 2px; /* Some margin */
            cursor: pointer; /* Pointer/hand icon */
            border-radius: 4px; /* Rounded corners */
        }

        .edit-button:hover { /*gpt_수정*/
            background-color: #0056b3; /* Darker blue on hover */
        }
</style>
</head>
<body>
    <h1>프로젝트일정 목록 조회</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>사원 번호</th> <!-- 추가된 열 -->
                <th>상태 번호</th> <!-- 추가된 열 -->
                <th>유형 번호</th> <!-- 추가된 열 -->
                <th>수정</th> <!-- 추가된 열 -->
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
                url: "http://127.0.0.1:8383/api/projectWork/list",
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
                        rows += "<td>" + voList[i].no2 + "</td>";
                        rows += "<td>" + voList[i].stateBNo + "</td>";
                        rows += "<td>" + voList[i].typeNo+ "</td>";
                         rows += "<td><button class='edit-button' onclick='editRecord(" + voList[i].no + ")'>수정</button></td>"; //gpt_수정
                        rows += "</tr>";
                    }

                    tbody.html(rows);
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching data:", error);
                }
            });
        });

         // 수정 버튼 클릭 시 호출되는 함수 //gpt_수정
                function editRecord(no) { //gpt_수정
                    window.location.href = "http://127.0.0.1:8383/personal/edit?no=" + no; //gpt_수정
                } //gpt_수정
    </script>
</body>
</html>





