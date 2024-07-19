function getParam(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}

$(document).ready( ()=> {
    const no = getParam("no");
    if(no){

        const rankVal = document.querySelector("#ingProjectData").value;
        const noVal = document.querySelector("#noVal").value;

    $.ajax({
        url : "/project/manager/listData",
        method : "GET",
        data : {no : no},
        success : function(x){
            if(noVal == x[0].pmNo){
                let str = "";
                const tbody = document.querySelector("tbody");
                for (let i = 0; i < x.length; i++) {
                    str += "<tr>";
                    str += "<td>" + x[i].proNo + "</td>";
                    str += "<td>" + x[i].name + "</td>";
                    str += "<td>" + x[i].empNo + "</td>";
                    str += `<td><button onclick=del(${x[i].no})>담당자해임</btuuon></td>`;
                    str += "</tr>"            
            }
            tbody.innerHTML = str;
            }
        }
    });
        
    }

});