package com.kh.app.project.dao;


import com.kh.app.member.vo.MemberVo;
import com.kh.app.project.mapper.ProjectMapper;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectDao {

    private final ProjectMapper mapper;

    public int insertProject(ProjectVo vo) {
        return mapper.insertProject(vo);
    }

    public List<ProjectVo> projectList(String deptCode) {
        return mapper.projectList(deptCode);
    }

    public int modifyPrj(ProjectVo vo) {
        return mapper.modifyPrj(vo);
    }

    public int deletePrj(String no) {
        return mapper.deletePrj(no);
    }

    public int recordInsert(ProjectRecordVo vo) {
        return mapper.recordInsert(vo);
    }

    public List<ProjectRecordVo> recordList(String prjNo) {
        return mapper.recordList(prjNo);
    }

    public ProjectVo getProjectByNo(String no) {
        return mapper.getProjectByNo(no);
    }

    public List<ProjectVo> projectSearchByName(String title) {
        return mapper.projectSearchByName(title);
    }

    public int managerInsert(ProjectManagerVo vo) {
        return mapper.managerInsert(vo);
    }

    public List<ProjectManagerVo> managerList(String no) {
        return mapper.managerList(no);
    }

    public int managerDelete(String no) {
        return mapper.managerDelete(no);
    }

    public ProjectRecordVo recordDetail(String no) {
        return mapper.recordDetail(no);
    }

    public int recordDelete(String no) {
        return mapper.recordDelete(no);
    }

    public List<ProjectVo> listData2(ProjectVo vo) {
        return mapper.listData2(vo);
    }

    public List<EmployeeVo> deptListByNo(String deptCode) {
        return mapper.deptListByNo(deptCode);
    }


    public List<ProjectVo> listData3(ProjectVo vo) {
        return mapper.listData3(vo);
    }

    public List<ProjectVo> getsPmByNo(String no) {
        return mapper.getsPmByNo(no);
    }

    public List<MemberVo> empListBydeptCode(String deptCode) {
        return mapper.empListBydeptCode(deptCode);
    }
}

