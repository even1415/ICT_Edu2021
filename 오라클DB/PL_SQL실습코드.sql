/*
CREATE OR REPLACE PROCEDURE ���ν�����
IS
���� ����
BEGIN
���๮
END;
*/
------------------------------------------------------------
CREATE OR REPLACE PROCEDURE HELLO(NAME IN VARCHAR2)
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('Hello ' || NAME);
END;
/


SET SERVEROUTPUT ON

EXECUTE HELLO('SCOTT');
EXECUTE HELLO('JAME');
------------------------------------------------------------
--����,3�ð� �� �ð� ��� ���ν���
CREATE OR REPLACE PROCEDURE MYTIME
IS
CTIME TIMESTAMP;
ATIME TIMESTAMP;
BEGIN
SELECT SYSTIMESTAMP, SYSTIMESTAMP +3/24 INTO CTIME, ATIME FROM DUAL;

DBMS_OUTPUT.PUT_LINE('���� �ð� : '|| CTIME);
DBMS_OUTPUT.PUT_LINE('3�ð� �� : '|| ATIME);
END;
/

EXEC MYTIME
------------------------------------------------------------
--MEMO���̺� ������ INSERT�ϴ� ���ν��� �ۼ�
--�ۼ���, �޸𳻿� => IN PARAMETER �ؼ� INSERT
CREATE OR REPLACE PROCEDURE MEMO_ADD
(PNAME IN MEMO.NAME%TYPE,
  PMSG IN MEMO.MSG%TYPE)
IS
BEGIN
INSERT INTO MEMO(IDX, NAME, MSG)
VALUES(MEMO_SEQ.NEXTVAL, PNAME, PMSG);
COMMIT;
END;
/

EXEC MEMO_ADD('�����','�ȳ�?');

SELECT * FROM MEMO ORDER BY IDX ASC;
------------------------------------------------------------
--������ �۹�ȣ�� IN �Ķ���� �޾Ƽ� �ش� ���� MEMO���� ����
CREATE OR REPLACE PROCEDURE MEMO_DELETE
(DNUM IN MEMO.IDX%TYPE)
IS
BEGIN
DELETE FROM MEMO WHERE (IDX = DNUM);
COMMIT;
END;

EXEC MEMO_DELETE(7);
------------------------------------------------------------
--������ �۹�ȣ,�۳��� IN �Ķ���� �޾Ƽ�
--�ش�� �����ϴ� ���ν���(MEMO_UPDATE) �ۼ�
CREATE OR REPLACE PROCEDURE MEMO_UPDATE
(DNUM IN MEMO.IDX%TYPE,
  PMSG IN MEMO.MSG%TYPE)
IS
BEGIN
UPDATE MEMO SET MSG = PMSG
WHERE IDX = DNUM;
COMMIT;
END;
/

EXEC MEMO_UPDATE(5, '�ѹ� �� ����');