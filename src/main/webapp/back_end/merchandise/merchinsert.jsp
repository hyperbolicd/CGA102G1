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
						<div>商品新增頁面</div>
					</div>
				</div>

				<form action="${pageContext.request.contextPath}/merch/controller"
					method="post" enctype="multipart/form-data">
					<div class="TKouter">

						<table class="TKinner">
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>商品名稱:</td>
								<td><input type="text" placeholder="請輸入商品名稱"
									name="merchName" value="${merchVo.merchName}" required></td>
								<td></td>
							</tr>
							<tr>
								<td>商品價格:</td>
								<td><input type="number" name="merchPrice"
									placeholder="請輸入商品價格編號" value="${merchVo.merchPrice}" required></td>
								<td>${errorMsgs.merchPrice}</td>
							</tr>
							<tr>
								<td>商品類別:</td>
								<td><select name="merchClass">
										<option value="模型" ${(merchVo.merchClass=="模型")? 'selected':''}>模型</option>
										<option value="抱枕" ${(merchVo.merchClass=="抱枕")? 'selected':''}>抱枕</option>
										<option value="生活用品" ${(merchVo.merchClass=="生活用品")? 'selected':''}>生活用品</option>
										<option value="服飾" ${(merchVo.merchClass=="服飾")? 'selected':''}>服飾</option>
										<option value="文具" ${(merchVo.merchClass=="文具")? 'selected':''}>文具</option>
								</select></td>
								<td></td>
							</tr>
							<tr>
								<td>商品銷售總數:</td>
								<td><input type="number" name="soldTotal"
									placeholder="不輸入則默認為0" value="${merchVo.soldTotal}"></td>
								<td>${errorMsgs.soldTotal}</td>
							</tr>
							<tr>
								<td>商品庫存:</td>
								<td><input type="number" name="merchStock"
									placeholder="請輸入庫存數" value="${merchVo.merchStock}" required></td>
								<td>${errorMsgs.merchStock}</td>
							</tr>
							<tr>
								<td>商品狀態:</td>
								<td><select name="merchStatus">
										<option value="1" ${(merchVo.merchStatus=="1")? 'selected':''}>下架</option>
										<option value="2" ${(merchVo.merchStatus=="2")? 'selected':''}>上架</option>
										<option value="3" ${(merchVo.merchStatus=="3")? 'selected':''}>主打</option>
								</select></td>
								<td></td>
							</tr>
							<tr>
								<td>商品描述:</td>
								<td><textarea name="merchDT" cols="30" rows="10" required>${merchVo.merchDT}</textarea></td>
								<td></td>
							</tr>
							<tr>
								<td>上傳商品圖一:</td>
								<td><input type="file" name="merchPic1" accept="image/*"></td>
								<td></td>
							</tr>
							<tr>
								<td>上傳商品圖二:</td>
								<td><input type="file" name="merchPic2" accept="image/*"></td>
								<td></td>
							</tr>
							<tr>
								<td>上傳商品圖三:</td>
								<td><input type="file" name="merchPic3" accept="image/*"></td>
								<td></td>
							</tr>
							<tr>
								<td>上傳商品圖四:</td>
								<td><input type="file" name="merchPic4" accept="image/*"></td>
								<td></td>
							</tr>
							<tr>
								<td>上傳商品圖五:</td>
								<td><input type="file" name="merchPic5" accept="image/*"></td>
								<td></td>
							</tr>


						</table>
					</div>
					<div class="btBlock">
						<input type="hidden" name="action" value="insert"> <input
							type="submit" class="bt" value="送出新增">
							<button class="tablebt" form="1234">放棄新增</button>
					</div>
				</FORM>
				<form action="${pageContext.request.contextPath}/back_end/merchandise/mallIndex.jsp" id="1234"></form>
			</div>

		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>
	<aside id="aside">     
     <%@ include file="/back_end/aside_html.jsp"%>   
    </aside>
	<script>
		let abc = URL.createObjectURL(blob);
	</script>
</body>

</html>