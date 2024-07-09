package com.kh.app.kpi.controller;

import com.kh.app.kpi.service.KpiService;
import com.kh.app.kpi.vo.KpiVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.project.vo.ProjectVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String kpiWrite(ProjectVo vo, Model model){
        List<ProjectVo> voList = service.writeList(vo);
        model.addAttribute("voList", voList);

        return "kpi/write";
    }

    @PostMapping("write")
    public HashMap<String, String> kpiWrite(KpiVo vo, HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        HashMap<String , String > map = new HashMap<>();
        if( loginMemberVo == null ){
            map.put("msg", "로그인 필요");
            return map;
        }

        int result = service.kpiWrite(vo);

        map.put("msg", "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

    // 게시글 목록
    @GetMapping("list")
    public String kpiList(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        return "kpi/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<KpiVo> kpiListData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();

        List<KpiVo> voList = service.kpiList(empNo);
        return voList;
    }

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
    @ResponseBody
    public HashMap<String, String> kpiDelete(String no){
        int result = service.kpiDelete(no);

        HashMap<String , String > map = new HashMap<>();
        map.put("msg", "삭제 성공");
        if( result != 1){
            map.put("msg", "삭제 실패");
        }
        return map;
    }

}
