package com.kh.app.adminDept.controller;

import com.kh.app.adminDept.service.AdminDeptService;
import com.kh.app.adminDept.vo.DivisionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("adminDeptMngr")
@RequiredArgsConstructor
public class AdminDeptController {

    private final AdminDeptService service;

    @GetMapping("list")
    public String adminDeptList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            Model model) {
        List<DivisionVo> voList = service.adminDeptList(page, size);
        int totalCount = service.getTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        model.addAttribute("voList", voList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "adminDeptMngr/adminDeptList";
    }//method

    @PostMapping("search")
    public String adminDeptSearch(
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            Model model) {

        List<DivisionVo> voList = service.adminDeptSearch(empCategory, searchBox, page, size);
        int totalCount = service.getTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        model.addAttribute("voList", voList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "adminDeptMngr/adminDeptList";
    }//method

    @GetMapping("enrollDiv")
    public String enrollDivForm() {
        return "adminDeptMngr/adminDeptEnrollDiv";
    }//method

    @PostMapping("enrollDiv")
    public String enrollDiv(
            @RequestParam("deptCategory") String deptCode,
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("enrollDate") String enrollDate,
            @RequestParam("stateCategory") String state) {

        DivisionVo divisionVo = new DivisionVo();
        divisionVo.setDeptCode(deptCode);
        divisionVo.setName(name);
        divisionVo.setCode(code);
        divisionVo.setEnrollDate(enrollDate);
        divisionVo.setState(state);

        // 서비스에 데이터 전달
        service.enrollDiv(divisionVo);

        return "redirect:/adminDeptMngr/list";
    }//method

    @GetMapping("edit")
    public String adminDeptEditForm(@RequestParam("code") String code, Model model){
        DivisionVo vo = service.getDivisionByCode(code);
        model.addAttribute("vo", vo);
        return "adminDeptMngr/adminDeptEdit";
    }

    @PostMapping("edit")
    public String adminDeptEdit(
            @RequestParam("deptCode") String deptCode,
            @RequestParam("name") String name,
            @RequestParam("code") String code,
            @RequestParam("modifyDate") String modifyDate,
            @RequestParam("state") String state){

        DivisionVo divisionVo = new DivisionVo();
        divisionVo.setDeptCode(deptCode);
        divisionVo.setName(name);
        divisionVo.setCode(code);
        divisionVo.setModifyDate(modifyDate);
        divisionVo.setState(state);

        service.updateDivision(divisionVo);

        return "redirect:/adminDeptMngr/list";
    }

}
