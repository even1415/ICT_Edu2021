--DAY3. SELECT(2)

--연습 1 : 급여가 200만이상~400만이하 직원의
--사번, 이름, 급여, 직급코드, 부서코드 조회 / 별칭 사용

SELECT EMP_ID "사번", EMP_NAME "이름", SALARY "급여", JOB_ID "직급코드", DEPT_ID "부서코드"
FROM EMPLOYEE
WHERE SALARY>=2000000 AND SALARY<=4000000;

--연습 2:
--입사일이 1995년 1월1일부터 ~ 2000년 12월31일 사이에 입사한 직원의
--사번,이름,입사일,부서코드 조회 / 별칭 사용
--날짜 데이터는 기록된 포멧과 일치되게 작성
--작은 따옴표로 묶어서 표현  : '1995/01/01' 또는 '95/01/01'
SELECT EMP_ID "사번", EMP_NAME "이름", HIRE_DATE "입사일", DEPT_ID "부서코드"
FROM EMPLOYEE
WHERE HIRE_DATE>='95/01/01' AND HIRE_DATE<='00/12/31';
--WHERE HIRE_DATE BETWEEN '95/01/01' AND '00/12/31'

--연결연산자 : || (자바의 println 메소드에서 문자열 + 연산자[문자열 합병] 기능)
SELECT EMP_NAME || ' 직원의 급여는 ' || SALARY || '원 입니다.' AS "급여정보"
FROM EMPLOYEE
WHERE DEPT_ID = '90';

--연습 3:
--2000년 1월1일 이후 입사한 기혼인 직원의
--이름,입사일,직급코드,부서코드,급여,결혼여부 조회 / 별칭 사용
--입사날짜 뒤에 ' 입사', 급여값 뒤에 ' (원)' 문자연결 출력
--결혼여부는 '기혼' 리터럴 사용
SELECT EMP_NAME "이름", HIRE_DATE  || ' 입사' AS "입사일", JOB_ID "직급코드", 
             DEPT_ID "부서코드", SALARY || ' (원)' AS "급여", '기혼' AS "결혼여부"
FROM EMPLOYEE
WHERE MARRIAGE='Y' AND HIRE_DATE>='00/01/01';
--※한선기 입사일은 2090년이라 출력에 포함됨

--성이 김씨인 직원정보 조회
SELECT EMP_ID "사번", EMP_NAME "이름", EMP_NO "주민번호", PHONE "전화번호"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '김%';

--직원 이름에 '해' 자 포함
SELECT EMP_ID "사번", EMP_NAME "이름", EMP_NO "주민번호", PHONE "전화번호"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%해%';

--전화번호 국번(4번째 자리값)이 '9'인 직원정보 조회
--이름, 전화번호 / 별칭 적용
SELECT EMP_NAME "이름", PHONE "전화번호"
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--연습 :
--성별이 여자인 직원(주민번호 2)
SELECT EMP_ID "사번", EMP_NAME "이름", EMP_NO "주민번호", PHONE "전화번호"
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%';

--기록값인 '_'와 와일드카드 '_'가 구분 안되는 경우
--기록값 구분 목적의 ESCAPE 사용(구별을 위해 임의문자 하나 표시)
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--부서,직급 배정없는 직원 조회
--사번,이름,직급코드,부서코드
--(컬럼)=NULL 사용불가(결과가 안나오는 에러)
SELECT EMP_ID "사번", EMP_NAME "이름", JOB_ID "직급코드", DEPT_ID "부서코드"
FROM EMPLOYEE
WHERE JOB_ID IS NULL AND DEPT_ID IS NULL;

---보너스포인트 없는 직원 조회
--사번,이름,부서코드,보너스포인트
SELECT EMP_ID "사번", EMP_NAME "이름", DEPT_ID "부서코드", BONUS_PCT "보너스포인트"
FROM EMPLOYEE
WHERE BONUS_PCT IS NULL;

--부서 배정x, 관리자는 있는 직원
--사번,이름,관리자사번,부서코드
SELECT EMP_ID "사번", EMP_NAME "이름", MGR_ID "관리자사번", DEPT_ID "부서코드"
FROM EMPLOYEE
WHERE DEPT_ID IS NULL AND MGR_ID IS NOT NULL; --0개

--부서 배정x, 보너스포인트는 받는 직원
--사번,이름,보너스포인트,부서코드
SELECT EMP_ID "사번", EMP_NAME "이름", DEPT_ID "부서코드", BONUS_PCT "보너스포인트"
FROM EMPLOYEE
WHERE BONUS_PCT IS NOT NULL AND DEPT_ID IS NULL;


--SELECT 연습문제

--1. 부서코드 90, 직급코드 J2인 직원들의
--사번,이름,부서코드,직급코드,급여 조회 / 별칭 적용
SELECT EMP_ID "사번", EMP_NAME "이름", SALARY "급여", JOB_ID "직급코드", DEPT_ID "부서코드"
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND JOB_ID = 'J2';

--2. 입사일이 '1982-01-01' 이후거나, 직급코드가 J3인 직원들의
--사번,이름,관리자 사번, 보너스포인트 조회
SELECT EMP_ID "사번", EMP_NAME "이름", MGR_ID "관리자사번", BONUS_PCT "보너스포인트"
FROM EMPLOYEE
WHERE HIRE_DATE>='1982/01/01' OR JOB_ID = 'J3';

--3. 직급코드가 J4가 아닌 직원들의 급여와 보너스포인트가 적용된 연봉을 조회함.
--  별칭 적용함, 사번, 사원명, 직급코드, 연봉(원)
--  단, 보너스포인트가 null 일 때는 0으로 바꾸어 계산하도록 함.
SELECT EMP_ID "사번", EMP_NAME "이름", JOB_ID "직급코드",
            (SALARY + (SALARY * NVL(BONUS_PCT,0))) *12 || ' (원)' "연봉"
FROM EMPLOYEE
WHERE JOB_ID != 'J4';

--4. 보너스포인트가 0.1 이상 0.2 이하인 직원들의 사번, 사원명, 이메일, 급여, 보너스포인트 조회함
SELECT EMP_ID "사번", EMP_NAME "사원명", EMAIL "이메일", SALARY "급여", BONUS_PCT "보너스포인트"
FROM EMPLOYEE
WHERE BONUS_PCT BETWEEN 0.1 AND 0.2;

--5. 보너스포인트가 0.1 보다 작거나(미만), 0.2 보다 많은(초과) 직원들의 사번, 사원명, 보너스포인트, 급여, 입사일 조회함
SELECT EMP_ID "사번", EMP_NAME "사원명", BONUS_PCT "보너스포인트", SALARY "급여", HIRE_DATE "입사일"
FROM EMPLOYEE
WHERE BONUS_PCT<0.1 AND BONUS_PCT>0.2;
--WHERE BONUS_PCT NOT BETWEEN 0.1 AND 0.2;

--6. '1982-01-01' 이후에 입사한 직원들의 사원명, 보너스포인트, 급여 조회함
SELECT EMP_NAME "이름",  BONUS_PCT "보너스포인트", SALARY "급여"
FROM EMPLOYEE
WHERE HIRE_DATE>='1982/01/01';

--7. 보너스포인트가 0.1, 0.2 인 직원들의 사번, 사원명, 보너스포인트, 전화번호 조회함
SELECT EMP_ID "사번", EMP_NAME "사원명", BONUS_PCT "보너스포인트", PHONE "전화번호"
FROM EMPLOYEE
WHERE BONUS_PCT IN(0.1, 0.2);
--WHERE BONUS_PCT=0.1 OR BONUS_PCT=0.2;

--8. 보너스포인트가 0.1도 0.2도 아닌 직원들의 사번, 사원명, 보너스포인트, 주민번호 조회함
SELECT EMP_ID "사번", EMP_NAME "사원명", BONUS_PCT "보너스포인트", EMP_NO "주민번호"
FROM EMPLOYEE
WHERE BONUS_PCT NOT IN(0.1, 0.2);
--WHERE BONUS_PCT!=0.1 AND BONUS_PCT!=0.2;

--9. 성이 '이'씨인 직원들의 사번, 사원명, 입사일 조회함
--  단, 입사일 기준 오름차순 정렬함
SELECT EMP_ID "사번", EMP_NAME "사원명", HIRE_DATE "입사일"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%'
ORDER BY HIRE_DATE ASC;

--10. 주민번호 8번째 값이 '2'인 직원의 사번, 사원명, 주민번호, 급여를 조회함
--  단, 급여 기준 내림차순 정렬함
SELECT EMP_ID "사번", EMP_NAME "사원명", EMP_NO "주민번호", SALARY "급여"
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%'
ORDER BY SALARY DESC;