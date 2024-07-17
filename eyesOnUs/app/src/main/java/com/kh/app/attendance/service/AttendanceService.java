package com.kh.app.attendance.service;

import com.kh.app.attendance.dao.AttendanceDao;
import com.kh.app.home.vo.HomeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceDao dao;

    public List<HomeVo> list(String empNo, String month) {
        return dao.list(empNo, month);
    }

}