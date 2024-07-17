package com.kh.app.workTime.service;

import com.kh.app.home.vo.HomeVo;
import com.kh.app.workTime.dao.WorkTimeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkTimeService {

    private final WorkTimeDao dao;

    public HomeVo workTimeByNo(String empNo) {
        return dao.workTimeByNo(empNo);
    }

}
