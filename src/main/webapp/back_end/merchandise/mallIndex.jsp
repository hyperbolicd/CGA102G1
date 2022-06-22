<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/emp/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back_end/merchandise/css/FDINFBack.css">
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
						<div>商品資訊管理</div>
					</div>
				</div>
				<div class="btBlock" style="color:red">
					${errorMsgs.merchID}
				</div>
				<div class="TKouter">
<jsp:useBean id="merchSvc" scope="page" class="com.merchandise_inf.model.MerchService" />
					<table class="TKinner">

						<tr>
							<td>
							<a class="tablebt"
								href="${pageContext.request.contextPath}/back_end/merchandise/mallIndex.jsp">首頁</a>
							</td>

							<td>
							<a class="tablebt"
								href="${pageContext.request.contextPath}/back_end/merchandise/merchinsert.jsp">新增</a></td>
							<td>
							<form
									action="${pageContext.request.contextPath}/merch/controller">
									<button class="tablebt" type="submit" name="action"
										value="getAll_For_Display">查詢所有商品</button>
							</form>
							</td>

						</tr>
						<tr>
						<form action="${pageContext.request.contextPath}/merch/controller">
							<td>選擇商品編號:</td>
							<td>
							<select size="1" name="merchID">
         					<c:forEach var="merchVo" items="${merchSvc.all}" > 
          					<option value="${merchVo.merchID}">${merchVo.merchID}
         					</c:forEach>   
       						</select>
							</td>
							<td>       
							<button class="tablebt" type="submit" name="action"
									value="getOne_For_Display">查詢商品</button>
       						</td>
       					</form>
						</tr>
						<tr>
						<form action="${pageContext.request.contextPath}/merch/controller">
							<td>選擇商品名稱:</td>
							<td>
							<select size="1" name="merchID">
         					<c:forEach var="merchVo" items="${merchSvc.all}" > 
          					<option value="${merchVo.merchID}">${merchVo.merchName}
         					</c:forEach>   
       						</select>
							</td>
							<td>       
							<button class="tablebt" type="submit" name="action"
									value="getOne_For_Display">查詢商品</button>
       						</td>
       					</form>
						</tr>
						<tr>
							<td>顯示商品詳情:</td>
							<td><form
									action="${pageContext.request.contextPath}/merch/controller">
									<input class="input" type="text" name="merchID" placeholder="請輸入商品編號或關鍵字查詢"
										style="width: 250px">
									<td><button class="tablebt" type="submit" name="action" value="getOne_For_Display">確認</button>
								</form>
							</td>
							
						</tr>
						

<!--                         目前為三欄式表格 要增加得自己放在下面並複製 -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 						</tr> -->


					</table>
				</div>
			</div>
		</div>
	<div style="display:none" id="success">
	${success}</div>


	</main>
	<c:if test="${not empty success}">
		<script type="text/javascript" language="javascript">
			let success = document.getElementById("success");
			alert(success.textContent);
// 			alert(${success});
		</script>
			${remove.success};
		
	</c:if>
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>
	<aside id="aside">     
     <%@ include file="/back_end/aside_html.jsp"%>   
    </aside>
</body>

</html>