package dev.mvc.imoney_data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.imoney_data.Imoney_dataProc")
public class Imoney_dataProc implements Imoney_dataProcInter {
  @Autowired
  private Imoney_dataDAOInter imoney_dataDAO;

  @Override
  public int create(Imoney_dataVO deposit_dataVO) {
    int cnt = this.imoney_dataDAO.create(deposit_dataVO);
    
    return cnt;
  }
  
  @Override
  public int all_count(HashMap<String, Object> hashMap) {
    int count = imoney_dataDAO.all_count(hashMap);
    
    return count;
  }

}
