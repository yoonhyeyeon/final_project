package com.kh.app.adminDept.controller;

import com.kh.app.adminDept.service.AdminDeptService;
import com.kh.app.adminDept.vo.DivisionVo;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("adminDeptMngr")
@RequiredArgsConstructor
public class AdminDeptController {

    private final AdminDeptService service;

    @GetMapping("list")
    public ModelAndView adminDeptList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        List<DivisionVo> voList = service.adminDeptList(page, size);
        int totalCount = service.getTotalCount();
//        총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalCount / size);

        ModelAndView mav = new ModelAndView("adminDeptMngr/adminDeptList");
        mav.addObject("voList", voList);
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", totalPages);
        return mav;
    }

    @PostMapping("search")
    public ModelAndView adminDeptSearch(
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {

        List<DivisionVo> voList = service.adminDeptSearch(empCategory, searchBox, page, size);
        int totalCount = service.getTotalCount(); // 전체 데이터 수 조회
        int totalPages = (int) Math.ceil((double) totalCount / size); // 총 페이지 수 계산

        ModelAndView mav = new ModelAndView("adminDeptMngr/adminDeptList");
        mav.addObject("voList", voList);
        mav.addObject("currentPage", page); // 현재 페이지를 기본 값으로 설정
        mav.addObject("totalPages", totalPages);
        return mav;
    }
}
