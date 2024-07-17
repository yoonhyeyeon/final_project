document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        events: function(fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: 'http://127.0.0.1:8383/test/teamCalendarData',
                type: 'GET',
                dataType: 'json', // Specify the data type as JSON
                success: function(response) {
                    if (response && response.voList) {
                        var events = response.voList.map(function(item) {
                            return {
                                title: item.title,
                                start: new Date(item.startDate),
                                end: item.endDate ? new Date(item.endDate) : null
                            };
                        });
                        successCallback(events);
                    } else {
                        console.error('서버에서 예상한 형식의 데이터를 반환하지 않았습니다.');
                        failureCallback('Invalid data format');
                    }
                },
                error: function(error) {
                    console.error('이벤트를 불러오는 중 오류가 발생했습니다.', error);
                    failureCallback(error);
                }
            });
        }
    });
    calendar.render();
});