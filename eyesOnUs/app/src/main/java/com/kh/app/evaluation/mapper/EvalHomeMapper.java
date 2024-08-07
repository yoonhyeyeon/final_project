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
    @Select("""
            SELECT
                E.NO
                , E.NAME
                , D.NAME AS DEPT
                , V.NAME AS DIVISION
                , P.NAME AS POSITION
            FROM EMPLOYEE E
            JOIN DEPARTMENT D
            ON E.DEPT_CODE = D.CODE
            JOIN DIVISION V
            ON E.DIV_CODE = V.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            WHERE E.DEPT_CODE =
            (SELECT\s
                DEPT_CODE
            FROM EMPLOYEE
            WHERE NO = #{no})
            AND E.POSITION_CODE = 40
            AND (NO NOT IN #{no})
            """)
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

    // 남은 사원 목록
    @Select("""
            SELECT
                E.NO
                , E.NAME
                , P.NAME AS POSITION
            FROM EMPLOYEE E
            JOIN DEPARTMENT D
            ON E.DEPT_CODE = D.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            WHERE (E.DEPT_CODE =\s
            (SELECT\s
                DEPT_CODE
            FROM EMPLOYEE
            WHERE NO = #{no})
            OR E.DIV_CODE =\s
            (SELECT
                DIV_CODE
            FROM EMPLOYEE
            WHERE NO = #{no}))
            AND E.NO != #{no}
            AND E.NO NOT IN (
                SELECT EVALUATEE_NO FROM LEADER_EVAL WHERE EVALUATOR_NO = #{no}
                UNION
                SELECT EVALUATEE_NO FROM MEMBER_EVAL WHERE EVALUATOR_NO = #{no}
                UNION
                SELECT EVALUATEE_NO FROM COLLEAGE_EVAL WHERE EVALUATOR_NO = #{no}
            )
            """)
    List<EvalHomeVo> list2(String no);
}
