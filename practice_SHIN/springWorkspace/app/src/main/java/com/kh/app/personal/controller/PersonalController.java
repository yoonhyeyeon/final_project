package com.kh.app.personal.controller;

import com.kh.app.personal.service.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("personal")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService service;

    // 일정 작성 폼 화면
    @GetMapping("writeForm")
    public String writeForm() {
        return "personal/write";
    }

    @PostMapping("write")
    @ResponseBody
    public String writePersonal(@RequestBody PersonalVo personalVo) {
        // 받아온 데이터를 서비스 계층을 통해 데이터베이스에 저장
        service.savePersonal(personalVo);

        return "success"; // 성공적으로 저장되었음을 클라이언트에게 응답
    }



}
