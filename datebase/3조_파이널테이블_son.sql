--------------------------------------------------
------------------------부서-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_DEPARTMENT_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_DEPARTMENT_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE DEPARTMENT (
	CODE              NUMBER        PRIMARY KEY
	, NAME            VARCHAR2(100)
	, STATE           VARCHAR2(100)
	, ENROLL_DATE     DATE
	, MODIFY_DATE     TIMESTAMP
	, END_DATE        DATE
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-------------------------권한---------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_AUTHORITY_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_AUTHORITY_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE AUTHORITY CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE AUTHORITY (
	RANK              NUMBER        PRIMARY KEY
	, NAME            VARCHAR2(100)
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
------------------------직급----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_POSITION_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_POSITION_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE POSITION CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE POSITION (
	CODE              NUMBER        PRIMARY KEY
	, NAME            VARCHAR2(100)
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
----------------------근태------------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_ATTEND_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_ATTEND_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE ATTEND CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE ATTEND (
	STATE             NUMBER        PRIMARY KEY
	, NAME            VARCHAR2(100)
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
----------------------급여------------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_SALARY_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_SALARY_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE SALARY CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE SALARY (
	SALARY_CODE       NUMBER    PRIMARY KEY
	, SALARY          NUMBER
	, MIN_SAL         NUMBER
	, MAX_SAL         NUMBER
);

-----외래키 제약조건-----


--------------------------------------------------


--------------------------------------------------
-----------------------연차-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_ANNUAL_LEAVE_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_ANNUAL_LEAVE_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE ANNUAL_LEAVE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE ANNUAL_LEAVE(
    ID	        NUMBER  NOT NULL
	, MEMBER_NO NUMBER  NOT NULL
	, YEAR	    DATE    NULL
	, DAYS	    DATE    		
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-----------------------휴가-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_LEAVE_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_LEAVE_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE LEAVE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE LEAVE(
    ID              NUMBER  NOT NULL
	, EMP_NO        NUMBER  NOT NULL
    , SIGN_NO       NUMBER  NOT NULL
	, TYPE          NUMBER
	, START_DATE    DATE
	, END_DATE      DATE
	, REASON	    VARCHAR(4000)
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-----------------------사원정보----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_EMPLOYEE_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_EMPLOYEE_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE EMPLOYEE (
	NO                  NUMBER              PRIMARY KEY
	, DEPT_CODE         NUMBER
	, POSITION_CODE     NUMBER
	, STATE             NUMBER
	, SALARY_CODE       NUMBER
	, RANK              NUMBER
	, SALARY            NUMBER
	, BONUS             NUMBER
	, ID                VARCHAR2(100)
	, PWD               VARCHAR2(100)
	, NICK              VARCHAR2(100)
	, NAME              VARCHAR2(100)
	, PHONE             CHAR(11)
	, ADDRESS           VARCHAR2(100)
	, ENROLL_DATE       DATE
	, RETIRE_DATE       DATE
	, RETIRE_YN         CHAR(1)             DEFAULT 'N'
);

-----외래키 제약조건-----
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_DEPARTMENT_TO_EMPLOYEE FOREIGN KEY (DEPT_CODE)
REFERENCES DEPARTMENT (CODE);

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_POSITION_TO_EMPLOYEE FOREIGN KEY (POSITION_CODE)
REFERENCES POSITION (CODE);

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_ATTEND_TO_EMPLOYEE FOREIGN KEY (STATE)
REFERENCES ATTEND (STATE);

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_SALARY FOREIGN KEY (SALARY_CODE)
REFERENCES SALARY (SALARY_CODE);

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_AUTHORITY_TO_EMPLOYEE FOREIGN KEY (RANK)
REFERENCES AUTHORITY (RANK);

--------------------------------------------------











--------------------------------------------------
-------------------제목--------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_제목_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_제목_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE 제목 CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE 제목(

);

-----외래키 제약조건-----

--------------------------------------------------

COMMIT;

