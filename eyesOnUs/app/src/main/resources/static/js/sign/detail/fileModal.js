// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

const modalDiv = document.querySelector("#modalDiv");

// 버튼 누르면 모달창 열기
function openModal() {
    modalDiv.style.display = "block";
}

// X 버튼 누르면 모달창 닫기
function closeModal() {
    modalDiv.style.display = "none";
}

// 다른 화면 누르면 모달창 닫기
window.onclick = function(event) {
    if (event.target === modalDiv) {
        modalDiv.style.display = "none";
    }
}
