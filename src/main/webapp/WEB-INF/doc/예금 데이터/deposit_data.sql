/**********************************/
/* Table Name: 예금 데이터 */
/**********************************/
DROP TABLE deposit_data;
CREATE TABLE deposit_data(
    depositno                           NUMBER(10)     NOT NULL PRIMARY KEY,
    kor_co_nm                          VARCHAR2(50)   NOT  NULL ,
    fin_prdt_nm                         VARCHAR2(100)   NOT  NULL ,
    join_way                           CLOB   NOT NULL,
    mtrt_int                            CLOB  NOT NULL
);

COMMENT ON TABLE deposit_data is '예금 상품';
COMMENT ON COLUMN deposit_data.depositno is '예금 상품 번호';
COMMENT ON COLUMN deposit_data.kor_co_nm is '금융회사명';
COMMENT ON COLUMN deposit_data.fin_prdt_nm is '금융상품명';
COMMENT ON COLUMN deposit_data.join_way is '가입방법';
COMMENT ON COLUMN deposit_data.mtrt_int is '만기 후 이자율';

DROP SEQUENCE deposit_data_seq;
CREATE SEQUENCE deposit_data_seq
  START WITH 1              -- 시작 번호
  INCREMENT BY 1          -- 증가값
  MAXVALUE 9999999999 -- 최대값: 9999999999
  CACHE 2                     -- 2번은 메모리에서만 계산
  NOCYCLE;                   -- 다시 1부터 생성되는 것을 방지