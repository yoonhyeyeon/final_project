function getParam(x){
    const url = new URLSearchParams(window.location.search);
    return url.get(x);
}

$(document).ready( ()=>{
    const no = getParam("no");
    if(no){
        $.ajax({
            url : "http://127.0.0.1:8383/project/record/detailData",
            method : "GET",
            data : { no : no},
            success : function(data){
                console.log("상세정보 통신 성공");
                console.log(data);

                const prjNo = document.querySelector(".prjNo");
                const rTitle = document.querySelector(".title");
                const rName = document.querySelector(".name");
                const rEnlDate = document.querySelector(".enlDate");
                const rContent = document.querySelector("#recordContent");

                let str1 = "";
                let str2 = "";
                let str3 = "";
                let str4 = "";
                let str5 = "";

                str1 += "프로젝트 번호 : " + data.prjNo;
                str2 += "담당자 : " + data.name;
                str3 += "제목 : " + data.title;
                str4 += "등록일 : " + data.enlDate;
                str5 += "내용 : " + data.content;

                prjNo.innerHTML = str1;
                rTitle.innerHTML = str2;
                rName.innerHTML = str3;
                rEnlDate.innerHTML = str4;
                rContent.innerHTML = str5;
            }
        })
    }
});