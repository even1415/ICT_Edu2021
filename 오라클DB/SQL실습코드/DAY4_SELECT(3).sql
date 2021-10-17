--DAY4. SELECT(3)

--LTRIM, RTRIM / 왼쪽의 문자열 목록에서 오른쪽의 문자 목록 제거
--(문자열 제거가 아니라, 문자 목록 각각의 단위로 모두 찾아서 다른게 나올때까지 제거)
SELECT '     0123456ABCDabxyORACLExxxxyyyyzyx532     ',
            LTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     '),
            LTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ',' '),
            LTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ', ' 0123456789'),
            LTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ', ' 0123456ABCDybax')
FROM DUAL;

SELECT '     0123456ABCDabxyORACLExxxxyyyyzyx532     ',
            RTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     '),
            RTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ',' '),
            RTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ', ' 0123456789'),
            RTRIM('     0123456ABCDabxyORACLExxxxyyyyzyx532     ', ' 0123456789xyz')
FROM DUAL;

--TRIM(LEADING(왼쪽) | TRAILING(오른쪽) | BOTH(양쪽/기본값) '제거할문자 1개' FROM '대상 문자열 값 | 컬럼명')
SELECT 'aaORACLEaa',
            TRIM(/*BOTH*/ 'a' FROM 'aaORACLEaa'),
            TRIM(LEADING 'a' FROM 'aaORACLEaa'),
            TRIM(TRAILING 'a' FROM 'aaORACLEaa')
FROM DUAL;

--SUBSTR('문자열' | 컬럼명, 추출할 시작위치, 추출할 글자수)
--추출할 시작위치 : 양수-앞에서부터 / 음수-뒤에서부터
--추출할 글자수 : 생략 시 글자 끝까지 모두 읽음
SELECT 'ORACLE 18C',
            SUBSTR('ORACLE 18C', 5),
            SUBSTR('ORACLE 18C', 8, 2),
            SUBSTR('ORACLE 18C', -7, 3)
FROM DUAL;

--직원들 주민번호에서 생년,생월,생일 분리조회 / 별칭 적용
SELECT EMP_NAME, EMP_NO,
            SUBSTR(EMP_NO, 1, 2) "생년",
            SUBSTR(EMP_NO, 3, 2) "생월",
            SUBSTR(EMP_NO, 5, 2) "생일"
FROM EMPLOYEE;

--직원들 입사일에서 입사년도, 입사월, 입사일 분리조회 / 별칭 적용
SELECT EMP_NAME, HIRE_DATE,
            SUBSTR(HIRE_DATE, 1,2) "입사년도",
            SUBSTR(HIRE_DATE, 4,2) "입사월",
            SUBSTR(HIRE_DATE, 7,2) "입사일"
FROM EMPLOYEE;

--SUBSTRB('문자열' | 컬럼명, 추출할 시작바이트 위치, 추출할 바이트)
SELECT SUBSTR('ORACLE', 3, 2), --AC
            SUBSTRB('ORACLE', 3, 2), --AC
            SUBSTR('오라클', 2, 2), --라클
            SUBSTRB('오라클', 4, 6) --라클
FROM DUAL;

--UPPER : 영문자일 때 대문자로 변경
--LOWER : 영문자일 때 소문자로 변경
--INITCAP : 영문자일 때 첫글자만 대문자로 변경
SELECT UPPER('oracle'), LOWER('ORACLE'), INITCAP('oracle')
FROM DUAL;

--함수 중첩 사용
--직원 정보에서 이름, 아이디 조회
--아이디는 이메일에서 분리추출
SELECT EMP_NAME "이름", 
            SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) "아이디"
FROM EMPLOYEE;

--함수 중첩 사용
--직원 정보에서 이름, 주민번호 조회
--주민번호는 000000-0****** 양식으로 뒷6자리를 '*' 처리
SELECT EMP_NAME "이름", RPAD(SUBSTR(EMP_NO, 1, 8), 14 /*LENGTH(EMP_NO)*/, '*')
FROM EMPLOYEE;

--직원 정보에서 사번,이름,급여,보너스포인트, 보너스포인트 적용 연봉
--연봉은 별칭 처리 : 1년급여
--연봉은 천단위에서 반올림
SELECT EMP_ID "사번", EMP_NAME "이름", SALARY "급여", BONUS_PCT "보너스포인트",
            ROUND(((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12), -4) "1년급여"
FROM EMPLOYEE;

--입사일-오늘, 오늘-입사일 조회 "근무일수"
--오늘 날짜 구하는 함수 : SYSDATE
SELECT EMP_NAME, HIRE_DATE,
            FLOOR(ABS(HIRE_DATE-SYSDATE)) "근무일수"
FROM EMPLOYEE;

--직원 정보에서 사번이 홀수인 직원들 조회
--사번, 이름
SELECT EMP_ID "사번", EMP_NAME "이름"
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

--날짜 처리함수(시스템으로부터 현재 날짜,시간 조회)
SELECT SYSDATE
FROM DUAL;

--직원들 중 근무년수가 20년 이상된 직원정보 조회
--사번,이름,부서코드,직급코드,입사일
SELECT EMP_ID "사번", EMP_NAME "이름", JOB_ID "부서코드", DEPT_ID "직급코드"
FROM EMPLOYEE
WHERE ADD_MONTHS(HIRE_DATE,240) <= SYSDATE;

--직원 이름,입사일,근무년수1~2
--근무년수1 : 오늘날짜 기준으로 EXTRACT
--근무년수2 : 오늘날짜 기준으로 MONTHS_BETWEEN
SELECT EMP_NAME "이름", HIRE_DATE "입사일",
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무년수1",
            FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "근무년수2"
FROM EMPLOYEE;

--직원정보에서 이름, 입사일 조회
--입사일은 포멧 적용 : '0000년 0월 00일 (목)'
SELECT EMP_NAME "이름",
            TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일 ("DY")"') "입사일"
FROM EMPLOYEE;