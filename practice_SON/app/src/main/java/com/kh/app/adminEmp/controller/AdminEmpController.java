package com.kh.app.adminEmp.controller;

import com.kh.app.adminEmp.service.AdminEmpService;
import org.springframework.http.ResponseEntity;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("adminEmpMngr")
@RequiredArgsConstructor
public class AdminEmpController {

    private final AdminEmpService service;

    @GetMapping("list")
    public String adminEmpList() {
        return "adminEmpMngr/adminEmpList";
    }

    @GetMapping("listData")
    @ResponseBody
    public Map<String, Object> adminEmpListData(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        List<AdminEmpVo> voList = service.adminEmpListData(page, size);
        int totalCount = service.getTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);
        return result;
    }

    @PostMapping("search")
    public String adminEmpSearch() {
        return "adminEmpMngr/adminEmpList";
    }

    @PostMapping("searchData")
    @ResponseBody
    public Map<String, Object> adminEmpSearchData(
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {

        List<AdminEmpVo> voList = service.adminEmpSearchData(empCategory, searchBox, page, size);
        int totalCount = service.getSearchTotalCount(empCategory, searchBox);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);
        return result;
    }

    @GetMapping("detail")
    public String adminEmpByNo(@RequestParam("no") String no, Model model) {
        AdminEmpVo vo = service.adminEmpByNo(no);
        model.addAttribute("vo", vo);
        return "adminEmpMngr/adminEmpDetail";
    }

    @GetMapping("enrollEmp")
    public String adminEmpEnroll(){
        return "adminEmpMngr/adminEmpEnroll";
    }

    @PostMapping("enrollEmpData")
    public String adminEmpEnrollData(AdminEmpVo vo) {
        service.adminEmpEnrollData(vo);
        return "redirect:/adminEmpMngr/list";
    }

}
