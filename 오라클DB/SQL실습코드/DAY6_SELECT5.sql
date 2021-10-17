--DAY6_SELECT5

--������������ �μ��ڵ� 50 Ȥ�� NULL ���� ��ȸ
--�̸�,�޿� ��ȸ
--�޿����� �������� ����, ���� �޿���� �̸����� �������� ����
SELECT EMP_NAME "�̸�", SALARY "�޿�"
FROM EMPLOYEE
WHERE DEPT_ID IS NULL OR DEPT_ID = '50'
ORDER BY SALARY DESC, EMP_NAME;

--2003�� 1�� 1�� ���� �Ի��� ���� ��ȸ
--�̸�, �Ի���, �μ��ڵ�, �޿� / ��Ī ó��
--�μ��ڵ� ���� �������� ����, ���� �μ��ڵ��� �Ի��� ���� �������� ����,
--���� �Ի����̶�� �̸� ���� �������� ����
SELECT EMP_NAME "�̸�", HIRE_DATE "�Ի���", DEPT_ID "�μ��ڵ�", SALARY "�޿�"
FROM EMPLOYEE
WHERE HIRE_DATE > = '2003/1/1'
--WHERE HIRE_DATE > TO_DATE('20030101', 'RRRRMMDD')
ORDER BY "�μ��ڵ�" DESC NULLS LAST, "�Ի���", "�̸�";

--�μ��ڵ�,�����ڵ� �Բ� �׷� ����, �޿��� �հ踦 ����
--ROLLUP ���, NULL ĭ�� ����
SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID);

SELECT *
FROM EMPLOYEE "E", DEPARTMENT "D"
WHERE E.DEPT_ID = D.DEPT_ID
ORDER BY EMP_ID ASC;

SELECT *
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

--���,�̸�,���޸� ��ȸ
--����Ŭ ����
SELECT EMP_ID "���", EMP_NAME "�̸�",  JOB_TITLE "���޸�"
FROM EMPLOYEE "E", JOB "J"
WHERE E.JOB_ID = J.JOB_ID;


--ANSI ǥ�ر���
SELECT EMP_ID "���", EMP_NAME "�̸�",  JOB_TITLE "���޸�"
FROM EMPLOYEE "E"
JOIN JOB USING (JOB_ID);

-- 1. �޿��� ���� �޴� ������ ������ �ű�ٸ�...
SELECT EMP_NAME, SALARY, 
        RANK() OVER (ORDER BY SALARY DESC) ����
FROM EMPLOYEE
ORDER BY ����;


------------------------------------------��������
-- JOIN ��������

-- 1. 2020�� 12�� 25���� ���� �������� ��ȸ�Ͻÿ�.
SELECT TO_CHAR(TO_DATE('2020/12/25', 'RRRR/MM/DD'), 'DY') "����"
FROM DUAL;


-- 2. �ֹι�ȣ�� 60��� ���̸鼭 ������ �����̰�, 
-- ���� �达�� �������� 
-- �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", EMP_NO "�ֹι�ȣ", DEPT_NAME "�μ��̸�", JOB_TITLE "���޸�"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J"
WHERE  E.DEPT_ID = D.DEPT_ID AND E.JOB_ID = J.JOB_ID
AND
SUBSTR(EMP_NO, 1, 2)>='60' AND SUBSTR(EMP_NO, 1, 2)<'70'
AND SUBSTR(EMP_NO, 8, 1)='2' AND EMP_NAME LIKE '��%';

--ANSI VER.
SELECT EMP_NAME "�����", EMP_NO "�ֹι�ȣ", DEPT_NAME "�μ��̸�", JOB_TITLE "���޸�"
FROM EMPLOYEE "E"
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE SUBSTR(EMP_NO, 1, 2)>='60' AND SUBSTR(EMP_NO, 1, 2)<'70'
AND SUBSTR(EMP_NO, 8, 1)='2' AND EMP_NAME LIKE '��%';


-- ��3. ���� ���̰� ���� ������ 
-- ���, �����, ����, �μ���, ���޸��� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_ID "���", EMP_NAME "�����", 
MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM'))) "����",
DEPT_NAME "�μ���", JOB_TITLE "���޸�"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J"
WHERE E.DEPT_ID = D.DEPT_ID(+) AND E.JOB_ID = J.JOB_ID(+)
GROUP BY EMP_ID, EMP_NAME, DEPT_NAME, JOB_TITLE
HAVING MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')))
 = (SELECT
MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')))
FROM EMPLOYEE
);

--ANSI VER.
SELECT EMP_ID "���", EMP_NAME "�����", 
MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM'))) "����",
DEPT_NAME "�μ���", JOB_TITLE "���޸�"
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT USING (DEPT_ID)
RIGHT JOIN JOB USING (JOB_ID)
GROUP BY EMP_ID, EMP_NAME, DEPT_NAME, JOB_TITLE
HAVING MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')))
 = (SELECT
MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')))
FROM EMPLOYEE
);

--������ �ּҰ� ��ȸ
SELECT MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM'))) "����"
FROM EMPLOYEE;
-- ��ȸ�� ������ �ּҰ��� �̿��� ������ ���� ��ȸ��
-- outer join �ʿ���.
SELECT EMP_ID "���", EMP_NAME "�����", 
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')) "����",
DEPT_NAME "�μ���", JOB_TITLE "���޸�"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J"
WHERE E.DEPT_ID = D.DEPT_ID(+) AND E.JOB_ID = J.JOB_ID(+)
AND EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 4), 'RRMM')) = 32;



-- 4. �̸��� '��'�ڰ� ���� �������� 
-- ���, �����, �μ����� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_ID "���", EMP_NAME "�����", DEPT_NAME "�μ���"
FROM EMPLOYEE "E", DEPARTMENT "D"
WHERE E.DEPT_ID = D.DEPT_ID
AND EMP_NAME LIKE '%��%';

--ANSI VER.
SELECT EMP_ID "���", EMP_NAME "�����", DEPT_NAME "�μ���"
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
WHERE EMP_NAME LIKE '%��%';


-- 5. �ؿܿ������� �ٹ��ϴ� 
-- �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", E.DEPT_ID "�μ��ڵ�", DEPT_NAME "�μ���"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J"
WHERE  E.DEPT_ID = D.DEPT_ID AND E.JOB_ID = J.JOB_ID
AND DEPT_NAME LIKE '�ؿܿ���%';

--ANSI VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", DEPT_ID "�μ��ڵ�", DEPT_NAME "�μ���"
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE DEPT_NAME LIKE '�ؿܿ���%';


-- 6. ���ʽ�����Ʈ�� �޴� �������� 
-- �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", BONUS_PCT "���ʽ�����Ʈ", DEPT_NAME "�μ���", LOC_DESCRIBE "�ٹ�������"
FROM EMPLOYEE "E", DEPARTMENT "D", LOCATION "L"
WHERE E.DEPT_ID = D.DEPT_ID AND D.LOC_ID = L.LOCATION_ID
AND BONUS_PCT > 0;

--ANSI VER.
SELECT EMP_NAME "�����", BONUS_PCT "���ʽ�����Ʈ", DEPT_NAME "�μ���", LOC_DESCRIBE "�ٹ�������"
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE BONUS_PCT > 0;


-- 7. �μ��ڵ尡 20�� �������� 
-- �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", DEPT_NAME "�μ���", LOC_DESCRIBE "�ٹ�������"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J", LOCATION "L"
WHERE E.DEPT_ID = D.DEPT_ID AND D.LOC_ID = L.LOCATION_ID AND E.JOB_ID = J.JOB_ID
AND E.DEPT_ID = 20;

--ANSI VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", DEPT_NAME "�μ���", LOC_DESCRIBE "�ٹ�������"
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE DEPT_ID = 20;


-- 8. ���޺� ������ �ּұ޿�(MIN_SAL)���� ���� �޴� ��������
-- �����, ���޸�, �޿�, ������ ��ȸ�Ͻÿ�.
-- ������ ���ʽ�����Ʈ�� �����Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", SALARY "�޿�", 
((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12) "����"
FROM EMPLOYEE "E", JOB "J"
WHERE E.JOB_ID = J.JOB_ID
AND ((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12) > MIN_SAL;

--ANSI VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", SALARY "�޿�", 
((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12) "����"
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE ((SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12) > MIN_SAL;


-- 9 . �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� 
-- �����(emp_name), �μ���(dept_name), ������(loc_describe),
--  ������(country_name)�� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", DEPT_NAME "�μ���", LOC_DESCRIBE "������", COUNTRY_NAME "������"
FROM EMPLOYEE "E", DEPARTMENT "D", JOB "J", LOCATION "L", COUNTRY "C"
WHERE E.DEPT_ID = D.DEPT_ID AND D.LOC_ID = L.LOCATION_ID AND E.JOB_ID = J.JOB_ID
AND L.COUNTRY_ID = C.COUNTRY_ID
AND C.COUNTRY_ID IN ('KO', 'JP');

--ANSI VER.
SELECT EMP_NAME "�����", DEPT_NAME "�μ���", LOC_DESCRIBE "������", COUNTRY_NAME "������"
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
JOIN COUNTRY USING (COUNTRY_ID)
WHERE COUNTRY_ID IN ('KO', 'JP');


-- 10. ���� �μ��� �ٹ��ϴ� �������� 
-- �����, �μ��ڵ�, �����̸�, �μ��ڵ带 ��ȸ�Ͻÿ�.
-- self join ���
--����Ŭ VER.
SELECT E.EMP_NAME "�����", E.DEPT_ID "�μ��ڵ�", M.EMP_NAME "�����̸�", M.DEPT_ID "���� �μ��ڵ�"
FROM EMPLOYEE "E", EMPLOYEE "M"
WHERE E.EMP_ID != M.EMP_ID AND E.DEPT_ID = M.DEPT_ID
ORDER BY E.EMP_NAME;

--ANSI VER.
SELECT E.EMP_NAME "�����", E.DEPT_ID "�μ��ڵ�",
M.EMP_NAME "�����̸�", M.DEPT_ID "���� �μ��ڵ�"
FROM EMPLOYEE "E"
JOIN EMPLOYEE "M" ON (E.DEPT_ID = M.DEPT_ID)
WHERE E.EMP_ID != M.EMP_ID
ORDER BY E.EMP_NAME;


-- 11. ���ʽ�����Ʈ�� ���� ������ �߿��� 
-- �����ڵ尡 J4�� J7�� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�.
--����Ŭ VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", SALARY "�޿�"
FROM EMPLOYEE "E", JOB "J"
WHERE E.JOB_ID = J.JOB_ID AND E.JOB_ID IN ('J4', 'J7')
AND BONUS_PCT IS NULL;

--ANSI VER.
SELECT EMP_NAME "�����", JOB_TITLE "���޸�", SALARY "�޿�"
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_ID IN ('J4', 'J7')
AND BONUS_PCT IS NULL;


-- 12. �ҼӺμ��� 50 �Ǵ� 90�� ������ 
-- ��ȥ�� ������ ��ȥ�� ������ ���� ��ȸ�Ͻÿ�.
--SELECT COUNT, COUNT(MARRIAGE = 'N')
SELECT DISTINCT 
(SELECT COUNT(*) FROM EMPLOYEE WHERE MARRIAGE = 'Y' AND DEPT_ID IN ('50', '90')) "��ȥ ���� ��",
(SELECT COUNT(*) FROM EMPLOYEE WHERE MARRIAGE = 'N' AND DEPT_ID IN ('50', '90')) "��ȥ ���� ��"
FROM EMPLOYEE;
