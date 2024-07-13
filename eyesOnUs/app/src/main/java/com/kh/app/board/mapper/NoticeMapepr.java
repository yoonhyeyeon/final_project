package com.kh.app.board.mapper;

import com.kh.app.board.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapepr {


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
            """)
    List<NoticeVo> listData();

}

