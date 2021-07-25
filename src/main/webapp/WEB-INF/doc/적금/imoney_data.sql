-- 모든 레코드 삭제
DROP TABLE imoney_data;
commit;

/**********************************/
/* Table Name: 적금 상품 */
/**********************************/
CREATE TABLE imoney_data(
    imoneyno                      NUMBER(10)    NOT NULL PRIMARY KEY,
    kor_co_nm                         VARCHAR2(50)     NOT NULL,
    fin_prdt_nm                       VARCHAR2(100)     NOT NULL,
    join_way                          CLOB     NOT NULL,
    mtrt_int                          CLOB     NOT NULL
/*  etc_note                          VARCHAR2(200)    NOT NULL  */
);

COMMENT ON TABLE imoney_data is '적금 상품';
COMMENT ON COLUMN imoney_data.imoneyno is '적금 상품 코드';
COMMENT ON COLUMN imoney_data.kor_co_nm is '은행명';
COMMENT ON COLUMN imoney_data.fin_prdt_nm is '적금상품명';
COMMENT ON COLUMN imoney_data.join_way is '가입 방법';
COMMENT ON COLUMN imoney_data.mtrt_int is '만기후 이자율';
/*COMMENT ON COLUMN imoney.etc_note is '기타 유의사항';
*/

DROP SEQUENCE imoney_data_seq;

CREATE SEQUENCE imoney_data_seq
  START WITH 1                -- 시작 번호
  INCREMENT BY 1            -- 증가값
  MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
  CACHE 2                        -- 2번은 메모리에서만 계산
  NOCYCLE;                      -- 다시 1부터 생성되는 것을 방지

-- 등록
INSERT INTO imoney_data(imoneyno, kor_co_nm, fin_prdt_nm, join_way, mtrt_int)
VALUES(imoney_seq.nextval,'신한은행', '서울거주자용', '핸드폰, 인터넷', 3);

-- FK 컬럼의 값이 사전에 등록되었는지 확인
-- ORA-02291: integrity constraint (AI8.SYS_C007066) violated - parent key not found


-- 목록
SELECT imoneyno, kor_co_nm, fin_prdt_nm, join_way, mtrt_int
FROM imoney_data
ORDER BY imoneyno ASC;

commit;

-- 조회, 수정폼
SELECT imoneyno, kor_co_nm, fin_prdt_nm, join_way, mtrt_int 
FROM imoney_data
WHERE imoneyno = 1;

commit;

--수정
UPDATE imoney_data
SET mtrt_int=5, join_way='대구'
WHERE imoneyno=12345;


commit;
-- 삭제
DELETE FROM imoney_data
WHERE imoneyno = 1;
commit;


