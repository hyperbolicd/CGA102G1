		
    	// 創建一陣列蒐集選中的座位物件
    	let selectedSeat = [];
    
   		function selectedBtn(){
        // 獲取座位的資訊
        let text =this.innerText;
        // 加進 目前已選
        if(selectedSeat.indexOf(this)===-1){
            document.getElementById('numberBox').innerText += '\n'+text  ;
            this.setAttribute('class','btn btn-outline-danger');
            // 利用bootstrap樣式改變 達到選取效果
            selectedSeat.push(this);  
        }
    }
		// 監聽連動下拉選單
		document.getElementById('datePick').addEventListener('change',selectDate);
		document.getElementById('showPick').addEventListener('change',selectTime);
		
		// 監聽改變狀態的按鈕
		document.getElementById('colorsample1').addEventListener('click',changeStatus)
    	document.getElementById('colorsample2').addEventListener('click',changeStatus)
    	document.getElementById('colorsample3').addEventListener('click',changeStatus)
    	document.getElementById('colorsample4').addEventListener('click',changeStatus)
    	
	// 監聽 日期的選單
	function selectDate (){
		
		// 獲取預存在頁面的hlId
		const hlId = document.getElementById('hlId').value;
		// 獲取USER選擇的日期
		let dateOption = this.value;
		
		const showPick=	document.getElementById('showPick');
		
		// 清空 showPick的option
		let child = showPick.lastElementChild;  
        while (child) { 
            showPick.removeChild(child); 
            child = showPick.lastElementChild; 
        } 
		
		$.ajax({
			url: '/CGA102G1/ShowSeatServlet.do',   // url位置
			type: 'post',                   // post/get
			data: { "action": "getTimeByDate",
					"dateOption" : dateOption,
					"hlId" : hlId },       // 輸入的資料
			error: function(xhr) { },      // 錯誤後執行的函數
			success: function(response) {
				
				// 把被清掉的 option放回去
				let option = document.createElement('option');
				option.innerText = "請選擇時段"
				showPick.append(option);
				
				for(let i =0 ; i < response.length ; i++){
					
					let showVO = response[i];
					// 轉換timestamp to 易讀的option
					let ShowTime = showVO.SH_TIME;
					let date = new Date(ShowTime);
					let timeOption =date.getHours()+"點"+date.getMinutes()+"分"
					let option = document.createElement('option');
					option.innerText = timeOption;
					option.value = showVO.SH_ID;
					
					showPick.append(option);
				}
			 }// 成功後要執行的函數
		});
	}
	
	// 監聽USER選擇的時段
	function selectTime(){
		// 獲取預存在頁面的hlId
		const hlId = document.getElementById('hlId').value;
		// 獲取USER選擇的時段(場次)
		let SH_ID = this.value;
		
		$.ajax({
			url: '/CGA102G1/ShowSeatServlet.do',   // url位置
			type: 'post',                   // post/get
			dataType:'json',
			data: {
				"action": "getShowByTime",
				"SH_ID": SH_ID,
				"hlId": hlId
			},       // 輸入的資料
			error: function(xhr) { },      // 錯誤後執行的函數
			success: function(response) {
				
				let showSeatVO = response.showSeatVO;
				let hallVO = response.hallVO;
				console.log('座位字串:'+showSeatVO.SH_SEAT_STATE);
				generateSeat(showSeatVO.SH_SEAT_STATE);
			}// 成功後要執行的函數
		});
	}
	
	// 動態生成座位
    function generateSeat(seatStr){
	
    // 獲取預覽區塊
    let prBox = document.getElementById("prBox");
	let seat=seatStr;
	// 清空prBox
	let child = prBox.lastElementChild;  
        while (child) { 
            prBox.removeChild(child); 
            child = prBox.lastElementChild; 
        } 
    // 調用JSP裡預藏的長跟寬
    let inputRow =document.getElementById('hlRow').value;
    let inputCol =document.getElementById('hlCol').value;
    console.log(inputRow);
    console.log(inputCol);
    // 配置索引值
    let seq =0;
    // 第一排第一個位置的狀態索引值必為4
    let seatIndex = 4;
    // 原始按鈕生成
    for(let row= 1 ; row <= inputRow ; row++){
        for(let col= 1 ; col <= inputCol ; col++){
            
            const btn = document.createElement('button');

            if(Number(seat[seatIndex]) ===0){
            btn.setAttribute('class',"btn btn-secondary");
			btn.setAttribute('disabled',"true");
			}
            if(Number(seat[seatIndex]) ===1)
            btn.setAttribute('class',"btn btn-success");
            if(Number(seat[seatIndex]) ===2){
            btn.setAttribute('class',"btn btn-primary");
			btn.setAttribute('disabled',"true");
			}
            if(Number(seat[seatIndex]) ===3)
            btn.setAttribute('class',"btn btn-warning");
            if(Number(seat[seatIndex]) ===4)
            btn.setAttribute('class',"btn btn-danger");

            btn.name ='seatBtn';
            btn.id=seq;
            // btn.id = `${row}排${col}號`;
            btn.style.fontSize = '10px';
            btn.style.color='white';
            btn.style.width='55px';
            btn.style.padding='5px 0px';
            btn.style.margin ='3px'
            btn.innerText=`${row}排${col}號`;

            btn.addEventListener('click',selectedBtn);
            
            // debug專用:檢查按鈕的底層索引值
            // btn.innerText=seq;
            
            prBox.append(btn);
            seatIndex += 5;
            seq++
           }
        const br = document.createElement("br");
        prBox.append(br);
    }
    // 顯示操作的介面
    document.getElementById('screen').style.display='block';
    document.getElementById('numberBox').style.display='block';
    document.getElementById('colorsample1').style.display='block';
    document.getElementById('colorsample5').style.display='block';
    document.getElementById('colorsample2').style.display='block';
    document.getElementById('colorsample3').style.display='block';
    document.getElementById('colorsample4').style.display='block';
    
}

    
    // 改變狀態
    function changeStatus({target}){
        // 清空 目前已選div內的文字
        document.querySelector('#numberBox').innerHTML = "目前已選:";
        
        // 將字串切割成陣列
        let seatArr = seat.split("",seat.length);
        for(let i =0 ; i < selectedSeat.length ; i++){
            let index = 4 + Number(selectedSeat[i].id)*5

            if(Number(target.value) ===0){
                seatArr[index]=0;
                selectedSeat[i].setAttribute('class',"btn btn-secondary");
            }
            if(Number(target.value) ===1){
                seatArr[index]=1;
                selectedSeat[i].setAttribute('class',"btn btn-success");
            }
            if(Number(target.value) ===3){
                seatArr[index]=3;
                selectedSeat[i].setAttribute('class',"btn btn-warning");
            }
            if(Number(target.value) ===4){
                seatArr[index]=4;
                selectedSeat[i].setAttribute('class',"btn btn-danger");
            }

        }
        seat="";
        for (const newStr of seatArr){
            seat += newStr ;
        }
        // 更改結束,清空記錄用的陣列
        selectedSeat.length=0;
        // console.log(seat);

        return seat;

    }

    // 計算座位數
    document.getElementById('countBtn').addEventListener('click',seatCounter);
    function seatCounter(){
        let seatCount =0;
        let seatArr =seat.split("",seat.length);
        // 座位狀態的索引值由4開始跳, 每次+5
        let index = 4;
        
        // row*col 總共有幾個格子 控制迴圈要遍歷幾次
        for(let i =0 ; i < (inputRow*inputCol) ; i++){
            // 若狀態 為1和3 進入計次
            if((seatArr[index]-1===0) || (seatArr[index]-3===0)){
                seatCount++;
            }
            index += 5;
        }
        console.log('座位數:'+seatCount);
       
        return seatCount;
    }




