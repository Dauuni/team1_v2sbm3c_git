package dev.mvc.connsite;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class ConnsiteCont {
  // @Autowired
  // @Qualifier("dev.mvc.admin.AdminProc")
  // private AdminProcInter adminProc;
  
  @Autowired
  @Qualifier("dev.mvc.connsite.ConnsiteProc")
  private ConnsiteProcInter connsiteProc;
  
  public ConnsiteCont() {
    System.out.println("-> ConnsiteCont created");
  }
  
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value = "/connsite/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url);
    
    return mav;
  }
  
  /**
   * 등록 폼 ★★★관리자번호 받기★★★
   * http://localhost:9090/connsite/create.do
   * @return
   */
  @RequestMapping(value="/connsite/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/connsite/create");
    
    return mav;
  }
  
  /**
   * 등록 처리
   * @param request
   * @param connsiteVO
   * @return
   */
  @RequestMapping(value="/connsite/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, ConnsiteVO connsiteVO) {
    ModelAndView mav = new ModelAndView();
    
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String img = "";          // 원본 파일명 image
    String imgsaved = "";  // 저장된 파일명, image
    String thumb = "";     // preview image
    
    // 기준 경로 확인
    String user_dir = System.getProperty("user.dir");
    // 완성된 절대 경로, F:/ai8/ws_frame/team1_v2sbm3c_git/src/main/resources/static/connsite/storage
    String upDir =  user_dir + "/src/main/resources/static/connsite/storage/"; 
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    MultipartFile mf = connsiteVO.getImgMF();
    
    img = mf.getOriginalFilename();  // 원본 파일명
    long imgsize = mf.getSize();       // 파일 크기
    
    if (imgsize > 0) { // 파일 크기 체크
      // 파일 저장 후 업로드된 파일명이 리턴됨, spring.jsp, spring_1.jpg...
      imgsaved = Upload.saveFileSpring(mf, upDir); 
      
      if (Tool.isImage(imgsaved)) { // 이미지인지 검사
        // thumb 이미지 생성후 파일명 리턴됨, width: 250, height: 200
        thumb = Tool.preview(upDir, imgsaved, 250, 200); 
      }
    }
    
    connsiteVO.setImg(img);
    connsiteVO.setImgsaved(imgsaved);
    connsiteVO.setThumb(thumb);
    connsiteVO.setImgsize(imgsize);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    
    int cnt = this.connsiteProc.create(connsiteVO);
    
    mav.addObject("cnt", cnt);
    mav.addObject("url","/connsite/create_msg");
    
    mav.setViewName("redirect:/connsite/msg.do");
    
    return mav;
  }
  
  /**
   * 전체 목록
   * @return
   */
  @RequestMapping(value = "/connsite/site_list.do", method = RequestMethod.GET)
  public ModelAndView site_list() {
    ModelAndView mav = new ModelAndView();
    
    List<ConnsiteVO> list = this.connsiteProc.site_list();
    mav.addObject("list", list);
    
    mav.setViewName("/connsite/site_list");
    
    return mav;
  }
  
  /**
   * 검색 목록
   * @param word
   * @return
   */
  @RequestMapping(value = "/connsite/site_list_search.do", method = RequestMethod.GET)
  public ModelAndView site_list_search(@RequestParam(value="word", defaultValue = "") String word) {
    ModelAndView mav = new ModelAndView();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("word", word);
    
    // 검색 목록
    List<ConnsiteVO> list = connsiteProc.site_list_search(map);
    mav.addObject("list", list);
    
    // 검색된 레코드 갯수
    int search_count = connsiteProc.search_count(map);
    mav.addObject("search_count", search_count);
    
    mav.setViewName("/connsite/site_list_search");
    
    return mav;
  }
  
  /**
   * 검색 + 페이징 목록
   * @param word
   * @param now_page
   * @return
   */
  @RequestMapping(value = "/connsite/site_list_search_paging.do", method = RequestMethod.GET)
  public ModelAndView site_list_search_paging(
      @RequestParam(value = "word", defaultValue = "") String word,
      @RequestParam(value = "now_page", defaultValue = "1") int now_page) { // ★ HttpServletRequest request {
    
    System.out.println("-> site_list_search_paging now_page: " + now_page);
    
    ModelAndView mav = new ModelAndView();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("word", word);
    map.put("now_page", now_page);
    
    // 검색 목록
    List<ConnsiteVO> list = connsiteProc.site_list_search_paging(map);
    mav.addObject("list", list);
    
    // 검색된 레코드 갯수
    int search_count = connsiteProc.search_count(map);
    mav.addObject("search_count", search_count);
    
    String paging = connsiteProc.pagingBox("site_list_search_paging.do", search_count, now_page, word);
    mav.addObject("paging", paging);
    
    mav.addObject("now_page", now_page);
    
    mav.setViewName("/connsite/site_list_search_paging");
    
    return mav;
  
  }
  
  /**
   * 수정 폼
   * @param siteno
   * @return
   */
  @RequestMapping(value = "/connsite/update.do", method = RequestMethod.GET)
  public ModelAndView update(int siteno) {
    ModelAndView mav = new ModelAndView();
    
    ConnsiteVO connsiteVO = this.connsiteProc.read(siteno);
    mav.addObject("connsiteVO", connsiteVO);
    
    mav.setViewName("/connsite/update");
    
    return mav;
  }
  
  /**
   * 수정 처리
   * @param request
   * @param connsiteVO
   * @return
   */
  @RequestMapping(value = "/connsite/update.do", method = RequestMethod.POST)
  public ModelAndView update(HttpServletRequest request, ConnsiteVO connsiteVO) {  // ★ 추가@RequestParam(value = "now_page", defaultValue = "1") int now_page
    ModelAndView mav = new ModelAndView();
    
    // -------------------------------------------------------------------
    // 파일 삭제 코드 시작
    // -------------------------------------------------------------------
    
    // 삭제할 파일 정보를 읽어옴.
    ConnsiteVO vo = connsiteProc.read(connsiteVO.getSiteno());
    
    String imgsaved = vo.getImgsaved();
    String thumb = vo.getThumb();
    long imgsize = 0;
    boolean sw = false;
    
    // 완성된 경로 F:/ai8/ws_frame/resort_v1sbm3a/src/main/resources/static/connsite/storage/
    String upDir =  System.getProperty("user.dir") + "/src/main/resources/static/connsite/storage/";
    
    sw = Tool.deleteFile(upDir, imgsaved);
    sw = Tool.deleteFile(upDir, thumb);
    
    // -------------------------------------------------------------------
    // 파일 삭제 종료 시작
    // -------------------------------------------------------------------
    
    // -------------------------------------------------------------------
    // 파일 전송 코드 시작
    // -------------------------------------------------------------------
    String img = "";
    
    MultipartFile mf = connsiteVO.getImgMF();
    
    img = mf.getOriginalFilename();
    imgsize = mf.getSize();
    
    if(imgsize > 0) {
      imgsaved = Upload.saveFileSpring(mf, upDir);
      
      if(Tool.isImage(imgsaved)) {
        thumb = Tool.preview(upDir, imgsaved, 250, 200);
      }
    }
    
    connsiteVO.setImg(img);
    connsiteVO.setImgsaved(imgsaved);
    connsiteVO.setThumb(thumb);
    connsiteVO.setImgsize(imgsize);
    // -------------------------------------------------------------------
    // 파일 전송 코드 종료
    // -------------------------------------------------------------------
    
    int cnt = this.connsiteProc.update(connsiteVO);
    
    mav.addObject("siteno", connsiteVO.getSiteno());
    // mav.addObject("now_page", now_page);
    
    mav.setViewName("redirect:/connsite/site_list.do");
    
    return mav;
  }
  
  /**
   * 삭제 폼
   * @param siteno
   * @return
   */
  @RequestMapping(value = "/connsite/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int siteno) {
    ModelAndView mav = new ModelAndView();
    
    ConnsiteVO connsiteVO = this.connsiteProc.read(siteno);
    mav.addObject("connsiteVO", connsiteVO);
    
    mav.setViewName("/connsite/delete");
    
    return mav;
  }
  
  /**
   * 삭제처리
   * @param request
   * @param siteno
   * @return
   */
  //파라미터에 now_page, word 추가
  @RequestMapping(value = "/connsite/delete.do", method=RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, int siteno) {
    ModelAndView mav = new ModelAndView();
    
    // -------------------------------------------------------------------
    // 파일 삭제 코드 시작
    // -------------------------------------------------------------------

    ConnsiteVO connsiteVO = connsiteProc.read(siteno);
    
    String imgsaved = connsiteVO.getImgsaved();
    String thumb = connsiteVO.getThumb();
    long imgsize = 0;
    boolean sw = false;
    
    // 완성된 절대 경로 F:/ai8/ws_frame/team1_v2sbm3c_git/src/main/resources/static/connsite/storage/
    String upDir =  System.getProperty("user.dir") + "/src/main/resources/static/connsite/storage/";

    sw = Tool.deleteFile(upDir, imgsaved);  // Folder에서 1건의 파일 삭제
    sw = Tool.deleteFile(upDir, thumb);     // Folder에서 1건의 파일 삭제
    
    // -------------------------------------------------------------------
    // 파일 삭제 종료
    // -------------------------------------------------------------------
    
    int cnt = this.connsiteProc.delete(siteno);
    
    // ★★★ 페이징 삭제 처리 ★★★
    
    // mav.addObject("now_page", now_page);
    
    mav.setViewName("redirect:/connsite/site_list.do");
    
    return mav;
  }

}
