package dev.mvc.product;

/*
    prodno                            NUMBER(10)     NOT NULL,
    categrpno                         NUMBER(10)     NULL ,
    prodname                          VARCHAR2(30)     NOT NULL,
    seqno                             NUMBER(10)     NOT NULL,
    pdate                             VARCHAR2(30)     NOT NULL,
        FOREIGN KEY (categrpno) REFERENCES categrp (categrpno)
 */

public class ProductVO {
  /** 상품 카테고리 번호 */
  private int prodno;
  /** 카테고리 그룹 번호 */
  private int categrpno;
  /** 상품 이름 */
  private String prodname;
  /** 출력 순서 */
  private int seqno;
  /** 등록일 */
  private String pdate;
  
  public int getProdno() {
    return prodno;
  }
  public void setProdno(int prodno) {
    this.prodno = prodno;
  }
  public int getCategrpno() {
    return categrpno;
  }
  public void setCategrpno(int categrpno) {
    this.categrpno = categrpno;
  }
  public String getProdname() {
    return prodname;
  }
  public void setProdname(String prodname) {
    this.prodname = prodname;
  }
  public int getSeqno() {
    return seqno;
  }
  public void setSeqno(int seqno) {
    this.seqno = seqno;
  }
  public String getPdate() {
    return pdate;
  }
  public void setPdate(String pdate) {
    this.pdate = pdate;
  }
  
}
