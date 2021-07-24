package dev.mvc.connsite;

import java.util.HashMap;
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
   * 전체 레코드 갯수
   * @param hashMap
   * @return
   */
  public int all_count(HashMap<String, Object> hashMap);
  
  /**
   * 검색 목록
   * @param hashmap
   * @return
   */
  public List<ConnsiteVO> site_list_search(HashMap<String, Object> hashmap);
  
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
   * 페이지 목록 문자열 생성, Box 형태
   * @param list_file 목록 파일명
   * @param search_count 검색 갯수
   * @param now_page 현재 페이지
   * @param word 검색어
   * @return
   */
  public String pagingBox(String list_file, int search_count, int now_page, String word);
  
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
