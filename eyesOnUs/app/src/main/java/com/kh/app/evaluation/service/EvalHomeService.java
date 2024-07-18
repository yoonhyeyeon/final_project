package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.EvallHomeDao;
import com.kh.app.evaluation.vo.EvalHomeVo;
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
    public List<EvalHomeVo> list(String no) {
        return dao.list(no);
    }

    // 팀장
    public List<EvalHomeVo> leader(String no) {
        return dao.leader(no);
    }

    // 팀원
    public List<EvalHomeVo> memberEval(String no) {
        return dao.memberEval(no);
    }

    // 동료
    public List<EvalHomeVo> colleage(String no) {
        return dao.colleage(no);
    }

    // 남은사원 목록
    public List<EvalHomeVo> list2(String no) {
        return dao.list2(no);
    }
}

