--문제에 주어진 테이블 생성
CREATE TABLE STUDENT (
    SID CHAR(4),
    SNAME VARCHAR2(10),
    GRADE CHAR(2),
    SCORE NUMBER
);
--문제에 주어진 데이터 삽입 및 정상적으로 삽입됬는지 확인
INSERT INTO STUDENT VALUES ('1001', '홍길동', 'A', 93);
INSERT INTO STUDENT VALUES ('1002', '고길동', 'D', 65);
INSERT INTO STUDENT VALUES ('1003', '김철수', 'C', 75);
INSERT INTO STUDENT VALUES ('1004', '박영희', 'A', 97);

SELECT * FROM STUDENT;

--GRADE 별 SCORE 의 평균을 조회하는 SELECT 쿼리문
SELECT GRADE, AVG(SCORE) "성적평균"
FROM STUDENT
GROUP BY GRADE
ORDER BY GRADE;