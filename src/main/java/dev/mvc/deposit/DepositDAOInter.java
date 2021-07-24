package dev.mvc.deposit;

import java.util.HashMap;
import java.util.List;

import dev.mvc.connsite.ConnsiteVO;

public interface DepositDAOInter {
  /**
   * 검색 레코드 갯수
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  /**
   * 검색 + 페이징 목록
   * @param hashmap
   * @return
   */
  public List<DepositVO> deposit_list_search_paging(HashMap<String, Object> map);
  
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
