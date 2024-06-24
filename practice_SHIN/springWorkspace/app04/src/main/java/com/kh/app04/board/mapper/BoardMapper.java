package com.kh.app04.board.mapper;

import com.kh.app04.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    @Insert("INSERT INTO BOARD (NO , TITLE , CONTENT) VALUES (SEQ_BOARD.NEXTVAL , #{title}, #{content})")
    int write(BoardVo vo);

    @Select("SELECT * FROM BOARD")
    List<BoardVo> getBoardList();
    
    @Select({
            "<script>"
            ,"SELECT *"
            ,"FROM BOARD"
            , "<if test='m.stype != null'>"
            ,"WHERE ${m.stype}"
            ,"LIKE '%${m.svalue}%' "
            , "</if>"
            ,"</script>"
    })
    List<BoardVo> searchBoardList(@Param("m") Map<String, String> paramMap);


}
