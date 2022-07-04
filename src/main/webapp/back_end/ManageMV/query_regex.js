/***********************片名英文數字驗證******************************/
const mvEName = document.getElementById('mvEName');
mvEName.addEventListener("blur",()=>{
    let regex = new RegExp("^[a-zA-Z0-9 ]+$");
    
     if (regex.test(mvEName.value)){
        mvEName.setAttribute('class',"form-control is-valid");
    }
    else{
        Swal.fire(
                "只接受輸入英文或數字", //標題 
                "",
                "warning"
                //圖示(可省略) success/info/warning/error/question
                //圖示範例：https://sweetalert2.github.io/#icons
            );
        mvEName.value="";
    }
    })