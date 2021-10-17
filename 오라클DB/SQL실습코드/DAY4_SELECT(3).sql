--DAY4. SELECT(3)

--LTRIM, RTRIM / ������ ���ڿ� ��Ͽ��� �������� ���� ��� ����
--(���ڿ� ���Ű� �ƴ϶�, ���� ��� ������ ������ ��� ã�Ƽ� �ٸ��� ���ö����� ����)
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

--TRIM(LEADING(����) | TRAILING(������) | BOTH(����/�⺻��) '�����ҹ��� 1��' FROM '��� ���ڿ� �� | �÷���')
SELECT 'aaORACLEaa',
            TRIM(/*BOTH*/ 'a' FROM 'aaORACLEaa'),
            TRIM(LEADING 'a' FROM 'aaORACLEaa'),
            TRIM(TRAILING 'a' FROM 'aaORACLEaa')
FROM DUAL;

--SUBSTR('���ڿ�' | �÷���, ������ ������ġ, ������ ���ڼ�)
--������ ������ġ : ���-�տ������� / ����-�ڿ�������
--������ ���ڼ� : ���� �� ���� ������ ��� ����
SELECT 'ORACLE 18C',
            SUBSTR('ORACLE 18C', 5),
            SUBSTR('ORACLE 18C', 8, 2),
            SUBSTR('ORACLE 18C', -7, 3)
FROM DUAL;

--������ �ֹι�ȣ���� ����,����,���� �и���ȸ / ��Ī ����
SELECT EMP_NAME, EMP_NO,
            SUBSTR(EMP_NO, 1, 2) "����",
            SUBSTR(EMP_NO, 3, 2) "����",
            SUBSTR(EMP_NO, 5, 2) "����"
FROM EMPLOYEE;

--������ �Ի��Ͽ��� �Ի�⵵, �Ի��, �Ի��� �и���ȸ / ��Ī ����
SELECT EMP_NAME, HIRE_DATE,
            SUBSTR(HIRE_DATE, 1,2) "�Ի�⵵",
            SUBSTR(HIRE_DATE, 4,2) "�Ի��",
            SUBSTR(HIRE_DATE, 7,2) "�Ի���"
FROM EMPLOYEE;

--SUBSTRB('���ڿ�' | �÷���, ������ ���۹���Ʈ ��ġ, ������ ����Ʈ)
SELECT SUBSTR('ORACLE', 3, 2), --AC
            SUBSTRB('ORACLE', 3, 2), --AC
            SUBSTR('����Ŭ', 2, 2), --��Ŭ
            SUBSTRB('����Ŭ', 4, 6) --��Ŭ
FROM DUAL;

--UPPER : �������� �� �빮�ڷ� ����
--LOWER : �������� �� �ҹ��ڷ� ����
--INITCAP : �������� �� ù���ڸ� �빮�ڷ� ����
SELECT UPPER('oracle'), LOWER('ORACLE'), INITCAP('oracle')
FROM DUAL;

--�Լ� ��ø ���
--���� �������� �̸�, ���̵� ��ȸ
--���̵�� �̸��Ͽ��� �и�����
SELECT EMP_NAME "�̸�", 
            SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) "���̵�"
FROM EMPLOYEE;

--�Լ� ��ø ���
--���� �������� �̸�, �ֹι�ȣ ��ȸ
--�ֹι�ȣ�� 000000-0****** ������� ��6�ڸ��� '*' ó��
SELECT EMP_NAME "�̸�", RPAD(SUBSTR(EMP_NO, 1, 8), 14 /*LENGTH(EMP_NO)*/, '*')
FROM EMPLOYEE;

--���� �������� ���,�̸�,�޿�,���ʽ�����Ʈ, ���ʽ�����Ʈ ���� ����
--������ ��Ī ó�� : 1��޿�
--������ õ�������� �ݿø�
SELECT EMP_ID "���", EMP_NAME "�̸�", SALARY "�޿�", BONUS_PCT "���ʽ�����Ʈ",
            ROUND(((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12), -4) "1��޿�"
FROM EMPLOYEE;

--�Ի���-����, ����-�Ի��� ��ȸ "�ٹ��ϼ�"
--���� ��¥ ���ϴ� �Լ� : SYSDATE
SELECT EMP_NAME, HIRE_DATE,
            FLOOR(ABS(HIRE_DATE-SYSDATE)) "�ٹ��ϼ�"
FROM EMPLOYEE;

--���� �������� ����� Ȧ���� ������ ��ȸ
--���, �̸�
SELECT EMP_ID "���", EMP_NAME "�̸�"
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

--��¥ ó���Լ�(�ý������κ��� ���� ��¥,�ð� ��ȸ)
SELECT SYSDATE
FROM DUAL;

--������ �� �ٹ������ 20�� �̻�� �������� ��ȸ
--���,�̸�,�μ��ڵ�,�����ڵ�,�Ի���
SELECT EMP_ID "���", EMP_NAME "�̸�", JOB_ID "�μ��ڵ�", DEPT_ID "�����ڵ�"
FROM EMPLOYEE
WHERE ADD_MONTHS(HIRE_DATE,240) <= SYSDATE;

--���� �̸�,�Ի���,�ٹ����1~2
--�ٹ����1 : ���ó�¥ �������� EXTRACT
--�ٹ����2 : ���ó�¥ �������� MONTHS_BETWEEN
SELECT EMP_NAME "�̸�", HIRE_DATE "�Ի���",
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "�ٹ����1",
            FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "�ٹ����2"
FROM EMPLOYEE;

--������������ �̸�, �Ի��� ��ȸ
--�Ի����� ���� ���� : '0000�� 0�� 00�� (��)'
SELECT EMP_NAME "�̸�",
            TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"�� ("DY")"') "�Ի���"
FROM EMPLOYEE;