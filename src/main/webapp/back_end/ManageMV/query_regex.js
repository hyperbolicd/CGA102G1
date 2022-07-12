/***********************片名英文數字驗證******************************/
const mvEName = document.getElementById('mvEName');
mvEName.addEventListener("blur",()=>{
    let regex = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5] $");
    
     if (regex.test(mvEName.value)){
    }
    else{
        Swal.fire(
                "請勿輸入中文", //標題 
                "",
                "warning"
                //圖示(可省略) success/info/warning/error/question
                //圖示範例：https://sweetalert2.github.io/#icons
            );
        mvEName.value="";
    }
    })