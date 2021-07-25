package dev.mvc.imoney;

/*
CREATE TABLE deposit_exam(
   imoneyno                           NUMBER(10)     NOT NULL PRIMARY KEY,
   kor_co_nm                          VARCHAR2(50)   NOT  NULL ,
   fin_prdt_nm                         VARCHAR2(100)   NOT  NULL ,
       join_way                           CLOB   NOT NULL,
   mtrt_int                            CLOB  NOT NULL
);

COMMENT ON TABLE deposit_exam is '예금 상품';
COMMENT ON COLUMN deposit_exam.imoneyno is '예금 상품 번호';
COMMENT ON COLUMN deposit_exam.kor_co_nm is '금융회사명';
COMMENT ON COLUMN deposit_exam.fin_prdt_nm is '금융상품명';
COMMENT ON COLUMN deposit_exam.join_way is '가입방법';
COMMENT ON COLUMN deposit_exam.mtrt_int is '만기 후 이자율';
*/

public class ImoneyVO {
   /** 예금 상품 번호*/
   private int imoneyno;
   /** 금융회사명 */
   private String kor_co_nm;
   /** 금융상품명 */
   private String fin_prdt_nm;
   /** 가입방법 */
   private String join_way;
   /** 만기 후 이자율 */
   private String mtrt_int;
   
  public int getImoneyno() {
    return imoneyno;
  }
  public void setImoneyno(int imoneyno) {
    this.imoneyno = imoneyno;
  }
  public String getKor_co_nm() {
    return kor_co_nm;
  }
  public void setKor_co_nm(String kor_co_nm) {
    this.kor_co_nm = kor_co_nm;
  }
  public String getFin_prdt_nm() {
    return fin_prdt_nm;
  }
  public void setFin_prdt_nm(String fin_prdt_nm) {
    this.fin_prdt_nm = fin_prdt_nm;
  }
  public String getJoin_way() {
    return join_way;
  }
  public void setJoin_way(String join_way) {
    this.join_way = join_way;
  }
  public String getMtrt_int() {
    return mtrt_int;
  }
  public void setMtrt_int(String mtrt_int) {
    this.mtrt_int = mtrt_int;
  }
}
