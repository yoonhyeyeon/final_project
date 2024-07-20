window.addEventListener("DOMContentLoaded", onPageLoad);

function onPageLoad(){
    $.ajax({
        url: "/api/sign/listForApprover",
        method: "get",
        success: (data) => {
            console.log("결재할 리스트 통신 성공");
    
            const doSignTable = document.querySelector("#doSign > tbody");
            const waitTable = document.querySelector("#wait > tbody");
            const approvalTable = document.querySelector("#approval > tbody");
            const returnTable = document.querySelector("#return > tbody");
            
            removeTag(doSignTable);
            removeTag(waitTable);
            removeTag(approvalTable);
            removeTag(returnTable);
    
            let doSignTableCnt = 0;
            let waitTableCnt = 0;
            let approvalTableCnt = 0;
            let returnTableCnt = 0;
 
            for(let i = 0; i < data.signVoListForApprover.length; ++i){
                const trTag = document.createElement("tr");
    
                trTag.addEventListener("click", (event) => {
                    event.stopPropagation();
                    location.href = `/sign/detail?no=${data.signVoListForApprover[i].no}&result=${data.signVoListForApprover[i].result}&step=${data.signVoListForApprover[i].step}`;
                });
                trTag.style.cursor = "pointer";
    
                const tdTag02 = addTag("td", data.signVoListForApprover[i].title);
                const tdTag03 = addTag("td", data.signVoListForApprover[i].empName);
                
                const enrollDate = data.signVoListForApprover[i].enrollDate.substring(0, 10);
                const latestApproveDate = data.signVoListForApprover[i].modifyDate ? data.signVoListForApprover[i].modifyDate.substring(0, 10) : "";

                const tdTag04 = addTag("td", enrollDate);
                const tdTag05 = addTag("td", latestApproveDate);

                let tdTag01 = "";
                let tdTag06 = "";
                if(data.signVoListForApprover[i].result === "1"){
                    approvalTableCnt++;
                    tdTag01 = addTag("td", approvalTableCnt);
                    tdTag06 = addTag("td", "결재 완료");
                } else if(data.signVoListForApprover[i].result === "2"){
                    returnTableCnt++;
                    tdTag01 = addTag("td", returnTableCnt);
                    tdTag06 = addTag("td", "반려");
                } else if(data.signVoListForApprover[i].result === "0"){
                    if(data.signVoListForApprover[i].step === data.signVoListForApprover[i].signSeq){
                        doSignTableCnt++;
                        tdTag01 = addTag("td", doSignTableCnt);
                    } else{
                        waitTableCnt++;
                        tdTag01 = addTag("td", waitTableCnt);
                    }

                    if(data.signVoListForApprover[i].step === "1"){
                        tdTag06 = addTag("td", "1차 결재 중");
                    } else if(data.signVoListForApprover[i].step === "2"){
                        tdTag06 = addTag("td", "2차 결재 중");
                    } else if(data.signVoListForApprover[i].step === "3"){
                        tdTag06 = addTag("td", "3차 결재 중");
                    }
                }

                trTag.appendChild(tdTag01);
                trTag.appendChild(tdTag02);
                trTag.appendChild(tdTag03);
                trTag.appendChild(tdTag04);
                trTag.appendChild(tdTag05);
                trTag.appendChild(tdTag06);
    
                if(data.signVoListForApprover[i].result === "0"){
                    if(data.signVoListForApprover[i].step === data.signVoListForApprover[i].signSeq){
                        doSignTable.appendChild(trTag);
                    } else{
                        waitTable.appendChild(trTag);
                    }
                } else if(data.signVoListForApprover[i].result === "1"){
                    approvalTable.appendChild(trTag);
                } else if(data.signVoListForApprover[i].result === "2"){
                    returnTable.appendChild(trTag);
                }

                const doSignMarkTag = document.querySelector("#doSignMark");
                const waitMarkTag = document.querySelector("#waitMark");
                const approvalMarkTag = document.querySelector("#approvalMark");
                const returnMarkTag = document.querySelector("#returnMark");

                doSignMarkTag.innerText = doSignTableCnt + " 건";
                waitMarkTag.innerText = waitTableCnt + " 건";
                approvalMarkTag.innerText = approvalTableCnt + " 건";
                returnMarkTag.innerText = returnTableCnt + " 건";
            }
        },
        error: (error) => {
            console.log("결재할 리스트 통신 실패");
            console.log(error);
        }
    });
}
