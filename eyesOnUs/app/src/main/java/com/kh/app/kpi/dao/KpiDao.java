package com.kh.app.kpi.dao;

import com.kh.app.kpi.mapper.KpiMapper;
import com.kh.app.kpi.vo.KpiVo;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class KpiDao {

    private final KpiMapper mapper;

    // 게시글 작성
    public int kpiWrite(KpiVo vo) {
        return mapper.kpiWrite(vo);
    }
    public List<ProjectVo> writeList(ProjectVo vo) {
        return mapper.writeList(vo);
    }
    public List<ProjectManagerVo> writeList2(ProjectManagerVo vo2) {
        return mapper.writeList2(vo2);
    }

    // 게시글 목록
    public List<KpiVo> kpiList(String empNo) {
        return mapper.KpiList(empNo);
    }

    //게시글 상세조회
    public KpiVo kpiByNo(String no) {
        return mapper.kpiByNo(no);
    }

    // 게시글 수정
    public int kpiModify(KpiVo vo) {
        return mapper.kpiModify(vo);
    }

    // 게시글 삭제
    public int kpiDelete(String no) {
        return mapper.kpiDelete(no);
    }

}
