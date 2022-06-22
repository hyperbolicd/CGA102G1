<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>員工登入系統</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emplogin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">
</head>

<body>
    <main>
        <div id="login">
            <h1>員工登入系統</h1>
            <form action="${pageContext.request.contextPath}/EmpLogin" method="post">
                <input type="text" id="empNameLG" name="loginId" placeholder="請輸入編號">
                <br>
                <input type="password" id="empPasswordLG" name="loginPassword" placeholder="請輸入密碼">
                <div>
                    <button type="submit" id="loginbtn" name="action" value="login">登入</button>
                </div>
            </form>
        </div>
    </main>
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
    <script src="${pageContext.request.contextPath}/back_end/css/emplogin.js"></script>
</body>
</html>