<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%@ page import="com.tk_inf.model.*"%>


<%@ page import="com.movie.model.*"%>

<%
MovieService movieSvc = new MovieService();
List<MovieVO> list = movieSvc.getAll();
pageContext.setAttribute("list", list);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>現場販售</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/tk_ord/styles/sellTKback.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>


<body>
	
	<header>
		<%@ include file="/back_end/header_html.jsp"%>
	</header>
	
	<aside id="aside"></aside>
	<!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
	<main>

		<div class="all">
			<div class="main">

				<div class="guide1outer">
					<div class="guide1">
						<div class="guide1inner">現場販售</div>
					</div>
				</div>

				<div class="guide2outer">
					<div class="TKouter">
						<table class="TKinner">
							<tr>
							
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/MovieServlet.do">
										<select size="1"
											name="MovieVO">
											<c:forEach var="MovieVO" items="${list}">
												<option value="${MovieVO.mvId}">${MovieVO.mvName}
											</c:forEach>
										</select> 
									</FORM>
								</td>

								<td>
								
								<select name="" id="">

								</select>
								
								</td>
								<td><select name="" id=""></select></td>
								<td><a class="tablebt checkout">查看</a></td>
								<td><a class="tablebt" href="checkout.html">購票</a></td>
							</tr>
						</table>
					</div>
				</div>

				<div class="SeatOuter" style="visibility:hidden;">
					<div class="front">
						<div class="screen">
							<div class="screeninner">螢幕</div>
						</div>
					</div>
					<div>
						<!-- 座位start -->

						<div class="seatsChart" >

							


						</div>

					</div>

				</div>
			</div>

			<!-- 座位end -->


		</div>


	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>


	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>
	<script>
	
	
	$(".checkout").click(function () {
        $('.SeatOuter').show();
    });
	
	
	
	
	
	
	
	
		const body = document.getElementsByClassName('seatsChart')[0];
		let col = 12;
		let row = 15;
		let seat = '010110102101030010410105101061010710108101091011000111101121020110202102030020410205102061020710208102091021000211102121030110302103030030410305103061030710308103091031000311103121040110402104030040410405104061040710408104091041000411104121050110502105030050410505105061050710508105091051000511105121060110602106030060410605106061060710608106091061000611106121070100702007030070400705007060070700708007090071000711007120080130802308030080430805308063080730808308093081000811308123090110902109030090410905109061090710908109091091000911109121100111002110030100411005110061100711008110091101001011110121110111102111030110411105111061110711108111091111001111111121120111202112030120411205112061120711208112091121001211112121130111302113030130411305113061130711308113091131001311113121140111402114030140411405114061140711408114091141001411114121150111502115030150411505115061150711508115091151001511115121';
		let rowname = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

		for (let j = 0; j < row; j++) {
			const singeRow = document.createElement('div');
			singeRow.className = 'seatRow';
			body.append(singeRow);

			const rowtitle = document.createElement('div');
			rowtitle.className = 'seatRowNumber';
			singeRow.append(rowtitle)
			// rowtitle.innerHTML = rowname[j] 已放棄加字因為會跑版

			for (let i = 4 + (j * 5 * col); i < seat.length; i += 5) {
				const input = document.createElement("div");
				input.setAttribute("role", "checkbox");
				input.setAttribute("aria-checked", "false");
				input.setAttribute("focusable", "true");

				// 用from
				input.innerHTML = (seat[i - 2] + seat[i - 1]);
				let state = seat[i];
				input.id = rowname[j] + "_" + (seat[i - 2] + seat[i - 1]);

				if (state === '1') {
					input.className = 'seatNumber';
				} else if (state === '0') {
					input.className = 'seatNumber aisle';
				} else if (state === '3') {
					input.className = 'seatNumber seatReserved';
				} else if (state === '4') {
					input.className = 'seatNumber seatConstruction';
				} else {
					input.className = 'seatNumber seatUnavailable';
				}

				singeRow.append(input);

				// 換排
				if (((i + 1) / 5) % col === 0) {

					break;
				}

			}

		}
		
	</script>
</body>
</html>