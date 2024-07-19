function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}


    $(document).ready( ()=> {
        const no = getParam("no");
        if(no){

            $.ajax({
                url : "/project/record/listData",
                method : "get",
                data : {prjNo : no},
                success : function(x){
                    console.log(x);
                    const tbody = document.querySelector("#recordList");
                    let str="";
                    for(let i=0;i<x.length;i++){
                        str += "<tr class='list-item' data-id='"+x[i].no + "'>";
                        str += "<td>"+ x[i].title + "</td>";
                        str += "<td>"+ x[i].enlDate + "</td>";
                        str += "<td>" + x[i].name + "</td>";
                        str += "</tr>";
                    }
                    tbody.innerHTML = str;
            
                    document.querySelectorAll(".list-item").forEach((tbody)=>{
                        tbody.addEventListener("click", ()=>{
                        const no = tbody.getAttribute("data-id");
                        window.location.href="/project/record/detail?no="+no;
                        });
                    });
                },
                error : function(x){
                    console.log("에러입니다.");
                },
            });


        }
    });
