package dev.mvc.deposit;

import java.util.HashMap;
import java.util.List;

public interface DepositProcInter {
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
