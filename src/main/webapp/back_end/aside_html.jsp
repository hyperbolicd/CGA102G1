<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul>
	<li id="index"><span><a href="${pageContext.request.contextPath}/back_end/empIndex.jsp">首頁</a></span></li>
	<li><span>資訊管理</span>
		<ul>
			<li>影城資訊管理</li>
			<li><a href="${pageContext.request.contextPath}/back_end/ManageMV/manageMV.jsp">電影資訊管理</a></li>
			<li><a href="${pageContext.request.contextPath}/back_end/tk_inf/allTkInf.jsp">票價資訊管理</a></li>
			<li><a href="${pageContext.request.contextPath}/back_end/fd_inf/allFdInf.jsp">餐飲資訊管理</a></li>
			<li><a href="${pageContext.request.contextPath}/back_end/ManageHall/manageHall.jsp">影廳資訊管理</a></li>
			<li>場次管理</li>
			<li><a href="${pageContext.request.contextPath}/back_end/ManageSeat/manageSeat.jsp">座位管理</a></li>
		</ul></li>
	<li><span>票務管理</span>
		<ul>
			<li>現場購票/購餐</li>
			<li>票務訂單管理</li>
			<li>驗票驗證碼</li>
		</ul></li>
	<li><span>評論相關</span>
		<ul>
			<li>舉報回應管理</li>
		</ul></li>
	<li><span>商城相關</span>
		<ul>
			<li><a href="${pageContext.request.contextPath}/back_end/merchandise/mallIndex.jsp">商品資訊</a></li>
			<li>商城訂單</li>
		</ul></li>
	<li><span>活動相關</span>
		<ul>
			<li>促銷活動管理</li>
			<li><a href="${pageContext.request.contextPath}/back_end/wish/wishPond.jsp">許願池管理</a></li>
		</ul></li>
	<li><span>公告客服</span>
		<ul>
			<li>公告管理</li>
			<li>Q&A文字管理</li>
			<li>線上客服</li>
		</ul></li>
	<li><span>員工管理</span>
		<ul>
			<li><a href="${pageContext.request.contextPath}/back_end/emp/empAcc.jsp">帳號與權限</a></li>
			<li><a href="${pageContext.request.contextPath}/back_end/emp/empSelf.jsp">個人資料維護</a></li>
		</ul></li>
	<li><span>會員管理</span>
		<ul>
			<li>會員帳號管理</li>
		</ul></li>
</ul>
