package com.kh.app.test.service;

import com.kh.app.test.dao.TestDao;
import com.kh.app.test.vo.TestTeamCalendarVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestDao dao;

    public List<TestTeamCalendarVo> teamCalendarData() {
        return dao.teamCalendarData();
    }
}
