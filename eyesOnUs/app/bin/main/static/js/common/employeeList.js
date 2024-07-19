function getEmployeeList(){
    $.ajax({
        url: "/api/sign/employeeList",
        method: "get",
        success: (data) => {
            console.log("승인자 리스트 통신 성공");

            const selectTagApproverNo = document.querySelector("select[name=approverNo]");

            for(let i = 0; i < data.employeeVoList.length; ++i){
                const optionTagApproverNo = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionTagApproverNo.value = data.employeeVoList[i].no;
                selectTagApproverNo.appendChild(optionTagApproverNo);
            }
        },
        error: (error) => {
            console.log("승인자 리스트 통신 실패");
            console.log(error);
        }
    });
}
