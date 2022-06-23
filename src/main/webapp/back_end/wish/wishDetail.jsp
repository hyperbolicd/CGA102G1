<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>許願池</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/wish/css/wishDetail.css">
</head>

<body>
    <header>
        <%@ include file="/back_end/header_html.jsp"%>   
    </header>
    <aside id="aside">     
    	<%@ include file="/back_end/aside_html.jsp"%>   
    </aside>
    <!-- 你們的內容請放在 <main> 標籤內，其他部分勿動! -->
    <main>
        <div id="main">
            <h1>許願池 - 母親節特選</h1>
            <button id="return"><a href="${pageContext.request.contextPath}/back_end/wish/wishPond.jsp">返回</a></button>
            <h2>投票結果</h2>
            <div id="vote">

            </div>
            <h2>許願訊息</h2>
            <div id="message">
                <table>
                    <tr>
                        <th>會員編號</th>
                        <th>訊息</th>
                    </tr>
                </table>
            </div>
        </div>

    </main>
    <!-- <div id="tree"></div> -->
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
    <script src="${pageContext.request.contextPath}/back_end/wish/js/wishDetail.js"></script>
</body>
</html>