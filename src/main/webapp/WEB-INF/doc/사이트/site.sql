/**********************************/
/* Table Name: 사이트 */
/**********************************/
DROP TABLE site;

CREATE TABLE site(
    siteno                              NUMBER(10)     NOT NULL PRIMARY KEY,
        img                                 VARCHAR2(100)  NULL,
        imgsaved                          VARCHAR2(100)  NULL,
        thumb                             VARCHAR2(100)  NULL,
        imgsize                            NUMBER(10) NULL,
    kor_co_nm                        VARCHAR2(100)     NOT NULL,
    homp_url                          CLOB     NOT NULL,
        cal_tel                              VARCHAR2(100) NOT NULL,
        area_cd                        VARCHAR2(20) NOT NULL,
        area_nm                        VARCHAR2(50) NOT NULL,
    cnt                                 NUMBER(10)
);

COMMENT ON TABLE site is '사이트';
COMMENT ON COLUMN site.siteno is '사이트 번호';
COMMENT ON COLUMN site.img is '사이트 이미지';
COMMENT ON COLUMN site.imgsaved is '실제 저장 이미지';
COMMENT ON COLUMN site.thumb is '이미지 preview';
COMMENT ON COLUMN site.imgsize is '이미지 사이즈';
COMMENT ON COLUMN site.kor_co_nm is '사이트 이름';
COMMENT ON COLUMN site.homp_url is '주소';
COMMENT ON COLUMN site.cal_tel is '전화번호';
COMMENT ON COLUMN site.area_cd is '지역구분';
COMMENT ON COLUMN site.area_nm is '지역이름';
COMMENT ON COLUMN site.cnt is '추천수';

DROP SEQUENCE site_seq;

-- Sequence 생성 SQL
CREATE SEQUENCE site_seq
  START WITH 1                -- 시작 번호
  INCREMENT BY 1            -- 증가값
  MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
  CACHE 2                        -- 2번은 메모리에서만 계산
  NOCYCLE;                      -- 다시 1부터 생성되는 것을 방지
  
-- 이름 지역 join
SELECT d.kor_co_nm, s.area_nm, d.fin_prdt_nm, d.join_way, d.mtrt_int
FROM site s, deposit_data d
WHERE d.kor_co_nm = s.kor_co_nm;