package com.kh.app.kpi.service;

import com.kh.app.kpi.dao.KpiDao;
import com.kh.app.kpi.vo.KpiVo;
import com.kh.app.project.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KpiService {

    private final KpiDao dao;

    // 게시글 작성
    public int kpiWrite(KpiVo vo) {
        return dao.kpiWrite(vo);
    }

    public List<ProjectVo> writeList(ProjectVo vo) {
        return dao.writeList(vo);
    }

    // 게시글 목록
    public List<KpiVo> kpiList(String empNo) {
        return dao.kpiList(empNo);
    }

    // 게시글 상세조회
    public KpiVo kpiByNo(String no) {
        return dao.kpiByNo(no);
    }

    // 게시글 수정
    public int kpiModify(KpiVo vo) {
        return dao.kpiModify(vo);
    }



    // 게시글 삭제
    public int kpiDelete(String no) {
        return dao.kpiDelete(no);
    }


//    public String kpiDelete(String no) {
//        return  dao.kpiDelete(no);
//    }

}
