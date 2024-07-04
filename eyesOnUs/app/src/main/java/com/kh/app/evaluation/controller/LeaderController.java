package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.LeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LeaderController {

    private final LeaderService service;

}
