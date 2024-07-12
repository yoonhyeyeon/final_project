<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TEAM ROOM</title>
    <link rel="stylesheet" href="/css/teamRoom/teamRoom.css">
    <link rel="stylesheet" href="/css/teamRoom/list.css">
    <link rel="stylesheet" href="/css/teamRoom/sidebar.css">
    <link rel="stylesheet" href="/css/projectCss/projectModify.css">
</head>

<body>

    <div class="time">
    <div id="time">
        <!-- 현재 시간을 표시할 div 추가 -->
    </div>

    <div id="work-time-table">
        <!-- 근무 시간을 표시할 div 추가 -->
        <%@ include file="/WEB-INF/views/util/workTime.jsp" %>
    </div>
    </div>

    <div id="sidebar" class="sidebar">
    <%@ include file="/WEB-INF/views/teamRoom/sidebar.jsp" %>
    </div>
    <button id="openBtn" class="open-btn">☰ Sidebar</button>

    <div id="calendarContainer" class="calendar-container">
    <div id="out">
        <div id="in">
            <div id="div-title">
                <h1>프로젝트</h1>
            </div>
            &nbsp;&nbsp;<p class="title"></p><hr>
            &nbsp;&nbsp;<p class="dept"></p><hr>
            &nbsp;&nbsp;<p class="employee"></p><br><hr>
            &nbsp;&nbsp;상태 : <input type="text" name="stateANo" id="stateANo"  placeholder="1:등록, 2:중지, 3:해산">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <p id="pModify">수정일 : </p>
            <hr>
            <h2>내용</h2>
            <textarea name="content" id="projectContent" ></textarea><br>
            <div id="div-submit">
                <button id="submitButton" onclick="f01();">수정하기</button>
            </div>
        </div>
    </div>
    </div>

    <div id="listContainer" class="list-container">
    <!-- 여기에 **서브** 내용을 추가할 수 있습니다 -->
    <%@ include file="/WEB-INF/views/teamRoom/list.jsp" %>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/js/teamRoom/teamRoom.js"></script>

</body>

</html>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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

            const dept = document.querySelector(".dept");
            const pm = document.querySelector(".employee");
            const prjContent = document.querySelector("#projectContent");
            const state = document.querySelector("#stateANo");
            const title = document.querySelector(".title");
            const pModif = document.querySelector("#pModify");

            let str1 = "";
            let str2 = "";
            let str3 = "";
            let str4 = "";
            let str5 = "";
            let str6 = "";
            str1 += "부서코드 : " + detailData.dept
            str2 += "담당자 : " +  detailData.pm
            str3 += detailData.content
            str4 += detailData.state
            str5 += "주제 :" + detailData.title
            str6 += detailData.modifyDate

            dept.innerHTML = str1;
            pm.innerHTML = str2;
            prjContent.innerHTML = str3;
            state.innerHTML = str4;
            title.innerHTML = str5;
            pModif.innerHTML = str6;
        },
        error : function(x){
            console.log("에러")
        }
    });
    }
});

function f01(){
    const contentVal = document.querySelector("#projectContent").value;
    const stateVal = document.querySelector("#stateANo").value;
    $(document).ready(() => {
        const no = getParam("no");
        if(no){
            $.ajax({
                url : 'http://127.0.0.1:8383/project/projectModify',
                type : 'post',
                data : {
                    no : no,
                    content : contentVal,
                    stateANo : stateVal
                },
                success : function(data){
                        alert("수정 완료!");
                        location.href='http://127.0.0.1:8383/project/projectList';

                },
                error : function(data){
                    console.log("에러");
                }
            });
        }
    })
}
</script>