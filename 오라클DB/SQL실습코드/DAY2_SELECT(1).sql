-- SELECT 문 연습

-- 직원 테이블의 전체 데이터 조회
SELECT * FROM EMPLOYEE;


--특정 컬럼의 값 조회
SELECT EMP_NAME, PHONE, SALARY
FROM EMPLOYEE;

--특정 행(ROW) 조회하는 경우
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '20';

--여러 개의 테이블을 합쳐서 조회, 원하는 컬럼을 선택
SELECT EMP_ID, EMP_NAME, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

--SELECT 사용 예 
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE;

--SELECT 절에 컬럼값에 대한 계산식 사용
--사번, 이름 ,급여, 급여에 대한 연봉, 보너스포인트 적용된 연봉
--NVL(인자, 바꿀 값) 사용하면 NULL 값을 바꿀 값으로 변경 후 계산가능
--큰따옴표로 "별칭"설정가능(ALIAS)
SELECT EMP_ID, EMP_NAME, SALARY, 
SALARY*12 "1년 급여(연봉)", 
(SALARY + (SALARY * NVL(BONUS_PCT,0))) *12 "보너스포인트 적용 연봉"
FROM EMPLOYEE;

SELECT LENGTHB('한글'), LENGTHB('ORACLE')
FROM DUAL; --오라클 정품은 한글1글자가 2바이트 / XE에서는 3바이트

--SELECT 절에 리터럴(임의의 문자열 값) 사용가능
--가상의 컬럼이 하나 추가
SELECT EMP_ID, EMP_NAME, 
'재직' AS 근무여부
FROM EMPLOYEE;

--직원 테이블에 사용된 직급코드 목록 조회
SELECT DISTINCT JOB_ID --같은 값은 1개만 보여줌(중복값 제거)
FROM EMPLOYEE;

--WHERE 절 사용
SELECT * 
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND SALARY > 2000000;

SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90' OR DEPT_ID = '20';