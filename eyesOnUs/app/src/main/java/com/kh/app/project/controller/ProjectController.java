package com.kh.app.project.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.project.service.ProjectService;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import com.kh.app.sign.vo.EmployeeVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("project")
@RequiredArgsConstructor
@CrossOrigin
public class ProjectController {

    private final ProjectService service;

    @GetMapping("projectMain")
    public String select(HttpSession session){


        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        return "project/projectMain";
    }

   @GetMapping("deptListData")
   @ResponseBody
   public List<EmployeeVo> deptListByNo(HttpSession session){

       MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
       List<EmployeeVo> voList = service.deptListByNo(loginMemberVo.getDeptCode());

       return voList;
    }


    @GetMapping("projectInsert")
    public String insert(){
        return "project/insertPrj";
    }

    @ResponseBody
    @PostMapping("projectInsert")
    public int insert(ProjectVo vo,HttpSession session){

        MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
        int result = service.insertProject(vo);

        return result;
    }

    @GetMapping("projectModify")
    public String modifyPrj(ProjectVo vo, HttpServletRequest req){
        ProjectVo vo1 = service.getProjectByNo(vo.getNo());
        req.setAttribute("vo",vo1);
        return "project/modifyPrj";
    }

    @ResponseBody
    @PostMapping("projectModify")
    public String modifyPrj(ProjectVo vo, HttpServletRequest req,HttpSession session){

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

        if(result !=1){
            req.setAttribute("result","삭제실패");

        }
        req.setAttribute("result","삭제성공");
        return "common/result";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<ProjectVo> projectListData(HttpSession session){
        MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
        List<ProjectVo> voList = service.projectList(loginMemberVo.getDeptCode());
        return  voList;
    }
    @GetMapping("projectList")
    public String projectList(){
        return "project/projectList";
    }

    @GetMapping("detailData")
    @ResponseBody
    public ProjectVo getProjectByNo(ProjectVo vo,HttpSession session,HttpServletRequest req){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        ProjectVo vo1 = service.getProjectByNo(vo.getNo());
        return vo1;
    }

    @GetMapping("detail")
    public String projectDetail(ProjectVo vo,HttpServletRequest req){
        ProjectVo vo1 = service.getProjectByNo(vo.getNo());
        req.setAttribute("vo",vo1);
        return "project/projectDetail";
    }

    @GetMapping("searchByName")
    @ResponseBody
    public List<ProjectVo>  projectSearchByName(ProjectVo vo){
       List<ProjectVo> voList = service.projectSearchByName(vo.getTitle());
       return voList;
    }

    @GetMapping("listData2")
    @ResponseBody
    public List<ProjectVo> listData2(ProjectVo vo){

        List<ProjectVo> voList = service.listData2(vo);
        return voList;
    }






    /////////////////////////////////// PROJECT RECORD 컨트롤러////////////////////////////////////////////////////////////////////
    @GetMapping("record/insert")
    public String recordInsert(){
        return "prjConfRecord/recordInsert";
    }

    @PostMapping("record/insert")
    @ResponseBody
    public int recordInsert(ProjectRecordVo vo, HttpSession session){

        MemberVo loginVo = (MemberVo) session.getAttribute("loginMemberVo");
        int result = service.recordInsert(vo);
        return result;

    }

    @ResponseBody
    @GetMapping("record/listData")
    public List<ProjectRecordVo> recordList(HttpServletRequest req, HttpSession session, Model model){

        MemberVo loginVo = (MemberVo) session.getAttribute("loginMemberVo");
        List<ProjectRecordVo> voList = service.recordList();

        model.addAttribute("voList",voList);

        return voList;
    }
    @GetMapping("record/list")
    public  String recordList() {
        return "prjConfRecord/recordList";
    }



    @GetMapping("record/detailData")
    @ResponseBody
    public ProjectRecordVo recordDetail(ProjectRecordVo vo, HttpSession session){
        MemberVo loginVo = (MemberVo) session.getAttribute("loginMemberVo");
        return service.recordDetail(vo.getNo());
    }

    @GetMapping("record/detail")
    public String recordDetail(){
        return "prjConfRecord/recordDetail";
    }

    @DeleteMapping("record/delete")
    @ResponseBody
    public int recordDetete(String no){
        return service.recordDelete(no);
    }

    ///////////////////////////////////////////// PROJECT_MANAGER //////////////////////////////////////////////////////////////////

    @GetMapping("manager/insert")
    public String managerInsert(){
        return "prjManager/managerInsert";
    }

    @PostMapping("manager/insert")
    @ResponseBody
    public int managerInsert(ProjectManagerVo vo){
        int result = service.managerInsert(vo);

        return result;

    }

    @GetMapping("manager/listData")
    @ResponseBody
    public List<ProjectManagerVo> managerListData(){
        List<ProjectManagerVo> voList = service.managerList();
        return  voList;
    }

    @GetMapping("manager/list")
    public String managerList(){
        return "prjManager/managerList";
    }

    @DeleteMapping("manager/delete")
    @ResponseBody
    public int managerDelete(String no){
        int result = service.managerDelete(no);
        return result;
    }


    @GetMapping("cal")
    public String cal(){
        return "project/cal";
    }


}
