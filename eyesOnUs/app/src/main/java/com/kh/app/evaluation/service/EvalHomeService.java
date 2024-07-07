package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.EvallHomeDao;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EvalHomeService {

    private final EvallHomeDao dao;

    public List<EmployeeVo> list() {
        return dao.list();
    }
}

