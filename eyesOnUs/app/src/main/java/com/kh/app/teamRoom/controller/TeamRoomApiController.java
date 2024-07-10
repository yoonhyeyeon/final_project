package com.kh.app.teamRoom.controller;


import com.kh.app.personal.vo.PersonalVo;
import com.kh.app.teamRoom.service.TeamRoomService;
import com.kh.app.teamRoom.vo.TeamRoomVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //사원목록 조회
    @GetMapping("temaList")
    public List<TeamRoomVo> getTeamList(){
        List<TeamRoomVo> voList = service.getTeamList();
        return voList;
    }



}//class
