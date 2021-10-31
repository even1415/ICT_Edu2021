--�μ����̺��� �μ���ȣ�� ����� ������ ����
--�������� : dept_seq
--���۰� : 60, ����ġ : 10
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