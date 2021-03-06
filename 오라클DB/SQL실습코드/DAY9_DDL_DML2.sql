-- DAY9_DDL_DML2

-- 90번 부서의 직원명단을 EMP_COPY90 테이블에 저장 처리
CREATE TABLE EMP_COPY90
AS 
SELECT * FROM EMPLOYEE
WHERE DEPT_ID = '90';

-- 전 직원의 사번, 이름, 급여, 부서명, 직급명을 조회해서
-- TABLE_SUBQUERY1 테이블에 저장처리
CREATE TABLE TABLE_SUBQUERY1
AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, JOB_TITLE
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID);

SELECT * FROM TABLE_SUBQUERY1;

DESC EMP_COPY90;

CREATE TABLE EMP_COPY
AS
SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;
DESC EMP_COPY;


-- 연습 :
-- 사번, 이름, 급여, 직급명, 부서명, 근무지역명, 소속국가명 조회결과를
-- EMP_LIST 테이블에 저장

CREATE TABLE EMP_LIST
AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, JOB_TITLE, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING (COUNTRY_ID);

SELECT * FROM EMP_LIST;
DESCRIBE EMP_LIST;

--남,여 정보 각각 테이블로 저장
CREATE TABLE EMP_MAN
AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1','3');

CREATE TABLE EMP_FEMAIL
AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2','4');

-- 실습 2 : 부서별로 정렬된 직원의 명단을 PART_LIST 테이블에 저장
-- DEPT_NAME, JOB_TITLE,EMP_NAME, EMP_ID 순으로 구성함(부서명, 직급명으로 오름차순 정렬)
-- 생성된 테이블의 각 컬럼에 주석(COMMENT) 달기
CREATE TABLE PART_LIST
AS
SELECT DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
ORDER BY DEPT_NAME, JOB_TITLE;

SELECT * FROM PART_LIST;

COMMENT ON COLUMN PART_LIST.DEPT_NAME IS '부서명';
COMMENT ON COLUMN PART_LIST.JOB_TITLE IS '직급명';
COMMENT ON COLUMN PART_LIST.EMP_NAME IS '사원이름';
COMMENT ON COLUMN PART_LIST.EMP_ID IS '사번';


CREATE TABLE PHONEBOOK (
    ID CHAR(3),
    PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
    PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
    ADDRESS VARCHAR2(100) DEFAULT '서울시 구로구',
    
    CONSTRAINT PK_PBID PRIMARY KEY (ID),
    CONSTRAINT UN_PBPHONE UNIQUE (PHONE)
);

INSERT INTO PHONEBOOK VALUES ('A01', '홍길동', '010-1234-5678', DEFAULT);

SELECT * FROM PHONEBOOK;

CREATE TABLE CONSTRAINT_EMP2 (
    EID CHAR(3),
    ENAME VARCHAR2(20) CONSTRAINT NENAME2 NOT NULL,
    ENO VARCHAR2(14) CONSTRAINT NENO2 NOT NULL,
    EMAIL VARCHAR2(25),
    PHONE VARCHAR2(12),
    HIRE_DATE DATE DEFAULT SYSDATE,
    JID CHAR(2),
    SALARY NUMBER,
    BONUS_PCT NUMBER,
    MARRIAGE CHAR(1) DEFAULT 'N',
    MID CHAR(3),
    DID CHAR(2),
    
    CONSTRAINT PKEID2 PRIMARY KEY (EID),
    CONSTRAINT UENO2 UNIQUE (ENO),
    CONSTRAINT UEMAIL2 UNIQUE (EMAIL),
    CONSTRAINT FKJID2 FOREIGN KEY (JID) REFERENCES JOB ON DELETE SET NULL,
    CONSTRAINT CHK2 CHECK (MARRIAGE IN ('N', 'Y')),
    CONSTRAINT FKMID2 FOREIGN KEY (MID) REFERENCES CONSTRAINT_EMP2
                            ON DELETE SET NULL,
    CONSTRAINT FKDID2 FOREIGN KEY (DID) REFERENCES DEPARTMENT
                            ON DELETE CASCADE
);

ALTER TABLE CONSTRAINT_EMP2
DROP CONSTRAINT CHK2;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONSTRAINT_EMP2';

ALTER TABLE CONSTRAINT_EMP2
DROP CONSTRAINT FKJID2
DROP CONSTRAINT FKMID2
DROP CONSTRAINT FKDID2;

ALTER TABLE CONSTRAINT_EMP2
MODIFY (ENAME NULL, ENO NULL);

DESC USER_CONS_COLUMNS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, COLUMN_NAME,
                DELETE_RULE, SEARCH_CONDITION
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'CONSTRAINT_EMP2';

CREATE TABLE TB_EXAM (
    COL1 CHAR(3) PRIMARY KEY,
    ENAME VARCHAR2(20),
    FOREIGN KEY (COL1) REFERENCES EMPLOYEE
);

DESC TB_EXAM;

ALTER TABLE TB_EXAM
RENAME COLUMN COL1 TO EMPID;
DESC TB_EXAM;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, COLUMN_NAME,
                DELETE_RULE, SEARCH_CONDITION
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'TB_EXAM';

ALTER TABLE TB_EXAM
RENAME CONSTRAINT SYS_C008426 TO PK_TBE_EID;

ALTER TABLE TB_EXAM
RENAME CONSTRAINT SYS_C008427 TO FK_TBE_EID;

ALTER TABLE TB_EXAM RENAME TO TB_SAMPLE1;
--또는
RENAME TB_SAMPLE1 TO TB_SAMPLE;

DROP TABLE TB_SAMPLE;

CREATE TABLE DEPT (
    DID CHAR(2) PRIMARY KEY,
    DNAME VARCHAR2(10)
);

CREATE TABLE EMP5 (
    EID CHAR(3) PRIMARY KEY,
    ENAME VARCHAR2(10),
    DID CHAR(2) REFERENCES DEPT
);

DROP TABLE DEPT; --제거 불가
DROP TABLE DEPT CASCADE CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, COLUMN_NAME,
                DELETE_RULE, SEARCH_CONDITION
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'EMP5';