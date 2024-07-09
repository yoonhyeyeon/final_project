package com.kh.app.adminHr.conrtoller;

import com.kh.app.adminHr.service.AdminHrServeice;
import com.kh.app.adminHr.vo.AdminHrVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("adminHr")
public class AdminHrController {

    private final AdminHrServeice service;

    @GetMapping("adminHrLogin")
    public String login(){
        return "adminHr/adminHrLogin";
    }

    @PostMapping("adminHrLoginData")
    public String login(AdminHrVo vo, HttpSession session){
        AdminHrVo adminHrLoginVo = service.login(vo);
        if (adminHrLoginVo != null) {
            session.setAttribute("adminHrLoginVo", adminHrLoginVo);
            return "redirect:/adminEmpMngr/list";
        } else {
            return "redirect:/adminHr/adminHrLogin";
        }
    }

}
