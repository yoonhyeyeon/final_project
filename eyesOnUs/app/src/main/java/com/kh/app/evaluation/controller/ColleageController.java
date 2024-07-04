package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.ColleageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ColleageController {

    private final ColleageService service;

}
