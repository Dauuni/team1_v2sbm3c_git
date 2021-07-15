/**********************************/
/* Table Name: 예금 상품 */
/**********************************/
CREATE TABLE deposit(
		depositno                     		INTEGER(10)		 NOT NULL,
		adminno                          NUMBER(10)     NULL 
		prodno                        		NUMBER(10)		 NULL ,
		bank                          		VARCHAR2(30)		 NOT NULL,
		dname                         		VARCHAR2(50)		 NOT NULL,
		area                          		VARCHAR2(20)		 NOT NULL,
		per                           		INTEGER(10)		 NOT NULL,
		drate                         		DATE		 NOT NULL
);

COMMENT ON TABLE deposit is '예금 상품';
COMMENT ON COLUMN deposit.depositno is '예금 상품 번호';
COMMENT ON COLUMN deposit.adminno is '관리자 번호';
COMMENT ON COLUMN deposit.prodno is '상품 카테고리 번호';
COMMENT ON COLUMN deposit.bank is '은행명';
COMMENT ON COLUMN deposit.dname is '예금상품명';
COMMENT ON COLUMN deposit.area is '지역';
COMMENT ON COLUMN deposit.per is '이자율';
COMMENT ON COLUMN deposit.drate is '등록일';
