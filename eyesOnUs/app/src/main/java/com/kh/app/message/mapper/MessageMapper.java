package com.kh.app.message.mapper;

import com.kh.app.message.vo.MessageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
                AND DEL_YN = 'N'
            """)
    int getTotalSendCount(String senderNo);

//    SELECT
//    M.NO
//                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
//                    , M.TITLE
//                    , M.SENDER
//                    , M.RECEIVER
//                    , M.READ_YN
//                    , M.DEL_YN
//                    , SENDER_EMP.NAME AS SENDER_NAME
//                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
//                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
//                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
//                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
//                    , RECEIVER_DEPT.NAME AS RECEIVER_DEPT_NAME
//                    , RECEIVER_DIV.NAME AS RECEIVER_DIV_NAME
//                    , RECEIVER_POSITION.NAME AS RECEIVER_POSITION_NAME
//    FROM MESSAGE M
//    JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
//    JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
//    JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
//    JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
//    JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
//    JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
//    JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
//    JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
//    WHERE M.SENDER = #{senderNo}
//    ORDER BY M.SEND_TIME DESC


    @Select("""
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
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
                AND DEL_YN = 'N'
                ORDER BY M.SEND_TIME DESC
                OFFSET #{offset} ROWS FETCH NEXT #{size} ROWS ONLY
            """)
    List<MessageVo> messageSendListData(String senderNo, int offset, int size);

    @Select("""
                <script>
                SELECT COUNT(*)
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
                AND DEL_YN = 'N'
                AND
                <choose>
                    <when test='empCategory == "receiverDeptName"'>
                        RECEIVER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverDivName"'>
                        RECEIVER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverPositionName"'>
                        RECEIVER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverName"'>
                        RECEIVER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    int getSearchTotalSendCount(String senderNo, String empCategory, String searchBox);

    @Select("""
                <script>
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
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
                AND DEL_YN = 'N'
                AND
                <choose>
                    <when test='empCategory == "receiverDeptName"'>
                        RECEIVER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverDivName"'>
                        RECEIVER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverPositionName"'>
                        RECEIVER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverName"'>
                        RECEIVER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    List<MessageVo> messageSendListSearchData(String senderNo, @Param("empCategory") String empCategory, @Param("searchBox") String searchBox,
                                              @Param("offset") int offset, @Param("size") int size);

    @Select("""
                SELECT COUNT(*)
                FROM MESSAGE
                WHERE RECEIVER = #{receiverNo}
                AND DEL_YN = 'N'
            """)
    int getTotalReceiveCount(String receiverNo);

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
                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'N'
                ORDER BY M.SEND_TIME DESC
                OFFSET #{offset} ROWS FETCH NEXT #{size} ROWS ONLY
            """)
    List<MessageVo> messageReceiveListData(String receiverNo, int offset, int size);

    @Select("""
                <script>
                SELECT COUNT(*)
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'N'
                AND
                <choose>
                    <when test='empCategory == "senderDeptName"'>
                        SENDER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderDivName"'>
                        SENDER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderPositionName"'>
                        SENDER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderName"'>
                        SENDER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    int getSearchTotalReceiveCount(String receiverNo, String empCategory, String searchBox);

    @Select("""
                <script>
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , SENDER_EMP.NAME AS SENDER_NAME
                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'N'
                AND
                <choose>
                    <when test='empCategory == "senderDeptName"'>
                        SENDER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderDivName"'>
                        SENDER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderPositionName"'>
                        SENDER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderName"'>
                        SENDER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    List<MessageVo> messageReceiveListSearchData(String receiverNo, @Param("empCategory") String empCategory, @Param("searchBox") String searchBox,
                                                 @Param("offset") int offset, @Param("size") int size);

    @Select("""
                SELECT
                M.NO
                , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                , M.TITLE
                , M.CONTENT
                , M.SENDER
                , M.RECEIVER
                , M.READ_YN
                , M.DEL_YN
                , SENDER_EMP.NAME AS SENDER_NAME
                , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                , SENDER_DIV.NAME AS SENDER_DIV_NAME
                , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                , RECEIVER_EMP.NAME AS RECEIVER_NAME
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
                WHERE M.NO = #{no}
            """)
    MessageVo messageDetailData(String no);

    @Update("""
            UPDATE MESSAGE
            SET READ_YN = 'Y'
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    void updateMessageReadYn(String no);

    @Update("""
            UPDATE MESSAGE
            SET DEL_YN = 'Y'
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    int updateReceiveMsgDelYn(String no);

    @Update("""
            UPDATE MESSAGE
            SET DEL_YN = 'Y'
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    void updateSendMsgDelYn(String no);

    @Select("""
                SELECT COUNT(*)
                FROM MESSAGE
                WHERE RECEIVER = #{receiverNo}
                AND DEL_YN = 'Y'
            """)
    int getTotalReceiveDeleteCount(String receiverNo);

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
                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'Y'
                ORDER BY M.SEND_TIME DESC
                OFFSET #{offset} ROWS FETCH NEXT #{size} ROWS ONLY
            """)
    List<MessageVo> messageReceiveDeleteListData(String receiverNo, int offset, int size);

    @Select("""
                <script>
                SELECT COUNT(*)
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'Y'
                AND
                <choose>
                    <when test='empCategory == "senderDeptName"'>
                        SENDER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderDivName"'>
                        SENDER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderPositionName"'>
                        SENDER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderName"'>
                        SENDER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    int getSearchTotalReceiveDeleteCount(String receiverNo, String empCategory, String searchBox);

    @Select("""
                <script>
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , SENDER_EMP.NAME AS SENDER_NAME
                    , SENDER_DEPT.NAME AS SENDER_DEPT_NAME
                    , SENDER_DIV.NAME AS SENDER_DIV_NAME
                    , SENDER_POSITION.NAME AS SENDER_POSITION_NAME
                FROM MESSAGE M
                JOIN EMPLOYEE SENDER_EMP ON M.SENDER = SENDER_EMP.NO
                JOIN DEPARTMENT SENDER_DEPT ON SENDER_EMP.DEPT_CODE = SENDER_DEPT.CODE
                JOIN DIVISION SENDER_DIV ON SENDER_EMP.DIV_CODE = SENDER_DIV.CODE
                JOIN POSITION SENDER_POSITION ON SENDER_EMP.POSITION_CODE = SENDER_POSITION.CODE
                JOIN EMPLOYEE RECEIVER_EMP ON M.RECEIVER = RECEIVER_EMP.NO
                JOIN DEPARTMENT RECEIVER_DEPT ON RECEIVER_EMP.DEPT_CODE = RECEIVER_DEPT.CODE
                JOIN DIVISION RECEIVER_DIV ON RECEIVER_EMP.DIV_CODE = RECEIVER_DIV.CODE
                JOIN POSITION RECEIVER_POSITION ON RECEIVER_EMP.POSITION_CODE = RECEIVER_POSITION.CODE
                WHERE M.RECEIVER = #{receiverNo}
                AND DEL_YN = 'Y'
                AND
                <choose>
                    <when test='empCategory == "senderDeptName"'>
                        SENDER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderDivName"'>
                        SENDER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderPositionName"'>
                        SENDER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "senderName"'>
                        SENDER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    List<MessageVo> messageReceiveDeleteListSearchData(String receiverNo, String empCategory, String searchBox, int page, int offset);

    @Select("""
                SELECT COUNT(*)
                FROM MESSAGE
                WHERE SENDER = #{senderNo}
                AND DEL_YN = 'Y'
            """)
    int getTotalSendDeleteCount(String senderNo);

    @Select("""
                <script>
                SELECT COUNT(*)
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
                AND DEL_YN = 'Y'
                AND
                <choose>
                    <when test='empCategory == "receiverDeptName"'>
                        RECEIVER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverDivName"'>
                        RECEIVER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverPositionName"'>
                        RECEIVER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverName"'>
                        RECEIVER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    int getSearchTotalSendDeleteCount(String senderNo, String empCategory, String searchBox);

    @Select("""
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
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
                AND DEL_YN = 'Y'
                ORDER BY M.SEND_TIME DESC
                OFFSET #{offset} ROWS FETCH NEXT #{size} ROWS ONLY
            """)
    List<MessageVo> messageSendDeleteListData(String senderNo, int offset, int size);

    @Select("""
                <script>
                SELECT
                    M.NO
                    , TO_CHAR(M.SEND_TIME, 'YYYY/MM/DD HH24:MI') AS SEND_TIME
                    , M.TITLE
                    , M.SENDER
                    , M.RECEIVER
                    , M.READ_YN
                    , M.DEL_YN
                    , RECEIVER_EMP.NAME AS RECEIVER_NAME
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
                AND DEL_YN = 'Y'
                AND
                <choose>
                    <when test='empCategory == "receiverDeptName"'>
                        RECEIVER_DEPT.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverDivName"'>
                        RECEIVER_DIV.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverPositionName"'>
                        RECEIVER_POSITION.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                    <when test='empCategory == "receiverName"'>
                        RECEIVER_EMP.NAME LIKE '%' || #{searchBox} || '%'
                    </when>
                </choose>
                ORDER BY M.SEND_TIME DESC
                </script>
            """)
    List<MessageVo> messageSendDeleteListSearchData(String senderNo, String empCategory, String searchBox, int offset, int size);

    @Update("""
            UPDATE MESSAGE
            SET DEL_YN = 'N'
            WHERE NO = #{no}
            AND DEL_YN = 'Y'
            """)
    int updateReceiveMsgRecover(String no);

    @Update("""
            UPDATE MESSAGE
            SET DEL_YN = 'N'
            WHERE NO = #{no}
            AND DEL_YN = 'Y'
            """)
    int updateSendMsgRecover(String no);
}
