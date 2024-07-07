$.ajax({
    url : "http://127.0.0.1:8383/project/manager/listData",
    method : "GET",
    data : {},
    success : function(x){
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
});