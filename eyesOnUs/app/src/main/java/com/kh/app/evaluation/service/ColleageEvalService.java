package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.ColleageEvalDao;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ColleageEvalService {

    private final ColleageEvalDao dao;

    // 작성하기
    public int write(ColleageEvalVo vo) {
        return dao.write(vo);
    }

    // 목록조회
    public List<ColleageEvalVo> list() {
        return dao.list();
    }
}
