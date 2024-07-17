package com.kh.app.attendance.dao;

import com.kh.app.attendance.mapper.AttendanceMapper;
import com.kh.app.home.vo.HomeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttendanceDao {

    private final AttendanceMapper mapper;

    public List<HomeVo> list(String empNo, String month) {
        return mapper.list(empNo, month);
    }

}