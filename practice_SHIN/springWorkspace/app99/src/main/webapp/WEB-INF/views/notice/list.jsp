<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파이널</title>

</head>
<body>
	<h1>공지사항 목록조회</h1>

    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>ttt</td>
                <td>77</td>
            </tr>
        </tbody>
    </table>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>

    $.ajax( {
        url: "http://127.0.0.1:8080/api/notice/list"  ,
        method: "get" ,
        data: {} ,
        success: function(x){
            
            const voList = x;

            const tbody = document.querySelector("tbody");
            let str = "";

            for(let i = 0; i < voList.length; ++i){
                str += "<tr>";
                str += "<td>" + voList[i].no + "</td>";
                str += "<td>" + voList[i].title + "</td>";
                str += "<td>" + voList[i].hit + "</td>";
                str += "</tr>";
            }
            
            tbody.innerHTML = str;

        },
    } );

    

</script>






