<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tk_inf.model.*"%>
<%@ page import="com.fd_inf.model.*"%>


<%
TkInfService tkInfSvc = new TkInfService();
List<TkInfVO> list = tkInfSvc.getAll();
pageContext.setAttribute("list", list);
%>

<%
FdInfService fdInfSvc = new FdInfService();
List<FdInfVO> list2 = fdInfSvc.getAll();
pageContext.setAttribute("list2", list2);
%>

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
	href="<%=request.getContextPath()%>/back_end/tk_ord/styles/chooseTK.css">
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
					</div>
				</div>

				<div class="guide1outer">
					<div class="guide1">
						<div class="guide1inner">�п�ܹq�v��</div>
					</div>
				</div>
				<div class="TKouter">
					<table class="TKinner">
						<tr class="TKh">
							<td>����</td>
							<td>����</td>
							<td>�ƶq</td>
						</tr>

						<c:forEach var="tkinfVO" items="${list}">
							<c:choose>
								<c:when test="${(0 == tkinfVO.tkDI) && (tkinfVO.tkTypeID < 4)}">
									<tr class="TKh">
										<td>${tkinfVO.tkType}</td>
										<td>$ ${tkinfVO.tkPrice}</td>
										<td><input class="TK${tkinfVO.tkTypeID}" type="number"
											onkeydown="return false;" min="0" max="5" step="1" value="0" />
										</td>
									</tr>
								</c:when>
								<c:when test="${(0 == tkinfVO.tkDI) && (tkinfVO.tkTypeID > 4)}">
									<tr class="TKh">
										<td>${tkinfVO.tkType}</td>
										<td>$ ${tkinfVO.tkPrice}</td>
										<td><input class="TK${tkinfVO.tkTypeID}" type="number"
											onkeydown="return false;" min="0" max="5" step="1" value="0" />
										</td>
									</tr>
								</c:when>
							</c:choose>

						</c:forEach>
					</table>

				</div>
				<div class="guide2outer">
					<div class="guide2">
						<div class="guide2inner">�п���\��</div>
					</div>
				</div>
				<div class="FD">
					<div class="items">

						<c:forEach var="fdinfVO" items="${list2}">

							<c:if test="${fdinfVO.fdState == 1}">

								<div class="item">
									<div class="img_block">
										<img
											src="<%=request.getContextPath()%>/back_end/fd_inf/fd_inf.do?action=getPic&fdID=${fdinfVO.fdID}"
											style="width: 100px; height: 120px;">
									</div>
									<div class="iteminner">
										<div class="item_text">${fdinfVO.fdName}</div>
										<div class="item_text2">$ ${fdinfVO.fdprice}</div>
										<div>
											<input class="FD${fdinfVO.fdID}" type="number" min="0"
												max="5" step="1" value="0" />
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>

					</div>
				</div>
			</div>
			<div>
				<div class="temporaryInf">

					<div>
						<div class="tablehead">�w���T</div>
						<table class="sidetable">
							<tr>
								<td>�W��</td>
								<td>�ƶq</td>
								<td>����</td>
							</tr>
							<!-- �����}�l -->



							<!-- �����}�l -->





							<tr class="TKtable">
								<td></td>
								<td></td>
								<td></td>
							</tr>

						</table>
					</div>

				</div>
				<div class="btBlock">
					<a class="bt" href="chooseSEAT.html" style="text-decoration: none;">�~��</a>
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
	
	
	
	// �I����@����
	
<c:forEach var="tkinfVO" items="${list}">
						
	
	$(".TK${tkinfVO.tkTypeID}").change((e) => {
	    sessionStorage.setItem("${tkinfVO.tkType}", e.target.value);
	    $(".trTK${tkinfVO.tkTypeID}").remove();
	    $(".TKtable").before('<tr  class="trTK${tkinfVO.tkTypeID}"><td>${tkinfVO.tkType}</td><td>x ' + e.target.value + '</td><td>$ ' + (parseInt(e.target.value) * ${tkinfVO.tkPrice}) + '</td></tr>');
	    if (e.target.value === '0') {
	        $(".trTK${tkinfVO.tkTypeID}").remove();
	    }
	});

</c:forEach>

<c:forEach var="fdinfVO" items="${list2}">

$(".FD${fdinfVO.fdID}").change((e) => {
    sessionStorage.setItem("${fdinfVO.fdName}", e.target.value);
    $(".trFD${fdinfVO.fdID}").remove();
    $(".TKtable").before('<tr  class="trFD${fdinfVO.fdID}"><td>${fdinfVO.fdName}</td><td>x ' + e.target.value + '</td><td>$ ' + (parseInt(e.target.value) * ${fdinfVO.fdprice}) + '</td></tr>');
    if (e.target.value === '0') {
        $(".trFD${fdinfVO.fdID}").remove();
    }
});

</c:forEach>
	
	
	</script>
</body>
</html>