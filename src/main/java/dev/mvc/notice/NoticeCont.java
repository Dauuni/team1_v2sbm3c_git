package dev.mvc.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class NoticeCont {
  // @Autowired
  // @Qualifier("dev.mvc.admin.AdminProc")
  // private AdminProcInter adminProc;
  
  @Autowired
  @Qualifier("dev.mvc.notice.NoticeProc")
  private NoticeProcInter noticeProc;
  
  public NoticeCont() {
    System.out.println("-> NoticeCont created");
  }
 
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value="/notice/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url);
   
    return mav;
  }
  
  /**
   * 등록폼  ★★★관리자번호 받기★★★
   * http://localhost:9090/notice/create.do
   * @return
   */
  @RequestMapping(value="/notice/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/notice/create");
    
    return mav;
  }
  
  /**
   * 등록 처리
   * @param request
   * @param noticeVO
   * @return
   */
  @RequestMapping(value = "/notice/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, NoticeVO noticeVO) {
    ModelAndView mav = new ModelAndView();
    
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String file1 = "";          // 원본 파일명 image
    String file1saved = "";  // 저장된 파일명, image
    String thumb1 = "";     // preview image
    
    // 기준 경로 확인
    String user_dir = System.getProperty("user.dir");
    // 완성된 절대 경로, F:/ai8/ws_frame/team1_v2sbm3c_git/src/main/resources/static/notice/storage
    String upDir =  user_dir + "/src/main/resources/static/notice/storage/"; 
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    MultipartFile mf = noticeVO.getFile1MF();
    
    file1 = mf.getOriginalFilename(); // 원본 파일명
    long size1 = mf.getSize();  // 파일 크기
    
    if (size1 > 0) { // 파일 크기 체크
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      file1saved = Upload.saveFileSpring(mf, upDir); 
      
      if (Tool.isImage(file1saved)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 250, height: 200
        thumb1 = Tool.preview(upDir, file1saved, 250, 200); 
      }
    }
    
    noticeVO.setFile1(file1);
    noticeVO.setFile1saved(file1saved);
    noticeVO.setThumb1(thumb1);
    noticeVO.setSize1(size1);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    
    // Call By Reference: 메모리 공유, Hashcode 전달
    int cnt = this.noticeProc.create(noticeVO);
    
    mav.addObject("cnt", cnt);
    // mav.addObject("adminno", noticeVO.getAdminno());
    mav.addObject("url","/notice/create_msg");
    
    mav.setViewName("redirect:/notice/msg.do");
    
    return mav;
  }
  
  /**
   * 전체 목록
   * @return
   */
  @RequestMapping(value="/notice/notice_list.do", method = RequestMethod.GET)
  public ModelAndView notice_list() {
    ModelAndView mav = new ModelAndView();
    
    List<NoticeVO> list = this.noticeProc.notice_list();
    mav.addObject("list", list);
    
    mav.setViewName("/notice/notice_list");
    
    return mav;
  }
  
  /**
   * 조회
   * @param request
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/read.do", method = RequestMethod.GET)
  public ModelAndView read(HttpServletRequest request, int noticeno) {
    ModelAndView mav = new ModelAndView();
    
    NoticeVO noticeVO = this.noticeProc.read(noticeno);
    mav.addObject("noticeVO", noticeVO);
    
    mav.setViewName("/notice/read");
    
    return mav;
  }
  
  /**
   * 삭제 폼
   * @param noticeno
   * @return
   */
  @RequestMapping(value = "/notice/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int noticeno) {
    ModelAndView mav = new ModelAndView();
    
    NoticeVO noticeVO = this.noticeProc.read(noticeno);
    mav.addObject("noticeVO", noticeVO);
    
    mav.setViewName("/notice/delete");
    
    return mav;
  }
  
  /**
   * 삭제 처리
   * @param request
   * @param noticeno
   * @return
   */
  // 파라미터에 now_page, word 추가
  @RequestMapping(value = "/notice/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, int noticeno) {
    ModelAndView mav = new ModelAndView();
    
    // -------------------------------------------------------------------
    // 파일 삭제 코드 시작
    // -------------------------------------------------------------------
    
    // 삭제할 파일 정보를 읽어옴.
    NoticeVO vo = noticeProc.read(noticeno);
    
    String file1saved = vo.getFile1saved();
    String thumb1 = vo.getThumb1();
    long size1 = 0;
    boolean sw = false;
    
    // 완성된 절대 경로 F:/ai8/ws_frame/team1_v2sbm3c_git/src/main/resources/static/notice/storage/
    String upDir =  System.getProperty("user.dir") + "/src/main/resources/static/notice/storage/";

    sw = Tool.deleteFile(upDir, file1saved);  // Folder에서 1건의 파일 삭제
    sw = Tool.deleteFile(upDir, thumb1);     // Folder에서 1건의 파일 삭제
    
    // -------------------------------------------------------------------
    // 파일 삭제 종료
    // -------------------------------------------------------------------
    
    int cnt = this.noticeProc.delete(noticeno);
    
    // ★★★ 페이징 삭제 처리 ★★★
    
    // mav.addObject("now_page", now_page);
    
    mav.setViewName("redirect:/notice/notice_list.do");
    
    return mav;
    
  }
}
