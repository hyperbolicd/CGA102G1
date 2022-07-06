<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>許願投票活動</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/css/layout.css" type="text/css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://fontawesome.com/v5/icons/edit?s=solid">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/membercentre/css/membercentre.css" />
	<!-- 許願池 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front_end/wish/css/wishDetail.css">
</head>
<body>
	<div class="wrapper row1" style="height: 60px;">
		<header id="header" class="clear">
			<div id="hgroup">
				<img src="${pageContext.request.contextPath}/front_end/images/demo/logo6.png" width="200" height="60" alt="">
			</div>
			<div class="dropdown" style="margin: 0; padding: 0; list-style: none;">
				<button class="dropbtn">會員專區</button>
				<div class="dropdown-content">
					<a href="#">會員登入</a> <a href="#">會員中心</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">活動公告</button>
				<div class="dropdown-content">
					<a href="#">影城公告</a> <a href="#">影城好康</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Q & A專區</button>
				<div class="dropdown-content">
					<a href="#">常見問題</a> <a href="#">客服信箱</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">影城專區</button>
				<div class="dropdown-content">
					<a href="#">影城介紹</a> <a href="#">影城地點</a> <a href="#">票價資訊</a> <a
						href="#">餐飲資訊</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">電影資訊</button>
				<div class="dropdown-content"></div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">商城購物</button>
				<div class="dropdown-content">
					<a href="#">商品瀏覽</a> <a href="#">購買退貨</a>
				</div>
			</div>
			<button class="logout">會員登出</button>
		</header>
	</div>

	<div id="mainDiv">
		<div class="side-menu">
			<nav>
				<a href="#"><i class="fa fa-edit" aria-hidden="true"></i>會員修改資料</a> 
				<a href="#"><i class="fa fa-gavel" aria-hidden="true"></i>票卷匣</a> 
				<a href="#"><i class="fa fa-object-group" aria-hidden="true"></i>許願池</a> 
				<a href="#"><i class="fa fa-clone" aria-hidden="true"></i>評論區</a>
			</nav>
		</div>
		<!-- <div id="content">
    <iframe src="" width="100%" height="100%" frameborder="0"></iframe>
  </div> -->
 	<% 
 		int i = 0;
 		java.util.List<Integer> tkCounts = (java.util.List<Integer>) request.getAttribute("tkCounts");
 	%>
	<!-- 許願池 -->
	<div id="main">
		<h1>許願池 - ${wish_name}</h1>
		<button id="return"><a href="${pageContext.request.contextPath}/front_end/wish/wishPage.jsp">返回</a></button>
		<h2>投票期間: ${wish_start} ~ ${wish_end}</h2>
		<h2>投票實況</h2>
		<div id="vote">
		 	<c:forEach var="eventOps" items="${eventMap}">
				<div>
		   			<h3>選項: ${eventOps.value}</h3>
						<div class="color" style='height: 20px; width: <%=tkCounts.get(i)*10%>px; background-color: rgb(160, 188, 194);'>
							<h5>票數: <%=tkCounts.get(i++)%></h5>
		    			</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${restTicket != null}">
			<div id="divPlate" onclick="windowClose()" style="display: block;"></div>
			<div id="dbConfirm" style="display: block;">
				<h3>投票成功! 剩餘票數為${restTicket}</h3>
				<div>
	        		<button class="enter" type="button" onclick="windowClose()">確認</button>
	    		</div>
			</div>
		</c:if>
	</div>
	<!-- 許願池 -->
	</div>
	
	<!-- Copyright -->
	<div class="wrapper row2">
		<footer id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2022 - All Rights Reserved <a href="#"></a>
			</p>
		</footer>
	</div>
	<script src="${pageContext.request.contextPath}/front_end/wish/js/voteWish.js"></script>
</body>
</html>