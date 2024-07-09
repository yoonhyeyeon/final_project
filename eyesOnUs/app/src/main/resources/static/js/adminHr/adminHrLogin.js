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