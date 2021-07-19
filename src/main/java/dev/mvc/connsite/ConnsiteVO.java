package dev.mvc.connsite;

import org.springframework.web.multipart.MultipartFile;

/*
    siteno                            NUMBER(10)     NOT NULL PRIMARY KEY,
    img                                   VARCHAR2(100)  NOT NULL,
    imgsaved                                   VARCHAR2(100)  NOT NULL,
    thumb                                 VARCHAR2(100)  NOT NULL,
    imgsize                           NUMBER(10) NOT NULL,
    sitename                          VARCHAR2(30)     NOT NULL,
    surl                                CLOB     NOT NULL,
    word                              VARCHAR2(100) NOT NULL,
    cnt                                 NUMBER(10) NOT NULL
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
  private String sitename;
  /** 주소 */
  private String surl;
  /** 검색어 */
  private String word;
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
  public String getSitename() {
    return sitename;
  }
  public void setSitename(String sitename) {
    this.sitename = sitename;
  }
  public String getSurl() {
    return surl;
  }
  public void setSurl(String surl) {
    this.surl = surl;
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
  public String getWord() {
    return word;
  }
  public void setWord(String word) {
    this.word = word;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  
  
  
}
