package com.kh.app.adminEmp.controller;

import com.kh.app.adminEmp.service.AdminEmpService;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("adminEmpMngr")
@RequiredArgsConstructor
public class AdminEmpController {

    private final AdminEmpService service;

    @GetMapping("list")
    public ModelAndView adminEmpList() {
        List<AdminEmpVo> voList = service.adminEmpList();
        System.out.println("voList = " + voList);
        ModelAndView mav = new ModelAndView("adminEmpMngr/adminEmpList"); // 뷰의 이름 설정 (접두사 및 접미사는 application.properties에서 설정)
        mav.addObject("voList", voList); // 모델에 데이터 추가
        return mav;
    }
}
