package com.kh.app.test.dao;

import com.kh.app.test.mapper.TestMapper;
import com.kh.app.test.vo.TestTeamCalendarVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestDao {

    private final TestMapper mapper;

    public List<TestTeamCalendarVo> teamCalendarData() {
        return mapper.teamCalendarData();
    }
}
