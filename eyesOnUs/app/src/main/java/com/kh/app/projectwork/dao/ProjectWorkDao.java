package com.kh.app.projectwork.dao;


import com.kh.app.personal.vo.PersonalVo;
import com.kh.app.projectwork.mapper.ProjectWorkMapper;
import com.kh.app.projectwork.vo.ProjectWorkVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectWorkDao {

    private final ProjectWorkMapper mapper;

    public List<ProjectWorkVo> getPrjWorkList() {
        return mapper.getPrjWorkList();
    }

    public int getPrjWorkWrite(ProjectWorkVo vo) {
        return mapper.getPrjWorkWrite(vo);
    }


    public int prjWorkDelete(String num) {
        return mapper.prjWorkDelete(num);
    }
}//class
