package com.kh.app.kpi.controller;

import com.kh.app.kpi.service.KpiService;
import com.kh.app.kpi.vo.KpiVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String kpiWrite(ProjectVo vo, ProjectManagerVo vo2, Model model){
        List<ProjectVo> voList = service.writeList(vo);
        List<ProjectManagerVo> voList2 = service.writeList2(vo2);

        model.addAttribute("voList", voList);
        model.addAttribute("voList2", voList2);

        return "kpi/write";
    }

    @PostMapping("write")
    public ResponseEntity<HashMap<String, String>> kpiWrite(KpiVo vo, HttpSession session){

        HashMap<String , String > map = new HashMap<>();
        if( vo.getEmpNo() == null || vo.getProjectNo() == null || vo.getGoal() == null || vo.getPersonalSchedule() == null ){
            map.put("msg", "필수 입력사항을 입력해주세요.");
            return ResponseEntity.badRequest().body(map);
        }

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if( loginMemberVo == null || !loginMemberVo.getNo().equals(vo.getEmpNo())){
            map.put("msg", "권한이 없습니다.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);
        }

        int result = service.kpiWrite(vo);

        if (result == 1) {
            map.put("msg", "작성 성공");
            return ResponseEntity.ok(map);
        } else {
            map.put("msg", "작성 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
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
    public ResponseEntity<HashMap<String, String>> kpiModify(KpiVo vo){
        int result = service.kpiModify(vo);

        HashMap<String, String> map = new HashMap<>();
        if (result == 1) {
            map.put("msg", "수정 성공");
            return ResponseEntity.ok(map);
        } else {
            map.put("msg", "수정 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 게시글 삭제
    @DeleteMapping("delete")
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> kpiDelete(String no){
        int result = service.kpiDelete(no);

        HashMap<String , String > map = new HashMap<>();
        if (result == 1) {
            map.put("msg", "삭제 성공");
            return ResponseEntity.ok(map);
        } else {
            map.put("msg", "삭제 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

}
