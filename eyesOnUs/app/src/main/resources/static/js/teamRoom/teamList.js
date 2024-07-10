 $.ajax({
        url: "http://127.0.0.1:8383/api/teamRoom/teamList",
        method: "get",
        dataType: "json",
        success: function(data) {
            const voList = data;
            const tbody = $("#teamListBody"); //테이블의 tbody
            let rows = "";

            for (let i = 0; i < voList.length; ++i) {
                rows += "<tr>";
                rows += "<td>" + voList[i].name + "</td>";
                rows += "<td>" + voList[i].nick + "</td>";
                rows += "</tr>";
            }

            tbody.html(rows);
        },
        error: function(xhr, status, error) {
            console.error("Error fetching todo list:", error);
        }
    });