<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>許願池管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/wish/css/wishPond.css">
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
            <h1>許願池管理</h1>
            <button id="newWish"><a href="${pageContext.request.contextPath}/back_end/wish/newWish.jsp">新增</a></button>
            <div id="multiSearch">
                <form action="">
                    <label for="searchId">編號: </label>
                    <select name="" id="searchId">
                        <option value="0"></option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                    <label for="searchName">名稱: </label>
                    <select name="" id="searchName">
                        <option value="0"></option>
                        <option value="1">母親節特選</option>
                        <option value="2">端午節特選</option>
                    </select>
                    <button>搜尋</button>
                    <button>顯示全部</button>
                </form>
            </div>
            <div id="wishList">
                <table>
                    <tr>
                        <th>編號</th>
                        <th>名稱</th>
                        <th>起始時間</th>
                        <th>結束時間</th>
                        <th>冠軍</th>
                        <th>查看詳情</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>母親節特選</td>
                        <td>2022-05-01</td>
                        <td>2022-05-31</td>
                        <td>XXXXX</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/back_end/wish/wishDetail.jsp"><img src="${pageContext.request.contextPath}/back_end/wish/icons8-detail-64.png" alt=""></a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>端午節特選</td>
                        <td>2022-06-01</td>
                        <td>2022-06-30</td>
                        <td>尚未結束</td>
                        <td>
                            <a href="#"><img src="${pageContext.request.contextPath}/back_end/wish/icons8-detail-64.png" alt=""></a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </main>
    <!-- <div id="tree"></div> -->
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
    <script src="emp_aside.js"></script>
</body>
</html>