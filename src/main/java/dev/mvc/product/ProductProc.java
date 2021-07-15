package dev.mvc.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.product.ProductProc")
public class ProductProc implements ProductProcInter {
  @Autowired
  private ProductDAOInter productDAO;

  @Override
  public int create(ProductVO productVO) {
    int cnt = productDAO.create(productVO);
    
    return cnt;
  }

  @Override
  public List<ProductVO> list_productno_asc() {
    List<ProductVO> list = null;
    list = this.productDAO.list_productno_asc();
    
    return list;
  }
  
  @Override
  public List<ProductVO> list_seqno_asc() {
    List<ProductVO> list = null;
    list = this.productDAO.list_seqno_asc();
    return list;
  }

  @Override
  public ProductVO read(int prodno) {
    ProductVO productVO = null;
    productVO = this.productDAO.read(prodno);
    
    return productVO;
  }

  @Override
  public int update(ProductVO productVO) {
    int cnt = 0;
    cnt = this.productDAO.update(productVO);
    
    return cnt;
  }

  @Override
  public int delete(int prodno) {
    int cnt = 0;
    cnt = this.productDAO.delete(prodno);
    
    return cnt;
  }

  @Override
  public int update_seqno_up(int prodno) {
    int cnt = 0;
    cnt = this.productDAO.update_seqno_up(prodno);
    
    return cnt;
  }

  @Override
  public int update_seqno_down(int prodno) {
    int cnt = 0;
    cnt = this.productDAO.update_seqno_down(prodno);
    
    return cnt;
  }

}
