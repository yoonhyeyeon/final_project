     $(document).ready(function() {
              $.ajax({
                  url: "http://127.0.0.1:8383/api/teamRoom",
                  method: "get",
                  dataType: "json",
                  success: function(data) {

                      const voList = data;

                      const tbody = $("#personalTableBody");
                      let rows = "";

                      for (let i = 0; i < voList.length; ++i) {
                          rows += "<tr>";
                          rows += "<td>" + voList[i].no + "</td>";
                          rows += "<td>" + voList[i].title + "</td>";
                          rows += "<td>" + voList[i].content + "</td>";
                          rows += "</tr>";
                      }

                      tbody.html(rows);
                  },
                  error: function(xhr, status, error) {
                      console.error("Error fetching data:", error);
                  }
              });
          });