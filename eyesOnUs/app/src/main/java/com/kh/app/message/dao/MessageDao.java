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

    @Transactional
    public void updateMessageDelYn(String no) {
        mapper.updateMessageDelYn(no);
    }
}
