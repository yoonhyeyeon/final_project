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

       thead, tbody tr {
           display: table;
           width: 100%;
           table-layout: fixed; /* 테이블 셀의 고정된 레이아웃 */
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
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>등록일</th>
                <th>사원 번호</th> <!-- 추가된 열 -->
                <th>상태</th> <!-- 추가된 열 -->
                <th>유형</th> <!-- 추가된 열 -->
                <th>삭제</th> <!-- 추가된 열 -->
            </tr>
        </thead>
        <tbody id="projectTableBody">
            <!-- Dynamic rows will be inserted here -->
        </tbody>
    </table>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>


  // 상태 번호를 문자열로 변환하는 함수
        function getStateBNoString(stateBNo) {
            switch(stateBNo) {
                case 1: return "진행";
                case 2: return "중단";
                case 3: return "완료";
                default: return "알 수 없음";
            }
        }

        // 유형 번호를 문자열로 변환하는 함수
        function getTypeNoString(typeNo) {
            switch(typeNo) {
                case 1: return "플젝 일정";
                case 2: return "팀 일정";
                case 3: return "개인 일정";
                default: return "기타";
            }
        }



        $(document).ready(function() {
            $.ajax({
                url: "http://127.0.0.1:8383/api/projectWork/list",
                method: "get",
                dataType: "json",
                success: function(data) {

                    const voList = data;

                    const tbody = $("#projectTableBody");
                    let rows = "";

                    for (let i = 0; i < voList.length; ++i) {
                    const stateBNoStr = getStateBNoString(voList[i].stateBNo);
                    const typeNoStr = getTypeNoString(voList[i].typeNo);

                        rows += "<tr>";
                        rows += "<td>" + voList[i].no + "</td>";
                        rows += "<td>" + voList[i].title + "</td>";
                        rows += "<td>" + voList[i].content + "</td>";
                        rows += "<td>" + voList[i].startDate + "</td>";
                        rows += "<td>" + voList[i].no2 + "</td>";
                        rows += "<td>" + stateBNoStr + "</td>";
                        rows += "<td>" + typeNoStr + "</td>";
                         rows += "<td><button class='edit-button' onclick='deleteRecord(" + voList[i].no + ")'>삭제</button></td>";
                        rows += "</tr>";
                    }

                    tbody.html(rows);
                     // 테이블이 로드된 후 맨 위로 스크롤 이동
                    $("html, body").animate({ scrollTop: 0 }, "slow");
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching data:", error);
                }
            });
        });


     function deleteRecord(no) {
              if (confirm("정말로 삭제하시겠습니까?")) {
                  $.ajax({
                      url: "/api/projectWork/delete/" + no,
                      method: "DELETE",
                      success: function(result) {
                          alert("삭제되었습니다.");
                          location.reload(); // 페이지를 새로고침하여 목록 갱신
                      },
                      error: function(xhr, status, error) {
                          console.error("Error deleting record:", error);
                          alert("삭제에 실패했습니다.");
                      }
                  });
              }
          }



    </script>
</body>
</html>





