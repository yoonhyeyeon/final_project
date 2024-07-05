package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.ColleageMapper;
import com.kh.app.evaluation.vo.ColleageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ColleageDao {

    private final ColleageMapper mapper;

    public int write(ColleageVo vo) {
        return mapper.write(vo);
    }
}
