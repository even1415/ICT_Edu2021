CREATE OR REPLACE PROCEDURE MEMO_FIND
(PIDX IN MEMO.IDX%TYPE)
IS
VNAME MEMO.NAME%TYPE;
VMSG MEMO.MSG%TYPE;
VDATE MEMO.WDATE%TYPE;
BEGIN
SELECT NAME, MSG, WDATE
INTO VNAME, VMSG, VDATE
FROM MEMO
WHERE IDX=PIDX;

DBMS_OUTPUT.PUT_LINE(VNAME||'  '||VDATE||' '||VMSG);

EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE(PIDX||'번 글은 없습니다');
--예외처리 구문

END;
/


SET SERVEROUTPUT ON

EXEC MEMO_FIND(5);
EXEC MEMO_FIND(100); --데이터 없는 경우
---------------------------------------------------------
--부서번호 IN파라미터 전달해서 해당 부서명,위치 출력
--하나 이상의 데이터값을 갖는 데이터타입(복합데이터 타입)
CREATE OR REPLACE PROCEDURE DEPT_INFO
(PNO IN DEPT.DEPTNO%TYPE)
IS
VDEPT DEPT%ROWTYPE;
BEGIN
SELECT DEPTNO, DNAME, LOC
INTO VDEPT.DEPTNO, VDEPT.DNAME, VDEPT.LOC
FROM DEPT
WHERE DEPTNO=PNO;

DBMS_OUTPUT.PUT_LINE(VDEPT.DEPTNO||' '||VDEPT.DNAME||' '||VDEPT.LOC);

EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE(PNO||'번 부서는 없습니다');

END;
/

EXEC DEPT_INFO(1);

---------------------------------------------------------
--사번(EMPNO)을 IN파라미터로 전달하면
--사원의 이름,업무,급여를 가져와 출력
CREATE OR REPLACE PROCEDURE EMP_INFO
(PNO IN EMP.EMPNO%TYPE)
IS
VEMP EMP%ROWTYPE;
VDEPT DEPT%ROWTYPE;
BEGIN
SELECT ENAME, JOB, SAL, DEPTNO
INTO VEMP.ENAME, VEMP.JOB, VEMP.SAL, VEMP.DEPTNO
FROM EMP
WHERE EMPNO=PNO;

SELECT DNAME, LOC
INTO VDEPT.DNAME, VDEPT.LOC
FROM DEPT
WHERE DEPTNO = VEMP.DEPTNO;

DBMS_OUTPUT.PUT_LINE(VEMP.ENAME||' '||VEMP.JOB||' '||VEMP.SAL||' '||VDEPT.DNAME||' '||VDEPT.LOC);

EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE(PNO||'번 사원은 없습니다');


END;
/

EXEC EMP_INFO(7369);
---------------------------------------------------------
--사번을 IN파라미터 전달하면 해당 사원의 이름을 OUT파라미터로 내보냄
CREATE OR REPLACE PROCEDURE EMP_FIND
(
    PNO IN EMP.EMPNO%TYPE,
    ONAME OUT EMP.ENAME%TYPE
)
IS

BEGIN
SELECT ENAME INTO ONAME
FROM EMP
WHERE EMPNO=PNO;
END;
/

--OUT파라미터 프로시저 실행하려면 변수 실행 후 프로시저 실행 필요
VARIABLE NAME VARCHAR2(20);
EXEC EMP_FIND(7788, :NAME);
PRINT NAME;

---------------------------------------------------------
--사번을 IN파라미터로 전달하면 해당 사원의 이름,부서명 출력
CREATE OR REPLACE PROCEDURE DEPT_SEARCH
(PNO IN NUMBER)
IS
VDNO EMP.DEPTNO%TYPE;
VNAME EMP.ENAME%TYPE;
VDNAME VARCHAR2(30);
BEGIN
SELECT DEPTNO, ENAME
INTO VDNO, VNAME
FROM EMP
WHERE EMPNO = PNO;

IF VDNO = 10
    THEN VDNAME := '회계부서';
ELSIF VDNO = 20
    THEN VDNAME := '연구부서';
ELSIF VDNO = 30
    THEN VDNAME := '영업부서';
ELSIF VDNO = 40
    THEN VDNAME := '운영부서';
ELSE
    VDNAME := '개발부서';
END IF;

DBMS_OUTPUT.PUT_LINE('사번: '||PNO);
DBMS_OUTPUT.PUT_LINE('이름: '||VNAME);
DBMS_OUTPUT.PUT_LINE('부서번호: '||VDNO);
DBMS_OUTPUT.PUT_LINE('부서명 : ' || VDNAME);

END;
/

EXEC DEPT_SEARCH(7900);
---------------------------------------------------------
--MEMO테이블에 '이것이 나의 메세지 100'
CREATE OR REPLACE PROCEDURE LOOP_TEST
IS
    VCNT NUMBER(3) := 100;
BEGIN
    LOOP
        INSERT INTO MEMO(IDX, NAME, MSG, WDATE)
        VALUES(MEMO_SEQ.NEXTVAL, 'TEST', '이것이 나의 메세지 '||VCNT, SYSDATE);
        VCNT := VCNT+1;
        EXIT WHEN VCNT>105;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('데이터 입력 완료');
    DBMS_OUTPUT.PUT_LINE(VCNT-100||' 개의 데이터가 삽입되었음');
END;
/

EXEC LOOP_TEST;
SELECT * FROM MEMO ORDER BY IDX DESC;
---------------------------------------------------------
--FOR루프문 사용
--REVERSE 있으면 역방향 출력
DECLARE
BEGIN
    FOR K IN REVERSE 1 .. 10 LOOP
        DBMS_OUTPUT.PUT_LINE('HELLO'||K);
    END LOOP;
END;
/
---------------------------------------------------------
--DEPT테이블의 모든 부서정보 출력
--FOR루프문 비사용(오류)
CREATE OR REPLACE PROCEDURE DEPT_ALL
IS
VDEPT DEPT%ROWTYPE;
BEGIN
    SELECT * INTO VDEPT
    FROM DEPT;
    
    DBMS_OUTPUT.PUT_LINE(VDEPT.DNAME);
END;
/

EXEC DEPT_ALL;

--FOR루프문 사용
CREATE OR REPLACE PROCEDURE DEPT_ALL
IS

BEGIN
    FOR K IN (SELECT * FROM DEPT ORDER BY DEPTNO) LOOP
    DBMS_OUTPUT.PUT_LINE(K.DEPTNO||' '||K.DNAME||' '||K.LOC);
    END LOOP;
END;
/

EXEC DEPT_ALL;

---------------------------------------------------------
--WHILE LOOP문
DECLARE
    CNT NUMBER(3) := 1;
BEGIN
    WHILE CNT<5 LOOP
        INSERT INTO EMP(EMPNO, ENAME.HIREDATE)
        VALUES(CNT, 'TOM'||CNT, SYSDATE);
        CNT := CNT+1;
        EXIT WHEN CNT=3;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(CNT-1||' 개의 레코드 삽입');
END;
/
SELECT * FROM EMP ORDER BY HIREDAE DESC;
ROLLBACK;
---------------------------------------------------------
--부서별 평균급여, 최대/최소급여, 인원수를 가져와서 출력
--부서번호, 인원수, 평균급여, 최대급여, 최소급여

SELECT DEPTNO, COUNT(EMPNO), ROUND(AVG(SAL),2), MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;
--------------------------
CREATE OR REPLACE PROCEDURE DEPT_SAL
IS
BEGIN
    FOR K IN (SELECT DEPTNO, COUNT(EMPNO) CNT, ROUND(AVG(SAL), 2) AG, MAX(SAL) MX, MIN(SAL) MN
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO) LOOP
        DBMS_OUTPUT.PUT_LINE(K.DEPTNO||' '||K.CNT||' '||K.AG||' '||K.MX||' '||K.MN);    
    END LOOP;
END;
/
--------------------------
EXEC DEPT_SAL;


---------------------------------------------------------
--오류코드.
create or replace procedure empsel
is
vno emp.empno%type:=0;
vname emp.ename%type:=null;
vsal emp.sal%type:=0;
vdate emp.hiredate%type;
begin
select empno,ename,sal,hiredate
into vno,vname,vsal,vdate from emp;
end;
/
---------------------------------------------------------
--수정코드
--명시적 커서 이용해서 여러개 레코드 추출
create or replace procedure empsel
is
vno emp.empno%type:=0;
vname emp.ename%type:=null;
vsal emp.sal%type:=0;
vdate emp.hiredate%type;
--명시적커서 선언
CURSOR EMP_CR IS
    SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP ORDER BY 1 ASC;
begin
--커서 OPEN
OPEN EMP_CR;
LOOP
    --데이터 추출 : FETCH
    FETCH EMP_CR INTO VNO, VNAME, VSAL, VDATE;
    EXIT WHEN EMP_CR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(VNO||' '||VNAME||' '||VSAL||' '||VDATE);
END LOOP;
--커서 CLOSE
CLOSE EMP_CR;
END;
/

EXEC EMPSEL;
---------------------------------------------------------
CREATE OR REPLACE PROCEDURE MEMO_ALL
(MYCR OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN MYCR
    FOR
    SELECT IDX, NAME, MSG,WDATE
    FROM MEMO
    ORDER BY IDX DESC;
END;
/