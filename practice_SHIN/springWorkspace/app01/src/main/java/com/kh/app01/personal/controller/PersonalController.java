package com.kh.app01.personal.controller;

import com.kh.app01.personal.controller.personal.service.PersonalService;
import com.kh.app01.personal.service.PersonalService;
import com.kh.app01.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personal")
@RequiredArgsConstructor
public class PersonalController {

    private PersonalService service;

    @PostMapping("save")
    public String saveEntity(@RequestBody PersonalVo vo) {
        service.save(vo);
        return "Saved successfully";
    }


}
