$(document).ready(function() {
  $('#loginButton').click(function(event){
    event.preventDefault();
    
    let formData = {
      id: $('input[name="id"]').val(),
      pwd: $('input[name="pwd"]').val(),
    };

    $.ajax({
      type: 'POST',
      url: '/adminHr/adminHrLoginData',
      data: formData,
      success: function(response) {
          window.location.href = '/adminEmpMngr/list';
      },
      error: function(error) {
          console.log('Error:', error);
          alert('로그인 실패');
      }
    });
  });
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