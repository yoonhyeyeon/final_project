package com.kh.app99.board.mapper;

import com.kh.app99.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD.NEXTVAL,#{title},#{content},#{writerNo})")
    int write(BoardVo vo);

    @Select("SELECT * FROM BOARD WHERE NO = #{num}")
    BoardVo getBoardByNo(String num);

    @Update("DELETE BOARD WHERE NO = #{num}")
    int deleteBoardByNo(String num);
}
