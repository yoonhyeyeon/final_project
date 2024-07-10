package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.EvalHomeMapper;
import com.kh.app.evaluation.vo.EvalHomeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EvallHomeDao {

    private final EvalHomeMapper mapper;

    // 모든사원
    public List<EvalHomeVo> list(String no) {
        return mapper.list(no);
    }

    // 팀장
    public List<EvalHomeVo> leader(String no) {
        return mapper.leader(no);
    }

    // 팀원
    public List<EvalHomeVo> memberEval(String no) {
        return mapper.memberEval(no);
    }

    // 동료
    public List<EvalHomeVo> colleage(String no) {
        return mapper.colleage(no);
    }
}
