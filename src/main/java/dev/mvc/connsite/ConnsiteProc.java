package dev.mvc.connsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.mvc.tool.Tool;

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
  public List<ConnsiteVO> site_list() {
    List<ConnsiteVO> list = null;
    list = this.connsiteDAO.site_list();
    
    return list;
  }
  
  @Override
  public ConnsiteVO read(int siteno) {
    ConnsiteVO connsiteVO = this.connsiteDAO.read(siteno);
    
    String sitename = connsiteVO.getSitename();
    String surl = connsiteVO.getSurl();
    
    sitename = Tool.convertChar(sitename);
    connsiteVO.setSitename(sitename);
    
    long imgsize = connsiteVO.getImgsize();
    connsiteVO.setSize1_label(Tool.unit(imgsize));
    
    return connsiteVO;
  }
  
  @Override
  public int update(ConnsiteVO connsiteVO) {
    int cnt = this.connsiteDAO.update(connsiteVO);
    
    return cnt;
  }

  @Override
  public int delete(int siteno) {
    int cnt = 0;
    cnt = this.connsiteDAO.delete(siteno);
    
    return cnt;
  }

}
