package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.EvalHomeMapper;
import com.kh.app.evaluation.vo.EvalHomeVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EvallHomeDao {

    private final EvalHomeMapper mapper;

    // 모든사원
    public List<EvalHomeVo> list() {
        return mapper.list();
    }

    // 팀장
    public List<EvalHomeVo> leader() {
        return mapper.leader();
    }

    // 팀원
    public List<EvalHomeVo> memberEval() {
        return mapper.memberEval();
    }

    // 동료
    public List<EvalHomeVo> colleage() {
        return mapper.colleage();
    }
}
