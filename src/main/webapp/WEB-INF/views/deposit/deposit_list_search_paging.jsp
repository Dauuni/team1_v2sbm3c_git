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
    
<script type="text/javascript">

$(document).ready(function() {
   $("input[type='checkbox']").on("click", function() {
     let count2 = $("input:checked[type='checkbox']").length;
     if(count2 > 5) {
       $(this).prop("checked", false);
       alert("5개까지만 선택할 수 있습니다.");
     }
   });
});

<%-- 비교하기 버튼 --%>
function check_comp(depositno, mtrt_int) {
  let count1 = $("input:checked[type='checkbox']").length;
  if(count1 == 0) {
    alert("1개 이상 선택해주세요.");
  }

  console.log(mtrt_int);
  return;

  // var rowData = new Array();
  var tdArr = new Array();
  
  var checkbox = $("input[name=dcheck]:checked");
  // console.log(checkbox);
  // return;
  
  checkbox.each(function(i) {
    var tr = checkbox.parent().parent().eq(i);
    var td = tr.children();
    // console.log(td);
    
    var kor_co_nm = td.eq(1).text()+",";
    var fin_prdt_nm = td.eq(2).text()+",";
    var join_way = td.eq(3).text()+",";
    var mtrt_int = mtrt_int +",";

    tdArr.push(kor_co_nm);
    tdArr.push(fin_prdt_nm);
    tdArr.push(join_way);
    tdArr.push(mtrt_int);
  });
  // $("#dcompare_result").html(rowData);
  $("#dcompare_result").html(tdArr);
  return;

  // ★★★ 여기서부터 다시 ★★★
  console.log(dcheck);
  var dcheck = document.getElementById("dcheck").checked;
  console.log(dcheck);
  
  if(dcheck == true) {
    var deposit = $('#depositno').val(depositno);
    // console.log(deposit);
    
    dcompare(depositno);
  } else {
    alert("코드 오류 발생");
  }
  
}

function dcompare(depositno) {
  // var depositno = $('#depositno').val();
  
  var params = "";
  params += 'depositno=' + depositno;
  // params += '&${ _csrf.parameterName }=${ _csrf.token }';
  console.log('-> dcompare: ' + params);
  
  $.ajax(
    {
      url: '/dcompare/create.do',
      type: 'post',  // get, post
      cache: false, // 응답 결과 임시 저장 취소
      async: true,  // true: 비동기 통신
      dataType: 'json', // 응답 형식: json, html, xml...
      data: params,      // 데이터
      success: function(rdata) { // 응답이 온경우
        var str = '';
        console.log('-> dcompare cnt: ' + rdata.cnt);
        
        if (rdata.cnt == 1) {
            location.href='/dcompare/list_by_depositno.do' ;          
        } else {
          alert('다시 선택해주세요.');
        }
      },
      // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
      error: function(request, status, error) { // callback 함수
        console.log(error);
      }
    }
  );  //  $.ajax END
}

function per_pointer(mtrt_int) {
  // console.log(mtrt_int)
  document.getElementById("per_info").style.display="table-cell"
}

function per_pointer_out() {
  $('#per_info').hide();
}
  
</script>
 
</head>                          
 
<body>
<jsp:include page="../menu/top.jsp" />
<DIV class='title_line'>
      예금 상품
</DIV>

<DIV class='content_body'>
  <form action=""></form>
  
  <form name='frm' id='frm' method='get' action='./deposit_list_search_paging.do'>
    <!-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  -->
<label><input type="checkbox" name="word" value="영업점">영업점</label>
<label><input type="checkbox" name="word" value="인터넷">인터넷</label>
<label><input type="checkbox" name="word" value="스마트폰">스마트폰</label>
<button type = 'submit'>가입방법</button>  
  <c:if test="${param.word.length() > 0}"></c:if>  
  </form>


  <form name='frm' id='frm' method='get' action='./deposit_list_search_paging.do'>
    <!-- <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">  -->
<label><input type="checkbox" name="word" value="서울">서울</label>
<label><input type="checkbox" name="word" value="부산">부산</label>
<label><input type="checkbox" name="word" value="대구">대구</label>
<label><input type="checkbox" name="word" value="인천">인천</label>
<label><input type="checkbox" name="word" value="광주">광주</label>
<label><input type="checkbox" name="word" value="대전">대전</label>
<label><input type="checkbox" name="word" value="울산">울산</label>
<label><input type="checkbox" name="word" value="세종 ">세종</label>
<label><input type="checkbox" name="word" value="경기">경기</label>
<br>
<label><input type="checkbox" name="word" value="강원">강원</label>
<label><input type="checkbox" name="word" value="충북">충북</label>
<label><input type="checkbox" name="word" value="충남">충남</label>
<label><input type="checkbox" name="word" value="전북">전북</label>
<label><input type="checkbox" name="word" value="전남">전남</label>
<label><input type="checkbox" name="word" value="경북">경북</label>
<label><input type="checkbox" name="word" value="경남">경남</label>
<label><input type="checkbox" name="word" value="제주">제주</label>
<button type = 'submit'>지역선택</button>  
  <c:if test="${param.word.length() > 0}"></c:if>  
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
    <button type='submit'>검색</button>
    <c:if test="${param.word.length() > 0 }">
      <button type='button' 
                   onclick="location.href='./site_list_search_paging.do?word='">검색 취소</button>  
    </c:if>    
  </form>
  
  <div id="dcompare_result"></div>
  <DIV class='menu_line'></DIV>
  
  <table class="table table-striped" style='width: 100%;'>
    <colgroup>
      <col style="width: 5%;"></col>
      <col style="width: 20%;"></col>
      <col style="width: 30%;"></col>
      <col style="width: 20%;"></col>
      <col style="width: 15%;"></col>
      <col style="width: 10%;"></col>
    </colgroup>
    
   <thead>  
    <TR>
      <TH class="th_bs">선택</TH>
      <TH class="th_bs">은행명</TH>
      <TH class="th_bs">상품명</TH>
      <TH class="th_bs">가입방법</TH>
      <TH class="th_bs">이자율</TH>
      <TH class="th_bs">기타</TH>
    </TR>
   </thead>
    
    <%-- table 내용 --%>
    <tbody>
      <c:forEach var="depositVO" items="${list }">
        <c:set var="depositno" value="${depositVO.depositno }" />
        <c:set var="kor_co_nm" value="${depositVO.kor_co_nm }" />
        <c:set var="fin_prdt_nm" value="${depositVO.fin_prdt_nm }" />
        <c:set var="join_way" value="${depositVO.join_way }" />
        <c:set var="mtrt_int" value="${depositVO.mtrt_int }" />
        
        <tr> 
          <td class="td_bs"><input type="checkbox" name="dcheck"></td>
          <td class="td_bs">${kor_co_nm }</td> 
          <td class="td_bs">${fin_prdt_nm }</td> 
          <td class="td_bs">${join_way }</td> 
          <%-- <td class="td_bs">${mtrt_int }</td>  --%> 
          <td class="td_bs"><a href="javascript:per_pointer('${mtrt_int}')"><img src="/images/search.png" style="width: 20px;"></a>
          </td>
          <td style='text-align: center;'><a href="./update.do?depositno=${depositno }">수정</a>/<a href="./delete.do?depositno=${depositno }">삭제</a></td>
        </tr>
         <tr>
          <td  id='per_info' colspan="6" style='display: none; text-align: right;'>${mtrt_int }</td>
        </tr>
      </c:forEach>
      
    </tbody>
  </table>
  <div style="text-align: right;">
    <input type='button' class='btn' value='비교하기' style="background-color: #C8DABC" onclick="check_comp(${depositno }, '${mtrt_int }')">
  </div>
  <DIV class='bottom_menu'>${paging }</DIV>
</DIV>

 
<jsp:include page="../menu/bottom.jsp" />
</body>
 
</html>

