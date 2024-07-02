package com.kh.app.personal.mapper;

import com.kh.app.personal.vo.PersonalVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalMapper {

    @Select("SELECT * FROM PERSONAL_WORK ORDER BY NO DESC")
    List<PersonalVo> getPersonalList();
}//class
