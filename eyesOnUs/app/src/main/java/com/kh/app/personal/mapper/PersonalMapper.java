package com.kh.app.personal.mapper;

import com.kh.app.personal.vo.PersonalVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonalMapper {

    @Select("SELECT pw.NO,\n" +
            "       pw.NO2,\n" +
            "       sb.CONTENT AS STATE_B_CONTENT,\n" +
            "       wt.NAME AS WORK_TYPE_NAME,\n" +
            "       pw.START_DATE,\n" +
            "       pw.TITLE,\n" +
            "       pw.CONTENT\n" +
            "FROM PERSONAL_WORK pw\n" +
            "JOIN STATE_B sb ON pw.STATE_B_NO = sb.NO\n" +
            "JOIN WORK_TYPE wt ON pw.TYPE_NO = wt.NO\n" +
            "ORDER BY pw.NO DESC")
    List<PersonalVo> getPersonalList();

    @Insert("INSERT INTO PERSONAL_WORK (NO,NO2,STATE_B_NO,TYPE_NO,START_DATE,TITLE,CONTENT)\n" +
            "VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
    int getPersonalWrite(PersonalVo vo);

    @Delete("DELETE FROM PERSONAL_WORK WHERE NO = #{num}")
    int personalDelete(@Param("num") String num);


}//class
