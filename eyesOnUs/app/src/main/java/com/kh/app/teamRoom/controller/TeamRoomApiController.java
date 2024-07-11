package com.kh.app.teamRoom.controller;


import com.kh.app.evaluation.vo.ColleageEvalVo;
import com.kh.app.home.vo.CommuteVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.teamRoom.service.TeamRoomService;
import com.kh.app.teamRoom.vo.TeamRoomVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/teamRoom")
@RequiredArgsConstructor
public class TeamRoomApiController {

    private final TeamRoomService service;

    //다가오는 일정 조회(todo)
    @GetMapping("todo")
    public List<TeamRoomVo> getTodoList(){
        List<TeamRoomVo> voList = service.getTodoList();
        return voList;
    }

    //다가오는 일정 조회(todo)
    @GetMapping("todo-prj")
    public List<TeamRoomVo> getTodoPrjList(){
        List<TeamRoomVo> voList = service.getTodoPrjList();
        return voList;
    }


    //팀원목록 조회


    @GetMapping("listData")
    @ResponseBody
    public List<TeamRoomVo> listData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<TeamRoomVo> voList = service.list(no);
        return voList;
    }


}//class
