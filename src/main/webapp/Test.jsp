<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ page import="com.emp_account.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/PhotoString" method="post" enctype="multipart/form-data">
	<input type="file" name="photo">
	<br>
	<label>File Name:</label>
	<input name="fileName">
	<br>
	<button type="submit">送出</button>
</form>

</body>
</html>