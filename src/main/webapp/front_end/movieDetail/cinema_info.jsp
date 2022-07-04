<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cnm_inf.model.*"%>

<%
Cnm_infService cnmSvc = new Cnm_infService();
Cnm_infVO cnmVO = cnmSvc.getOneCnm_inf(1);
%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<title>影城資訊</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="./css/cinema_info.css">
</head>

<body>
	<!-- 置頂按鈕 -->
	<button type="button" id="BackTop" class="toTop-arrow"></button>
	<script>
		$(function() {
			$('#BackTop').click(function() {
				$('html,body').animate({
					scrollTop : 0
				}, 333);
			});
			$(window).scroll(function() {
				if ($(this).scrollTop() > 300) {
					$('#BackTop').fadeIn(222);
				} else {
					$('#BackTop').stop().fadeOut(222);
				}
			}).scroll();
		});
	</script>

	<div class="wrapper row1" style="height: 60px;">
		<header id="header" class="clear">
			<div id="hgroup">
				<img src="images/demo/logo6.png" width="200" height="60" alt="">
			</div>

			<div class="dropdown"
				style="margin: 0; padding: 0; list-style: none;">

				<button class="dropbtn">會員專區</button>
				<div class="dropdown-content">
					<a href="#">會員登入</a> <a href="#">會員註冊</a> <a href="#">查看票夾</a> <a
						href="#">查看評論</a> <a href="#">許願池</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">最新消息</button>
				<div class="dropdown-content">
					<a href="#">影城公告</a> <a href="#">影城好康</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">電影資訊</button>
				<!-- <a href="#"></a>
        <a href="#"></a> 下拉選單-->
			</div>

			<div class="dropdown">
				<button class="dropbtn">影城專區</button>
				<div class="dropdown-content">
					<a href="#">影城介紹</a> <a href="#">影城地點</a> <a href="#">票價資訊</a> <a
						href="#">餐飲資訊</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">商城</button>
				<!-- <a href="#"></a>
        <a href="#"></a> 下拉選單-->
			</div>

			<div class="dropdown">
				<button class="dropbtn">Q & A專區</button>
				<div class="dropdown-content">
					<a href="#">常見問題</a> <a href="#">聯絡我們</a>
				</div>
			</div>

		</header>
	</div>

	<div
		style='padding: 50px 100px; color: #979797; background-color: black;'>
		<div id="info_title" class="title">
			<span>Infomation</span>
		</div>
		<div id="cmn_dt" class="detail">
			<span>📽</span> <span>${cnmVO.CNM_DT}</span>
		</div>
		<div id="lc_title" class="title">
			<span>Location</span>
		</div>
		<div id="cmn_lc" class="detail">
			<span>🗺</span> <span>${cnmVO.CNM_LC}</span>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1956179.0189827878!2d0.17714008665609016!3d-0.029105184759486192!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xbc6dbea4e5fc3562!2zMMKwMDAnMDAuMCJOIDDCsDAwJzAwLjAiRQ!5e0!3m2!1szh-TW!2stw!4v1655086125338!5m2!1szh-TW!2stw"
				width="400" height="300" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
		<div id="tpr_title" class="title">
			<span>How to go to CINAMA</span>
		</div>
		<div id="cmn_tpr" class="detail">
			<span>🚎</span> <span>${cnmVO.CNM_TRP}</span>
		</div>
		<div id="em_title" class="title">
			<span>Email</span>
		</div>
		<div id="cmn_em" class="detail">
			<span>✉</span> <span>${cnmVO.CNM_EM}</span>
		</div>
		<div id="tel_title" class="title">
			<span>Tel</span>
		</div>
		<div id="cmn_tel" class="detail">
			<span>☎</span> <span>${cnmVO.CNM_TEL}</span>
		</div>



	</div>

	<!-- Copyright -->
	<div class="wrapper row4">
		<footer id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2022 - All Rights Reserved <a href="#"></a>
			</p>
			<p class="fl_right">
				Template by <a target="_blank" href="https://www.os-templates.com/"
					title="Free Website Templates"></a>
			</p>
		</footer>
	</div>
</body>

</html>