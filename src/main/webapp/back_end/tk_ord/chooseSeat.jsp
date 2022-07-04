<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>選擇座位</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/tk_ord/styles/chooseSeat.css">
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
						<div class="guide1inner">請選擇座位</div>
					</div>
				</div>
				<div class="guide2outer">
					<div class="guide2">
						<div class="guide2inner">
							<div class="state1outer">
								<div class="state1"></div>
								<div>可選擇</div>
							</div>
							<div class="state2outer">
								<div class="state2"></div>
								<div>已售出</div>
							</div>
							<div class="state3outer">
								<div class="state3"></div>
								<div>您的座位</div>
							</div>
							<div class="state4outer">
								<div class="state4"></div>
								<div>保留位</div>
							</div>
							<div class="state5outer">
								<div class="state5"></div>
								<div>維修中</div>
							</div>
						</div>
					</div>
				</div>
				<div class="SeatOuter">
					<div class="front">
						<div class="screen">
							<div class="screeninner">螢幕</div>
						</div>
					</div>
					<div>
						<!-- 座位start -->
						<div class="seatsChart">


							<!-- 以下改為用長的 -->
							<!-- <div class="seatRow">
                            <div class="seatRowNumber">
                                A
                            </div>
                            <div id="A_1" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber seatUnavailable">1</div>
                            <div id="A_2" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber ">2</div>
                            <div id="A_3" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber ">3</div>
                            <div id="A_4" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber seatUnavailable">4</div>
                            <div id="A_5" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber ">5</div>
                            <div id="A_6" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber  ">6</div>
                            <div id="A_7" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber ">7</div>
                            <div id="A_8" role="checkbox" value="1" aria-checked="false" focusable="true"
                                class=" seatNumber ">8</div>


                        </div>-->
						</div>

					</div>

				</div>
			</div>

			<!-- 座位end -->



			<div>
				<div class="temporaryInf">
					<div class="timer">
						<table class="sidetable">
							<tr>
								<td>剩下時間</td>
							</tr>
							<tr>
								<td>01:00</td>
							</tr>
						</table>
					</div>
					<div class="receiptouter">
						<div class="seatsReceipt">
							<p>
								<strong> 已選座位數: <span class="seatsAmount"> 0 </span> <!-- 									<button id="btnClear" class="btn">清空</button> -->
								</strong>
							</p>
							<ul id="seatsList" class="nav nav-stacked"></ul>
						</div>
					</div>
				</div>

				<div class="btBlock">
					<a class="bt"
						href="<%=request.getContextPath()%>/back_end/tk_ord/confirmOrder.jsp">繼續</a>
				</div>
			</div>
		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>


	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<script>
	
//  把選的座位存起來================================================
	let seatSelected = [];
	let seatindex = [];
	
	$('.bt').click(function () {
		
		$(".seatSelected").each(function(){		
			seatSelected.push($(this).attr("title"));
			sessionStorage.setItem('seatSelected', JSON.stringify(seatSelected));
			seatindex.push($(this).attr("seatindex"));
			sessionStorage.setItem('seatindex', JSON.stringify(seatindex));
		
		})
		
    });   
	
	
	
		
// 	長座位==================================================
		const body = document.getElementsByClassName('seatsChart')[0];
		let col = 12;
		let row = 15;
		let seat = '010120102201030010410105101061010710108101091011000111101121020110202102030020410205102061020710208102091021000211102121030110302103030030410305103061030710308103091031000311103121040110402104030040410405104061040710408104091041000411104121050110502105030050410505105061050710508105091051000511105121060110602106030060410605106061060710608106091061000611106121070100702007030070400705007060070700708007090071000711007120080130802308030080430805308063080730808308093081000811308123090110902109030090410905109061090710908109091091000911109121100111002110030100411005110061100711008110091101001011110121110111102111030110411105111061110711108111091111001111111121120111202112030120411205112061120711208112091121001211112121130111302113030130411305113061130711308113091131001311113121140111402114030140411405114061140711408114091141001411114121150111502115030150411505115061150711508115091151001511115121';
		let rowname = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

		for (let j = 0; j < row; j++) {
			const singeRow = document.createElement('div');
			singeRow.className = 'seatRow';
			body.append(singeRow);

			// 			已放棄加字因為會跑版
			// 			const rowtitle = document.createElement('div');
			// 			rowtitle.className = 'seatRowNumber';
			// 			singeRow.append(rowtitle)
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

				let seatIndex = i;
				input.setAttribute("seatIndex", seatIndex);

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

		//  取出之前選的票數=====================================================
		
		const TKCountStr = sessionStorage.getItem('TKCount');
        const TKCount = JSON.parse(TKCountStr);
        
		let TotalCount = 0;
		for (let TK of TKCount){
			TotalCount += parseInt(TK.count);
		}
		
		// 點擊單一座位=========================================================
		$(".seatNumber")
				.click(
						function() {
							// 去除不可選座位
							if (!$(this).hasClass("seatUnavailable")) {
								// 如果座位已選過
								if ($(this).hasClass("seatSelected")) {
									
									
									var thisId = $(this).attr('id');
									var price = $('#seatsList .' + thisId)
											.val();
									$(this).removeClass("seatSelected");
										
                                    //把對應座位字串改回未選
									let seatArray = seat.split("",seat.length);
									let i = $(this).attr("seatIndex");
									seatArray[i]= '1';
									seat="";
							        for (const newStr of seatArray){
							            seat += newStr ;
							        }
									
									$('#seatsList .' + thisId).remove();
									// 呼叫方法更新預覽
									removeFromCheckout(price);
									refreshCounter();
									
								} else {
									// 限制選位數
									if ($(".seatSelected").length > (TotalCount-1)) {
										             Swal.fire({
										                 icon: 'error',
										                 title: '很抱歉',
										                 text: '您所選的座位超過您預定的數量!',
										                 footer: '請先取消原有座位再進行選擇'
										             })
									}else{
									
									// 取值
									var thisId = $(this).attr('id');
									var id = thisId.split("_");
									var price = $(this).attr('value');
									var seatDetails = "Row: " + id[0]
											+ " Seat:" + id[1] + " Price:CA$:"
											+ price;

									// 將座位加到預覽
									var seatDetails = "" + id[0] + "排" + id[1]
											+ "號";
									$("#seatsList")
											.append(
													'<li value=' + price + ' class=' + thisId + '>'
													+ seatDetails
													+ "</li>");
															
// 															有需要再加
// 															+ "<button id='remove:" + thisId + "'+ class='btn btn-default btn-sm removeSeat' value='" + price + 
// 													"'><strong>X</strong></button></li>");
															
															
									$(this).addClass("seatSelected");
									
									let seatArray = seat.split("",seat.length);
									let i = $(this).attr("seatIndex");
									seatArray[i]= '2';
									seat="";
							        for (const newStr of seatArray){
							        	seat += newStr ;
							            
							        }
									
									addToCheckout(price);
									refreshCounter();
									}
								}
							}
						});

		
		
		
		
		
		// 清除單個座位
// 		$(document).on('click', ".removeSeat", function() {
// 			// 從座位取得id
// 			var id = $(this).attr('id').split(":");
// 			var price = $(this).attr('value')
// 			$('#seatsList .' + id[1]).remove();
// 			$("#" + id[1] + ".seatNumber").removeClass("seatSelected");
// 			removeFromCheckout(price);
// 			refreshCounter();
// 		});
		// 停留時顯示座位
		$(".seatNumber").hover(function() {
			if (!$(this).hasClass("seatUnavailable")) {
				var id = $(this).attr('id');
				var id = id.split("_");
				var tooltip = "" + id[0] + id[1];

				$(this).prop('title', tooltip);
			} else {
				$(this).prop('title', "無法選擇");
			}
		});
		// 從預覽清除座位
		function refreshCounter() {
			$(".seatsAmount").text($(".seatSelected").length);
		}
		// 加座位到預覽
		function addToCheckout(thisSeat) {
			var seatPrice = parseInt(thisSeat);
			var num = parseInt($('.txtSubTotal').text());
			num += seatPrice;
			num = num.toString();
			$(".txtSubTotal").text(num);
		}
		// 從預覽清除單個座位
		function removeFromCheckout(thisSeat) {
			var seatPrice = parseInt(thisSeat);
			var num = parseInt($('.txtSubTotal').text());
			num -= seatPrice;
			num = num.toString();
			$('.txtSubTotal').text(num);
		}

		// 清除座位按鈕
		// 		$("#btnClear").click(function() {
		// 			$('.txtSubTotal').text(0);
		// 			$(".seatsAmount").text(0);
		// 			$('.seatSelected').removeClass('seatSelected');
		// 			$('#seatsList li').remove();
		// 		});

		
		
			//計時器
// 	let sec = 59;
// 		setInterval(function() {
// 			$("#timeOut").text(timeFormat(sec));
// 			sec -= 1;
// 		}, 1000)
// 		setTimeout(
// 			function() {
// 				window.location.replace("${pageContext.request.contextPath}/index.jsp");
// 			}, sec * 1000);
// 		function timeFormat(second) {
// 			let minute = parseInt(second / 60);
// 			second %= 60;
// 			(second < 10) ? second = '0' + second : second;
// 			return minute + ":" + second;
// 		}
		
	</script>
</body>
</html>