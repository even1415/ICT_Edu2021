CREATE TABLE USERDATA (
    Key NUMBER PRIMARY KEY,
    ID VARCHAR2(20),
    Nickname VARCHAR2(40),
    Password VARCHAR2(30),
    JoinDate DATE DEFAULT SYSDATE
);

CREATE TABLE SITELIST (
    Key REFERENCES USERDATA(Key),
    SiteKey NUMBER PRIMARY KEY,
    SiteName VARCHAR2(40),
    URL VARCHAR2(2100),
    SiteID VARCHAR2(20),
    SitePW VARCHAR2(30),
    InsertDate DATE DEFAULT SYSDATE,
    GuardLevel NUMBER DEFAULT '1'
);
ALTER TABLE SITELIST ADD CATEGORY NUMBER DEFAULT '0';

ALTER TABLE SITELIST MODIFY SitePW VARCHAR2(255);

DROP TABLE SITELIST;