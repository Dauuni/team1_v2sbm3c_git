package dev.mvc.imoney;

import java.util.HashMap;
import java.util.List;

public interface ImoneyProcInter {
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
   * 페이지 목록 문자열 생성, Box 형태
   * @param list_file 목록 파일명
   * @param search_count 검색 갯수
   * @param now_page 현재 페이지
   * @param word 검색어
   * @return
   */
  public String pagingBox(String list_file, int search_count, int now_page, String word, String word1, String word2);
  
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
