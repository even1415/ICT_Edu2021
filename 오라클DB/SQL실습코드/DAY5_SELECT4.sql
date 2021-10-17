SELECT EMP_NAME "�̸�", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "�Ի���"
FROM EMPLOYEE;
--WHERE EMP_ID = '100';

--��¥,�ð� ���� ��ϵ� ���� �񱳿���� ��¥�� ������ �� �Ұ�
SELECT EMP_NAME "�̸�", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "�Ի���"
FROM EMPLOYEE
WHERE HIRE_DATE = '90/04/01'; --��� �ȳ���

--�ذ�1
SELECT EMP_NAME "�̸�", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "�Ի���"
FROM EMPLOYEE
WHERE TO_CHAR(HIRE_DATE, 'YY/MM/DD') = '90/04/01';

--�ذ�2
SELECT EMP_NAME "�̸�", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "�Ի���"
FROM EMPLOYEE
WHERE HIRE_DATE LIKE '90/04/01%';

--�ذ�3
SELECT EMP_NAME "�̸�", 
            TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH24:MI:SS') "�Ի���"
FROM EMPLOYEE
WHERE SUBSTR(HIRE_DATE, 1, 8) = '90/04/01';

--NVL2() �Լ�
--������������ ���ʽ�����Ʈ 0.2 �̸� OR NULL ���� ��ȸ
--���, �̸�, ���ʽ�����Ʈ, ���溸�ʽ�����Ʈ
--���溸�ʽ�����Ʈ = ���ʽ�����Ʈ �÷��� �� ������ 0.15�� ����, ������ 0.05
SELECT EMP_ID "���", EMP_NAME "�̸�", BONUS_PCT "���ʽ�����Ʈ",
            NVL2(BONUS_PCT, 0.15, 0.05) "���溸�ʽ�����Ʈ"
FROM EMPLOYEE
WHERE BONUS_PCT < 0.2 OR BONUS_PCT IS NULL;

--50�� �μ��� �Ҽӵ� �������� �̸�,���� ��ȸ
--���� ���� : �ֹι�ȣ 8��° ���� 1,3�̸� ���� / 2,4�̸� ����
SELECT EMP_NAME "�̸�", EMP_NO "�ֹι�ȣ",
            DECODE(SUBSTR(EMP_NO, 8, 1), '1', '����', '2', '����', '3', '����', '4', '����')
FROM EMPLOYEE
WHERE DEPT_ID = '50';


--1. ������� �ֹι�ȣ�� ��ȸ��
--  ��, �ֹι�ȣ 9��° �ڸ����� �������� '*'���ڷ� ä��
--  �� : ȫ�浿 771120-1******
SELECT EMP_NAME �̸�,
        RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') �ֹι�ȣ
FROM EMPLOYEE;

--2. ������, �����ڵ�, ����(��) ��ȸ
--  ��, ������ ��57,000,000 ���� ǥ�õǰ� ��
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
SELECT EMP_NAME �̸�, JOB_ID �����ڵ�, 
        TO_CHAR(ROUND(((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12), -4), 'L99,999,999') "����(��)"
FROM EMPLOYEE;

--3. �μ��ڵ尡 50, 90�� ������ �߿��� 2004�⵵�� �Ի��� ���� ��ȸ
--	��� ����� �μ��ڵ� �Ի���
SELECT EMP_ID ���, EMP_NAME �����, DEPT_ID �μ��ڵ�, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE DEPT_ID IN('50','90') AND SUBSTR(HIRE_DATE, 1, 2) = '04';


--4. ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
--  ��, �ָ��� ������
SELECT EMP_NAME �����, HIRE_DATE �Ի���,
            LAST_DAY(HIRE_DATE) - HIRE_DATE "�Ի� ù�� �ٹ��ϼ�"
FROM EMPLOYEE;


--5. ������, �μ��ڵ�, �������, ����(��) ��ȸ
--  ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--     ������ ������ �����Ϸ� ��µǰ� ��.
--  ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, �����
SELECT EMP_NAME �����, DEPT_ID �μ��ڵ�, 
            SUBSTR(EMP_NO, 1, 2)||'�� '||SUBSTR(EMP_NO, 3, 2)||'�� '||SUBSTR(EMP_NO, 5, 2)||'��' �������,
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')) "����"
FROM EMPLOYEE;

--6. �������� �Ի��Ϸ� ���� �⵵�� ������, �� �⵵�� �Ի��ο����� ���Ͻÿ�.
--  �Ʒ��� �⵵�� �Ի��� �ο����� ��ȸ�Ͻÿ�.
--  => to_char, decode, sum ���
--	-------------------------------------------------------------
--	��ü������   2001��   2002��   2003��   2004��
--	-------------------------------------------------------------
SELECT COUNT(*) ��ü������,
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2001, 1, 0)) "2001��",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2002, 1, 0)) "2002��",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2003, 1, 0)) "2003��",
            SUM(DECODE(TO_CHAR(HIRE_DATE, 'YYYY'), 2004, 1, 0)) "2004��"
FROM EMPLOYEE;

--7.  �μ��ڵ尡 50�̸� �ѹ���, 60�̸� ��ȹ��, 90�̸� �����η� ó���Ͻÿ�.
--   ��, �μ��ڵ尡 50, 60, 90 �� ������ ������ ��ȸ��
--  => case ���
--	�μ��ڵ� ���� �������� ������.
SELECT DEPT_ID �μ��ڵ�,
            CASE DEPT_ID WHEN '50' THEN '�ѹ���'
                                  WHEN '60' THEN '��ȹ��'
                                  WHEN '90' THEN '������'
            END AS "�μ���"
FROM EMPLOYEE
WHERE DEPT_ID IN('50', '60', '90')
ORDER BY DEPT_ID ASC;