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
}
