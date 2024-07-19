package com.kh.app.project.mapper;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.project.vo.ProjectManagerVo;
import com.kh.app.project.vo.ProjectRecordVo;
import com.kh.app.project.vo.ProjectVo;
import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("INSERT INTO PROJECT(NO,TITLE,CODE,EMP_NO,STATE_A_NO,CONTENT) VALUES(SEQ_PROJECT.NEXTVAL,#{title},#{code},#{empNo},#{stateANo},#{content})")
    int insertProject(ProjectVo vo);

    @Update("UPDATE PROJECT SET CONTENT = #{content},STATE_A_NO = #{stateANo}, MODIFY_DATE = CURRENT_TIMESTAMP WHERE NO = #{no}")
    int modifyPrj(ProjectVo vo);

    @Select("SELECT P.NO as NO,P.CODE as CODE, P.EMP_NO AS EMPNO, P.STATE_A_NO as STATEANO,\n" +
            "TO_CHAR(P.START_DATE,'YYYY.MM.DD') as STARTDATE, TO_CHAR(P.END_DATE,'YYYY.MM.DD')as ENDDATE,TO_CHAR(P.MODIFY_DATE,'YYYY.MM.DD') as MODIFYDATE,\n" +
            "P.title as title,E.NAME as PM, D.NAME as DEPT,S.CONTENT as STATE, P.CONTENT AS CONTENT\n" +
            "FROM PROJECT P\n" +
            "JOIN STATE_A S\n" +
            "ON P.STATE_A_NO = S.NO\n" +
            "JOIN EMPLOYEE E\n" +
            "ON P.EMP_NO = E.NO\n" +
            "JOIN DEPARTMENT D\n" +
            "ON P.CODE = D.CODE\n" +
            "WHERE P.CODE = #{code}\n" +
            "ORDER BY P.NO ASC")
            List<ProjectVo> projectList(String deptCode);


    @Delete("DELETE PROJECT WHERE NO = #{no}")
    int deletePrj(String no);

    @Select("""
            SELECT P.NO as NO,P.title as title,P.EMP_NO as empNo, E.NAME as PM, D.NAME as DEPT,S.CONTENT as STATE, P.CONTENT AS CONTENT
                        ,TO_CHAR(P.MODIFY_DATE,'YYYY.MM.DD')  as modifyDate , P.START_DATE as startDate
                        FROM PROJECT P
                        JOIN STATE_A S
                        ON P.STATE_A_NO = S.NO
                        JOIN EMPLOYEE E
                        ON P.EMP_NO = E.NO
                        JOIN DEPARTMENT D
                        ON P.CODE = D.CODE
                        WHERE P.NO = #{no}                       
            """)
    ProjectVo getProjectByNo(String no);

    @Select("SELECT P.NO as NO, P.title as title, E.NAME as PM, D.NAME as DEPT,S.CONTENT as STATE, P.CONTENT AS CONTENT \n" +
            ",TO_CHAR(P.MODIFY_DATE,'YYYY.MM.DD')  as modifyDate , P.START_DATE as startDate\n" +
            "FROM PROJECT P\n" +
            "JOIN STATE_A S\n" +
            "ON P.STATE_A_NO = S.NO\n" +
            "JOIN EMPLOYEE E\n" +
            "ON P.EMP_NO = E.NO\n" +
            "JOIN DEPARTMENT D\n" +
            "ON P.CODE = D.CODE\n" +
            "WHERE P.TITLE LIKE '%' || #{title} || '%'")
    List<ProjectVo> projectSearchByName(String title);

    @Select("SELECT NO, CODE, EMP_NO, STATE_A_NO, TITLE, CONTENT,\n" +
            "        startDate,endDate,modifyDate\n" +
            "FROM (\n" +
            "    SELECT NO, CODE, EMP_NO, STATE_A_NO, TITLE, CONTENT,\n" +
            "           TO_CHAR(START_DATE, 'YYYY/MM/DD') AS startDate,\n" +
            "           TO_CHAR(END_DATE, 'YYYY/MM/DD') AS endDate,\n" +
            "           TO_CHAR(MODIFY_DATE, 'YYYY/MM/DD') AS modifyDate,\n" +
            "           ROW_NUMBER() OVER (ORDER BY NO ASC) AS rnum\n" +
            "    FROM PROJECT\n" +
            "    WHERE STATE_A_NO = 1\n" +
            "      AND CODE = #{code}\n" +
            ")\n" +
            "WHERE rnum <= 5\n" +
            "ORDER BY NO ASC")
    List<ProjectVo> listData2(ProjectVo vo);

    @Select("SELECT NO, CODE, EMP_NO, STATE_A_NO, TITLE, CONTENT,\n" +
            "        startDate,endDate,modifyDate\n" +
            "FROM (\n" +
            "    SELECT NO, CODE, EMP_NO, STATE_A_NO, TITLE, CONTENT,\n" +
            "           TO_CHAR(START_DATE, 'YYYY/MM/DD') AS startDate,\n" +
            "           TO_CHAR(END_DATE, 'YYYY/MM/DD') AS endDate,\n" +
            "           TO_CHAR(MODIFY_DATE, 'YYYY/MM/DD') AS modifyDate,\n" +
            "           ROW_NUMBER() OVER (ORDER BY NO ASC) AS rnum\n" +
            "    FROM PROJECT\n" +
            "    WHERE STATE_A_NO = 2\n" +
            "      AND CODE = #{code}\n" +
            ")\n" +
            "WHERE rnum <= 5\n" +
            "ORDER BY NO ASC")
    List<ProjectVo> listData3(ProjectVo vo);


    ////////////////////////PROJECT RECORD CRUD ///////////////////////////////////////

    @Insert("INSERT INTO CONFERENCE_RECORD(NO,PRJ_NO,TITLE,CONTENT) VALUES(SEQ_CONFERENCE_RECORD.NEXTVAL,#{prjNo},#{title},#{content})")
    int recordInsert(ProjectRecordVo vo);

    @Select("SELECT * FROM CONFERENCE_RECORD WHERE DEL_YN ='N' ORDER BY PRJ_NO ASC")
    List<ProjectRecordVo> recordList();


    @Select("""
            SELECT\s
                C.NO as no
                ,C.PRJ_NO as prjNo\s
                , E.NO as empNo
                , E.NAME as name
                , C.TITLE as title
                , C.CONTENT as content
                , C.ENL_DATE as enlDate
            FROM CONFERENCE_RECORD C
            JOIN PROJECT P
            ON C.PRJ_NO = P.NO
            JOIN EMPLOYEE E
            ON E.NO = P.EMP_NO
            WHERE C.NO = #{no}
            """)
    ProjectRecordVo recordDetail(String no);

///////////////////////////////////// PROJECT_MANAGER CRUD ///////////////////////////////////////////////////////////

    @Insert("INSERT INTO PROJECT_MANAGER(NO,PRO_NO,EMP_NO) VALUES(SEQ_PROJECT_MANAGER.NEXTVAL,#{proNo},#{empNo})")
    int managerInsert(ProjectManagerVo vo);


    @Select("SELECT M.NO as NO, M.PRO_NO as PRONO, M.EMP_NO as EMPNO, E.NAME as NAME  FROM\n" +
            "PROJECT_MANAGER M\n" +
            "JOIN EMPLOYEE E\n" +
            "ON M.EMP_NO = E.NO\n" +
    "ORDER BY M.PRO_NO ASC")
    List<ProjectManagerVo> managerList();

    @Delete("DELETE PROJECT_MANAGER WHERE NO = #{no}")
    int managerDelete(String no);

    @Delete("DELETE CONFERENCE_RECORD WHERE NO = #{no}")
    int recordDelete(String no);

    @Select("""
           SELECT D.NAME as deptName, E.NAME as name, P.NAME as positionName, E.NO as NO, A.NAME as STATE
           FROM EMPLOYEE E
           JOIN DEPARTMENT D
           ON E.DEPT_CODE = D.CODE
           JOIN POSITION P
           ON P.CODE = E.POSITION_CODE
           JOIN ATTEND A
           ON E.STATE = A.STATE
           WHERE E.DEPT_CODE = #{deptCode}
           """
    )
    List<EmployeeVo> deptListByNo(String deptCode);


    @Select("""
            SELECT P.NO as no, E.NAME as pm, M.EMP_NO as empNo
            FROM PROJECT_MANAGER M
            JOIN EMPLOYEE E
            ON M.EMP_NO = E.NO
            JOIN PROJECT P
            ON P.NO = M.PRO_NO
            WHERE P.NO = #{no}
            """)
    List<ProjectVo> getsPmByNo(String no);

    @Select("""
            SELECT NO,NAME
            FROM EMPLOYEE
            WHERE DEPT_CODE = #{deptCode} AND RANK > 20
            ORDER BY NO ASC                      
            """)
    List<MemberVo> empListBydeptCode(String deptCode);
}



/*
SELECT M.NO as NO, M.PRO_NO as PRONO, M.EMP_NO as EMPNO, E.NAME as NAME,P.emp_NO as pmNo FROM
PROJECT_MANAGER M
JOIN EMPLOYEE E
ON M.EMP_NO = E.NO
JOIN PROJECT P
ON P.NO = M.PRO_NO
JOIN EMPLOYEE EE
ON P.EMP_NO = EE.NO
WHERE P.emp_NO = 11
ORDER BY M.PRO_NO ASC*/
