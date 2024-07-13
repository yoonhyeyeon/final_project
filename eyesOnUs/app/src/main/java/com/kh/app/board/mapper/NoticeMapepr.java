package com.kh.app.board.mapper;

import com.kh.app.board.vo.NoticeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapepr {

    // 작성하기
    @Insert("""
            INSERT INTO NOTICE_BOARD(
                NO
                , WRITER_NO
                , TITLE
                , CONTENT
                , ENROLL_DATE
            )
            VALUES (
                SEQ_NOTICE_BOARD.NEXTVAL
                , 0
                , #{title}
                , #{content}
                , SYSDATE
            )
            """)
    int write(NoticeVo vo);

    // 목록조회
    @Select("""
            SELECT\s
                N.NO
                , E.NAME AS WRITER_NO
                , N.TITLE
                , N.CONTENT
                , N.HIT
                , N.ENROLL_DATE
            FROM NOTICE_BOARD N
            JOIN EMPLOYEE E
            ON N.WRITER_NO = E.NO
            ORDER BY N.NO DESC
            """)
    List<NoticeVo> listData();

}

