-- BUSINESS_TRIP
-- 출장 목록 조회 (신청자 입장) (API)
SELECT
    B.NO
    , B.PRO_NO
    , B.EMP_NO
    , B.APPROVER_NO
    , B.ENROLL_DATE
    , B.APPROVE_DATE
    , B.START_DATE
    , B.END_DATE
    , B.REASON
    , B.DESTINATION
    , B.STATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE B.EMP_NO = 43
ORDER BY B.NO DESC
;

-- 출장 승인자 목록 조회 (신청자 입장) (API)
SELECT
    B.NO
    , B.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE B.EMP_NO = 43
ORDER BY B.NO DESC
;

-- 출장 목록 조회 (승인자 입장) (API)
SELECT
    B.NO
    , B.PRO_NO
    , J.TITLE           PRO_NAME
    , B.EMP_NO
    , B.APPROVER_NO
    , B.ENROLL_DATE
    , B.APPROVE_DATE
    , B.START_DATE
    , B.END_DATE
    , B.REASON
    , B.DESTINATION
    , B.STATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
JOIN PROJECT J ON (B.PRO_NO = J.NO)
WHERE B.APPROVER_NO = 13
ORDER BY B.NO DESC
;

-- 출장 목록 조회 (승인자 입장) (API)
SELECT
    B.NO
    , B.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE B.APPROVER_NO = 13
ORDER BY B.NO DESC
;

-- 출장 상세 조회 (API)
SELECT
    B.NO
    , B.PRO_NO          PRO_CODE
    , J.TITLE           PRO_NAME
    , B.EMP_NO
    , B.APPROVER_NO
    , B.START_DATE
    , B.END_DATE
    , B.REASON
    , B.DESTINATION
    , B.STATE
    , B.ENROLL_DATE
    , B.APPROVE_DATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
JOIN PROJECT J ON (B.PRO_NO = J.NO)
WHERE B.NO = 3
;

-- 출장 승인자 상세 조회 (API)
SELECT
    B.NO
    , B.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM BUSINESS_TRIP B
JOIN EMPLOYEE E ON (B.APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE B.NO = 3
;

-- 프로젝트 목록 조회
SELECT
    J.NO
    , J.CODE
    , J.EMP_NO
    , J.STATE_A_NO
    , J.TITLE
    , J.CONTENT
    , J.START_DATE
    , J.END_DATE
    , J.MODIFY_DATE
FROM EMPLOYEE E
JOIN PROJECT_MANAGER M ON (E.NO = M.EMP_NO)
JOIN PROJECT J ON (M.PRO_NO = J.NO)
WHERE E.NO = 43
;

-- 출장 승인
UPDATE BUSINESS_TRIP
SET STATE = 999
    , APPROVE_DATE = SYSDATE
WHERE NO = 1
;



--------------------------------------------------
--------------------------------------------------
--------------------------------------------------



-- LEAVE
-- 휴가 목록 조회 (신청자 입장) (API)
SELECT
    L.NO
    , L.TYPE_NO         LEAVE_TYPE
    , A.NAME            LEAVE_NAME
    , L.EMP_NO
    , L.ENROLL_DATE
    , L.APPROVE_DATE
    , L.APPROVER_NO
    , L.START_DATE
    , L.END_DATE
    , L.REASON
    , L.STATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
WHERE L.EMP_NO = 43
ORDER BY L.NO DESC
;

-- 휴가 승인자 목록 조회 (신청자 입장) (API)
SELECT
    L.NO
    , L.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE L.EMP_NO = 43
ORDER BY L.NO DESC
;

-- 휴가 목록 조회 (승인자 입장) (API)
SELECT
    L.NO
    , L.TYPE_NO         LEAVE_TYPE
    , A.NAME            LEAVE_NAME
    , L.EMP_NO
    , L.ENROLL_DATE
    , L.APPROVE_DATE
    , L.APPROVER_NO
    , L.START_DATE
    , L.END_DATE
    , L.REASON
    , L.STATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
WHERE L.APPROVER_NO = 43
ORDER BY L.NO DESC
;

-- 휴가 승인자 목록 조회 (승인자 입장) (API)
SELECT
    L.NO
    , L.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE L.APPROVER_NO = 43
ORDER BY L.NO DESC
;

-- 휴가 상세 조회 (API)
SELECT
    L.NO
    , L.TYPE_NO         LEAVE_TYPE
    , A.NAME            LEAVE_NAME
    , L.EMP_NO
    , L.APPROVER_NO
    , L.START_DATE
    , L.END_DATE
    , L.REASON
    , L.STATE
    , L.ENROLL_DATE
    , L.APPROVE_DATE
    , E.NAME            EMP_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
WHERE L.NO = 10
;

-- 휴가 승인자 상세 조회 (API)
SELECT
    L.NO
    , L.APPROVER_NO
    , E.NAME            APPROVER_NAME
    , E.NICK
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , P.CODE            POSITION_CODE
    , P.NAME            POSITION_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM LEAVE L
JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE L.NO = 10
;



--------------------------------------------------
--------------------------------------------------
--------------------------------------------------



-- SIGN
-- 2. 결재 목록 조회 (기안자 입장) (API)
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
WHERE S.EMP_NO = 43
ORDER BY S.NO DESC
;

-- 5. 결재 목록 조회 (결재자 입장) (API)
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
WHERE H.APPROVER_NO = 13
ORDER BY S.NO DESC
;

-- 8. 결재 목록 조회 (참조자 입장) (API)
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
WHERE R.REF_NO = 4
ORDER BY S.NO DESC
;

-- 11. 결재 상세 조회 (API)


-- 12. 결재자 상세 조회 (API)


-- 13. 참조자 상세 조회 (API)


-- 14. 결재 (API)

