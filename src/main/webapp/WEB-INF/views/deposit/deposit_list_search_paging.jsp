<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KM Bank</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style type='text/css'>
  @font-face {
    font-family: menu_font; 
    src: url("/css/font/H2HDRM.TTF");
  }
</style>
    
<script type="text/javascript">

<%-- 체크박스 갯수 제한 --%>
$(document).ready(function() {
   $("input[type='checkbox']").on("click", function() {
     let count2 = $("input:checked[type='checkbox']").length;
     if(count2 > 2) {
       $(this).prop("checked", false);
       alert("2개까지만 선택할 수 있습니다.");
     }
   });
});

  <%-- 비교하기 버튼 --%>
  function check_comp(depositno) {
    let count1 = $("input:checked[type='checkbox']").length;
    if(count1 == 0) {
      alert("1개 이상 선택해주세요.");
    }

    var checkbox = $("input[name='dcheck[]']:checked");

    var banknm = [];
    var fin_prdt_nm = [];
    var join_way = [];
    var area = [];
    var tdArr = new Array();  // 이자율

    var msg = '';
    
    checkbox.each(function(i) {
      var tmpVal = $(this).val();
      tdArr.push(tmpVal);
      
      var tr = checkbox.parent().parent().eq(i);
      var td = tr.children();
      // console.log(td);
      
      banknm.push(td.eq(1).text());
      fin_prdt_nm.push(td.eq(2).text());
      join_way.push(td.eq(3).text());
      area.push(td.eq(3).text());

      // console.log(banknm, fin_prdt_nm, join_way, tdArr);
      // return;
    });
    
    for (var i=0; i<checkbox.length; i++) {
      msg +="<div class='dcompare'>";
      msg += '<hr>';
      msg += "<h2 class='bank_name'>"+banknm[i] +"</h2> ";
      msg += "<h3>『 " + fin_prdt_nm[i] + "』</h3>";
      msg += "<h5>- 가입 방법 : " + join_way[i] + "<br></h5>";
      msg += "<h5 class='per_text'>【이자율】</h5><h5>" + tdArr[i]+"</h5>";
      msg += "</div>"
   }
    document.getElementById("dcompare_result").style.display="inline";
    document.getElementById("dcompare_result").innerHTML = msg;
    document.getElementById("dcompare_result").scrollIntoView();
  }

  <%-- 돋보기에 마우스 over 했을 때 행 추가 --%>
  function per_pointer(num, mtrt_int) {
    var row_index = num.parentElement.parentElement.rowIndex;
    const table = document.getElementById('data_table');
    const newRow = table.insertRow(row_index+1);
    const newCol = newRow.insertCell(0);
    newCol.colSpan=6;
    newRow.style.cssText = 'text-align:right;';
  
    newCol.innerHTML = "<td>"+mtrt_int+"</td>";
  }
  
  <%-- 돋보기에 마우스 leave 했을 때 행 삭제  --%>
  function per_pointer_out(num) {
    var row_index = num.parentElement.parentElement.rowIndex;
    const table = document.getElementById('data_table');
    const newRow = table.deleteRow(row_index+1);
  }
  
</script>
 
</head>                          
 
<body>
<jsp:include page="../menu/top.jsp" />
<DIV class='content2' style="background-color: rgba(189, 215, 238, 0.2); border-radius: 20px;">
  <DIV class='content_body'>
    <DIV class='search_form'>
      <DIV class='main_title'>
        예금 상품
      </DIV>
      <form action=""></form>
  
      <form name='frm' id='frm' method='get' action='./deposit_list_search_paging.do'>
        <!-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  -->
        <label><input type="checkbox" name="word1" id ="word1"value="영업점">영업점</label>
        <label><input type="checkbox" name="word1" id ="word1"value="인터넷">인터넷</label>
        <label><input type="checkbox" name="word1" id ="word1"value="스마트폰">스마트폰</label>      
        <button type = 'submit' class='search_btn' value = '${param.word1 }'>가입방법</button>   
      </form>
    
      <form name='frm' id='frm' method='get' action='./deposit_list_search_paging.do'>
        <!-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  -->
        <label><input type="checkbox" name="word2" id ="word2"value="서울">서울</label>
        <label><input type="checkbox" name="word2" id ="word2"value="부산">부산</label>
        <label><input type="checkbox" name="word2" id ="word2"value="대구">대구</label>
        <label><input type="checkbox" name="word2" id ="word2"value="인천">인천</label>
        <label><input type="checkbox" name="word2" id ="word2"value="광주">광주</label>
        <label><input type="checkbox" name="word2" id ="word2"value="대전">대전</label>
        <label><input type="checkbox" name="word2" id ="word2"value="울산">울산</label>
        <label><input type="checkbox" name="word2" id ="word2"value="세종">세종</label>
        <label><input type="checkbox" name="word2" id ="word2"value="경기">경기</label>
        <br>
        <label><input type="checkbox" name="word2" id ="word2"value="강원">강원</label>
        <label><input type="checkbox" name="word2" id ="word2"value="충북">충북</label>
        <label><input type="checkbox" name="word2" id ="word2"value="충남">충남</label>
        <label><input type="checkbox" name="word2" id ="word2"value="전북">전북</label>
        <label><input type="checkbox" name="word2" id ="word2"value="전남">전남</label>
        <label><input type="checkbox" name="word2" id ="word2"value="경북">경북</label>
        <label><input type="checkbox" name="word2" id ="word2"value="경남">경남</label>
        <label><input type="checkbox" name="word2" id ="word2"value="제주">제주</label>
        <button type = 'submit' class='search_btn'>지역선택</button>  
      </form>
  
  
      <form name='frm' id='frm' method='get' action='./deposit_list_search_paging.do'>
        <!-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  -->
        <c:choose>
          <c:when test="${param.word != '' }"> <%-- 검색하는 경우 --%>
            <input type='text' name='word' id='word' value='${param.word }' style='width: 20%;'>
          </c:when>
          <c:otherwise> <%-- 검색하지 않는 경우 --%>
            <input type='text' name='word' id='word' value='' style='width: 20%;'>
          </c:otherwise>
        </c:choose>
        <button type='submit' class='search_btn'>검색</button>
        <c:if test="${param.word.length() > 0 }">
          <button type='button' class='search_btn'
                       onclick="location.href='./site_list_search_paging.do?word='">검색 취소</button>  
        </c:if>    
      </form>
    </DIV>
  
    <div class="dcompare_result" id="dcompare_result" style="display: none;"></div>
    <DIV class='menu_line'></DIV>
  
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 5%;"></col>
        <col style="width: 20%;"></col>
        <col style="width: 30%;"></col>
        <col style="width: 20%;"></col>
        <col style="width: 15%;"></col>
        <c:choose>
          <c:when test="${sessionScope.grade == 1 }">
            <col style="width: 10%;"></col>
          </c:when>
        </c:choose>
      </colgroup>
      
     <thead>  
      <TR>
        <TH class="th_bs">선택</TH>
        <TH class="th_bs">은행명</TH>
        <TH class="th_bs">상품명</TH>
        <TH class="th_bs">가입방법</TH>
        <TH class="th_bs">이자율</TH>
         <c:choose>
          <c:when test="${sessionScope.grade == 1 }">
            <TH class="th_bs">기타</TH>
          </c:when>
        </c:choose>
      </TR>
     </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="depositVO" items="${list }">
          <c:set var="depositno" value="${depositVO.depositno }" />
          <c:set var="banknm" value="${depositVO.banknm }" />
          <c:set var="fin_prdt_nm" value="${depositVO.fin_prdt_nm }" />
          <c:set var="join_way" value="${depositVO.join_way }" />
          <c:set var="mtrt_int" value="${depositVO.mtrt_int }" />
          
          <tr> 
            <td class="td_bs"><input type="checkbox" name="dcheck[]" value='${mtrt_int }'></td>
            <td class="td_bs">${banknm }</td> 
            <td class="td_bs">${fin_prdt_nm }</td> 
            <td class="td_bs">${join_way }</td> 
            <%-- <td class="td_bs">${mtrt_int }</td>  --%> 
            <td class="td_bs"><a onmouseover="per_pointer(this,'${mtrt_int}')" onmouseout="per_pointer_out(this)"><img src="/images/search.png" style="width: 20px;"></a>
            </td>
            <c:choose>
              <c:when test="${sessionScope.grade == 1 }">
                <td style='text-align: center;'><a href="./update.do?depositno=${depositno }">수정</a>/<a href="./delete.do?depositno=${depositno }">삭제</a></td>
              </c:when>
            </c:choose>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <div style="float: right;">
      <button class='deposit_btn' type='button' onclick="check_comp(${depositno })">
        예금상품<br>비교하기
      </button>
    </div>
    <DIV class='bottom_menu'>${paging }</DIV>
  </DIV>
</DIV>

 
<jsp:include page="../menu/bottom.jsp" />
</body>
 
</html>
