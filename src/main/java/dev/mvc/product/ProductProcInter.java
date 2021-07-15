package dev.mvc.product;

import java.util.List;

public interface ProductProcInter {
  /**
   * 등록
   * @param productVO
   * @return
   */
  public int create(ProductVO productVO);
  
  /**
   * 등록 순서별 목록
   * @return
   */
  public List<ProductVO> list_productno_asc();
  
  /**
   * 출력 순서별 목록
   * @return
   */
  public List<ProductVO> list_seqno_asc();
  
  /**
   * 조회
   * @param prodno
   * @return
   */
  public ProductVO read(int prodno);
  
  /**
   * 수정
   * @param productVO
   * @return
   */
  public int update(ProductVO productVO);
  
  /**
   * 삭제
   * @param prodno
   * @return
   */
  public int delete(int prodno);
  
  /**
   * 출력 순서 상향
   * @param prodno
   * @return
   */
  public int update_seqno_up(int prodno);
  
  /**
   * 출력 순서 하향
   * @param prodno
   * @return
   */
  public int update_seqno_down(int prodno);
}
