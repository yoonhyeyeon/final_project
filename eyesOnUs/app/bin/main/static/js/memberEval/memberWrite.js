function write01(){

  const evaluatorNoValue = document.querySelector("#evaluatorNo").value;
  const evaluateeNoValue = document.querySelector("#evaluateeNo").value;
  const complimentValue = document.querySelector("#compliment").value;
  const disappointmentValue = document.querySelector("#disappointment").value;
  const suggestionValue = document.querySelector("#suggestion").value;

  const potentialValue = document.querySelector("input[name=potential]:checked").value;
  const communicationValue = document.querySelector("input[name=communication]:checked").value;
  const problemSolveValue = document.querySelector("input[name=problemSolve]:checked").value;
  const responsibilityValue = document.querySelector("input[name=responsibility]:checked").value;

  $.ajax({
    url : "/memberEval/write",
    type : "post",
    data : {
      evaluatorNo : evaluatorNoValue,
      evaluateeNo : evaluateeNoValue,
      potential : potentialValue,
      communication : communicationValue,
      problemSolve : problemSolveValue,
      responsibility : responsibilityValue,
      compliment : complimentValue,
      disappointment : disappointmentValue,
      suggestion : suggestionValue,
    },
    success : (x)=>{
      console.log("작성 성공");
      alert("평가 완료");
      location.href="/memberEval/list";
    },
    fail : (x)=>{
      console.log("작성 실패");
    },
  });
}