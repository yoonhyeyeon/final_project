package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.LeaderEvalDao;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LeaderEvalService {

    private final LeaderEvalDao dao;

    // 작성하기
    public int write(LeaderEvalVo vo) {
        return dao.write(vo);
    }

}
