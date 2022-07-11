<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.actdt.model.*"%>

<%
ActdtVO actdtVO = (ActdtVO) request.getAttribute("actdtVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>活動管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">

<!-- 活動方案修改_css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/act/css/actback_add.css">


<!-- 文本編輯器，目前刪掉不用 -->
<script src="https://cdn.ckeditor.com/4.7.3/basic/ckeditor.js"></script>

<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>



</head>


<body>
	<header>
		<%@ include file="/back_end/header_html.jsp"%>
	</header>
	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>
	<!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
	<main>
		<div class="all">
			<div class="main">

				<div class="guide1outer">
					<div class="guide1">
						<div>修改活動</div>
					</div>
				</div>

				<FORM METHOD="post" enctype="multipart/form-data"
					ACTION="<%=request.getContextPath()%>/act/act.do" name="form1">

					<div class="TKouter">

						<table class="TKinner">
							<tr>
								<td></td>
								<td>輸入</td>
								<td></td>
							</tr>
							<tr>
								<td>編號:</td>
								<td>${actdtVO.act_id}<input type="hidden" name="act_id" value="${actdtVO.act_id}"></td>
								<td></td>
							</tr>
							<tr>
								<td>發佈日期:</td>
								<td><input style="text-align: center;" type="text"
									id="act_date1" name="act_date_start" size="95"
									value="${actdtVO.act_date_start}"></td>
								<td>${errorMsgs.act_date_start}</td>
							</tr>
							<tr>
								<td>標題:</td>
								<td><input type="text" name="act_title"
									placeholder="請輸入標題，為了更好的展示效果，標題字數在20字以內"
									onkeyUp="textLimitCheck(this, 20);" size="90"
									value="${actdtVO.act_title}"><span id="messageCount">0</span>/20</td>
								<td>${errorMsgs.act_title}</td>
							</tr>
							<tr>
								<td>副標題:</td>
								<td><input type="text" name="act_subtitle"
									placeholder="請輸入副標題，為了更好的展示效果，標題字數在40字以內"
									onkeyUp="textLimitCheck2(this, 40);" size="90"
									value="${actdtVO.act_subtitle}"><span id="messageCount2">0</span>/40</td>
								<td>${errorMsgs.act_subtitle}</td>
							</tr>

							<tr>
								<td>適用票種:</td>
								<td>${actdtVO.tkTypeID}</td>
<%-- 								<td><input type="checkbox" name="TkTypeID" VALUE="1" ${actdtVO.tkTypeID=='1'? "selected" : ""}>全票/數位 --%>
<%-- 									<input type="checkbox" name="TkTypeID" VALUE="2" ${actdtVO.tkTypeID=='2'? "selected" : ""}>全票/IMAX --%>
<%-- 									<input type="checkbox" name="TkTypeID" VALUE="3" ${actdtVO.tkTypeID=='3'? "selected" : ""}>優待票/數位 --%>
<%-- 									<input type="checkbox" name="TkTypeID" VALUE="4" ${actdtVO.tkTypeID=='4'? "selected" : ""}>優待票/IMAX --%>
<%-- 									<input type="checkbox" name="TkTypeID" VALUE="5" ${actdtVO.tkTypeID=='5'? "selected" : ""}>早場票/數位 --%>
<%-- 									<input type="checkbox" name="TkTypeID" VALUE="6" ${actdtVO.tkTypeID=='6'? "selected" : ""}>早場票/IMAX</td> --%>
								<td></td>
							</tr>
							
							<tr>
								<td>折扣:</td>
								<td><input type="text" name="act_discount" size="45"
									value="${actdtVO.act_discount}">請輸入0~1中間的值，例如：0.9</td>
								<td>${errorMsgs.act_discount}</td>
							</tr>
							
							<tr>
								<td>折價:</td>
								<td><input type="text" name="act_coupon" size="45"
									value="${actdtVO.act_coupon}">請輸入數字，例如：20　　　　</td>
								<td>${errorMsgs.act_coupon}</td>
							</tr>
							
							<tr>
								<td>狀態:</td>
								<td><select name="act_status">
										<option value="0" ${actdtVO.act_status=='0'? "selected" : ""}>未上架</option>
										<option value="1" ${actdtVO.act_status=='0'? "selected" : ""}>已上架</option>
										<option value="2" ${actdtVO.act_status=='0'? "selected" : ""}>已下架</option>
								</select></td>
								<td></td>
							</tr>

							<tr>
								<td>內容:</td>
								<td><textarea style="resize: none; margin: 20px;"
										id="act_content" name="act_content" cols="90" rows="30">${actdtVO.act_content}</textarea></td>
								<td>${errorMsgs.act_content}</td>
							</tr>
							<tr>
								<td>圖片:</td>
								<td class="act_picture"><img id="img" src=<%=request.getContextPath()%>${actdtVO.act_picture} style="width: 300px; height: 250px;"> 
								<input id="act_picture" type="file" name="act_picture"
									value="${actdtVO.act_picture}"></td>
								<td></td>
							</tr>
						</table>
					</div>


					<div class="btBlock">
						<input type="hidden" name="action" value="update"> <input
							type="submit" class="bt" value="送出修改">
					</div>
				</FORM>

			</div>

		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>

	
	<!-- 標題輸入框字數限制 -->
	<script type="text/javascript">
		function textLimitCheck(thisArea, maxLength) {
			if (thisArea.value.length > maxLength) {
				alert(maxLength + ' 個字限制。 \r 超出的將自動清除');
				thisArea.value = thisArea.value.substring(0, 20);
				thisArea.focus();
			}
			messageCount.innerText = thisArea.value.length;
		}
	</script>
	
	<!-- 副標題輸入框字數限制 -->
	<script type="text/javascript">
		function textLimitCheck2(thisArea, maxLength) {
			if (thisArea.value.length > maxLength) {
				alert(maxLength + ' 個字限制。 \r 超出的將自動清除');
				thisArea.value = thisArea.value.substring(0, 40);
				thisArea.focus();
			}
			messageCount2.innerText = thisArea.value.length;
		}
	</script>
	
	
	
</body>


<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Date act_date_start = null;
try {
	act_date_start = actdtVO.getAct_date_start();
} catch (Exception e) {
	act_date_start = new java.sql.Date(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script
	src="<%=request.getContextPath()%>/back_end/act/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/back_end/act/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#act_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=act_date_start%>'
	// value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});
</script>




</html>