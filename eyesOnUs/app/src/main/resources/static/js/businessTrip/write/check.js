function check(){
    const startDateElement = document.querySelector("input[name=startDate]");
    const startDateValue = startDateElement ? startDateElement.value : "";
    
    const endDateElement = document.querySelector("input[name=endDate]");
    const endDateValue = endDateElement ? endDateElement.value : "";
    
    const proNoElement = document.querySelector("select[name=proNo]");
    const proNoValue = proNoElement ? proNoElement.value : "";
    
    const destinationElement = document.querySelector("input[name=destination]");
    const destinationValue = destinationElement ? destinationElement.value : "";
    
    const reasonElement = document.querySelector("textarea[name=reason]");
    const reasonValue = reasonElement ? reasonElement.value : "";
    
    const approverNoElement = document.querySelector("select[name=approverNo]");
    const approverNoValue = approverNoElement ? approverNoElement.value : "";

    console.log(startDateValue);
    console.log(endDateValue);
    console.log(proNoValue);
    console.log(destinationValue);
    console.log(reasonValue);
    console.log(approverNoValue);

    if(startDateValue === ""
        || endDateValue === ""
        || proNoValue === ""
        || destinationValue === ""
        || reasonValue === ""
        || approverNoValue === ""){

        alert("출장에 관련된 모든 정보를 입력하세요");
        return false;
    }

    if(startDateValue > endDateValue){
        alert("출장 종료일이 시작일보다 이전일 수 없습니다");
        document.querySelector("input[name=startDate]").value = "";
        document.querySelector("input[name=endDate]").value = "";
        return false;
    }
    
    return true;
}
