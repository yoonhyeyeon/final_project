package com.kh.app.project.service;


import com.kh.app.project.dao.ProjectDao;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDao dao;

    public int insertProject(ProjectVo vo) {
        return dao.insertProject(vo);
    }

    public List<ProjectVo> projectList(String deptCode) {
        return dao.projectList(deptCode);
    }

    public int modifyPrj(ProjectVo vo) {
        return dao.modifyPrj(vo);
    }

    public int deletePrj(String no) {
        return dao.deletePrj(no);
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


    public List<ProjectVo> projectSearchByName(String title) {
        return dao.projectSearchByName(title);
    }

    public int managerInsert(ProjectManagerVo vo) {
        return dao.managerInsert(vo);
    }

    public List<ProjectManagerVo> managerList() {
        return  dao.managerList();
    }

    public int managerDelete(String no) {
        return dao.managerDelete(no);
    }

    public ProjectRecordVo recordDetail(String no) {
        return dao.recordDetail(no);
    }

    public int recordDelete(String no) {
        return dao.recordDelete(no);
    }

    public List<ProjectVo> listData2(ProjectVo vo) {
        return dao.listData2(vo);
    }

    public List<EmployeeVo> deptListByNo(String deptCode) {
        return dao.deptListByNo(deptCode);
    }


    public List<ProjectVo> listData3(ProjectVo vo) {
        return dao.listData3(vo);
    }
}
