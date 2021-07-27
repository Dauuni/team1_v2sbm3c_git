package dev.mvc.deposit;

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

import dev.mvc.deposit.DepositVO;
import dev.mvc.tool.Tool;
import dev.mvc.deposit.DepositVO;
import dev.mvc.deposit.DepositVO;
import dev.mvc.deposit.DepositVO;
import dev.mvc.deposit.DepositVO;

@Controller
public class DepositCont {
  @Autowired
  @Qualifier("dev.mvc.deposit.DepositProc")
  private DepositProcInter depositProc;
  
  public DepositCont() {
    System.out.println("-> DepositCont created");
  }
  
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value = "/deposit/msg.do", method = RequestMethod.GET)
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
  @RequestMapping(value = "/deposit/deposit_list_search_paging.do", method = RequestMethod.GET)
  public ModelAndView deposit_list_search_paging(
      @RequestParam(value = "word", defaultValue = "") String word,
      @RequestParam(value = "word1", defaultValue = "") String word1,
      @RequestParam(value = "word2", defaultValue = "") String word2,
      @RequestParam(value = "now_page", defaultValue = "1") int now_page){ // ★ HttpServletRequest request {
    
    System.out.println("-> deposit_list_search_paging now_page: " + now_page);
    
    ModelAndView mav = new ModelAndView();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("word", word);
    map.put("word1", word1);
    map.put("word2", word2);
    map.put("now_page", now_page);
    
    // 검색 목록
    List<DepositVO> list = depositProc.deposit_list_search_paging(map);
    
    mav.addObject("list", list);
    
    // 검색된 레코드 갯수
    int search_count = depositProc.search_count(map);
    mav.addObject("search_count", search_count);
    
    String paging = depositProc.pagingBox("deposit_list_search_paging.do", search_count, now_page, word, word1, word2);
    mav.addObject("paging", paging);
    
    mav.addObject("now_page", now_page);
    
    mav.setViewName("/deposit/deposit_list_search_paging");
    
    return mav;
  
  }
  
  /**
   * 수정 폼
   * @param depositno
   * @return
   */
  @RequestMapping(value = "/deposit/update.do", method = RequestMethod.GET)
  public ModelAndView update(int depositno) {
    ModelAndView mav = new ModelAndView();
    
    DepositVO depositVO = this.depositProc.read(depositno);
    mav.addObject("depositVO", depositVO);
    
    mav.setViewName("/deposit/update");
    
    return mav;
  }
  
  /**
   * 수정 처리
   * @param request
   * @param depositVO
   * @return
   */
  @RequestMapping(value = "/deposit/update.do", method = RequestMethod.POST)
  public ModelAndView update(HttpServletRequest request, DepositVO depositVO) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.depositProc.update(depositVO);
    
    mav.addObject("depositno", depositVO.getDepositno());
    
    mav.setViewName("redirect:/deposit/deposit_list.do");
    
    return mav;
    
  }
  
  /**
   *  삭제 폼
   * @param depositno
   * @return
   */
  @RequestMapping(value = "/deposit/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int depositno) {
    ModelAndView mav = new ModelAndView();
    
    DepositVO depositVO = this.depositProc.read(depositno);
    mav.addObject("depositVO", depositVO);
    
    mav.setViewName("/deposit/delete");
    
    return mav;
  }
  
  /**
   * 삭제 처리
   * @param request
   * @param depositno
   * @return
   */
  @RequestMapping(value = "/deposit/delete.do", method=RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, int depositno) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.depositProc.delete(depositno);
    
    // ★★★ 페이징 삭제 처리 ★★★
    
    // mav.addObject("now_page", now_page);
    
    mav.setViewName("redirect:/deposit/deposit_list.do");
    
    return mav;
    
  }
}
