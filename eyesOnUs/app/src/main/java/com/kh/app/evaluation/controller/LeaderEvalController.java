package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.LeaderEvalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LeaderEvalController {

    private final LeaderEvalService service;

}
