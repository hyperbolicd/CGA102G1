<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>HireMe</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/css/layout.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

  <div class="wrapper row1" style="height:60px;">
    <header id="header" class="clear">
      <div id="hgroup">
       <img src="images/demo/logo6.png" width="200" height="60" alt="">
      </div>

      <div class="dropdown" style=" margin: 0;padding: 0;list-style: none; ">

        <button class="dropbtn">會員專區</button>
        <div class="dropdown-content">
          <a href="#">會員登入</a>
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

    
    
    

 <div style="padding:500px 100px;">

內容放在這裡




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