function getLeaveTypeList(){
    $.ajax({
        url: "/api/leave/leaveTypeList",
        method: "get",
        success: (data) => {
            console.log("휴가 타입 리스트 통신 성공");

            console.log(data);

            const selectTagLeaveTypeNo = document.querySelector("select[name=typeNo]");

            for(let i = 0; i < data.leaveTypeVoList.length; ++i){
                const optionTagLeaveTypeNo = addTag("option", data.leaveTypeVoList[i].leaveName);
                optionTagLeaveTypeNo.value = data.leaveTypeVoList[i].leaveType;
                selectTagLeaveTypeNo.appendChild(optionTagLeaveTypeNo);
            }

            getEmployeeList();
        },
        error: (error) => {
            console.log("통신 실패");
            console.log(error);
        }
    });
}
