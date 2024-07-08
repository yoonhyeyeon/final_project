package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.EvallHomeDao;
import com.kh.app.evaluation.vo.EvalHomeVo;
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

    // 모든 사원
    public List<EvalHomeVo> list() {
        return dao.list();
    }

    // 팀장
    public List<EvalHomeVo> leader() {
        return dao.leader();
    }

    // 팀원
    public List<EvalHomeVo> memberEval() {
        return dao.memberEval();
    }

    // 동료
    public List<EvalHomeVo> colleage() {
        return dao.colleage();
    }
}

