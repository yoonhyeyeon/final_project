package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.ColleageEvalMapper;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ColleageEvalDao {

    private final ColleageEvalMapper mapper;

    public int write(ColleageEvalVo vo) {
        return mapper.write(vo);
    }
}
