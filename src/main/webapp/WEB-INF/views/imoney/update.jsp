<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="imoneyno" value="${imoneyVO.imoneyno }" />
<c:set var="kor_co_nm" value="${imoneyVO.kor_co_nm }" />
<c:set var="join_way" value="${imoneyVO.join_way }" />
<c:set var="fin_prdt_nm" value="${imoneyVO.fin_prdt_nm }" />
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KM Bank</title>
 
<link href="/css/style.css" rel="Stylesheet" type="text/css">
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    
<script type="text/javascript">
  $(function(){
 
  });
</script>
 
</head> 
 
<body>
<jsp:include page="../menu/top.jsp" flush='false' />
 
<DIV class='title_line'>
  <A href="../connsite/site_list.do" class='title_link'>적금 상품</A>
   > 사이트 수정(관리자)
</DIV>

  <DIV class='content_body'>
    <ASIDE class="aside_right">
      <A href="javascript:location.reload();">새로고침</A>
      <span class='menu_divide' >│</span> 
      <A href='./imoney_list_search_paging.do'>목록</A>
    </ASIDE> 
  
  
  <DIV class='menu_line'></DIV>

  <fieldset class="fieldset_basic">
    <ul>
      <li class="li_none">
      
        <DIV style='text-align: left; width: 47%; float: left;'>
          <span style='font-size: 1.2em;'>${kor_co_nm}</span>
          <FORM name='frm' method='POST' action='./update.do' 
              enctype="multipart/form-data">
            <input type="hidden" name="imoneyno" value="${imoneyno }">
            <!-- <input type='hidden' name='now_page' value='${param.now_page }'>  -->
            <!-- <input type="hidden" name="adminno" value="1"> <%-- 관리자 개발후 변경 필요 --%>  -->
 
            <div class="form-group">
               <label class="control-label col-md-4" style='margin-top: 10px;'>은행명</label>
               <div class="col-md-8">
                 <input type='text' name='kor_co_nm' value='${kor_co_nm }' required="required" 
                           autofocus="autofocus" class="form-control" style='width: 100%; margin-top: 10px;'>
               </div>
            </div>
            <div class="form-group">
               <label class="control-label col-md-4" style="margin-top: 10px">상품명</label>
               <div class="col-md-8">
                 <input type='text' name='fin_prdt_nm' value="${fin_prdt_nm }" required="required" 
                            class="form-control" style='width: 100%; margin-top: 10px;'>
               </div>
            </div> 
            <div class="form-group">
               <label class="control-label col-md-4" style="margin-top: 10px">가입 방법</label>
               <div class="col-md-8">
                 <textarea name='join_way' id='join_way' required="required" class="form-control" 
                              style='width: 100%; margin-top: 10px;'>${join_way }</textarea>
               </div>
            </div>
            <div style='margin-top: 20px; clear: both;'>  
              <button type="submit" class="btn btn-primary">저장</button>
              <button type="button" onclick="history.back();" class="btn btn-primary">취소</button>
            </div>  
          </FORM>
        </DIV>
      </li>
      <li class="li_none">

      </li>   
    </ul>
  </fieldset>

</DIV>
 
<jsp:include page="../menu/bottom.jsp" flush='false' />
</body>
 
</html>

