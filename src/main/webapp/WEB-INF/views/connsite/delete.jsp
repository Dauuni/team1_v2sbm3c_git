<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="siteno" value="${connsiteVO.siteno }" />
<c:set var="sitename" value="${connsiteVO.sitename }" />
 
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

</script>
 
</head> 
 
<body>
<jsp:include page="../menu/top.jsp" flush='false' />
 
<DIV class='title_line'>
  <A href="../notice/site_list.do" class='title_link'>관련사이트</A>
   > 사이트 삭제(관리자)
</DIV>

<DIV class='content_body'>
  <ASIDE class="aside_right">
    <A href="./create.do">등록</A>
    <span class='menu_divide' >│</span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span>
    <A href="./updatedo?siteno=${siteno}">수정</A>
  </ASIDE> 
  
  <DIV class='menu_line'></DIV>

  <fieldset class="fieldset_basic">
    <ul>
      <li class="li_none">
        <DIV style='text-align: center; width: 50%; float: left;'>
          <c:set var="imgsaved" value="${connsiteVO.imgsaved.toLowerCase() }" />
          <c:set var="thumb" value="${connsiteVO.thumb }" />
          <c:choose>
            <c:when test="${thumb.endsWith('jpg') || thumb.endsWith('png') || thumb.endsWith('gif')}">
              <IMG src="/connsite/storage/${imgsaved }" style='width: 70%;'> 
            </c:when>
            <c:otherwise> <!-- 이미지가 아닌 일반 파일 -->
              첨부 파일: ${img}
            </c:otherwise>
          </c:choose>
        </DIV>

        <DIV style='text-align: left; width: 47%; float: left;'>
          <span style='font-size: 1.5em;'>${sitename}</span>
          <br>
          <FORM name='frm' method='POST' action='./delete.do'>
              <%-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"> --%>
              <input type='hidden' name='siteno' value='${param.siteno}'>
              <%-- <input type='hidden' name='now_page' value='${param.now_page }'> ★★★now_page★★★ --%>
                  
              <DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto;"></DIV>
                    
              <div class="form-group">   
                <div class="col-md-12" style='text-align: center; margin: 10px auto;'>
                  삭제 되는글: ${sitename }<br><br>
                  삭제하시겠습니까? 삭제하시면 복구 할 수 없습니다.<br><br>
                 
                  <button type = "submit" class="btn btn-info">삭제 진행</button>
                  <button type = "button" onclick = "history.back()" class="btn btn-info">취소</button>
                </div>
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

