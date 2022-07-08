<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act.model.*"%>
<%@ page import="com.actdt.model.*"%>

<%
ActVO actVO = (ActVO) request.getAttribute("actVO");
ActdtVO actdtVO = (ActdtVO) request.getAttribute("actdtVO");//EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

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
<title>���ʤ�׺޲z</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_all.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/css/emp_footer.css">


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/act/css/actback_add.css">


<!-- ���e�奻 -->
<script src="https://cdn.ckeditor.com/4.7.3/basic/ckeditor.js"></script>

<!-- ����d�� -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/act/daterangepicker/daterangepicker.css">


<script type="text/javascript">
	function tk_type_id() {
		for (var i = 0; i < document.form1.tk_type_id.length; i++) {
			if (!document.f.tk_type_id[i].checked) {
				alert("Please Select Your options");
				return false;
			} else {
				alert("Click Submit to Know your choices");
				return true;
			}
		}
	}
</script>



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

				<div class="guide1outer">
					<div class="guide1">
						<div>�s�W���ʤ��</div>
					</div>
				</div>

				<FORM METHOD="post" enctype="multipart/form-data"
					ACTION="<%=request.getContextPath()%>/act/act.do" name="form1">
					<div class="TKouter">

						<table class="TKinner">
							<tr>
								<td></td>
								<td>��J</td>
								<td></td>
							</tr>
							<tr>
								<td>���D:</td>
								<td><input type="text" name="act_title" size="45"
									value="${param.act_title}"></td>
								<td>${errorMsgs.act_title}</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>�Ƽ��D:</td>
								<td><input type="text" name="act_subtitle" size="45"
									value="${param.act_subtitle}"></td>
								<td>${errorMsgs.act_subtitle}</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>


							<tr>
								<td>�A�β���:</td>
								<td><input type="checkbox" name="tk_type_id" VALUE="1">����/�Ʀ�
									<input type="checkbox" name="tk_type_id" VALUE="2">����/IMAX
									<input type="checkbox" name="tk_type_id" VALUE="3">�u�ݲ�/�Ʀ�
									<input type="checkbox" name="tk_type_id" VALUE="4">�u�ݲ�/IMAX
									<input type="checkbox" name="tk_type_id" VALUE="5">������/�Ʀ�
									<input type="checkbox" name="tk_type_id" VALUE="6">������/IMAX</td>
								<td></td>
							</tr>


							<tr>
								<td>���ʧ馩:</td>
								<td><input type="text" name="act_discount" size="45"
									value="${param.act_discount}"></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>���ʧ��:</td>
								<td><input type="text" name="act_coupon" size="45"
									value="${param.act_coupon}"></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>���:</td>
								<td><input style="text-align: center;" type="text"
									id="act_date1" name="act_date" size="95"
									value="${param.act_date_start}"></td>
									<td>${errorMsgs.act_date_start}</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>���ʤ�ת��A:</td>
								<td><select name="act_status">
										<option value="0" ${param.act_status=='0'? "selected" : ""}>���W�[</option>
										<option value="1" ${param.act_status=='1'? "selected" : ""}>�w�W�[</option>
										<option value="2" ${param.act_status=='2'? "selected" : ""}>�w�U�[</option>
								</select></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>���e:</td>
								<td><textarea id="act_content" name="editor1" cols="50"
										rows="10">${actVO.act_content}</textarea> <script>
											CKEDITOR.replace('editor1');
										</script></td>
								<td>${errorMsgs.act_content}</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>�Ϥ�:</td>
								<td><input id="act_picture"	type="file" name="ann_picture" value="${param.act_picture}"></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
					<div class="btBlock">
						<input type="hidden" name="action" value="insert"> <input
							type="submit" class="bt" value="�e�X�s�W">


					</div>
				</FORM>
			</div>

		</div>

	</main>
	<!-- <div id="tree"></div> -->
	<footer> ����V�v�� &copy; HIREME CINEMA 2022 </footer>



	<aside id="aside">
		<%@ include file="/back_end/aside_html.jsp"%>
	</aside>

<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

<%
java.sql.Date act_date_start = null;
try {
	act_date_start = actVO.getAct_date_start();
} catch (Exception e) {
	act_date_start = new java.sql.Date(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script
	src="<%=request.getContextPath()%>/back_end/act/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/back_end/act/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#act_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=act_date_start%>'
	// value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
	//startDate:	            '2017/07/10',  // �_�l��
	//minDate:               '-1970-01-01', // �h������(���t)���e
	//maxDate:               '+1970-01-01'  // �h������(���t)����
	});
</script>


</html>