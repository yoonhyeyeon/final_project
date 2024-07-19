<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <div id="personalPage-body">
    <div id="personalPage-body-left">
      <div id="calendar"></div>
    </div>
    <div id="personalPage-body-right">
      <div id="personalPage-body-left-currentTime">
        <%@ include file="/WEB-INF/views/teamRoom/clock.jsp" %>
          <%@ include file="/WEB-INF/views/homeUtil/weather.jsp" %>
      </div>
      <div class="map">
        <div id="mapBox">
          <%@ include file="/WEB-INF/views/homeUtil/location.jsp" %>
        </div>
      </div>
      <div>
        <h3><a href="/message/messageReceiveList" id="msgReceiveList">받은 메시지 함</a></h3>
        <%@ include file="/WEB-INF/views/message/messageReceiveListHomeVer.jsp" %>
      </div>

      <div id="notice">
        <%@ include file="/WEB-INF/views/board/notice/homeList.jsp" %>
      </div>

    </div>
  </div>