package dev.mvc.connsite;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
   * 등록 폼 ★★★ 관리자 번호 받기 ★★★
   * @return
   */
  @RequestMapping(value = "/connsite/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/connsite/create");
    
    return mav;
  }
  
  /**
   * Ajax 등록 처리
   * @param session
   * @param depositno
   * @return
   */
  @RequestMapping(value="/connsite/create.do", method=RequestMethod.POST )
  @ResponseBody
  public String create(@RequestParam(value="kor_co_nm[]") List<String> kor_co_nm,
                            @RequestParam(value="homp_url[]") List<String> homp_url,
                            @RequestParam(value="cal_tel[]") List<String> cal_tel) {
    ConnsiteVO connsiteVO = new ConnsiteVO();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    
    // 전체 레코드 갯수
    int all_count = connsiteProc.all_count(map);
    
    int cnt = 0;
    
    if(all_count == 0) {
      for(int i=0; i<homp_url.size(); i++) {
        connsiteVO.setKor_co_nm(kor_co_nm.get(i));
        connsiteVO.setHomp_url(homp_url.get(i));
        connsiteVO.setCal_tel(cal_tel.get(i));
        cnt = this.connsiteProc.create(connsiteVO);
        System.out.printf(kor_co_nm.get(i), homp_url.get(i), cal_tel.get(i));
      }
    }
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
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
