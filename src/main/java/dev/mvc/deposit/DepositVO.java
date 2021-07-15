package dev.mvc.deposit;

/*
    depositno                         NUMBER(10)     NOT NULL,
    adminno                           NUMBER(10)     NULL,
    prodno                            NUMBER(10)     NULL ,
    bank                              VARCHAR2(30)     NOT NULL,
    dname                             VARCHAR2(50)     NOT NULL,
    area                              VARCHAR2(20)     NOT NULL,
    per                               NUMBER(10)     NOT NULL,
    drate                             DATE     NOT NULL,
 */

public class DepositVO {
  /** 예금 상품 번호 */
  private int depositno;
  /** 관리자 번호 */
  private int adminno;
  /** 상품 카테고리 번호 */
  private int prodno;
  /** 은행명 */
  private String bank;
  /** 예금상품명 */
  private String dname;
  /** 지역 */
  private String area;
  /** 이자율 */
  private float per;
  /** 등록일 */
  private String drate;
  
  public int getDepositno() {
    return depositno;
  }
  public void setDepositno(int depositno) {
    this.depositno = depositno;
  }
  public int getAdminno() {
    return adminno;
  }
  public void setAdminno(int adminno) {
    this.adminno = adminno;
  }
  public int getProdno() {
    return prodno;
  }
  public void setProdno(int prodno) {
    this.prodno = prodno;
  }
  public String getBank() {
    return bank;
  }
  public void setBank(String bank) {
    this.bank = bank;
  }
  public String getDname() {
    return dname;
  }
  public void setDname(String dname) {
    this.dname = dname;
  }
  public String getArea() {
    return area;
  }
  public void setArea(String area) {
    this.area = area;
  }
  public float getPer() {
    return per;
  }
  public void setPer(float per) {
    this.per = per;
  }
  public String getDrate() {
    return drate;
  }
  public void setDrate(String drate) {
    this.drate = drate;
  }

}
