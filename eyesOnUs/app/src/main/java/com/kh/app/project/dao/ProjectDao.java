package com.kh.app.project.dao;


import com.kh.app.project.mapper.ProjectMapper;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
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

    public List<ProjectVo> projectList() {
        return mapper.projectList();
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

    public List<ProjectRecordVo> recordList() {
        return mapper.recordList();
    }

    public ProjectVo getProjectByNo(String no) {
        return mapper.getProjectByNo(no);
    }
}

