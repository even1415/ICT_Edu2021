--DAY3. SELECT(2)

--���� 1 : �޿��� 200���̻�~400������ ������
--���, �̸�, �޿�, �����ڵ�, �μ��ڵ� ��ȸ / ��Ī ���

SELECT EMP_ID "���", EMP_NAME "�̸�", SALARY "�޿�", JOB_ID "�����ڵ�", DEPT_ID "�μ��ڵ�"
FROM EMPLOYEE
WHERE SALARY>=2000000 AND SALARY<=4000000;

--���� 2:
--�Ի����� 1995�� 1��1�Ϻ��� ~ 2000�� 12��31�� ���̿� �Ի��� ������
--���,�̸�,�Ի���,�μ��ڵ� ��ȸ / ��Ī ���
--��¥ �����ʹ� ��ϵ� ����� ��ġ�ǰ� �ۼ�
--���� ����ǥ�� ��� ǥ��  : '1995/01/01' �Ǵ� '95/01/01'
SELECT EMP_ID "���", EMP_NAME "�̸�", HIRE_DATE "�Ի���", DEPT_ID "�μ��ڵ�"
FROM EMPLOYEE
WHERE HIRE_DATE>='95/01/01' AND HIRE_DATE<='00/12/31';
--WHERE HIRE_DATE BETWEEN '95/01/01' AND '00/12/31'

--���Ῥ���� : || (�ڹ��� println �޼ҵ忡�� ���ڿ� + ������[���ڿ� �պ�] ���)
SELECT EMP_NAME || ' ������ �޿��� ' || SALARY || '�� �Դϴ�.' AS "�޿�����"
FROM EMPLOYEE
WHERE DEPT_ID = '90';

--���� 3:
--2000�� 1��1�� ���� �Ի��� ��ȥ�� ������
--�̸�,�Ի���,�����ڵ�,�μ��ڵ�,�޿�,��ȥ���� ��ȸ / ��Ī ���
--�Ի糯¥ �ڿ� ' �Ի�', �޿��� �ڿ� ' (��)' ���ڿ��� ���
--��ȥ���δ� '��ȥ' ���ͷ� ���
SELECT EMP_NAME "�̸�", HIRE_DATE  || ' �Ի�' AS "�Ի���", JOB_ID "�����ڵ�", 
             DEPT_ID "�μ��ڵ�", SALARY || ' (��)' AS "�޿�", '��ȥ' AS "��ȥ����"
FROM EMPLOYEE
WHERE MARRIAGE='Y' AND HIRE_DATE>='00/01/01';
--���Ѽ��� �Ի����� 2090���̶� ��¿� ���Ե�

--���� �达�� �������� ��ȸ
SELECT EMP_ID "���", EMP_NAME "�̸�", EMP_NO "�ֹι�ȣ", PHONE "��ȭ��ȣ"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

--���� �̸��� '��' �� ����
SELECT EMP_ID "���", EMP_NAME "�̸�", EMP_NO "�ֹι�ȣ", PHONE "��ȭ��ȣ"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

--��ȭ��ȣ ����(4��° �ڸ���)�� '9'�� �������� ��ȸ
--�̸�, ��ȭ��ȣ / ��Ī ����
SELECT EMP_NAME "�̸�", PHONE "��ȭ��ȣ"
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--���� :
--������ ������ ����(�ֹι�ȣ 2)
SELECT EMP_ID "���", EMP_NAME "�̸�", EMP_NO "�ֹι�ȣ", PHONE "��ȭ��ȣ"
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%';

--��ϰ��� '_'�� ���ϵ�ī�� '_'�� ���� �ȵǴ� ���
--��ϰ� ���� ������ ESCAPE ���(������ ���� ���ǹ��� �ϳ� ǥ��)
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--�μ�,���� �������� ���� ��ȸ
--���,�̸�,�����ڵ�,�μ��ڵ�
--(�÷�)=NULL ���Ұ�(����� �ȳ����� ����)
SELECT EMP_ID "���", EMP_NAME "�̸�", JOB_ID "�����ڵ�", DEPT_ID "�μ��ڵ�"
FROM EMPLOYEE
WHERE JOB_ID IS NULL AND DEPT_ID IS NULL;

---���ʽ�����Ʈ ���� ���� ��ȸ
--���,�̸�,�μ��ڵ�,���ʽ�����Ʈ
SELECT EMP_ID "���", EMP_NAME "�̸�", DEPT_ID "�μ��ڵ�", BONUS_PCT "���ʽ�����Ʈ"
FROM EMPLOYEE
WHERE BONUS_PCT IS NULL;

--�μ� ����x, �����ڴ� �ִ� ����
--���,�̸�,�����ڻ��,�μ��ڵ�
SELECT EMP_ID "���", EMP_NAME "�̸�", MGR_ID "�����ڻ��", DEPT_ID "�μ��ڵ�"
FROM EMPLOYEE
WHERE DEPT_ID IS NULL AND MGR_ID IS NOT NULL; --0��

--�μ� ����x, ���ʽ�����Ʈ�� �޴� ����
--���,�̸�,���ʽ�����Ʈ,�μ��ڵ�
SELECT EMP_ID "���", EMP_NAME "�̸�", DEPT_ID "�μ��ڵ�", BONUS_PCT "���ʽ�����Ʈ"
FROM EMPLOYEE
WHERE BONUS_PCT IS NOT NULL AND DEPT_ID IS NULL;


--SELECT ��������

--1. �μ��ڵ� 90, �����ڵ� J2�� ��������
--���,�̸�,�μ��ڵ�,�����ڵ�,�޿� ��ȸ / ��Ī ����
SELECT EMP_ID "���", EMP_NAME "�̸�", SALARY "�޿�", JOB_ID "�����ڵ�", DEPT_ID "�μ��ڵ�"
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND JOB_ID = 'J2';

--2. �Ի����� '1982-01-01' ���İų�, �����ڵ尡 J3�� ��������
--���,�̸�,������ ���, ���ʽ�����Ʈ ��ȸ
SELECT EMP_ID "���", EMP_NAME "�̸�", MGR_ID "�����ڻ��", BONUS_PCT "���ʽ�����Ʈ"
FROM EMPLOYEE
WHERE HIRE_DATE>='1982/01/01' OR JOB_ID = 'J3';

--3. �����ڵ尡 J4�� �ƴ� �������� �޿��� ���ʽ�����Ʈ�� ����� ������ ��ȸ��.
--  ��Ī ������, ���, �����, �����ڵ�, ����(��)
--  ��, ���ʽ�����Ʈ�� null �� ���� 0���� �ٲپ� ����ϵ��� ��.
SELECT EMP_ID "���", EMP_NAME "�̸�", JOB_ID "�����ڵ�",
            (SALARY + (SALARY * NVL(BONUS_PCT,0))) *12 || ' (��)' "����"
FROM EMPLOYEE
WHERE JOB_ID != 'J4';

--4. ���ʽ�����Ʈ�� 0.1 �̻� 0.2 ������ �������� ���, �����, �̸���, �޿�, ���ʽ�����Ʈ ��ȸ��
SELECT EMP_ID "���", EMP_NAME "�����", EMAIL "�̸���", SALARY "�޿�", BONUS_PCT "���ʽ�����Ʈ"
FROM EMPLOYEE
WHERE BONUS_PCT BETWEEN 0.1 AND 0.2;

--5. ���ʽ�����Ʈ�� 0.1 ���� �۰ų�(�̸�), 0.2 ���� ����(�ʰ�) �������� ���, �����, ���ʽ�����Ʈ, �޿�, �Ի��� ��ȸ��
SELECT EMP_ID "���", EMP_NAME "�����", BONUS_PCT "���ʽ�����Ʈ", SALARY "�޿�", HIRE_DATE "�Ի���"
FROM EMPLOYEE
WHERE BONUS_PCT<0.1 AND BONUS_PCT>0.2;
--WHERE BONUS_PCT NOT BETWEEN 0.1 AND 0.2;

--6. '1982-01-01' ���Ŀ� �Ի��� �������� �����, ���ʽ�����Ʈ, �޿� ��ȸ��
SELECT EMP_NAME "�̸�",  BONUS_PCT "���ʽ�����Ʈ", SALARY "�޿�"
FROM EMPLOYEE
WHERE HIRE_DATE>='1982/01/01';

--7. ���ʽ�����Ʈ�� 0.1, 0.2 �� �������� ���, �����, ���ʽ�����Ʈ, ��ȭ��ȣ ��ȸ��
SELECT EMP_ID "���", EMP_NAME "�����", BONUS_PCT "���ʽ�����Ʈ", PHONE "��ȭ��ȣ"
FROM EMPLOYEE
WHERE BONUS_PCT IN(0.1, 0.2);
--WHERE BONUS_PCT=0.1 OR BONUS_PCT=0.2;

--8. ���ʽ�����Ʈ�� 0.1�� 0.2�� �ƴ� �������� ���, �����, ���ʽ�����Ʈ, �ֹι�ȣ ��ȸ��
SELECT EMP_ID "���", EMP_NAME "�����", BONUS_PCT "���ʽ�����Ʈ", EMP_NO "�ֹι�ȣ"
FROM EMPLOYEE
WHERE BONUS_PCT NOT IN(0.1, 0.2);
--WHERE BONUS_PCT!=0.1 AND BONUS_PCT!=0.2;

--9. ���� '��'���� �������� ���, �����, �Ի��� ��ȸ��
--  ��, �Ի��� ���� �������� ������
SELECT EMP_ID "���", EMP_NAME "�����", HIRE_DATE "�Ի���"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%'
ORDER BY HIRE_DATE ASC;

--10. �ֹι�ȣ 8��° ���� '2'�� ������ ���, �����, �ֹι�ȣ, �޿��� ��ȸ��
--  ��, �޿� ���� �������� ������
SELECT EMP_ID "���", EMP_NAME "�����", EMP_NO "�ֹι�ȣ", SALARY "�޿�"
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%'
ORDER BY SALARY DESC;