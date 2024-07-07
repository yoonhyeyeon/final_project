package com.kh.app.home.dao;

import com.kh.app.home.mapper.CommuteMapper;
import com.kh.app.home.vo.CommuteVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommuteDao {

    private final CommuteMapper mapper;

    // 출근시간
    public int write(CommuteVo vo) {
        return mapper.write(vo);
    }

    public int quit(CommuteVo vo) {
        return mapper.quit(vo);
    }
}
