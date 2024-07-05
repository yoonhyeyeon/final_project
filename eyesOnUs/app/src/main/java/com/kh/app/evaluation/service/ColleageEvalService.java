package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.ColleageEvalDao;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ColleageEvalService {

    private final ColleageEvalDao dao;

    public int write(ColleageEvalVo vo) {
        return dao.write(vo);
    }
}
