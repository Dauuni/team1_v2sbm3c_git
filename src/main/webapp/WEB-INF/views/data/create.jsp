<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KM Bank</title>
<link href="/css/style.css" rel="Stylesheet" type="text/css">

<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript">
$(function() {
  $('#btn_deposit_data').on('click', deposit_data);  // 이벤트 처리 함수 등록
  $('#btn_site_data').on('click', site_data);  // 이벤트 처리 함수 등록
  $('#btn_imoney_data').on('click', imoney_data);  // 이벤트 처리 함수 등록
});

function imoney_data () {
  var params =""; 

  var kor_co_nm = [];
  var fin_prdt_nm = [];
  var join_way = [];
  var mtrt_int = [];
  
  $.ajax({
   url: '/fss/read_ajax.do', // form action
   type: 'get',  // form method, get
   cache: false, // 응답 결과 임시 저장 취소
   async: true,  // true: 비동기 통신
   dataType: 'json', // 응답 형식: json, html, xml...
   data: params,      // 데이터
   success: function(rdata) { // 응답이 온 경우
      for (var i=0; i < rdata.result.baseList.length; i++ ) {
        kor_co_nm.push(rdata.result.baseList[i].kor_co_nm);
        fin_prdt_nm.push(rdata.result.baseList[i].fin_prdt_nm);
        join_way.push(rdata.result.baseList[i].join_way);
        mtrt_int.push(rdata.result.baseList[i].mtrt_int);
      }
         imoney_exam(kor_co_nm, fin_prdt_nm, join_way, mtrt_int);    
   },
   // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
   error: function(request, status, error) { // callback 함수
     console.log(error);
   }
  });
}

function imoney_exam(kor_co_nm, fin_prdt_nm, join_way, mtrt_int) {
  var params = {
      "kor_co_nm" : kor_co_nm,
      "fin_prdt_nm" : fin_prdt_nm,
      "join_way" : join_way,
      "mtrt_int" : mtrt_int
   };
  
  $.ajax(
      {
        url: '/idata/create.do',
        type: 'post',  // get, post
        cache: false, // 응답 결과 임시 저장 취소
        async: true,  // true: 비동기 통신
        dataType: 'json', // 응답 형식: json, html, xml...
        data: params,      // 데이터
        success: function(rdata) {
          console.log(rdata.cnt);

          if(rdata.cnt == 0) {
            $('#panel1').html('이미 데이터가 저장되어 있습니다.');
          } else {
          $('#panel1').html('데이터 저장이 완료되었습니다.');
          }
        },
        // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
        error: function(request, status, error) { // callback 함수
          console.log(error);
        }
      }
    );  //  $.ajax END

  $('#panel1').show();

}

function site_data () {
  var params =""; 

  var kor_co_nm = [];
  var homp_url = [];
  var cal_tel = [];
  var area_cd =[];
  var area_nm=[];
  
  $.ajax({
   url: '/fss/site_data.do', // form action
   type: 'get',  // form method, get
   cache: false, // 응답 결과 임시 저장 취소
   async: true,  // true: 비동기 통신
   dataType: 'json', // 응답 형식: json, html, xml...
   data: params,      // 데이터
   success: function(rdata) { // 응답이 온 경우
          
      for (var i=0; i < rdata.result.baseList.length; i++ ) {
        kor_co_nm.push(rdata.result.baseList[i].kor_co_nm);
        homp_url.push(rdata.result.baseList[i].homp_url);
        cal_tel.push(rdata.result.baseList[i].cal_tel);
        area_cd.push(rdata.result.optionList[i].area_cd);
        area_nm.push(rdata.result.optionList[i].area_nm);
      }
         site_data_save(kor_co_nm, homp_url, cal_tel, area_cd, area_nm);    
   },
   // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
   error: function(request, status, error) { // callback 함수
     console.log(error);
   }
  });
}

function site_data_save(kor_co_nm, homp_url, cal_tel, area_cd, area_nm) {
  var params = {
      "kor_co_nm" : kor_co_nm,
      "homp_url" : homp_url,
      "cal_tel" : cal_tel,
      "area_cd" : area_cd,
      "area_nm" : area_nm
   };

  // console.log(params);
  // return;
  
  $.ajax(
      {
        url: '/connsite/create.do',
        type: 'post',  // get, post
        cache: false, // 응답 결과 임시 저장 취소
        async: true,  // true: 비동기 통신
        dataType: 'json', // 응답 형식: json, html, xml...
        data: params,      // 데이터
        success: function(rdata) {
          // console.log("hi");
          console.log(rdata.cnt);
          
          if(rdata.cnt == 0) {
            $('#panel1').html('이미 데이터가 저장되어 있습니다.');
          } else {
          $('#panel1').html('데이터 저장이 완료되었습니다.');
          }
        },
        // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
        error: function(request, status, error) { // callback 함수
          console.log(error);
        }
      }
    );  //  $.ajax END

  $('#panel1').show();

}

function deposit_data () {
  var params =""; 

  var kor_co_nm = [];
  var fin_prdt_nm = [];
  var join_way = [];
  var mtrt_int = [];
  
  $.ajax({
   url: '/fss/read_deposit.do', // form action
   type: 'get',  // form method, get
   cache: false, // 응답 결과 임시 저장 취소
   async: true,  // true: 비동기 통신
   dataType: 'json', // 응답 형식: json, html, xml...
   data: params,      // 데이터
   success: function(rdata) { // 응답이 온 경우
     
      for (var i=0; i < rdata.result.baseList.length; i++ ) {
        kor_co_nm.push(rdata.result.baseList[i].kor_co_nm);
        fin_prdt_nm.push(rdata.result.baseList[i].fin_prdt_nm);
        join_way.push(rdata.result.baseList[i].join_way);
        mtrt_int.push(rdata.result.baseList[i].mtrt_int);
      }
         deposit_exam(kor_co_nm, fin_prdt_nm, join_way, mtrt_int);    
   },
   // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
   error: function(request, status, error) { // callback 함수
     console.log(error);
   }
  });
}

function deposit_exam(kor_co_nm, fin_prdt_nm, join_way, mtrt_int) {
  var params = {
      "kor_co_nm" : kor_co_nm,
      "fin_prdt_nm" : fin_prdt_nm,
      "join_way" : join_way,
      "mtrt_int" : mtrt_int
   };
  
  $.ajax(
      {
        url: '/data/create.do',
        type: 'post',  // get, post
        cache: false, // 응답 결과 임시 저장 취소
        async: true,  // true: 비동기 통신
        dataType: 'json', // 응답 형식: json, html, xml...
        data: params,      // 데이터
        success: function(rdata) {
          console.log(rdata.cnt);

          if(rdata.cnt == 0) {
            $('#panel1').html('이미 데이터가 저장되어 있습니다.');
          } else {
          $('#panel1').html('데이터 저장이 완료되었습니다.');
          }
        },
        // Ajax 통신 에러, 응답 코드가 200이 아닌경우, dataType이 다른경우 
        error: function(request, status, error) { // callback 함수
          console.log(error);
        }
      }
    );  //  $.ajax END

  $('#panel1').show();

}

function btn_deposit_data_over() {
  document.getElementById("btn_deposit_data").src="http://localhost:9090/css/images/deposit_api_over.png"
}

function btn_deposit_data_out() {
  document.getElementById("btn_deposit_data").src="http://localhost:9090/css/images/deposit_api.png"
}

function btn_imoney_data_over() {
  document.getElementById("btn_imoney_data").src="http://localhost:9090/css/images/imoney_api_over.png"
}

function btn_imoney_data_out() {
  document.getElementById("btn_imoney_data").src="http://localhost:9090/css/images/imoney_api.png"
}

function btn_site_data_over() {
  document.getElementById("btn_site_data").src="http://localhost:9090/css/images/bank_api_over.png"
}

function btn_site_data_out() {
  document.getElementById("btn_site_data").src="http://localhost:9090/css/images/bank_api.png"
}

</script>
</head>
<body>
<jsp:include page="../menu/top.jsp" flush='false' />

<DIV class='title_line'>데이터 수집</DIV>
<DIV class='content_body'>
  <DIV id='panel1' style='display: none; margin: 10px auto; text-align: center; width: 80%;'></DIV>
  <DIV class='data_save'>
    <img class="data_img" id="btn_deposit_data" onmouseover="btn_deposit_data_over()" onmouseout="btn_deposit_data_out()" src="/css/images/deposit_api.png">
    <img class="data_img" id="btn_imoney_data" onmouseover="btn_imoney_data_over()" onmouseout="btn_imoney_data_out()" alt="" src="/css/images/imoney_api.png">
    <img class="data_img" id="btn_site_data" onmouseover="btn_site_data_over()" onmouseout="btn_site_data_out()" alt="" src="/css/images/bank_api.png">
  </DIV>
</DIV>
 
 <jsp:include page="../menu/bottom.jsp" flush='false' />
</body>
</html>