<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KM BANK</title>
 
<link href="/css/style.css" rel="Stylesheet" type="text/css">
 
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head> 
<body>
<jsp:include page="../menu/top.jsp" flush='false' />
 
  <DIV class='title_line'>
    
  </DIV>

  <DIV class='content_body'>
    <ASIDE class="aside_right">
      <A href="javascript:location.reload();">새로고침</A>
      <span class='menu_divide' >│</span> 
      <A href='./imoney_list_search_paging.do'>목록</A>
    </ASIDE> 
   
    <div class='menu_line'></div>
   
   
    <DIV class='message'>
      <FORM name='frm' method='POST' action='./delete.do'>
<%--         <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"> --%>
        <input type ='hidden' name='imoneyno' value = '${param.imoneyno }'>
        '${imoneyVO.kor_co_nm}, ${imoneyVO.fin_prdt_nm }' 상품을 삭제하면 복구 할 수 없습니다.<br><br>
        정말로 삭제하시겠습니까?<br><br>         
        <input type='hidden' name='memberno' value='${imoneyVO.imoneyno}'>     
            
        <button type="submit" class="btn btn-primary">삭제</button>
        <button type="button" onclick="location.href='./imoney_list_search_paging.do'" class="btn btn-primary">취소(목록)</button>
     
      </FORM>
    </DIV>
  </DIV> <%--  <DIV class='content_body'> END --%>

<jsp:include page="../menu/bottom.jsp" flush='false' />
</body>
 
</html>


