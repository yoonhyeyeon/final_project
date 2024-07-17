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

    // 작성하기
    public int write(NoticeVo vo) {
        return mapper.write(vo);
    }

    // 목록
    public List<NoticeVo> listData() {
        return mapper.listData();
    }

    // 상세조회
    public NoticeVo noticeByNo(String no) {
        return mapper.noticeByNo(no);
    }

    // 수정하기
    public int modify(NoticeVo vo) {
        return mapper.modify(vo);
    }
}
