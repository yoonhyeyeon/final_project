package com.kh.app.home.dao;

import com.kh.app.home.mapper.HomeMapper;
import com.kh.app.home.vo.HomeVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HomeDao {

    private final HomeMapper mapper;

    public List<EmployeeVo> list(EmployeeVo vo) {
        return mapper.list(vo);
    }

    // 출근시간
    public int write(HomeVo vo) {
        return mapper.write(vo);
    }

    // 퇴근시간
    public int quit(HomeVo vo) {
        return mapper.quit(vo);
    }

}
