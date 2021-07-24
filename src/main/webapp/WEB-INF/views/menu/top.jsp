<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<DIV class='container_main'> 
  <%-- 화면 상단 메뉴 --%>
  <!-- <DIV class='top_img'>  -->
  <DIV class='top_banner'>
    <A href='/index.do'><img class='top_img' src="/css/images/kmlogo.png"></A>
    
    <span style='padding-left: 5%;'></span>
    <img class='top_img2' src="/css/images/Logo.png">
    
    <NAV class='top_menu_km'>   
    <div style="text-align: center;">
      <A class='menu_link_km'  href='/deposit/deposit_list_search_paging.do'><img alt="" src="/css/images/deposit.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/'><img alt="" src="/css/images/imoney.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/notice/notice_list_search_paging.do'><img alt="" src="/css/images/notice.png"></A>  
      <span style='padding-left: 5%;'></span>
      <A class='menu_link_km'  href='/connsite/site_list_search_paging.do'><img alt="" src="/css/images/connsite.png"></A>  
    </div> 
    </NAV>
      <c:choose>
      <c:when test="${sessionScope.id == null}"> <%-- 로그인 안 한 경 우 --%>
        <span style='padding-left: 5%;'></span> 
        <A class='login_btn'  href='/member/login.do' ><img class='login_img' alt="" src="/css/images/login_btn.png"></A>
      </c:when>
      <c:otherwise>
        <span style='padding-left: 5%;'></span>
          <A class='login_btn'  href='/index.do'><img class='my_img' alt="" src="/css/images/My.png"></A>
          <A class='login_btn'  href='/member/logout.do' ><img class='logout_img' alt="" src="/css/images/logout_btn.png"></A>
        </div>
      </c:otherwise>
    </c:choose> 
  </DIV>
    
  <%-- 내용 --%> 
  <DIV class='content'>

  
  