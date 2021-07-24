package dev.mvc.connsite;

import org.springframework.web.multipart.MultipartFile;

/*
CREATE TABLE site(
    siteno                              NUMBER(10)     NOT NULL PRIMARY KEY,
        img                                 VARCHAR2(100)  NULL,
        imgsaved                          VARCHAR2(100)  NULL,
        thumb                             VARCHAR2(100)  NULL,
        imgsize                            NUMBER(10) NULL,
    kor_co_nm                        VARCHAR2(30)    NOT NULL,
    homp_url                          CLOB     NOT NULL,
        cal_tel                              VARCHAR2(100) NOT NULL,
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
COMMENT ON COLUMN site.cnt is '추천수';
 */

public class ConnsiteVO {
  /** 사이트 번호 */
  private int siteno;
  /** 사이트 이미지 */
  private String img;
  /** 실제 저장 이미지 */
  private String imgsaved;
  /** 이미지 preview */
  private String thumb;
  /** 이미지 사이즈 */
  private long imgsize;
  /** 사이트 이름 */
  private String kor_co_nm;
  /** 주소 */
  private String homp_url;
  /** 검색어 */
  private String cal_tel;
  /** 추천수 */
  private int cnt;
  
  private MultipartFile imgMF;
  
  /** 파일 크기 단위 출력 */
  private String size1_label;
  
  public MultipartFile getImgMF() {
    return imgMF;
  }
  public void setImgMF(MultipartFile imgMF) {
    this.imgMF = imgMF;
  }
  public String getSize1_label() {
    return size1_label;
  }
  public void setSize1_label(String size1_label) {
    this.size1_label = size1_label;
  }
  public int getSiteno() {
    return siteno;
  }
  public void setSiteno(int siteno) {
    this.siteno = siteno;
  }
  public long getImgsize() {
    return imgsize;
  }
  public void setImgsize(long imgsize) {
    this.imgsize = imgsize;
  }
  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public String getImgsaved() {
    return imgsaved;
  }
  public void setImgsaved(String imgsaved) {
    this.imgsaved = imgsaved;
  }
  public String getThumb() {
    return thumb;
  }
  public void setThumb(String thumb) {
    this.thumb = thumb;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public String getKor_co_nm() {
    return kor_co_nm;
  }
  public void setKor_co_nm(String kor_co_nm) {
    this.kor_co_nm = kor_co_nm;
  }
  public String getHomp_url() {
    return homp_url;
  }
  public void setHomp_url(String homp_url) {
    this.homp_url = homp_url;
  }
  public String getCal_tel() {
    return cal_tel;
  }
  public void setCal_tel(String cal_tel) {
    this.cal_tel = cal_tel;
  }
  
}
