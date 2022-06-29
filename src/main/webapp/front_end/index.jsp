<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>
<html lang="en" dir="ltr">
<%
 MemberVO memberVO = (MemberVO) session.getAttribute("memberVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<head>
  <title>HireMe</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/css/layout.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


  <!-- 輪播圖片 css -->
  <style type="text/css">
  div,ul,li,a,span,img{margin:0;padding:0;}
  #banner { 
      overflow:hidden; 
      width:100%; 
      height:400px; 
      position:relative; 
      float:left;
      padding-bottom: 10px;
  }
  #tab>img:not(:first-child){ 
      display:none; 
  }
  .lunbo_btn {
      height: 15px;
      width: 100%;
      margin: 0px auto;
      margin-top: -40px;
      position: absolute;
      z-index: 3;
      text-align: center;
  }
  .lunbo_btn span {
      width:14px;
      height:14px;
      display:inline-block;
      background-color:#b4b5b7;
      border-radius:50%;
      margin:0px 2px;
      cursor:pointer;
  }
  .lunbo_btn span.hover {
      background-color:#ffb23c;
  }
  .arrow {
      display: none;
      width: 30px;
      height: 60px;
      background-color: rgba(0,0,0,0.4);
      position: absolute;
      top: 50%;
      margin-top: -30px;
      z-index:999;
  }
  .arrow span {
      display: block;
      width: 10px;
      height: 10px;
      border-bottom: 2px solid #fff;
      border-left: 2px solid #fff;
  }
  .slider_left {
      margin: 25px 0 0 10px;
      transform: rotate(45deg);
  }
  .prve {
      left: 0;
  }
  .next {
      right: 0;
  }
  .slider_right {
      margin: 25px 0 0 5px;
      transform: rotate(-135deg);
  }
  .arrow:hover{background:#444;}
  #banner:hover .arrow{display:block;}
  </style>

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
        <img src="<%=request.getContextPath()%>/front_end/index/images/demo/logo6.png" width="200" height="60" alt="">
      </div>

      <div class="dropdown" style=" margin: 0;padding: 0;list-style: none; ">
        <button class="dropbtn">會員專區</button>
        <div class="dropdown-content">
          <a href="${pageContext.request.contextPath}/front_end/membercentre/membercentre.jsp">會員中心</a>
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
    	

 
<!--       <button class="logout">會員登出</button> -->
 	<div class="dropdown">
		<c:if test="${empty sessionScope.memberVO.member_ID}">
			<a id="logIn" href="${pageContext.request.contextPath}/front_end/login/login.jsp">登入</a>
		</c:if>
		<c:if test="${not empty sessionScope.memberVO.member_ID}">
			<div style="display:flex">
				<p style="margin-right:20px">${memberVO.member_Name}&nbsp;&nbsp;Hello</p>
				<a href="<%=request.getContextPath()%>/member.do?action=logout" type="button" id="logOut">登出</a>
			</div>
		</c:if>
	</div>
    

    </header>
  </div>

  

    <div id="banner">    
        <!-- 輪播圖片 -->
        <div id="tab">
            <img class="tabImg" src="<%=request.getContextPath()%>/front_end/index/images/movie3.jpg" height="400" width="100%"/>
            <img class="tabImg" src="<%=request.getContextPath()%>/front_end/index/images/movie4.jpg" height="400" width="100%"/>
            <img class="tabImg" src="<%=request.getContextPath()%>/front_end/index/images/movie5.jpg" height="400" width="100%"/>
            <img class="tabImg" src="<%=request.getContextPath()%>/front_end/index/images/movie6.jpg" height="400" width="100%"/>
        </div>
        <!-- 指示符 -->
        <div class="lunbo_btn">
            <span num="0" class="tabBtn hover"></span>
            <span num="1" class="tabBtn"></span>
            <span num="2" class="tabBtn"></span>
            <span num="3" class="tabBtn"></span>
        </div>    
        <!-- 左右切換按鈕 -->
        <div class="arrow prve">
            <span class="slider_left"></span>
        </div>
        <div class="arrow next">
            <span class="slider_right"></span>
        </div>    
    </div>
<!--     <div id="login"> -->
<%-- 	   <a href="${pageContext.request.contextPath}/front_end/membercentre/membercentre.jsp">會員修改</a> --%>
<%-- 	   <input type = "text" value="${memberVO.member_ID}"> --%>
<!--     </div> -->
	    <script type="text/javascript">
    
        //輪播圖
        var curIndex=0;//初始化
        var img_number = document.getElementsByClassName('tabImg').length;
        var _timer = setInterval(runFn,5000);//5秒
        function runFn(){ //運行定時器         
            curIndex = ++curIndex == img_number ? 0 : curIndex;//演算法 4為banner圖片數量
            slideTo(curIndex);
         }
         
         //圓點點擊切換輪播圖
         window.onload = function  () {    //為按鈕初始化onclick事件
            var tbs = document.getElementsByClassName("tabBtn");
            for(var i=0;i<tbs.length;i++){
                tbs[i].onclick = function  () {
                    clearInterval(_timer);//細節處理，關閉定時，防止點切圖和定時器函數衝突
                    slideTo(this.attributes['num'].value);
                    curIndex = this.attributes['num'].value
                    _timer = setInterval(runFn,2000);//點擊事件處理完成，繼續開啟定時輪播
                }
            }
        }
    
        var prve = document.getElementsByClassName("prve");
        prve[0].onclick = function () {//上一張
            clearInterval(_timer);//細節處理，關閉定時，防止點切圖和定時器函數衝突
            curIndex--;
            if(curIndex == -1){
                curIndex = img_number-1;
            }
            slideTo(curIndex);
            _timer = setInterval(runFn,2000);//點擊事件處理完成，繼續開啟定時輪播
        }
        
        var next = document.getElementsByClassName("next");
        next[0].onclick = function () {//下一張
            clearInterval(_timer);//細節處理，關閉定時，防止點切圖和定時器函數衝突
            curIndex++;
            if(curIndex == img_number){
                curIndex =0;
            }
            slideTo(curIndex);
            _timer = setInterval(runFn,2000);//點擊事件處理完成，繼續開啟定時輪播
        }
        
        //切換banner圖片 和 按鈕樣式
        function slideTo(index){
            console.log(index)
            var index = parseInt(index);//轉int類型
            var images = document.getElementsByClassName('tabImg');
            for(var i=0;i<images.length;i++){//遍歷每個圖片
                if( i == index ){
                    images[i].style.display = 'inline';//顯示            
                }else{
                    images[i].style.display = 'none';//隱藏
                }
            }
            var tabBtn = document.getElementsByClassName('tabBtn');
            for(var j=0;j<tabBtn.length;j++){//遍歷每個按鈕
                if( j == index ){
                    tabBtn[j].classList.add("hover");    //添加輪播按鈕hover樣式
                    curIndex=j;
                }else{
                    tabBtn[j].classList.remove("hover");//去除輪播按鈕hover樣式
                }
            }
            
        }
        
    </script>

 <div style="padding:500px 100px;">

內容放在這裡




  </div>
  <!--客服圖 請自行加連結-->
  <img class="cs" src="<%=request.getContextPath()%>/front_end/index/images/demo/cs.png" height="50px;" width="60px;" href="#"></img>

  <!-- Copyright -->
  <div class="wrapper row2">
    <footer id="copyright" class="clear">
      <p class="fl_left">Copyright &copy; 2022 - All Rights Reserved <a href="#"></a></p>
    </footer>
  </div>

</body>

</html>