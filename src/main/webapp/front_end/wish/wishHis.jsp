<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>許願池歷史回顧</h1> 
        <button id="historyWish"><a href="${pageContext.request.contextPath}/front_end/wish/wishPage.jsp">返回投票</a></button>
        <div id="multiSearch">
            <form action="${pageContext.request.contextPath}/wish/WishingPond.do" method="post">
                <label for="searchPeriod">時間: </label>
                <select name="searchPeriod" id="searchPeriod">
                    <option value="WISH_START">以起始時間搜尋</option>
                    <option value="WISH_END">以結束時間搜尋</option>
                    <option value="3">以包含時間搜尋</option> <!-- 再想想 -->
                </select>
                <input name="start_date" id="start_date" autocomplete="off"> ~ <input name="end_date" id="end_date" autocomplete="off">
                <label for="searchName">名稱: </label>
                <input name="searchName" id="searchName">
                <button type="submit" name="action" value="multiSearch">搜尋</button>
                <button type="submit" name="action" value="showAll">顯示全部</button>
            </form>
        </div>
        <div id="wishList">
            <table>
                <tr>
                    <th>編號</th>
                    <th>名稱</th>
                    <th>起始時間</th>
                    <th>結束時間</th>
                    <th>冠軍</th>
                    <th>查看詳情</th>
                </tr>
                <c:forEach var="event" items="${list}">
	                 <tr>
	                     <td>${event.wish_no}</td>
	                     <td>${event.wish_name}</td>
	                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${event.wish_start}" /></td>
	                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${event.wish_end}" /></td>
	                     <td>${event.mvVO.mvName == null ? "結果尚未出爐" : event.mvVO.mvName}</td>
	                     <td>
	                     	<form action="${pageContext.request.contextPath}/wish/WishingPond.do" method="post">
	                      	<button type="submit" name="action" value="seeOneEvent"><img src="${pageContext.request.contextPath}/back_end/wish/icons8-detail-64.png" alt=""></button>
	                      	<input type="hidden" name="wish_no" value="${event.wish_no}">
	                      	<input type="hidden" name="top_one" value="${event.top_one}">
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