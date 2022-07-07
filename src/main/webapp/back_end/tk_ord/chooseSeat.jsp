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
<!-- 					<div class="timer"> -->
<!-- 						<table class="sidetable"> -->
<!-- 							<tr> -->
<!-- 								<td>剩下時間</td> -->
<!-- 							</tr> -->
<!-- 							<tr> -->
<!-- 								<td>01:00</td> -->
<!-- 							</tr> -->
<!-- 						</table> -->
<!-- 					</div> -->
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
					<a class="bt">繼續</a>
				</div>
				<!-- 				<form> -->
				<!-- 					<input type="hidden" name="id" class="id"> -->
				<!-- 					<input type="hidden" name="name" class= "name"> -->
				<!-- 					<input type="hidden" name="unitPrice" class= "unitPrice"> -->
				<!-- 					<input type="hidden" name="count" class= "count"> -->
				<!-- 				</form> -->
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
		if ($(".seatSelected").length < (TotalCount)) {
            Swal.fire({
                icon: 'error',
                title: '很抱歉',
                text: '您還有座位未選擇!',
                footer: '請繼續選擇您的座位'
            })
		}else{	
		
		
			$(".seatSelected").each(function(){		
				seatSelected.push($(this).attr("title"));
				sessionStorage.setItem('seatSelected', JSON.stringify(seatSelected));
				seatindex.push($(this).attr("seatindex"));
				sessionStorage.setItem('seatindex', JSON.stringify(seatindex));
		
			})
			
			document.location.href="<%=request.getContextPath()%>/back_end/tk_ord/confirmOrder.jsp";
		}
    });   
	
	
	
		
// 	長座位==================================================
		const body = document.getElementsByClassName('seatsChart')[0];
		let col = ${OrderHallVO.hlCol};
		let row = ${OrderHallVO.hlRow};
		let seat = '${OrderShowingVO.SH_SEAT_STATE}';

		let showingID = ${OrderShowingVO.SH_ID};

		
		
		
		let rowname = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

		for (let j = 0; j < row; j++) {
			const singeRow = document.createElement('div');
			singeRow.className = 'seatRow';
			body.append(singeRow);

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
				} else if (state === '5') {
					input.className = 'seatNumber seatSelected';	
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
		
		const TKorderStr = sessionStorage.getItem('TKorder');
        const TKorder = JSON.parse(TKorderStr);
        
		let TotalCount = 0;
		for (let TK of TKorder){
			TotalCount += parseInt(TK.count);
		}
		console.log(TotalCount);
		// 點擊單一座位=========================================================
		$(".seatNumber")
				.click(
						function() {
							// 去除不可選座位
							if (!$(this).hasClass("seatUnavailable")) {
								// 如果座位已選過
								if ($(this).hasClass("seatSelected")) {
									
									console.log("有啟動取消");
									let thisId = $(this).attr('id');
									let price = $('#seatsList .' + thisId)
											.val();
									$(this).removeClass("seatSelected");
										
                                    //把對應座位字串改回未選
                                    let index = $(this).attr("seatIndex");
                                    seat = changeSeat(seat, index, '1');
									console.log(seat);
// 							        更新資料庫座位
							        
							        
							        let url = "${pageContext.request.contextPath}/tkOrd/tkOrd.do?action=updateShowingByShowingID&SH_ID=" + showingID + "&SH_SEAT_STATE=" + seat;
									$.ajax({
           								url: url,
            							type: 'post',
           							 	dataType: 'json',
            							async: false,
            							timeout: 15000,
            							success: function (data) {
            								console.log("成功取消");
            								seat = data.SH_SEAT_STATE;
//             								
            								sendMessage(index);
            							} 
	 
									})
							        
							        
							        
									
									
							        
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
									let thisId = $(this).attr('id');
									let id = thisId.split("_");
									let price = $(this).attr('value');


									// 將座位加到預覽
									let seatDetails = "" + id[0] + "排" + id[1]
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
									
									let index = $(this).attr("seatIndex");
                                    seat = changeSeat(seat, index, '5');
							        
							        
// 							        更新資料庫座位=============================================================
							        
							      	let url = "${pageContext.request.contextPath}/tkOrd/tkOrd.do?action=updateShowingByShowingID&SH_ID=" + showingID + "&SH_SEAT_STATE=" + seat;
									$.ajax({
           								url: url,
            							type: 'post',
           							 	dataType: 'json',
            							async: false,
            							timeout: 15000,
            							success: function (data) {
            								console.log("成功新增");
            								seat = data.SH_SEAT_STATE;

            								console.log("成功長出新增");
            								sendMessage(index);
            								
            							} 
	 
									})
	
		        
									addToCheckout(price);
									refreshCounter();
									}
								}
							}
						});


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



let MyPoint = "/WebSocket_server_order/chooseSeat_user";
let host = window.location.host;
let path = window.location.pathname;
let webCtx = path.substring(0, path.indexOf('/', 1));
let endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
//串接起來=> ws://localhost:8081/CGA102G1/WebSocket_server/backend_user

let webSocket;

	function connect() {
		webSocket = new WebSocket(endPointURL);
		
		webSocket.onopen = function(event) {
		};
		// 此處收到來自server的session.getAsyncRemote().sendText(message);
		webSocket.onmessage = function(event) {
			let obj = JSON.parse(event.data);
			let seat_index = obj.seat_index;
			console.log(seat[seat_index])
			console.log(seat[seat_index])
// 			if (seat[seat_index] === '1'){
			// Data
            seat = changeSeat(seat, seat_index, '2');
            // UI
            var doms = $('.seatNumber'); 
            for (let i = 0; i < doms.length; i++) {
            	if($(doms[i]).attr('seatindex') === seat_index) {
            		

            		$(doms[i]).addClass('seatNumber seatUnavailable');
            		break;
            	}
            }
//             else if {}
				
// 			}
			

			console.log("選位頁面-收到推播!")

		};

		webSocket.onclose = function(event) {
		};
	}
	connect();
	
	function sendMessage(index) {
		let jsonObj = {
			"seat_index" : index
		};
		// JSON API 轉成文字 送到SERVER 清空欄位 focus
		webSocket.send(JSON.stringify(jsonObj));
			
	}

	function disconnect() {
		webSocket.close();
	}

	// common 
	function changeSeat(seat, index, status) {
		let seatArray = seat.split("");
		seatArray[index] = status;
		seat = "";
        for (const newStr of seatArray){
        	seat += newStr;
        }
        return seat;
	}


	</script>
	

<%-- 	<script src="${pageContext.request.contextPath}/back_end/tk_ord/javaScript/chooseSeatSocket.js"></script> --%>
</body>
</html>