/* 
	사원테이블(emp)
	부서테이블(dept)의 3정규화를 진행
		* 부서(부모) 1대다 사원(자식, 부모 테이블인 부서를 참조)
		* 사원테이블에서 부서번호를 FK로 설정하여 무결성 위배하지 않도록 설정
*/
CREATE TABLE mvc_department(
	deptno NUMBER PRIMARY KEY,
	dname VARCHAR2(100) NOT NULL,
	loc VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL
)

INSERT INTO mvc_department(deptno, dname, loc, tel) VALUES(10, '전략기획', '오리', '031');
INSERT INTO mvc_department(deptno, dname, loc, tel) VALUES(20, '공공사업', '종로', '02');
INSERT INTO mvc_department(deptno, dname, loc, tel) VALUES(30, '연구개발', '판교', '033');

commit

--참조해야하는 부서번호가 존재하지 않으므로 column 생성 불가
INSERT INTO mvc_employee(empno, ename, sal, deptno) VALUES(1, '아이유', 400, 50);
--사원테이블 생성
INSERT INTO mvc_employee(empno, ename, sal, deptno) VALUES(1, '아이유', 400, 10);
INSERT INTO mvc_employee(empno, ename, sal, deptno) VALUES(2, '박보검', 300, 10);
INSERT INTO mvc_employee(empno, ename, sal, deptno) VALUES(3, '강하늘', 600, 20);

commit

SELECT COUNT(*) FROM mvc_employee;

--ename, dname, loc
--mvc_employee, mvc_department
SELECT e.empno, e.ename, d.dname, d.loc
FROM mvc_employee e
INNER JOIN mvc_department d
ON e.deptno=d.deptno
WHERE e.empno = 1;

--사원이 없는 부서정보까지 조회하고자 할 경우
SELECT e.ename, d.dname, d.loc
FROM mvc_department d
LEFT OUTER JOIN mvc_employee e
ON e.deptno = d.deptno

SELECT e.ename, d.dname, d.loc
FROM mvc_employee e
RIGHT OUTER JOIN mvc_department d
ON e.deptno = d.deptno

--부서명(dname), 근무지(loc), 부서별 사원수(count(*)) as emp_count
--부서명과 근무지는 mvc_department_table 
--부서별 사원수는 mvc_employee
SELECT d.dname, d.loc, COUNT(*)
FROM(
	SELECT d.dname, d.loc
	FROM mvc_department d, mvc_employee e
	WHERE d.deptno = e.deptno
)
GROUP BY dname

SELECT d.dname, d.loc, count.deptno, count.emp_no
FROM(
	SELECT deptno, COUNT(*) as emp_no
	FROM mvc_employee
	GROUP BY deptno
) count
INNER JOIN mvc_department d
ON d.deptno = count.deptno

--위 결과에서 사원이 없는 부서도 출력하는 경우
SELECT d.dname, d.loc, count.deptno, count.emp_no
FROM mvc_department d 
LEFT OUTER JOIN(
	SELECT deptno, COUNT(*) as emp_no
	FROM mvc_employee
	GROUP BY deptno
) count
ON d.deptno = count.deptno

--NVL(value, alias) --> value가 null일 경우 지정값으로 배치
SELECT d.dname, d.loc, NVL(count.emp_no, 0) as emp_no
FROM mvc_department d 
LEFT OUTER JOIN(
	SELECT deptno, COUNT(*) as emp_no
	FROM mvc_employee
	GROUP BY deptno
) count
ON d.deptno = count.deptno

