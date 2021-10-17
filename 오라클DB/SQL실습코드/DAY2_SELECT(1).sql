-- SELECT �� ����

-- ���� ���̺��� ��ü ������ ��ȸ
SELECT * FROM EMPLOYEE;


--Ư�� �÷��� �� ��ȸ
SELECT EMP_NAME, PHONE, SALARY
FROM EMPLOYEE;

--Ư�� ��(ROW) ��ȸ�ϴ� ���
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '20';

--���� ���� ���̺��� ���ļ� ��ȸ, ���ϴ� �÷��� ����
SELECT EMP_ID, EMP_NAME, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

--SELECT ��� �� 
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE;

--SELECT ���� �÷����� ���� ���� ���
--���, �̸� ,�޿�, �޿��� ���� ����, ���ʽ�����Ʈ ����� ����
--NVL(����, �ٲ� ��) ����ϸ� NULL ���� �ٲ� ������ ���� �� ��갡��
--ū����ǥ�� "��Ī"��������(ALIAS)
SELECT EMP_ID, EMP_NAME, SALARY, 
SALARY*12 "1�� �޿�(����)", 
(SALARY + (SALARY * NVL(BONUS_PCT,0))) *12 "���ʽ�����Ʈ ���� ����"
FROM EMPLOYEE;

SELECT LENGTHB('�ѱ�'), LENGTHB('ORACLE')
FROM DUAL; --����Ŭ ��ǰ�� �ѱ�1���ڰ� 2����Ʈ / XE������ 3����Ʈ

--SELECT ���� ���ͷ�(������ ���ڿ� ��) ��밡��
--������ �÷��� �ϳ� �߰�
SELECT EMP_ID, EMP_NAME, 
'����' AS �ٹ�����
FROM EMPLOYEE;

--���� ���̺� ���� �����ڵ� ��� ��ȸ
SELECT DISTINCT JOB_ID --���� ���� 1���� ������(�ߺ��� ����)
FROM EMPLOYEE;

--WHERE �� ���
SELECT * 
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND SALARY > 2000000;

SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90' OR DEPT_ID = '20';