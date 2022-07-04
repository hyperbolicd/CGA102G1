<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*" %>
<%@ page import="com.tk_ord.model.*" %>
<%@ page import="com.changeSeat.*" %>
<%@ page import="com.hall.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
 Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
 List<TkOrdVO> OrdVOList = (List<TkOrdVO>)map.get("OrdVOList");
 List<ShowSeatVO> showList = (List<ShowSeatVO>)map.get("showList");
 List<HallVO> hlList = (List<HallVO>)map.get("hlList");
 List<MovieVO> mvList = (List<MovieVO>)map.get("mvList");
%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>我的票夾</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/ticketFolder/ticketFolder.css">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
  <!-- 置頂按鈕 -->
  <button type="button" id="BackTop" class="toTop-arrow"></button>
  <script>
    $(function () {
      $('#BackTop').click(function () {
        $('html,body').animate({ scrollTop: 0 }, 333);
      });
      $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
          $('#BackTop').fadeIn(222);
        } else {
          $('#BackTop').stop().fadeOut(222);
        }
      }).scroll();
    });
  </script>

<header>

<%@ include file="/front_end/header.jsp"%>
<%@ include file="/front_end/header_css.jsp"%>

</header>

 <div class="order_container">
 	<div class="mytabs">
        <input type="radio" id="show" name="mytabs" checked="checked">
        <label for="show">查看票卷</label>
        <div class="container">
        	<c:forEach items="${OrdVOList}" var="OrdVO" varStatus="loop">
            <div class="content">
                <div class="cover">
                    <img src="${pageContext.request.contextPath}${mvList[loop.index].mvPicture}" alt="">
                </div>
                <div class="info_container">
                    <div class="info">
                        <div class="mvName">${mvList[loop.index].mvName}</div>
                        <div class="hlName">${hlList[loop.index].hlName}</div>
                        <div class="shDate">$showList[loop.index].SH_TIME}</div>
                        <div class="icon_container">
	                    	<div class="ticket_icon">
	                    	<img src="/CGA102G1/front_end/ticketFolder/ticket.png" alt="">
	                    	x2
	                    	</div>
	                    	<div class="food_icon">
	                    	<img src="/CGA102G1/front_end/ticketFolder/food.png" alt="">
	                    	x3
	                    	</div>
                    	</div>
                    </div>
                </div>
                <div class="bt">
                	<form action="${pageContext.request.contextPath}" method="post">
                		<input type="hidden" name="mvId" value="$">
                		<input type="hidden" name="action" value="getOneForDisplay">
                    	<button type="submit">查看訂單詳情</button>
                	</form>
                </div>
            </div>
            </c:forEach>
        </div>
        
        <input type="radio" id="soon" name="mytabs">
        <label for="soon">已過期票卷</label>
        <div class="container">
            <div class="content">
                <div class="cover">
                    <img src="" alt="">
                </div>
                <div class="info_container">
                     <div class="info">
                        <div class="mvName">電影名稱</div>
                        <div class="hlName">廳院名稱</div>
                        <div class="shDate">2022-06-01 09:00</div>
                        <div class="icon_container">
	                    	<div class="ticket_icon">
	                    	<img src="/CGA102G1/front_end/ticketFolder/ticket.png" alt="">
	                    	x2
	                    	</div>
	                    	<div class="food_icon">
	                    	<img src="/CGA102G1/front_end/ticketFolder/food.png" alt="">
	                    	x3
	                    	</div>
                    	</div>
                    </div>
                </div>
                <div class="bt">
                	<form action="${pageContext.request.contextPath}" method="post">
                		<input type="hidden" name="" value="">
                		<input type="hidden" name="" value="">
                    	<button type="submit">查看訂單詳情</button>
                	</form>
                </div>
            </div>
            
        </div>
      </div>
 </div>
      
      

  <!--客服圖 請自行加連結-->
  <img class="cs" src="images/demo/cs.png" height="50px;" width="60px;" href="#"></img>

  <!-- Copyright -->
  <div class="wrapper row2">
    <footer id="copyright" class="clear">
      <p class="fl_left">Copyright &copy; 2022 - All Rights Reserved <a href="#"></a></p>
    </footer>
  </div>

</body>

</html>