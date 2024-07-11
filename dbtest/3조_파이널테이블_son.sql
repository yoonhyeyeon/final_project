--------------------------------------------------
------------------------부서-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_DEPARTMENT;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_DEPARTMENT NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE DEPARTMENT (
	CODE              NUMBER        PRIMARY KEY
	, NAME            VARCHAR2(100)
	, STATE           VARCHAR2(100)
	, ENROLL_DATE     TIMESTAMP
	, MODIFY_DATE     TIMESTAMP
	, END_DATE        TIMESTAMP
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-------------------프로젝트팀-----------------------
--------------------------------------------------

-----테이블 삭제-----
DROP TABLE DIVISION CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE DIVISION (
	CODE              NUMBER        PRIMARY KEY
    , DEPT_CODE       NUMBER
	, NAME            VARCHAR2(100)
	, STATE           VARCHAR2(100)
	, ENROLL_DATE     TIMESTAMP
	, MODIFY_DATE     TIMESTAMP
	, END_DATE        TIMESTAMP
);

-----외래키 제약조건-----
ALTER TABLE DIVISION ADD CONSTRAINT FK_DEPARTMENT_TO_DIVISION FOREIGN KEY (DEPT_CODE)
REFERENCES DEPARTMENT (CODE);

--------------------------------------------------


--------------------------------------------------
-------------------------권한---------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_AUTHORITY;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_AUTHORITY NOCACHE NOCYCLE;

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
DROP SEQUENCE SEQ_POSITION;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_POSITION NOCACHE NOCYCLE;

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
DROP SEQUENCE SEQ_ATTEND;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_ATTEND NOCACHE NOCYCLE;

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
DROP SEQUENCE SEQ_SALARY;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_SALARY NOCACHE NOCYCLE;

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
DROP SEQUENCE SEQ_ANNUAL_LEAVE;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_ANNUAL_LEAVE NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE ANNUAL_LEAVE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE ANNUAL_LEAVE(
    ID	        NUMBER  NOT NULL
	, MEMBER NUMBER  NOT NULL
	, YEAR	    DATE    NULL
	, DAYS	    DATE    		
);

-----외래키 제약조건-----

--------------------------------------------------


--------------------------------------------------
-----------------------휴가-----------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_LEAVE;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_LEAVE NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE LEAVE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE LEAVE(
    ID              NUMBER  NOT NULL
	, EMP        NUMBER  NOT NULL
    , SIGN       NUMBER  NOT NULL
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
DROP SEQUENCE SEQ_EMPLOYEE;
DROP SEQUENCE SEQ_EMPLOYEE_NO;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_EMPLOYEE NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE EMPLOYEE (
	NO                  NUMBER              PRIMARY KEY
	, DEPT_CODE         NUMBER
    , DIV_CODE          NUMBER
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
	, ENROLL_DATE       TIMESTAMP
	, RETIRE_DATE       TIMESTAMP
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
-------------------인사관리계정---------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_HR_ACCOUNT;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_HR_ACCOUNT NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE HR_ACCOUNT CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE HR_ACCOUNT(
    NO      NUMBER
    , RANK  NUMBER
    , ID    VARCHAR2(100)
    , PWD   VARCHAR2(100)
    , NICK VARCHAR2(100)
);

-----외래키 제약조건-----
ALTER TABLE HR_ACCOUNT ADD CONSTRAINT FK_AUTHORITY_TO_HR_ACCOUNT FOREIGN KEY (RANK)
REFERENCES AUTHORITY (RANK);


--------------------------------------------------


--------------------------------------------------
-------------------메시지--------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_MESSAGE;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_MESSAGE NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE MESSAGE CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE MESSAGE(
    NO          NUMBER		    PRIMARY KEY
	, SENDER    NUMBER		    NOT NULL
	, RECEIVER  NUMBER		    NOT NULL
	, TITLE     VARCHAR2(100)
	, CONTENT   VARCHAR2(1000)
	, SEND_TIME TIMESTAMP       DEFAULT SYSDATE
	, READ_YN	CHAR(1)         DEFAULT 'N'     NOT NULL
	, DEL_YN	CHAR(1)	        DEFAULT 'N'     NOT NULL
);

-----외래키 제약조건-----
ALTER TABLE MESSAGE
ADD CONSTRAINT FK_MESSAGE_SENDER
FOREIGN KEY (SENDER)
REFERENCES EMPLOYEE(NO);

ALTER TABLE MESSAGE
ADD CONSTRAINT FK_MESSAGE_RECEIVER
FOREIGN KEY (RECEIVER)
REFERENCES EMPLOYEE(NO);

--------------------------------------------------












--------------------------------------------------
-------------------제목--------------------
--------------------------------------------------

-----시퀀스 삭제-----
DROP SEQUENCE SEQ_제목;

-----시퀀스 생성-----
CREATE SEQUENCE SEQ_제목 NOCACHE NOCYCLE;

-----테이블 삭제-----
DROP TABLE 제목 CASCADE CONSTRAINTS;

-----테이블 생성-----
CREATE TABLE 제목(

);

-----외래키 제약조건-----

--------------------------------------------------

COMMIT;

