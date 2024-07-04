package com.kh.app.sign.mapper;

import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SignMapper {

    // 결재 신청 (SIGN)
    @Insert("INSERT INTO SIGN(\n" +
            "   NO, EMP_NO\n" +
            "   , TITLE, CONTENT\n" +
            ")\n" +
            "VALUES(\n" +
            "   SEQ_SIGN.NEXTVAL, #{empNo}\n" +
            "   , #{title}, #{content}\n" +
            ")")
    int signWrite(SignVo vo);

    // 결재 신청 (SIGN_FILE)
    @Insert("INSERT INTO SIGN_FILE(\n" +
            "   NO, SIGN_NO, CHANGE_NAME, ORIGIN_NAME, \"SIZE\"\n" +
            ")\n" +
            "VALUES(\n" +
            "   SEQ_SIGN_FILE.NEXTVAL, SEQ_SIGN.CURRVAL, #{changeName}, #{originName}, #{size}\n" +
            ")"
    )
    int signFileWrite(SignVo vo);

    // 결재 신청 (SIGN_PATH)
    @Insert("INSERT INTO SIGN_PATH(\n" +
            "   NO, SIGN_NO\n" +
            "   , APPROVER_NO, SIGN_SEQ\n" +
            ")\n" +
            "VALUES(\n" +
            "   SEQ_SIGN_PATH.NEXTVAL, SEQ_SIGN.CURRVAL\n" +
            "   , #{approver}, #{signSeq}\n" +
            ")")
    int signPathWrite(@RequestParam("approver") String approver, @RequestParam("signSeq") int signSeq);

    // 결재 신청 (SIGN_REF)
    @Insert("INSERT INTO SIGN_REF(\n" +
            "   NO, SIGN_NO, REF_NO\n" +
            ")\n" +
            "VALUES(\n" +
            "   SEQ_SIGN_REF.NEXTVAL, SEQ_SIGN.CURRVAL, #{ref}\n" +
            ")")
    int signRefWrite(@RequestParam("ref") String ref);

    // 직원 전체 목록 조회 (API)
    @Select("SELECT\n" +
            "    ROWNUM\n" +
            "    , Y.NO\n" +
            "    , Y.DEPT_CODE\n" +
            "    , Y.DIV_CODE\n" +
            "    , Y.POSITION_CODE\n" +
            "    , Y.STATE\n" +
            "    , Y.SALARY_CODE\n" +
            "    , Y.RANK\n" +
            "    , Y.SALARY\n" +
            "    , Y.BONUS\n" +
            "    , Y.ID\n" +
            "    , Y.PWD\n" +
            "    , Y.NICK\n" +
            "    , Y.NAME\n" +
            "    , Y.PHONE\n" +
            "    , Y.ADDRESS\n" +
            "    , Y.PROFILE\n" +
            "    , Y.ENROLL_DATE\n" +
            "    , Y.RETIRE_DATE\n" +
            "    , Y.RETIRE_YN\n" +
            "    , Y.POSITION_NAME\n" +
            "    , Y.DIV_NAME\n" +
            "    , Y.DEPT_NAME\n" +
            "FROM\n" +
            "(\n" +
            "    SELECT\n" +
            "        E.NO\n" +
            "        , E.DEPT_CODE\n" +
            "        , E.DIV_CODE\n" +
            "        , E.POSITION_CODE\n" +
            "        , E.STATE\n" +
            "        , E.SALARY_CODE\n" +
            "        , E.RANK\n" +
            "        , E.SALARY\n" +
            "        , E.BONUS\n" +
            "        , E.ID\n" +
            "        , E.PWD\n" +
            "        , E.NICK\n" +
            "        , E.NAME\n" +
            "        , E.PHONE\n" +
            "        , E.ADDRESS\n" +
            "        , E.PROFILE\n" +
            "        , E.ENROLL_DATE\n" +
            "        , E.RETIRE_DATE\n" +
            "        , E.RETIRE_YN\n" +
            "        , P.NAME            POSITION_NAME\n" +
            "        , D.NAME            DIV_NAME\n" +
            "        , T.NAME            DEPT_NAME\n" +
            "    FROM EMPLOYEE E\n" +
            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "    ORDER BY E.POSITION_CODE ASC\n" +
            ") Y")
    List<EmployeeVo> getEmployeeList();

    // 결재 (API)
    @Update("")
    int updateSignApprove(SignVo signVo);

    // 결재 상세 조회 (API)
    @Select("")
    SignVo getSignDetail(String signNo);

    // 결재자 상세 조회 (API)
    @Select("")
    SignVo getSignApproverDetail(String signNo);

    // 결재자 목록 조회 (API)
    @Select("")
    List<SignVo> getSignApproverList(String empNo);

    // 결재 목록 조회 (신청자 입장) (동적 쿼리) (API)
    @Select({
            "<script>",
                "SELECT",
                    "ROWNUM",
                    ", Y.NO",
                    ", Y.EMP_NO",
                    ", Y.RESULT",
                    ", Y.STEP",
                    ", Y.TITLE",
                    ", Y.CONTENT",
                    ", Y.ENROLL_DATE",
                    ", Y.CHANGE_NAME",
                    ", Y.ORIGIN_NAME",
                    ", Y.\"SIZE\"",
                    ", Y.MODIFY_DATE",
                    ", Y.EMP_NAME",
                    ", Y.NICK",
                    ", Y.POSITION_CODE",
                    ", Y.POSITION_NAME",
                    ", Y.DIV_CODE",
                    ", Y.DIV_NAME",
                    ", Y.DEPT_CODE",
                    ", Y.DEPT_NAME",
                "FROM",
                "(",
                    "SELECT",
                        "S.NO",
                        ", S.EMP_NO",
                        ", S.RESULT",
                        ", S.STEP",
                        ", S.TITLE",
                        ", S.CONTENT",
                        ", S.ENROLL_DATE",
                        ", F.CHANGE_NAME",
                        ", F.ORIGIN_NAME",
                        ", F.\"SIZE\"",
                        ", F.MODIFY_DATE",
                        ", E.NAME EMP_NAME",
                        ", E.NICK",
                        ", P.CODE POSITION_CODE",
                        ", P.NAME POSITION_NAME",
                        ", D.CODE DIV_CODE",
                        ", D.NAME DIV_NAME",
                        ", T.CODE DEPT_CODE",
                        ", T.NAME DEPT_NAME",
                    "FROM SIGN S",
                    "JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)",
                    "JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)",
                    "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)",
                    "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)",
                    "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)",
                    "WHERE S.EMP_NO = #{empNo}",

                    "<if test='result != null'>",
                        "AND S.RESULT = #{result}",
                    "</if>",

                    "<if test='step != null'>",
                        "AND S.STEP = #{step}",
                    "</if>",

                    "ORDER BY S.NO DESC",
                ") Y",
            "</script>"
    })
    List<SignVo> getVoListDynamic(SignVo signVo);

    // 결재 목록 조회 (결재자 입장) (동적 쿼리) (API)
    @Select({
            "<script>",
                "SELECT",
                    "ROWNUM",
                    ", Y.NO",
                    ", Y.SIGN_NO",
                    ", Y.APPROVER_NO",
                    ", Y.SIGN_SEQ",
                    ", Y.EMP_NO",
                    ", Y.RESULT",
                    ", Y.STEP",
                    ", Y.TITLE",
                    ", Y.CONTENT",
                    ", Y.ENROLL_DATE",
                    ", Y.CHANGE_NAME",
                    ", Y.ORIGIN_NAME",
                    ", Y.\"SIZE\"",
                    ", Y.MODIFY_DATE",
                    ", Y.EMP_NAME",
                    ", Y.NICK",
                    ", Y.POSITION_CODE",
                    ", Y.POSITION_NAME",
                    ", Y.DIV_CODE",
                    ", Y.DIV_NAME",
                    ", Y.DEPT_CODE",
                    ", Y.DEPT_NAME",
                "FROM",
                "(",
                    "SELECT",
                        "P.NO",
                        ", P.SIGN_NO",
                        ", P.APPROVER_NO",
                        ", P.SIGN_SEQ",
                        ", S.EMP_NO",
                        ", S.RESULT",
                        ", S.STEP",
                        ", S.TITLE",
                        ", S.CONTENT",
                        ", S.ENROLL_DATE",
                        ", F.CHANGE_NAME",
                        ", F.ORIGIN_NAME",
                        ", F.\"SIZE\"",
                        ", F.MODIFY_DATE",
                        ", E.NAME EMP_NAME",
                        ", E.NICK",
                        ", O.CODE POSITION_CODE",
                        ", O.NAME POSITION_NAME",
                        ", D.CODE DIV_CODE",
                        ", D.NAME DIV_NAME",
                        ", T.CODE DEPT_CODE",
                        ", T.NAME DEPT_NAME",
                    "FROM SIGN_PATH P",
                    "JOIN SIGN S ON (P.SIGN_NO = S.NO)",
                    "JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)",
                    "JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)",
                    "JOIN POSITION O ON (E.POSITION_CODE = O.CODE)",
                    "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)",
                    "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)",
                    "WHERE P.APPROVER_NO = #{approverNo[0]}",

                    "<if test='result != null'>",
                        "AND S.RESULT = #{result}",
                    "</if>",

                    "<if test='step != null'>",
                        "AND S.STEP = #{step}",
                    "</if>",

                    "ORDER BY S.NO DESC",
                ") Y",
            "</script>"
    })
    List<SignVo> getVoListDynamicForApprover(SignVo signVo);

    // 결재 목록 조회 (참조자 입장) (동적 쿼리) (API)
    @Select({
            "<script>",
                "SELECT",
                    "ROWNUM",
                    ", Y.NO",
                    ", Y.SIGN_NO",
                    ", Y.EMP_NO",
                    ", Y.RESULT",
                    ", Y.STEP",
                    ", Y.TITLE",
                    ", Y.CONTENT",
                    ", Y.ENROLL_DATE",
                    ", Y.CHANGE_NAME",
                    ", Y.ORIGIN_NAME",
                    ", Y.\"SIZE\"",
                    ", Y.MODIFY_DATE",
                    ", Y.EMP_NAME",
                    ", Y.NICK",
                    ", Y.POSITION_CODE",
                    ", Y.POSITION_NAME",
                    ", Y.DIV_CODE",
                    ", Y.DIV_NAME",
                    ", Y.DEPT_CODE",
                    ", Y.DEPT_NAME",
                "FROM",
                "(",
                    "SELECT",
                        "R.NO",
                        ", R.SIGN_NO",
                        ", R.REF_NO",
                        ", S.EMP_NO",
                        ", S.RESULT",
                        ", S.STEP",
                        ", S.TITLE",
                        ", S.CONTENT",
                        ", S.ENROLL_DATE",
                        ", F.CHANGE_NAME",
                        ", F.ORIGIN_NAME",
                        ", F.\"SIZE\"",
                        ", F.MODIFY_DATE",
                        ", E.NAME EMP_NAME",
                        ", E.NICK",
                        ", O.CODE POSITION_CODE",
                        ", O.NAME POSITION_NAME",
                        ", D.CODE DIV_CODE",
                        ", D.NAME DIV_NAME",
                        ", T.CODE DEPT_CODE",
                        ", T.NAME DEPT_NAME",
                    "FROM SIGN_REF R",
                    "JOIN SIGN S ON (R.SIGN_NO = S.NO)",
                    "JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)",
                    "JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)",
                    "JOIN POSITION O ON (E.POSITION_CODE = O.CODE)",
                    "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)",
                    "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)",
                    "WHERE R.REF_NO = #{refNo[0]}",

                    "<if test='result != null'>",
                        "AND S.RESULT = #{result}",
                    "</if>",

                    "<if test='step != null'>",
                        "AND S.STEP = #{step}",
                    "</if>",

                    "ORDER BY S.NO DESC",
                ") Y",
            "</script>"
    })
    List<SignVo> getVoListDynamicForReference(SignVo signVo);

//    // 결재 진행 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        S.NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN S\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE S.EMP_NO = #{empNo}\n" +
//            "    AND S.RESULT = 0\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignWaitList(@RequestParam("empNo") String empNo);
//
//    // 결재 완료 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        S.NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN S\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE S.EMP_NO = #{empNo}\n" +
//            "    AND S.RESULT = 1\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignApprovalList(@RequestParam("empNo") String empNo);
//
//    // 결재 반려 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        S.NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN S\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE S.EMP_NO = #{empNo}\n" +
//            "    AND S.RESULT = 2\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignReturnList(@RequestParam("empNo") String empNo);
//
//    // 결재 전체 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        S.NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN S\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE S.EMP_NO = #{empNo}\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignList(@RequestParam("empNo") String empNo);
//
//    // 결재 대기 목록 조회 (결재자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.SIGN_SEQ\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        P.NO\n" +
//            "        , P.SIGN_NO\n" +
//            "        , P.APPROVER_NO\n" +
//            "        , P.SIGN_SEQ\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_PATH P\n" +
//            "    JOIN SIGN S ON (P.SIGN_NO = S.NO)\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE P.APPROVER_NO = #{approverNo}\n" +
//            "    AND S.RESULT = 0\n" +
//            "    AND S.STEP = P.SIGN_SEQ\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getDoSignListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 결재 진행 목록 조회 (결재자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.SIGN_SEQ\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        P.NO\n" +
//            "        , P.SIGN_NO\n" +
//            "        , P.APPROVER_NO\n" +
//            "        , P.SIGN_SEQ\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_PATH P\n" +
//            "    JOIN SIGN S ON (P.SIGN_NO = S.NO)\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE P.APPROVER_NO = #{approverNo}\n" +
//            "    AND S.RESULT = 0\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignWaitListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 결재 완료 목록 조회 (결재자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.SIGN_SEQ\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        P.NO\n" +
//            "        , P.SIGN_NO\n" +
//            "        , P.APPROVER_NO\n" +
//            "        , P.SIGN_SEQ\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_PATH P\n" +
//            "    JOIN SIGN S ON (P.SIGN_NO = S.NO)\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE P.APPROVER_NO = #{approverNo}\n" +
//            "    AND S.RESULT = 1\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignApprovalListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 결재 반려 목록 조회 (결재자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.SIGN_SEQ\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        P.NO\n" +
//            "        , P.SIGN_NO\n" +
//            "        , P.APPROVER_NO\n" +
//            "        , P.SIGN_SEQ\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_PATH P\n" +
//            "    JOIN SIGN S ON (P.SIGN_NO = S.NO)\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE P.APPROVER_NO = #{approverNo}\n" +
//            "    AND S.RESULT = 2\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignReturnListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 결재 전체 목록 조회 (결재자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.SIGN_SEQ\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        P.NO\n" +
//            "        , P.SIGN_NO\n" +
//            "        , P.APPROVER_NO\n" +
//            "        , P.SIGN_SEQ\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_PATH P\n" +
//            "    JOIN SIGN S ON (P.SIGN_NO = S.NO)\n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE P.APPROVER_NO = #{approverNo}\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 결재 진행 목록 조회 (참조자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        R.NO\n" +
//            "        , R.SIGN_NO\n" +
//            "        , R.REF_NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_REF R\n" +
//            "    JOIN SIGN S ON (R.SIGN_NO = S.NO) \n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE R.REF_NO = #{refNo}\n" +
//            "    AND S.RESULT = 0\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignWaitListForReference(@RequestParam("refNo") String refNo);
//
//    // 결재 완료 목록 조회 (참조자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        R.NO\n" +
//            "        , R.SIGN_NO\n" +
//            "        , R.REF_NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_REF R\n" +
//            "    JOIN SIGN S ON (R.SIGN_NO = S.NO) \n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE R.REF_NO = #{refNo}\n" +
//            "    AND S.RESULT = 1\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignApprovalListForReference(@RequestParam("refNo") String refNo);
//
//    // 결재 반려 목록 조회 (참조자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        R.NO\n" +
//            "        , R.SIGN_NO\n" +
//            "        , R.REF_NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_REF R\n" +
//            "    JOIN SIGN S ON (R.SIGN_NO = S.NO) \n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE R.REF_NO = #{refNo}\n" +
//            "    AND S.RESULT = 2\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignReturnListForReference(@RequestParam("refNo") String refNo);
//
//    // 결재 전체 목록 조회 (참조자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.SIGN_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.RESULT\n" +
//            "    , Y.STEP\n" +
//            "    , Y.TITLE\n" +
//            "    , Y.CONTENT\n" +
//            "    , Y.ENROLL_DATE\n" +
//            "    , Y.CHANGE_NAME\n" +
//            "    , Y.ORIGIN_NAME\n" +
//            "    , Y.\"SIZE\"\n" +
//            "    , Y.MODIFY_DATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        R.NO\n" +
//            "        , R.SIGN_NO\n" +
//            "        , R.REF_NO\n" +
//            "        , S.EMP_NO\n" +
//            "        , S.RESULT\n" +
//            "        , S.STEP\n" +
//            "        , S.TITLE\n" +
//            "        , S.CONTENT\n" +
//            "        , S.ENROLL_DATE\n" +
//            "        , F.CHANGE_NAME\n" +
//            "        , F.ORIGIN_NAME\n" +
//            "        , F.\"SIZE\"\n" +
//            "        , F.MODIFY_DATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , O.CODE            POSITION_CODE\n" +
//            "        , O.NAME            POSITION_NAME\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM SIGN_REF R\n" +
//            "    JOIN SIGN S ON (R.SIGN_NO = S.NO) \n" +
//            "    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)\n" +
//            "    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)\n" +
//            "    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE R.REF_NO = #{refNo}\n" +
//            "    ORDER BY S.NO DESC\n" +
//            ") Y")
//    List<SignVo> getSignListForReference(@RequestParam("refNo") String refNo);
} // interface
