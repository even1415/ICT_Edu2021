/*
���̺�� : memberTb
�÷��� :      id         pass        name        age
�÷��ڷ��� : (varchar2(10)) (varchar2(20))  (varchar2(10))  (number)
���̺� ����� �� : 
 0100       en1234       ������        25
 0101      C33kimleechoi   ���ѳ�        30
 0102        snsd        ������        28
 */
 
--������ �־��� ���̺� ����
CREATE TABLE memberTb (
    ID VARCHAR2(10),
    PASS VARCHAR2(20),
    NAME VARCHAR2(10),
    AGE NUMBER
);
--������ �־��� ������ ���� �� ���������� ���ԉ���� Ȯ��
INSERT INTO memberTb VALUES ('0100', 'en1234', '������', 25);
INSERT INTO memberTb VALUES ('0101', 'C33kimleechoi', '���ѳ�', 30);
INSERT INTO memberTb VALUES ('0102', 'snsd', '������', 28);

SELECT * FROM memberTb;