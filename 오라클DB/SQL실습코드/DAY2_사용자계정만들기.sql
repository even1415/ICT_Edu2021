-- �����ڰ� ����ڰ��� �� ��ȣ�� ����(18C XE������ ����ڰ��� �տ� C## �ʼ�) :
-- �տ� ID, �ڿ� ��ȣ �Է�
CREATE USER c##student IDENTIFIED BY c##student;

-- DB���� ���� �� �����ͺ��̽� �ڿ� ������ �ο� :
-- �������� ���� ������ "ROLL"�� ���
GRANT CONNECT TO c##student; -- ���� ���� �ο�
GRANT RESOURCE TO c##student; -- ROLL ���ѹ��� �ο�

-- 18C ������ ���Ѻο� �� �����ͱ�� ������ ���̺� �����̽� �Ҵ� �ʿ�
-- ���� �������� �ʿ� x
ALTER USER c##student QUOTA 1024M ON USERS;