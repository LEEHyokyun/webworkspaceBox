DROP TABLE member;
SELECT * FROM member;

CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL
)

INSERT INTO member(id, password, name) VALUES('java', 'a', '아이유');
INSERT INTO member(id, password, name) VALUES('spring', 'a', '박보검');

COMMIT

SELECT * FROM member;

CREATE TABLE board(
	board_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL, 
	hits NUMBER DEFAULT 0,
	time_posted DATE NOT NULL,
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT myboard_fk FOREIGN KEY(id) REFERENCES member(id)
)

/*
 * 
 * CLOB data type : 
 * Oracle 문자열 varchar2 타입은 최대 4000byte 까지 가능 

Oracle clob datatype 을 이용하면 많은 문자열을 저장할 수 있음 
CLOB (character large object) 최대 4GB까지 가능 
사용법은 varchar2 와 동일함
---------------------------------------------------------
HTML 
<pre></pre>
태그로 감싼 문장은 입력한 문장 형태 그대로 브라우저에 표현할 수 있음 - 게시물 본문내용을 보여줄 때 사용 
 * 
*/

CREATE SEQUENCE board_seq;

INSERT INTO board(board_no, title, content, time_posted, id) VALUES(board_seq.nextval, '즐공', '웹공부중', sysdate, 'java');
INSERT INTO board(board_no, title, content, time_posted, id) VALUES(board_seq.nextval, '열공', '인생공부중', sysdate, 'spring');

COMMIT
SELECT * FROM board;
