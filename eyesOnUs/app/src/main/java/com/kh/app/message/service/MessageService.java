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

    public int getTotalCount(String senderNo) {
        return dao.getTotalCount(senderNo);
    }

    public List<MessageVo> messageSendListData(String senderNo, int page, int size) {
        int offset = (page - 1) * size;
        return dao.messageSendListData(senderNo, offset, size);
    }

}
