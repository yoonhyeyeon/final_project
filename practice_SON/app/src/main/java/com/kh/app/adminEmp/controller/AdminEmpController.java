package com.kh.app.adminEmp.controller;

import com.kh.app.adminEmp.service.AdminEmpService;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        ModelAndView mav = new ModelAndView("adminEmpMngr/adminEmpList");
        mav.addObject("voList", voList);
        return mav;
    }

    @GetMapping("detail")
    public ModelAndView adminEmpByNo(@RequestParam("no") String no) {
        AdminEmpVo vo = service.adminEmpByNo(no);
        ModelAndView mav = new ModelAndView("adminEmpMngr/adminEmpDetail");
        mav.addObject("vo", vo);
        return mav;
    }
}
