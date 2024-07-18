<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="personalPage-body">
  <div id="personalPage-body-left">
    <div id="personalPage-body-left-currentTime">
      <h3>시계</h3>
      <%@ include file="/WEB-INF/views/teamRoom/clock.jsp" %>
    </div>
    <div id="personalPage-body-left-currentTime">
      <h3>결제</h3>
      <ul>
        <li>결재문서1</li>
        <li>결재문서2</li>
        <li>결재문서3</li>
      </ul>
    </div>
    <div id="calendar"></div>
  </div>
  <div id="personalPage-body-right">
    <div>
      <%@ include file="/WEB-INF/views/homeUtil/weather.jsp" %>
    </div>


    <div class="map">
        <div id="mapBox">
       <%@ include file="/WEB-INF/views/homeUtil/location.jsp" %>
       </div>
    </div>


    <div id="notice">
      <%@ include file="/WEB-INF/views/board/notice/homeList.jsp" %>
    </div>

  </div>
</div>