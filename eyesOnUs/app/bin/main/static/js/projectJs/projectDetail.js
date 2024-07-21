function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}
const svo = document.querySelector("#svo").value;
const vo = document.querySelector("#vo").value;

$(document).ready(()=>{
    const no = getParam("no");
    if(no){
        $.ajax({
            url : '/project/detailData2',
            method : 'get',
            data : {no : no},
            success : function(x){
                console.log(x);

                    const sPmVal = document.querySelector(".sPm");
    
                    let str7 = "";
    
                    str7 += "담당자 : ";
                    for(let i=0;i<x.length;i++){
                        str7 += x[i].pm + "    ";
                    }
                    sPmVal.innerHTML = str7;
            },
            error : function(y){
                console.log("에러");
            },
        });
    }

})


$(document).ready(() => {
    const no = getParam("no");
    if(no){
        $.ajax({
        url : '/project/detailData',
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
          const managerInsert = document.querySelector("#buttonDiv");
          const managerList = document.querySelector("#buttonDiv1");
          const recordInsert = document.querySelector("#buttonDiv2");
          const recordList = document.querySelector("#buttonDiv3");

          let str9 = "";
          str9 += "<button id='recordListGoBtn' data-id='"+detailData.no+"'>"+"회의록 목록";
          recordList.innerHTML = str9;
      
          document.querySelectorAll("#recordListGoBtn").forEach( (recordList) =>{
              recordList.addEventListener("click", ()=> {
                  const no = recordList.getAttribute("data-id");
                  location.href="/project/record/list?no=" + no;
              });
          });
          
          if(vo == svo){


            let str1 = "";
            let str2 = "";
            let str3 = "";
            let str4 = "";
            let str5 = "";
            let str6 = "";

            str5 += "주제 :" + detailData.title
            str1 += "부서 : " +  detailData.dept
            str2 += "PM : " +  detailData.pm

            str3 += detailData.content
            str4 += "상태 : " + detailData.state
            str6 += `<button id ="delBtn" onclick='del(${detailData.no});'>삭제하기</button>`;

            dept.innerHTML = str1;
            pm.innerHTML = str2;
            prjContent.innerHTML = str3;
            state.innerHTML = str4;
            title.innerHTML = str5;
            dbtn.innerHTML =  str6;


            let str="";
            str += "<button class='list-item' data-id='"+detailData.no +"'>" + "수정하기";
            sbtn.innerHTML = str;


            let str7 = "";
            str7 += "<button id='prjListGoBtn' data-id='"+detailData.no+"'>"+ "담당자 등록하기";
            managerInsert.innerHTML = str7;
            
            let str8 = "";
            str8 += "<button id='recordInsertGoBtn' data-id='"+detailData.no+"'>"+ "회의록 등록하기";
            recordInsert.innerHTML = str8;
            
            let str10 = "";
            str10 += "<button id='managerListGoBtn' data-id='"+detailData.no+"'>"+ "담당자 관리";
            managerList.innerHTML = str10;
            
            document.querySelectorAll("#managerListGoBtn").forEach( (managerList) =>{
                managerList.addEventListener("click", ()=> {
                    const no = managerList.getAttribute("data-id");
                    location.href="/project/manager/list?no=" + no;
                });
            });


            document.querySelectorAll("#recordInsertGoBtn").forEach( (recordInsert) =>{
                recordInsert.addEventListener("click", ()=> {
                    const no = recordInsert.getAttribute("data-id");
                    location.href="/project/record/insert?no=" + no;
                });
            });



            document.querySelectorAll("#prjListGoBtn").forEach((managerInsert) => {
                managerInsert.addEventListener("click", ()=>{
                    const no = managerInsert.getAttribute("data-id");
                    window.location.href= "/project/manager/insert?no="+no;
                });
            });
            
            document.querySelectorAll(".list-item").forEach((sbtn)=>{
                sbtn.addEventListener("click", ()=>{
            const no = sbtn.getAttribute("data-id");
            window.location.href="/project/projectModify?no="+no;
            });
        });
    }
    
            
            
            else{
                const dept = document.querySelector(".deptCode");
                const pm = document.querySelector(".employee");
                const prjContent = document.querySelector("#projectContent");
                const state = document.querySelector(".state");
                const title = document.querySelector(".title");
    
    
    
    
                let str1 = "";
                let str2 = "";
                let str3 = "";
                let str4 = "";
                let str5 = "";
    
                str5 += "주제 :" + detailData.title
                str1 += "부서 : " +  detailData.dept
                str2 += "PM : " +  detailData.pm
                str3 += detailData.content
                str4 += "상태 : " + detailData.state   
                dept.innerHTML = str1;
                pm.innerHTML = str2;
                prjContent.innerHTML = str3;
                state.innerHTML = str4;
                title.innerHTML = str5;
    
    
            }

        },
        error : function(x){
            console.log("에러")
        }
    });
    }

    
});