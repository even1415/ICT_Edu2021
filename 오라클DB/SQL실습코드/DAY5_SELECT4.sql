SELECT EMP_NAME "이름", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "입사일"
FROM EMPLOYEE;
--WHERE EMP_ID = '100';

--날짜,시간 같이 기록된 경우는 비교연산시 날짜만 가지고 비교 불가
SELECT EMP_NAME "이름", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "입사일"
FROM EMPLOYEE
WHERE HIRE_DATE = '90/04/01'; --결과 안나옴

--해결1
SELECT EMP_NAME "이름", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "입사일"
FROM EMPLOYEE
WHERE TO_CHAR(HIRE_DATE, 'YY/MM/DD') = '90/04/01';

--해결2
SELECT EMP_NAME "이름", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "입사일"
FROM EMPLOYEE
WHERE HIRE_DATE LIKE '90/04/01%';

--해결3
SELECT EMP_NAME "이름", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "입사일"
FROM EMPLOYEE
WHERE SUBSTR(HIRE_DATE, 1, 8) = '90/04/01';

--NVL2() 함수
--직원정보에서 보너스포인트 0.2 미만 OR NULL 직원 조회
--사번, 이름, 보너스포인트, 변경보너스포인트
--변경보너스포인트 = 보너스포인트 컬럼에 값 있으면 0.15로 변경, 없으면 0.05
SELECT EMP_ID "사번", EMP_NAME "이름", BONUS_PCT "보너스포인트",
            NVL2(BONUS_PCT, 0.15, 0.05) "변경보너스포인트"
FROM EMPLOYEE
WHERE BONUS_PCT < 0.2 OR BONUS_PCT IS NULL;

--50번 부서에 소속된 직원들의 이름,성별 조회
--성별 기준 : 주민번호 8번째 값이 1,3이면 남자 / 2,4이면 여자
SELECT EMP_NAME "이름", EMP_NO "주민번호",
            DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자', '3', '남자', '4', '여자')
FROM EMPLOYEE
WHERE DEPT_ID = '50';


--1. 직원명과 주민번호를 조회함
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
SELECT EMP_NAME 이름,
        RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민번호
FROM EMPLOYEE;

--2. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT EMP_NAME 이름, JOB_ID 직급코드, 
        TO_CHAR(ROUND(((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12), -4), 'L99,999,999') "연봉(원)"
FROM EMPLOYEE;

--3. 부서코드가 50, 90인 직원들 중에서 2004년도에 입사한 직원 조회
--	사번 사원명 부서코드 입사일
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_ID 부서코드, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE DEPT_ID IN('50','90') AND SUBSTR(HIRE_DATE, 1, 2) = '04';


--4. 직원명, 입사일, 입사한 달의 근무일수 조회
--  단, 주말도 포함함
SELECT EMP_NAME 사원명, HIRE_DATE 입사일,
            LAST_DAY(HIRE_DATE) - HIRE_DATE "입사 첫달 근무일수"
FROM EMPLOYEE;


--5. 직원명, 부서코드, 생년월일, 나이(만) 조회
--  단, 생년월일은 주민번호에서 추출해서, 
--     ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--  나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
SELECT EMP_NAME 사원명, DEPT_ID 부서코드, 
            SUBSTR(EMP_NO, 1, 2)||'년 '||SUBSTR(EMP_NO, 3, 2)||'월 '||SUBSTR(EMP_NO, 5, 2)||'일' 생년월일,
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')) "나이"
FROM EMPLOYEE;

--6. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--  아래의 년도에 입사한 인원수를 조회하시오.
--  => to_char, decode, sum 사용
--	-------------------------------------------------------------
--	전체직원수   2001년   2002년   2003년   2004년
--	-------------------------------------------------------------
SELECT COUNT(*) 전체직원수,
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2001, 1, 0)) "2001년",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2002, 1, 0)) "2002년",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2003, 1, 0)) "2003년",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2004, 1, 0)) "2004년"
FROM EMPLOYEE;

--7.  부서코드가 50이면 총무부, 60이면 기획부, 90이면 영업부로 처리하시오.
--   단, 부서코드가 50, 60, 90 인 직원의 정보만 조회함
--  => case 사용
--	부서코드 기준 오름차순 정렬함.
SELECT DEPT_ID 부서코드,
            CASE DEPT_ID WHEN '50' THEN '총무부'
                                  WHEN '60' THEN '기획부'
                                  WHEN '90' THEN '영업부'
            END AS "부서명"
FROM EMPLOYEE
WHERE DEPT_ID IN('50', '60', '90')
ORDER BY DEPT_ID ASC;