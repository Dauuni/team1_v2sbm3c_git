<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>KM Bank</title>
<!-- /static 기준 -->
<link href="/css/style.css" rel="Stylesheet" type="text/css">
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    
</head>

<script type="text/javascript">
var imgArray=new Array(); 
  imgArray[0]="/images/main_img1.png"; 
  imgArray[1]="/images/main_img2.png"; 
  imgArray[2]="/images/main_img3.png"; 
  imgArray[3]="/images/main_img4.png"; 

function showImage(){ 
  var imgNum=Math.round(Math.random()*3); 
  var objImg=document.getElementById("introimg"); 
  objImg.src=imgArray[imgNum]; 
  setTimeout(showImage,3000); 
}

function link() {
  var img = document.getElementById("introimg").src;
  
  if(img == "http://localhost:9090/images/main_img1.png") {
    location.href="./deposit/deposit_list_search_paging.do";
  } else if (img == "http://localhost:9090/images/main_img2.png") {
    location.href="./imoney/imoney_list_search_paging.do";
  } else if (img == "http://localhost:9090/images/main_img3.png") {
    location.href="./notice/notice_list_search_paging.do";
  } else if (img == "http://localhost:9090/images/main_img4.png") {
    location.href="http://ncov.mohw.go.kr/";
  }
}

</script>

<body onload="showImage()">
<jsp:include page="./menu/top.jsp" flush='false' />
<DIV style="margin: auto;">
    <img class="introimg" id="introimg" onclick="link()" >
</DIV>
 
<jsp:include page="./menu/bottom.jsp" flush='false' />
 
</body>
</html>


