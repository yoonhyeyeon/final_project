----- BUSINESS_TRIP -----
-- 출장 전체 목록 조회 (신청자 입장)
SELECT
    ROWNUM
    , Y.NO
    , Y.PRO_NO
    , Y.EMP_NO
    , Y.APPROVER_NO
    , Y.START_DATE
    , Y.END_DATE
    , Y.REASON
    , Y.DESTINATION
    , Y.STATE
    , Y.EMP_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
    SELECT
        B.NO
        , B.PRO_NO
        , B.EMP_NO
        , B.APPROVER_NO
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
) Y
;

-- 출장 상세 조회
SELECT
    B.NO
    , B.PRO_NO
    , B.EMP_NO
    , B.APPROVER_NO
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
WHERE B.NO = 3
;

-- 출장 승인자 목록 조회
SELECT
    ROWNUM
    , Y.NO
    , Y.APPROVER_NO
    , Y.APPROVER_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
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
    WHERE B.EMP_NO = 43
    ORDER BY B.NO DESC
) Y
;

-- 출장 승인자 상세 조회
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

-- 출장 상태 변경
UPDATE BUSINESS_TRIP
SET STATE = 2
WHERE NO = 1
;

-- 출장 전체 목록 조회 (승인자 입장)
SELECT
    ROWNUM
    , Y.NO
    , Y.PRO_NO
    , Y.EMP_NO
    , Y.APPROVER_NO
    , Y.START_DATE
    , Y.END_DATE
    , Y.REASON
    , Y.DESTINATION
    , Y.STATE
    , Y.EMP_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
    SELECT
        B.NO
        , B.PRO_NO
        , B.EMP_NO
        , B.APPROVER_NO
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
    WHERE B.APPROVER_NO = 13
    ORDER BY B.NO DESC
) Y
;



--------------------------------------------------
--------------------------------------------------
--------------------------------------------------



----- LEAVE -----
-- 휴가 전체 목록 조회 (신청자 입장)
SELECT
    ROWNUM
    , Y.NO
    , Y.LEAVE_TYPE
    , Y.LEAVE_NAME
    , Y.EMP_NO
    , Y.APPROVER_NO
    , Y.START_DATE
    , Y.END_DATE
    , Y.REASON
    , Y.STATE
    , Y.EMP_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
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
) Y
;

-- 휴가 상세 조회
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
WHERE L.NO = 3
;

-- 휴가 승인자 상세 조회
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
WHERE L.NO = 3
;

-- 휴가 승인자 목록 조회
SELECT
    ROWNUM
    , Y.NO
    , Y.APPROVER_NO
    , Y.APPROVER_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
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
) Y
;

-- 휴가 상태 변경
UPDATE LEAVE
SET STATE = 99
WHERE NO = 1
;

SELECT
    E.NO
    , E.DEPT_CODE
    , E.DIV_CODE
    , E.POSITION_CODE
    , E.STATE
    , E.SALARY_CODE
    , E.RANK
    , E.SALARY
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
    , D.NAME            DIV_NAME
    , P.NAME            POSITION_NAME
    , T.NAME            DEPT_NAME
FROM EMPLOYEE E
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN POSITION P ON (E.POSITION_CODE = D.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
ORDER BY E.POSITION_CODE ASC
;

-- 직원 목록 조회
SELECT
    ROWNUM
    , Y.NO
    , Y.DEPT_CODE
    , Y.DIV_CODE
    , Y.POSITION_CODE
    , Y.STATE
    , Y.SALARY_CODE
    , Y.RANK
    , Y.SALARY
    , Y.BONUS
    , Y.ID
    , Y.PWD
    , Y.NICK
    , Y.NAME
    , Y.PHONE
    , Y.ADDRESS
    , Y.PROFILE
    , Y.ENROLL_DATE
    , Y.RETIRE_DATE
    , Y.RETIRE_YN
    , Y.POSITION_NAME
    , Y.DIV_NAME
    , Y.DEPT_NAME
FROM
(
    SELECT
        E.NO
        , E.DEPT_CODE
        , E.DIV_CODE
        , E.POSITION_CODE
        , E.STATE
        , E.SALARY_CODE
        , E.RANK
        , E.SALARY
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
) Y
;

-- 휴가 전체 목록 조회 (승인자 입장)
SELECT
    ROWNUM
    , Y.NO
    , Y.LEAVE_TYPE
    , Y.LEAVE_NAME
    , Y.EMP_NO
    , Y.APPROVER_NO
    , Y.START_DATE
    , Y.END_DATE
    , Y.REASON
    , Y.STATE
    , Y.EMP_NAME
    , Y.NICK
    , Y.DIV_CODE
    , Y.DIV_NAME
    , Y.POSITION_CODE
    , Y.POSITION_NAME
    , Y.DEPT_CODE
    , Y.DEPT_NAME
FROM
(
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
    WHERE L.APPROVER_NO = 13
    ORDER BY L.NO DESC
) Y
;



--------------------------------------------------
--------------------------------------------------
--------------------------------------------------



----- SIGN -----
-- 결재 전체 목록 조회 (신청자 입장)
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
    , Y."SIZE"
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
        , F."SIZE"
        , F.MODIFY_DATE
        , E.NAME            EMP_NAME
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
    AND S.RESULT = 1
    AND S.STEP = 3
    ORDER BY S.NO DESC
) Y
;

-- 결재 전체 목록 조회 (결재자 입장)
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
    , Y."SIZE"
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
        , F."SIZE"
        , F.MODIFY_DATE
        , E.NAME            EMP_NAME
        , E.NICK
        , O.CODE            POSITION_CODE
        , O.NAME            POSITION_NAME
        , D.CODE            DIV_CODE
        , D.NAME            DIV_NAME
        , T.CODE            DEPT_CODE
        , T.NAME            DEPT_NAME
    FROM SIGN_PATH P
    JOIN SIGN S ON (P.SIGN_NO = S.NO)
    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
    WHERE P.APPROVER_NO = 13
    ORDER BY S.NO DESC
) Y
;

-- 결재 전체 목록 조회 (참조자 입장)
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
    , Y."SIZE"
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
        , F."SIZE"
        , F.MODIFY_DATE
        , E.NAME            EMP_NAME
        , E.NICK
        , O.CODE            POSITION_CODE
        , O.NAME            POSITION_NAME
        , D.CODE            DIV_CODE
        , D.NAME            DIV_NAME
        , T.CODE            DEPT_CODE
        , T.NAME            DEPT_NAME
    FROM SIGN_REF R
    JOIN SIGN S ON (R.SIGN_NO = S.NO)
    JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
    JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
    JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
    WHERE R.REF_NO = 4
    ORDER BY S.NO DESC
) Y
;

-- 결재 상세 조회
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
    , F."SIZE"
    , F.MODIFY_DATE
    , E.NAME            EMP_NAME
    , E.NICK
    , O.CODE            POSITION_CODE
    , O.NAME            POSITION_NAME
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM SIGN S
JOIN SIGN_FILE F ON (S.NO = F.SIGN_NO)
JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE S.NO = 4
;

-- 결재
UPDATE SIGN
SET RESULT = 99
    , STEP = 99
WHERE NO = 1
;

-- 결재자 상세 조회
SELECT
    P.NO
    , P.SIGN_NO
    , P.APPROVER_NO
    , P.SIGN_SEQ
    , E.NAME            EMP_NAME
    , E.NICK
    , O.CODE            POSITION_CODE
    , O.NAME            POSITION_NAME
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM SIGN_PATH P
JOIN EMPLOYEE E ON (P.APPROVER_NO = E.NO)
JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE P.SIGN_NO = 1
ORDER BY P.SIGN_SEQ ASC
;

-- 결재자 목록 조회


-- 신청자 목록 조회
SELECT
    P.NO
    , S.EMP_NO
    , P.SIGN_NO
    , P.APPROVER_NO
    , P.SIGN_SEQ
    , E.NAME            EMP_NAME
    , E.NICK
    , O.CODE            POSITION_CODE
    , O.NAME            POSITION_NAME
    , D.CODE            DIV_CODE
    , D.NAME            DIV_NAME
    , T.CODE            DEPT_CODE
    , T.NAME            DEPT_NAME
FROM SIGN_PATH P
JOIN SIGN S ON (P.SIGN_NO = S.NO)
JOIN EMPLOYEE E ON (S.EMP_NO = E.NO)
JOIN POSITION O ON (E.POSITION_CODE = O.CODE)
JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
WHERE P.APPROVER_NO = 6
ORDER BY P.SIGN_NO DESC
;
