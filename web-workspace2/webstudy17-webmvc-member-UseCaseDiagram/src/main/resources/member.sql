SELECT * FROM MEMBER;

--login
---client가 전송한 id와 password가 일치하는 회원이 존재할 경우 해당 회원정보를 조회
SELECT name, address FROM member WHERE id = 'spring' and password = 'abcd';
---회원정보가 없을 경우: id가 일치하지 않거나 pw가 일치하지 않거나
SELECT name, address FROM member WHERE id = 'spring' and password = '1';

COMMIT

--아이디 존재 유무를 판단
SELECT COUNT(*) FROM member WHERE id='java';
SELECT COUNT(*) FROM member WHERE id='java2';