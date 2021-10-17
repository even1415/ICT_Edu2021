--2. 아래에서 요구되는 제약조건이 설정된 테이블 생성 DDL구문과
--각 컬럼에 설명(COMMENT)을 지정하는 구문을 [원인](30점)에 기술하고,
--아래의 요구사항에 대한 조회구문을 오라클 전용구문과
--ANSI 표준 구문으로 각각 [조치내용](30점)에 작성하시오. (60점). ( 60점 )

/*
원인 : 제약조건이 설정된 테이블 만들기
테이블명 : PHONEBOOK
컬럼명 : ID CHAR(3) 기본키(저장이름 : PK_PBID) (설명 : 아이디)
    PNAME   VARCHAR2(20) 널 사용못함. (설명 : 이름)
                (NN_PBNAME) 
    PHONE   VARCHAR2(15) 널 사용못함 (설명 : 전화번호)
                 (NN_PBPHONE)
                중복값 입력못함
                (UN_PBPHONE)
    ADDRESS  VARCHAR2(100) 기본값 지정함 (설명 : 주소)
                '서울시 구로구'
* NOT NULL을 제외하고, 모두 테이블 레벨에서 지정함. 제약조건 저장이름 반드시 지정함
* 각 컬럼에 설명 지정함

조치내용 : 직급이 대리이면서, 아시아지역에 근무하는 직원 정보를 조회하시오.
* 오라클 전용구문과 ANSI 표준구문으로 각각 작성하시오
테이블 : EMPLOYEE, JOB, DEPARTMENT, LOCATION, COUNTRY, SAL_GRADE
조회할 컬럼 : emp_name 사원명, dept_name 소속부서명, job_title 직급명, loc_describe 근무지역명, 
         country_name 국가명, salary 급여, slevel 급여등급
*/

---------------답안작성---------------
--원인 :
CREATE TABLE PHONEBOOK2 (
    ID CHAR(3) PRIMARY KEY,
    PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
    PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
    ADDRESS VARCHAR2(100) DEFAULT '서울시 구로구',
    
    CONSTRAINT PK_PBID PRIMARY KEY (ID),
    CONSTRAINT UN_PBPHONE UNIQUE (PHONE)
);
COMMENT ON COLUMN PHONEBOOK2.ID IS '아이디';
COMMENT ON COLUMN PHONEBOOK2.PNAME IS '이름';
COMMENT ON COLUMN PHONEBOOK2.PHONE IS '전화번호';
COMMENT ON COLUMN PHONEBOOK2.ADDRESS IS '주소';

--해결 :
--오라클 VER.
SELECT emp_name 사원명, dept_name 소속부서명, job_title 직급명, loc_describe 근무지역명, 
         country_name 국가명, salary 급여, slevel 급여등급
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L, COUNTRY C, SAL_GRADE S
WHERE E.DEPT_ID = D.DEPT_ID AND E.JOB_ID = J.JOB_ID
            AND D.LOC_ID = L.LOCATION_ID AND L.COUNTRY_ID = C.COUNTRY_ID
            AND JOB_TITLE = '대리' AND LOC_DESCRIBE LIKE '아시아%'
            AND SLEVEL = (SELECT SLEVEL
                                        FROM SAL_GRADE
                                        WHERE SALARY >= LOWEST AND SALARY <= HIGHEST);
--ANSI VER.
SELECT emp_name 사원명, dept_name 소속부서명, job_title 직급명, loc_describe 근무지역명, 
         country_name 국가명, salary 급여, slevel 급여등급
FROM SAL_GRADE, EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING (COUNTRY_ID)
WHERE JOB_TITLE = '대리' AND LOC_DESCRIBE LIKE '아시아%'
            AND SLEVEL = (SELECT SLEVEL
                                        FROM SAL_GRADE
                                        WHERE SALARY >= LOWEST AND SALARY <= HIGHEST);