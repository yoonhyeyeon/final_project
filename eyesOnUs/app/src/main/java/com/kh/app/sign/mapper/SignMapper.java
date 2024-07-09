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

    // 기안 (SIGN)
    @Insert({"""
            INSERT INTO SIGN(
                NO, EMP_NO
                , TITLE, CONTENT
            )
            VALUES(
                SEQ_SIGN.NEXTVAL, #{empNo}
                , #{title}, #{content}
            )
            """})
    int signWrite(SignVo vo);

    // 기안 (SIGN_FILE)
    @Insert({"""
            INSERT INTO SIGN_FILE(
                NO, SIGN_NO, CHANGE_NAME, ORIGIN_NAME, \"SIZE\"
            )
            VALUES(
                SEQ_SIGN_FILE.NEXTVAL, SEQ_SIGN.CURRVAL, #{changeName}, #{originName}, #{size}
            )
            """})
    int signFileWrite(SignVo vo);

    // 기안 (SIGN_PATH)
    @Insert({"""
            INSERT INTO SIGN_PATH(
                NO, SIGN_NO
                , APPROVER_NO, SIGN_SEQ
            )
            VALUES(
                SEQ_SIGN_PATH.NEXTVAL, SEQ_SIGN.CURRVAL
                , #{approver}, #{signSeq}
            )
            """})
    int signPathWrite(@RequestParam("approver") String approver, @RequestParam("signSeq") int signSeq);

    // 기안 (SIGN_REF)
    @Insert({"""
            INSERT INTO SIGN_REF(
                NO, SIGN_NO, REF_NO
            )
            VALUES(
                SEQ_SIGN_REF.NEXTVAL, SEQ_SIGN.CURRVAL, #{ref}
            )
            """})
    int signRefWrite(@RequestParam("ref") String ref);

    // 직원 전체 목록 조회 (API)
    @Select({"""
            SELECT
                E.NO
                , E.DEPT_CODE
                , E.DIV_CODE
                , E.POSITION_CODE
                , E.STATE
                , E.SALARY_CODE
                , E.RANK
                , E.BONUS
                , E.ID
                , E.PWD
                , E.NICK
                , E.NAME
                , E.PHONE
                , E.ADDRESS
                , E.PROFILE
                , E.ENROLL_DATE
                , E.RETIRE_DATE
                , E.RETIRE_YN
                , P.NAME            POSITION_NAME
                , D.NAME            DIV_NAME
                , T.NAME            DEPT_NAME
            FROM EMPLOYEE E
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            ORDER BY E.POSITION_CODE ASC
            """})
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
            """
            <script>
                SELECT
                    ROWNUM
                    , Y.NO
                    , Y.EMP_NO
                    , Y.RESULT
                    , Y.STEP
                    , Y.TITLE
                    , Y.CONTENT
                    , Y.ENROLL_DATE
                    , Y.CHANGE_NAME
                    , Y.ORIGIN_NAME
                    , Y.\"SIZE\"
                    , Y.MODIFY_DATE
                    , Y.EMP_NAME
                    , Y.NICK
                    , Y.POSITION_CODE
                    , Y.POSITION_NAME
                    , Y.DIV_CODE
                    , Y.DIV_NAME
                    , Y.DEPT_CODE
                    , Y.DEPT_NAME
                FROM
                (
                    SELECT
                        S.NO
                        , S.EMP_NO
                        , S.RESULT
                        , S.STEP
                        , S.TITLE
                        , S.CONTENT
                        , S.ENROLL_DATE
                        , F.CHANGE_NAME
                        , F.ORIGIN_NAME
                        , F.\"SIZE\"
                        , F.MODIFY_DATE
                        , E.NAME EMP_NAME
                        , E.NICK
                        , P.CODE POSITION_CODE
                        , P.NAME POSITION_NAME
                        , D.CODE DIV_CODE
                        , D.NAME DIV_NAME
                        , T.CODE DEPT_CODE
                        , T.NAME DEPT_NAME
                    FROM SIGN S
                    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
                    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
                    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
                    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
                    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
                    WHERE S.EMP_NO = #{empNo}
                    
                    <if test='result != null'>
                        AND S.RESULT = #{result}
                    </if>
                    
                    <if test='step != null'>
                        AND S.STEP = #{step}
                    </if>
                    
                    ORDER BY S.NO DESC
                ) Y
            </script>
            """
    })
    List<SignVo> getVoListDynamic(SignVo signVo);

    // 결재 목록 조회 (결재자 입장) (동적 쿼리) (API)
    @Select({
            """
                <script>
                    SELECT
                        ROWNUM
                        , Y.NO
                        , Y.SIGN_NO
                        , Y.APPROVER_NO
                        , Y.SIGN_SEQ
                        , Y.EMP_NO
                        , Y.RESULT
                        , Y.STEP
                        , Y.TITLE
                        , Y.CONTENT
                        , Y.ENROLL_DATE
                        , Y.CHANGE_NAME
                        , Y.ORIGIN_NAME
                        , Y.\"SIZE\"
                        , Y.MODIFY_DATE
                        , Y.EMP_NAME
                        , Y.NICK
                        , Y.POSITION_CODE
                        , Y.POSITION_NAME
                        , Y.DIV_CODE
                        , Y.DIV_NAME
                        , Y.DEPT_CODE
                        , Y.DEPT_NAME
                    FROM
                    (
                        SELECT
                            P.NO
                            , P.SIGN_NO
                            , P.APPROVER_NO
                            , P.SIGN_SEQ
                            , S.EMP_NO
                            , S.RESULT
                            , S.STEP
                            , S.TITLE
                            , S.CONTENT
                            , S.ENROLL_DATE
                            , F.CHANGE_NAME
                            , F.ORIGIN_NAME
                            , F.\"SIZE\"
                            , F.MODIFY_DATE
                            , E.NAME EMP_NAME
                            , E.NICK
                            , O.CODE POSITION_CODE
                            , O.NAME POSITION_NAME
                            , D.CODE DIV_CODE
                            , D.NAME DIV_NAME
                            , T.CODE DEPT_CODE
                            , T.NAME DEPT_NAME
                        FROM SIGN_PATH P
                        JOIN SIGN S ON (P.SIGN_NO = S.NO)
                        JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
                        JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
                        JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
                        JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
                        JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
                        WHERE P.APPROVER_NO = #{approverNo[0]}
                        
                        <if test='result != null'>
                            AND S.RESULT = #{result}
                        </if>
                        
                        <if test='step != null'>
                            AND S.STEP = #{step}
                        </if>
                        
                        ORDER BY S.NO DESC
                    ) Y
                </script>
            """
    })
    List<SignVo> getVoListDynamicForApprover(SignVo signVo);

    // 결재 목록 조회 (참조자 입장) (동적 쿼리) (API)
    @Select({
            """
                <script>
                    SELECT
                        ROWNUM
                        , Y.NO
                        , Y.SIGN_NO
                        , Y.EMP_NO
                        , Y.RESULT
                        , Y.STEP
                        , Y.TITLE
                        , Y.CONTENT
                        , Y.ENROLL_DATE
                        , Y.CHANGE_NAME
                        , Y.ORIGIN_NAME
                        , Y.\"SIZE\"
                        , Y.MODIFY_DATE
                        , Y.EMP_NAME
                        , Y.NICK
                        , Y.POSITION_CODE
                        , Y.POSITION_NAME
                        , Y.DIV_CODE
                        , Y.DIV_NAME
                        , Y.DEPT_CODE
                        , Y.DEPT_NAME
                    FROM
                    (
                        SELECT
                            R.NO
                            , R.SIGN_NO
                            , R.REF_NO
                            , S.EMP_NO
                            , S.RESULT
                            , S.STEP
                            , S.TITLE
                            , S.CONTENT
                            , S.ENROLL_DATE
                            , F.CHANGE_NAME
                            , F.ORIGIN_NAME
                            , F.\"SIZE\"
                            , F.MODIFY_DATE
                            , E.NAME EMP_NAME
                            , E.NICK
                            , O.CODE POSITION_CODE
                            , O.NAME POSITION_NAME
                            , D.CODE DIV_CODE
                            , D.NAME DIV_NAME
                            , T.CODE DEPT_CODE
                            , T.NAME DEPT_NAME
                        FROM SIGN_REF R
                        JOIN SIGN S ON (R.SIGN_NO = S.NO)
                        JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
                        JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
                        JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
                        JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
                        JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
                        WHERE R.REF_NO = #{refNo[0]}
                        
                        <if test='result != null'>
                            AND S.RESULT = #{result}
                        </if>
                        
                        <if test='step != null'>
                            AND S.STEP = #{step}
                        </if>
                        
                        ORDER BY S.NO DESC
                    ) Y
                </script>
            """
    })
    List<SignVo> getVoListDynamicForReference(SignVo signVo);
} // interface
