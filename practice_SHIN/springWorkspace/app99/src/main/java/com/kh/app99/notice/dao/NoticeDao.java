package com.kh.app99.notice.dao;

import com.kh.app99.notice.mapper.NoticeMapper;
import com.kh.app99.notice.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDao {

    private final NoticeMapper mapper;

    public List<NoticeVo> getNoticeList() {
        return mapper.getNoticeList();
    }

    public NoticeVo getNoticeByNo(String num) {
        return mapper.getNoticeByNo(num);
    }

    public int write(NoticeVo vo) {
        return mapper.write(vo);
    }

    public int edit(NoticeVo vo) {
        return mapper.edit(vo);
    }

    public int delete(String num) {
        return mapper.delete(num);
    }
}
