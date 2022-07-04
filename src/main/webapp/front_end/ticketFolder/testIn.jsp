<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>測試</title>
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

      <form action="${pageContext.request.contextPath}//TkFolderServlet.do" METHOD="post">
      <input type="hidden" name="member_ID" value="1" >
      <input type="hidden" name="action" value="listAllOrdInf" >
      <button type="submit">進入我的票夾</button>
      </form>
      

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