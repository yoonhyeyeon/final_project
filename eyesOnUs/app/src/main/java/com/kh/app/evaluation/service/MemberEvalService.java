package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.MemberEvalDao;
import com.kh.app.evaluation.vo.MemberEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberEvalService {

    private final MemberEvalDao dao;

    // 작성하기
    public int write(MemberEvalVo vo) {
        return dao.write(vo);
    }

    public List<EmployeeVo> writeList(EmployeeVo vo) {
        return dao.writeList(vo);
    }

    // 목록조회
    public List<MemberEvalVo> list() {
        return dao.list();
    }

}
