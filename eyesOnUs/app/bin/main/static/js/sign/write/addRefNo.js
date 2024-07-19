// 참조자 select 태그 추가
function addRefNo(){
    const formDivLastChild = document.querySelector("#form div:last-child");
    const newSelectTag = document.createElement("select");
    newSelectTag.name = "refNo[]";
    const formDivChildren = formDivLastChild.children;

    // selected 옵션 태그 만들기
    const newOptionTagSelected = document.createElement("option");
    newOptionTagSelected.selected;
    newOptionTagSelected.innerText = "참조자를 선택하세요";

    newSelectTag.appendChild(newOptionTagSelected);
    formDivLastChild.insertBefore(newSelectTag, formDivChildren[formDivChildren.length - 1]);

    $.ajax({
        url: "/api/sign/employeeList",
        method: "get",
        success: (data) => {
            console.log("추가 참조자 리스트 통신 성공");

            for(let i = 0; i < data.employeeVoList.length; ++i){
                const optionTagNewRefNo = addTag("option", data.employeeVoList[i].divName + " " + data.employeeVoList[i].name + " " + data.employeeVoList[i].positionName);
                optionTagNewRefNo.value = data.employeeVoList[i].no;
                newSelectTag.appendChild(optionTagNewRefNo);
            }
        },
        error: (error) => {
            console.log("추가 참조자 리스트 통신 실패");
            console.log(error);
        }
    });
}
