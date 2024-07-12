function getProjectList(){
    $.ajax({
        url: "/api/businessTrip/projectList",
        method: "get",
        success: (data) => {
            console.log("프로젝트 리스트 통신 성공");

            const selectTagProNo = document.querySelector("select[name=proNo]");

            for(let i = 0; i < data.projectVoList.length; ++i){
                const optionTagProNo = addTag("option", data.projectVoList[i].title);
                optionTagProNo.value = data.projectVoList[i].no;
                selectTagProNo.appendChild(optionTagProNo);
            }

            getEmployeeList();
        },
        error: (error) => {
            console.log("통신 실패");
            console.log(error);
        }
    });
}
