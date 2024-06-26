package com.kh.app.personal.mapper;

import com.kh.app.personal.vo.PersonalVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalMapper {

//    @Insert("INSERT INTO PERSONAL_WORK " +
//            "    (NO, NO2, STATE_B_NO, TYPE_NO, START_DATE, TITLE, CONTENT) \n" +
//            "    VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
//    int write(PersonalVo vo);
//
//
//    @Insert("INSERT INTO PERSONAL_WORK " +
//            "    (NO, NO2, STATE_B_NO, TYPE_NO, START_DATE, TITLE, CONTENT) \n" +
//            "    VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
//    void insertPersonal(PersonalVo vo);

    @Insert("INSERT INTO PERSONAL_WORK " +
            "(NO, NO2, STATE_B_NO, TYPE_NO, START_DATE, TITLE, CONTENT) " +
            "VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
    int write(PersonalVo vo);

    @Insert("INSERT INTO PERSONAL_WORK " +
            "(NO, NO2, STATE_B_NO, TYPE_NO, START_DATE, TITLE, CONTENT) " +
            "VALUES (SEQ_PERSONAL_WORK.NEXTVAL, #{no2}, #{stateBNo}, #{typeNo}, SYSDATE, #{title}, #{content})")
    void insertPersonal(PersonalVo vo);
}
