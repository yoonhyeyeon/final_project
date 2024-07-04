package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

}
