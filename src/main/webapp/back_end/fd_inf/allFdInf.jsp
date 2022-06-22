<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.fd_inf.model.*"%>

<%
FdInfService fdInfSvc = new FdInfService();
List<FdInfVO> list = fdInfSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>飲食資料管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/fd_inf/styles/FDINFBack.css">


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
						<div>所有餐飲資訊</div>
					</div>
				</div>
				<div class="btBlock">
					<a class="bt"
						href='<%=request.getContextPath()%>/back_end/fd_inf/addFdInf.jsp'>新增</a>
				</div>
				<div class="TKouter">

					<table class="TKinner">
						<tr>
							<td>編號</td>
							<td>種類</td>
							<td>餐飲名稱</td>
							<td>價格</td>
							<td>備註</td>
							<td>圖片</td>
							<td>狀態</td>
							<td>修改</td>
							<td>刪除</td>

						</tr>
						<%@ include file="page1.file"%>
						<c:forEach var="fdinfVO" items="${list}" begin="<%=pageIndex%>"
							end="<%=pageIndex+rowsPerPage-1%>">
							<tr>
								<td>${fdinfVO.fdID}</td>
								<td><c:choose>
										<c:when test="${fdinfVO.fdType == 0}">
														飲料
													</c:when>
										<c:when test="${fdinfVO.fdType == 1}">
														熟食
													</c:when>
									</c:choose></td>
								<td>${fdinfVO.fdName}</td>
								<td>$ ${fdinfVO.fdprice}</td>
								<td>${fdinfVO.fdDT}</td>
								<td><img src="<%=request.getContextPath()%>/back_end/fd_inf/fd_inf.do?action=getPic&fdID=${fdinfVO.fdID}"
									style="width: 100px; height: 120px;"></td>
								<td id="status-${fdinfVO.fdID}">${fdinfVO.fdState == 0 ? "下架" : "上架"}</td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/back_end/fd_inf/fd_inf.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="修改"> <input
											type="hidden" name="fdID" value="${fdinfVO.fdID}"> <input
											type="hidden" name="action" value="getOne_For_Update">
									</FORM></td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/back_end/fd_inf/fd_inf.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="刪除"> <input
											type="hidden" name="fdID" value="${fdinfVO.fdID}"> <input
											type="hidden" name="action" value="delete">
									</FORM></td>
							</tr>

						</c:forEach>


					</table>
				</div>
				<div class="btBlock">

						<%@ include file="page2.file"%>

				</div>


			</div>

		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>


	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>

</body>
</html>