package dev.mvc.connsite;

import java.util.List;

public interface ConnsiteProcInter {
  /**
   * 등록
   * @param connsiteVO
   * @return
   */
  public int create(ConnsiteVO connsiteVO);
  
  /**
   * 전체 목록
   * @return
   */
  public List<ConnsiteVO> site_list();
  
  /**
   * 조회
   * @param siteno
   * @return
   */
  public ConnsiteVO read(int siteno);
  
  /**
   * 수정
   * @param connsiteVO
   * @return
   */
  public int update(ConnsiteVO connsiteVO);
  
  /**
   * 삭제
   * @param siteno
   * @return
   */
  public int delete(int siteno);
}
