package com.kh.app.project.service;


import com.kh.app.project.dao.ProjectDao;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDao dao;

    public int insertProject(ProjectVo vo) {
        return dao.insertProject(vo);
    }

    public List<ProjectVo> projectList() {
        return dao.projectList();
    }

    public int modifyPrj(ProjectVo vo) {
        return dao.modifyPrj(vo);
    }

    public int deletePrj(ProjectVo vo) {
        return dao.deletePrj(vo);
    }

    public int recordInsert(ProjectRecordVo vo) {
        return dao.recordInsert(vo);
    }

    public List<ProjectRecordVo> recordList() {
        return dao.recordList();
    }

    public ProjectVo getProjectByNo(String no) {
        return dao.getProjectByNo(no);
    }
}
