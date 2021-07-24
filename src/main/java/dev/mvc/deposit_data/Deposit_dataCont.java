package dev.mvc.deposit_data;

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
public class Deposit_dataCont {
  @Autowired
  @Qualifier("dev.mvc.deposit_data.Deposit_dataProc")
  private Deposit_dataProcInter deposit_dataProc;
  
  /**
   * 새로고침 방지
   * @param url
   * @return
   */
  @RequestMapping(value = "/data/msg.do", method = RequestMethod.GET)
  public ModelAndView msg(String url) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(url);
    
    return mav;
  }
  
  /**
   * 등록 폼
   * @return
   */
  @RequestMapping(value = "/data/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/data/create");
    
    return mav;
  }
  
  /**
   * Ajax 등록 처리
   * @param session
   * @param depositno
   * @return
   */
  @RequestMapping(value="/data/create.do", method=RequestMethod.POST )
  @ResponseBody
  public String create(@RequestParam(value="kor_co_nm[]") List<String> kor_co_nm,
                            @RequestParam(value="fin_prdt_nm[]") List<String> fin_prdt_nm,
                            @RequestParam(value="join_way[]") List<String> join_way,
                            @RequestParam(value="mtrt_int[]") List<String> mtrt_int) {
    Deposit_dataVO deposit_dataVO = new Deposit_dataVO();
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    
    // 전체 레코드 갯수
    int all_count = deposit_dataProc.all_count(map);
    
    int cnt = 0;
    
    if(all_count == 0) {
      for(int i=0; i<kor_co_nm.size(); i++) {
        deposit_dataVO.setKor_co_nm(kor_co_nm.get(i));
        deposit_dataVO.setFin_prdt_nm(fin_prdt_nm.get(i));
        deposit_dataVO.setJoin_way(join_way.get(i));
        deposit_dataVO.setMtrt_int(mtrt_int.get(i));
        cnt = this.deposit_dataProc.create(deposit_dataVO);
      }
    }
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);

    return json.toString();
  }

}
