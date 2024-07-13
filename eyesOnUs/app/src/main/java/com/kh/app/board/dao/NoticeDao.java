package com.kh.app.board.dao;

import com.kh.app.board.mapper.NoticeMapepr;
import com.kh.app.board.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDao {

    private final NoticeMapepr mapper;

    // 목록
    public List<NoticeVo> listData() {
        return mapper.listData();
    }


}