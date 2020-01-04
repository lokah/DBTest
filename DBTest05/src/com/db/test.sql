DROP TABLE SCORE;

CREATE TABLE SCORE(
NAME VARCHAR2(1000) PRIMARY KEY,
KOR NUMBER NOT NULL,
ENG NUMBER NOT NULL,
MATH NUMBER NOT NULL,
SUM NUMBER,
AVG NUMBER,
GRADE VARCHAR2(2) CHECK(GRADE IN('A','B','C','D','F'))
);

SELECT*
FROM SCORE;

INSERT INTO SCORE
VALUES('김유신',100,100,100,300,100.0,'A');

