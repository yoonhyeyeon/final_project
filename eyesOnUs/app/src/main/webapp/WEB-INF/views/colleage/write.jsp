<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
    </style>

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="/css/testMain/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/testMain/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/colleage/colleageWrite.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/sidebar.js"></script>
      <script defer src="../js/calender.js"></script>
      <script defer src="../js/colleage/colleageWrite.js"></script>
      <title>YOON</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/mainUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/mainUtil/nav.jsp" %>
        <section>
          <div class="out">
            <h2>동료 평가</h2>
            <div id="date">
              <span>기한 : 2024-07-05&nbsp;&nbsp;</span><span>~&nbsp;&nbsp;2024-07-24</span>
            </div>

            <hr>
            <div id="form">
              <span>평가자</span>
              <select id="evaluatorNo">
                 <option value="">------선택------</option>
                 <% for (int i = 1; i <= 64; i++) { %>
                   <option id="evaluatorNo" value="<%= i %>"><%= i %></option>
                 <% } %>
              </select>
              <br>
              <br>
              <span>평가 대상</span>
              <select id="evaluateeNo">
                 <option value="">------선택------</option>
                 <% for (int i = 1; i <= 64; i++) { %>
                   <option id="evaluateeNo" value="<%= i %>"><%= i %></option>
                 <% } %>
              </select>
              <p>잠재력</p>
              <div class="myform">
                <fieldset>
                  <input type="radio" name="potential" value="10" id="rate1" class="potential">
                  <label for="rate1">★</label>
                  <input type="radio" name="potential" value="9" id="rate2" class="potential">
                  <label for="rate2">★</label>
                  <input type="radio" name="potential" value="8" id="rate3" class="potential">
                  <label for="rate3">★</label>
                  <input type="radio" name="potential" value="7" id="rate4" class="potential">
                  <label for="rate4">★</label>
                  <input type="radio" name="potential" value="6" id="rate5" class="potential">
                  <label for="rate5">★</label>
                  <input type="radio" name="potential" value="5" id="rate6" class="potential">
                  <label for="rate6">★</label>
                  <input type="radio" name="potential" value="4" id="rate7" class="potential">
                  <label for="rate7">★</label>
                  <input type="radio" name="potential" value="3" id="rate8" class="potential">
                  <label for="rate8">★</label>
                  <input type="radio" name="potential" value="2" id="rate9">
                  <label for="rate9">★</label>
                  <input type="radio" name="potential" value="1" id="rate10">
                  <label for="rate10">★</label>
                </fieldset>
              </div>
              <p id="communication">소통력</p>
              <div class="myform2">
                <fieldset>
                  <input type="radio" name="communication" value="10" id="rate11">
                  <label for="rate11">★</label>
                  <input type="radio" name="communication" value="9" id="rate12">
                  <label for="rate12">★</label>
                  <input type="radio" name="communication" value="8" id="rate13">
                  <label for="rate13">★</label>
                  <input type="radio" name="communication" value="7" id="rate14">
                  <label for="rate14">★</label>
                  <input type="radio" name="communication" value="6" id="rate15">
                  <label for="rate15">★</label>
                  <input type="radio" name="communication" value="5" id="rate16">
                  <label for="rate16">★</label>
                  <input type="radio" name="communication" value="4" id="rate17">
                  <label for="rate17">★</label>
                  <input type="radio" name="communication" value="3" id="rate18">
                  <label for="rate18">★</label>
                  <input type="radio" name="communication" value="2" id="rate19">
                  <label for="rate19">★</label>
                  <input type="radio" name="communication" value="1" id="rate20">
                  <label for="rate20">★</label>
                </fieldset>
              </div>
              <p id="problemSolve">문제해결력</p>
              <div class="myform3">
                <fieldset>
                  <input type="radio" name="problemSolve" value="10" id="rate21">
                  <label for="rate21">★</label>
                  <input type="radio" name="problemSolve" value="9" id="rate22">
                  <label for="rate22">★</label>
                  <input type="radio" name="problemSolve" value="8" id="rate23">
                  <label for="rate23">★</label>
                  <input type="radio" name="problemSolve" value="7" id="rate24">
                  <label for="rate24">★</label>
                  <input type="radio" name="problemSolve" value="6" id="rate25">
                  <label for="rate25">★</label>
                  <input type="radio" name="problemSolve" value="5" id="rate26">
                  <label for="rate26">★</label>
                  <input type="radio" name="problemSolve" value="4" id="rate27">
                  <label for="rate27">★</label>
                  <input type="radio" name="problemSolve" value="3" id="rate28">
                  <label for="rate28">★</label>
                  <input type="radio" name="problemSolve" value="2" id="rate29">
                  <label for="rate29">★</label>
                  <input type="radio" name="problemSolve" value="1" id="rate30">
                  <label for="rate30">★</label>
                </fieldset>
              </div>
              <p id="responsibility">책임감</p>
              <div class="myform4">
                <fieldset>
                  <input type="radio" name="responsibility" value="10" id="rate31">
                  <label for="rate31">★</label>
                  <input type="radio" name="responsibility" value="9" id="rate32">
                  <label for="rate32">★</label>
                  <input type="radio" name="responsibility" value="8" id="rate33">
                  <label for="rate33">★</label>
                  <input type="radio" name="responsibility" value="7" id="rate34">
                  <label for="rate34">★</label>
                  <input type="radio" name="responsibility" value="6" id="rate35">
                  <label for="rate35">★</label>
                  <input type="radio" name="responsibility" value="5" id="rate36">
                  <label for="rate36">★</label>
                  <input type="radio" name="responsibility" value="4" id="rate37">
                  <label for="rate37">★</label>
                  <input type="radio" name="responsibility" value="3" id="rate38">
                  <label for="rate38">★</label>
                  <input type="radio" name="responsibility" value="2" id="rate39">
                  <label for="rate39">★</label>
                  <input type="radio" name="responsibility" value="1" id="rate40">
                  <label for="rate40">★</label>
                </fieldset>
              </div>
              <div id="say">
                <p>칭찬할 점</p>
                <textarea name="compliment" id="compliment"></textarea>
                <p>아쉬운 점</p>
                <textarea name="disappointment" id="disappointment"></textarea>
                <p>하고싶은 말</p>
                <textarea name="suggestion" id="suggestion"></textarea>
              </div>
              <br>
              <button onclick="write01();" id="sub">등록</button>
            </div>
            <br>
          </div>

        </section>
        <%@ include file="/WEB-INF/views/mainUtil/footer.jsp" %>
      </div>
      <%@ include file="/WEB-INF/views/mainUtil/sidebar.jsp" %>
      <button id="sidebarBtn"><span>메뉴</span></button>
    </body>
</html>