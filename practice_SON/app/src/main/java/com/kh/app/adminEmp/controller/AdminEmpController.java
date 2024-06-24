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
//    매개변수로 page와 페이지당 게시글 수인 size를 지정
//    @RequestParam: 요청 파라미터를 컨트롤러 메서드의 매개변수에 바인딩
    public ModelAndView adminEmpList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        List<AdminEmpVo> voList = service.adminEmpList(page, size);
        int totalCount = service.getTotalCount();
//        총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalCount / size);

        ModelAndView mav = new ModelAndView("adminEmpMngr/adminEmpList");
        mav.addObject("voList", voList);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", totalPages);
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
