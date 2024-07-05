package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.MemberEvalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberEvalController {

    private final MemberEvalService service;

}
