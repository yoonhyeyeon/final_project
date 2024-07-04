package com.kh.app.kpi.controller;

import com.kh.app.kpi.service.KpiService;
import com.kh.app.kpi.vo.KpiVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("kpi")
@RequiredArgsConstructor
public class KpiController {

    private final KpiService service;

    // KPI 작성
    @GetMapping("write")
    public String kpiWrite(){
        return "kpi/write";
    }

    @PostMapping("write")
    public HashMap<String, String> kpiWrite(KpiVo vo){

//        HttpSession session = req.getSession();

        int result = service.kpiWrite(vo);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

    // 게시글 목록
    @GetMapping("list")
    public String kpiList(){
        return "kpi/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<KpiVo> kpiListData(){
        List<KpiVo> voList = service.kpiList();
        return voList;
    }

//    @GetMapping("list")
//    public List<KpiVo> kpiList(KpiVo vo){
//        List<KpiVo> voList = service.kpiList( vo.getEmpNo() );
//        return voList;
//    }

    // 게시글 상세조회
    @GetMapping("detail")
    public String kpiByNo(){
        return "kpi/detail";
    }

    @GetMapping("detailData")
    @ResponseBody
    public KpiVo kpiByNoDate(KpiVo vo){
        return service.kpiByNo(vo.getNo());
    }

    // 게시글 수정
    @GetMapping("modify")
    public String kpiModify(){
        return "kpi/modify";
    }

    @PostMapping("modify")
    public HashMap<String, String> kpiModify(KpiVo vo){
        int result = service.kpiModify(vo);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "수정 성공");

        if( result != 1){
            map.put("msg", "수정 실패");
        }
        return map;
    }

    // 게시글 삭제
    @DeleteMapping("delete")
    public HashMap<String, String> kpiDelete(String no){
        int result = service.kpiDelete(no);

        HashMap<String , String > map = new HashMap<>();
        map.put("msg", "삭제 성공");
        if( result != 1){
            map.put("msg", "삭제 실패");
        }
        return map;
    }

//    @PostMapping("delete")
//    public String kpiDelete(KpiVo vo){
//        return service.kpiDelete(vo.getNo());
//    }


}
