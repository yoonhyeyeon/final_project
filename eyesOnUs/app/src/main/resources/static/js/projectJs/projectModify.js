function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}

    $(document).ready(() => {
        const no = getParam("no");
        if(no){
            $.ajax({
            url : 'http://127.0.0.1:8383/project/detailData',
            type : 'get',
            data : { no : no },
            success : (detailData)=> {
                console.log("상세 정보 통신 성공");
                console.log(detailData)
    
                const dept = document.querySelector(".dept");
                const pm = document.querySelector(".employee");
                const prjContent = document.querySelector("#projectContent");
                const title = document.querySelector(".title");
                const pModif = document.querySelector("#pModify");
    
                let str1 = "";
                let str2 = "";
                let str3 = "";
                let str5 = "";
                let str6 = "";
                str1 += "부서코드 : " + detailData.dept
                str2 += "담당자 : " +  detailData.pm
                str3 += detailData.content
                str5 += "주제 : " + detailData.title
                str6 += "수정일 : " + detailData.modifyDate
    
                dept.innerHTML = str1;
                pm.innerHTML = str2;
                prjContent.innerHTML = str3;
                title.innerHTML = str5;
                pModif.innerHTML = str6;
    
    
            },
            error : function(x){
                console.log("에러")
            }
        });
        }
    });
    
    
    function f01(){
        const contentVal = document.querySelector("#projectContent").value;
        const stateVal = document.querySelector("#stateANo").value;
        $(document).ready(() => {
            const no = getParam("no");
            if(no){
                $.ajax({
                    url : 'http://127.0.0.1:8383/project/projectModify',
                    type : 'post',
                    data : {
                        no : no,
                        content : contentVal,
                        stateANo : stateVal
                    },
                    success : function(data){
                            alert("수정 완료!");
                            location.href='http://127.0.0.1:8383/project/projectList';
    
                    },
                    error : function(data){
                        console.log("에러");
                    }
                });
            }
        })
    }

