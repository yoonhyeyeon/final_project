$.ajax({
    url: "http://127.0.0.1:8383/api/leave/listForWriter",
    method: "get",
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

        for(let i = 0; i < data.leaveVoListForWriter.length; ++i){
            const trTag = document.createElement("tr");

            const tdTag02 = addTag("td", data.leaveVoListForWriter[i].leaveName);
            const tdTag03 = addTag("td", data.leaveVoListForWriter[i].reason);
            const tdTag04 = addTag("td", data.leaveVoListForWriter[i].divName + " " + data.leaveVoListForWriter[i].empName + " " + data.leaveVoListForWriter[i].positionName);
            const tdTag05 = addTag("td", data.leaveApproverVoListForWriter[i].divName + " " + data.leaveApproverVoListForWriter[i].approverName + " " + data.leaveApproverVoListForWriter[i].positionName);

            const enrollDate = data.leaveVoListForWriter[i].enrollDate.substring(0, 10);
            const approveDate = data.leaveVoListForWriter[i].approveDate ? data.leaveVoListForWriter[i].approveDate.substring(0, 10) : "";

            const tdTag06 = addTag("td", enrollDate);
            const tdTag07 = addTag("td", approveDate);

            let tdTag01 = "";
            let tdTag08 = "";
            if(data.leaveVoListForWriter[i].state === "0"){
                tdTag01 = addTag("td", waitTableCnt);
                tdTag08 = addTag("td", "승인 대기");
                waitTableCnt++;
            } else if(data.leaveVoListForWriter[i].state === "1"){
                tdTag01 = addTag("td", approvalTableCnt);
                tdTag08 = addTag("td", "승인 완료");
                approvalTableCnt++;
            } else if(data.leaveVoListForWriter[i].state === "2"){
                tdTag01 = addTag("td", returnTableCnt);
                tdTag08 = addTag("td", "반려");
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

            if(data.leaveVoListForWriter[i].state === "0"){
                waitTable.appendChild(trTag);
            } else if(data.leaveVoListForWriter[i].state === "1"){
                approvalTable.appendChild(trTag);
            } else if(data.leaveVoListForWriter[i].state === "2"){
                returnTable.appendChild(trTag);
            }
        }
    },
    error: (error) => {
        console.log("통신 실패");
        console.log(error);
    }
});
