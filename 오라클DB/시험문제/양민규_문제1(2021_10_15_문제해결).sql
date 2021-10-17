--1. ������ ���� DEPARTMENT, EMPLOYEE ���̺��� �����Ѵ�.
--�� ���� ���̺��� �����Ͽ� EMPNO, EMPNAME, DEPTNO, DEPTNAME �÷��� ��ȸ�ϴ� ���ι��� �ۼ��ϱ� ����
--�Ʒ��� ���� ������ �ۼ��Ͽ���. �� �� �߻��ϴ� �������� [����](10��)�� ����ϰ�,
--�̸� �ذ��ϱ� ���� ����Ŭ���뱸���� ANSIǥ�� ������ [��ġ����](30��)�� ����Ͻÿ�. (40��). ( 40�� )

CREATE TABLE DEPARTMENT (
  DEPTNO NUMBER PRIMARY KEY,
  DEPTNAME NVARCHAR2(10) NOT NULL
);

CREATE TABLE EMPLOYEE (
  EMPNO NUMBER PRIMARY KEY,
  EMPNAME NVARCHAR2(10) NOT NULL,
  DEPTNO NUMBER REFERENCES DEPARTMENT(DEPTNO)
);

SELECT EMPNO, EMPNAME, DEPTNO, DEPTNAME
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPTNO = D.DEPTNO;

---------------����ۼ�---------------
-- ���� :
-- EMPLOYEE ���̺�� DEPARTMENT ���̺� ��� DEPTNO �÷��� �����ϱ� ������
-- SELECT DEPTNO ���� DEPTNO �� ��� ���̺� �Ҽӵ� �÷��� ����� �� Ȯ������ �� ����.
-- ����, �Ʒ��� ���� DEPTNO �� �Ҽ��� ������־�� �Ѵ�.

-- �ذ� :
--����Ŭ VER.
SELECT EMPNO, EMPNAME, E.DEPTNO, DEPTNAME
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPTNO = D.DEPTNO;

--ANSI VER.
--ANSI ǥ�ؿ����� EMPLOYEE ���̺��� �������� DEPARTMENT ���̺��� �պ��Ǵ� ���̱� ������
--������ �Ҽ� ��� ���� DEPTNO �� ��ȸ�Ѵ�.
SELECT EMPNO, EMPNAME, DEPTNO, DEPTNAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPTNO);