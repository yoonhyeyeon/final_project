package com.kh.app.message.mapper;

import com.kh.app.message.vo.MessageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {

    @Insert("""
                INSERT INTO MESSAGE
                (
                    NO
                    , SENDER
                    , RECEIVER
                    , TITLE
                    , CONTENT
                )
                VALUES
                (
                    SEQ_MESSAGE.NEXTVAL
                    , #{sender}
                    , #{receiver}
                    , #{title}
                    , #{content}
                )
            """)
    void messageWriteData(MessageVo vo);

    @Select("""
                SELECT COUNT(*)
                FROM MESSAGE
                WHERE SENDER = #{senderNo}
            """)
    int getTotalCount(String senderNo);

    @Select("""
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , SENDER_EMP.NAME AS SENDER_NAME
                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                    , RECEIVER_DEPT.NAME AS RECEIVER_DEPT_NAME
                    , RECEIVER_DIV.NAME AS RECEIVER_DIV_NAME
                    , RECEIVER_POSITION.NAME AS RECEIVER_POSITION_NAME
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.SENDER = #{senderNo}
                ORDER BY M.SEND_TIME DESC
            """)
    List<MessageVo> messageSendListData(String senderNo, int offset, int size);
}
