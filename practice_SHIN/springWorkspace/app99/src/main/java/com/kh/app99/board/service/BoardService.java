package com.kh.app99.board.service;

import com.kh.app99.board.dao.BoardDao;
import com.kh.app99.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardDao dao;

    public int write(BoardVo vo) {
        return dao.write(vo);
    }

    public BoardVo getBoardByNo(String num) {
        return dao.getBoardByNo(num);
    }

    public int deleteBoardByNo(String num) {
        return dao.deleteBoardByNo(num);
    }
}//class
