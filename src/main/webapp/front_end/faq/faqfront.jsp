<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.faq.model.*"%>


<%
FaqService faqSvc = new FaqService();
// 	List<FaqVO> FaqClass1List = faqSvc.getFaqClass1();
// 	List<FaqVO> FaqClass2List = faqSvc.getFaqClass2();
// 	List<FaqVO> FaqClass3List = faqSvc.getFaqClass3();
// 	List<FaqVO> FaqClass4List = faqSvc.getFaqClass4();
// 	pageContext.setAttribute("FaqClass1", FaqClass1);
// 	pageContext.setAttribute("FaqClass2", FaqClass2);
// 	pageContext.setAttribute("FaqClass3", FaqClass3);
// 	pageContext.setAttribute("FaqClass4", FaqClass4);
%>


<!-- <!DOCTYPE html> -->
<html lang="en" dir="ltr">

<head>
<title>HireMe</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/front_end/css/layout.css"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/front_end/faq/css/faq_front.css">
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/front_end/faq/js/faq_front.js">

<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>



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
	<header>

		<%@ include file="/front_end/header.jsp"%>
		<%@ include file="/front_end/header_css.jsp"%>

	</header>

	<div style="padding: 100px 100px;">


		<!--各自的內容--------------------->
		<!-- Page Content-->
		<div>

				<div class="text-center mb-5">
					<h1 class="fw-bolder">常見問題</h1>
					<p class="lead fw-normal text-muted mb-0">F A Q</p>
				</div>
				
				<div class="row gx-5">
					<div class="col-xl-8">
						<!-- FAQ Accordion 1-->
						<h2 class="fw-bolder mb-3">會員相關問題</h2>
						<div class="accordion mb-5" id="accordionExample">
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingOne">
									<button class="accordion-button" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne">如何加入HireMe會員？</button>
								</h3>
								<div class="accordion-collapse collapse show" id="collapseOne"
									aria-labelledby="headingOne" data-bs-parent="#accordionExample">
									<div class="accordion-body">
										<strong>會員資格申請：請至嗨邇覓影城官網，點選會員註冊進行申請，啟用帳號成功後，即可使用網路訂票與線上累兌點功能。</code>
									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingTwo">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">Accordion
										Item #2</button>
								</h3>
								<div class="accordion-collapse collapse" id="collapseTwo"
									aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
									<div class="accordion-body">
										<strong>This is the second item's accordion body.</strong> It
										is hidden by default, until the collapse plugin adds the
										appropriate classes that we use to style each element. These
										classes control the overall appearance, as well as the showing
										and hiding via CSS transitions. You can modify any of this
										with custom CSS or overriding our default variables. It's also
										worth noting that just about any HTML can go within the
										<code>.accordion-body</code>
										, though the transition does limit overflow.
									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingThree">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">Accordion
										Item #3</button>
								</h3>
								<div class="accordion-collapse collapse" id="collapseThree"
									aria-labelledby="headingThree"
									data-bs-parent="#accordionExample">
									<div class="accordion-body">
										<strong>This is the third item's accordion body.</strong> It
										is hidden by default, until the collapse plugin adds the
										appropriate classes that we use to style each element. These
										classes control the overall appearance, as well as the showing
										and hiding via CSS transitions. You can modify any of this
										with custom CSS or overriding our default variables. It's also
										worth noting that just about any HTML can go within the
										<code>.accordion-body</code>
										, though the transition does limit overflow.
									</div>
								</div>
							</div>
						</div>
						<!-- FAQ Accordion 2-->
						<h2 class="fw-bolder mb-3">Website Issues</h2>
						<div class="accordion mb-5 mb-xl-0" id="accordionExample2">
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingOne">
									<button class="accordion-button" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne">Accordion
										Item #1</button>
								</h3>
								<div class="accordion-collapse collapse show" id="collapseOne"
									aria-labelledby="headingOne"
									data-bs-parent="#accordionExample2">
									<div class="accordion-body">
										<strong>This is the first item's accordion body.</strong> It
										is shown by default, until the collapse plugin adds the
										appropriate classes that we use to style each element. These
										classes control the overall appearance, as well as the showing
										and hiding via CSS transitions. You can modify any of this
										with custom CSS or overriding our default variables. It's also
										worth noting that just about any HTML can go within the
										<code>.accordion-body</code>
										, though the transition does limit overflow.
									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingTwo">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">Accordion
										Item #2</button>
								</h3>
								<div class="accordion-collapse collapse" id="collapseTwo"
									aria-labelledby="headingTwo"
									data-bs-parent="#accordionExample2">
									<div class="accordion-body">
										<strong>This is the second item's accordion body.</strong> It
										is hidden by default, until the collapse plugin adds the
										appropriate classes that we use to style each element. These
										classes control the overall appearance, as well as the showing
										and hiding via CSS transitions. You can modify any of this
										with custom CSS or overriding our default variables. It's also
										worth noting that just about any HTML can go within the
										<code>.accordion-body</code>
										, though the transition does limit overflow.
									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h3 class="accordion-header" id="headingThree">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">Accordion
										Item #3</button>
								</h3>
								<div class="accordion-collapse collapse" id="collapseThree"
									aria-labelledby="headingThree"
									data-bs-parent="#accordionExample2">
									<div class="accordion-body">
										<strong>This is the third item's accordion body.</strong> It
										is hidden by default, until the collapse plugin adds the
										appropriate classes that we use to style each element. These
										classes control the overall appearance, as well as the showing
										and hiding via CSS transitions. You can modify any of this
										with custom CSS or overriding our default variables. It's also
										worth noting that just about any HTML can go within the
										<code>.accordion-body</code>
										, though the transition does limit overflow.
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>







		</div>
		<!--   <!--客服圖 請自行加連結-->

		<!--   <img class="cs" src="images/demo/cs.png" height="50px;" width="60px;" href="#"></img> -->

		<!-- Copyright -->
		<div class="wrapper row2">
			<footer id="copyright" class="clear">
				<p class="fl_left">
					Copyright &copy; 2022 - All Rights Reserved <a href="#"></a>
				</p>
			</footer>

			<!-- Bootstrap core JS-->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
			<!-- Core theme JS-->
			<script src="/front_end/faq/js/scripts.js"></script>


		</div>
</body>

</html>