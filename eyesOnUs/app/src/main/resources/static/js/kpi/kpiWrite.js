function write01() {
    const projectNoValue = document.querySelector("#projectNo").value;
    const goalValue = document.querySelector("#goal").value;
    const personalScheduleValue = document.querySelector("#personalSchedule").value;
    const focusValue = document.querySelector("#focus").value;

    $.ajax({
        url: "http://127.0.0.1:8383/kpi/write",
        type: "POST",
        data: {
            projectNo: projectNoValue,
            goal: goalValue,
            personalSchedule: personalScheduleValue,
            focus: focusValue,
        },
        success: (x) => {
            console.log("작성 성공");
            alert("등록 성공");
            location.href = "http://127.0.0.1:8383/kpi/list";
        },
        error: (x) => {
            console.log("통신 실패");
        },
    });
}
