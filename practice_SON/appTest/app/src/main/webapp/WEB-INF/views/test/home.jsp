<!DOCTYPE html>
<html lang="en">
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/adminPage.css">
    <link rel="stylesheet" href="../css/teamRoom.css">
    <link rel="stylesheet" href="../css/sidebar.css">
    <link rel="stylesheet" href="../css/footer.css">
    <script defer src="../js/adminUtil.js"></script>
    <script defer src="../js/sidebar.js"></script>
    <script defer src="../js/calender.js"></script>
    <title>SHIN</title>
</head>

<body id="container">
  <div id="warp">
    <header id="headerContainer"></header>
    <nav id="navContainer"></nav>
    <!-- <section id="main">
      <div class="teamRoomMainDiv">
        <h1>바로가기</h1>
      </div>
      <div class="teamRoomMainDiv">
        <h1>공지사항1</h1>
      </div>
      <div class="teamRoomMainDiv">
        <h1>캘린더</h1>
        <hr>
        <h1>오늘일정</h1>
      </div>
      <div class="teamRoomMainDiv">
        <h1>공지사항2</h1>
      </div>
    </section> -->
    <footer id="footerContainer"></footer>
  </div>
    <aside class="sidebar" id="sidebar"></aside>
    <button id="sidebarBtn"><span>메뉴</span></button>
</body>

<script>
  document.addEventListener('DOMContentLoaded', () => {
      fetch('http://localhost:3000/events')
          .then(response => response.json())
          .then(events => {
              const eventsList = document.getElementById('events');
              events.forEach(event => {
                  const listItem = document.createElement('li');
                  const start = event.start.dateTime || event.start.date;
                  listItem.textContent = `${start} - ${event.summary}`;
                  eventsList.appendChild(listItem);
              });
          })
          .catch(error => console.error('Error fetching events:', error));
  });
  </script>
      <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js'></script>
      <script src='https://cdn.jsdelivr.net/npm/@fullcalendar/google-calendar@6.1.14/index.global.min.js'></script>
      <script>

        document.addEventListener('DOMContentLoaded', function() {
          var calendarEl = document.getElementById('calendar');
          var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            googleCalendarApiKey: 'AIzaSyCmTxfgPwI7KvOefc_F_54VM07Aomyimgw',
            events: {
              googleCalendarId: 'adsa7777@gmail.com'
            }
          });
          calendar.render();
        });

      </script>


</html>