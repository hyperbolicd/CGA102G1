<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.showing.model.*"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="com.cmt.model.*"%>

<%
  ShowingVO showingVO = (ShowingVO) request.getAttribute("showingVO"); //ShowingServlet.java(Controller), 存入req的showingVO物件
  MovieVO movieVO = (MovieVO) request.getAttribute("movieVO"); 
  CmtVO cmtVO = (CmtVO) request.getAttribute("cmtVO"); 
%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>劇場版 咒術迴戰 0</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="styles/layout.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
  <script src="<%=request.getContextPath()%>/front_end/movieDetail/js/bootstrap.js"></script>
  <script src="<%=request.getContextPath()%>/front_end/movieDetail/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/movieDetail/css/movie_detail.css">

<!-- icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
          <a href="#">會員註冊</a>
          <a href="#">查看票夾</a>
          <a href="#">查看評論</a>
          <a href="#">許願池</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">最新消息</button>
        <div class="dropdown-content">
          <a href="#">影城公告</a>
          <a href="#">影城好康</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">電影資訊</button>
        <!-- <a href="#"></a>
        <a href="#"></a> 下拉選單-->
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
        <button class="dropbtn">商城</button>
        <!-- <a href="#"></a>
        <a href="#"></a> 下拉選單-->
      </div>

      <div class="dropdown">
        <button class="dropbtn">Q & A專區</button>
        <div class="dropdown-content">
          <a href="#">常見問題</a>
          <a href="#">聯絡我們</a>
        </div>
      </div>

    </header>
  </div>

  <!-- 內容 -->
  			<jsp:useBean id="showingSvc" scope="page" class="com.showing.model.ShowingService" />
			<jsp:useBean id="movieSvc" scope="page" class="com.movie.model.MovieService" />
			<jsp:useBean id="cmtSvc" scope="page" class="com.cmt.model.CmtService" />
  
  <div id="movie_detail_main" style='padding:50px 100px; color:#979797; background-color:black;'>
    <div id="movie">
      <div id="movie_img">
        <div id="pic">
          <img src="./images/demo/movie0.jpg" alt="">
        </div>
      </div>
      <div id="movie_detail_1">
        <div id="movie_title">
          <span>劇場版 咒術迴戰 0</span>
        </div><br>
        <span class="whiteBg" id="movie_title_eng">JUJUTSU KAISEN:ZERO</span><br>
        <span class="whiteBg" id="movie_time">01:45:00</span><br>
        <span class="whiteBg" id="movie_level">輔導級12歲</span><br>
        <span class="whiteBg" id="movie_type">動畫</span><br>
        <span class="whiteBg" id="movie_cast">緒方惠美、小松未可子、內山昂輝、關智一</span><br>
        <div id="movie_detail_2" class="whiteBg">
          <p id="movie_dt">故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚故事敘述一對青梅竹馬的戀人：乙骨憂太與祈本里香原本約定好長大以後要結婚</p>
        </div>
      </div>
    </div>
    <div id="booking">
      <div id="date">
        <select name="" id="dateSelector" class="picker toRed">
          <!-- inject date -->
        </select>
      </div>
      <div id="time">
        <select name="" id="showingTime" class="picker toRed" >
          <option value="">--:--</option>
          <option value="">08:00</option>
          <option value="">11:00</option>
          <option value="">14:00</option>
          <option value="">17:00</option>
          <option value="">20:00</option>
          <option value="">23:00</option>
        </select>
      </div>
      <div id="book">
        <button id="bookBtn">BOOKING!</button>
      </div>
    </div>
    <div id="comment">
      <div id="cmt_info" value="0">
        <div id="cmt_title">
          <span>COMMENTS</span>
        </div>
        <div id="cmt_avg">
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span>(232則評論)</span>
        </div>
        <div id="cmt_open">
          <span class="fa fa-plus" ></span>
        </div>
      </div>
      <div class="cmt">
        <div class="member">
          <div class="member_pic">
            <img src="./images/test0001.jpg" alt="">
          </div>
          <div class="member_name">
            <div class="member_nickname">
              <span>野獣先輩</span>
            </div>
            <div class="member_id">
              <span>test0001</span>
          </div>
          </div>
        </div>
        <div class="cmt_detail">
          <div class="cmt_text whiteBg" value="0">
            潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ潮好看ㄉ
          </div>
          <hr>
          <div class="cmt_like">
            <span class="fa fa-heart like" >111</span>
          </div>
          <div class="cmt_date">
            <span>2022-05-27 11:29:32</span>
          </div>
        </div>
        <div class="cmt_star">
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
        </div>
      </div>
      <div class="cmt">
        <div class="member">
          <div class="member_pic">
            <img src="./images/test0002.jpg" alt="">
          </div>
          <div class="member_name">
            <div class="member_nickname">
              <span>里香</span>
            </div>
            <div class="member_id">
              <span>test0002</span>
          </div>
          </div>
        </div>
        <div class="cmt_detail">
          <div class="cmt_text whiteBg" value="3">
            憂太、喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡喜歡！
          </div>
          <hr>
          <div class="cmt_like">
            <span class="fa fa-heart like" >99</span>
          </div>
          <div class="cmt_date">
            <span>2022-05-27 11:29:32</span>
          </div>
        </div>
        <div class="cmt_star">
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
        </div>
      </div>
      <div class="cmt">
        <div class="member">
          <div class="member_pic">
            <img src="./images/test0004.jpg" alt="">
          </div>
          <div class="member_name">
            <div class="member_nickname">
              <span>夏油傑</span>
            </div>
            <div class="member_id">
              <span>test0004</span>
          </div>
          </div>
        </div>
        <div class="cmt_detail">
          <div class="cmt_text whiteBg neta" value="1">
            我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔我會領便當喔
          </div>
          <hr>
          <div class="cmt_like">
            <span class="fa fa-heart like" >0</span>
          </div>
          <div class="cmt_date">
            <span>2022-05-27 11:29:32</span>
          </div>
        </div>
        <div class="cmt_star">
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
          <span class="fa fa-star" ></span>
        </div>
      </div>
    </div>
    <div id="newCmt">
      <div class="member">
        <div class="member_pic">
          <img id="thisMemPic" src="./images/test0003.jpg" alt="">
        </div>
        <div class="member_name">
          <div class="member_nickname">
            <span id="thisMemNickname">乙骨憂太</span>
          </div>
          <div class="member_id">
            <span id="thisMemId">test0003</span>
        </div>
        </div>
      </div>
      <div class="cmt_detail">
        <div class="cmt_text">
          <textarea name="" id=""></textarea>
        </div>
        <hr>
        <div id="conf">
          <div class="cmtBtnArea">    
              <p>comment</p>   
          </div>
          <div id="netaArea">
            <div>評論是否劇透</div>
            <input type="checkbox" name="" id="netabare">
          </div>
        </div>
      </div>
      <div class="cmt_star">
        <div class="rating-box">
          <span class="rating-boxH1">Rating</span>
          <div class="rating">
            <span class="fa fa-star-o" ></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>
            <span class="fa fa-star-o"></span>     
          </div>
          <!-- <h4 id="rating-value"></h1> -->
        </div>
      </div>
    </div>
  


  </div>


  <!--客服圖 請自行加連結-->
  <img class="cs" src="<%=request.getContextPath()%>/front_end/movieDetail/images/demo/cs.png" height="50px;" width="60px;" href="#"></img>

  <!-- Copyright -->
  <div class="wrapper row2">
    <footer id="copyright" class="clear">
      <p class="fl_left">Copyright &copy; 2022 - All Rights Reserved <a href="#"></a></p>
    </footer>
  </div>
  
  <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $("#date button").click(function(){
      if($(this).attr("class") == ""){
        $(this).attr("class", "clicked")
      }else{
        $(this).attr("class", "")
      }
    })
    

  </script>
  <script src="<%=request.getContextPath()%>/front_end/movieDetail//js/movie_detail.js"></script>
  <!-- rating system -->
  <script src="<%=request.getContextPath()%>/front_end/movieDetail//js/rating.js"></script>
  
  
          <!-- 加載Ajax -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        <!-- Ajax的測試Script -->
         <script>
             //在網頁加載後，對id=doAjaxBtn的Button設定click的function
            $(document).ready(function(){ 
            	let url = "${pageContext.request.contextPath}/showing/showing.do?action=getShowingByDate&SH_TIME=" + SH_TIME1;
               $("#dateSelector").change(function(){
                   $.ajax({ 
                        type:"POST",                    //指定http參數傳輸格式為POST
                        url: "url",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                        dataType: "json",             
                        async: false,
                        success : function(response){
                            $("#showingTime").append("<option>" + reponse.SH_TIME + "</option>");
                        },
                        //Ajax失敗後要執行的function，此例為印出錯誤訊息
                        error:function(xhr, ajaxOptions, thrownError){
                            alert(xhr.status+"\n"+thrownError);
                        }
                    });
               });
            });  
             
            if("getShowingByDate".equals(action)) {
                String SH_TIME = Integer.valueOf(req.getParameter("SH_TIME"));
                ShowingService showingSvc = new ShowingService();
                ShowingVO showingVO = showingSvc.getShowingByDate(SH_TIME);
                PrintWriter out = res.getWriter();
                Gson gson = new Gson();
                out.print(gson.toJson(showingVO));
               }
 
        </script>
  
</body>

</html>