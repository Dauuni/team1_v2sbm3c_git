package dev.mvc.deposit_data;

import java.util.HashMap;

public interface Deposit_dataDAOInter {
  /**
   * 등록
   * @param deposit_dataVO
   * @return
   */
  public int create(Deposit_dataVO deposit_dataVO);

  /**
   * 전체 레코드 갯수
   * @param hashMap
   * @return
   */
  public int all_count(HashMap<String, Object> hashMap);
  
}
