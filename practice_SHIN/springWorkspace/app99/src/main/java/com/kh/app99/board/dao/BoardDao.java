package com.kh.app99.board.dao;

import com.kh.app99.board.mapper.BoardMapper;
import com.kh.app99.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final BoardMapper mapper;

    public int write(BoardVo vo) {
        System.out.println("vo = " + vo);
        return mapper.write(vo);
    }

    public BoardVo getBoardByNo(String num) {
        return mapper.getBoardByNo(num);
    }

    public int deleteBoardByNo(String num) {
        return mapper.deleteBoardByNo(num);
    }
}//class
