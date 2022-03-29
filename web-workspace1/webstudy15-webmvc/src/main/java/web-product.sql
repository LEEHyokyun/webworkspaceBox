CREATE TABLE web_product(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(100),
	maker VARCHAR2(100),
	price NUMBER NOT NULL
)

CREATE SEQUENCE web_product_seq;

INSERT INTO web_product(id, name, maker, price) VALUES (web_product_seq.nextval, '카스', 'OB', 1500);

INSERT INTO web_product(id, name, maker, price) VALUES (web_product_seq.nextval, '테라', '하이트', 1400);
INSERT INTO web_product(id, name, maker, price) VALUES (web_product_seq.nextval, '맥스', 'OB', 1600);

SELECT * FROM web_product

SELECT NAME, MAKER, PRICE FROM web_product WHERE id=1;

COMMIT

SELECT NAME, MAKER, PRICE FROM web_product ORDER BY id DESC;