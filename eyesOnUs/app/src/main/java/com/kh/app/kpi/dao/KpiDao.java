package com.kh.app.kpi.dao;

import com.kh.app.kpi.mapper.KpiMapper;
import com.kh.app.kpi.vo.KpiVo;
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

    // 게시글 목록
    public List<KpiVo> kpiList() {
        return mapper.KpiList();
    }


//    public List<KpiVo> kpiList(String empNo) {
//        return mapper.kpiList(empNo);
//    }

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
//    public String kpiDelete(String no) {
//        return mapper.kpiDelete(no);
//    }

}
