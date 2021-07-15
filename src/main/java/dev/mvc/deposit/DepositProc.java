package dev.mvc.deposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.deposit.DepositProc")
public class DepositProc  implements DepositProcInter{
  @Autowired
  private DepositProc depositDAO;

  @Override
  public int create(DepositVO depositVO) {
    int cnt = this.depositDAO.create(depositVO);
    
    return cnt;
  }

  @Override
  public DepositVO read(int depositno) {
    DepositVO depositVO = this.depositDAO.read(depositno);
    
    return depositVO;
  }

  @Override
  public int update(DepositVO depositVO) {
    int cnt = this.depositDAO.update(depositVO);
    
    return cnt;
  }

  @Override
  public int delete(int depositno) {
    int cnt = this.depositDAO.delete(depositno);
    
    return cnt;
  }

}
