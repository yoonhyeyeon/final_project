package com.kh.app.message.dao;

import com.kh.app.message.mapper.MessageMapper;
import com.kh.app.message.vo.MessageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageDao {

    private final MessageMapper mapper;

    public void messageWriteData(MessageVo vo) {
        mapper.messageWriteData(vo);
    }

    public int getTotalSendCount(String senderNo) {
        return mapper.getTotalSendCount(senderNo);
    }

    public List<MessageVo> messageSendListData(String senderNo, int offset, int size) {
        return mapper.messageSendListData(senderNo, offset, size);
    }

    public int getSearchTotalSendCount(String senderNo, String empCategory, String searchBox) {
        return mapper.getSearchTotalSendCount(senderNo, empCategory, searchBox);
    }

    public List<MessageVo> messageSendListSearchData(String senderNo, String empCategory, String searchBox, int offset, int size) {
        return mapper.messageSendListSearchData(senderNo, empCategory, searchBox, offset, size);
    }

    public int getTotalReceiveCount(String receiverNo) {
        return mapper.getTotalReceiveCount(receiverNo);
    }

    public List<MessageVo> messageReceiveListData(String receiverNo, int offset, int size) {
        return mapper.messageReceiveListData(receiverNo, offset, size);
    }

    public int getSearchTotalReceiveCount(String receiverNo, String empCategory, String searchBox) {
        return mapper.getSearchTotalReceiveCount(receiverNo, empCategory, searchBox);
    }

    public List<MessageVo> messageReceiveListSearchData(String receiverNo, String empCategory, String searchBox, int offset, int size) {
        return mapper.messageReceiveListSearchData(receiverNo, empCategory, searchBox, offset, size);
    }

    public MessageVo messageDetailData(String no) {
        return mapper.messageDetailData(no);
    }

    public void updateMessageReadYn(String no) {
        mapper.updateMessageReadYn(no);
    }

    public int updateReceiveMsgDelYn(String no) {
        return mapper.updateReceiveMsgDelYn(no);
    }

    public void updateSendMsgDelYn(String no) {
        mapper.updateSendMsgDelYn(no);
    }

    public int getTotalReceiveDeleteCount(String receiverNo) {
        return mapper.getTotalReceiveDeleteCount(receiverNo);
    }

    public List<MessageVo> messageReceiveDeleteListData(String receiverNo, int offset, int size) {
        return mapper.messageReceiveDeleteListData(receiverNo, offset, size);
    }

    public int getSearchTotalReceiveDeleteCount(String receiverNo, String empCategory, String searchBox) {
        return mapper.getSearchTotalReceiveDeleteCount(receiverNo, empCategory, searchBox);
    }

    public List<MessageVo> messageReceiveDeleteListSearchData(String receiverNo, String empCategory, String searchBox, int page, int offset) {
        return mapper.messageReceiveDeleteListSearchData(receiverNo, empCategory, searchBox, page, offset);
    }
}
