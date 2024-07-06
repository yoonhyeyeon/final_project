<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
<link rel="stylesheet" href="/css/projectCss/projectList.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
</head>
    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
            <div id="out">
                <div id="in">
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
                </div>
            </div>
            <div id="divSearch">
                <select name="search" id="search">
                    <option value="1">제목</option>
                </select>
                <input type="text" name="title" id="title">
                <button id="searchBtn" onclick="saerchName();">검색</button>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
      </div>
      <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>



</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    $.ajax({
        url : "http://127.0.0.1:8383/project/listData",
        method : "get",
        data : {},
        success : function(x){
            const voList = x;
            const tbody = document.querySelector("tbody");
            let str="";
            for(let i=0;i<voList.length;i++){
                str += "<tr class='list-item' data-id='"+voList[i].no + "'>";
                str += "<td>"+ voList[i].title + "</td>";
                str += "<td>"+ voList[i].pm + "</td>";
                str += "<td>" + voList[i].dept + "</td>";
                str += "<td>" + voList[i].state + "</td>";
                str += "<td>" + voList[i].startDate + "</td>";
                str += "<td>" + voList[i].modifyDate + "</td>";
                str += "</tr>";
            }
            tbody.innerHTML = str;

            document.querySelectorAll(".list-item").forEach((tbody)=>{
                tbody.addEventListener("click", ()=>{
                const no = tbody.getAttribute("data-id");
                window.location.href="http://127.0.0.1:8383/project/detail?no="+no;
                });
            });
        },
        error : function(x){
            console.log("에러입니다.");
        },
    });

    function saerchName(){
        const titleVal = document.querySelector("input[name=title]").value;
        $.ajax({
            url : "http://127.0.0.1:8383/project/searchByName",
            method : "get",
            data :{
                title : titleVal
            },
            success : function(x){
                const tbody = document.querySelector("tbody");
                let str="";
                for(let i=0;i<x.length;i++){
                str += "<tr>";
                str += "<td>"+ x[i].title + "</td>";
                str += "<td>"+ x[i].pm + "</td>";
                str += "<td>" + x[i].dept + "</td>";
                str += "<td>" + x[i].state + "</td>";
                str += "<td>" + x[i].startDate + "</td>";
                str += "<td>" + x[i].modifyDate + "</td>";
                str += "</tr>";
            }
            tbody.innerHTML = str;
            },
            error : function(x){
                console.log("에러");
            },
        });
    }
</script>



