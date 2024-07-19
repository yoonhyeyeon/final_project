function check(){
    const startDateElement = document.querySelector("input[name=startDate]");
    const startDateValue = startDateElement ? startDateElement.value : "";
    
    const endDateElement = document.querySelector("input[name=endDate]");
    const endDateValue = endDateElement ? endDateElement.value : "";
    
    const typeNoElement = document.querySelector("select[name=typeNo]");
    const typeNoValue = typeNoElement ? typeNoElement.value : "";
    
    const reasonElement = document.querySelector("textarea[name=reason]");
    const reasonValue = reasonElement ? reasonElement.value : "";
    
    const approverNoElement = document.querySelector("select[name=approverNo]");
    const approverNoValue = approverNoElement ? approverNoElement.value : "";

    if(startDateValue === ""
        || endDateValue === ""
        || typeNoValue === ""
        || reasonValue === ""
        || approverNoValue === ""){

        alert("휴가에 관련된 모든 정보를 입력하세요");
        return false;
    }

    if(startDateValue > endDateValue){
        alert("휴가 종료일이 시작일보다 이전일 수 없습니다");
        document.querySelector("input[name=startDate]").value = "";
        document.querySelector("input[name=endDate]").value = "";
        return false;
    }
    
    return true;
}
