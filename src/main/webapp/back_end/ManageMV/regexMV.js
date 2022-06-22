/***********************片名不可空驗證******************************/
const mvName = document.getElementById('mvName');
mvName.addEventListener("blur",()=>{
        if(mvName.value.length===0){
            mvName.setAttribute('class',"form-control is-invalid")
            alert('此欄位不可為空!')
        }else
        mvName.setAttribute('class',"form-control is-valid")
    })
/***********************片名英文數字驗證******************************/
const mvEName = document.getElementById('mvEName');
mvEName.addEventListener("blur",()=>{
    let regex = new RegExp("^[a-zA-Z0-9 ]+$");
    
    if(mvEName.value.length===0){
            mvEName.setAttribute('class',"form-control is-invalid")
            alert('此欄位不可為空!')
        }else if (regex.test(mvEName.value)){
        mvEName.setAttribute('class',"form-control is-valid");
    }
    else{
        alert("請輸入英文和數字");
        mvEName.value="";
        mvEName.setAttribute('class',"form-control is-invalid");
    }
    })
/*******************上映日驗證:上映日只能大於等於當天******************************/
const stDate = document.getElementById('stDate');
stDate.addEventListener('change',()=>{
	let nowDate= new Date().toISOString().split('T')[0];
	if(stDate.value >= nowDate){
		stDate.setAttribute('class',"form-control is-valid");
	}else{
		stDate.setAttribute('class',"form-control is-invalid");
		alert('注意!上映日不可小於今日');
		stDate.value="";
	}
})
/*******************下檔日驗證:下檔日只能大於等於上映日******************************/    
const edDate = document.getElementById('edDate');
edDate.addEventListener('change',()=>{
	if(edDate.value >= stDate.value){
		edDate.setAttribute('class',"form-control is-valid");
	}else{
		edDate.setAttribute('class',"form-control is-invalid");
		alert('注意!下檔日不可小於上映日');
		edDate.value="";
	}
})
/***********************導演不可空驗證******************************/
const mvDrt = document.getElementById('mvDrt');
mvDrt.addEventListener("blur",()=>{
        if(mvDrt.value.length===0){
            mvDrt.setAttribute('class',"form-control is-invalid")
        }else
        mvDrt.setAttribute('class',"form-control is-valid")
    })
/***********************演員不可空驗證******************************/
const mvCast = document.getElementById('mvCast');
mvCast.addEventListener("blur",()=>{
        if(mvCast.value.length===0){
            mvCast.setAttribute('class',"form-control is-invalid")
        }else
        mvCast.setAttribute('class',"form-control is-valid")
    })
/***********************片長僅能輸入正整數驗證******************************/
const mvLong = document.getElementById('mvLong');
mvLong.addEventListener('blur',()=>{
	if(!checkNum(mvLong.value)){
        alert('請輸入正整數');
        mvLong.value="";
        mvLong.setAttribute('class',"form-control is-invalid");
    }else
    mvLong.setAttribute('class',"form-control is-valid");

})
function checkNum(num){
    let regex = new RegExp( "^[0-9]*[1-9][0-9]*$");
    return regex.test(num);
}

/***********************網址驗證******************************* */
/* 
const mvTler = document.getElementById('mvTler');
mvTler.addEventListener('blur',()=>{
	if(isValidUrl(mvTler.value)){
		console.log('yes')
	}else{
		console.log('no')
		
	}
})
function isValidUrl(string) {
  const pattern = /^https?:\/\/(?:www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)$/gm;
  return pattern.test(string);
}
*/
/***********************上傳圖片預覽******************************/
document.getElementById('mvPc').addEventListener('change',uploadListner);
function uploadListner({target}){
            // 取得target的files物件
            const tFile = target.files[0];
            const img =document.querySelector("#pvImg");
            img.src = URL.createObjectURL(tFile);
            
        }

    