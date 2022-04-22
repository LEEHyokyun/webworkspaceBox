--pagination

--기본설정
SELECT * FROM member;

DROP 	TABLE board;
--board는 일단 drop 후 재생성
SELECT COUNT(*) FROM board;

INSERT INTO board(no, title, content, time_posted, id) VALUES(board_seq.nextval, '즐공', '웹공부중', sysdate, 'java');
INSERT INTO board(no, title, content, time_posted, id) VALUES(board_seq.nextval, '열공', '인생공부중', sysdate, 'spring');
INSERT INTO board(no, title, content, time_posted, id) VALUES(board_seq.nextval, '불금', '오늘은 불금', sysdate, 'java'); 

--select한 정보를 insert
INSERT INTO board(no, title, content, time_posted, id)
SELECT board_seq.nextval, title, content, sysdate, id from board

-- 1. row number 적용
SELECT no, title, TO_CHAR(time_posted, 'yyyy.mm.dd') as time_posted , hits
FROM board ORDER BY no DESC;


SELECT ROW_NUMBER() OVER(ORDER BY no DESC) as rnum, no, title, time_posted, hits  --ROU NUMBER OVER 내부는 반드시 order by 기준이 있어야 한다.
FROM board

-- 2. nowPage에 해당하는 post 출력
SELECT rnum, no, title, time_posted, hits 
FROM(
	SELECT ROW_NUMBER() OVER(ORDER BY no DESC) as rnum, no, title, time_posted, hits 
	FROM board
)
WHERE rnum BETWEEN 1 AND 5

-- 3. 특정 페이지에서의 회원명 조회
SELECT b.rnum, b.no, b.title, b.time_posted, b.hits, m.name
FROM(
	SELECT ROW_NUMBER() OVER(ORDER BY no DESC) as rnum, no, title, time_posted, hits, id
	FROM board
) b
INNER JOIN member m ON b.id=m.id 
WHERE rnum BETWEEN 1 AND 5