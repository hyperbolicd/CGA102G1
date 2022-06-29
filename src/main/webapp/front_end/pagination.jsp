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
  <!-- �m�����s -->
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

        <button class="dropbtn">�|���M��</button>
        <div class="dropdown-content">
          <a href="#">�|���n�J</a>
          <a href="#">�|������</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">���ʤ��i</button>
        <div class="dropdown-content">
          <a href="#">�v�����i</a>
          <a href="#">�v���n�d</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">Q & A�M��</button>
        <div class="dropdown-content">
          <a href="#">�`�����D</a>
          <a href="#">�ȪA�H�c</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">�v���M��</button>
        <div class="dropdown-content">
          <a href="#">�v������</a>
          <a href="#">�v���a�I</a>
          <a href="#">������T</a>
          <a href="#">�\����T</a>
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">�q�v��T</button>
        <div class="dropdown-content">
        </div>
      </div>

      <div class="dropdown">
        <button class="dropbtn">�ӫ��ʪ�</button>
        <div class="dropdown-content">
          <a href="#">�ӫ~�s��</a>
          <a href="#">�ʶR�h�f</a>
        </div>
      </div>

    </header>
  </div>

    
    
    

 <div style="padding:500px 100px;">

���e��b�o��




  </div>
  <!--�ȪA�� �Цۦ�[�s��-->
  <img class="cs" src="images/demo/cs.png" height="50px;" width="60px;" href="#"></img>

  <!-- Copyright -->
  <div class="wrapper row2">
    <footer id="copyright" class="clear">
      <p class="fl_left">Copyright &copy; 2022 - All Rights Reserved <a href="#"></a></p>
    </footer>
  </div>

</body>

</html>