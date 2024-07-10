package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.LeaderEvalMapper;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeaderEvalDao {

    private final LeaderEvalMapper mapper;

    // 작성하기
    public int write(LeaderEvalVo vo) {
        return mapper.write(vo);
    }

    public List<EmployeeVo> writeList(EmployeeVo vo) {
        return mapper.writeList(vo);
    }

    // 목록조회
    public List<LeaderEvalVo> list(String no) {
        return mapper.list(no);
    }

    public List<EmployeeVo> listByNo(EmployeeVo vo) {
        return mapper.listByNo(vo);
    }
}
