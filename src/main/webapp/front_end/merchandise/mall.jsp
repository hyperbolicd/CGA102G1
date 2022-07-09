<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<base target="_parent">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- price range -->
<!--Plugin CSS file with desired skin-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css" />
<!--jQuery-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--Plugin JavaScript file-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/merchandise/css/mall.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/front_end/css/layout.css" type="text/css">

</head>

<body>

	<!-- 使用 checkbox 來做開關 -->
	<input type="checkbox" name="" id="sideMenu-active">
	<div class="sideMenu">
		<!-- <form>
            <input type="search" placeholder="請輸入搜尋名稱">
            <button><i class="fas fa-search"></i></button>
        </form> -->
		<nav>
			<a href="#" class="home"><i class="fas"></i>首頁</a> <a href="#"
				class="pages" id="pg1-home"><i class="fas"></i>模型</a> <a href="#"
				class="pages" id="pg2-home"><i class="fas"></i>抱枕</a> <a href="#"
				class="pages" id="pg3-home"><i class="fas"></i>生活用品</a> <a href="#"
				class="pages" id="pg4-home"><i class="fas"></i>服飾</a> <a href="#"
				class="pages" id="pg5-home"><i class="fas"></i>文具</a>
		</nav>
		<label for="sideMenu-active"> <i class="fas fa-angle-right"></i>
		</label>
		<!-- label 寫在 nav 下方是為了比較好看到 -->
	</div>



	<div class="mainDiv">

		<div class="searchBox">
			<form action="" id="form1">
				<input type="text" placeholder="請輸入搜尋名稱" name="search">
				<input type="hidden" name="min" value="0" id="inputmin">
				<input type="hidden" name="max" value="100000" id="inputmax">
				<input type="hidden" name="action" value="getSearchList">
				<button id="searchbutton" type="button">
					<i class="fas fa-search"></i>
				</button>
			</form>
			<div class="topSearch">
				<span>模型</span> <span>公仔公仔公仔公仔</span> <span>模型模型</span> <span>轉蛋轉蛋轉蛋轉蛋轉蛋轉蛋轉蛋轉蛋</span>
				<span>模型</span>
			</div>
			<div class="filter">
				<input type="text" class="js-range-slider" name="my_range" value=""
					form="form1" />
			</div>
		</div>

		<!-- 主頁熱門商品的div(有分頁) -->
		<div class="mytabs">
			<input type="radio" name="mytabs" id="tab1" checked="checked">
			<label for="tab1">主打商品</label>
			<div class="tab">
				<div class="gallery gallery1">
				 <jsp:useBean id="merchSvc" class="com.merchandise_inf.model.MerchService"/>
					<c:forEach var="merchVo" items="${merchSvc.hotSell}">
					<div class="content">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6>$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
					

				</div>
			</div>

			<input type="radio" name="mytabs" id="tab2"> <label
				for="tab2">最新上架</label>
			<div class="tab">
				<div class="gallery gallery1">

					<c:forEach var="merchVo" items="${merchSvc.newest}">
					<div class="content">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6>$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
				</div>
			</div>

			<input type="radio" name="mytabs" id="tab3"> <label
				for="tab3">銷售熱門</label>
			<div class="tab">
				<div class="gallery gallery1">

					<c:forEach var="merchVo" items="${merchSvc.mostSold}">
					<div class="content">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6>$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
					</div>
			</div>

		</div>

		<!-- 側邊欄各自的div -->
		<div class="pg" id="pg1">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery">

					<c:forEach var="merchVo" items="${merchSvc.getByClass('模型')}">
					<div class="content merchpricediv">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6 class="merchprice">$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>

				</div>
			</div>

		</div>
		<div class="pg" id="pg2">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery">

					<c:forEach var="merchVo" items="${merchSvc.getByClass('抱枕')}">
					<div class="content merchpricediv">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6 class="merchprice">$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="pg" id="pg3">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery">

					<c:forEach var="merchVo" items="${merchSvc.getByClass('生活用品')}">
					<div class="content merchpricediv">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6 class="merchprice">$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="pg" id="pg4">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery">

					<c:forEach var="merchVo" items="${merchSvc.getByClass('服飾')}">
					<div class="content merchpricediv">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6 class="merchprice">$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="pg" id="pg5">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery">

					<c:forEach var="merchVo" items="${merchSvc.getByClass('文具')}">
					<div class="content merchpricediv">
						<a href="${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=${merchVo.merchID}"> <img
							src="${pageContext.request.contextPath}/merch/controller?action=getPic&merchID=${merchVo.merchID}&pic=1">
							<h3>${merchVo.merchName}</h3>
							<p>${merchVo.merchDT}</p>
							<h6 class="merchprice">$${merchVo.merchPrice}</h6></a> <a href="https://www.google.com.tw"><button
								class="buy-1">buy now</button></a>
					</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="pg" id="pg6">
			<!-- 點側邊欄顯示全商品卡片 -->
			<div class="tab">
				<div class="gallery" id="searchdiv">
				
				</div>
			</div>

		</div>








	</div>


	<!-- jquery -->
	<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->


	<!-- price range -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/front_end/merchandise/javascript/mall.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/front_end/merchandise/javascript/price_range_script.js"></script>
	<script>
		//-----JS for Price Range slider----
// 		$(".js-range-slider").ionRangeSlider({
// 			onFinish : function(data) {
// 				console.log(data.from);
				
// 				console.log(data.to);
// 			},
// 			type : "double",
// 			min : 0,
// 			max : 100000,
// 			from : 0,
// 			to : 10000,
// 			grid : true,
// 			step : 100
// 		});
		//主打商品 最新上架 銷售熱門
        let tab = document.getElementsByClassName('tab');
		let gallerys = document.getElementsByClassName('gallery1');
		//商品卡片價格位子與對應DIV
		let merchprice = document.getElementsByClassName('merchprice');
		let merchpricediv = document.getElementsByClassName('merchpricediv');
		//表單標籤
		let inputmin = document.getElementById('inputmin');
		let inputmax = document.getElementById('inputmax');
		//搜尋DIV
		let searchdiv = document.getElementById('searchdiv');
        $(".js-range-slider").ionRangeSlider({
            onFinish: function (price) {
            	//最大最小值轉數字
            		let min = parseInt(price.from);
            		let max = parseInt(price.to)
            	//表單標籤變更
            		inputmin.value = price.from;
            		inputmax.value = price.to;
            	//變更各分類使其符合價格區間	
            	for(let i = 0; i < merchprice.length; i++){
            	    merchpricediv[i].style.display = '';
            		let prices = parseInt(merchprice[i].textContent.slice(1));
            		if(prices < min || prices > max){
            			merchpricediv[i].style.display = 'none';
            		}
					
            	}
            	//重新長出 主打商品 最新上架 熱門銷售
                for (let i = 0; i < gallerys.length; i++) {
                    gallerys[i].remove();
                    let gallery = document.createElement('div');
                    gallery.classList.add('gallery','gallery1');
                    tab[i].append(gallery);
                    $.ajax({
                        url:'/CGA102G1/merch/controller',
                        type: 'post',
                        dataType: 'json',
//                         contentType:'application/json; charset=UTF-8',
                        data: { 'action': 'changePrice', 'min': JSON.stringify(price.from), 'max': JSON.stringify(price.to), 'index':JSON.stringify(i)},
                        success: function (res) {
                        	console.log(res);
                            for(let item of res){
                                let content = document.createElement('div');
                                content.className = "content";
                                let a1 = document.createElement('a');
                                a1.href = "${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=" + item.merchID;
                                let img = document.createElement('img');
                                img.src = "${pageContext.request.contextPath}/merch/controller?action=getPic&merchID="+item.merchID+"&pic=1";
                                let h3 = document.createElement('A3');
                                h3.textContent = item.merchName;
                                let p = document.createElement('p');
                                p.innerHTML = item.merchDT;
                                let h6 = document.createElement('h6');
                                h6.textContent = '$' + item.merchPrice;
                                a1.append(img);
                                a1.append(h3);
                                a1.append(p);
                                a1.append(h6);
                                let a2 = document.createElement('a');
                                a2.href = "https://www.google.com.tw";
                                let button = document.createElement('button');
                                button.className = "buy-1";
                                button.textContent="加入購物車"
                                a2.append(button);
                                content.append(a1);
                                content.append(a2);
                                gallery.append(content);
                                tab[i].append(gallery);
                            }

                        },
                    })
                }
            },
            type: "double",
            min: 0,
            max: 100000,
            from: 0,
            to: 10000,
            grid: true,
            step: 100,
        });
        //監聽表單送出按鈕
        let searchbutton = document.getElementById('searchbutton');
        searchbutton.addEventListener('click',function(){
        	 let passFrom = document.getElementById("form1");
             let pform = new FormData(passFrom);
             
             $.ajax({
                 type: "POST",
                 url: "/CGA102G1/merch/controller",
                 data: pform,
                 dataType : 'json',
                 contentType: false,//must, tell jQuery not to process the data
                 processData: false,
                 async : false,
                 success: function (res) {
                    	 searchdiv.innerHTML = "";
                     for(let item of res){
                         let content = document.createElement('div');
                         content.classList.add('content','merchpricediv');
                         let a1 = document.createElement('a');
                         a1.href = "${pageContext.request.contextPath}/merch/controller?action=getMerchInfo&merchID=" + item.merchID;
                         let img = document.createElement('img');
                         img.src = "${pageContext.request.contextPath}/merch/controller?action=getPic&merchID="+item.merchID+"&pic=1";
                         let h3 = document.createElement('A3');
                         h3.textContent = item.merchName;
                         let p = document.createElement('p');
                         p.innerHTML = item.merchDT;
                         let h6 = document.createElement('h6');
                         h6.className = 'merchprice';
                         h6.textContent = '$' + item.merchPrice;
                         a1.append(img);
                         a1.append(h3);
                         a1.append(p);
                         a1.append(h6);
                         let a2 = document.createElement('a');
                         a2.href = "https://www.google.com.tw";
                         let button = document.createElement('button');
                         button.className = "buy-1";
                         button.textContent="加入購物車"
                         a2.append(button);
                         content.append(a1);
                         content.append(a2);
                         searchdiv.append(content);
                     }

                 }
                          
                        	 
                        
                    
        })
        $(".mytabs").hide();
             $(".pg").hide();
             $("#pg6").show(500);
        })
        
	</script>
</body>

</html>