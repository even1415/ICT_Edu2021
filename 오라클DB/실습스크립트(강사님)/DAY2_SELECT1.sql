-- SELECT ��
/*
���̺� ��� ����� �����͸� �˻�(��ȸ, ã�Ƴ��� ����)�ϱ� ���� �ۼ��ϴ� SQL ������.
DQL (Data Query Language) �̶�� ��

�⺻ ���� �ۼ��� : 
SELECT * | �÷���, �÷���, �÷���, ...... | ���� | �Լ���
FROM ��ȸ�� ����� ���̺��;
*/

-- * ��� : ���̺��� ���� ��� �÷������� ��ȸ�� �� ���
-- ����(EMPLOYEE) ���̺� ����� ��ü ������ ��ȸ�Ϸ���
SELECT * FROM EMPLOYEE;

-- Ư�� �÷��� ������ ��ȸ�� ����� SELECT �� : 
SELECT EMP_NAME, PHONE, SALARY
FROM EMPLOYEE;

-- Ư�� ��(ROW)�� ��ȸ�ϰ��� �� ����� SELECT �� : 
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '20';  -- DEPT_ID �÷��� '20'�� ��ϵ� ����� ���

-- Ư�� �࿡�� Ư�� �÷��� ��ȸ�ϴ� SELECT �� : 
SELECT EMP_ID, EMP_NAME, 
        PHONE, SALARY, DEPT_ID
FROM EMPLOYEE
WHERE DEPT_ID = '20';

-- �⺻�� �� ���� ���̺� ���ؼ� �� ��ȸ��.
-- �ʿ��� ��� ���� ���� ���̺��� ���ļ�(����), ���ϴ� �÷��� ������ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

/*
SELECT ���� �ۼ� ���� : 
5. SELECT * | �÷���, �÷���, ���� [AS ��Ī]
1. FROM ���̺��
2. WHERE �÷��� �񱳿����� �񱳰� (������� ���͸���)
3. GROUP BY �÷��� | ����
4. HAVING �׷��Լ� �񱳿����� �񱳰� (�׷캰 ���ǿ� �ش��ϴ� �׷��� ������)
6. ORDER BY �÷��� ���ı���, ���� ���ı���, ��Ī ���ı���(ASC | DESC)
*/

-- SELECT ��� �� 1 : 
-- ���� ���̺��� ����� �̸� ��ȸ
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE;

-- ���� ���̺��� �������� ��� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, HIRE_DATE, JOB_ID, 
        SALARY, BONUS_PCT, MARRIAGE, MGR_ID, DEPT_ID
FROM EMPLOYEE;
-- �Ǵ�
SELECT *
FROM EMPLOYEE;

-- SELECT ���� �÷����� ���� ���ĵ� ����� �� ����.
-- ���, �̸�, �޿�, �޿��� ���� ����, ���ʽ� ����Ʈ�� ����� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, 
        SALARY * 12,
        (SALARY + (SALARY * BONUS_PCT)) * 12
FROM EMPLOYEE;

-- ����ϴ� ���� NULL (�� ����.) �̸� ����� ������ NULL ��.
-- ���Ŀ� �Լ��� ����� �� ����.
-- �÷��� ���� NULL �̸�, �ٸ� ������ �ٲٴ� �Լ��� �̿���.
-- NVL(�� �о�� �÷���, NULL�� �� �ٲ� ��)
SELECT EMP_ID, EMP_NAME, SALARY, 
        SALARY * 12,
        (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12
FROM EMPLOYEE;

-- SELECT ���� �÷���, ���Ŀ� ��Ī(ALIAS)�� ����� ���� ����
-- �÷��� AS ��Ī, ���� AS ��Ī
-- AS �� ������ �� ����. ==> �÷��� ��Ī, ���� ��Ī
-- ���ǻ��� : ��Ī�� ����, ����, ��ȣ�� ���� ���� �ݵ�� "��Ī" (""�� ����� ��)
-- ��Ī�� ���ڴ� 30����Ʈ���Ϸ� �ۼ��� �� ����.
SELECT EMP_ID AS ���, EMP_NAME �̸�, SALARY �޿�, 
        SALARY * 12 "1�� �޿�",
        (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12 "���ʽ�����Ʈ���뿬��(��)"
FROM EMPLOYEE;

SELECT LENGTHB('�ѱ�'), LENGTHB('ORACLE')
FROM DUAL;  -- ����Ŭ ��ǰ������ �ѱ� 1���ڰ� 2����Ʈ��. XE ������ �ѱ� 1���ڰ� 3����Ʈ��.

-- SELECT ���� ���ͷ�(LITERAL, ������ ���ڿ���) ����� �� ����.
-- ������ �÷��� �ϳ� �߰��� 
-- SELECT �� �����͵��� ���°� ǥ�ÿ����� �̿��� �� ����
-- '���ͷ����ڿ�' AS ��Ī
SELECT EMP_ID ���, EMP_NAME �̸�, '����' �ٹ�����
FROM EMPLOYEE;

-- DISTINCT : SELECT ���� �÷��� �տ� ����� �� ����
-- DISTINCT �÷���

-- �������� ���� �ڵ� ��ȸ
SELECT JOB_ID
FROM EMPLOYEE;  -- ��� 22��

-- ���� ���̺� ���� �����ڵ� ��ȸ
SELECT DISTINCT JOB_ID  -- ���� ���� 1���� ������ (�ߺ�����)
FROM EMPLOYEE;  -- ��� 8��

-- DISTINCT �� SELECT ���� 1���� ����� �� ����
-- �÷����� DISTINCT ��� �� ��
SELECT DISTINCT JOB_ID, DISTINCT DEPT_ID
FROM EMPLOYEE;  -- ERROR

SELECT DISTINCT JOB_ID, DEPT_ID
FROM EMPLOYEE;  -- �� �÷����� �ϳ��� ������ ���� �ߺ� �Ǵ���
-- 'J3 50' �� 'J3 60' �� �ٸ� ����

-- ���� ���̺��� ���� �μ��ڵ� ��ȸ
SELECT DISTINCT DEPT_ID
FROM EMPLOYEE;

-- WHERE �� ******************************************************************
-- �۵����� : FROM �� ������ WHERE ���� �۵���.
-- WHERE �÷��� �񱳿����� �񱳰�
-- �������̶�� �� : ���̺��� �ش� �÷��� ���� ������ �����ϴ� ��鸸 ���
-- �񱳿����� : > (ũ��, �ʰ�), < (������, �̸�), >= (ũ�ų� ������, �̻�), <= (�۰ų� ������, ����)
--          = (������), != | <> | ^= (���� �ʴ���)
-- �������� : AND(&&�� ����), OR(||�� ����)

-- �μ��ڵ尡 '90'�� �����鸸 ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90';  -- ���� �ִ� ���� ���

-- �����ڵ尡 'J7'�� �����鸸 ��ȸ
SELECT *
FROM EMPLOYEE
WHERE JOB_ID = 'J7';  -- ���� �ִ� ���� ���
-- WHERE JOB_ID = 'j7';   -- ��ϰ��� ��/�ҹ��� ������. ��ϵ� ���� �״�� ���ؾ� ��

-- ������ �߿��� �޿��� 4�鸸�� �ʰ��ϴ� ���� ��� ��ȸ
-- ���, �̸�, �޿�
SELECT EMP_ID ���, EMP_NAME �̸�, SALARY �޿�
FROM EMPLOYEE
WHERE SALARY > 4000000;

-- 90�� �μ��� �ٹ��ϴ� ���� �� �޿��� 2�鸸�� �ʰ��ϴ� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND SALARY > 2000000;

-- 90 �Ǵ� 20�� �μ��� �ٹ��ϴ� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90' OR DEPT_ID = '20';



