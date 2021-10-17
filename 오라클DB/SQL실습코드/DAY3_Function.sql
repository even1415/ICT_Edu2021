--�ҼӺμ��� '50'�̰ų� �μ��� �������� ���� �������� �޿� �հ�
SELECT SUM(SALARY), SUM(DISTINCT SALARY)
FROM EMPLOYEE
WHERE DEPT_ID = '50' OR DEPT_ID IS NULL;

--�ҼӺμ��� 50 �Ǵ� 90 �Ǵ� NULL�� �������� ���ʽ� ��� ��ȸ
SELECT AVG(BONUS_PCT) �⺻���,
            AVG(DISTINCT BONUS_PCT) �ߺ��������,
            AVG(NVL(BONUS_PCT, 0)) NULL�������
FROM EMPLOYEE
WHERE DEPT_ID IN('50', '90') OR DEPT_ID IS NULL;


--�μ��ڵ尡 50 �Ǵ� 90�� �������� �����ڵ���
--�ִ밪,�ּҰ�,�Ի����� �ִ밪,�ּҰ�, �޿��� �ִ밪,�ּҰ�
SELECT MAX(JOB_ID), MIN(JOB_ID),
            MAX(HIRE_DATE), MIN(HIRE_DATE),
            MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IN('50', '90');

--COUNT : ��ü �� ���� ��ȯ
--�÷��� ��ü(*)�� �ƴ� ��� ���� ������ NULL�� ����
SELECT COUNT(*), COUNT(DEPT_ID), COUNT(DISTINCT DEPT_ID)
FROM EMPLOYEE;
--50�� �μ��� �ҼӵǾ��ų� �μ��� �������� ���� ���� ��
SELECT COUNT(*), --NULL ����
            COUNT(DEPT_ID) --NULL ����
FROM EMPLOYEE
WHERE DEPT_ID = '50' OR DEPT_ID IS NULL;

--�������� ����ϱ�
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

SELECT EMAIL, INSTR(EMAIL, 'c', INSTR(EMAIL, '.')-1)
FROM EMPLOYEE;