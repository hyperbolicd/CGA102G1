<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/login/css/login.css">
      
  <title>HireMe</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/front_end/css/layout.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
   <jsp:include page="/front_end/header.jsp" />
   
    </head>
    <body>
    
        <div class="center">
            <h1>Login</h1>
            <form method="post" ACTION="${pageContext.request.contextPath}/member.do">
            <div class="txt_field">
<!--                 <input type="text" required> -->
                <input type="email" id="email" name="email" required>
                <span></span>
                <label>Email</label>
            </div>
            <div class="txt_field">
                <input type="password" id="password" name="password" required>
                <span></span>
                <label>Password</label>
            </div>
            <div class="pass">Forgot Password?</div>
            <input type="submit" value="Login">
            <div class="signup_link">
                沒有帳號?<a href="${pageContext.request.contextPath}/front_end/register/register.jsp">註冊</a>

            </div>
            <input type="hidden" name="action" value="login">
            </form>

        </div>
       		
    </body>
</html>
