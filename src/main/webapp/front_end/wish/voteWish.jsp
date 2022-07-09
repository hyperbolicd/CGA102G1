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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front_end/wish/css/voteWish.css">
</head>
<<<<<<< HEAD
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

=======
<body onload="connect();" onunload="disconnect();">
	<%@ include file="/front_end/header.jsp"%>
	
>>>>>>> Liu
	<div id="mainDiv">
		<div class="side-menu">
			<nav>
				<a
					href="${pageContext.request.contextPath}/front_end/membercentre/membermod.jsp">
					<i class="fa fa-edit" aria-hidden="true"></i> 會員修改資料
				</a> <a href="${pageContext.request.contextPath}/front_end/wish/wishPage.jsp"> <i class="fa fa-object-group" aria-hidden="true"></i>
					許願池
				</a> <a href="${pageContext.request.contextPath}/front_end/memberCmt/memberCmt.jsp"> <i class="fa fa-clone" aria-hidden="true"></i> 評論區
				</a>
				 <a href="#"> <i class="fa fa-gavel" aria-hidden="true"></i> 訂單明細</a>
			</nav>
		</div>
		<!-- <div id="content">
    <iframe src="" width="100%" height="100%" frameborder="0"></iframe>
  </div> -->
 	
	<!-- 許願池 -->
	<div id="main">
		<h1>${wishListVOs[0].wishVO.wish_name}</h1>
        <form action="${pageContext.request.contextPath}/wish/WishingPond.do" method="post">
            <button type="button" id="return"><a href="${pageContext.request.contextPath}/front_end/wish/wishPage.jsp">返回</a></button>
        	<span style="color: red;">${errMsg.isSuccess}</span>
            <h2>活動資訊</h2>
            <div id="event">
            	<h4>票選期間: ${wishListVOs[0].wishVO.wish_start} ~ ${wishListVOs[0].wishVO.wish_end}</h4>
            	<h4>票選目的: 最高票之電影將於近期再上映。</h4>
            	<h4>票選資格: 擁有許願票之會員們。<a href="#">詳情</a></h4>
        		<h4>您的剩餘許願票數: <span style="color: rgb(202, 37, 37);">${wish_ticket}</span> 張</h4>
            </div>
            <h2>電影列表</h2>
            <div id="movies">
            	<c:forEach var="wishListVO" items="${wishListVOs}">
	                 <div class="movie" title="${wishListVO.mvVO.mvName}" >
	                     <input type="checkbox" name="checkMovie" id="movie${wishListVO.mvVO.mvId}" value="${wishListVO.mvVO.mvId}" onclick="colorChange(this)">
	                     <label for="movie${wishListVO.mvVO.mvId}">
	                         <div class="inner">
	                             <h3>${wishListVO.mvVO.mvName}</h3>
	                             <img src="${pageContext.request.contextPath}${wishListVO.mvVO.mvPicture}" alt="">
	                             <div>
		                             類型: ${wishListVO.mvVO.mvType}
		                             <br> 分級: <c:if test="${wishListVO.mvVO.mvLevel == 0}">普遍級</c:if> 
					                      	   <c:if test="${wishListVO.mvVO.mvLevel == 1}">保護級</c:if> 
					                      	   <c:if test="${wishListVO.mvVO.mvLevel == 2}">輔導級</c:if> 
					                      	   <c:if test="${wishListVO.mvVO.mvLevel == 3}">輔導級</c:if> 
					                      	   <c:if test="${wishListVO.mvVO.mvLevel == 4}">限制級</c:if> 
	                             </div>
				             	 <button id="voteBtn" type="button"><img class="clickImg" onclick="windowOpen(this)" src="${pageContext.request.contextPath}/front_end/wish/icons8-vote-badge-64.png"></button>
	                         </div>
	                     </label>
	                 </div> 
                </c:forEach>
            </div>
        </form>
        
        <div id="divPlate" onclick="windowClose()" style="display: none;"></div>
		<div id="dbConfirm" style="display: none;">
			<h3>您已勾選"<span id="voteMvName"></span>"，送出後即無法修改，您確定要送出嗎？</h3>
			<form action="${pageContext.request.contextPath}/wish/WishingVote.do" method="post">
				<input type="hidden" name="wish_no" value="${wishListVOs[0].wishVO.wish_no}" >
				<input type="hidden" name="wish_name" value="${wishListVOs[0].wishVO.wish_name}" >
				<input type="hidden" name="wish_start" value="${wishListVOs[0].wishVO.wish_start}" >
				<input type="hidden" name="wish_end" value="${wishListVOs[0].wishVO.wish_end}" >
				<input type="hidden" name="member_id" value="${memberVO.member_ID}">
				<input type="hidden" name="mv_id" id="voteMvId">
				<br>
				<label for="wish_msg">還有什麼想說的:</label>
				<input id="wish_msg" name="wish_msg">
				<div>
	        		<button class="cancel" type="button" onclick="windowClose()">取消</button>
	        		<button class="enter" type="submit" name="action" value="voteMovie">確認</button>
	    		</div>
	 		</form>	
		</div>
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