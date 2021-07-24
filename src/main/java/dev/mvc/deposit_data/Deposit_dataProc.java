package dev.mvc.deposit_data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.deposit_data.Deposit_dataProc")
public class Deposit_dataProc implements Deposit_dataProcInter {
  @Autowired
  private Deposit_dataDAOInter deposit_dataDAO;

  @Override
  public int create(Deposit_dataVO deposit_dataVO) {
    int cnt = this.deposit_dataDAO.create(deposit_dataVO);
    
    return cnt;
  }
  
  @Override
  public int all_count(HashMap<String, Object> hashMap) {
    int count = deposit_dataDAO.all_count(hashMap);
    
    return count;
  }

}
