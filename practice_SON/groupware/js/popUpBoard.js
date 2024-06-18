// 버튼 클릭 이벤트 설정
document.getElementById('anniversaryBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('scheduleBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('todoBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('diaryBoardBtn').addEventListener('click', toggleBoard);
document.getElementById('accountBoardBtn').addEventListener('click', toggleBoard);

// div 토글 함수 정의
function toggleBoard() {
    // 모든 보드 숨기기
    hideAllBoards();

    // 클릭된 버튼에 해당하는 보드 보이기
    let boardId = this.id.replace("Btn", "");
    let board = document.getElementById(boardId);
    if (board) {
        board.style.display = 'block';
    } else {
        console.error('Board not found:', boardId);
    }
}

// 모든 보드 숨기는 함수 정의
function hideAllBoards() {
    let boards = document.querySelectorAll('.board');
    boards.forEach(board => {
        board.style.display = 'none';
    });
}