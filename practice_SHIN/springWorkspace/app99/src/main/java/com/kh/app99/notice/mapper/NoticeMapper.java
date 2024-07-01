package com.kh.app99.notice.mapper;

import com.kh.app99.notice.vo.NoticeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT * FROM NOTICE ORDER BY NO DESC")
    List<NoticeVo> getNoticeList();

    @Select("SELECT * FROM NOTICE WHERE NO = #{num}")
    NoticeVo getNoticeByNo(String num);

    @Insert("INSERT INTO NOTICE(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_NOTICE.NEXTVAL, #{title} , #{content} , #{writerNo})")
    int write(NoticeVo vo);

    @Update("UPDATE NOTICE SET TITLE = #{title} , CONTENT = #{content} WHERE NO = #{no}")
    int edit(NoticeVo vo);

    @Delete("DELETE NOTICE WHERE NO = #{num}")
    int delete(String num);
}
