<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*" %>


<div class="wrapper row1" style="height:60px;">
    <header id="header" class="clear">
      <div id="hgroup">
        <img src="<%=request.getContextPath()%>/front_end/index/images/demo/logo6.png" width="200" height="60" alt="">
      </div>

      <div class="dropdown" style=" margin: 0;padding: 0;list-style: none; ">
        <button class="dropbtn">會員專區</button>
        <div class="dropdown-content">
          <a href="#">會員中心</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">活動公告</button>
        <div class="dropdown-content">
          <a href="#">影城公告</a>
          <a href="#">影城好康</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">Q & A專區</button>
        <div class="dropdown-content">
          <a href="#">常見問題</a>
          <a href="#">客服信箱</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">影城專區</button>
        <div class="dropdown-content">
          <a href="#">影城介紹</a>
          <a href="#">影城地點</a>
          <a href="#">票價資訊</a>
          <a href="#">餐飲資訊</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">電影資訊</button>
        <div class="dropdown-content">
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">商城購物</button>
        <div class="dropdown-content">
          <a href="#">商品瀏覽</a>
          <a href="#">購買退貨</a>
        </div>
      </div>
 

    </header>
  </div>
      <!-- 置頂按鈕 -->
  <button type="button" id="BackTop" class="toTop-arrow"></button>
  <!--  <script>
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
-->