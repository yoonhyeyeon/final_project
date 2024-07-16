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
      <%@ include file="/WEB-INF/views/mainUtil/weather.jsp" %>
    </div>
    <div>
      <%@ include file="/WEB-INF/views/mainUtil/location.jsp" %>
    </div>
    <div>
      <h1>피드3</h1>
    </div>
  </div>
</div>