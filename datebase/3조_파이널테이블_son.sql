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
	CODE              VARCHAR2(100) PRIMARY KEY
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
	RANK              CHAR(2)       PRIMARY KEY
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
	CODE              CHAR(2)       PRIMARY KEY
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
	STATE             VARCHAR2(100) PRIMARY KEY
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
	SALARY_CODE       CHAR(2)   PRIMARY KEY
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
    ID	        VARCHAR2(100)   NOT NULL
	, MEMBER_NO VARCHAR2(100)   NOT NULL
	, YEAR	    DATE		    NULL
	, DAYS	    DATE    		
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-----------------------휴가-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_OTHRE_LEAVE_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_OTHRE_LEAVE_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE OTHRE_LEAVE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE OTHRE_LEAVE(
    ID	VARCHAR(255)                NOT NULL
	, NO	VARCHAR2(1000)          NOT NULL
	, TYPE	VARCHAR(255)
	, START_DATE	VARCHAR(255)
	, END_DATE	VARCHAR(255)
	, REASON	VARCHAR(255)
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
------------------------멤버-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_MEMBER_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE MEMBER CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE MEMBER (
	NO                  VARCHAR2(1000)      PRIMARY KEY
	, DEPT_CODE         VARCHAR2(100)
	, POSITION_CODE     CHAR(2)
	, STATE             VARCHAR2(100)
	, SALARY_CODE       VARCHAR2(100)
	, RANK              CHAR(2)            
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
	, RETIRE_YN         CHAR(1) DEFAULT 'N'
	, AUTHOR_CODE       CHAR(2)
	, PERSONAL_WORK_NO  NUMBER              
    , REST_LEAVE        VARCHAR2(100)
);

-----외래키 제약조건-----
ALTER TABLE MEMBER ADD CONSTRAINT FK_DEPARTMENT_TO_MEMBER FOREIGN KEY (DEPT_CODE)
REFERENCES DEPARTMENT (CODE);

ALTER TABLE MEMBER ADD CONSTRAINT FK_POSITION_TO_MEMBER FOREIGN KEY (POSITION_CODE)
REFERENCES POSITION (CODE);

ALTER TABLE MEMBER ADD CONSTRAINT FK_ATTENDANCE_TO_MEMBER FOREIGN KEY (STATE)
REFERENCES ATTENDANCE (STATE);

ALTER TABLE MEMBER ADD CONSTRAINT FK_SALARY_TO_MEMBER FOREIGN KEY (SALARY_CODE)
REFERENCES SALARY (SALARY_CODE);

ALTER TABLE MEMBER ADD CONSTRAINT FK_AUTHORITY_TO_MEMBER FOREIGN KEY (RANK)
REFERENCES AUTHORITY (RANK);

ALTER TABLE MEMBER ADD CONSTRAINT FK_PERSONAL_WORK_TO_MEMBER FOREIGN KEY (PERSONAL_WORK_NO)
REFERENCES PERSONAL_WORK (NO);

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

