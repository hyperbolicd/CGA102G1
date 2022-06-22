<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.movie.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
MovieService mvSvc = new MovieService();
	 List<MovieVO> list = mvSvc.getAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>電影資訊管理</title>
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav>
            <div id="logo">
            	<img src="${pageContext.request.contextPath}/back_end/logo2noline.jpg">
            </div>
            <h2>員工後台操作系統</h2>
            <ul>
                <li>登出</li>
            </ul>
        </nav>
    </header>
    <aside id="aside">
    <%@ include file="/back_end/aside_html.jsp"%>         
    </aside>
    <!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
    <main>
        <div id="main">

            <div class="table_body" >
                <div class="btnbox" >
                    <a href="${pageContext.request.contextPath}/back_end/ManageMV/creatMV.jsp" class="btn btn-success"  >新增電影</a>
                </div>    
                <div class="container1">
                    <table class="table table-hover table-bordered single-ellipsis" id="table1">
                      <thead>
                        <tr>
                          <th>電影編號</th>
                          <th>電影名稱</th>
                          <th>電影英文名稱</th>
                          <th>片長</th>
                          <th>分級</th>
                          <th>類型</th>
                          <th>上映日</th>
                          <th>預計下檔日</th>
                          <th>操作區</th>
                        </tr>
                      </thead>
                      <tbody>
                      <%@ include file="page1.file" %> 
                      <c:forEach var="movieVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
                        <tr>
                          <td>${movieVO.mvId}</td>
                          <td>${movieVO.mvName}</td>
                          <td>${movieVO.mvEName}</td>
                          <td>${movieVO.mvLong}</td>
                      	<c:if test="${movieVO.mvLevel==0}">
                          <td>普遍級</td>
                      	</c:if> 
                      	<c:if test="${movieVO.mvLevel==1}">
                          <td>保護級</td>
                      	</c:if> 
                      	<c:if test="${movieVO.mvLevel==2}">
                          <td>輔導級(12)</td>
                      	</c:if> 
                      	<c:if test="${movieVO.mvLevel==3}">
                          <td>輔導級(15)</td>
                      	</c:if> 
                      	<c:if test="${movieVO.mvLevel==4}">
                          <td>限制級</td>
                      	</c:if> 
                          <td>${movieVO.mvType}</td>
                          <td>${movieVO.mvStDate}</td>
                          <td>${movieVO.mvEdDate}</td>
                          <td>
                          <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/MovieServlet.do">
			     				<input type="submit" value="查看/修改"  class="btn btn-primary">
			     				<input type="hidden" name="mvId"  value="${movieVO.mvId}">
			     				<input type="hidden" name="action"	value="getOne_For_Update">
			     			</FORM>
                          </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                    <%@ include file="page2.file" %>
                  </div>
            </div>
        </div>
    </main>
   
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
</body>

</html>