package dev.mvc.imoney_data;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Imoney_dataCont {
  @Autowired
  @Qualifier("dev.mvc.imoney_data.Imoney_dataProc")
  private Imoney_dataProcInter imoney_dataProc;
  
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value = "/idata/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url);
    
    return mav;
  }
  
  /**
   * 등록 폼
   * @return
   */
  @RequestMapping(value = "/idata/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/idata/create");
    
    return mav;
  }
  
  /**
   * Ajax 등록 처리
   * @param session
   * @param imoneyno
   * @return
   */
  @RequestMapping(value="/idata/create.do", method=RequestMethod.POST )
  @ResponseBody
  public String create(@RequestParam(value="kor_co_nm[]") List<String> kor_co_nm,
                            @RequestParam(value="fin_prdt_nm[]") List<String> fin_prdt_nm,
                            @RequestParam(value="join_way[]") List<String> join_way,
                            @RequestParam(value="mtrt_int[]") List<String> mtrt_int) {
    Imoney_dataVO imoney_dataVO = new Imoney_dataVO();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    
    // 전체 레코드 갯수
    int all_count = imoney_dataProc.all_count(map);
    
    int cnt = 0;
    
    if(all_count == 0) {
      for(int i=0; i<kor_co_nm.size(); i++) {
        imoney_dataVO.setKor_co_nm(kor_co_nm.get(i));
        imoney_dataVO.setFin_prdt_nm(fin_prdt_nm.get(i));
        imoney_dataVO.setJoin_way(join_way.get(i));
        imoney_dataVO.setMtrt_int(mtrt_int.get(i));
        cnt = this.imoney_dataProc.create(imoney_dataVO);
      }
    }
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }

}
