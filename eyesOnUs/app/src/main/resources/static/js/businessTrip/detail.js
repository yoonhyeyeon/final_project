$.ajax({
    url: "http://127.0.0.1:8383/api/businessTrip/detail",
    method: "get",
    data: {
        businessTripNo: businessTripVo.no
    },
    success: (data) => {
        console.log("통신 성공");

        const waitTable = document.querySelector("#wait > tbody");

        waitTable.innerHTML = "";

        let waitTableCnt = 1;

        for(let i = 0; i < data.businessTripDetailVo.length; ++i){
            const trTag = document.createElement("tr");

            let tdTag01 = waitTableCnt;
            const tdTag02 = addTag("td", data.businessTripDetailVo[i].reason);
            const tdTag03 = addTag("td", data.businessTripDetailVo[i].divName + " " + data.businessTripDetailVo[i].empName + " " + data.businessTripDetailVo[i].positionName);
            const tdTag04 = addTag("td", data.businessTripApproverDetailVo[i].divName + " " + data.businessTripApproverDetailVo[i].approverName + " " + data.businessTripApproverDetailVo[i].positionName);

            const enrollDate = data.businessTripApproverDetailVo[i].enrollDate.substring(0, 10);
            const approveDate = data.businessTripApproverDetailVo[i].approveDate ? data.businessTripApproverDetailVo[i].approveDate.substring(0, 10) : "";

            const tdTag05 = addTag("td", enrollDate);
            const tdTag06 = addTag("td", approveDate);
            const tdTag07 = addTag("td", data.businessTripDetailVo[i].state);

            waitTableCnt++;

            trTag.appendChild(tdTag01);
            trTag.appendChild(tdTag02);
            trTag.appendChild(tdTag03);
            trTag.appendChild(tdTag04);
            trTag.appendChild(tdTag05);
            trTag.appendChild(tdTag06);
            trTag.appendChild(tdTag07);

            waitTable.appendChild(trTag);
        }
    },
    error: (error) => {
        console.log("통신 실패");
        console.log(error);
    }
});
