<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增許願活動</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/wish/css/newWish.css">
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
            <h1>新增許願活動</h1>
            <form action="">
                <button type="submit" name="action" value="addWish" id="addWish">新增活動</button>
                <button type="button" id="return"><a href="${pageContext.request.contextPath}/back_end/wish/wishPond.jsp">返回</a></button>
                <h2>活動資訊</h2>
                <div id="event">
                    <label for="eventNo">活動編號: </label>
                    <input type="text" id="eventNo" value="3" disabled>
                    <br>
                    <label for="eventName">活動名稱: </label>
                    <input type="text" id="eventName">
                    <br>
                    <label for="startDate">活動日期: </label>
                    <input id="startDate"> ~ <input id="endDate">
                </div>
                <h2>選擇電影</h2>
                <div id="multiSearch">
                    <label for="level">分級:</label>
                    <select name="level" id="level">
                        <option value="0">請選擇</option>
                        <option value="1">普遍級</option>
                        <option value="2">保護級</option>
                        <option value="3">輔導級</option>
                        <option value="4">限制級</option>
                    </select>
                    <label for="type">類型:</label>
                    <select name="type" id="type">
                        <option value="0">請選擇</option>
                        <option value="動畫">動畫</option>
                        <option value="奇幻">奇幻</option>
                        <option value="動作">動作</option>
                        <option value="科幻">科幻</option>
                        <option value="劇情">劇情</option>
                    </select>
                    <label for="keyword">關鍵字:</label>
                    <input id="keyword">
                    <button id="select">篩選</button>
                    <button id="selectAll">顯示全部</button>
                </div>
                <div id="movies">
                    <!-- <div class="movie">
                        <input type="checkbox" name="checkMovie" id="kai" onclick="colorChange(this)">
                        <label for="kai">
                            <div class="inner">
                                <h3>劇場版 咒術迴戰 0</h3>
                                <img src="images/1.jpg" alt=""><br> 類型: 動畫<br> 分級: 普遍級
                            </div>
                        </label>
                    </div> -->
                </div>
            </form>
        </div>
    </main>
    <!-- <div id="tree"></div> -->
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
    <script src="${pageContext.request.contextPath}/back_end/wish/js/newWish.js"></script>
</body>
</html>