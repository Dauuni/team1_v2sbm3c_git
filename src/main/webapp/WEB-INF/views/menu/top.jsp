<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<DIV class='container_main'> 
  <%-- 화면 상단 메뉴 --%>
  <DIV class='top_img'>
    <DIV class='top_menu_label'>KM Bank</DIV>
    <NAV class='top_menu'>
      <span style='padding-left: 0.5%;'></span>
      <A class='menu_link'  href='/' >예금</A><span class='top_menu_sep'> </span> 
      <A class='menu_link'  href='/' >적금</A><span class='top_menu_sep'> </span>
      <A class='menu_link'  href='/notice/notice_list.do'>커뮤니티</A><span class='top_menu_sep'> </span> 
      <A class='menu_link'  href='/connsite/site_list.do'>관련사이트</A><span class='top_menu_sep'> </span> 
      <c:choose>
        <c:when test="${sessionScope.id == null}"> <%-- 로그인 안 한 경 우 --%>
          <A class='menu_link'  href='/member/login.do' >Login</A><span class='top_menu_sep'> </span>
        </c:when>
        <c:otherwise>
          ${sessionScope.id } <A class='menu_link'  href='/member/logout.do' >Logout</A><span class='top_menu_sep'> </span>
        </c:otherwise>
      </c:choose>     
    </NAV>
  </DIV>
  
  <%-- 내용 --%> 
  <DIV class='content'>
  
  