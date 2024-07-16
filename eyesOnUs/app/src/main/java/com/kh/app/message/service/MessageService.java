package com.kh.app.message.service;

import com.kh.app.message.dao.MessageDao;
import com.kh.app.message.vo.MessageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageDao dao;

    public void messageWriteData(MessageVo vo) {
        dao.messageWriteData(vo);
    }

    public int getTotalSendCount(String senderNo) {
        return dao.getTotalSendCount(senderNo);
    }

    public List<MessageVo> messageSendListData(String senderNo, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageSendListData(senderNo, offset, size);
    }

    public int getSearchTotalSendCount(String senderNo, String empCategory, String searchBox) {
        return dao.getSearchTotalSendCount(senderNo, empCategory, searchBox);
    }

    public List<MessageVo> messageSendListSearchData(String senderNo, String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageSendListSearchData(senderNo, empCategory, searchBox, offset, size);
    }

    public int getTotalReceiveCount(String receiverNo) {
        return dao.getTotalReceiveCount(receiverNo);
    }

    public List<MessageVo> messageReceiveListData(String receiverNo, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageReceiveListData(receiverNo, offset, size);
    }

    public int getSearchTotalReceiveCount(String receiverNo, String empCategory, String searchBox) {
        return dao.getSearchTotalReceiveCount(receiverNo, empCategory, searchBox);
    }

    public List<MessageVo> messageReceiveListSearchData(String receiverNo, String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageReceiveListSearchData(receiverNo, empCategory, searchBox, offset, size);
    }

    public MessageVo messageDetailData(String no) {
        return dao.messageDetailData(no);
    }

    public void updateMessageReadYn(String no) {
        dao.updateMessageReadYn(no);
    }

    public void updateReceiveMsgDelYn(String no) {
        int updatedRows = dao.updateReceiveMsgDelYn(no);
        if (updatedRows == 0) {
            throw new RuntimeException("해당 메시지가 존재하지 않거나 이미 삭제되었습니다.");
        }
    }

    public void updateSendMsgDelYn(String no) {
        dao.updateSendMsgDelYn(no);
    }

    public int getTotalReceiveDeleteCount(String receiverNo) {
        return dao.getTotalReceiveDeleteCount(receiverNo);
    }

    public List<MessageVo> messageReceiveDeleteListData(String receiverNo, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageReceiveDeleteListData(receiverNo, offset, size);
    }

    public int getSearchTotalReceiveDeleteCount(String receiverNo, String empCategory, String searchBox) {
        return dao.getSearchTotalReceiveDeleteCount(receiverNo, empCategory, searchBox);
    }

    public List<MessageVo> messageReceiveDeleteListSearchData(String receiverNo, String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageReceiveDeleteListSearchData(receiverNo, empCategory, searchBox, page, offset);
    }
}
