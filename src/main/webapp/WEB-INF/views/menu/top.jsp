<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  @font-face {
    font-family: menu_font; 
    src: url("/css/font/H2HDRM.TTF");
  }
</style>

<script>
$(document).ready(function(){
  $('.admin').click(function(){
    if(document.getElementById("board").style.visibility=="hidden"){
      document.getElementById("board").style.visibility="visible"
    } else {
      document.getElementById("board").style.visibility="hidden"
    }
  });
});
</script>

<DIV class='container_main'>
  <c:choose>
    <c:when test="${sessionScope.id != null}">
    <DIV class='top_banner'>
      <DIV class='banner1'>
        <A href='/index.do'><img class='top_img' src="/css/images/kmlogo.png"></A>
      
        <span style='padding-left: 5%;'></span>
        <img class='top_img2' src="/css/images/Logo.png">
      </DIV>
      
      <DIV class='banner2'>
        <NAV class='top_menu_km'>
          <span style='padding-left: 9%;'></span>
          <A class='menu_link_km'  href='/deposit/deposit_list_search_paging.do'>예금</A>  
          <span style='padding-left: 9%;'></span>
          <A class='menu_link_km'  href='/imoney/imoney_list_search_paging.do'>적금</A>  
          <span style='padding-left: 9%;'></span>
          <A class='menu_link_km'  href='/notice/notice_list_search_paging.do'>커뮤니티</A>  
          <span style='padding-left: 9%;'></span>
          <A class='menu_link_km'  href='/connsite/site_list_search_paging.do'>은행</A>
        </NAV>
      </DIV>
    
      <DIV class='banner3'>
        <span style='padding-left: 5%;'></span>
        <A class='login_btn'  href='/index.do'><img class='my_img' alt="" src="/css/images/My.png"></A>
        <c:choose>
            <c:when test="${sessionScope.grade == 1 }">
            <img class='admin' alt="" src="/css/images/admin.png">
            </c:when>
          </c:choose>
        <A class='login_btn'  href='/member/logout.do' ><img class='logout_img' alt="" src="/css/images/logout_btn.png"></A>
        <nav class="board" id="board" style="visibility:hidden;">
          <A class='admin_menu'  href='/deposit/deposit_list_search_paging.do'>회원 목록</A>  
          <span style='padding-left: 5%;'></span>
          <A class='admin_menu'  href='/data/create.do'>데이터 수집</A>  
          <br></br>
          <A class='admin_menu'  href='/idata/create.do'>적금 데이터 수집</A>  
          
        </nav>
      </DIV>
    </DIV>
    </c:when>
    <c:otherwise>
      <DIV class='top_banner'>
        <DIV class='banner1'>
          <A href='/index.do'><img class='top_img' src="/css/images/kmlogo.png"></A>
        
          <span style='padding-left: 5%;'></span>
          <img class='top_img2' src="/css/images/Logo.png">
        </DIV>
        
        <DIV class='banner2'>
          <NAV class='top_menu_km'>
            <span style='padding-left: 9%;'></span>
            <A class='menu_link_km'  href='/deposit/deposit_list_search_paging.do'>예금</A>  
            <span style='padding-left: 9%;'></span>
            <A class='menu_link_km'  href='/imoney/imoney_list_search_paging.do'>적금</A>  
            <span style='padding-left: 9%;'></span>
            <A class='menu_link_km'  href='/notice/notice_list_search_paging.do'>커뮤니티</A>  
            <span style='padding-left: 9%;'></span>
            <A class='menu_link_km'  href='/connsite/site_list_search_paging.do'>은행</A>
          </NAV>
        </DIV>
        
        <DIV class='banner3'>
          <span style='padding-left: 5%;'></span> 
          <A class='login_btn'  href='/member/login.do' ><img class='login_img' alt="" src="/css/images/login_btn.png"></A>
        </DIV>
      </DIV>
    </c:otherwise>
  </c:choose>
    
  <%-- 내용 --%> 
  <DIV class='content'>

  
  