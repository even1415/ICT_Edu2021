--������ �־��� ���̺� ����
CREATE TABLE STUDENT (
    SID CHAR(4),
    SNAME VARCHAR2(10),
    GRADE CHAR(2),
    SCORE NUMBER
);
--������ �־��� ������ ���� �� ���������� ���ԉ���� Ȯ��
INSERT INTO STUDENT VALUES ('1001', 'ȫ�浿', 'A', 93);
INSERT INTO STUDENT VALUES ('1002', '��浿', 'D', 65);
INSERT INTO STUDENT VALUES ('1003', '��ö��', 'C', 75);
INSERT INTO STUDENT VALUES ('1004', '�ڿ���', 'A', 97);

SELECT * FROM STUDENT;

--GRADE �� SCORE �� ����� ��ȸ�ϴ� SELECT ������
SELECT GRADE, AVG(SCORE) "�������"
FROM STUDENT
GROUP BY GRADE
ORDER BY GRADE;