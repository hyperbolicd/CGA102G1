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
											<c:forEach var="MovieVO" items="${list}">
												<option value="${MovieVO.mvId}">${MovieVO.mvName}
											</c:forEach>
										</select>
									</FORM>
								</td>




								<td>

									<div id="selectByDate" class="selectBy">
										<div id="selectByDate_input">
											<input name="SH_TIME" id="f_date1" type="text"
												autocomplete="off"> <input type="hidden"
												name="action" value="listShowings_ByCompositeQuery">
										</div>
									</div>

								</td>

								<td><select class="showTimeSelect"></select></td>

								<td><a class="tablebt checkout">查看</a></td>
								<td><a class="tablebt"
									href="<%=request.getContextPath()%>/back_end/tk_ord/chooseTK.jsp">購票</a></td>
							</tr>
						</table>
					</div>
				</div>

				<div class="SeatOuter" style="visibility: hidden;">
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
			$('.SeatOuter').css("visibility", "visible");
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
	<script>
	let MV_ID = '';
	
	$('.MV_ID').change((e) => {
		MV_ID = e.target.value;
	})
	
	$('#f_date1').change((e) => {
		let SH_TIME = e.target.value;
		let url = "${pageContext.request.contextPath}/tkOrd12/tkOrd.do?action=listShowings_ByCompositeQuery&MV_ID=" + MV_ID +"&SH_TIME=" + SH_TIME;
		 

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
	            		console.log(showTime);
	            		$('.showTimeSelect').append('<option value='+ show.SH_ID + '>' + showTime);
	            		

	            		
	            	}
	            }
		 
		 
		})
	})

// 	function f1(e) {

// 		    /*製作下一個table的row*/
// 		    let input = document.createElement('input');
// 		    input.type = "number";
// 		    input.name = "merchCount";
// 		    input.className = "totalCount";
// 		    input.placeholder = "請輸入需要的商品數量";
// 		    input.value = "${orderDetailVo.ordCount}";
// 		    let selectes = document.createElement('select');
// 		    selectes.name = "merchID";
// 		    let tr1 = document.createElement('tr');
// 		    let td4 = document.createElement('td');
// 		    let td5 = document.createElement('td');
// 		    let td6 = document.createElement('td');
// 		    td6.className = "merchPrice";
// 		    table.append(tr1);
// 		    tr1.append(td4);
// 		    tr1.append(td5);
// 		    tr1.append(td6);
// 		    td4.textContent = '商品名稱:';
// 		    td4.append(selectes);
// 		    td5.textContent = "商品數量:";
// 		    td5.append(input);
		    /*第一個選單*/
// 		    let option1 = document.createElement('option');
// 		    option1.textContent = "請選擇";
// 		    option1.value = "0";
// 		    selectes.append(option1);
// 		    /*製作沒有被選到商品的選單*/
// 		    for (let i = 0; i < merchID.length; i++) {
// 		        let option = document.createElement('option');
// 		        option.value = merchID[i];
// 		        let merchID1 = merchID[i];
// 		        /*傳沒被選到的商品編號回去取得剩下的所有商品名稱*/
// 		        let url = "${pageContext.request.contextPath}/merchOrd/merchOrd.do?action=getmerchNameByID&merchID=" + merchID1;
// 		        $.ajax({
// 		            url: url,
// 		            type: 'post',
// 		            dataType: 'json',
// 		            async: false,
// 		            timeout: 15000,
// 		            success: function (data) {
// 		                option.textContent = data.merchName;
// 		            }
// 		        })
// 		        selectes.append(option);
// 		    }
	
	
// 	let url = "${pageContext.request.contextPath}/merchOrd/merchOrd.do?action=getmerchNameByID&merchID=" + merchID1;
//         $.ajax({
//             url: url,
//             type: 'post',
//             dataType: 'json',
//             async: false,
//             timeout: 15000,
//             success: function (data) {
//                 option.textContent = data.merchName;
//             }
//         })
        
        
//       if("getmerchNameByID".equals(action)) {
//    Integer merchID = Integer.valueOf(req.getParameter("merchID"));
//    MerchService merchSvc = new MerchService();
//    MerchVO merchVo = merchSvc.getOneMerch(merchID);
//    PrintWriter out = res.getWriter();
//    Gson gson = new Gson();
//    out.print(gson.toJson(merchVo));
//   }
        
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

	
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