$.ajax({
    url: "http://127.0.0.1:8383/api/businessTrip",
    method: "get",
    data: {
        empNo: 43
    },
    success: (data) => {
        console.log("통신 성공");

        const waitTable = document.querySelector("#wait > tbody");
        const approvalTable = document.querySelector("#approval > tbody");
        const returnTable = document.querySelector("#return > tbody");

        waitTable.innerHTML = "";
        approvalTable.innerHTML = "";
        returnTable.innerHTML = "";

        let waitTableCnt = 1;
        let approvalTableCnt = 1;
        let returnTableCnt = 1;

        for(let i = 0; i < data.businessTripVoListForAll.length; ++i){
            const trTag = document.createElement("tr");

            const tdTag02 = addTag("td", data.businessTripVoListForAll[i].proNo);
            const tdTag03 = addTag("td", data.businessTripVoListForAll[i].reason);
            const tdTag04 = addTag("td", data.businessTripVoListForAll[i].empName, " ",data.businessTripVoListForAll[i].positionName);
            const tdTag05 = addTag("td", data.businessTripApproverVoList[i].approverName, " ", data.businessTripApproverVoList[i].positionName);
            const tdTag06 = addTag("td", data.businessTripVoListForAll[i].divName);

            const enrollDate = data.businessTripVoListForAll[i].enrollDate.substring(0, 10);
            const startDate = data.businessTripVoListForAll[i].startDate.substring(0, 10);
            const endDate = data.businessTripVoListForAll[i].endDate.substring(0, 10);
            const approveDate = data.businessTripVoListForAll[i].approveDate ? data.businessTripVoListForAll[i].approveDate.substring(0, 10) : "";

            const tdTag07 = addTag("td", enrollDate);
            const tdTag08 = addTag("td", startDate);
            const tdTag09 = addTag("td", endDate);
            const tdTag10 = addTag("td", approveDate);

            let tdTag01 = "";
            let tdTag11 = "";
            if(data.businessTripVoListForAll[i].state === "0"){
                tdTag01 = addTag("td", waitTableCnt);
                tdTag11 = addTag("td", "승인 대기");
                waitTableCnt++;
            } else if(data.businessTripVoListForAll[i].state === "1"){
                tdTag01 = addTag("td", approvalTableCnt);
                tdTag11 = addTag("td", "승인 완료");
                approvalTableCnt++;
            } else if(data.businessTripVoListForAll[i].state === "2"){
                tdTag01 = addTag("td", returnTableCnt);
                tdTag11 = addTag("td", "반려");
                returnTableCnt++;
            }

            trTag.appendChild(tdTag01);
            trTag.appendChild(tdTag02);
            trTag.appendChild(tdTag03);
            trTag.appendChild(tdTag04);
            trTag.appendChild(tdTag05);
            trTag.appendChild(tdTag06);
            trTag.appendChild(tdTag07);
            trTag.appendChild(tdTag08);
            trTag.appendChild(tdTag09);
            trTag.appendChild(tdTag10);
            trTag.appendChild(tdTag11);

            if(data.businessTripVoListForAll[i].state === "0"){
                waitTable.appendChild(trTag);
            } else if(data.businessTripVoListForAll[i].state === "1"){
                approvalTable.appendChild(trTag);
            } else if(data.businessTripVoListForAll[i].state === "2"){
                returnTable.appendChild(trTag);
            }
        }
    },
    error: (error) => {
        console.log("통신 실패");
        console.log(error);
    }
});
