package com.kh.app.attendance.dao;

import com.kh.app.attendance.mapper.AttendanceMapper;
import com.kh.app.home.vo.CommuteVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttendanceDao {

    private final AttendanceMapper mapper;

    public List<CommuteVo> list(String empNo) {
        return mapper.list(empNo);
    }

    public List<CommuteVo> listVo(CommuteVo vo) {
        return mapper.listVo(vo);
    }

    public CommuteVo noDate(String empNo) {
        return mapper.noDate(empNo);
    }
}
