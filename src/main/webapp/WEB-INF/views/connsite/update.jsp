<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="siteno" value="${connsiteVO.siteno }" />
<c:set var="kor_co_nm" value="${connsiteVO.kor_co_nm }" />
<c:set var="homp_url" value="${connsiteVO.homp_url }" />
<c:set var="cal_tel" value="${connsiteVO.cal_tel }" />
 
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
  <A href="../connsite/site_list.do" class='title_link'>관련사이트</A>
   > 사이트 수정(관리자)
</DIV>

<DIV class='content_body'>
  <ASIDE class="aside_right">
    <A href="./create.do">사이트 등록</A>
    <span class='menu_divide' >│</span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span>
  </ASIDE> 
  
<%--     <DIV style="text-align: right; clear: both;">  
    <form name='frm' id='frm' method='get' action='./list_by_cateno_search.do'>
      <!-- <input type='hidden' name='now_page' value='${param.now_page }'>  -->
      
      <c:choose>
        <c:when test="${param.word != '' }"> 검색하는 경우
          <input type='text' name='word' id='word' value='${param.word }' style='width: 20%;'>
        </c:when>
        <c:otherwise> 검색하지 않는 경우
          <input type='text' name='word' id='word' value='' style='width: 20%;'>
        </c:otherwise>
      </c:choose>
      <button type='submit'>검색</button>
      <c:if test="${param.word.length() > 0 }">
        <button type='button' 
                     onclick="location.href='./list_by_cateno_search.do?cateno=${cateVO.cateno}&word='">검색 취소</button>  
      </c:if>    
    </form>
  </DIV> --%>
  
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
          <span style='font-size: 1.2em;'>${kor_co_nm}</span>
          <FORM name='frm' method='POST' action='./update.do' 
              enctype="multipart/form-data">
            <input type="hidden" name="siteno" value="${siteno }">
            <!-- <input type='hidden' name='now_page' value='${param.now_page }'>  -->
            <!-- <input type="hidden" name="adminno" value="1"> <%-- 관리자 개발후 변경 필요 --%>  -->
            <br>
            변경 이미지 선택<br>  
            <input type='file' name='imgMF' id='imgMF' value='' placeholder="파일 선택">
            <div class="form-group">
               <label class="control-label col-md-4" style='margin-top: 10px;'>사이트명</label>
               <div class="col-md-8">
                 <input type='text' name='kor_co_nm' value='${kor_co_nm }' required="required" 
                           autofocus="autofocus" class="form-control" style='width: 100%; margin-top: 10px;'>
               </div>
            </div>
            <div class="form-group">
               <label class="control-label col-md-4" style="margin-top: 10px">주소</label>
               <div class="col-md-8">
                 <textarea name='homp_url' id='homp_url' required="required" class="form-control" 
                              style='width: 100%; margin-top: 10px;'>${homp_url }</textarea>
               </div>
            </div>
            <div class="form-group">
               <label class="control-label col-md-4" style="margin-top: 10px">전화번호</label>
               <div class="col-md-8">
                 <input type='text' name='cal_tel' value="${cal_tel }" required="required" 
                            class="form-control" style='width: 100%; margin-top: 10px;'>
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

