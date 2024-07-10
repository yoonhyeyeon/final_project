window.addEventListener("load", onPageLoad);

function onPageLoad(){
    $.ajax({
        url: "/api/leave/listForApprover",
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
    
            for(let i = 0; i < data.leaveVoListForApprover.length; ++i){
                const trTag = document.createElement("tr");
    
                trTag.addEventListener("click", () => {
                    location.href = `/leave/detail?no=${data.leaveVoListForApprover[i].no}&state=${data.leaveVoListForApprover[i].state}`;
                });
                trTag.style.cursor = "pointer";
    
                const tdTag02 = addTag("td", data.leaveVoListForApprover[i].leaveName);
                const tdTag03 = addTag("td", data.leaveVoListForApprover[i].reason);
                const tdTag04 = addTag("td", data.leaveVoListForApprover[i].divName + " " + data.leaveVoListForApprover[i].empName + " " + data.leaveVoListForApprover[i].positionName);
                const tdTag05 = addTag("td", data.leaveApproverVoListForApprover[i].divName + " " + data.leaveApproverVoListForApprover[i].approverName + " " + data.leaveApproverVoListForApprover[i].positionName);
    
                const enrollDate = data.leaveVoListForApprover[i].enrollDate.substring(0, 10);
                const approveDate = data.leaveVoListForApprover[i].approveDate ? data.leaveVoListForApprover[i].approveDate.substring(0, 10) : "";
    
                const tdTag06 = addTag("td", enrollDate);
                const tdTag07 = addTag("td", approveDate);
    
                let tdTag01 = "";
                let tdTag08 = "";
                if(data.leaveVoListForApprover[i].state === "0"){
                    tdTag01 = addTag("td", waitTableCnt);
                    tdTag08 = addTag("td", "승인 대기");
                    waitTableCnt++;
                } else if(data.leaveVoListForApprover[i].state === "1"){
                    tdTag01 = addTag("td", approvalTableCnt);
                    tdTag08 = addTag("td", "승인 완료");
                    approvalTableCnt++;
                } else if(data.leaveVoListForApprover[i].state === "2"){
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
    
                if(data.leaveVoListForApprover[i].state === "0"){
                    waitTable.appendChild(trTag);
                } else if(data.leaveVoListForApprover[i].state === "1"){
                    approvalTable.appendChild(trTag);
                } else if(data.leaveVoListForApprover[i].state === "2"){
                    returnTable.appendChild(trTag);
                }
            }
        },
        error: (error) => {
            console.log("통신 실패");
            console.log(error);
        }
    });
}
