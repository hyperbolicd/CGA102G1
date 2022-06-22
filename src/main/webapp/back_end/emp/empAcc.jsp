<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.emp_account.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>帳號與權限</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back_end/emp/css/emp_all.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back_end/emp/css/emp_main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back_end/emp/css/emp_footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back_end/emp/css/empAcc.css">
</head>

<body>
	<header>
		<nav>
			<div id="logo">
				<img src="${pageContext.request.contextPath}/back_end/emp/logo2noline.jpg">
			</div>
			<h2>員工後台操作系統</h2>
			<ul>
				<li>登出</li>
			</ul>
		</nav>
	</header>
	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>
	<!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
	<main>
		<div id="main">
			<h1>帳號與權限</h1>
<%-- 			--${listAll == null}-- --%>
<%-- 			==${listAll != null}== --%>
<%-- 			++${orderType}++ --%>
<%-- 			<c:forEach var="xxx" items="${listAll}"> --%>
<%-- 				${xxx.emp_no} --%>
<%-- 			</c:forEach> --%>
			<button class="add" onclick="addAccount()">新增</button><span style="color: red;">${isSucess}</span>
			<div id="search">
				<label>顯示: </label>
				<select id="showStatus">
					<option value="-1">所有人</option>
					<option value="1">在職</option>
                    <option value="0">離職</option>
                    <option value="2">留職停薪</option>
				</select>
			</div>
			<table id="empData">
				<tr>
					<th class="tb0">
						<form action="${pageContext.request.contextPath}/OrderBy" method="post">
							<button id="listOrder" name="action" value="listAll">
								編號 ${orderSign==null? "&#8595;":orderSign}
								<input type="hidden" name="orderType" value='${orderType==null? "asc":orderType}'>
							</button>
						</form>
					</th>
					<th class="tb1">姓名</th>
					<th class="tb2">狀態</th>
					<th class="tb3">密碼</th>
					<th class="tb4">功能</th>
				</tr>
				<% 
					if(request.getAttribute("listAll") == null){
						EmpAccountService empSvc = new EmpAccountService();
						request.setAttribute("listAll", empSvc.getAll());
					}
				%>
				<c:forEach var="e" items="${listAll}">
<%-- 				<jsp:useBean id="listA" scope="page" class="com.emp_account.model.EmpAccountService"/> --%>
<%-- 				<c:forEach var="e" items="${listA.all}"> --%>
				<c:if test="${e.emp_no == lastUpdateEmpNo}">
					<tr style="color: red; !important">
				</c:if>
				<c:if test="${e.emp_no != lastUpdateEmpNo}">
					<tr>
				</c:if>
					<td>${e.emp_no}</td>
					<td>${e.emp_name}</td>
					<td id="empStatus">
						<c:if test="${e.emp_status == 0}">
							離職
						</c:if>
						<c:if test="${e.emp_status == 1}">
							在職
						</c:if>
						<c:if test="${e.emp_status == 2}">
							留職停薪
						</c:if>
					</td>
					<td>${e.emp_password}</td>
					<td>
						<form method="post" action="${pageContext.request.contextPath}/emp/EmpAccount.do" >
							<button type="submit" class="see" name="action" value="seeEmp">個人資料</button>
							<input type="hidden" name="seeEmpNo" value="${e.emp_no}">
						</form>
						<button class="edit">查看/修改權限</button>
						<button class="resetPw" onclick="resetPw(${e.emp_no})">重設密碼</button>
						<form method="post" action="${pageContext.request.contextPath}/emp/EmpAccount.do" >
							<button type="submit" class="delete" name="action" value="deleteEmp">刪除</button>
							<input type="hidden" name="deleteEmpNo" value="${e.emp_no}">
						</form>
					</td>
				</tr>
				</c:forEach>

			</table>
		</div>
		<div id="newAccount" onclick="windowClose()" style="display: none;"></div>
		<div id="dataInput" style="display: none;">
			<h1>新增員工資料</h1>
  				<form action="${pageContext.request.contextPath}/emp/EmpAccount.do" method="post">
   				<table id="newInfo">
			        <tr>
			            <td><label for="number">編號：</label></td>
			            <jsp:useBean id="listToGetNextId" scope="page" class="com.emp_account.model.EmpAccountService"/>
			            <td><input value="${listToGetNextId.nextId}" id="number" readonly></td>
			            <td><label for="password">密碼：</label></td>
			            <td><input type="password" id="password" name="emp_password" value="${empVO.emp_password}" placeholder="${errMsg.emp_password}"></td>
			        </tr>
			        <tr>
			            <td><label for="ename">姓名：</label></td>
			            <td><input id="ename" name="emp_name" value="${empVO.emp_name}" placeholder="${errMsg.emp_name}"></td>
			            <td><label for="status">狀態：</label></td>
			            <td>
			                <select name="emp_status" id="status">
			                    <option value="1" <c:if test="${empVO.emp_status == 1}">selected</c:if>>在職</option>
			                    <option value="0" <c:if test="${empVO.emp_status == 0}">selected</c:if>>離職</option>
			                    <option value="2" <c:if test="${empVO.emp_status == 2}">selected</c:if>>留職停薪</option>
			                </select>
			            </td>
        			</tr>
    			</table>
			    <h1>權限功能</h1>
			    <div id="auth">
				    	<input type="checkbox" id="funcs0" onclick="chooseAll(this)">
				        <label for="funcs2" class="big">一般職員權限</label>
				    	<input type="checkbox" id="funcs1" onclick="chooseAll(this)">
				        <label for="funcs1" class="big">管理員權限</label>
			        <br>
<!-- 			        從BD抓所有權限 -->
			    	<jsp:useBean id="listF" scope="page" class="com.emp_function.model.EmpFunctionService"/>
			    	<div class="fc_block">
				    	<c:forEach var="function" items="${listF.all}" begin="1" step="3">
				    		<input type="checkbox" name="newEmpFunctions" value="${function.fc_no}" class="funcs${function.fc_category}" id="func${function.fc_no}">
	           				<label for="func${function.fc_no}">${function.fc_name}</label>
	           				<br>
				    	</c:forEach>
			    	</div>
			    	<div class="fc_block">
				    	<c:forEach var="function" items="${listF.all}" begin="2" step="3">
				    		<input type="checkbox" name="newEmpFunctions" value="${function.fc_no}" class="funcs${function.fc_category}" id="func${function.fc_no}">
	           				<label for="func${function.fc_no}">${function.fc_name}</label>
	           				<br>
				    	</c:forEach>
			    	</div>
			    	<div class="fc_block">
				    	<c:forEach var="function" items="${listF.all}" begin="3" step="3">
				    		<input type="checkbox" name="newEmpFunctions" value="${function.fc_no}" class="funcs${function.fc_category}" id="func${function.fc_no}">
	           				<label for="func${function.fc_no}">${function.fc_name}</label>
	           				<br>
				    	</c:forEach>
			    	</div>
			    </div>
				<div>
			        <button class="cancel" type="button" onclick="windowClose()">取消</button>
			        <button class="enter" type="submit" name="action" value="addEmp">確認</button>
			    </div>
			 </form>	
		</div>
	</main>
	<!-- <div id="tree"></div> -->
	<footer> 嗨邇覓影城 &copy; HIREME CINEMA 2022 </footer>
	<script src="${pageContext.request.contextPath}/back_end/emp/js/empAcc2.js"></script>
</body>

</html>