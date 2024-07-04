function write01() {
    const projectNoValue = document.querySelector("#projectNo").value;
    const goalValue = document.querySelector("#goal").value;
    const personalScheduleValue = document.querySelector("#personalSchedule").value;
    const focusValue = document.querySelector("#focus").value;

    $.ajax({
        url: "http://127.0.0.1:8080/kpi/write",
        type: "POST",
        data: {
            projectNo: projectNoValue,
            goal: goalValue,
            personalSchedule: personalScheduleValue,
            focus: focusValue,
        },
        success: (response) => {
            console.log("성공");
            console.log(response);
            location.href = "http://127.0.0.1:8080/kpi/list";
        },
        error: (error) => {
            console.log("통신 실패");
        },
    });
}
