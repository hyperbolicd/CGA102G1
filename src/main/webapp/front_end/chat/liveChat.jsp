<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>客服聊天</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/front_end/liveChat/liveChat.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="dialogue-wrapper">
		<div id="btn_open" class="dialogue-support-btn">
			<i class="dialogue-support-icon"></i> <i
				class="dialogue-support-line"></i> <span
				class="dialogue-support-text">聯繫客服</span>
		</div>
		<div class="dialogue-main">
			<div class="dialogue-header">
				<i id="btn_close" class="dialogue-close">></i>
				<div class="dialogue-service-info">
					<i class="dialogue-service-img">頭像</i>
					<div class="dialogue-service-title">
						<p class="dialogue-service-name">XX客服</p>
						<p class="dialogue-service-detail">XX客服支援平臺</p>
					</div>
				</div>
			</div>
			<div id="dialogue_contain" class="dialogue-contain">
				<p class="dialogue-service-contain">
					<span class="dialogue-text dialogue-service-text">您好，請提問</span>
				</p>
				<!-- <p class="dialogue-customer-contain"><span class="dialogue-text dialogue-customer-text">我有個問題</span></p> -->
			</div>
			<div class="dialogue-submit">
				<p id="dialogue_hint" class="dialogue-hint">
					<span class="dialogue-hint-icon">!</span><span
						class="dialogue-hint-text">發送內容不能為空</span>
				</p>
				<textarea id="dialogue_input" class="dialogue-input-text"
					placeholder="請輸入您的問題，按Enter鍵提交（shift+Enter換行）"></textarea>
				<div class="dialogue-input-tools">小工具預留位置</div>
			</div>
		</div>
	</div>
	<script>
    var doc = document;
    // 類比一些後端傳輸資料
    var serviceData = {
        'robot': {
            'name': 'robot001',
            'dialogue': ['模擬回復1', '模擬回復2', '模擬回復3'],
            'welcome': '您好，robot001為您服務'
        }
    };

    var dialogueInput = doc.getElementById('dialogue_input'),
        dialogueContain = doc.getElementById('dialogue_contain'),
        dialogueHint = doc.getElementById('dialogue_hint'),
        btnOpen = doc.getElementById('btn_open'),
        btnClose = doc.getElementById('btn_close'),
        timer,
        timerId,
        shiftKeyOn = false;  // 輔助判斷shift鍵是否按住

    btnOpen.addEventListener('click', function(e) {
        $('.dialogue-support-btn').css({'display': 'none'});
        $('.dialogue-main').css({'display': 'inline-block', 'height': '0'});
        $('.dialogue-main').animate({'height': '600px'})
    })

    btnClose.addEventListener('click', function(e) {
        $('.dialogue-main').animate({'height': '0'}, function() {
            $('.dialogue-main').css({'display': 'none'});
            $('.dialogue-support-btn').css({'display': 'inline-block'});
        });
    })

    dialogueInput.addEventListener('keydown', function(e) {
        var e = e || window.event;
        if (e.keyCode == 16) {
            shiftKeyOn = true;
        }
        if (shiftKeyOn) {
            return true;
        } else if (e.keyCode == 13 && dialogueInput.value == '') {
            // console.log('發送內容不能為空');
            // 多次觸發只執行最後一次漸隱
            setTimeout(function() {
                fadeIn(dialogueHint);
                clearTimeout(timerId)
                timer = setTimeout(function() {
                    fadeOut(dialogueHint)
                }, 2000);
            }, 10);
            timerId = timer;
            return true;
        } else if (e.keyCode == 13) {
            var nodeP = doc.createElement('p'),
                nodeSpan = doc.createElement('span');
            nodeP.classList.add('dialogue-customer-contain');
            nodeSpan.classList.add('dialogue-text', 'dialogue-customer-text');
            nodeSpan.innerHTML = dialogueInput.value;
            nodeP.appendChild(nodeSpan);
            dialogueContain.appendChild(nodeP);
            dialogueContain.scrollTop = dialogueContain.scrollHeight;
            submitCustomerText(dialogueInput.value);
        }
    });

    dialogueInput.addEventListener('keyup', function(e) {
        var e = e || window.event;
        if (e.keyCode == 16) {
            shiftKeyOn = false;
            return true;
        }
        if (!shiftKeyOn && e.keyCode == 13) {
            dialogueInput.value = null;
        }
    });

    function submitCustomerText(text) {
        console.log(text)
        // code here 向後端發送text內容

        // 模擬後端回復
        var num = Math.random() * 10;
        if (num <= 7) {
            getServiceText(serviceData);
        }
    }

    function getServiceText(data) {
        var serviceText = data.robot.dialogue,
            i = Math.floor(Math.random() * serviceText.length);
        var nodeP = doc.createElement('p'),
            nodeSpan = doc.createElement('span');
        nodeP.classList.add('dialogue-service-contain');
        nodeSpan.classList.add('dialogue-text', 'dialogue-service-text');
        nodeSpan.innerHTML = serviceText[i];
        nodeP.appendChild(nodeSpan);
        dialogueContain.appendChild(nodeP);
        dialogueContain.scrollTop = dialogueContain.scrollHeight;
    }

    // 漸隱
    function fadeOut(obj) {
        var n = 100;
        var time = setInterval(function() {
            if (n > 0) {
                n -= 10;
                obj.style.opacity = '0.' + n;
            } else if (n <= 30) {
                obj.style.opacity = '0';
                clearInterval(time);
            }
        }, 10);
        return true;
    }

    // 漸顯
    function fadeIn(obj) {
        var n = 30;
        var time = setInterval(function() {
            if (n < 90) {
                n += 10;
                obj.style.opacity = '0.' + n;
            } else if (n >= 80) {

                obj.style.opacity = '1';
                clearInterval(time);
            }
        }, 100);
        return true;
    }
</script>
</body>
</html>
