package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.ColleageEvalMapper;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ColleageEvalDao {

    private final ColleageEvalMapper mapper;

    // 작성하기
    public int write(ColleageEvalVo vo) {
        return mapper.write(vo);
    }

    public List<EmployeeVo> writeList(EmployeeVo vo) {
        return mapper.writeList(vo);
    }

    // 목록조회
    public List<ColleageEvalVo> list() {
        return mapper.list();
    }

}
