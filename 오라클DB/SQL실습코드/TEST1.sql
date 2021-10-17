--1. SELECT 구문의 SELECT, FROM. WHERE 절을 실행 순서대로 나열하고, 각 절의 사용형식을 작성하시오.. ( 40점 )
--
--SELECT (검색할 컬럼) FROM (검색 대상인 테이블) WHERE (조건문);
--
--<실행순서>
--1. FROM 절의 테이블로 이동
--2. WHERE 절의 조건문을 실행
--3. WHERE 절의 조건문에 부합하는 SELECT 절의 컬럼을 검색
--
--<사용형식>
--1. SELECT
--SQL문의 끝은 반드시 세미콜론(;) 혹은 슬래시(/) 가 붙어야하며,
--(슬래시는 개행해서 작성해야함)
--키워드, 테이블 이름, 컬럼 이름은 약자로 줄여쓰거나 엔터(개행)로 분리해서 작성할 수 없음
--또한, 모든 컬럼을 조회하는 경우 별표(*) 를 사용해서 표현하며, 여러 컬럼을 조회할 경우 쉼표(,) 로 구분
--
--2. FROM
--검색 대상인 테이블을 적는다. 
--
--3. WHERE
--제한 조건을 여러개 포함할 경우 논리 연산자(AND, OR)로 연결

--오늘 날짜 기준으로 입사일(HIRE_DATE)을 사용하여 근무년수를 계산하여 정수로 표시되게 한다. (별칭 : 근무년수)
--주민번호(EMP_NO)에서 생년, 생월, 생일을 각각 추출하여, 연결연산자를 사용하여 '77년 11월 15일' 로 표시되게 한다. (별칭 : 생일)
--입사일(HIRE_DATE)은 포멧을 적용하여, '1998년 12월 30일 (목) 입사' 로 표시되게 한다. (별칭 : 입사일)
--보너스포인트(BONUS_PCT) 컬럼값은 포멧을 적용하여 출력시 NULL 은 0.00 으로 표시되게 한다. (별칭 : 보너스포인트)
--급여(SALARY)는 포멧을 적용하여 '￦35,000,000' 으로 표시되게 한다.
--아이디는 이메일(EMAIL)에서 추출하여 표시한다.
--조회항목 - 사번, 이름, 아이디, 생일, 급여, 보너스포인트, 입사일, 근무년수 (모두 별칭 처리함)

SELECT EMP_ID "사번", EMP_NAME "이름",
            SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) "아이디",
            SUBSTR(EMP_NO, 1, 2)||'년 '||SUBSTR(EMP_NO, 3, 2)||'월 '||SUBSTR(EMP_NO, 5, 2)||'일' "생일",
            TO_CHAR(SALARY, 'L99,999,999') "급여",
            TO_CHAR(NVL(BONUS_PCT, 0),'0.99') "보너스포인트",
            TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" "("DY")"') "입사일",
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무년수"
FROM EMPLOYEE;

--직원 정보가 저장된 EMPLOYEE 테이블에서
--사원명(EMP_NAME), 입사일(HIRE_DATE), 오늘 날짜 기준 현재까지의 근무년수를 조회하는 SELECT 문을 작성하시오.. ( 15점 )
--조회한 컬럼명과 계산식에는 별칭 적용한다. (EMP_NAME 이름, HIRE_DATE 입사일, 계산식 근무년수)
--근무년수는 정수로 출력되게 한다.
SELECT EMP_NAME "이름", HIRE_DATE "입사일",
            FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "근무년수"
FROM EMPLOYEE;

--6. 직원 정보를 저장한 EMPLOYEE 테이블에서 주민번호를 이용하여
--남자직원의 사원명(EMP_NAME)과 주민번호(EMP_NO)를 조회되도록 SELECT 구문을 기술하시오.. ( 25점 )
--조회결과에 컬럼명은 별칭 처리하시오. => EMP_NAME 사원명, EMP_NO 주민번호

SELECT EMP_NAME "사원명", EMP_NO"주민번호"
FROM EMPLOYEE
WHERE MOD(SUBSTR(EMP_NO, 8, 1), 2) = 1;