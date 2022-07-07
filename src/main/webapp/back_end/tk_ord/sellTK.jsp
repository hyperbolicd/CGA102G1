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
<!-- TimePicker.css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/md-date-time-picker@2.3.0/dist/css/mdDateTimePicker.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back_end/showing/css/jquery.timepicker.css" />
<!-- DatePicker.css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/showing/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>
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
										<select size="1" name="MV_ID" class="MV_ID">
												<option value=0>請選擇電影
											<c:forEach var="MovieVO" items="${list}">
												<option value="${MovieVO.mvId}">${MovieVO.mvName}
											</c:forEach>
										</select>
									</FORM>
								</td>




								<td>

									<div id="selectByDate" class="selectBy">
										<div id="selectByDate_input">
											<input name="SH_TIME" id="f_date1" type="text" value="請選擇日期"
												autocomplete="off" onkeydown="return false;"><input
												type="hidden" name="action"
												value="listShowings_ByCompositeQuery">
										</div>
									</div>

								</td>

								<td><select class="showTimeSelect">
										<option value=0>請選擇場次
								</select></td>

								<td><a class="tablebt checkout">查看</a></td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/tkOrd/tkOrd.do"
										style="margin-bottom: 0px;">
								<input class="tablebt checkIn" type="submit" value="購票">
								 <input type="hidden" name="MV_ID" class="inputMV_ID"> 
								 <input type="hidden" name="SH_ID" class="inputSH_ID">
								 <input type="hidden" name="HL_ID" class="inputHL_ID">  
								 <input type="hidden" name="action" value="go_To_TicketSelect"></FORM>
								</td>
							</tr>
						</table>
					</div>
				</div>

				<div class="SeatOuter" style="opacity: 0;">
					<div class="front">
						<div class="screen">
							<div class="screeninner">螢幕</div>
						</div>
					</div>
					<div>
						<!-- 座位start -->

						<div class="seatsChart"></div>

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
	$('.checkout').click(function() {
// 		if($('.SeatOuter').css("opacity") == 0 ){
				
			$('.SeatOuter').fadeTo("fast",1);
		});
// 		else{
// 			$('.SeatOuter').fadeTo("fast",0);
// 			}
// 		}
			
	let col = '';
	let row = '';
	let seat = '';
	let MV_ID = '';
	let SH_SEAT_STATE = '';
	let HL_ID = 0;
	let hallName = '';
	let movieTime ='';
	let movieName ='';
	$('.MV_ID').change((e) => {
		MV_ID = e.target.value;
		$('.inputMV_ID').val(MV_ID);
		
	})
	
	
	$('#f_date1').change((e) => {
		SH_TIME = e.target.value;
		let url = "${pageContext.request.contextPath}/tkOrd/tkOrd.do?action=listShowings_ByCompositeQuery&MV_ID=" + MV_ID +"&SH_TIME=" + SH_TIME;
		

		$('.showTimeSelect').empty();
		$('.showTimeSelect').append('<option value=0>請選擇場次' );
		 $.ajax({
	            url: url,
	            type: 'post',
	            dataType: 'json',
	            async: false,
	            timeout: 15000,
	            success: function (data) {
	            	for(let show of data){
	            		let showTimeStr = show.SH_TIME + " "; 
	            		let showTime = showTimeStr.slice(-11, -7) + showTimeStr.slice(-3, -1);	
	            		
	            		if(show.SH_TYPE === 0){
	            			$('.showTimeSelect').append('<option value='+ show.SH_ID + '>'+showTime+"  (數位)");
	            		}else if (show.SH_TYPE === 1){
	            			$('.showTimeSelect').append('<option value='+ show.SH_ID + '>'+showTime+"  (IMAX)");
	            		}
	            	}
	            }
		 
		 
		})
	})

	$('.showTimeSelect').blur((e) => {
		let SH_ID = e.target.value;
		$('.inputSH_ID').val(SH_ID);
		
		let url = "${pageContext.request.contextPath}/tkOrd/tkOrd.do?action=listShowings_ByCompositeQuery&MV_ID=" + MV_ID +"&SH_ID=" + SH_ID;
		
		 $.ajax({
	            url: url,
	            type: 'post',
	            dataType: 'json',
	            async: false,
	            timeout: 15000,
	            success: function (data) {
	            	for(let show of data){
	            		HL_ID = show.HL_ID;
	            		seat = show.SH_SEAT_STATE;
	            		let showTimeStr = show.SH_TIME + " "; 
	            		
	            		
// 	            		之後得修改
// 	            		movieTime = showTimeStr.slice(0, 6) + showTimeStr.slice(-11, -7) + showTimeStr.slice(-3, -1) + "數位";
	            		
	            		
	            	}
	            } 
		 
			})
		
		let url2 = "${pageContext.request.contextPath}/tkOrd/tkOrd.do?action=findHallByhlId&hlId=" + HL_ID;
		$('.inputHL_ID').val(HL_ID);
		$.ajax({
            url: url2,
            type: 'post',
            dataType: 'json',
            async: false,
            timeout: 15000,
            success: function (data2) {
            	hallName = data2.hlName;
            	row = data2.hlRow;
            	col = data2.hlCol;

            } 
	 
		})
		
		let rowname = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
			const body = document.getElementsByClassName('seatsChart')[0];
			$('.seatsChart').empty();
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

			};
		
		
	})
	
	
	let showSelected = [];
	
	let showInf = {'movieName' : [],
			 'hallName' : [], 
			 'movieTime' : []
	};
	$('.checkIn').click(function() {
		movieName = $('.MV_ID option:selected').text();
		
		showInf.movieName= movieName;
		showInf.hallName= hallName;
		showInf.movieTime= movieTime;
		
		showSelected.push(showInf);
        sessionStorage.setItem('showSelected', JSON.stringify(showSelected));
		

	})
	
	
	</script>
	<script>
	
// 	let today = new Date();
		
		$.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
 	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 30,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d 09:00:00',         //format:'Y-m-d H:i:s',
		   value: '',              // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           minDate: '-1970-01-01', // 去除今日(不含)之前
           maxDate: '+1970-01-08'  // 去除今日(不含)之後
        });

		// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

		//      1.以下為某一天之前的日期無法選擇
		//      var somedate1 = new Date('2017-06-15');
		//      $('#f_date1').datetimepicker({
		//          beforeShowDay: function(date) {
		//        	  if (  date.getYear() <  somedate1.getYear() || 
		//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
		//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
		//              ) {
		//                   return [false, ""]
		//              }
		//              return [true, ""];
		//      }});

		//      2.以下為某一天之後的日期無法選擇
		//      var somedate2 = new Date('2017-06-15');
		//      $('#f_date1').datetimepicker({
		//          beforeShowDay: function(date) {
		//        	  if (  date.getYear() >  somedate2.getYear() || 
		//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
		//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
		//              ) {
		//                   return [false, ""]
		//              }
		//              return [true, ""];
		//      }});

		//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
		//      var somedate1 = new Date('2017-06-15');
		//      var somedate2 = new Date('2017-06-25');
		//      $('#f_date1').datetimepicker({
		//          beforeShowDay: function(date) {
		//        	  if (  date.getYear() <  somedate1.getYear() || 
		//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
		//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
		//		             ||
		//		            date.getYear() >  somedate2.getYear() || 
		//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
		//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
		//              ) {
		//                   return [false, ""]
		//              }
		//              return [true, ""];
		//      }});
	</script>
</body>
</html>