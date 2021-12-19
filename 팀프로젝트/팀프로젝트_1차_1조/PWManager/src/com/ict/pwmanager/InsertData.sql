--유저 추가

INSERT INTO USERDATA

VALUES(1001, 'KIM', '김씨', 'PWD', SYSDATE);

INSERT INTO USERDATA

VALUES(1002, 'PARK', '박씨', 'pwd', SYSDATE);

 

--사이트 정보 추가

INSERT INTO SITELIST

VALUES(1001, 10000, '네이버', 'https://www.naver.com/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1001, 10001, '다음', 'https://www.daum.net/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10002, '네이버', 'https://www.naver.com/', 'papapak', 'parkpwd123!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10003, '다음', 'https://www.daum.net/', 'papa', 'parkpwd123@', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 10004, 'ZOOM', 'https://zoom.us/', 'park', 'pk1234@!', DEFAULT, DEFAULT);

 

--조회해보기

SELECT U.KEY, NICKNAME, SITENAME, SITEID, SITEPW

FROM USERDATA U FULL OUTER JOIN SITELIST S

ON U.KEY = S.KEY;


SELECT * FROM USERDATA ORDER BY 1;
SELECT * FROM SITELIST;


--시퀀스 추가
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

--기타
delete from sitelist where url='사이트 URL 입력';
delete from sitelist where sitename='몰?루';
delete from sitelist where sitename='몰??루';
delete from sitelist where sitename='얗얗얗';
INSERT INTO SITELIST VALUES(1002, 10005, '몰???루', 'https://몰???루', 'abcd', '1234',
sysdate, 1, 0);