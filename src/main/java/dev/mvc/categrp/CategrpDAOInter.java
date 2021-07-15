package dev.mvc.categrp;

import java.util.List;

public interface CategrpDAOInter {
  /**
   * 생성
   * @param categrpVO
   * @return
   */
  public int create(CategrpVO categrpVO);
  
  /**
   * 등록 순서별 목록
   * @return
   */
  public List<CategrpVO> list_categrpno_asc();

  /**
   * 출력 순서별 목록
   * @return
   */
  public List<CategrpVO> list_seqno_asc();

  /**
   * 조회
   * @param categrpno
   * @return
   */
  public CategrpVO read(int categrpno);
  
  /**
   * 수정
   * @param categrpVO
   * @return
   */
  public int update(CategrpVO categrpVO);
  
  /**
   * 삭제
   * @param categrpno
   * @return
   */
  public int delete(int categrpno);
  
  /**
   * 출력 순서 상향
   * @param categrpno
   * @return 처리된 레코드 갯수
   */
  public int update_seqno_up(int categrpno);
 
  /**
   * 출력 순서 하향
   * @param categrpno
   * @return 처리된 레코드 갯수
   */
  public int update_seqno_down(int categrpno); 
  
  /**
   * visible 수정
   * @param categrpVO
   * @return
   */
  public int update_visible(CategrpVO categrpVO);
}
