window.addEventListener("load", onPageLoad);

function onPageLoad(){
    const businessTripNo = "${no}";
    console.log(businessTripNo);

    $.ajax({
        url: "/api/businessTrip/detail",
        method: "get",
        data: {
            no: businessTripNo
        },
        success: (data) => {
            console.log("통신 성공");
            const waitTable = document.querySelector("#wait > tbody");
            waitTable.innerHTML = "";
            const trTag = document.createElement("tr");
            let waitTableCnt = 1;

            const tdTag01 = addTag("td", waitTableCnt);
            const tdTag02 = addTag("td", data.businessTripDetailVo.reason);
            const tdTag03 = addTag("td", data.businessTripDetailVo.divName + " " + data.businessTripDetailVo.empName + " " + data.businessTripDetailVo.positionName);
            const tdTag04 = addTag("td", data.businessTripApproverDetailVo.divName + " " + data.businessTripApproverDetailVo.approverName + " " + data.businessTripApproverDetailVo.positionName);

            const enrollDate = data.businessTripDetailVo.enrollDate.substring(0, 10);
            const approveDate = data.businessTripDetailVo.approveDate ? data.businessTripDetailVo.approveDate.substring(0, 10) : "";

            const tdTag05 = addTag("td", enrollDate);
            const tdTag06 = addTag("td", approveDate);

            let tdTag07 = ""
            if(data.businessTripDetailVo.state === "0"){
                tdTag07 = addTag("td", "승인 대기");
            } else if(data.businessTripDetailVo.state === "1"){
                tdTag07 = addTag("td", "승인 완료");
            } else if(data.businessTripDetailVo.state === "2"){
                tdTag07 = addTag("td", "반려");
            }
    
            trTag.appendChild(tdTag01);
            trTag.appendChild(tdTag02);
            trTag.appendChild(tdTag03);
            trTag.appendChild(tdTag04);
            trTag.appendChild(tdTag05);
            trTag.appendChild(tdTag06);
            trTag.appendChild(tdTag07);

            waitTable.appendChild(trTag);
        },
        error: (error) => {
            console.log("통신 실패");
            console.log(error);
        }
    });
}
