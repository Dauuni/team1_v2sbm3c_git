/**********************************/
/* Table Name: 게시판 */
/**********************************/
DROP TABLE notice;

CREATE TABLE notice(
    noticeno                          NUMBER(10)     NOT NULL PRIMARY KEY,
    memberno                        NUMBER(10)     NULL,
    title                             VARCHAR2(300)    NOT NULL,
    content                         VARCHAR2(4000)     NOT NULL,
    cnt                               NUMBER(10)     NOT NULL,
    replycnt                          NUMBER(10)     NOT NULL,
    rdate                             DATE     NOT NULL,
        FOREIGN KEY (memberno) REFERENCES member (memberno)
);

COMMENT ON TABLE notice is '게시판';
COMMENT ON COLUMN notice.noticeno is '게시판 번호';
COMMENT ON COLUMN notice.MEMBERNO is '회원 번호';
COMMENT ON COLUMN notice.title is '제목';
COMMENT ON COLUMN notice.content is '내용';
COMMENT ON COLUMN notice.cnt is '추천수';
COMMENT ON COLUMN notice.replycnt is '조회수';
COMMENT ON COLUMN notice.rdate is '등록일';


DROP SEQUENCE notice_seq;

-- Sequence 생성 SQL
CREATE SEQUENCE notice_seq
  START WITH 1                -- 시작 번호
  INCREMENT BY 1            -- 증가값
  MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
  CACHE 2                        -- 2번은 메모리에서만 계산
  NOCYCLE;                      -- 다시 1부터 생성되는 것을 방지
  
  -- 등록
INSERT INTO notice(noticeno, memberno, title, content, cnt, replycnt, rdate)
VALUES(notice_seq.nextval, 1, '추천합니다', '좋은 상품', 0, 0, sysdate);

-- 전체 목록
SELECT noticeno, memberno, title, content, cnt, replycnt, rdate
FROM notice
ORDER BY noticeno ASC;

-- 조회
SELECT noticeno, memberno, title, content, cnt, replycnt, rdate
FROM notice
WHERE noticeno = 1;

-- 수정
UPDATE notice
SET title='비추천', content='별로예요'
WHERE prodno=1;

-- 삭제
DELETE FROM notice
WHERE noticeno=1;

-- 레코드 갯수
SELECT COUNT(*) FROM notice;

commit;