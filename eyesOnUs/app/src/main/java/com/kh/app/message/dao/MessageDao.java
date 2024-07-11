package com.kh.app.message.dao;

import com.kh.app.message.mapper.MessageMapper;
import com.kh.app.message.vo.MessageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageDao {

    private final MessageMapper mapper;

    public void messageWriteData(MessageVo vo) {
        mapper.messageWriteData(vo);
    }

    public int getTotalCount(String senderNo) {
        return mapper.getTotalCount(senderNo);
    }

    public List<MessageVo> messageSendListData(String senderNo, int offset, int size) {
        return mapper.messageSendListData(senderNo, offset, size);
    }
}
