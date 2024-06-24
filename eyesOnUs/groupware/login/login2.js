// Optional JavaScript
document.getElementById('loginButton').addEventListener('click', function() {
  alert('로그인 시도 중☁️');
});


// DOM 요소 참조
const text1 = document.getElementById('text1');
const text2 = document.getElementById('text2');

// 페이지 로드 후 애니메이션 시작
document.addEventListener('DOMContentLoaded', function() {
  setTimeout(() => {
    text1.style.animation = 'fadeIn 1s forwards'; // text1에 fadeIn 애니메이션 적용
  }, 0);
  setTimeout(() => {
    text2.style.animation = 'fadeIn 1s forwards'; // text2에 fadeIn 애니메이션 적용
  }, 1500); // text2가 text1보다 0.5초 늦게 나타나도록 설정
});
