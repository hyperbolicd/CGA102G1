var DateDiff = function (sDate1, sDate2) { // sDate1 和 sDate2 是 2016-06-18 格式
    var oDate1 = new Date(sDate1);
    var oDate2 = new Date(sDate2);
    var iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); // 把相差的毫秒數轉換為天數
    return iDays;
  };
  
  var GetDateDiff1 = DateDiff("2019/4/1","2019/4/2"); // 轉換為天數 : 1
  console.log(GetDateDiff1);
  
  var GetDateDiff2 = DateDiff("2016/5/28","2016/6/2"); // 轉換為天數 : 5 
  console.log(GetDateDiff2);



  // Add Days
Date.prototype.addDays = function (days) {
  const date = new Date(this.valueOf());
  date.setDate(date.getDate() + days);
  return date;
};

const date = new Date('2020-12-02');
let newDay = date.addDays(1).toLocaleDateString('sv');
console.log(newDay);

for(let i =0; i<=GetDateDiff; i++){
    for(let j = 0; j <= 9; j++){
      if($(`#time${j}`) !== ''){
        let date = new Date(startDate);
        console.log(date.addDays(i).toLocaleDateString('sv') + " " +  $(`#time${j}`).val() + ":00")
      }
    }
}


let arr = ['a', 'b', 'c']
console.log(arr.includes('b'))
arr.delete('b')
console.log(arr)

undefined