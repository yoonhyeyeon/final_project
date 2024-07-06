package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.MemberEvalMapper;
import com.kh.app.evaluation.vo.MemberEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberEvalDao {

    private final MemberEvalMapper mapper;

    // 작성하기
    public int write(MemberEvalVo vo) {
        return mapper.write(vo);
    }

    public List<EmployeeVo> writeList(EmployeeVo vo) {
        return mapper.writeList(vo);
    }

    // 목록조회
    public List<MemberEvalVo> list() {
        return mapper.list();
    }

}
