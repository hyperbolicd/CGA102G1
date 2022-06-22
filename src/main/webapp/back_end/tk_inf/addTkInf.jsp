<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tk_inf.model.*"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>���ظ�ƺ޲z</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/tk_inf/styles/addTKINFBack.css">
</head>


<body>
	<header>
		<nav>
			<div id="logo">
				<img src="${pageContext.request.contextPath}/back_end/logo2noline.jpg">
			</div>
			<h2>���u��x�ާ@�t��</h2>
			<ul>
				<li>�n�X</li>
			</ul>
		</nav>
	</header>
	<aside id="aside"></aside>
	<!-- �A�̪����e�Щ�b <main> ���Ҥ��A��L�����Ű�! -->
	<main>
		<div class="all">
			<div class="main">

				<div class="guide1outer">
					<div class="guide1">
						<div>�s�W����</div>
					</div>
				</div><FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/tk_inf/tk_inf.do" name="form1">
				<div class="TKouter">
					
						<table class="TKinner">
							<tr>
								<td></td>
								<td>��J</td>
								<td></td>
							</tr>
							<tr>
								<td>���ئW��:</td>
								<td><input type="text" name="tkType" size="45"
									value="${param.tkType}"></td>
								<td>${errorMsgs.tkType}</td>
							</tr>
							<tr>
								<td>�w��:</td>
								<td><input type="text" name="tkPrice" size="45"
									value="${param.tkPrice}"></td>
								<td>${errorMsgs.tkPrice}</td>
							</tr>
							<tr>
								<td>�������:</td>
								<td><select name="tkDI">
										<option value="0">�Ʀ�</option>
										<option value="1">IMAX</option>
								</select></td>
								<td></td>
							</tr>
							<tr>
								<td>�Ƶ�:</td>
								<td><input type="text" name="tkTypeDT" size="45"
									value="${param.tkTypeDT}" /></td>
								<td>${errorMsgs.tkTypeDT}</td>
							</tr>

						</table>
				</div>
				<div class="btBlock">
					<input type="hidden" name="action" value="insert"> <input
						type="submit" class="bt" value="�e�X�s�W">

				
			</div></FORM>
			</div>

		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> ����V�v�� &copy; HIREME CINEMA 2022 </footer>



 <aside id="aside">
  <%@ include file="/back_end/aside_html.jsp"%>
 </aside>
</body>
</html>