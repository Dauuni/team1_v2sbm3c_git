package dev.mvc.connsite;

import java.util.HashMap;
import java.util.List;

import dev.mvc.notice.NoticeVO;

public interface ConnsiteDAOInter {
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
   * 검색 목록
   * @param hashmap
   * @return
   */
  public List<ConnsiteVO> site_list_search(HashMap<String, Object> hashmap);
 
  /**
   * 전체 레코드 갯수
   * @param hashMap
   * @return
   */
  public int all_count(HashMap<String, Object> hashMap);
  
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
  public List<ConnsiteVO> site_list_search_paging(HashMap<String, Object> map);
  
  /**
   * 조회
   * @param siteno
   * @return
   */
  public ConnsiteVO read(int siteno);
  
  /**
   * 수정.
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
