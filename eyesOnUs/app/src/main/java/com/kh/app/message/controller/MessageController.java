package com.kh.app.message.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.message.service.MessageService;

import com.kh.app.message.vo.MessageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

//    @GetMapping("messageWrite")
//    public String messageWrite(Model model) {
//
//        String senderName = "발신자 이름";
//        String senderNo = "발신자 번호";
//
//        model.addAttribute("senderName", senderName);
//        model.addAttribute("senderNo", senderNo);
//
//        // 메시지 작성 폼 페이지로 이동
//        return "message/messageWrite";
//    }

    @GetMapping("messageWrite")
    public String messageWrite(Model model, HttpSession session) {
        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 발신인 정보 넣기
        if (loginMemberVo != null) {
            String senderName = loginMemberVo.getName();
            String senderNo = loginMemberVo.getNo();

            model.addAttribute("senderName", senderName);
            model.addAttribute("senderNo", senderNo);
        } else {
            // 로그인 정보가 없는 경우 로그인 페이지로 이동
            return "redirect:/member/login";
        }

        return "message/messageWrite";
    }

    @PostMapping("messageWriteData")
    public String messageWriteData(MessageVo vo){
        service.messageWriteData(vo);
        return "redirect:/message/messageSendList";
    }

    @GetMapping("messageSendList")
    public String messageSendList(){
        return "message/messageSendList";
    }

    @GetMapping("messageSendListData")
    @ResponseBody
    public Map<String, Object> messageSendListData(
            HttpSession session,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {

        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 로그인 정보 확인
        if (loginMemberVo == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
            Map<String, Object> result = new HashMap<>();
            result.put("error", "로그인이 필요합니다.");
            return result;
        }

        // 발신자 정보 가져오기
        String senderNo = loginMemberVo.getNo();

        // 발신자의 메시지 목록 조회
        List<MessageVo> voList = service.messageSendListData(senderNo, page, size);
        int totalCount = service.getTotalCount(senderNo);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;
    }


    @GetMapping("messageReceiveList")
    public String messageReceiveList(){
        return "message/messageReceiveList";
    }

    @GetMapping("messageDetail")
    public String messageDetail(){
        return "message/messageDetail";
    }

}
