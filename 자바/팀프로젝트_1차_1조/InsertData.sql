--���� �߰�

INSERT INTO USERDATA

VALUES(1001, 'KIM', '�达', 'PWD', SYSDATE);

INSERT INTO USERDATA

VALUES(1002, 'PARK', '�ھ�', 'pwd', SYSDATE);

 

--����Ʈ ���� �߰�

INSERT INTO SITELIST

VALUES(1001, '���̹�', 'https://www.naver.com/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1001, '����', 'https://www.daum.net/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, '���̹�', 'https://www.naver.com/', 'papapak', 'parkpwd123!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, '����', 'https://www.daum.net/', 'papa', 'parkpwd123@', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 'ZOOM', 'https://zoom.us/', 'park', 'pk1234@!', DEFAULT, DEFAULT);

 

--��ȸ�غ���

SELECT U.KEY, NICKNAME, SITENAME, SITEID, SITEPW

FROM USERDATA U FULL OUTER JOIN SITELIST S

ON U.KEY = S.KEY;


SELECT * FROM USERDATA;
SELECT * FROM SITELIST;


--������ �߰�
CREATE SEQUENCE SITE_SEQ
START WITH 1010
INCREMENT BY 1
NOCACHE;

--��Ÿ
delete from sitelist where url='����Ʈ URL �Է�';