<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.merchandise_inf.model.*"%>
<%
List<MerchVO> list = (List<MerchVO>) session.getAttribute("merchlist");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/merchandise/css/merchlist.css">
</head>

<body>
	<header>
		<nav>
			<div id="logo">
				<img src="logo2noline.jpg">
			</div>
			<h2>員工後台操作系統</h2>
			<ul>
				<li>登出</li>
			</ul>
		</nav>
	</header>
	<aside id="aside"></aside>
	<!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
	<main>


		<div class="all">
			<div class="main">

				<div class="guide1outer">
					<div class="guide1">
						<div>所有商品</div>
					</div>
				</div>
				<div class="TKouter">

					<table class="TKinner tablesorter" id="myTable">
						<thead>
							<tr>
								<td>商品編號</td>
								<td>商品名稱</td>
								<td>商品狀態</td>
								<td>查詢</td>
								<td>刪除</td>
							</tr>
						</thead>
						<%@ include file="page1.file"%>
						<tbody>
							<c:forEach var="merch" items="${merchlist}"
								begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
								<%-- 						<c:forEach var="merch" items="${list}" > --%>
								<tr>
									<td>${merch.merchID}</td>
									<td><a class="tablebt"
										href="${pageContext.request.contextPath}/merch/controller?action=getOne_For_Display&merchID=${merch.merchID}">${merch.merchName}</td>
									<td>${merch.merchStatus == 1? '下架':''} ${merch.merchStatus == 2? '上架':''}
										${merch.merchStatus == 3? '主打':''}</td>
									<td>
										<form
											action="${pageContext.request.contextPath}/merch/controller">
											<input class="tablebt" type="hidden" name="merchID"
												value="${merch.merchID}">
											<button class="tablebt" type="submit" name="action"
												value="getOne_For_Update">修改</button>
										</form>
									</td>
									<td>
										<form
											action="${pageContext.request.contextPath}/merch/controller">
											<input class="tablebt" type="hidden" name="merchID"
												value="${merch.merchID}">
											<button class="tablebt" type="submit" name="action"
												value="delete">刪除</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<div class="btBlock">

					<%@ include file="page2.file"%>

				</div>
			</div>

		</div>





	</main>

	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>
	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>
	<script
		src='//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/css/theme.bootstrap.min.css"></link>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/js/jquery.tablesorter.min.js"></script>

	<script>
		$("#myTable").tablesorter({
			theme : "",
			widgets : [ 'zebra' ]
		});
	</script>
</body>

</html>