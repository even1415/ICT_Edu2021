--2. �Ʒ����� �䱸�Ǵ� ���������� ������ ���̺� ���� DDL������
--�� �÷��� ����(COMMENT)�� �����ϴ� ������ [����](30��)�� ����ϰ�,
--�Ʒ��� �䱸���׿� ���� ��ȸ������ ����Ŭ ���뱸����
--ANSI ǥ�� �������� ���� [��ġ����](30��)�� �ۼ��Ͻÿ�. (60��). ( 60�� )

/*
���� : ���������� ������ ���̺� �����
���̺�� : PHONEBOOK
�÷��� : ID CHAR(3) �⺻Ű(�����̸� : PK_PBID) (���� : ���̵�)
    PNAME   VARCHAR2(20) �� ������. (���� : �̸�)
                (NN_PBNAME) 
    PHONE   VARCHAR2(15) �� ������ (���� : ��ȭ��ȣ)
                 (NN_PBPHONE)
                �ߺ��� �Է¸���
                (UN_PBPHONE)
    ADDRESS  VARCHAR2(100) �⺻�� ������ (���� : �ּ�)
                '����� ���α�'
* NOT NULL�� �����ϰ�, ��� ���̺� �������� ������. �������� �����̸� �ݵ�� ������
* �� �÷��� ���� ������

��ġ���� : ������ �븮�̸鼭, �ƽþ������� �ٹ��ϴ� ���� ������ ��ȸ�Ͻÿ�.
* ����Ŭ ���뱸���� ANSI ǥ�ر������� ���� �ۼ��Ͻÿ�
���̺� : EMPLOYEE, JOB, DEPARTMENT, LOCATION, COUNTRY, SAL_GRADE
��ȸ�� �÷� : emp_name �����, dept_name �ҼӺμ���, job_title ���޸�, loc_describe �ٹ�������, 
         country_name ������, salary �޿�, slevel �޿����
*/

---------------����ۼ�---------------
--���� :
CREATE TABLE PHONEBOOK2 (
    ID CHAR(3) PRIMARY KEY,
    PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
    PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
    ADDRESS VARCHAR2(100) DEFAULT '����� ���α�',
    
    CONSTRAINT PK_PBID PRIMARY KEY (ID),
    CONSTRAINT UN_PBPHONE UNIQUE (PHONE)
);
COMMENT ON COLUMN PHONEBOOK2.ID IS '���̵�';
COMMENT ON COLUMN PHONEBOOK2.PNAME IS '�̸�';
COMMENT ON COLUMN PHONEBOOK2.PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN PHONEBOOK2.ADDRESS IS '�ּ�';

--�ذ� :
--����Ŭ VER.
SELECT emp_name �����, dept_name �ҼӺμ���, job_title ���޸�, loc_describe �ٹ�������, 
         country_name ������, salary �޿�, slevel �޿����
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L, COUNTRY C, SAL_GRADE S
WHERE E.DEPT_ID = D.DEPT_ID AND E.JOB_ID = J.JOB_ID
            AND D.LOC_ID = L.LOCATION_ID AND L.COUNTRY_ID = C.COUNTRY_ID
            AND JOB_TITLE = '�븮' AND LOC_DESCRIBE LIKE '�ƽþ�%'
            AND SLEVEL = (SELECT SLEVEL
                                        FROM SAL_GRADE
                                        WHERE SALARY >= LOWEST AND SALARY <= HIGHEST);
--ANSI VER.
SELECT emp_name �����, dept_name �ҼӺμ���, job_title ���޸�, loc_describe �ٹ�������, 
         country_name ������, salary �޿�, slevel �޿����
FROM SAL_GRADE, EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING (COUNTRY_ID)
WHERE JOB_TITLE = '�븮' AND LOC_DESCRIBE LIKE '�ƽþ�%'
            AND SLEVEL = (SELECT SLEVEL
                                        FROM SAL_GRADE
                                        WHERE SALARY >= LOWEST AND SALARY <= HIGHEST);