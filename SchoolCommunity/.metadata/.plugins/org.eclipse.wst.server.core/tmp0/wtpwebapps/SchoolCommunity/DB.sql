DROP TABLE REPLY_TBL;
DROP TABLE COMMENT_TBL;
DROP TABLE POST_TBL;
DROP TABLE ACCOUNT_TBL;
DROP TABLE SUGGESTION_TBL;

DELETE FROM REPLY_TBL;
DELETE FROM COMMENT_TBL;
DELETE FROM POST_TBL;
DELETE FROM ACCOUNT_TBL;

CREATE TABLE ACCOUNT_TBL(
	ID VARCHAR2(20) NOT NULL PRIMARY KEY,
	PASSWORD VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(30) NOT NULL
);
CREATE TABLE POST_TBL(
	PCODE NUMBER(6) NOT NULL PRIMARY KEY,
	PTYPE CHAR(4) NOT NULL CHECK(PTYPE IN ('NEWS', 'FREE', 'QUES')),
	WRITER VARCHAR2(20) NOT NULL,
	TITLE VARCHAR2(100) NOT NULL,
	CONTENTS VARCHAR2(1000),
	FOREIGN KEY (WRITER) REFERENCES ACCOUNT_TBL (ID) ON DELETE CASCADE
);
CREATE TABLE SUGGESTION_TBL(
	PCODE NUMBER(6) NOT NULL,
	ID VARCHAR2(20) NOT NULL,
	PRIMARY KEY(PCODE, ID),
	FOREIGN KEY(PCODE) REFERENCES POST_TBL(PCODE),
	FOREIGN KEY(ID) REFERENCES ACCOUNT_TBL(ID)
);
CREATE TABLE COMMENT_TBL(
	CMCODE NUMBER(6) NOT NULL PRIMARY KEY,
	PCODE NUMBER(6) NOT NULL,
	WRITER VARCHAR2(20),
	CONTENTS VARCHAR2(500),
	FOREIGN KEY (WRITER) REFERENCES ACCOUNT_TBL (ID) ON DELETE CASCADE,
	FOREIGN KEY (PCODE) REFERENCES POST_TBL (PCODE) ON DELETE CASCADE
);
CREATE TABLE REPLY_TBL(
	RECODE NUMBER(6) NOT NULL PRIMARY KEY,
	CMCODE NUMBER(6) NOT NULL,
	WRITER VARCHAR2(20),
	CONTENTS VARCHAR2(500),
	FOREIGN KEY (WRITER) REFERENCES ACCOUNT_TBL (ID) ON DELETE CASCADE,
	FOREIGN KEY (CMCODE) REFERENCES COMMENT_TBL (CMCODE) ON DELETE CASCADE
);

INSERT INTO ACCOUNT_TBL VALUES('admin','1234','관리자');
UPDATE ACCOUNT_TBL SET PASSWORD='1234' WHERE ID='admin'
INSERT INTO POST_TBL VALUES(1,'NEWS','admin','공지사항테스트제목','공지사항테스트내용입니다.');
INSERT INTO POST_TBL VALUES(2,'FREE','admin','자유게시판테스트제목','자유게시판테스트내용입니다.');
INSERT INTO POST_TBL VALUES(3,'QUES','admin','Q&A테스트제목','Q&A테스트내용입니다.');
INSERT INTO POST_TBL VALUES(4,'NEWS','admin','공지사항정렬','공지사항정렬테스트내용입니다.');
INSERT INTO POST_TBL VALUES(5,'NEWS','admin','공지사항정렬','공지사항정렬테스트내용입니다.');
INSERT INTO POST_TBL VALUES(6,'NEWS','admin','공지사항정렬','공지사항정렬테스트내용입니다.');

INSERT INTO SUGGESTION_TBL VALUES(1,'admin');

INSERT INTO COMMENT_TBL VALUES(1,1,'admin','댓글테스트입니다.');
	INSERT INTO REPLY_TBL VALUES(1,1,'admin','답글테스트입니다.');
	INSERT INTO REPLY_TBL VALUES(2,1,'admin','답글테스트2입니다.');
INSERT INTO COMMENT_TBL VALUES(2,1,'admin','댓글테스트2입니다.');
	INSERT INTO REPLY_TBL VALUES(3,2,'admin','답글테스트3입니다.');
	INSERT INTO REPLY_TBL VALUES(4,2,'admin','답글테스트4입니다.');

--홈 인기글
SELECT X.PCODE PCODE, DECODE(PTYPE, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') PTYPE,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT 
FROM (SELECT PCODE,PTYPE,TITLE,NAME,SUGGESTION
FROM (SELECT X.PCODE PCODE,PTYPE,WRITER,TITLE,COUNT(ID) SUGGESTION
FROM POST_TBL X LEFT OUTER JOIN SUGGESTION_TBL Y ON (X.PCODE=Y.PCODE)
GROUP BY X.PCODE,PTYPE,WRITER,TITLE) LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID)) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE) 
WHERE ROWNUM <= 8
GROUP BY X.PCODE,PTYPE,TITLE,NAME,SUGGESTION
ORDER BY SUGGESTION DESC, PCODE DESC

SELECT X.PCODE PCODE, DECODE(PTYPE, 'NEWS','공지사항','FREE','자유게시판','QUES','Q&A') PTYPE,TITLE,NAME,SUGGESTION,COUNT(Y.CMCODE) COMMENTCOUNT 
FROM (SELECT PCODE,PTYPE,TITLE,NAME,SUGGESTION
FROM (SELECT X.PCODE PCODE,PTYPE,WRITER,TITLE,COUNT(ID) SUGGESTION
FROM POST_TBL X LEFT OUTER JOIN SUGGESTION_TBL Y ON (X.PCODE=Y.PCODE)
GROUP BY X.PCODE,PTYPE,WRITER,TITLE) LEFT OUTER JOIN ACCOUNT_TBL ON(WRITER=ID) WHERE PTYPE=?) X LEFT OUTER JOIN COMMENT_TBL Y ON(X.PCODE=Y.PCODE) 
WHERE ROWNUM <= 8
GROUP BY X.PCODE,PTYPE,TITLE,NAME,SUGGESTION 
ORDER BY PCODE DESC



