package dev.mvc.notice;

import java.util.List;

public interface NoticeDAOInter {
  /**
   * 등록
   * @param noticeVO
   * @return
   */
  public int create(NoticeVO noticeVO);
  
  /** 
   * 카테고리 그룹별 조회
   * @param categrpno
   * @return
   */
  public List<NoticeVO> list_by_categrpno(int categrpno);
  
  /**
   * 전체 목록
   * @return
   */
  public List<NoticeVO> notice_list();
  
  /**
   * 조회
   * @param noticeno
   * @return
   */
  public NoticeVO read(int noticeno);
  
  /**
   * 수정
   * @param noticeVO
   * @return
   */
  public int update(NoticeVO noticeVO);
  
  /**
   * 삭제
   * @param noticeno
   * @return
   */
  public int delete(int noticeno);

}
