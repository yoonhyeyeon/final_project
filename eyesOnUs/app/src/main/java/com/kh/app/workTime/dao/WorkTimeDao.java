package com.kh.app.workTime.dao;

import com.kh.app.home.vo.HomeVo;
import com.kh.app.workTime.mapper.WorkTimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WorkTimeDao {

    private final WorkTimeMapper mapper;

    public HomeVo workTimeByNo(String empNo) {
        return mapper.workTimeByNo(empNo);
    }

}
