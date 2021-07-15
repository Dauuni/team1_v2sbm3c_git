/**********************************/
/* Table Name: 사이트 */
/**********************************/
CREATE TABLE site(
		siteno                        		NUMBER(10)		 NOT NULL,
		sitename                      		VARCHAR2(30)		 NOT NULL,
		surl                          		VARCHAR2(100)		 NOT NULL,
		sdate                         		DATE		 NOT NULL,
		noticeno                      		NUMBER(10)		 NULL 
);

COMMENT ON TABLE site is '사이트';
COMMENT ON COLUMN site.siteno is '사이트 번호';
COMMENT ON COLUMN site.sitename is '사이트 이름';
COMMENT ON COLUMN site.surl is '주소';
COMMENT ON COLUMN site.sdate is '등록일';
COMMENT ON COLUMN site.noticeno is '게시판 번호';