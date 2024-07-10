package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.EvalHomeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvalHomeMapper {

    // 평가해야 될 모든 사람들 목록 조회
    @Select("SELECT\n" +
            "    E.NO\n" +
            "    , E.NAME\n" +
            "    , D.NAME AS DEPT\n" +
            "    , V.NAME AS DIVISION\n" +
            "    , P.NAME AS POSITION\n" +
            "FROM EMPLOYEE E\n" +
            "JOIN DEPARTMENT D\n" +
            "ON E.DEPT_CODE = D.CODE\n" +
            "JOIN DIVISION V\n" +
            "ON E.DIV_CODE = V.CODE\n" +
            "JOIN POSITION P\n" +
            "ON E.POSITION_CODE = P.CODE\n" +
            "WHERE (E.DEPT_CODE = \n" +
            "(SELECT \n" +
            "    DEPT_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no})\n" +
            "OR E.DIV_CODE = \n" +
            "(SELECT\n" +
            "    DIV_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no}))\n" +
            "AND NO NOT IN #{no}")
    List<EvalHomeVo> list(String no);

    // 팀장 조회
    @Select("SELECT\n" +
            "    E.NO\n" +
            "    , E.NAME\n" +
            "    , D.NAME AS DEPT\n" +
            "    , V.NAME AS DIVISION\n" +
            "    , P.NAME AS POSITION\n" +
            "FROM EMPLOYEE E\n" +
            "JOIN DEPARTMENT D\n" +
            "ON E.DEPT_CODE = D.CODE\n" +
            "JOIN DIVISION V\n" +
            "ON E.DIV_CODE = V.CODE\n" +
            "JOIN POSITION P\n" +
            "ON E.POSITION_CODE = P.CODE\n" +
            "WHERE E.DEPT_CODE = \n" +
            "(SELECT \n" +
            "    DEPT_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no})\n" +
            "AND E.POSITION_CODE = 40")
    List<EvalHomeVo> leader(String no);

    // 팀원
    @Select("SELECT\n" +
            "    E.NO\n" +
            "    , E.NAME\n" +
            "    , D.NAME AS DEPT\n" +
            "    , V.NAME AS DIVISION\n" +
            "    , P.NAME AS POSITION\n" +
            "FROM EMPLOYEE E\n" +
            "JOIN DEPARTMENT D\n" +
            "ON E.DEPT_CODE = D.CODE\n" +
            "JOIN DIVISION V\n" +
            "ON E.DIV_CODE = V.CODE\n" +
            "JOIN POSITION P\n" +
            "ON E.POSITION_CODE = P.CODE\n" +
            "WHERE DIV_CODE = (\n" +
            "SELECT\n" +
            "    DIV_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = ${no}\n" +
            ")\n" +
            "AND (NO NOT IN ${no} AND POSITION_CODE NOT IN 40)")
    List<EvalHomeVo> memberEval(String no);

    // 동료
    @Select("SELECT\n" +
            "    E.NO\n" +
            "    , E.NAME\n" +
            "    , D.NAME AS DEPT\n" +
            "    , V.NAME AS DIVISION\n" +
            "    , P.NAME AS POSITION\n" +
            "FROM EMPLOYEE E\n" +
            "JOIN DEPARTMENT D\n" +
            "ON E.DEPT_CODE = D.CODE\n" +
            "JOIN DIVISION V\n" +
            "ON E.DIV_CODE = V.CODE\n" +
            "JOIN POSITION P\n" +
            "ON E.POSITION_CODE = P.CODE\n" +
            "WHERE E.DEPT_CODE = (\n" +
            "SELECT\n" +
            "    DEPT_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no}\n" +
            ")\n" +
            "AND POSITION_CODE IN (50,60,70,80,90)\n" +
            "AND NO NOT IN #{no}")
    List<EvalHomeVo> colleage(String no);
}
