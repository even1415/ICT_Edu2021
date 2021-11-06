--유저 추가

INSERT INTO USERDATA

VALUES(1001, 'KIM', '김씨', 'PWD', SYSDATE);

INSERT INTO USERDATA

VALUES(1002, 'PARK', '박씨', 'pwd', SYSDATE);

 

--사이트 정보 추가

INSERT INTO SITELIST

VALUES(1001, '네이버', 'https://www.naver.com/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1001, '다음', 'https://www.daum.net/', 'kimkim', 'kimpwd@!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, '네이버', 'https://www.naver.com/', 'papapak', 'parkpwd123!', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, '다음', 'https://www.daum.net/', 'papa', 'parkpwd123@', DEFAULT, DEFAULT);

INSERT INTO SITELIST

VALUES(1002, 'ZOOM', 'https://zoom.us/', 'park', 'pk1234@!', DEFAULT, DEFAULT);

 

--조회해보기

SELECT U.KEY, NICKNAME, SITENAME, SITEID, SITEPW

FROM USERDATA U FULL OUTER JOIN SITELIST S

ON U.KEY = S.KEY;


SELECT * FROM USERDATA;
SELECT * FROM SITELIST;


--시퀀스 추가
CREATE SEQUENCE SITE_SEQ
START WITH 1010
INCREMENT BY 1
NOCACHE;

--기타
delete from sitelist where url='사이트 URL 입력';