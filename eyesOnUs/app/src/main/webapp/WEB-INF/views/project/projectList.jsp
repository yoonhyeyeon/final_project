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
                    <table border=1>
                        <thead>
                            <tr><td>프로젝트 이름</td>
                                <td>부서코드</td>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
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
        url : "http://127.0.0.1:8080/project/listData",
        method : "get",
        data : {},
        success : function(x){
            const voList = x;
            const tbody = document.querySelector("tbody");
            let str="";
            for(let i=0;i<voList.length;i++){
                str += "<tr class='list-item' data-id='"+voList[i].no + "'>";
                str += "<td>"+ voList[i].title + "</td>";
                str += "<td>" + voList[i].code + "</td>";
                str += "</tr>";
            }
            tbody.innerHTML = str;

            document.querySelectorAll(".list-item").forEach((tbody)=>{
                tbody.addEventListener("click", ()=>{
                const no = tbody.getAttribute("data-id");
                window.location.href="http://127.0.0.1:8080/project/detail?no="+no;
                });
            });
        },
        error : function(x){
            console.log("에러입니다.");
        },
    });
</script>

