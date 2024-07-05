package com.kh.app.adminEmp.controller;

import com.kh.app.adminEmp.service.AdminEmpService;
import com.kh.app.adminEmp.vo.DivisionVo;
import com.kh.app.adminEmp.vo.PositionVo;
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

    // 사원 목록 페이지
    @GetMapping("list")
    public String adminEmpList() {
        return "adminEmpMngr/adminEmpList";
    }//method
    
    // 사원 목록 데이터
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
    }//method

    // 사원 검색 목록 페이지 
    @PostMapping("search")
    public String adminEmpSearch() {
        return "adminEmpMngr/adminEmpList";
    }//method

    // 사원 검색 목록 데이터
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
    }//method

//    @GetMapping("detail")
//    public String adminEmpByNo(@RequestParam("no") String no, Model model) {
//        AdminEmpVo vo = service.adminEmpByNo(no);
//        model.addAttribute("vo", vo);
//        return "adminEmpMngr/adminEmpDetail";
//    }//method

    // 사원 상세 정보 페이지
    @GetMapping("detail")
    public String adminEmpByNo() {
        return "adminEmpMngr/adminEmpDetail";
    }//method

//    @GetMapping("detailData")
//    @ResponseBody
//    public Map<String, Object> adminEmpByNoData(String no){
//        AdminEmpVo vo = service.adminEmpByNoData(no);
//        Map<String, Object> result = new HashMap<>();
//        result.put("vo", vo);
//        return result;
//    }//method

//    @GetMapping("detailData")
//    @ResponseBody
//    public Map<String, Object> adminEmpByNoData(@RequestParam("no") String no) {
//        AdminEmpVo vo = service.adminEmpByNo(no);
//        Map<String, Object> result = new HashMap<>();
//        result.put("vo", vo);
//        return result;
//    }//method

    // 사원 상세 정보 데이터
    @GetMapping("detailData")
    @ResponseBody
    public AdminEmpVo adminEmpByNoData(@RequestParam("no") String no) {
        return service.adminEmpByNo(no);
    }//method

    // 사원 등록 페이지
    @GetMapping("enrollEmp")
    public String adminEmpEnroll(){
        return "adminEmpMngr/adminEmpEnroll";
    }//method

    // 사원 등록 데이터
    @PostMapping("enrollEmpData")
    public String adminEmpEnrollData(AdminEmpVo vo) {
        service.adminEmpEnrollData(vo);
        return "redirect:/adminEmpMngr/list";
    }//method

    // 사원 정보 수정 페이지
    @GetMapping("edit")
    public String adminEmpEdit(){
        return "adminEmpMngr/adminEmpEdit";
    }//method

    // 사원 정보 수정 데이터
    @GetMapping("editData")
    @ResponseBody
    public AdminEmpVo adminEmpEditData(@RequestParam("no") String no){
        return service.adminEmpByNo(no);
    }//method

    // 부서코드 가져오기
    @GetMapping("getDivCode")
    @ResponseBody
    public Map<String, Object> getDivCode(@RequestParam("deptCode") String deptCode){
        List<DivisionVo> voList = service.getDivCode(deptCode);
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        return result;
    }//method

    // 상세 조회 데이터 수정 페이지로 전달
    @GetMapping("editPostData")
    public AdminEmpVo editData(@RequestParam("no") String no) {
        return service.getEmployeeDetail(no);
    }//method

    // 사원정보 수정
    @PostMapping("updateEmpData")
    @ResponseBody
    public String updateEmpData(@RequestBody AdminEmpVo vo) {
        int result = service.updateEmployee(vo);

        return "사원 정보가 성공적으로 수정되었습니다.";
    }//method

}
