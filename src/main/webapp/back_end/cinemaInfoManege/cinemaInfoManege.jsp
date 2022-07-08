<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cnm_inf.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
// Cnm_infService cnmSvc = new Cnm_infService();
// List<Cnm_infVO> list = cnmSvc.getAll();
// System.out.println(list.get(0).getCNM_TEL());
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/back_end/cinemaInfoManege/css/cinemaInfoManege.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/showing/emp_all.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/showing/emp_main.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/showing/emp_footer.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back_end/showing/css/showing_select_page.css" />

</head>
<body>
	<header>
        <%@ include file="/back_end/header_html.jsp"%>   
    </header>
    <aside id="aside">   
    	<%@ include file="/back_end/aside_html.jsp"%>     
    </aside>
    	<main>
    
<div class="mainDiv">

<jsp:useBean id="cnm_infSvc" scope="page" class="com.cnm_inf.model.Cnm_infService" />

    <div class="selectDiv">
        <select name="" id="infoId">
        <option value="">選一個改啦
            <c:forEach var="cnm_infVO" items="${cnm_infSvc.all}">
				<option value="${cnm_infVO.CNM_INF_ID}">${cnm_infVO.CNM_INF_ID}
			</c:forEach>
        </select>
    </div>

    <div class="editDiv">

        <div class="cnmID">
            <span>敘述編號</span>
            <input type="text" readonly>
        </div>

        <div class="cnmDT">
            <span>影城敘述</span>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>

        <div class="cnmTEL">
            <span>影城電話</span>
            <input type="text" name="" id="">
        </div>

        <div class="cnmEM">
            <span>電子信箱</span>
            <input type="text">
        </div>

        <div class="cnmLC">
            <span>影城地址</span>
            <input type="text">
        </div>

        <div class="cnmTRP">
            <span>交通資訊</span>
            <input type="text">
        </div>

        <div class="send">
            <button>submit</button>
        </div>

    </div>



</div>

</main>

	<footer>嗨邇覓影城 &copy; HIREME CINEMA 2022</footer>
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/back_end/showing/emp_aside.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>


<script type="text/javascript">
$("#infoId").change(function(){
	let id = $("#infoId").val();
	let url = "${pageContext.request.contextPath}/cnm_inf/cnm_inf.do?action=getOne_For_Display&CNM_INF_ID=" + id;
	console.log(url);
	$.ajax({
	      type: "POST", //指定http參數傳輸格式為POST
	      url: url, //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
	      dataType: "json",
	      async: false,
	      success: function (response) {
	    	  	
		        console.log(response.CNM_INF_ID);
		        $(".cnmID input").val(response.CNM_INF_ID);  
		        $(".cnmDT textarea").text(response.CNM_DT);  
		        $(".cnmID input").val(response.CNM_INF_ID);  
		        $(".cnmID input").val(response.CNM_INF_ID);  
		        $(".cnmID input").val(response.CNM_INF_ID);  

	      },
	      //Ajax失敗後要執行的function，此例為印出錯誤訊息
	      error: function (xhr, ajaxOptions, thrownError) {
	        alert(xhr.status + "\n" + thrownError);
	      }
  });
});

</script>

</body>
</html>