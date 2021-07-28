package dev.mvc.imoney;

import java.util.HashMap;
import java.util.List;

import dev.mvc.connsite.ConnsiteVO;

public interface ImoneyDAOInter {
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
  public List<ImoneyVO> imoney_list_search_paging(HashMap<String, Object> map);
  
  /**
   * 조회
   * @param imoneyno
   * @return
   */
  public ImoneyVO read(int imoneyno);
  
  /**
   * 수정
   * @param imoneyVO
   * @return
   */
  public int update(ImoneyVO imoneyVO);
  
  /**
   * 삭제
   * @param imoneyno
   * @return
   */
  public int delete(int imoneyno);

}
