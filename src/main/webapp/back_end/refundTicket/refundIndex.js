const searchBtn = document.getElementById('searchBtn');
searchBtn.addEventListener('click',()=>{
	
	
	
	// 獲取USER想要查詢的電影票訂單編號
	let tkOrdID = document.getElementById('searchInput').value;
	const tbody = document.getElementsByTagName('tbody')[0];
	
	//
	let child = tbody.lastElementChild;  
        while (child) { 
            tbody.removeChild(child); 
            child = tbody.lastElementChild; 
        } 
	
	$.ajax({
			url: '/CGA102G1//RefundTicketServlet.do',
			type: 'post',                
			dataType:'json',
			data: {
				"action": "getDtByOrd",
				"tkOrdID": tkOrdID,
			},      
			error: function(xhr) { },    
			success: function(response) {
				for(const dt of response){
				tbody.insertAdjacentHTML('beforeend',`
	            <tr>
	                <td>${dt.tkOrdID}</td>
	                <td>${dt.tkDtID}</td>
	                <td>${dt.seat}</td>
	                <td>${dt.sellPrice}</td>
	                <td>${dt.state}</td>
	                <td><button class="btn btn-secondary">退票</button></td>
	            </tr>`)				
				}
				
			}
		});
})