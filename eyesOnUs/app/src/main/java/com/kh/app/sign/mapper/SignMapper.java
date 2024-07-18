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
    int signWrite(SignVo signVo);

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

    // 결재 목록 조회 (기안자 입장) (API)
    @Select({"""
            SELECT
                S.NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM SIGN S
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE S.EMP_NO = #{empNo}
            ORDER BY S.NO DESC
            """})
    List<SignVo> getSignListForWriter(@RequestParam("empNo") String empNo);

    // 결재 목록 조회 (결재자 입장) (API)
    @Select({"""
            SELECT
                S.NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
                , H.SIGN_SEQ
            FROM SIGN_PATH H
            JOIN SIGN S ON (H.SIGN_NO = S.NO)
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE H.APPROVER_NO = #{approverNo}
            ORDER BY S.NO DESC
            """})
    List<SignVo> getSignListForApprover(@RequestParam("approverNo") String approverNo);

    // 결재 목록 조회 (참조자 입장) (API)
    @Select({"""
            SELECT
                S.NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM SIGN_REF R
            JOIN SIGN S ON (R.SIGN_NO = S.NO)
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE R.REF_NO = #{refNo}
            ORDER BY S.NO DESC
            """})
    List<SignVo> getSignListForReference(@RequestParam("refNo") String refNo);

    // 결재 상세 조회 (API)
    @Select({"""
            SELECT
                S.NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM SIGN S
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE S.NO = #{no}
            """})
    SignVo getSignDetail(SignVo signVo);

    // 결재자 상세 조회 (API)
    @Select({"""
            SELECT
                H.SIGN_NO
                , H.SIGN_SEQ
                , H.APPROVER_NO     APP_NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM SIGN_PATH H
            JOIN SIGN S ON (H.SIGN_NO = S.NO)
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (H.APPROVER_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE H.SIGN_NO = #{no}
            ORDER BY H.SIGN_SEQ ASC
            """})
    List<SignVo> getSignApproverDetailList(SignVo signVo);

    // 참조자 상세 조회 (API)
    @Select({"""
            SELECT
                R.SIGN_NO
                , R.REF_NO
                , S.EMP_NO
                , E.NAME            EMP_NAME
                , S.RESULT
                , S.STEP
                , S.TITLE
                , S.CONTENT
                , S.ENROLL_DATE
                , F.CHANGE_NAME
                , F.ORIGIN_NAME
                , F."SIZE"
                , F.MODIFY_DATE
                , E.NICK
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM SIGN_REF R
            JOIN SIGN S ON (R.SIGN_NO = S.NO)
            JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
            JOIN EMPLOYEE E ON (R.REF_NO = E.NO)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE R.SIGN_NO = #{no}
            ORDER BY P.CODE ASC
                , T.CODE ASC
                , D.CODE ASC
            """})
    List<SignVo> getSignReferenceDetailList(SignVo signVo);

    // 결재 (SIGN) (API)
    @Update({"""
            <script>
                UPDATE SIGN
                <choose>
                    <when test=\"result == 0\">
                        SET STEP = #{step}
                    </when>
                    <when test=\"result == 1\">
                        SET RESULT = #{result}
                    </when>
                    <when test=\"result == 2\">
                        SET RESULT = #{result}
                    </when>
                </choose>
                WHERE NO = #{no}
            </script>
            """})
    int updateSign(SignVo signVo);

    // 결재 (SIGN_FILE) (API)
    @Update({"""
            <script>
                UPDATE SIGN_FILE
                SET MODIFY_DATE = SYSDATE
                <if test=\"changeName != null\">
                    , CHANGE_NAME = #{changeName}
                    , \"SIZE\" = #{size}
                </if>
                WHERE SIGN_NO = #{no}
            </script>
            """})
    int updateFile(SignVo signVo);

    // 결재 (SIGN_COM) (API)
    @Insert({"""
            INSERT INTO SIGN_COM(
                NO
                , SIGN_NO
                , \"COMMENT\"
            )
            VALUES(
                SEQ_SIGN_COM.NEXTVAL
                , #{no}
                , #{comment}
            )
            """})
    int writeComment(SignVo signVo);
} // interface
