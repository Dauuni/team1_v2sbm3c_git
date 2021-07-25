package dev.mvc.web;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.imoney.ImoneyProcInter;

@Controller
public class WebLoadingCont {
  @Autowired
  @Qualifier("dev.mvc.imoney.ImoneyProc")
  private ImoneyProcInter imoneyProc = null;
  
  public WebLoadingCont() {
    System.out.println("-> WebLoadingCont created.");
  }
  
  /**
   * 예금
   * http://localhost:9091/fss/read_ajax.do
   * json.put("data", line)
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/fss/read_deposit.do", method = RequestMethod.GET)
  public String read_deposit() {
    System.out.println("-> read_ajax called.");
    String data = "";
    try {
      // Thread.sleep(3000);
      
      String Address = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=2280639be6ff46a7021f490d12ada3a0&topFinGrpNo=020000&pageNo=1";
      String method = "GET";
      URL url = new URL(Address);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod(method);
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
      
//      while((line = br.readLine()) != null){
//        System.out.println(line);
//      }
      data = br.readLine();
      System.out.println(data);
      
      br.close();

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // JSONObject json = new JSONObject();
    // json.put("data", line);
    
    // return json.toString();
    
    return data;
  }
  
  /**
   * 적금
   * http://localhost:9090/imoney/imoney_getdata.do
   * json.put("data", line)
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/fss/read_ajax.do", method = RequestMethod.GET, 
                            produces = "text/plain;charset=UTF-8")
  public String read_ajax() {
    System.out.println("-> imoney_getdata called.");
    String data = "";
    try {
      // Thread.sleep(3000);
      
      String Address = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json?auth=2280639be6ff46a7021f490d12ada3a0&topFinGrpNo=020000&pageNo=1";
      String method = "GET";
      URL url = new URL(Address);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod(method);
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
      
//      while((line = br.readLine()) != null){
//        System.out.println(line);
//      }
      data = br.readLine();
      System.out.println(data);
      
      br.close();

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // JSONObject json = new JSONObject();
    // json.put("data", line);
    
    // return json.toString();
    
    return data;
  }
//  
// @RequestMapping(value = "/imoney/imoney_getdata.do", method = RequestMethod.POST)
//  public ModelAndView create(ImoneyVO imoneyVO) {
//    ModelAndView mav = new ModelAndView();
//    mav.setViewName("/imoney/create"); // webapp/imoney/create.jsp
//    
//    int cnt = imoneyProc.create(imoneyVO);
//    mav.addObject("cnt", cnt);
//    mav.addObject("url", "create_msg");
//    
//    mav.setViewName("redirect:/imoney/msg.do");
//    
//    
//    return mav;
//  }
  
  /**
   * 사이트
   * http://localhost:9090/fss/site_data.do
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/fss/site_data.do", method = RequestMethod.GET)
  public String site_data() {
    System.out.println("-> site_data called.");
    String data = "";
    try {
      // Thread.sleep(3000);
      
      String Address = "http://finlife.fss.or.kr/finlifeapi/companySearch.json?auth=47673d6decea5b861553d9d919dff99b&topFinGrpNo=020000&pageNo=1";
      String method = "GET";
      URL url = new URL(Address);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod(method);
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
      
//      while((line = br.readLine()) != null){
//        System.out.println(line);
//      }
      data = br.readLine();
      System.out.println(data);
      
      br.close();

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // JSONObject json = new JSONObject();
    // json.put("data", line);
    
    // return json.toString();
    
    return data;
  }

}
