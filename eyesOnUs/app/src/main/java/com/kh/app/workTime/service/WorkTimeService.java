package com.kh.app.workTime.service;

import com.kh.app.home.vo.CommuteVo;
import com.kh.app.workTime.dao.WorkTimeDao;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkTimeService {

    private final WorkTimeDao dao;

    public CommuteVo workTimeByNo(String empNo) {
        return dao.workTimeByNo(empNo);
    }

}
