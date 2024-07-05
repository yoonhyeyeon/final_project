package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.ColleageDao;
import com.kh.app.evaluation.vo.ColleageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ColleageService {

    private final ColleageDao dao;

    public int write(ColleageVo vo) {
        return dao.write(vo);
    }
}
