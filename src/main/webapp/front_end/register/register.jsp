<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">

<head>
  <meta charset="UTF-8">
  <!---<title> Responsive Registration Form | CodingLab </title>--->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/register/css/register.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">	
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

  
  <script type="text/javascript">

      function checkRegister() {
        var memberName = $("#memberName").val();
        var memberEmail = $("#memberEmail").val();
        var memberPhone = $("#memberPhone").val();
        var memberPassword = $("#memberPassword").val();
        var memberAddress = $("#memberAddress").val();
        var memberPassword2 = $("#memberPassword2").val();
        // if(memberName == "" || memberEmail == "" || memberPhone == "" || memberPassword == "" || memberAddress == "" || memberPassword2 == ""){
        //   alert("基本資料填寫未完整");
        // }
        var str  = '';
        if(memberName == "" ){
         str+="尚未填寫會員名稱,";
        }
        if(memberPhone == "" ){
          str+="尚未填寫電話,";
        }
        if(memberAddress == "" ){
          str+="尚未填寫地址,";
        }
        if(memberPassword != memberPassword2){
          str+="兩次輸入的密碼不一致！";
        }

        if (str !=="")
        alert(str);      
      }  
      
      
  </script>
</head>


<body>
  <div class="container" name="register" id="register">
    <div class="title">註冊</div>
    <div class="content">
      <form method="post" ACTION="${pageContext.request.contextPath}/member.do"enctype="multipart/form-data">
        <div class="user-details">
          <div class="input-box">
            <span class="username">會員名稱</span>  
            <div class="${errorMsgs.memberName}"></div>
            <input type="text" placeholder="請輸入您的使用者名稱" id="member_Name" name="member_Name" >
         	
          </div>
          
          <div class="input-box">
            <span class="email">電子信箱</span>
            <div class="errMsgs" vlaue="{param.member_Email}"></div>
            <input type="text" placeholder="請輸入您的電子信箱" id="member_Email" name="member_Email" >
          </div>
          
          <div class="input-box">
            <span class="phone">會員電話</span>
            <div class="errMsgs"></div>
            <input type="text" placeholder="請輸入您的會員電話" id="member_Phone" name="member_Phone">
          </div>
          
          <div class="input-box">
            <span class="password">會員密碼</span>
            <div class="errMsgs"></div>
            <input type="password" placeholder="請輸入您的密碼" id="member_Password" name="member_Password" >
          </div>


          <div class="input-box">
            <span class="address">會員地址</span>
            <div class="errMsgs"></div>
            <input type="text" placeholder="請輸入您的會員地址" id="member_Address" name="member_Address">
          </div>

          <div class="input-box">
            <span class="details">再次確認密碼</span>
            <div class="errMsgs"></div>
            <input type="password" placeholder="再次確認密碼" id="member_Password2" name="member_Password2" >
          </div>



          <div class="input">
            <span class="details">會員照片</span>
            <div class="errMsgs"></div>
            <input type="file" id="file-uploader" name="myUpfile">
          </div>

        </div>
        
        <div class="button">
          <input type="submit" id="" value="註冊" onclick="checkRegister();">
          <input type="hidden" name="action" value="insert">
        </div>
      </form>
    </div>
  </div>

</body>

</html>