$(document).ready(function(){
    let seat='010120102201030010410105101061010700108101091011010111001121011310201102021020300204102051020610207002081020910210102110021210213103011030210303003041030510306103070030810309103101031100312103131040110402104030040410405104061040700408104091041010411004121041310501105021050300504105051050610507005081050910510105110051210513106013060230603006043060530606306070060830609306103061100612306133070130702307030070430705307063070700708307093071030711007123071330801108021080300804108051080610807008081080910810108110081210813109011090210903009041090510906109070090810909109101091100912109131100111002110030100411005110061100701008110091101011011010121101311101111021110301104111051110611107011081110911110111110111211113112011120211203012041120511206112070120811209112101121101212112131130111302113030130411305113061130701308113091131011311013121131311401114021140301404114051140611407014081140911410114110141211413115011150211503015041150511506115070150811509115101151101512115131';
    // 調用DB內的長跟寬
    let inputRow =15;
    let inputCol =13;
    // 獲取預覽區塊
    let prBox = document.getElementById("prBox");
    // 配置索引值
    let seq =0;
    // 第一排第一個位置的狀態索引值必為4
    let seatIndex = 4;
    // 原始按鈕生成
    for(let row= 1 ; row <= inputRow ; row++){
        for(let col= 1 ; col <= inputCol ; col++){
            
            const btn = document.createElement('button');

            if(Number(seat[seatIndex]) ===0)
            btn.setAttribute('class',"btn btn-secondary");
            if(Number(seat[seatIndex]) ===1)
            btn.setAttribute('class',"btn btn-success");
            if(Number(seat[seatIndex]) ===2)
            btn.setAttribute('class',"btn btn-primary");
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

            // 禁止已出售的位置被綁定監聽
            if(Number(seat[seatIndex]) !==2)
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
    // 創建一陣列蒐集選中的座位物件
    let selectedSeat = [];
    
    function selectedBtn(){
        // 獲取座位的資訊
        let text =this.innerText;
        // 加進 目前已選
        document.getElementById('numberBox').innerText += '\n'+text  ;
        // 利用bootstrap樣式改變 達到選取效果
        this.setAttribute('class','btn btn-outline-danger');
        selectedSeat.push(this);
    }

    document.getElementById('colorsample1').addEventListener('click',changeStatus)
    document.getElementById('colorsample2').addEventListener('click',changeStatus)
    document.getElementById('colorsample3').addEventListener('click',changeStatus)
    document.getElementById('colorsample4').addEventListener('click',changeStatus)
    
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

    // 假資料測試區------需要跟DB互動獲取兩個select內的option!-------------------------------------------------
    document.getElementById('date').addEventListener('change',({target})=>{
      const show = document.getElementById('show');
      show.innerHTML="";
      const showList = mappingShow[target.value];
      for (let showOption of showList) {
       const option = document.createElement('option');
       option.innerText = showOption;
        show.append(option);
      }

    });
    const mappingShow = {
        0:['15:00','17:00','1900','2000'],
        1:['11:00','13:00','1500','1900'],
        2:['12:00','16:00','2200','2359'],
        3:['13:00','15:00','2300','2369']
    }
    // -----------------------------------------------------------------------------------------------------
})


