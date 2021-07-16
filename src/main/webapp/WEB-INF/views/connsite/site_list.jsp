<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KB Bank</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    
<script type="text/javascript">
 
  
</script>
 
</head> 
 
<body>
<jsp:include page="../menu/top.jsp" />
 
<DIV class='title_line'>
  관련사이트
</DIV>

<DIV class='content_body'>
  <ASIDE class="aside_right">
    <A href="./create.do">사이트 등록</A>
    <span class='menu_divide' >│</span>
    <A href="javascript:location.reload();">새로고침</A>
  </ASIDE> 

  <DIV class='menu_line'></DIV>
  
  <table class="table table-striped" style='width: 100%;'>
    <colgroup>
      <col style="width: 10%;"></col>
      <col style="width: 30%;"></col>
      <col style="width: 50%;"></col>
      <col style="width: 10%;"></col>
    </colgroup>
    
    <%-- table 내용 --%>
    <tbody>
      <c:forEach var="connsiteVO" items="${list }">
        <c:set var="siteno" value="${connsiteVO.siteno }" />
        <c:set var="thumb" value="${connsiteVO.thumb }" />
        
        <tr> 
          <td style='vertical-align: middle;'>
           ${siteno }.
          </td>
          <td style='vertical-align: middle; text-align: center;'>
            <c:choose>
              <c:when test="${thumb.endsWith('jpg') || thumb.endsWith('png') || thumb.endsWith('gif')}">
                <%-- /static/connsite/storage/ --%>
                <a href="${connsiteVO.surl }"><IMG src="/connsite/storage/${thumb }" style="width: 120px; height: 80px;"></a> 
              </c:when>
              <c:otherwise> <!-- 이미지가 아닌 일반 파일 -->
                ${connsiteVO.img}
              </c:otherwise>
            </c:choose>
          </td>  
          <td style='vertical-align: middle;'> <!-- ★★★ 새 창으로 열리기 고민 ★★★ -->
            <strong>${connsiteVO.sitename}</strong><a href="${connsiteVO.surl }">${connsiteVO.surl}
          </td> 
          <td style='vertical-align: middle; text-align: center;'><a href="./update.do?siteno=${siteno }">수정</a>/<a href="./delete.do?siteno=${siteno }">삭제</a></td>
        </tr>
      </c:forEach>
      
    </tbody>
  </table>
</DIV>

 
<jsp:include page="../menu/bottom.jsp" />
</body>
 
</html>

