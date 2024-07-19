function getApproverList(){
    $.ajax({
        url: "/api/sign/employeeList",
        method: "get",
        success: (data) => {
            console.log("결재자 리스트 통신 성공");

            const firstApproverSelectTag = document.querySelector("#firstApproverSelect");
            const secondApproverSelectTag = document.querySelector("#secondApproverSelect");
            const thirdApproverSelectTag = document.querySelector("#thirdApproverSelect");
            const firstRefSelectTag = document.querySelector("#refSelect")

            for(let i = 0; i < data.employeeVoList.length; ++i){
                const optionTagApproverNo01 = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionTagApproverNo01.value = data.employeeVoList[i].no;
                const optionTagApproverNo02 = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionTagApproverNo02.value = data.employeeVoList[i].no;
                const optionTagApproverNo03 = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionTagApproverNo03.value = data.employeeVoList[i].no;
                const optionFirstRefNo = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionFirstRefNo.value = data.employeeVoList[i].no;

                firstApproverSelectTag.appendChild(optionTagApproverNo01);
                secondApproverSelectTag.appendChild(optionTagApproverNo02);
                thirdApproverSelectTag.appendChild(optionTagApproverNo03);
                firstRefSelectTag.appendChild(optionFirstRefNo);
            }
        },
        error: (error) => {
            console.log("결재자 리스트 통신 실패");
            console.log(error);
        }
    });
}
