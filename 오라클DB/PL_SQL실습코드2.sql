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
DBMS_OUTPUT.PUT_LINE(PIDX||'�� ���� �����ϴ�');
--����ó�� ����

END;
/


SET SERVEROUTPUT ON

EXEC MEMO_FIND(5);
EXEC MEMO_FIND(100); --������ ���� ���
---------------------------------------------------------
--�μ���ȣ IN�Ķ���� �����ؼ� �ش� �μ���,��ġ ���
--�ϳ� �̻��� �����Ͱ��� ���� ������Ÿ��(���յ����� Ÿ��)
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
DBMS_OUTPUT.PUT_LINE(PNO||'�� �μ��� �����ϴ�');

END;
/

EXEC DEPT_INFO(1);

---------------------------------------------------------
--���(EMPNO)�� IN�Ķ���ͷ� �����ϸ�
--����� �̸�,����,�޿��� ������ ���
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
DBMS_OUTPUT.PUT_LINE(PNO||'�� ����� �����ϴ�');


END;
/

EXEC EMP_INFO(7369);
---------------------------------------------------------
--����� IN�Ķ���� �����ϸ� �ش� ����� �̸��� OUT�Ķ���ͷ� ������
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

--OUT�Ķ���� ���ν��� �����Ϸ��� ���� ���� �� ���ν��� ���� �ʿ�
VARIABLE NAME VARCHAR2(20);
EXEC EMP_FIND(7788, :NAME);
PRINT NAME;

---------------------------------------------------------
--����� IN�Ķ���ͷ� �����ϸ� �ش� ����� �̸�,�μ��� ���
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
    THEN VDNAME := 'ȸ��μ�';
ELSIF VDNO = 20
    THEN VDNAME := '�����μ�';
ELSIF VDNO = 30
    THEN VDNAME := '�����μ�';
ELSIF VDNO = 40
    THEN VDNAME := '��μ�';
ELSE
    VDNAME := '���ߺμ�';
END IF;

DBMS_OUTPUT.PUT_LINE('���: '||PNO);
DBMS_OUTPUT.PUT_LINE('�̸�: '||VNAME);
DBMS_OUTPUT.PUT_LINE('�μ���ȣ: '||VDNO);
DBMS_OUTPUT.PUT_LINE('�μ��� : ' || VDNAME);

END;
/

EXEC DEPT_SEARCH(7900);
---------------------------------------------------------
--MEMO���̺� '�̰��� ���� �޼��� 100'
CREATE OR REPLACE PROCEDURE LOOP_TEST
IS
    VCNT NUMBER(3) := 100;
BEGIN
    LOOP
        INSERT INTO MEMO(IDX, NAME, MSG, WDATE)
        VALUES(MEMO_SEQ.NEXTVAL, 'TEST', '�̰��� ���� �޼��� '||VCNT, SYSDATE);
        VCNT := VCNT+1;
        EXIT WHEN VCNT>105;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('������ �Է� �Ϸ�');
    DBMS_OUTPUT.PUT_LINE(VCNT-100||' ���� �����Ͱ� ���ԵǾ���');
END;
/

EXEC LOOP_TEST;
SELECT * FROM MEMO ORDER BY IDX DESC;
---------------------------------------------------------
--FOR������ ���
--REVERSE ������ ������ ���
DECLARE
BEGIN
    FOR K IN REVERSE 1 .. 10 LOOP
        DBMS_OUTPUT.PUT_LINE('HELLO'||K);
    END LOOP;
END;
/
---------------------------------------------------------
--DEPT���̺��� ��� �μ����� ���
--FOR������ ����(����)
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

--FOR������ ���
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
--WHILE LOOP��
DECLARE
    CNT NUMBER(3) := 1;
BEGIN
    WHILE CNT<5 LOOP
        INSERT INTO EMP(EMPNO, ENAME.HIREDATE)
        VALUES(CNT, 'TOM'||CNT, SYSDATE);
        CNT := CNT+1;
        EXIT WHEN CNT=3;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(CNT-1||' ���� ���ڵ� ����');
END;
/
SELECT * FROM EMP ORDER BY HIREDAE DESC;
ROLLBACK;
---------------------------------------------------------
--�μ��� ��ձ޿�, �ִ�/�ּұ޿�, �ο����� �����ͼ� ���
--�μ���ȣ, �ο���, ��ձ޿�, �ִ�޿�, �ּұ޿�

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
--�����ڵ�.
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
--�����ڵ�
--����� Ŀ�� �̿��ؼ� ������ ���ڵ� ����
create or replace procedure empsel
is
vno emp.empno%type:=0;
vname emp.ename%type:=null;
vsal emp.sal%type:=0;
vdate emp.hiredate%type;
--�����Ŀ�� ����
CURSOR EMP_CR IS
    SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP ORDER BY 1 ASC;
begin
--Ŀ�� OPEN
OPEN EMP_CR;
LOOP
    --������ ���� : FETCH
    FETCH EMP_CR INTO VNO, VNAME, VSAL, VDATE;
    EXIT WHEN EMP_CR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(VNO||' '||VNAME||' '||VSAL||' '||VDATE);
END LOOP;
--Ŀ�� CLOSE
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