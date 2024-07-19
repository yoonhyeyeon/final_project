function check(){
    const titleElement = document.querySelector("input[name=title]");
    const titleValue = titleElement ? titleElement.value : "";
    
    const contentElement = document.querySelector("input[name=content]");
    const contentValue = contentElement ? contentElement.value : "";
    
    const fileElement = document.querySelector("input[name=file]");
    const fileLength = fileElement ? fileElement.files.length : 0;

    const firstApproverElement = document.querySelector("#firstApproverSelect");
    const firstApproverValue = firstApproverElement ? firstApproverElement.value : "";

    const secondApproverElement = document.querySelector("#secondApproverSelect");
    const secondApproverValue = secondApproverElement ? secondApproverElement.value : "";

    const thirdApproverElement = document.querySelector("#thirdApproverSelect");
    const thirdApproverValue = thirdApproverElement ? thirdApproverElement.value : "";

    if(titleValue === ""
        || contentValue === ""
        || fileLength === 0
        || firstApproverValue === ""
        || secondApproverValue === ""
        || thirdApproverValue === ""){

        alert("기안에 관련된 모든 정보를 입력하세요");
        return false;
    }
    
    return true;
}
