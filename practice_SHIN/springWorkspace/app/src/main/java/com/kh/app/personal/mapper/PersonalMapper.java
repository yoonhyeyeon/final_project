package com.kh.app.personal.mapper;

import com.kh.app.personal.vo.PersonalVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonalMapper {

    @Select("SELECT * FROM PERSONAL_WORK ORDER BY NO DESC")
    List<PersonalVo> getPersonalList();

    @Insert("INSERT INTO PERSONAL_WORK (NO,NO2,STATE_B_NO,TYPE_NO,START_DATE,TITLE,CONTENT)\n" +
            "VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
    int getPersonalWrite(PersonalVo vo);


    @Update("UPDATE PERSONAL_WORK SET STATE_B_NO = #{stateBNo}, TYPE_NO = #{typeNo}, TITLE = #{title} , CONTENT = #{content}, MODIFY_DATE = SYSDATE WHERE NO2 = #{no2}")
    int personalEdit(PersonalVo vo);

}//class
