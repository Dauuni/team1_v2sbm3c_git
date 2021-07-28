package dev.mvc.imoney;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ImoneyCont {
  @Autowired
  @Qualifier("dev.mvc.imoney.ImoneyProc")
  private ImoneyProcInter imoneyProc;
  
  public ImoneyCont() {
    System.out.println("-> ImoneyCont created");
  }
  
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value = "/imoney/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url);
    
    return mav;
  }
  
  /**
   * 검색 + 페이징 목록
   * @param word
   * @param now_page
   * @return
   */
  @RequestMapping(value = "/imoney/imoney_list_search_paging.do", method = RequestMethod.GET)
  public ModelAndView deposit_list_search_paging(
      @RequestParam(value = "word", defaultValue = "") String word,
      @RequestParam(value = "word1", defaultValue = "") String word1,
      @RequestParam(value = "word2", defaultValue = "") String word2,
      @RequestParam(value = "now_page", defaultValue = "1") int now_page) { // ★ HttpServletRequest request {
    
    System.out.println("-> imoney_list_search_paging now_page: " + now_page);
    
    ModelAndView mav = new ModelAndView();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("word", word);
    map.put("word1", word1);
    map.put("word2", word2);
    map.put("now_page", now_page);
    
    // 검색 목록
    List<ImoneyVO> list = imoneyProc.imoney_list_search_paging(map);
    
    mav.addObject("list", list);
    
    // 검색된 레코드 갯수
    int search_count = imoneyProc.search_count(map);
    mav.addObject("search_count", search_count);
    
    String paging = imoneyProc.pagingBox("imoney_list_search_paging.do", search_count, now_page, word, word1, word2);
    mav.addObject("paging", paging);
    
    mav.addObject("now_page", now_page);
    
    mav.setViewName("/imoney/imoney_list_search_paging");
    
    return mav;
  
  }
  
  /**
   * 수정 폼
   * @param imoneyno
   * @return
   */
  @RequestMapping(value = "/imoney/update.do", method = RequestMethod.GET)
  public ModelAndView update(int imoneyno) {
    ModelAndView mav = new ModelAndView();
    
    ImoneyVO imoneyVO = this.imoneyProc.read(imoneyno);
    mav.addObject("imoneyVO", imoneyVO);
    
    mav.setViewName("/imoney/update");
    
    return mav;
  }
  
  /**
   * 수정 처리
   * @param request
   * @param imoneyVO
   * @return
   */
  @RequestMapping(value = "/imoney/update.do", method = RequestMethod.POST)
  public ModelAndView update(HttpServletRequest request, ImoneyVO imoneyVO) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.imoneyProc.update(imoneyVO);
    
    mav.addObject("imoneyno", imoneyVO.getImoneyno());
    
    mav.setViewName("redirect:/imoney/imoney_list_search_paging.do");
    
    return mav;
    
  }
  
  /**
   *  삭제 폼
   * @param imoneyno
   * @return
   */
  @RequestMapping(value = "/imoney/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int imoneyno) {
    ModelAndView mav = new ModelAndView();
    
    ImoneyVO imoneyVO = this.imoneyProc.read(imoneyno);
    mav.addObject("imoneyVO", imoneyVO);
    
    mav.setViewName("/imoney/delete");
    
    return mav;
  }
  
  /**
   * 삭제 처리
   * @param request
   * @param imoneyno
   * @return
   */
  @RequestMapping(value = "/imoney/delete.do", method=RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, int imoneyno) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.imoneyProc.delete(imoneyno);
    
    // ★★★ 페이징 삭제 처리 ★★★
    
    // mav.addObject("now_page", now_page);
    
    mav.setViewName("redirect:/imoney/imoney_list_search_paging.do.do");
    
    return mav;
    
  }
}
