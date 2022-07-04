<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>選擇票種</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/tk_ord/styles/confirmOrder.css">
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

				<div class="showingInf">
					<div class="showmain">
						<div class="showname">電影名</div>
					</div>
					<div class="showside">
						<div class="showtime">時間</div>
						<div class="hellname">廳名</div>
						<div class="seats">
							<div class="allSeat"></div>
						</div>
					</div>
				</div>
				<div class="guide1outer">
					<div class="guide1">
						<div>請確認訂單內容</div>
					</div>
				</div>
				<div class="TKouter">
					<table class="TKinner">
						<thead>
							<tr>
								<th>名稱</th>
								<th>價格</th>
								<th>數量</th>
								<th>活動方案</th>
								<th>售價</th>
							</tr>
						<thead>
						<tbody class="orderTable">
						</tbody>
						<tr>
							<th>總計</th>
							<th></th>
							<th></th>
							<th></th>
							<th id="total"></th>
						</tr>
					</table>
				</div>



				<div class="checkout">
					<div class="btBlock">
						<a class="bt"
							href="<%=request.getContextPath()%>/back_end/tk_ord/creditCard.jsp">信用卡付款</a>
					</div>

				</div>
			</div>
			<div>
				<div class="temporaryInf">
					<div class="timer">
						<table class="sidetable">
							<tr>
								<th>剩下時間</th>
							</tr>
							<tr>
								<td>01:00</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>


	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>

	<script>
//          取出訂單==============================================================
	
	 	const tbody = document.querySelector('tbody');
        const orderStr = sessionStorage.getItem('order');
        const order = JSON.parse(orderStr);
       
       let total = 0;
       for (let TK of order) {
    	   if (TK.count === '' || TK.count === '0') {	
    		   
    	   }else{
           total += (TK.unitPrice * TK.count);
           
           tbody.insertAdjacentHTML('beforeend','<tr><td>'+ TK.name+ '</td><td>$' + TK.unitPrice +'</td><td>' + TK.count + '</td><td>原價</td><td>$'+(TK.unitPrice * TK.count)+'</td></tr>');        
    	   
    	   
    	   
    	   
    	   
    	   
    	   }
       }
       
       
       let showTotal = document.getElementById('total');
       showTotal.innerText ="$" + total;
       
       
       
//        已選座位==============================================================
		
       const seatSelectedStr = sessionStorage.getItem('seatSelected');
       const seatSelected = JSON.parse(seatSelectedStr);

       for (let seat of seatSelected){
    	   $(".allSeat").prepend("| " + seat + " ");
       }
       
       

	
	</script>
</body>
</html>