package dev.mvc.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("dev.mvc.notice.NoticeProc")
public class NoticeProc implements NoticeProcInter {
  @Autowired
  private NoticeDAOInter noticeDAO;

  @Override
  public int create(NoticeVO noticeVO) {
    int cnt = this.noticeDAO.create(noticeVO);
    
    return cnt;
  }

  @Override
  public List<NoticeVO> list_by_categrpno(int categrpno) {
    List<NoticeVO> list = this.noticeDAO.list_by_categrpno(categrpno);
    
    for (NoticeVO noticeVO : list) {  // 내용이 160자 이상이면 160자만 출력
      String content = noticeVO.getContent();
      
      if(content.length() > 160) {
        content = content.substring(0, 160) + "...";
        noticeVO.setContent(content);
      }
    }
    
    return list;
  }

  @Override
  public NoticeVO read(int noticeno) {  //  ★★★Tool 패키지 추가 ★★★
    NoticeVO noticeVO = this.noticeDAO.read(noticeno);
    
    String title = noticeVO.getTitle();
    String content = noticeVO.getContent();
    
    // title = Tool.convertChar(title);  // 특수 문자 처리
    noticeVO.setTitle(title);
    
    long size1 = noticeVO.getSize1();
    // noticeVO.setSize1_label(Tool.unit(size1));
    
    return noticeVO;
  }

  @Override
  public int update(NoticeVO noticeVO) {
    int cnt = this.noticeDAO.update(noticeVO);
    
    return cnt;
  }

  @Override
  public int delete(int noticeno) {
    int cnt = this.noticeDAO.delete(noticeno);
    
    return cnt;
  }

}
