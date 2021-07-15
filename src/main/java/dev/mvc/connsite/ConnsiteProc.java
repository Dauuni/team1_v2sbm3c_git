package dev.mvc.connsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.connsite.ConnsiteProc")
public class ConnsiteProc implements ConnsiteProcInter {
  @Autowired
  private ConnsiteDAOInter connsiteDAO;

  @Override
  public int create(ConnsiteVO connsiteVO) {
    int cnt = connsiteDAO.create(connsiteVO);
    
    return cnt;
  }

  @Override
  public List<ConnsiteVO> list_siteno_asc() {
    List<ConnsiteVO> list = null;
    list = this.connsiteDAO.list_siteno_asc();
    
    return list;
  }

  @Override
  public ConnsiteVO read(int siteno) {
    ConnsiteVO connsiteVO = null;
    connsiteVO = this.connsiteDAO.read(siteno);
    
    return connsiteVO;
  }

  @Override
  public int update(ConnsiteVO connsiteVO) {
    int cnt = 0;
    cnt = this.connsiteDAO.update(connsiteVO);
    
    return cnt;
  }

  @Override
  public int delete(int siteno) {
    int cnt = 0;
    cnt = this.connsiteDAO.delete(siteno);
    
    return cnt;
  }

}
