package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.ColleageEvalService;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.vo.EmployeeVo;
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
@RequiredArgsConstructor
@RequestMapping("colleageEval")
public class ColleageEvalController {

    private final ColleageEvalService service;

    // 작성하기
    @GetMapping("write")
    public String write(EmployeeVo vo, Model model, String evaluateeNo){
        List<EmployeeVo> voList = service.writeList(vo);

        model.addAttribute("selectedEvaluateeNo", evaluateeNo);
        model.addAttribute("voList", voList);

        return "colleageEval/write";
    }

    @PostMapping("write")
    public ResponseEntity<HashMap<String, String>> write(ColleageEvalVo vo, HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        int result = service.write(vo);

        HashMap<String, String> map = new HashMap<>();
        if (result == 1) {
            map.put("msg", "작성 성공");
            return ResponseEntity.ok(map);
        } else {
            map.put("msg", "작성 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 목록
    @GetMapping("list")
    public String list(EmployeeVo vo, Model model){
        List<EmployeeVo> voList = service.listByNo(vo);
        model.addAttribute("voList", voList);

        return "colleageEval/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<ColleageEvalVo> listData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<ColleageEvalVo> voList = service.list(no);
        return voList;
    }
}
