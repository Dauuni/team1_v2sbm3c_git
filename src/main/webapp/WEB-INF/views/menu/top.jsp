<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<DIV class='container_main'> 
  <%-- 화면 상단 메뉴 --%>
  <!-- <DIV class='top_img'>  -->
    <DIV class='top_menu_label' style="text-align: center;">
      <A href='/index.do'><img class='top_img' src="/css/images/kmlogo.png"></A>
    </DIV>
    <NAV class='top_menu_km'>
    <div style="text-align: center;">
      <A class='menu_link_km'  href='/deposit/deposit_list_search_paging.do'><img alt="" src="/css/images/deposit.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/'><img alt="" src="/css/images/imoney.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/notice/notice_list_search_paging.do'><img alt="" src="/css/images/notice.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/connsite/site_list_search_paging.do'><img alt="" src="/css/images/connsite.png"></A>  
      <c:choose>
        <c:when test="${sessionScope.id == null}"> <%-- 로그인 안 한 경 우 --%>
          <span style='padding-left: 5%;'></span>
          <A class='menu_link_km'  href='/member/login.do' ><img alt="" src="/css/images/login.png"></A>
        </c:when>
        <c:otherwise>
          ${sessionScope.id } 
          <span style='padding-left: 5%;'></span>
          <A class='menu_link_km'  href='/member/logout.do' ><img alt="" src="/css/images/logout.png"></A>
        </c:otherwise>
      </c:choose>    
      </div> 
    </NAV>
  <!-- </DIV>  -->
  
  <%-- 내용 --%> 
  <DIV class='content'>
  
  