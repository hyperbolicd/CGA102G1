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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front_end/wish/css/wishPage.css">
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
 	
	<!-- 許願池 -->
	<div id="main">
		<h1>許願池投票活動</h1>
		<span style="color: red;">${errMsg.isSuccess}</span>
<!-- 		取消 -->
<%--         <button id="historyWish"><a href="${pageContext.request.contextPath}/front_end/wish/wishHis.jsp">歷屆回顧</a></button> --%>
        <div id="wishList">
            <table>
                <tr>
                    <th>編號</th>
                    <th>名稱</th>
                    <th>起始時間</th>
                    <th>結束時間</th>
                    <th>查看詳情</th>
                    <th>參加投票</th>
                </tr>
                <jsp:useBean id="wishSvc" class="com.wishing_pond.model.WishingPondService"/>
                <c:forEach var="event" items="${wishSvc.avaliable}">
	                 <tr>
	                     <td>${event.wish_no}</td>
	                     <td>${event.wish_name}</td>
	                     <td>${event.wish_start}</td>
	                     <td>${event.wish_end}</td>
	                     <td>
	                     	<form action="${pageContext.request.contextPath}/wish/WishingVote.do" method="post">
		                      	<button type="submit" name="action" value="seeOneEvent"><img src="${pageContext.request.contextPath}/back_end/wish/icons8-detail-64.png" alt=""></button>
		                      	<input type="hidden" name="wish_no" value="${event.wish_no}">
		                      	<input type="hidden" name="wish_name" value="${event.wish_name}">
		                      	<input type="hidden" name="wish_start" value="${event.wish_start}">
		                      	<input type="hidden" name="wish_end" value="${event.wish_end}">
	                     	</form>
	                     </td>
	                     <td>
	                     	<form action="${pageContext.request.contextPath}/wish/WishingVote.do" method="post">
		                      	<button type="submit" name="action" value="voteOneEvent"><img src="${pageContext.request.contextPath}/front_end/wish/icons8-vote-64.png" alt=""></button>
		                      	<input type="hidden" name="member_id" value="${memberVO.member_ID}">
		                      	<input type="hidden" name="wish_no" value="${event.wish_no}">
	                     	</form>
	                     </td>
	                 </tr>
				</c:forEach>
            </table>
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

</body>
</html>