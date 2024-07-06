<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM</title>
      <link rel="stylesheet" href="/css/projectCss/projectDetail.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
            <div id="out">
                <div id="in">
                    <div id="div-title">
                        <h1>프로젝트</h1>
                    </div>
                    &nbsp;&nbsp;<p class="title"></p><hr>
                    &nbsp;&nbsp;<p class="deptCode"></p><hr>
                    &nbsp;&nbsp;<p class="employee"></p><br><hr>
                    &nbsp;&nbsp;<p class="state" ></p><br>
                    <hr>
                    <h2>내용</h2>
                    <textarea name="content" id="projectContent" readonly></textarea><br>
                    <div id="divSubmit">
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
      </div>
      <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>



</html>

<script>
    function getParam(param){
        const url = new URLSearchParams(window.location.search);
        return url.get(param);
    }
    $(document).ready(() => {
        const no = getParam("no");
        if(no){
            $.ajax({
            url : 'http://127.0.0.1:8383/project/detailData',
            type : 'get',
            data : { no : no },
            success : (detailData)=> {
              console.log("상세 정보 통신 성공");
              console.log(detailData)


                const dept = document.querySelector(".deptCode");
                const pm = document.querySelector(".employee");
                const prjContent = document.querySelector("#projectContent");
                const state = document.querySelector(".state");
                const smt = document.querySelector("#divSubmit");
                const title = document.querySelector(".title");




                let str1 = "";
                let str2 = "";
                let str3 = "";
                let str4 = "";
                let str5 = "";

                str5 += "주제 :" + detailData.title
                str1 += "부서 : " +  detailData.dept
                str2 += "담당자 : " +  detailData.pm
                str3 += detailData.content
                str4 += "상태 : " + detailData.state

                dept.innerHTML = str1;
                pm.innerHTML = str2;
                prjContent.innerHTML = str3;
                state.innerHTML = str4;
                title.innerHTML = str5;

                let str="";
                str += "<button class='list-item' data-id='"+detailData.no +"'>" + "수정하기";
                str += "</button>";
                smt.innerHTML = str;

                document.querySelectorAll(".list-item").forEach((smt)=>{
                smt.addEventListener("click", ()=>{
                const no = smt.getAttribute("data-id");
                window.location.href="http://127.0.0.1:8383/project/projectModify?no="+no;

                });
            });

            },
            error : function(x){
                console.log("에러")
            }
        });
        }
    });
    </script>




