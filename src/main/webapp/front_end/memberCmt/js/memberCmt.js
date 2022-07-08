$(document).ready(function(){
    //全選
    $("#checkAll").on("click", function(){
        if(this.checked){
            $(":checkbox").each(function() {
                this.checked = true;                        
            });
        } else {
            $(":checkbox").each(function() {
                this.checked = false;                       
            });
        }     
    });

    //將選中CM_ID加入陣列
    let cmtArr = [];
    $(".checkOne").on("click", function(){
        console.log($(this).val())

    });


});