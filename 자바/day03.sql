CREATE OR REPLACE PROCEDURE DEPT_EMP_INFO
(DNO IN DEPT.DEPTNO%TYPE)
IS
VEMP EMP%ROWTYPE;
BEGIN
--    SELECT EMPNO, ENAME, DEPTNO
--    INTO VEMP.EMPNO, VEMP.ENAME, VEMP.DEPTNO
--    FROM EMP
--    WHERE DEPTNO = DNO;
    FOR K IN (SELECT EMPNO, ENAME,DEPTNO FROM EMP WHERE DEPTNO=DNO) LOOP
    
    DBMS_OUTPUT.PUT_LINE('��� : '||VEMP.EMPNO);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||VEMP.ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ : '||VEMP.DEPTNO);
    
    DBMS_OUTPUT.PUT_LINE('��� : '||K.EMPNO);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||K.ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ : '||K.DEPTNO);
    
    END LOOP;

    EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('TOO MANY ROWS : �����Ͱ� �ʹ� ����');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('NO DATA FOUND : �����Ͱ� ����');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ���� �߻�');
END;
/

SET SERVEROUTPUT ON

EXEC DEPT_EMP_INFO(10);
--------------------------------------------------------------------------------------
--[1] �����
CREATE OR REPLACE PACKAGE EMPINFO AS
PROCEDURE ALLEMP;
PROCEDURE ALLSAL;
END EMPINFO;
/

--[2] ��������
CREATE OR REPLACE PACKAGE BODY EMPINFO AS
PROCEDURE ALLEMP
IS
    CURSOR EMPCR IS
        SELECT EMPNO, ENAME FROM EMP ORDER BY 1;
BEGIN
    FOR K IN EMPCR LOOP
        DBMS_OUTPUT.PUT_LINE(K.EMPNO|| LPAD(K.ENAME, 16,' '));
    END LOOP;
    EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ���� �߻�');
END ALLEMP;

PROCEDURE ALLSAL
IS
BEGIN
    FOR K IN ( SELECT ROUND(AVG(SAL)) AG_SAL, MAX(SAL) MX_SAL, MIN(SAL) MN_SAL FROM EMP) LOOP
        DBMS_OUTPUT.PUT_LINE(K.AG_SAL|| LPAD(K.MX_SAL,10,' ')|| LPAD(K.MN_SAL, 10,' '));
    END LOOP;
END ALLSAL;
END EMPINFO;
/

SET SERVEROUTPUT ON

--EXEC ��Ű����.���ν�����
EXEC EMPINFO.ALLEMP;
EXEC EMPINFO.ALLSAL;
--------------------------------------------------------------------------------------
--�Լ� ó��
CREATE OR REPLACE FUNCTION GET_EMPNO
(PNAME IN EMP.ENAME%TYPE)
RETURN EMP.EMPNO%TYPE
IS
VENO EMP.EMPNO%TYPE;
BEGIN
    SELECT EMPNO INTO VENO
    FROM EMP
    WHERE ENAME = UPPER(PNAME);
    DBMS_OUTPUT.PUT_LINE('���: '||VENO);
    RETURN VENO;
    
    exception
        when no_data_found then
        dbms_output.put_line('�Է��� ����� �����');
        when too_many_rows then
        dbms_output.put_line('�ڷᰡ 2�� �̻��̿���');
        when others then
        dbms_output.put_line('��Ÿ �����Դϴ�');    
END;
/

SET SERVEROUTPUT ON

VAR G_NO NUMBER

EXEC :G_NO := GET_EMPNO('scott');

PRINT G_NO
--------------------------------------------------------------------------------------
--Ʈ���� ���
CREATE OR REPLACE TRIGGER MY_TRG
BEFORE UPDATE ON DEPT
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('���� �� �÷���: '|| :OLD.DNAME);
    DBMS_OUTPUT.PUT_LINE('���� �� �÷���: '|| :NEW.DNAME);
END;
/

SELECT * FROM DEPT;

UPDATE DEPT SET DNAME ='DEVELOPEMENT' WHERE DEPTNO=50;

COMMIT;


