package dev.mvc.notice;

import org.springframework.web.multipart.MultipartFile;

/*
    noticeno                          NUMBER(10)     NOT NULL,
    categrpno                         NUMBER(10)     NULL ,
    MEMBERNO                          NUMBER(10)     NULL,
    title                             VARCHAR2(300)    NOT NULL,
    content                           INTEGER(4000)    NOT NULL,
    file1                             VARCHAR2(100)    NOT NULL,
    file1saved                        VARCHAR2(100)    NOT NULL,
    thumb1                            VARCHAR2(100)    NOT NULL,
    size1                             NUMBER(10)     NOT NULL,
    cnt                               NUMBER(10)     NOT NULL,
    replycnt                          NUMBER(10)     NOT NULL,
    rdate                             DATE     NOT NULL,
 */

public class NoticeVO {
  /** 게시판 번호 */
  private int noticeno;
  /** 카테고리 그룹 번호 */
  private int categrpno;
  /** 회원 번호 */
  private int memberno;
  /** 제목 */
  private String title;
  /** 내용 */
  private String content;
  /** 메인이미지 */
  private String file1;
  /** 실제 저장 이미지 */
  private String file1saved;
  /** 메인 이미지 Preview */
  private String thumb1;
  /** 이미지 사이즈 */
  private long size1;
  /** 추천수 */
  private int cnt;
  /** 조회수 */
  private int replycnt;
  /** 등록일 */
  private String rdate;
  
  private MultipartFile file1MF;
  
  /** 파일 크기 단위 출력 */
  private String size1_label;
  
  public int getNoticeno() {
    return noticeno;
  }
  public void setNoticeno(int noticeno) {
    this.noticeno = noticeno;
  }
  public int getCategrpno() {
    return categrpno;
  }
  public void setCategrpno(int categrpno) {
    this.categrpno = categrpno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFile1() {
    return file1;
  }
  public void setFile1(String file1) {
    this.file1 = file1;
  }
  public String getFile1saved() {
    return file1saved;
  }
  public void setFile1saved(String file1saved) {
    this.file1saved = file1saved;
  }
  public String getThumb1() {
    return thumb1;
  }
  public void setThumb1(String thumb1) {
    this.thumb1 = thumb1;
  }
  public long getSize1() {
    return size1;
  }
  public void setSize1(long size1) {
    this.size1 = size1;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public int getReplycnt() {
    return replycnt;
  }
  public void setReplycnt(int replycnt) {
    this.replycnt = replycnt;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public MultipartFile getFile1MF() {
    return file1MF;
  }
  public void setFile1MF(MultipartFile file1mf) {
    file1MF = file1mf;
  }
  public String getSize1_label() {
    return size1_label;
  }
  public void setSize1_label(String size1_label) {
    this.size1_label = size1_label;
  }
  
  

}
