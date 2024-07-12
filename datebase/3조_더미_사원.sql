--권한 등급--
INSERT INTO AUTHORITY (RANK, NAME) VALUES (00, 'Master');
INSERT INTO AUTHORITY (RANK, NAME) VALUES (10, 'Chief Manager');
INSERT INTO AUTHORITY (RANK, NAME) VALUES (20, 'Project Manager');
INSERT INTO AUTHORITY (RANK, NAME) VALUES (30, 'Vice Manager');
INSERT INTO AUTHORITY (RANK, NAME) VALUES (40, 'Temporary Manager');

--직급--
INSERT INTO POSITION (CODE, NAME) VALUES (10, '사장');
INSERT INTO POSITION (CODE, NAME) VALUES (11, '관리자');
INSERT INTO POSITION (CODE, NAME) VALUES (20, '이사');
INSERT INTO POSITION (CODE, NAME) VALUES (30, '부장');
INSERT INTO POSITION (CODE, NAME) VALUES (40, '팀장');
INSERT INTO POSITION (CODE, NAME) VALUES (50, '차장');
INSERT INTO POSITION (CODE, NAME) VALUES (60, '과장');
INSERT INTO POSITION (CODE, NAME) VALUES (70, '대리');
INSERT INTO POSITION (CODE, NAME) VALUES (80, '주임');
INSERT INTO POSITION (CODE, NAME) VALUES (90, '사원');

--급여--
INSERT INTO SALARY (SALARY_CODE) VALUES (10);
INSERT INTO SALARY (SALARY_CODE) VALUES (20);
INSERT INTO SALARY (SALARY_CODE) VALUES (30);
INSERT INTO SALARY (SALARY_CODE) VALUES (40);
INSERT INTO SALARY (SALARY_CODE) VALUES (50);
INSERT INTO SALARY (SALARY_CODE) VALUES (60);
INSERT INTO SALARY (SALARY_CODE) VALUES (70);
INSERT INTO SALARY (SALARY_CODE) VALUES (80);
INSERT INTO SALARY (SALARY_CODE) VALUES (90);

--부서--
INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (00, '임원', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (10, '경영지원부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20, '인사부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (30, '연구개발부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (40, '영업부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DEPARTMENT (CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (50, '홍보부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

--프로젝트팀--
INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (00, 00, '임원', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (10, 10, '경영지원본부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20241001, 10, '경영지원1팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20241002, 10, '경영지원2팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20, 20, '인사본부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20242001, 20, '인사1팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20242002, 20, '인사2팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (30, 30, '연구개발본부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20243001, 30, '연구개발1팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20243002, 30, '연구개발2팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (40, 40, '영업본부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20244001, 40, '영업1팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20244002, 40, '영업2팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (50, 50, '홍보본부', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20245001, 50, '홍보1팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE)
VALUES (20245002, 50, '홍보2팀', '활동중', SYSDATE, CURRENT_TIMESTAMP, NULL);

--근태--
INSERT INTO ATTEND (STATE, NAME)
VALUES (10, '출근');

INSERT INTO ATTEND (STATE, NAME)
VALUES (11, '외출');

INSERT INTO ATTEND (STATE, NAME)
VALUES (20, '퇴근');

INSERT INTO ATTEND (STATE, NAME)
VALUES (30, '외근');

INSERT INTO ATTEND (STATE, NAME)
VALUES (40, '출장');

INSERT INTO ATTEND (STATE, NAME)
VALUES (50, '휴가');

-- 인사 관리 계정
INSERT INTO HR_ACCOUNT (NO, RANK, ID, PWD, NICK)
VALUES (SEQ_HR_ACCOUNT.NEXTVAL, 00, 'admin', '1234', '인사관리자');

-- 멤버
-- INSERT 관리자
INSERT INTO EMPLOYEE (NO, RANK, POSITION_CODE, ID, PWD, NICK, NAME)
VALUES (00, 00, 11, 'admin', '1234', '관리자', '관리자');

-- INSERT 사장
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 00, 00, 10, 10, 10, 00, 4000, 800, 'ceo', '1234', 'CEO', '김사장', '01023456789', '서울시 강동구', SYSDATE, NULL, 'N');

-- INSERT 이사
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 00, 00, 20, 10, 20, 10, 3500, 700, 'is1', '1234', '이사1', '김이사', '01034567890', '서울시 강서구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 00, 00, 20, 10, 20, 10, 3500, 700, 'is2', '1234', '이사2', '이이사', '01034567890', '서울시 강서구', SYSDATE, NULL, 'N');

-- INSERT 부장
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 10, 30, 10, 30, 10, 3000, 600, 'hqb', '1234', '경영부장', '김경영', '01045678901', '서울시 관악구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20, 30, 10, 30, 10, 3000, 600, 'hrb', '1234', '인사부장', '이인사', '01045678901', '서울시 관악구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 30, 30, 10, 30, 10, 3000, 600, 'rndb', '1234', '연구부장', '박연구', '01045678901', '서울시 관악구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 40, 30, 10, 30, 10, 3000, 600, 'slb', '1234', '영업부장', '최영업', '01045678901', '서울시 관악구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 50, 30, 10, 30, 10, 3000, 600, 'mkb', '1234', '홍보부장', '정홍보', '01045678901', '서울시 관악구', SYSDATE, NULL, 'N');

-- INSERT 팀장
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 40, 10, 40, 20, 2800, 560, 'hqt1', '1234', '경영팀장1', '김경일', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 40, 10, 40, 20, 2800, 560, 'hqt2', '1234', '경영팀장2', '김경이', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 40, 10, 40, 20, 2800, 560, 'hrt1', '1234', '인사팀장1', '이인일', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 40, 10, 40, 20, 2800, 560, 'hrt2', '1234', '인사팀장2', '이인이', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 40, 10, 40, 20, 2800, 560, 'rnd1', '1234', '연구팀장1', '박연일', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 40, 10, 40, 20, 2800, 560, 'rnd2', '1234', '연구팀장2', '박연이', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 40, 10, 40, 20, 2800, 560, 'slt1', '1234', '영업팀장1', '최영일', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 40, 10, 40, 20, 2800, 560, 'slt2', '1234', '영업팀장2', '최영이', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 40, 10, 40, 20, 2800, 560, 'mkt1', '1234', '홍보팀장1', '정홍일', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 40, 10, 40, 20, 2800, 560, 'mkt2', '1234', '홍보팀장2', '정홍이', '01056789012', '서울시 송파구', SYSDATE, NULL, 'N');

-- INSERT 차장
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 50, 10, 50, 20, 2500, 500, 'hqc1', '1234', '경영차장1', '김경삼', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 50, 10, 50, 20, 2500, 500, 'hqc2', '1234', '경영차장2', '김경사', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 50, 10, 50, 20, 2500, 500, 'hrc1', '1234', '인사차장1', '이인삼', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 50, 10, 50, 20, 2500, 500, 'hrc2', '1234', '인사차장2', '이인사', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 50, 10, 50, 20, 2500, 500, 'rndc1', '1234', '연구차장1', '박연삼', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 50, 10, 50, 20, 2500, 500, 'rndc2', '1234', '연구차장2', '박연사', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 50, 10, 50, 20, 2500, 500, 'slc1', '1234', '영업차장1', '최영삼', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 50, 10, 50, 20, 2500, 500, 'slc2', '1234', '영업차장2', '최영사', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 50, 10, 50, 20, 2500, 500, 'mkc1', '1234', '홍보차장1', '정홍삼', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 50, 10, 50, 20, 2500, 500, 'mkc2', '1234', '홍보차장2', '정홍사', '01067890123', '서울시 강북구', SYSDATE, NULL, 'N');

-- INSERT 과장
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 60, 10, 60, 30, 2300, 460, 'hqg1', '1234', '경영과장1', '김경오', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 60, 10, 60, 30, 2300, 460, 'hqg2', '1234', '경영과장2', '김경육', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 60, 10, 60, 30, 2300, 460, 'hrg1', '1234', '인사과장1', '이인오', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 60, 10, 60, 30, 2300, 460, 'hrg2', '1234', '인사과장2', '이인육', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 60, 10, 60, 30, 2300, 460, 'rndg1', '1234', '연구과장1', '박연오', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 60, 10, 60, 30, 2300, 460, 'rndg2', '1234', '연구과장2', '박연육', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 60, 10, 60, 30, 2300, 460, 'slg1', '1234', '영업과장1', '최영오', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 60, 10, 60, 30, 2300, 460, 'slg2', '1234', '영업과장2', '최영육', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 60, 10, 60, 30, 2300, 460, 'mkg1', '1234', '홍보과장1', '정홍오', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 60, 10, 60, 30, 2300, 460, 'mkg2', '1234', '홍보과장2', '정홍육', '01078901234', '서울시 도봉구', SYSDATE, NULL, 'N');

-- INSERT 대리
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 70, 10, 70, 30, 2000, 400, 'hqd1', '1234', '경영대리1', '김경칠', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 70, 10, 70, 30, 2000, 400, 'hqd2', '1234', '경영대리2', '김경팔', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 70, 10, 70, 30, 2000, 400, 'hrd1', '1234', '인사대리1', '이인칠', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 70, 10, 70, 30, 2000, 400, 'hrd2', '1234', '인사대리2', '이인팔', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 70, 10, 70, 30, 2000, 400, 'rndd1', '1234', '연구대리1', '박연칠', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 70, 10, 70, 30, 2000, 400, 'rndd2', '1234', '연구대리2', '박연팔', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 70, 10, 70, 30, 2000, 400, 'sld1', '1234', '영업대리1', '최영칠', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 70, 10, 70, 30, 2000, 400, 'sld2', '1234', '영업대리2', '최영팔', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 70, 10, 70, 30, 2000, 400, 'mkd1', '1234', '홍보대리1', '정홍칠', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 70, 10, 70, 30, 2000, 400, 'mkd2', '1234', '홍보대리2', '정홍팔', '01089012345', '서울시 마포구', SYSDATE, NULL, 'N');

-- INSERT 주임
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 80, 10, 80, 40, 1800, 360, 'hqj1', '1234', '경영주임1', '김경구', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 80, 10, 80, 40, 1800, 360, 'hqj2', '1234', '경영주임2', '김경십', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 80, 10, 80, 40, 1800, 360, 'hrj1', '1234', '인사주임1', '이인구', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 80, 10, 80, 40, 1800, 360, 'hrj2', '1234', '인사주임2', '이인십', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 80, 10, 80, 40, 1800, 360, 'rndj1', '1234', '연구주임1', '박연귀', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 80, 10, 80, 40, 1800, 360, 'rndj2', '1234', '연구주임2', '박연십', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 80, 10, 80, 40, 1800, 360, 'slj1', '1234', '영업주임1', '최영구', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 80, 10, 80, 40, 1800, 360, 'slj2', '1234', '영업주임2', '최영십', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 80, 10, 80, 40, 1800, 360, 'mkj1', '1234', '홍보주임1', '정홍구', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 80, 10, 80, 40, 1800, 360, 'mkj2', '1234', '홍보주임2', '정홍십', '01090123456', '서울시 강남구', SYSDATE, NULL, 'N');

-- INSERT 사원
INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241001, 90, 10, 90, NULL, 1500, 300, 'hqs1', '1234', '경영사원1', '김경사', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 10, 20241002, 90, 10, 90, NULL, 1500, 300, 'hqs2', '1234', '경영사원2', '김경원', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242001, 90, 10, 90, NULL, 1500, 300, 'hrs1', '1234', '인사사원1', '이인상', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 20, 20242002, 90, 10, 90, NULL, 1500, 300, 'hrs2', '1234', '인사사원2', '이인원', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243001, 90, 10, 90, NULL, 1500, 300, 'rnds1', '1234', '연구사원1', '박연사', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 30, 20243002, 90, 10, 90, NULL, 1500, 300, 'rnds2', '1234', '연구사원2', '박연원', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244001, 90, 10, 90, NULL, 1500, 300, 'sls1', '1234', '영업사원1', '최영사', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 40, 20244002, 90, 10, 90, NULL, 1500, 300, 'sls2', '1234', '영업사원2', '최영원', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245001, 90, 10, 90, NULL, 1500, 300, 'mks1', '1234', '홍보사원1', '정홍사', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');

INSERT INTO EMPLOYEE (NO, DEPT_CODE, DIV_CODE, POSITION_CODE, STATE, SALARY_CODE, RANK, SALARY, BONUS, ID, PWD, NICK, NAME, PHONE, ADDRESS, ENROLL_DATE, RETIRE_DATE, RETIRE_YN)
VALUES (SEQ_EMPLOYEE.NEXTVAL, 50, 20245002, 90, 10, 90, NULL, 1500, 300, 'mks2', '1234', '홍보사원2', '정홍원', '01001234567', '서울시 서초구', SYSDATE, NULL, 'N');




--급여--



COMMIT;


