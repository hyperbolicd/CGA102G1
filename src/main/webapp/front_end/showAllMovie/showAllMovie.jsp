<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	MovieService mvSvc = new MovieService();
	List<MovieVO> showingList = mvSvc.getShowingMV();
	List<MovieVO> comingList = mvSvc.getComingMV();
	pageContext.setAttribute("showingList", showingList);
	pageContext.setAttribute("comingList", comingList);
%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>showAllMovie</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="styles/layout.css" type="text/css">
  <link rel="stylesheet" href="./styles/allMovie.css">
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


  <!--各自的內容--------------------->
    <div class="fm1" style = 'padding:10px 20px; background-color:#ECECEC;'>
      <!--將內容存-->
      <div class="mytabs">
        <input type="radio" id="show" name="mytabs" checked="checked">
        <label for="show">上映中</label>
        <div class="container">
         <c:forEach var="showingVO" items="${showingList}" >
            <div class="content">
                <div class="cover">
                    <img src="${showingVO.mvPicture}" alt="">
                </div>
                <div class="info_container">
                    <div class="info">
                        <div class="name">${showingVO.mvName}</div>
                        <div class="ename">${showingVO.mvEName}</div>
                        <div class="stDate">上映日期:${showingVO.mvStDate}</div>
                        <div class="star">${showingVO.mvTtStar/showingVO.mvTtCm}
                            <img src="/CGA102G1/front_end/showAllMovie/MV_ICON/star.png" alt="">
                        </div>
                    </div>
                    <div class="icon">
                        <img src="/CGA102G1/front_end/showAllMovie/MV_ICON/level${showingVO.mvLevel}.jpg" alt="">
                    </div>
                </div>
                <div class="bt">
                	<form action="">
                	
                    <button>查看電影詳情</button>
                	</form>
                </div>
            </div>
            </c:forEach>
        </div>
        
        <input type="radio" id="soon" name="mytabs">
        <label for="soon">即將上映</label>
        <div class="container">
      		<c:forEach var="comingVO" items="${comingList}" >
            <div class="content">
                <div class="cover">
                    <img src="${comingVO.mvPicture}" alt="">
                </div>
                <div class="info_container">
                    <div class="info">
                        <div class="name">${comingVO.mvName}</div>
                        <div class="ename">${comingVO.mvEName}</div>
                        <div class="stDate">預計上映:${comingVO.mvStDate}</div>
                    </div>
                    <div class="icon">
                        <img src="/CGA102G1/front_end/showAllMovie/MV_ICON/level${comingVO.mvLevel}.jpg" alt="">
                    </div>
                </div>
                <div class="bt">
                	<form action="">
                	
                    <button>查看電影詳情</button>
                	</form>
                </div>
            </div>
            </c:forEach>
            
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