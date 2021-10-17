-- 관리자가 사용자계정 및 암호를 생성(18C XE에서는 사용자계정 앞에 C## 필수) :
-- 앞에 ID, 뒤에 암호 입력
CREATE USER c##student IDENTIFIED BY c##student;

-- DB접속 권한 및 데이터베이스 자원 사용권한 부여 :
-- 기초적인 권한 묶음인 "ROLL"을 사용
GRANT CONNECT TO c##student; -- 접속 권한 부여
GRANT RESOURCE TO c##student; -- ROLL 권한묶음 부여

-- 18C 에서는 권한부여 후 데이터기록 목적의 테이블 스페이스 할당 필요
-- 이전 버전에선 필요 x
ALTER USER c##student QUOTA 1024M ON USERS;