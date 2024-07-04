package com.kh.eyes.businessTrip.controller;

import com.kh.eyes.businessTrip.service.BusinessTripService;
import com.kh.eyes.businessTrip.vo.BusinessTripVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("businessTrip")
public class BusinessTripController {

    private final BusinessTripService service;

    // 출장 신청 (화면)
    @GetMapping("write")
    public void businessTripWrite(){} // businessTripWrite

    // 출장 신청
    @PostMapping("write")
    public String businessTripWrite(BusinessTripVo vo){
        int businessTripWriteResult = service.businessTripWrite(vo);
        return "redirect:/home";
    } // businessTripWrite

    // 출장 목록 조회 (화면)
    @GetMapping("list")
    public void businessTripList(){} // businessTripList

    // 출장 상세 조회 (화면)
    @GetMapping("detail")
    public void businessTripDetail(){} // businessTripDetail
} // class
