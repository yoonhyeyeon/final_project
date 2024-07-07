package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.EvalHomeMapper;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EvallHomeDao {

    private final EvalHomeMapper mapper;

    public List<EmployeeVo> list() {
        return mapper.list();
    }
}
