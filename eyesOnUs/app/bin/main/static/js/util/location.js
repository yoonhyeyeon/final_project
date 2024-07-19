document.addEventListener("DOMContentLoaded", function() {
    // Geolocation API를 사용하여 현재 위치 정보를 가져옴
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeoError);
    } else {
        console.error("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
    }
});

// Geolocation 성공 시 호출되는 함수
function onGeoSuccess(position) {
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;

    // 현재 위치의 위도와 경도로 지도 표시
    showMap(latitude, longitude);
}

// Geolocation 실패 시 호출되는 함수
function onGeoError(error) {
    console.error("Geolocation 오류 " + error.code + ": " + error.message);

    // 기본값: 서울의 위도와 경도로 지도 표시
    var latitude = 37.5665;
    var longitude = 126.9780;
    showMap(latitude, longitude);
}

////////////////////////카카오 맵 API////////////////////////////////////
function showMap(latitude, longitude) {
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);

    ///////////////////////마커 표시////////////////////////////////////////////

      // 지도에 마커를 표시합니다
      var marker = new kakao.maps.Marker({
          map: map,
          position: new kakao.maps.LatLng(37.498996636, 127.03284824)
      });

      // 커스텀 오버레이에 표시할 컨텐츠 입니다
      // 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
      // 별도의 이벤트 메소드를 제공하지 않습니다
      var content = '<div class="wrap">' +
                  '    <div class="info">' +
                  '        <div class="title">' +
                  '            EyesOnUs 본사' +
                  '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
                  '        </div>' +
                  '        <div class="body">' +
                  '            <div class="img">' +
                  '                <img src="https://i.pinimg.com/736x/94/c3/a8/94c3a843641993991fa5ae688c0eb5d3.jpg" width="73" height="70">' +
                  '           </div>' +
                  '            <div class="desc">' +
                  '                <div class="ellipsis">서울특별시 강남구 강남구 테헤란로14길 6</div>' +
                  '                <div class="jibun ellipsis">(우) 06234 (지번) 서울특별시 강남구 역삼동 823-24</div>' +
                  '                <div><a href="http://127.0.0.1:8383/home" target="_blank" class="link">홈페이지</a></div>' +
                  '            </div>' +
                  '        </div>' +
                  '    </div>' +
                  '</div>';

      // 마커 위에 커스텀오버레이를 표시합니다
      // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
      var overlay = new kakao.maps.CustomOverlay({
          content: content,
          map: map,
          position: marker.getPosition()
      });

      // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
      kakao.maps.event.addListener(marker, 'click', function() {
          overlay.setMap(map);
      });

      // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
      function closeOverlay() {
          overlay.setMap(null);
      }


}//showmap



