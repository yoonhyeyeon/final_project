package com.kh.app.message.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.message.service.MessageService;

import com.kh.app.message.vo.MessageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // 메시지 작성 뷰(+보낸사람 정보 넣기)
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

    // 메시지 작성 데이터
    @PostMapping("messageWriteData")
    public String messageWriteData(MessageVo vo){
        service.messageWriteData(vo);
        return "redirect:/message/messageSendList";
    }

    // 보낸 메시지함 뷰
    @GetMapping("messageSendList")
    public String messageSendList(){
        return "message/messageSendList";
    }

    // 보낸 메시지함 데이터
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
        int totalCount = service.getTotalSendCount(senderNo);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;
    }

    // 보낸 메시지함 검색 데이터
    @PostMapping("messageSendListSearchData")
    @ResponseBody
    public Map<String, Object> messageSendListSearchData(
            HttpSession session,
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

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
        List<MessageVo> voList = service.messageSendListSearchData(senderNo, empCategory, searchBox, page, size);
        int totalCount = service.getSearchTotalSendCount(senderNo, empCategory, searchBox);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

    // 받은 메시지함 뷰
    @GetMapping("messageReceiveList")
    public String messageReceiveList(){
        return "message/messageReceiveList";
    }

    // 받은 메시지함 데이터
    @GetMapping("messageReceiveListData")
    @ResponseBody
    public Map<String, Object> messageReceiveListData(
            HttpSession session,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 로그인 정보 확인
        if (loginMemberVo == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
            Map<String, Object> result = new HashMap<>();
            result.put("error", "로그인이 필요합니다.");
            return result;
        }

        // 수신자 정보 가져오기
        String receiverNo = loginMemberVo.getNo();

        // 발신자의 메시지 목록 조회
        List<MessageVo> voList = service.messageReceiveListData(receiverNo, page, size);
        int totalCount = service.getTotalReceiveCount(receiverNo);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

    // 받은 메시지함 검색 데이터
    @PostMapping("messageReceiveListSearchData")
    @ResponseBody
    public Map<String, Object> messageReceiveListSearchData(
            HttpSession session,
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 로그인 정보 확인
        if (loginMemberVo == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
            Map<String, Object> result = new HashMap<>();
            result.put("error", "로그인이 필요합니다.");
            return result;
        }

        // 수신자 정보 가져오기
        String receiverNo = loginMemberVo.getNo();

        // 발신자의 메시지 목록 조회
        List<MessageVo> voList = service.messageReceiveListSearchData(receiverNo, empCategory, searchBox, page, size);
        int totalCount = service.getSearchTotalReceiveCount(receiverNo, empCategory, searchBox);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

    // 메시지 상세 보기 뷰
    @GetMapping("messageDetail")
    public String messageDetail(){
        return "message/messageDetail";
    }

    // 메시지 상세 보기 데이터
    @GetMapping("messageDetailData")
    @ResponseBody
    public MessageVo messageDetailData(@RequestParam("no") String no){
        return service.messageDetailData(no);
    }

    // 로그인 사원 번호 받아오기
    @GetMapping("loginNo")
    @ResponseBody
    public String getLoginNo(HttpSession session) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        return loginMemberVo.getNo();
    }
    
    //메시지 읽음
    @PutMapping("updateReadYn")
    public void updateReadYn(@RequestBody String no) {
        service.updateMessageReadYn(no);
    }

    //받은 메시지 삭제
    @PutMapping("updateReceiveMsgDelYn")
    public ResponseEntity<String> updateReceiveMsgDelYn(@RequestBody String no) {
        try {
            service.updateReceiveMsgDelYn(no);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }

    //보낸 메시지 삭제
    @PutMapping("updateSendMsgDelYn")
    public ResponseEntity<String> updateSendMsgDelYn(@RequestBody String no) {
        try {
            service.updateReceiveMsgDelYn(no);
            return ResponseEntity.ok("success");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }

    // 삭제된 받은 메시지함 뷰
    @GetMapping("messageReceiveDeleteList")
    public String messageReceiveDeleteList(){
        return "message/messageReceiveDeleteList";
    }

    // 받은 메시지함 데이터
    @GetMapping("messageReceiveDeleteListData")
    @ResponseBody
    public Map<String, Object> messageReceiveDeleteListData(
            HttpSession session,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 로그인 정보 확인
        if (loginMemberVo == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
            Map<String, Object> result = new HashMap<>();
            result.put("error", "로그인이 필요합니다.");
            return result;
        }

        // 수신자 정보 가져오기
        String receiverNo = loginMemberVo.getNo();

        // 발신자의 메시지 목록 조회
        List<MessageVo> voList = service.messageReceiveDeleteListData(receiverNo, page, size);
        int totalCount = service.getTotalReceiveDeleteCount(receiverNo);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

    // 받은 메시지함 검색 데이터
    @PostMapping("messageReceiveDeleteListSearchData")
    @ResponseBody
    public Map<String, Object> messageReceiveDeleteListSearchData(
            HttpSession session,
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

        // 세션에서 로그인 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        // 로그인 정보 확인
        if (loginMemberVo == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
            Map<String, Object> result = new HashMap<>();
            result.put("error", "로그인이 필요합니다.");
            return result;
        }

        // 수신자 정보 가져오기
        String receiverNo = loginMemberVo.getNo();

        // 발신자의 메시지 목록 조회
        List<MessageVo> voList = service.messageReceiveDeleteListSearchData(receiverNo, empCategory, searchBox, page, size);
        int totalCount = service.getSearchTotalReceiveDeleteCount(receiverNo, empCategory, searchBox);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

    // 삭제된 보낸 메시지함 뷰
    @GetMapping("messageSendDeleteList")
    public String messageSendDeleteList(){
        return "message/messageSendDeleteList";
    }

    // 삭제된 보낸 메시지함 데이터
    @GetMapping("messageSendDeleteListData")
    @ResponseBody
    public Map<String, Object> messageSendDeleteListData(
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
        List<MessageVo> voList = service.messageSendDeleteListData(senderNo, page, size);
        int totalCount = service.getTotalSendDeleteCount(senderNo);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;
    }

    // 삭제된 보낸 메시지함 검색 데이터
    @PostMapping("messageSendDeleteListSearchData")
    @ResponseBody
    public Map<String, Object> messageSendDeleteListSearchData(
            HttpSession session,
            @RequestParam("empCategory") String empCategory,
            @RequestParam("searchBox") String searchBox,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){

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
        List<MessageVo> voList = service.messageSendDeleteListSearchData(senderNo, empCategory, searchBox, page, size);
        int totalCount = service.getSearchTotalSendDeleteCount(senderNo, empCategory, searchBox);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // 결과 맵 생성
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);

        return result;

    }

}

