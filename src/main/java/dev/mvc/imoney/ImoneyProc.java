package dev.mvc.imoney;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.mvc.tool.Tool;

@Component("dev.mvc.imoney.ImoneyProc")
public class ImoneyProc  implements ImoneyProcInter{
  @Autowired
  private ImoneyDAOInter imoneyDAO;

  @Override
  public int search_count(HashMap<String, Object> hashMap) {
    int count = imoneyDAO.search_count(hashMap);
    
    return count;
  }
  
  @Override
  public List<ImoneyVO> imoney_list_search_paging(HashMap<String, Object> map) {
    // 페이지에서 출력할 시작 레코드 번호 계산 , nowPage는 1부터 시작
    int begin_of_page = ((Integer)map.get("now_page") - 1) * Imoney.RECORD_PER_PAGE;
   
    // 시작 rownum 결정
    int start_num = begin_of_page + 1;
    
    //  종료 rownum
    int end_num = begin_of_page + Imoney.RECORD_PER_PAGE;   

    map.put("start_num", start_num);
    map.put("end_num", end_num);
   
    List<ImoneyVO> list = this.imoneyDAO.imoney_list_search_paging(map);

     for (ImoneyVO imoneyVO : list) { 
       String mtrt_int = Tool.convertChar(imoneyVO.getMtrt_int()); 
       imoneyVO.setMtrt_int(mtrt_int);
       // System.out.println(imoneyVO.getMtrt_int());
       
       mtrt_int = Tool.convertChar(mtrt_int);
       imoneyVO.setMtrt_int(mtrt_int);
     }
    
    return list;
  }

  @Override
  public String pagingBox(String list_file, int search_count, int now_page, String word, String word1, String word2) {
    int total_page = (int)(Math.ceil((double)search_count/Imoney.RECORD_PER_PAGE));  // 전체 페이지 수 
    int total_grp = (int)(Math.ceil((double)total_page/Imoney.PAGE_PER_BLOCK));         // 전체 그룹  수
    int now_grp = (int)(Math.ceil((double)now_page/Imoney.PAGE_PER_BLOCK));         // 현재 그룹 번호
    
    int start_page = ((now_grp - 1) * Imoney.PAGE_PER_BLOCK) + 1;   // 특정 그룹의 시작  페이지  
    int end_page = (now_grp * Imoney.PAGE_PER_BLOCK);               // 특정 그룹의 마지막 페이지   
     
    StringBuffer str = new StringBuffer(); 
     
    str.append("<style type='text/css'>"); 
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
    str.append("  #paging A:hover{text-decoration:none; background-color: #FFFFFF; color:black; font-size: 1em;}"); 
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
    str.append("  .span_box_1{"); 
    str.append("    text-align: center;");    
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("  }"); 
    str.append("  .span_box_2{"); 
    str.append("    text-align: center;");    
    str.append("    background-color: #668db4;"); 
    str.append("    color: #FFFFFF;"); 
    str.append("    font-size: 1em;"); 
    str.append("    border: 1px;"); 
    str.append("    border-style: solid;"); 
    str.append("    border-color: #cccccc;"); 
    str.append("    padding:1px 6px 1px 6px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("    margin:1px 2px 1px 2px; /*위, 오른쪽, 아래, 왼쪽*/"); 
    str.append("  }"); 
    str.append("</style>"); 
    str.append("<DIV id='paging'>"); 
 
    // 이전 5개 페이지로 이동
    int _now_page = (now_grp - 1) * Imoney.PAGE_PER_BLOCK;
    
    // 현재 그룹번호가 2이상이면 이전 그룹으로 갈수 있는 링크 생성
    if (now_grp >= 2){ 
      str.append("<span class='span_box_1'><A href='"+list_file+"?&word="+word+"&word1="+word1+"&word2="+word2+"&now_page="+_now_page+"'>이전</A></span>"); 
    } 
 
    // 중앙의 페이지 목록
    for(int i=start_page; i<=end_page; i++){ 
      if (i > total_page){ // 마지막 페이지를 넘어갔다면 페이 출력 종료
        break; 
      }
      
      // 목록에 출력하는 페이지가 현재페이지와 같다면 CSS 강조(차별을 둠)
      if (now_page == i){ 
        str.append("<span class='span_box_2'>"+i+"</span>"); // 현재 페이지, 강조 
      }else{
        // 현재 페이지가 아닌 페이지는 이동이 가능하도록 링크를 설정
        str.append("<span class='span_box_1'><A href='"+list_file+"?word="+word+"&word1="+word1+"&word2="+word2+"&now_page="+i+"'>"+i+"</A></span>");   
      } 
    } 
 
    // 5개 다음 페이지로 이동
    _now_page = (now_grp * Imoney.PAGE_PER_BLOCK)+1;  
    if (now_grp < total_grp){ 
      str.append("<span class='span_box_1'><A href='"+list_file+"?&word="+word+"&word1="+word1+"&word2="+word2+"&now_page="+_now_page+"'>다음</A></span>"); 
    } 
    str.append("</DIV>"); 
     
    return str.toString();
  }

  @Override
  public ImoneyVO read(int imoneyno) {
    ImoneyVO imoneyVO = this.imoneyDAO.read(imoneyno);
    
    return imoneyVO;
  }

  @Override
  public int update(ImoneyVO imoneyVO) {
    int cnt = this.imoneyDAO.update(imoneyVO);
    
    return cnt;
  }

  @Override
  public int delete(int imoneyno) {
    int cnt = this.imoneyDAO.delete(imoneyno);
    
    return cnt;
  }

}
