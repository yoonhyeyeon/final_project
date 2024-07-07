package com.kh.app.projectwork.service;


import com.kh.app.personal.vo.PersonalVo;
import com.kh.app.projectwork.dao.ProjectWorkDao;
import com.kh.app.projectwork.vo.ProjectWorkVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectWorkService {

    private final ProjectWorkDao dao;

    public List<ProjectWorkVo> getPrjWorkList() {
        return dao.getPrjWorkList();
    }

    public int getPrjWorkWrite(ProjectWorkVo vo) {
        return dao.getPrjWorkWrite(vo);
    }


}//class
