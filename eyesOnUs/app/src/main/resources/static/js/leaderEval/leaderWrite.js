function write01(){

    const evaluatorNoValue = document.querySelector("#evaluatorNo").value;
    const evaluateeNoValue = document.querySelector("#evaluateeNo").value;
    const communicationValue = document.querySelector("input[name=communication]:checked").value;
    const responsibilityValue = document.querySelector("input[name=responsibility]:checked").value;
    const judgementValue = document.querySelector("input[name=judgement]:checked").value;
    const professionalismValue = document.querySelector("input[name=professionalism]:checked").value;
    const complimentValue = document.querySelector("#compliment").value;
    const disappointmentValue = document.querySelector("#disappointment").value;
    const suggestionValue = document.querySelector("#suggestion").value;

    $.ajax({
        url : "http://127.0.0.1:8383/leaderEval/write",
        type : "post",
        data : {
            evaluatorNo : evaluatorNoValue,
            evaluateeNo : evaluateeNoValue,
            communication : communicationValue,
            responsibility : responsibilityValue,
            judgement : judgementValue,
            professionalism : professionalismValue,
            compliment : complimentValue,
            disappointment : disappointmentValue,
            suggestion : suggestionValue,
        },
        success : (data)=>{
            console.log(data);
            alert("작성 성공!");
            location.href="http://127.0.0.1:8383/leaderEval/list";
        },
        fail : (x)=>{
            console.log("통신 실패");
        },
    });
}