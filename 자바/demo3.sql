--부서테이블의 부서번호로 사용할 시퀀스 생성
--시퀀스명 : dept_seq
--시작값 : 60, 증가치 : 10
select max(deptno) from dept;

DROP SEQUENCE DEPT_SEQ;
CREATE SEQUENCE DEPT_SEQ
START WITH 60
INCREMENT BY 10
NOCACHE;

select * from dept order by 1;

alter table dept modify deptno number(4);
desc dept;

DROP SEQUENCE EMP_SEQ;
CREATE SEQUENCE EMP_SEQ
START WITH 8000
INCREMENT BY 1
NOCACHE;

select * from emp;