DROP TABLE mvc_member;

SELECT * FROM mvc_member;

CREATE TABLE mvc_member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	birthday DATE NOT NULL,
	regdate DATE NOT NULL
);

INSERT INTO mvc_member (id, password, name, address, birthday, regdate) 
VALUES('java', 'a', '아이유', '오리', TO_DATE('2001-03-11', 'yyyy-mm-dd'), sysdate);

INSERT INTO mvc_member (id, password, name, address, birthday, regdate) 
VALUES('queen', 'a', '프레디', '오리', TO_DATE('1970-03-11', 'yyyy-mm-dd'), sysdate);

INSERT INTO mvc_member (id, password, name, address, birthday, regdate) 
VALUES('beatles', 'a', '존레논', '용인', TO_DATE('1980-11-23', 'yyyy-mm-dd'), sysdate);

SELECT name, address, TO_CHAR(birthday, 'yyyy-mm-dd') as bir, TO_CHAR(regdate, 'yyy-mm-dd HH24:MM:SS') as reg FROM mvc_member WHERE id='java' AND password='a';

commit