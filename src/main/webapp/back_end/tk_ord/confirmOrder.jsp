<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>��ܲ���</title>
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
	<!-- �A�̪����e�Щ�b <main> ���Ҥ��A��L�����Ű�! -->
	<main>

		<div class="all">
			<div class="main">

				<div class="showingInf">
					<div class="showmain">
						<div class="showname">�q�v�W</div>
					</div>
					<div class="showside">
						<div class="showtime">�ɶ�</div>
						<div class="hellname">�U�W</div>
						<div class="seats">
							<div class="allSeat"></div>
						</div>
					</div>
				</div>
				<div class="guide1outer">
					<div class="guide1">
						<div>�нT�{�q�椺�e</div>
					</div>
				</div>
				<div class="TKouter">
					<table class="TKinner">
						<thead>
							<tr>
								<th>�W��</th>
								<th>����</th>
								<th>�ƶq</th>
								<th>���ʤ��</th>
								<th>���</th>
							</tr>
						<thead>
						<tbody class="orderTable">
						</tbody>
						<tr>
							<th>�`�p</th>
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
							href="<%=request.getContextPath()%>/back_end/tk_ord/creditCard.jsp">�H�Υd�I��</a>
					</div>

				</div>
			</div>
			<div>
				<div class="temporaryInf">
					<div class="timer">
						<table class="sidetable">
							<tr>
								<th>�ѤU�ɶ�</th>
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
	<footer> ����V�v�� &copy; HIREME CINEMA 2022 </footer>


	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>

	<script>
//          ���X�q��==============================================================
	
	 	const tbody = document.querySelector('tbody');
        const orderStr = sessionStorage.getItem('order');
        const order = JSON.parse(orderStr);
       
       let total = 0;
       for (let TK of order) {
    	   if (TK.count === '' || TK.count === '0') {	
    		   
    	   }else{
           total += (TK.unitPrice * TK.count);
           
           tbody.insertAdjacentHTML('beforeend','<tr><td>'+ TK.name+ '</td><td>$' + TK.unitPrice +'</td><td>' + TK.count + '</td><td>���</td><td>$'+(TK.unitPrice * TK.count)+'</td></tr>');        
    	   
    	   
    	   
    	   
    	   
    	   
    	   }
       }
       
       
       let showTotal = document.getElementById('total');
       showTotal.innerText ="$" + total;
       
       
       
//        �w��y��==============================================================
		
       const seatSelectedStr = sessionStorage.getItem('seatSelected');
       const seatSelected = JSON.parse(seatSelectedStr);

       for (let seat of seatSelected){
    	   $(".allSeat").prepend("| " + seat + " ");
       }
       
       

	
	</script>
</body>
</html>