--���� �߰�

INSERT INTO USERDATA

VALUES(1001, 'KIM', '�达', 'PWD', SYSDATE);

INSERT INTO USERDATA

VALUES(1002, 'PARK', '�ھ�', 'pwd', SYSDATE);

 

--����Ʈ ���� �߰�

INSERT INTO SITELIST

VALUES(1001, 10000, '���̹�', 'https://www.naver.com/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1001, 10001, '����', 'https://www.daum.net/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10002, '���̹�', 'https://www.naver.com/', 'papapak', 'parkpwd123!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10003, '����', 'https://www.daum.net/', 'papa', 'parkpwd123@', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10004, 'ZOOM', 'https://zoom.us/', 'park', 'pk1234@!', DEFAULT, DEFAULT);

 

--��ȸ�غ���

SELECT U.KEY, NICKNAME, SITENAME, SITEID, SITEPW

FROM USERDATA U FULL OUTER JOIN SITELIST S

ON U.KEY = S.KEY;


SELECT * FROM USERDATA ORDER BY 1;
SELECT * FROM SITELIST;


--������ �߰�
CREATE SEQUENCE SITE_SEQ
START WITH 10010
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE USER_SEQ
START WITH 1100
INCREMENT BY 1
NOCACHE;

DROP SEQUENCE SITE_SEQ;

COMMIT;

--��Ÿ
delete from sitelist where url='����Ʈ URL �Է�';
delete from sitelist where sitename='��?��';
delete from sitelist where sitename='��??��';
delete from sitelist where sitename='����';
INSERT INTO SITELIST VALUES(1002, 10005, '��???��', 'https://��???��', 'abcd', '1234',
sysdate, 1, 0);