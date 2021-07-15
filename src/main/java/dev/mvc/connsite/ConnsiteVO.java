package dev.mvc.connsite;

/*
    siteno                            NUMBER(10)     NOT NULL PRIMARY KEY,
    sitename                          VARCHAR2(30)     NOT NULL,
    surl                              VARCHAR2(100)    NOT NULL,
    sdate                             DATE     NOT NULL
 */

public class ConnsiteVO {
  /** 사이트 번호 */
  private int siteno;
  /** 사이트 이름 */
  private String sitename;
  /** 주소 */
  private String surl;
  /** 등록일 */
  private String sdate;
  
  public int getSiteno() {
    return siteno;
  }
  public void setSiteno(int siteno) {
    this.siteno = siteno;
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
  public String getSdate() {
    return sdate;
  }
  public void setSdate(String sdate) {
    this.sdate = sdate;
  }
  
  
}
