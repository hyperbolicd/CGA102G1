<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front_end/css/layout.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/front_end/merchandise/css/cart.css"
	type="text/css">
</head>

<body>
	<button type="button" id="BackTop" class="toTop-arrow"></button>
	<!--   <script>
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
</script> -->
	<div class="wrapper row1" style="height: 60px;">
		<jsp:include page="/front_end/header.jsp" />
	</div>
	<form action="${pageContext.request.contextPath}/ShoppingCartServlet"
		id="forPay">
		<input type="hidden" name="action" value="insertfromcart">
		<input type="hidden" name="totalCount" value="" id="totalCount">
		</form>
	<div id="cartMain">
		<hr class="line" />
		<div id="cartTitle">
			<div id="titleCheck" class="check">
				<input type="checkbox" name="" id="checkAll">全選
			</div>
			<div id="titlePic" class="pic">商品圖片</div>
			<div id="titleName" class="name">商品名稱</div>
			<div id="titleInfo" class="info">商品描述</div>
			<div id="titlePrice" class="price">價格</div>
			<div id="titleCount" class="count">數量</div>
			<div id="titleEdit" class="edit">刪除</div>
		</div>
		<hr class="line" />
		<div id="cartBody">
		<c:forEach var="scDetailVo" items="${shoppingcart}" varStatus="statusName">
			<div class="eachItem">
				<div class="check">
					<input type="checkbox" name="pay" class="checkOne" value="${statusName.index}" form="forPay">
				</div>
				<div class="vl"></div>
				<div class="pic">
					<img src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${scDetailVo.merchVO.merchID}&pic=1" alt="">
				</div>
				<div class="vl"></div>
				<div class="name">${scDetailVo.merchVO.merchName}</div>
				<div class="vl"></div>
				<div class="info">${scDetailVo.merchVO.merchDT}</div>
				<div class="vl"></div>
				<div class="price inputprice">${scDetailVo.merchVO.merchPrice}</div>
				<div class="vl"></div>
				<div class="count">
					<input class="inputcount" type="number" min="1" max="100" value="${scDetailVo.scCount}" name="count" form="forPay">
				</div>
				<div class="vl"></div>
				<div class="edit">
				<form action="${pageContext.request.contextPath}/ShoppingCartServlet">
					<input type="hidden" name="del" value="${statusName.index}">
					<button name="action" value="delete" type="submit">刪除</button>
				</form>
				</div>
			</div>
			</c:forEach>
			
		</div>

		<hr class="line" style="margin-top: 20px;" />
		<div id="cartArea">
			<div id="total">總金額:${amount}</div>
			<div id="cartBtn">
				<button class="button" type="submit" form="forPay">
					<span>結帳唷</span>
				</button>
			</div>
		</div>
	</div>

	<div class="wrapper row2">
		<footer id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2022 - All Rights Reserved <a href="#"></a>
			</p>
		</footer>
	</div>
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front_end/merchandise/javascript/cart.js"></script>
	
</body>

</html>