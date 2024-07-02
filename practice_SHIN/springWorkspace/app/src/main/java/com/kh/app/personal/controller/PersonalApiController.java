package com.kh.app.personal.controller;

import com.kh.app.personal.serviec.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/personal")
@RequiredArgsConstructor
public class PersonalApiController {

    private final PersonalService service;

    //목록조회
    @GetMapping("list")
    public List<PersonalVo> getPersonalList(){
        List<PersonalVo> voList = service.getPersonalList();
        return voList;
    }

}
