package com.kh.app04.board.dao;

import com.kh.app04.board.mapper.BoardMapper;
import com.kh.app04.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final BoardMapper mapper;

    @Transactional
    public int write(BoardVo vo) {
        return mapper.write(vo);
    }


    public List<BoardVo> getBoardList() {
        return  mapper.getBoardList();
    }

    public List<BoardVo> getBoardList(Map<String, String> paramMap) {
        return mapper.searchBoardList(paramMap);
    }
}
