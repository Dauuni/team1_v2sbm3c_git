package dev.mvc.imoney_data;

import java.util.HashMap;

public interface Imoney_dataProcInter {
  /**
   * 등록
   * @param imoney_dataVO
   * @return
   */
  public int create(Imoney_dataVO imoney_dataVO);
  
  /**
   * 전체 레코드 갯수
   * @param hashMap
   * @return
   */
  public int all_count2(HashMap<String, Object> hashMap);

}