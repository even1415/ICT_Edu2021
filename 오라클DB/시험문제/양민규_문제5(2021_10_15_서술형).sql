/*
테이블명 : memberTb
컬럼명 :      id         pass        name        age
컬럼자료형 : (varchar2(10)) (varchar2(20))  (varchar2(10))  (number)
테이블에 기록할 값 : 
 0100       en1234       이지은        25
 0101      C33kimleechoi   강한나        30
 0102        snsd        서주현        28
 */
 
--문제에 주어진 테이블 생성
CREATE TABLE memberTb (
    ID VARCHAR2(10),
    PASS VARCHAR2(20),
    NAME VARCHAR2(10),
    AGE NUMBER
);
--문제에 주어진 데이터 삽입 및 정상적으로 삽입됬는지 확인
INSERT INTO memberTb VALUES ('0100', 'en1234', '이지은', 25);
INSERT INTO memberTb VALUES ('0101', 'C33kimleechoi', '강한나', 30);
INSERT INTO memberTb VALUES ('0102', 'snsd', '서주현', 28);

SELECT * FROM memberTb;