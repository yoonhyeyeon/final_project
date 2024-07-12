function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}
$(document).ready(() => {
    const no = getParam("no");
    if(no){
        $.ajax({
        url : 'http://127.0.0.1:8383/project/detailData',
        method : 'get',
        data : { no : no },
        success : (detailData)=> {
          console.log("상세 정보 통신 성공");
          console.log(detailData)


            const dept = document.querySelector(".deptCode");
            const pm = document.querySelector(".employee");
            const prjContent = document.querySelector("#projectContent");
            const state = document.querySelector(".state");
            const sbtn = document.querySelector("#sBtn");
            const dbtn = document.querySelector("#dBtn");
            const title = document.querySelector(".title");




            let str1 = "";
            let str2 = "";
            let str3 = "";
            let str4 = "";
            let str5 = "";
            let str6 = "";

            str5 += "주제 :" + detailData.title
            str1 += "부서 : " +  detailData.dept
            str2 += "담당자 : " +  detailData.pm
            str3 += detailData.content
            str4 += "상태 : " + detailData.state
            str6 += `<button id ="dBtn" onclick='del(${detailData.no});'>삭제하기</button>`;

            dept.innerHTML = str1;
            pm.innerHTML = str2;
            prjContent.innerHTML = str3;
            state.innerHTML = str4;
            title.innerHTML = str5;
            dbtn.innerHTML =  str6;


            let str="";
            str += "<button class='list-item' data-id='"+detailData.no +"'>" + "수정하기";
            sbtn.innerHTML = str;

            document.querySelectorAll(".list-item").forEach((sbtn)=>{
                sbtn.addEventListener("click", ()=>{
            const no = sbtn.getAttribute("data-id");
            window.location.href="http://127.0.0.1:8383/project/projectModify?no="+no;




            });
        });

        },
        error : function(x){
            console.log("에러")
        }
    });
    }

    
});