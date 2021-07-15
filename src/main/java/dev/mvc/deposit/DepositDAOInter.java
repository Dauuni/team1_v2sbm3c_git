package dev.mvc.deposit;

public interface DepositDAOInter {
  /**
   * 등록
   * @param depositVO
   * @return
   */
  public int create(DepositVO depositVO);
  
  /**
   * 조회
   * @param depositno
   * @return
   */
  public DepositVO read(int depositno);
  
  /**
   * 수정
   * @param depositVO
   * @return
   */
  public int update(DepositVO depositVO);
  
  /**
   * 삭제
   * @param depositno
   * @return
   */
  public int delete(int depositno);

}
