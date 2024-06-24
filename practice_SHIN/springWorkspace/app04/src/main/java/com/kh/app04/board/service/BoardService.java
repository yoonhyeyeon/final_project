package com.kh.app04.board.service;

import com.kh.app04.board.dao.BoardDao;
import com.kh.app04.board.mapper.BoardMapper;
import com.kh.app04.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardDao dao;

    public int write(BoardVo vo) {
        return dao.write(vo);
    }

    public List<BoardVo> getBoardList() {
        return dao.getBoardList();
    }

    public List<BoardVo> searchBoardList(Map<String, String> paramMap) {
        return dao.getBoardList(paramMap);
    }
}
