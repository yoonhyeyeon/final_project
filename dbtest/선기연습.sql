-- 출장 전체 목록 조회
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
    , Y.EMP_NAME            EMP_NAME
    , Y.NICK
    , Y.DIV_CODE            DIV_CODE
    , Y.DIV_NAME            DIV_NAME
    , Y.POSITION_CODE       POSITION_CODE
    , Y.POSITION_NAME       POSITION_NAME
    , Y.DEPT_CODE           DEPT_CODE
    , Y.DEPT_NAME           DEPT_NAME
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

-- 출장 확인자 목록 조회
SELECT
    ROWNUM
    , Y.NO
    , Y.APPROVER_NO
    , Y.APPROVER_NAME
    , Y.NICK
    , Y.DIV_CODE            DIV_CODE
    , Y.DIV_NAME            DIV_NAME
    , Y.POSITION_CODE       POSITION_CODE
    , Y.POSITION_NAME       POSITION_NAME
    , Y.DEPT_CODE           DEPT_CODE
    , Y.DEPT_NAME           DEPT_NAME
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

-- 출장 확인자 상세 조회
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



--------------------------------------------------
--------------------------------------------------
--------------------------------------------------



-- 휴가 확인 대기 목록 조회
SELECT
    ROWNUM
    , T.NO
    , T.LEAVE_TYPE
    , T.LEAVE_NAME
    , T.EMP_NO
    , T.APPROVER_NO
    , T.START_DATE
    , T.END_DATE
    , T.REASON
    , T.STATE
    , T.EMP_NAME
    , T.NICK
    , T.DIV_CODE
    , T.DIV_NAME
    , T.POSITION_CODE
    , T.POSITION_NAME
    , T.DEPT_CODE
    , T.DEPT_NAME
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
) T
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

-- 휴가 확인자 상세 조회
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

-- 휴가 확인자 목록 조회
SELECT
    ROWNUM
    , Y.NO
    , Y.APPROVER_NO
    , Y.APPROVER_NAME
    , Y.NICK
    , Y.DIV_CODE            DIV_CODE
    , Y.DIV_NAME            DIV_NAME
    , Y.POSITION_CODE       POSITION_CODE
    , Y.POSITION_NAME       POSITION_NAME
    , Y.DEPT_CODE           DEPT_CODE
    , Y.DEPT_NAME           DEPT_NAME
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

SELECT *
FROM EMPLOYEE
;
