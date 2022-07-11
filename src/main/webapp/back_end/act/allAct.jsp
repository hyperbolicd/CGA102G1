<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.actdt.model.*"%>

<%
ActdtService actdtSvc = new ActdtService();
//List<ActdtVO> list = actdtSvc.getAll();
List<ActdtVO> list = actdtSvc.getOnlyAct();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>活動管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">

<!-- 活動_css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/act/css/actback.css">

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
						<div>所有活動</div>
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
<!-- 							<td style="width: 8%">圖片</td> -->
							<td style="width: 10%">修改</td>
							<td style="width: 10%">刪除</td>

						</tr>
						<%@ include file="page1.file"%>
						<c:forEach var="actdtVO" items="${list}" begin="<%=pageIndex%>"
							end="<%=pageIndex+rowsPerPage-1%>">
							<tr>
								<td>${actdtVO.act_id}</td>
								<td>${actdtVO.act_date_start}</td>
								<td>${actdtVO.act_subtitle}</td>
								<td>${actdtVO.act_content}</td>
<%-- 								<td><img src="<%=request.getContextPath()%>${actdtVO.act_picture}" style="width: 80px; height: 70px;"></td> --%>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/act/act.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="修改"> <input
											type="hidden" name="act_id" value="${actdtVO.act_id}">
										<input type="hidden" name="action" value="getOne_For_Update">
									</FORM></td>
								<td><FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/act/act.do"
										style="margin-bottom: 0px;">
										<input class="tablebt" type="submit" value="刪除"> <input
											type="hidden" name="act_id" value="${actdtVO.act_id}">
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

</body>
</html>