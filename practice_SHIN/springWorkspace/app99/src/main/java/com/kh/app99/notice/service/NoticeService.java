package com.kh.app99.notice.service;

import com.kh.app99.notice.dao.NoticeDao;
import com.kh.app99.notice.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeDao dao;

    public List<NoticeVo> getNoticeList() {
        return dao.getNoticeList();
    }

    public NoticeVo getNoticeByNo(String num) {
        return dao.getNoticeByNo(num);
    }

    public int write(NoticeVo vo) {
        return dao.write(vo);
    }

    public int edit(NoticeVo vo) {
        return dao.edit(vo);
    }

    public int delete(String num) {
        return dao.delete(num);
    }
}
