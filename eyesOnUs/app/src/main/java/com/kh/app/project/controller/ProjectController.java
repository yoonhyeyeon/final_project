package com.kh.app.project.controller;

import com.kh.app.project.service.ProjectService;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("project")
@RequiredArgsConstructor
@CrossOrigin
public class ProjectController {

    private final ProjectService service;

    @GetMapping("projectMain")
    public String select(){
        return "project/projectMain";
    }
    @GetMapping("projectInsert")
    public String insert(){
        return "project/insertPrj";
    }

    @ResponseBody
    @PostMapping("projectInsert")
    public String insert(ProjectVo vo, HttpServletResponse resp, HttpServletRequest req){

        int result = service.insertProject(vo);

        if(result != 1){
            req.setAttribute("result","등록실패...");
        }
        req.setAttribute("result","등록 성공!");
        return "common/result";
    }

    @GetMapping("projectModify")
    public String modifyPrj(){
        return "project/modifyPrj";
    }

    @ResponseBody
    @PostMapping("projectModify")
    public String modifyPrj(ProjectVo vo, HttpServletRequest req){

        int result = service.modifyPrj(vo);

        if(result != 1){
            req.setAttribute("result","수정실패...");
        }
        req.setAttribute("result","수정 성공!");
        return "common/result";
    }

    @DeleteMapping("projectDelete")
    @ResponseBody
    public String deletePrj(String no,HttpServletRequest req){
        int result = service.deletePrj(no);

        HashMap<String ,String > map = new HashMap<>();
        if(result !=1){
            req.setAttribute("result","삭제실패");

        }
        req.setAttribute("result","삭제성공");
        return "common/result";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<ProjectVo> projectListData(){
        List<ProjectVo> voList = service.projectList();
        return  voList;
    }
    @GetMapping("projectList")
    public String projectList(){
        return "project/projectList";
    }

    @GetMapping("detailData")
    @ResponseBody
    public ProjectVo getProjectByNo(ProjectVo vo){
        return service.getProjectByNo(vo.getNo());
    }

    @GetMapping("detail")
    public String projectDetail(){
        return "project/projectDetail";
    }





    /////////////////////////////////// PROJECT RECORD 컨트롤러////////////////////////////////////////////////////////////////////
    @GetMapping("record/insert")
    public String recordInsert(){
        return "project/recordInsert";
    }

    @PostMapping("record/insert")
    public String recordInsert(ProjectRecordVo vo, HttpServletResponse resp, HttpServletRequest req){

        int result = service.recordInsert(vo);

        if(result != 1){
            req.setAttribute("result","회의록 등록 실패..");
            return "common/result";
        }
        req.setAttribute("result","회의록 등록 완료!");
        return "common/result";
    }

    @ResponseBody
    @GetMapping("record/list")
    public List<ProjectRecordVo> recordList(HttpServletRequest req){

        List<ProjectRecordVo> voList = service.recordList();

        //아직 잘 모름 이렇게 내리면 될거같은데?
        //req.setAttribute("voList",voList);

        return voList;
    }


}
