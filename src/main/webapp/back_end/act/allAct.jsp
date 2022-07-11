<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act.model.*"%>
<%@ page import="com.actdt.model.*"%>

<%
ActService actSvc = new ActService();
List<ActVO> list = actSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>活動方案管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">

<!-- 活動方案_css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/act/css/actback.css">

</head>


<body>
	<header>
		<nav>
			<div id="logo">
				<img
					src="${pageContext.request.contextPath}/back_end/logo2noline.jpg">
			</div>
			<h2>員工後台操作系統</h2>
			<ul>
				<li>登出</li>
			</ul>
		</nav>
	</header>

	<!-- 	<header> -->
	<%--         <%@ include file="/back_end/header_html.jsp"%>    --%>
	<!--     </header> -->

	<aside id="aside"></aside>
	<!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
	<main>
		<div class="all">
			<div class="main">

				<div class="guide1outer">
					<div class="guide1">
						<div>所有活動方案</div>
					</div>
				</div>
				<div class="btBlock">
					<a class="bt"
						href='<%=request.getContextPath()%>/back_end/act/addAct.jsp'>新增</a>
				</div>
				<div class="TKouter">

					<table class="TKinner">
						<tr>
							<td style="width: 7%">編號</td>
							<td style="width: 15%">發布日期</td>
							<td style="width: 30%">標題</td>
							<td style="width: 20%">內容</td>
							<td style="width: 3%">圖片</td>
							<td style="width: 10%">修改</td>
							<td style="width: 10%">刪除</td>

						</tr>
						<%@ include file="page1.file"%>
						<c:forEach var="actVO" items="${list}" begin="<%=pageIndex%>"
							end="<%=pageIndex+rowsPerPage-1%>">
							<tr>
								<td>${actVO.act_id}</td>
								<td>${actVO.act_date_start}</td>
								<td>${actVO.act_subtitle}</td>
								<td>${actVO.act_content}</td>
								<td>${actVO.act_picture}</td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/act/act.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="修改"> <input
											type="hidden" name="act_id" value="${actVO.act_id}">
										<input type="hidden" name="action" value="getOne_For_Update">
									</FORM></td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/act/act.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="刪除"> <input
											type="hidden" name="act_id" value="${actVO.act_id}">
										<input type="hidden" name="action" value="delete">
									</FORM></td>
							</tr>

						</c:forEach>


					</table>
				</div>

				<div class="btBlockpage">

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