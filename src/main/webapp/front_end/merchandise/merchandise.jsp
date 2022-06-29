<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>HireMe</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/css/layout.css" type="text/css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/merchandise/css/merchandise.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>


<body>
  <!-- 置頂按鈕 -->
  <button type="button" id="BackTop" class="toTop-arrow"></button>
  <script>
    $(function () {
      $('#BackTop').click(function () {
        $('html,body').animate({ scrollTop: 0 }, 333);
      });
      $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
          $('#BackTop').fadeIn(222);
        } else {
          $('#BackTop').stop().fadeOut(222);
        }
      }).scroll();
    });
  </script>
  <div class="wrapper row1" style="height:60px;">
 <jsp:include page="/front_end/header.jsp" />
</div>
<main>
    <div id="product-aside" style="border: 1px solid red ;">
      <img class="product-img <c:if test="${merchVo.merchPic1==null}">nullimg</c:if>" src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
      <img class="product-img <c:if test="${merchVo.merchPic2==null}">nullimg</c:if>" src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=2">
      <img class="product-img <c:if test="${merchVo.merchPic3==null}">nullimg</c:if>" src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=3">
      <img class="product-img <c:if test="${merchVo.merchPic4==null}">nullimg</c:if>" src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=4">
      <img class="product-img <c:if test="${merchVo.merchPic5==null}">nullimg</c:if>"src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=5">
    </div>



    <img id="photo" src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1" style="border: 1px solid red ;">

  </main>
  <div class="product-title-all">
    <h1>${merchVo.merchName}</h1>
    <div class="product-content">
      <h2>商品詳情</h2>
      ${merchVo.merchDT}
    </div>
    <h1 class="hr1"></h1>
    <span id="number-text">數量:</span>
    <form method="get">
      <div class="select-area">
        <span class="down" onclick='decreaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/front_end/merchandise/images/LeftArrow.png"></span>
        <input id="input-amount" type="number" value="1" name="ordCount">
        <span class="up" onclick='increaseCount(event, this)'><img class="arrow-pic" src="${pageContext.request.contextPath}/front_end/merchandise/images/RightArrow.png"></span>
      </div>
    <span id="number-text">價格:</span>
    <div class="select-area1">      
        <input id="totalCount" type="number" value="${merchVo.merchPrice}" name="totalCount" readonly>
        元整
      </div>
      <div class="purchase-area">
        <input class="purchase-btn" type="button" value="前往購買">
        <input class="addcar-btn" type="button" value="加入購物車">
      </div>
    </form>



  </div>
<!--   <!--客服圖 請自行加連結--> -->
<!--   <img class="cs" src="images/demo/cs.png" height="50px;" width="60px;" href="#"></img> -->

  <!-- Copyright -->
  <div class="wrapper row2">
    <footer id="copyright" class="clear">
      <p class="fl_left">Copyright &copy; 2022 - All Rights Reserved <a href="#"></a></p>
    </footer>
  </div>
<script>
let productimgs = document.getElementsByClassName('product-img');
let nullimgs = document.getElementsByClassName('nullimg');
for(productimg of productimgs){
  productimg.addEventListener('click',changes);
}
for(nullimg of nullimgs){
	nullimg.setAttribute('style','display:none;')
}
let totalCount = document.getElementById('totalCount');


// 圖片
function changes(e) {
  document.getElementById("photo").src = e.target.src;
}
let updateFiles = document.getElementsByClassName('updatefile');
let updateImgs = document.getElementsByClassName('updateimg');
for(let i = 0; i < updateFiles.length; i++){
  updateFiles[i].addEventListener('change', function(e){
    updateImgs[i].src = URL.createObjectURL(e.target.files[0]);
    updateFiles[i].textContent
  })
}

// 產品數量選擇器
function increaseCount(a, b) {
  var input = b.previousElementSibling;
  var value = parseInt(input.value, 10); 
  value = isNaN(value)? 0 : value;
  value ++;
  input.value = value;
  totalCount.value = ${merchVo.merchPrice} * value;
  console.log(input.value);
}
function decreaseCount(a, b) {
  var input = b.nextElementSibling;
  var value = parseInt(input.value, 10); 
  if (value > 1) {
    value = isNaN(value)? 0 : value;
    value --;
    input.value = value;
    totalCount.value = ${merchVo.merchPrice} * value;
    console.log(input.value);
  }
}
</script>
</body>

</html>