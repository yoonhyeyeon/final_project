$.ajax({
    url: "/api/sign/employee",
    method: "get",
    data: {
        empNo: 43
    },
    success: (data) => {
        console.log("통신 성공");
        console.log(data);
    },
    error: (error) => {
        console.log("통신 실패");
        console.log(error);
    }
});
