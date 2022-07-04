<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.showing.model.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.cmt.model.*"%>
<%@ page import="com.showing.model.*"%>
<%@ page import="java.util.*"%>

<%
//MovieServlet.java(Controller), 存入req的MovieVO物件
MovieVO movieVO = (MovieVO) request.getAttribute("movieVO");
//取得評論的VO
CmtService cmtSvc = new CmtService();
List<CmtVO> list = cmtSvc.getCmtsByMV_ID(movieVO.getMvId());
pageContext.setAttribute("list", list);
for (CmtVO lis : list) {
	System.out.println(lis.getCM_ID());
}
//取得場次的VO
ShowingService showingSvc = new ShowingService();
// List<ShowingVO> showingList = showingSvc.getShowingByDate();

//平均星數
int avgStar = (movieVO.getMvTtStar() / movieVO.getMvTtCm());
pageContext.setAttribute("avgStar", avgStar);
%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<title>${movieVO.mvName}</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front_end/movieDetail/styles/layout.css"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link
	href="<%=request.getContextPath()%>/front_end/movieDetail/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<script
	src="<%=request.getContextPath()%>/front_end/movieDetail/js/bootstrap.js"></script>
<script
	src="<%=request.getContextPath()%>/front_end/movieDetail/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front_end/movieDetail/css/movie_detail.css">

<!-- icon -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
				<img
					src="<%=request.getContextPath()%>/front_end/movieDetail/images/demo/logo6.png"
					width="200" height="60" alt="">
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

	<!-- 內容 -->
	<jsp:useBean id="movieSvc" scope="page" class="com.movie.model.MovieService" />

	<div id="movie_detail_main" style='padding: 50px 100px; color: #979797; background-color: black;'>
		<div id="movie">
			<div id="movie_img">
				<div id="pic">
					<img src="<%=request.getContextPath()%>${movieVO.mvPicture}" alt="">
				</div>
			</div>
			<div id="movie_detail_1">
				<div id="movie_title">
					<span>${movieVO.mvName}</span>
				</div>
				<br> <span class="whiteBg" id="movie_title_eng">${movieVO.mvEName}</span><br>
				<span class="whiteBg" id="movie_time">${movieVO.mvLong} 分鐘</span><br>
				<span class="whiteBg" id="movie_level">${movieVO.mvLevel}</span><br>
				<span class="whiteBg" id="movie_type">${movieVO.mvType}</span><br>
				<span class="whiteBg" id="movie_cast">${movieVO.mvCast}</span><br>
				<div id="movie_detail_2" class="whiteBg">
					<p id="movie_dt">${movieVO.mvDt}</p>
				</div>
			</div>
		</div>
		<div id="booking">
			<div id="date">
				<select name="" id="dateSelector" class="picker toRed">
					<!-- inject date -->
				</select>
			</div>
			<div id="time">
				<select name="" id="showingTime" class="picker toRed">
<!-- 					<option value="">--:--</option> -->
<!-- 					<option value="">08:00</option> -->
<!-- 					<option value="">11:00</option> -->
<!-- 					<option value="">14:00</option> -->
<!-- 					<option value="">17:00</option> -->
<!-- 					<option value="">20:00</option> -->
<!-- 					<option value="">23:00</option> -->
				</select>
			</div>
			<div id="book">
				<button id="bookBtn">BOOKING!</button>
			</div>
		</div>

		<div id="comment">
			<div id="cmt_info" value="0">
				<div id="cmt_title">
					<span>COMMENTS</span>
				</div>
				<div id="cmt_avg" value="${avgStar}" class="cmt_star">
					
				</div>
				<div id="cmt_ttcmt">
					<span>【${movieVO.mvTtCm}則評論】</span>
				</div>
				<div id="cmt_open">
					<span class="fa fa-plus"></span>
				</div>
			</div>


			<!--    載入評論   -------- -->
			<c:forEach var="cmtVO" items="${list}">
				<div class="cmt">
					<div class="member">
						<div class="member_pic">
							<img src="<%=request.getContextPath()%>${cmtVO.memberVO.member_Pic}" alt="">
						</div>
						<div class="member_name">
							<div class="member_nickname">
								<span>${cmtVO.memberVO.member_Name}</span>
							</div>
							<div class="member_id">
								<span>${cmtVO.MEMBER_ID}</span>
							</div>
						</div>
					</div>
					<div class="cmt_detail">
						<div class="cmt_text whiteBg" value="${cmtVO.CM_STATE}">
							${cmtVO.CM_TEXT}</div>
						<hr class="hr_cmt">
						<div class="cmt_like">
							<span class="fa fa-heart like">${cmtVO.CM_LIKE}</span>
						</div>
						<div class="cmt_date">
							<span><fmt:formatDate value="${cmtVO.CM_DATE}"
									pattern="yyyy-MM-dd HH:mm:ss" /></span>
						</div>
					</div>
					<div class="cmt_star" value="${cmtVO.CM_STAR}"></div>
				</div>
			</c:forEach>
		</div>


		<!--     新評論 -->
<hr class="hr-shadow">

		<div id="newCmt">
			<div class="member">
				<div class="member_pic">
					<img id="thisMemPic" src="./images/test0003.jpg" alt="">
				</div>
				<div class="member_name">
					<div class="member_nickname">
						<span id="thisMemNickname">乙骨憂太</span>
					</div>
					<div class="member_id">
						<span id="thisMemId">test0003</span>
					</div>
				</div>
			</div>
			<div class="cmt_detail">
				<div class="cmt_text">
					<textarea name="" id=""></textarea>
				</div>
				<hr>
				<div id="conf">
					<div class="cmtBtnArea">
						<p>comment</p>
					</div>
					<div id="netaArea">
						<div>評論是否劇透</div>
						<input type="checkbox" name="" id="netabare">
					</div>
				</div>
			</div>
			<div class="cmt_star">
				<div class="rating-box">
					<span class="rating-boxH1">Rating</span>
					<div class="rating">
						<span class="fa fa-star-o"></span> <span class="fa fa-star-o"></span>
						<span class="fa fa-star-o"></span> <span class="fa fa-star-o"></span>
						<span class="fa fa-star-o"></span>
					</div>
					<!-- <h4 id="rating-value"></h1> -->
				</div>
			</div>
		</div>




	</div>


	<!--客服圖 請自行加連結-->
	<img class="cs"
		src="<%=request.getContextPath()%>/front_end/movieDetail/images/demo/cs.png"
		height="50px;" width="60px;" href="#"></img>

	<!-- Copyright -->
	<div class="wrapper row2">
		<footer id="copyright" class="clear">
			<p class="fl_left">
				Copyright &copy; 2022 - All Rights Reserved <a href="#"></a>
			</p>
		</footer>
	</div>

	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$("#date button").click(function() {
			if ($(this).attr("class") == "") {
				$(this).attr("class", "clicked")
			} else {
				$(this).attr("class", "")
			}
		})
	</script>
	<script
		src="<%=request.getContextPath()%>/front_end/movieDetail//js/movie_detail.js"></script>
	<!-- rating system -->
	<script
		src="<%=request.getContextPath()%>/front_end/movieDetail//js/rating.js"></script>


	<!-- 加載Ajax -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<!-- Ajax的測試Script -->
	<script>
		//在網頁加載後，對id=doAjaxBtn的Button設定click的function
		$("#dateSelector").change(function(){
			let SH_TIME1 = $("#dateSelector").val() + " 09:00:00";
			console.log(SH_TIME1);
			let url = "${pageContext.request.contextPath}/showing/showing.do?action=getShowingByDate&SH_TIME=" + SH_TIME1;
			console.log(url);
			$.ajax({
			      type: "POST", //指定http參數傳輸格式為POST
			      url: url, //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
			      dataType: "json",
			      async: false,
			      success: function (response) {
			    	  for(let res of response){
				        $("#showingTime").append("<option>" + res.SH_TIME + "</option>");  
				        console.log(res.SH_TIME);
			    	  }
			      },
			      //Ajax失敗後要執行的function，此例為印出錯誤訊息
			      error: function (xhr, ajaxOptions, thrownError) {
			        alert(xhr.status + "\n" + thrownError);
			      }
		    });
		});
		
// 		let SH_TIME1 = $("#dateSelector").val();
// 		  console.log(SH_TIME1);
// 	$(document).ready(function () {
// 	  $("#dateSelector").change(function (e) {
// 		  let SH_TIME1 = $("#dateSelector").val() + " 09:00:00";
// 		  console.log(SH_TIME1);
// 	  let url = ${pageContext.request.contextPath}"/showing/showing.do?action=getShowingByDate&SH_TIME=" + SH_TIME1;
// 	    $.ajax({
// 	      type: "POST", //指定http參數傳輸格式為POST
// 	      url: "url", //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
// 	      dataType: "json",
// 	      async: false,
// 	      success: function (response) {
// 	    	  for(ShowingVO res : response){
// 		        $("#showingTime").append("<option>" + res.SH_TIME + "</option>");  
// 	    	  }
// 	      },
// 	      //Ajax失敗後要執行的function，此例為印出錯誤訊息
// 	      error: function (xhr, ajaxOptions, thrownError) {
// 	        alert(xhr.status + "\n" + thrownError);
// 	      },
// 	    });
// 	  });
// 	});

	
	</script>

</body>

</html>